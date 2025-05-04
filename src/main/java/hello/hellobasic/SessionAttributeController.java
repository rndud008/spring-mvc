package hello.hellobasic;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class SessionAttributeController {

    @GetMapping("/setSession")
    public String setSession(Model model) {
        User user = new User("springmvc", "a@a.com");
        model.addAttribute("user", user); // "user"를 모델과 세션에 저장
        return "userForm";
    }

    @PostMapping("/getSession")
    public String getSession(@SessionAttribute(name = "user", required = false) User user, Model model) {
//        model.addAttribute("user", null);
        return "userDetails";
    }


    @GetMapping("/clearSession")
    @ResponseBody
    public String clearSession(SessionStatus sessionStatus) {
        sessionStatus.setComplete(); // 세션에서 "user" 데이터 삭제
        return "Session has been cleared.";
    }

}
