package hello.hellobasic;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataBinderController {

    @PostMapping(value = "/binder")
    @ResponseBody
    public LoginUser binder(@ModelAttribute LoginUser user) {
        return user;
    }

    @GetMapping("/users/{loginUser}")
    @ResponseBody
    public LoginUser getUserByUsername(@ModelAttribute LoginUser user) {
        return user;
    }
}