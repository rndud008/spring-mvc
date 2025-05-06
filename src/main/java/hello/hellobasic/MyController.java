package hello.hellobasic;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @GetMapping("/dynamic1")
    public User dynamic1(@RequestParam("username") String name, @ModelAttribute User user, Model model) throws Exception {
        return user;
    }

    @GetMapping("/dynamic2")
    public String dynamic2(HttpServletRequest request, HttpServletResponse response,  Model model) throws Exception {
        return "springmvc";
    }
}