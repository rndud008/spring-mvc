package hello.hellobasic.advanced;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Component
@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestId = UUID.randomUUID().toString();
        RequestContextUtil.setRequestId(requestId);
        log.info("Request ID {} : - PreHandle 요청 전 {} {} ", requestId, request.getMethod(), request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String requestId = RequestContextUtil.getRequestId();
        log.info("Request ID: {} - PostHandle 요청 후", requestId);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestId = RequestContextUtil.getRequestId();
        if(ex != null) {
            log.error("Request ID: {} - AfterCompletion 예외 발생 {}", requestId, ex.getMessage());
        }else{
            log.info("Request ID: {} - AfterCompletion", requestId);
        }

        RequestContextUtil.clearRequestId();
    }
}
