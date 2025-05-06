package hello.hellobasic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@Slf4j
public class ControllerAdviceController {

    @GetMapping("/model")
    public String model(Model model) {  // model 에는 user=new User("springmvc", "a@a.com") 가 담겨져 있다
        model.addAttribute("message", "Welcome Spring MVC");
        return "home";
    }

    @GetMapping("/date")
    public String date(@RequestParam Date date, Model model) {
        model.addAttribute("date", date);
        return "home";
    }

    @GetMapping("/exception1")
    public String exception() {
        throw new IllegalArgumentException("IllegalArgumentException error");
    }
}