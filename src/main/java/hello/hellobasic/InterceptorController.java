package hello.hellobasic;

import hello.hellobasic.advanced.AdminOnly;
import hello.hellobasic.advanced.RequestContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class InterceptorController {

    @GetMapping("/api/users")
    @ResponseBody
    public String users(Model model) {
        return "Hello CustomInterceptor1";
    }

    @GetMapping("/api/public/users")
    @ResponseBody
    public String publicUsers(Model model) {
        return "Hello CustomInterceptor1";
    }

    @GetMapping("/login")
    @ResponseBody
    public String login(Model model) {
        return "Hello CustomInterceptor2";
    }

    @GetMapping("/log")
    @ResponseBody
    public String log(Model model) {
        String requestId = RequestContextUtil.getRequestId();
        log.info("Request ID: {} Controller ", requestId);
        return "Hello LoggingInterceptor";
    }

    @GetMapping("/profile")
    public String profile(@RequestParam String username,  Model model) {
        model.addAttribute("username", username);
        return "userProfile";
    }

    @AdminOnly
    @ResponseBody
    @GetMapping("/admin")
    public String admin() {
        return "Welcome Admin";
    }

    @ResponseBody
    @GetMapping("/order")
    public String order() {
        return "Ordered Success";
    }
}
