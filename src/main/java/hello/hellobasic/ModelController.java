package hello.hellobasic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ModelController {

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "springmvc");
        model.addAttribute("message", "Welcome to Spring MVC");
        model.addAttribute("user", new User("springmvc", "a@a.com"));

        return "greeting";
    }

    @GetMapping("/greeting2")
    public String greeting2(Model model) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "springmvc2");
        data.put("message", "Welcome2");
        data.put("user", new User("springmvc2", "a@a.com"));
        model.addAllAttributes(data);
        return "greeting";
    }

    @PostMapping("/model")
    @ResponseBody
    public Object model(@ModelAttribute("user") User user, BindingAwareModelMap model) {
        User user1 = (User)model.get("user");
        Object bindingResult = model.get("org.springframework.validation.BindingResult.user");
        return user1 +" : " + bindingResult.toString();
    }

}