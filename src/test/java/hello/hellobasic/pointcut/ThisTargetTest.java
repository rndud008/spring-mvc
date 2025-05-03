package hello.hellobasic.pointcut;

import hello.hellobasic.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

// spring.aop.proxy-target-class=true // CGLIB 사용
@Slf4j
@Import(ThisTargetTest.ThisTargetAspect.class)
@SpringBootTest(properties = "spring.aop.proxy-target-class=false") // JDK  동적 프록시
public class ThisTargetTest {

    @Autowired
    MemberService memberService;

    @Test
    void  success(){
        log.info("memberService Proxy={}",memberService.getClass());
        memberService.hello("helloA");
    }

    @Aspect
    static class ThisTargetAspect{
        // 부모 타입 허용
        @Around("this(hello.hellobasic.member.MemberService)")
        public Object doThisInterface(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[this-interface]{}",joinPoint.getSignature());
            return joinPoint.proceed();
        }

        @Around("target(hello.hellobasic.member.MemberService)")
        public Object doTargetInterface(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[target-interface]{}",joinPoint.getSignature());
            return joinPoint.proceed();
        }

        @Around("this(hello.hellobasic.member.MemberServiceImpl)")
        public Object doThis(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[this-impl]{}",joinPoint.getSignature());
            return joinPoint.proceed();
        }

        @Around("target(hello.hellobasic.member.MemberServiceImpl)")
        public Object diTarget(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[target-impl]{}",joinPoint.getSignature());
            return joinPoint.proceed();
        }
//        [target-impl]String hello.hellobasic.member.MemberService.hello(String)
//        [target-interface]String hello.hellobasic.member.MemberService.hello(String)
//        [this-interface]String hello.hellobasic.member.MemberService.hello(String)
    }
}
