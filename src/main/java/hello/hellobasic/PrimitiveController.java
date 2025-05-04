package hello.hellobasic;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimitiveController {

    @GetMapping("/primitive")
    public String primitive(@RequestParam int number) {  // 기본형 매개변수
        return "숫자: " + number;
    }

    @GetMapping("/primitiveDefault")
    public String primitiveWithDefault(@RequestParam(name = "number", defaultValue = "0") int number) {  // 기본형 매개변수와 빈값 처리
        return "숫자: " + number;
    }

}
