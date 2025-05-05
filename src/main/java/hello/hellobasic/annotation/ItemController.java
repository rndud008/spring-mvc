package hello.hellobasic.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

    @GetMapping("/item")
    public String showForm(Model model) {
        model.addAttribute("item", new Item());
        return "itemForm";
    }

    @PostMapping("/item")
    public String handleForm(@ModelAttribute Item item, Model model) {
        model.addAttribute("item", item);
        return "itemResult";
    }
}