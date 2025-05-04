package hello.hellobasic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HeadersController {

    @RequestMapping(value = "/text", headers = "content-type=text/*")
    public String handleText() {
        return "text/*";
    }

    @RequestMapping(value = "/json", headers = "content-type=application/json")
    public String handleJson() {
        return "application/json";
    }

    @RequestMapping(value = "/notJson", headers = "content-type!=application/json")
    public String notJson() {
        return "notJson";
    }

    @RequestMapping(value = "/myHeader", headers = "My-Header=myValue")
    public String myHeader() {
        return "My-Header";
    }
}