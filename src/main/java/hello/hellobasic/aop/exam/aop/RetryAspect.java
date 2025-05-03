package hello.hellobasic.aop.exam.aop;

import hello.hellobasic.aop.exam.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class RetryAspect {

    @Around("@annotation(retry)") // 객체를 직접 넣음
    public Object doRetry(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
        log.info("[retry] {} args={}",joinPoint.getSignature(),retry);

        int maxRetry = retry.value();
        Exception exceptionHolder= null;

        for (int retryCount = 1; retryCount < maxRetry; retryCount++) {
            try {
                ;log.info("[retry] try count={}/{}", retryCount, maxRetry);
               return joinPoint.proceed();
            }catch (Exception e){
                exceptionHolder = e;
            }
        }
        throw exceptionHolder;

    }
}
