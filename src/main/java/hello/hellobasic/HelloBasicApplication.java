package hello.hellobasic;

import hello.hellobasic.config.AppV1Config;
import hello.hellobasic.config.AppV2Config;
import hello.hellobasic.config.v1_proxy.ConcreteProxyConfig;
import hello.hellobasic.config.v1_proxy.InterfaceProxyConfig;
import hello.hellobasic.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import hello.hellobasic.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import hello.hellobasic.config.v3_proxyfactory.ProxyFactoryConfigV1;
import hello.hellobasic.config.v3_proxyfactory.ProxyFactoryConfigV2;
import hello.hellobasic.config.v4_postprocessor.postprocessor.BeanPostProcessorConfig;
import hello.hellobasic.trace.logtrace.LogTrace;
import hello.hellobasic.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import({InterfaceProxyConfig.class, ConcreteProxyConfig.class})
//@Import({DynamicProxyBasicConfig.class, ConcreteProxyConfig.class})
//@Import({DynamicProxyFilterConfig.class, ConcreteProxyConfig.class})
//@Import({ProxyFactoryConfigV1.class, ConcreteProxyConfig.class})
//@Import({ProxyFactoryConfigV1.class, ProxyFactoryConfigV2.class})
@Import(BeanPostProcessorConfig.class)
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
