package hello.hellobasic.web.validation;

import hello.hellobasic.web.validation.form.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {

    @PostMapping("/add")
    public Object addItme(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult){
        log.info("API 컨트롤러 호출");

        // JSON으로 ItemSaveForm 의 객체를 변환시 타입이 맞지않으면 컨트롤러가 실행되지 않는 문제 발생

        if (bindingResult.hasErrors()){
            log.info("검즌 오류 발행 errors={}",bindingResult);
            return bindingResult.getAllErrors();
        }
        log.info("성공 로직 실행");
        return form;
    }
}
