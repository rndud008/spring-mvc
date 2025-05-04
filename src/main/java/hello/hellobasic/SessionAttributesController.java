package hello.hellobasic;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class SessionAttributesController {

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("user", new User("springmvc","a@a.com"));
        return "redirect:/getUser";
    }

  /*  @ModelAttribute
    public User addUser() {
        return new User("springmvc","a@a.com");
    }*/

    @GetMapping("/getUser")
    public String getUser(@ModelAttribute("user") User user) {
        return "redirect:/getUser2";
    }

    @GetMapping("/getUser2")
    public String getUser2(Model model, User user) {
        return "userDetails";
    }

    @GetMapping("/clearSession")
    @ResponseBody
    public String clearSession(SessionStatus sessionStatus) {
        sessionStatus.setComplete();  // 'user' 속성만 세션에서 제거
        return "Session has been cleared";
    }

}