package hello.hellobasic;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ErrorPageController {

    // 401 에러 페이지
 /*   @GetMapping("/error/401")
    public String unAuthorized() {
        return "error/401"; // error/401.html로 이동
    }*/
    // 404 에러 페이지
    @GetMapping("/error/404")
    public String handleNotFound() {
        return "error/404"; // error/404.html로 이동
    }
    // 500 에러 페이지
    @GetMapping("/error/500")
    public String handleServerError() {
        return "error/500"; // error/500.html로 이동
    }
    // Exception 에러 페이지
    @GetMapping("/error/exception")
    public String handleExceptionError() {
        return "error/exception"; // error.html로 이동
    }

    @GetMapping("/error/401")
    public String unAuthorized(HttpServletRequest request) {

        String servletName = (String)request.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME);
        String exception = (String)request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        String message = (String)request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        String requestUri = (String)request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        String exceptionType = (String)request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE);
        int attribute = (int)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        System.out.println("servletName = " + servletName);
        System.out.println("exception = " + exception);
        System.out.println("message = " + message);
        System.out.println("requestUri = " + requestUri);
        System.out.println("exceptionType = " + exceptionType);
        System.out.println("attribute = " + attribute);

        return "error/401";
    }
}
