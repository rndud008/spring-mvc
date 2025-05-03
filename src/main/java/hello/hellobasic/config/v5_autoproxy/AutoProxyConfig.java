package hello.hellobasic.config.v5_autoproxy;


import hello.hellobasic.config.AppV1Config;
import hello.hellobasic.config.AppV2Config;
import hello.hellobasic.config.v3_proxyfactory.advice.LogTraceAdvice;
import hello.hellobasic.trace.logtrace.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AutoProxyConfig {

//    @Bean
    public Advisor advisor1(LogTrace logTrace) {
        // pointCut
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*","order*","save*");

        // advise
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);

        return new DefaultPointcutAdvisor(pointcut,advice);
    }

//    @Bean
    public Advisor advisor2(LogTrace logTrace) {
        // pointCut
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
       pointcut.setExpression("execution(* hello.hellobasic.app..*(..))");

        // advise
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);

        return new DefaultPointcutAdvisor(pointcut,advice);
    }

    @Bean
    public Advisor advisor3(LogTrace logTrace) {
        // pointCut
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* hello.hellobasic.app..*(..)) && !execution(* hello.hellobasic.app..noLog(..))");

        // advise
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);

        return new DefaultPointcutAdvisor(pointcut,advice);
    }



}
