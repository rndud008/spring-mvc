package hello.hellobasic;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MethodController {

    @RequestMapping(value = "/order")
    public String getOrder(HttpServletRequest request) {
        return request.getMethod() + " Order data";
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(HttpServletRequest request) {
        return request.getMethod() + " User data";
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createUser(HttpServletRequest request) {
        return request.getMethod() + " User created";
    }

}