package hello.hellobasic;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplatesController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Spring MVC");
        return "home"; // templates 폴더의 home.html 파일을 렌더링
    }

    @GetMapping("/users")
    public String users(Model model) {
        User user = new User(1L, "springmvc", 10);
        model.addAttribute("user", user);
        return "users/user"; // templates 폴더의 users 폴더 아래 user.html 파일을 렌더링
    }
}