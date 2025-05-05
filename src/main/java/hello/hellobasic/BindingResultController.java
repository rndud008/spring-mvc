package hello.hellobasic;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BindingResultController {

    @PostMapping("/validation")
    public User validation(@ModelAttribute User user, BindingResult bindingResult, Model model) {
        return user;
    }

    @PostMapping("/nonValidation")
    public User nonValidation(@ModelAttribute User user) {
        return user;
    }

    @PostMapping("/validation2")
    public User validation2(@ModelAttribute User user, BindingResult bindingResult) {
        return user;
    }

}
