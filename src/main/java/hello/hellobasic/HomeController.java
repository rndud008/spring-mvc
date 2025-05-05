package hello.hellobasic;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @PostMapping(value = "/users2")
    public String users2(@ModelAttribute User user) {
        return "userForm";
    }
}