package hello.hellobasic;

import hello.hellobasic.config.AppV1Config;
import hello.hellobasic.config.AppV2Config;
import hello.hellobasic.config.v1_proxy.InterfaceProxyConfig;
import hello.hellobasic.trace.logtrace.LogTrace;
import hello.hellobasic.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import({AppV1Config.class, AppV2Config.class})
@Import(InterfaceProxyConfig.class)
@SpringBootApplication(scanBasePackages = "hello.hellobasic.app")
public class HelloBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloBasicApplication.class, args);
    }

    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }
}
