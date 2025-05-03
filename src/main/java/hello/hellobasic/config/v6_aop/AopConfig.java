package hello.hellobasic.config.v6_aop;

import hello.hellobasic.config.AppV1Config;
import hello.hellobasic.config.AppV2Config;
import hello.hellobasic.config.v3_proxyfactory.advice.LogTraceAdvice;
import hello.hellobasic.config.v6_aop.aspect.LogTraceAspect;
import hello.hellobasic.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {

    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace){
        return new LogTraceAspect(logTrace);
    }
}
