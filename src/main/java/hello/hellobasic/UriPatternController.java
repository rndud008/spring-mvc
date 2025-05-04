package hello.hellobasic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UriPatternController {

    @GetMapping("/resources/ima?e.png")
    public String getSingleMatch() {
        return "경로에서 한 문자만 일치하는 URL입니다.";
    }


    @GetMapping("/resources/*.png")
    public String getAllMatch() {
        return "경로에서 0개 이상의 문자와 일치하는 URL입니다.";
    }


    @GetMapping("/resources/**")
    public String getMultiAllMatch() {
        return " resources 디렉터리 및 그 하위 모든 경로와 일치합니다.";
    }
}