package hello.hellobasic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArgumentResolverController {

    @GetMapping("/users")
    public String users(@CurrentUser LoginUser loginUser, Model model){
        if (loginUser == null){
            return "noUser";
        }

        model.addAttribute("user", loginUser);

        return "userInfo";
    }
}
