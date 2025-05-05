package hello.hellobasic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {

    @GetMapping("/currency")
    public String showCurrencyForm(Model model) {
        model.addAttribute("amount", 12345);
        return "currencyForm";
    }

    @PostMapping("/currency")
    public String handleCurrencyForm(@RequestParam("amount") int amount, Model model) {
        model.addAttribute("amount", amount);
        return "currencyResult";
    }
}
