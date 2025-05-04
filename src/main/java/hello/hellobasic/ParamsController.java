package hello.hellobasic;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ParamsController {

    @RequestMapping(value = "/order", params="type=pizza")
    public String param1(HttpServletRequest request) {
        return request.getMethod() + " Order data=" + request.getParameter("type");
    }

    @RequestMapping(value = "/order", params="type=chicken")
    public String param2(HttpServletRequest request) {
        return request.getMethod() + " Order data=" + request.getParameter("type");
    }
}