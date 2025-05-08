package hello.hellobasic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HandlerExceptionController {

    @GetMapping("/error-view")
    public void throwViewError() {
        throw new IllegalArgumentException ("HTML View Error Occurred!");
    }

    @GetMapping("/error-json")
    public void throwJsonError() {
        throw new IllegalStateException("JSON Error Occurred!");
    }

    @GetMapping("/error-sendError")
    public void throwSendError() {
        throw new RuntimeException("sendError triggered!");
    }

    @GetMapping("/error-null")
    public void returnNull() throws CustomException {
        throw new CustomException();
    }
}