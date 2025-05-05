package hello.hellobasic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class MessageSourceController {

    @GetMapping("/item")
    public String item(Model model) {
        model.addAttribute("item", new Item());
        return "itemForm";
    }

    @PostMapping("/item")
    public String item(@Validated @ModelAttribute Item item, BindingResult result) {

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> log.info("errors={}", error.getDefaultMessage()));
            return "itemForm";
        }
        return "itemForm";
    }
}