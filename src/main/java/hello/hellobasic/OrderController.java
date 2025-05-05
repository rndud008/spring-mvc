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
    public String submitOrder(@ModelAttribute("order") Order order, BindingResult result) {

        // 필드 오류 검증 (productName)
        if (!StringUtils.hasText(order.getItem())) {
            result.addError(new FieldError("order", "item", order.getItem(), false, null, null,  "상품명은 필수입니다."));
        }
        // 필드 오류 검증 (quantity)
        if (order.getQuantity() <= 10) {
            result.addError(new FieldError("order", "quantity", order.getQuantity(), false, null, null, "수량은 10보다 커야 합니다."));
        }
        if (order.getPrice() < 1000 || order.getPrice() > 1_000_000) {  // 가격 범위 제한: 1 ~ 1,000,000)
            result.addError(new FieldError("order", "price",  order.getPrice(), false, null, null, "가격은 1000 이상 1,000,000 이하여야 합니다."));
        }
        // 객체 수준 오류
        if (!StringUtils.hasText(order.getItem()) && (order. getQuantity() <= 10)) {
            result.addError(new ObjectError("order", "유효하지 않은 상품명입니다."));
        }
        if (result.hasErrors()){
            return "orderForm";  // 오류가 있으면 주문 폼으로 돌아가기
        }
        return "orderForm";
    }

}