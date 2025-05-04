package hello.hellobasic;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RequestController {

    @GetMapping("/header1")
    public void header1(@RequestHeader(value="Accept-Encoding", required = false) String encoding,
                        @RequestHeader(value="Keep-Alive", required = false) String keepAlive) {

        System.out.println("encoding = " + encoding + ", keepAlive = " + keepAlive);

    }

    @GetMapping("/header2")
    public void header2(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> System.out.println("key=" + key + ", value=" + value));

    }

    @GetMapping("/header3")
    public void header3(@RequestHeader MultiValueMap<String, String> headers) {
        headers.forEach((key, value) -> System.out.println("key=" + key + ", value=" + value));

    }

    @GetMapping("/header4")
    public void header4(@RequestHeader("Accept") List<String> headers) {
        System.out.println("headers = " + headers);
    }

    @GetMapping("/attribute")
    public void attribute(@RequestAttribute("myAttribute") String myAttribute) {
        System.out.println("myAttribute = " + myAttribute);
    }

    @GetMapping("/setCookie") //개발자 도구 응답 참조
    public String setCookie(HttpServletResponse response) {

        Cookie cookie = new Cookie("userSession", "12345ABC"); // 쿠키 이름과 값 설정
        cookie.setPath("/"); // 모든 경로에서 사용 가능하도록 설정
        cookie.setMaxAge(60 * 60); // 1시간 동안 유효
        response.addCookie(cookie); // 응답에 쿠키 추가

        return "쿠키가 설정되었습니다!";
    }

    @GetMapping("/cookie")
    public String cookie(@CookieValue(value = "userSession", defaultValue = "defaultSession") String session) {
        return "Session ID: " + session;
    }

}
