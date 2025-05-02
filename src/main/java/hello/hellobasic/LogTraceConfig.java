package hello.hellobasic;

import hello.hellobasic.trace.logtrace.FiledLogTrace;
import hello.hellobasic.trace.logtrace.LogTrace;
import hello.hellobasic.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }
}
