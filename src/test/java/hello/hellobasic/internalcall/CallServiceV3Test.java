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
@SpringBootTest
class CallServiceV3Test {
    @Autowired
    CallServiceV3 CallServiceV3;

    @Test
    void external(){
        CallServiceV3.external();
    }
}