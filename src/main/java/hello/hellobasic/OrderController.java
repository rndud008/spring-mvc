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
    @PostMapping("/order")
    public String submitOrder(@ModelAttribute("order") Order order, BindingResult bindingResult) {

        if (!StringUtils.hasText(order.getItem())) {
            bindingResult.addError(new FieldError("order", "item", order.getItem(),
                    false, new String[]{"required.order.item"}, null,  ""));
        }

        if (order.getPrice() < 1000 || order.getPrice() > 1_000_000) {  // 가격 범위 제한: 1 ~ 1,000,000)
            bindingResult.addError(new FieldError("order", "price",  order.getPrice(),
                    false, new String[]{"range.order.price"}, new Object[]{100, 10000}, ""));
        }

        // 객체 수준 오류
        if (!StringUtils.hasText(order.getItem()) && (order.getPrice() < 1000)) {
            bindingResult.addError(new ObjectError("order", "유효하지 않은 상품명입니다."));
        }

        if (bindingResult.hasErrors()) {
            return "orderForm";
        }
        return "orderResult";
    }
}