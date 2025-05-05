package hello.hellobasic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewResolverController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
