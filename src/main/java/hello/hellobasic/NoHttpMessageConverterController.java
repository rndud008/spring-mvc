package hello.hellobasic;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoHttpMessageConverterController {

    // 1) GET 요청 : 본문이 없으므로 HttpMessageConverter 가 정상적으로 작동하지 않음
    @GetMapping(value = "/noBody", consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String noBody(@RequestBody String request) {
        return request;
    }

    @PostMapping(value = "/jsonOnly", consumes = "application/json")
    public String handleJsonOnly(@RequestBody String data) {
        return "received: " + data;
    }

    @PostMapping("/noResponseBody")
    @ResponseBody
    public String noResponseBody(@RequestBody String data) {
        return "file"; //@ResponseBody 가 없으므로, 이 문자열은 "뷰 이름"이라고 간주되어 뷰 리졸버에게 전달됨
    }
}