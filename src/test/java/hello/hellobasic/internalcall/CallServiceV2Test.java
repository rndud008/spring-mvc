package hello.hellobasic.internalcall;

import hello.hellobasic.internalcall.aop.CallLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@Import(CallLogAspect.class)
//  스프링 부트 2.6 이상이라면 이 설정을 꼭 추가 추가해야 한다.
@SpringBootTest(properties = "spring.main.allow-circular-references=true")
class CallServiceV2Test {
    @Autowired
    CallServiceV2 CallServiceV2;

    @Test
    void external(){
        CallServiceV2.external();
    }

}