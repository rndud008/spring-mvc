package hello.hellobasic.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV1 {

    private CallServiceV1 callServiceV1;

    @Autowired
    public void setCallServiceV1(CallServiceV1 callServiceV1){
        this.callServiceV1 = callServiceV1;
        log.info("callServiceV1 setter={}", callServiceV1.getClass());
        //  스프링 부트 2.6 이상이라면 이 설정을 꼭 추가 추가해야 한다.
        // (properties = "spring.main.allow-circular-references=true")
    }



    public void external() {
        log.info("call external");
        callServiceV1.internal();// 외부 메서드 호출
    }

    public void internal() {
        log.info("call internal");
    }
}
