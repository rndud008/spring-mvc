package hello.hellobasic.config.v4_postprocessor.postprocessor;

import hello.hellobasic.config.AppV1Config;
import hello.hellobasic.config.AppV2Config;
import hello.hellobasic.config.v3_proxyfactory.advice.LogTraceAdvice;
import hello.hellobasic.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class BeanPostProcessorConfig {
    @Bean
    public  PackageLogTracePostProcessor logTracePostProcessor(LogTrace logTrace){
        return new PackageLogTracePostProcessor("hello.hellobasic.app", getAdviosr(logTrace));
    }


    private Advisor getAdviosr(LogTrace logTrace) {
        // pointCut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*","order*","save*");

        // advise
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);

        return new DefaultPointcutAdvisor(advice);
    }
}
