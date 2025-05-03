package hello.hellobasic.pointcut.exam;

import hello.hellobasic.aop.exam.ExamService;
import hello.hellobasic.aop.exam.aop.TraceAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@Import(TraceAspect.class)
@SpringBootTest
public class ExamTest {

    @Autowired
    ExamService service;

    @Test
    void test(){
        for (int i = 0; i < 5; i++) {
            log.info("client request i={}",i);
            service.request("data"+i);
        }
    }
}
