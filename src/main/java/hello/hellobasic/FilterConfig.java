package hello.hellobasic;

import jakarta.servlet.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import java.io.IOException;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<MyAttributeFilter> customFilter(){
        FilterRegistrationBean<MyAttributeFilter> bean = new FilterRegistrationBean<MyAttributeFilter>();
        bean.setFilter(new MyAttributeFilter());
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }


    class MyAttributeFilter implements Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            request.setAttribute("myAttribute", "myValue");
            chain.doFilter(request, response);
        }
    }

}