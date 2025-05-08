package hello.hellobasic;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
@Slf4j
public class ExceptionController {

    @GetMapping("/exception")
    public String exception() {
        throw new IllegalArgumentException("IllegalArgumentException error");  // 스프링의 /error/500 호출
    }

    @GetMapping("/error500")
    public void error500(HttpServletResponse response) throws IOException {
        response.sendError(500); // ErrorPageController /error/500 호출
    }

    @GetMapping("/error404")
    public void error404(HttpServletResponse response) throws IOException {
        response.sendError(404);// ErrorPageController /error/404 호출
    }

    @GetMapping("/error401")
    public void error401(HttpServletResponse response) throws IOException {
        response.sendError(401);// ErrorPageController /error/401 호출
    }
}
