package hello.hellobasic.config.v1_proxy;

import hello.hellobasic.app.v2.OrderControllerV2;
import hello.hellobasic.app.v2.OrderRepositoryV2;
import hello.hellobasic.app.v2.OrderServiceV2;
import hello.hellobasic.config.v1_proxy.conncrete_proxy.OrderControllerConcreteProxy;
import hello.hellobasic.config.v1_proxy.conncrete_proxy.OrderRepositoryConcreteProxy;
import hello.hellobasic.config.v1_proxy.conncrete_proxy.OrderServiceConcreteProxy;
import hello.hellobasic.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace){
        OrderControllerV2 orderControllerV2 = new OrderControllerV2(orderServiceV2(logTrace));
        return new OrderControllerConcreteProxy(orderControllerV2, logTrace);
    }

    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace){
        OrderServiceV2 orderServiceV2 = new OrderServiceV2(orderRepositoryV2(logTrace));
        return new OrderServiceConcreteProxy(orderServiceV2, logTrace);
    }
    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace){
        OrderRepositoryV2 orderRepositoryV2 = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(orderRepositoryV2,logTrace);
    }
}
