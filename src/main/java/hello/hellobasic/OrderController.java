package hello.hellobasic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    @GetMapping("/order")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    /*@PostMapping("/order")
    public String submitOrder(@ModelAttribute("order") Order order, BindingResult bindingResult) {

        if (!StringUtils.hasText(order.getItem())) {
            bindingResult.rejectValue("item", "required", null, "상품명은 필수입니다1");
        }
        if (order.getPrice() < 1000 || order.getPrice() > 1_000_000) {  // 가격 범위 제한: 1 ~ 1,000,000)
            bindingResult.rejectValue("price", "range", new Object[]{100, 10000}, "가격은 100 이상 10000 이하여만 합니다1.");
        }
        // 객체 수준 오류
        if (!StringUtils.hasText(order.getItem()) && (order.getPrice() < 1000)) {
            bindingResult.reject("required", "유효하지 않은 상품명입니다.");
        }

        if (bindingResult.hasErrors()) {
            return "orderForm";
        }
        return "orderResult";
    }*/

    @PostMapping("/order")
    public String submitOrder(@ModelAttribute("order") Order order, BindingResult bindingResult) {


        if (!StringUtils.hasText(order.getItem())) {
            bindingResult.rejectValue("item", "required");
        }
        if (order.getItem().length() > 30) {
            bindingResult.rejectValue("item", "max");
        }

        if (order.getPrice() < 1000) {
            bindingResult.rejectValue("price", "min", new Object[]{1000}, "주문가격은 1000 원 이상이어야 합니다.");
        } else if (order.getPrice() > 1000000) {
            bindingResult.rejectValue("price", "max", new Object[]{1000000}, "주문가격은 1000000 원 이하여야 합니다.");
        }


        if (bindingResult.hasErrors()) {
            return "orderForm";
        }
        return "orderResult";
    }

}