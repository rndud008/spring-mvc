package hello.hellobasic;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.*;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.lang.reflect.Method;

@Controller
@RequiredArgsConstructor
public class MyController {

    private final MyService myService;

    @GetMapping("/invokeService1")
    public void invokeService1(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Method serviceMethod= myService.getClass().getMethod("processRequest", User.class);
        InvocableHandlerMethod invocableHandlerMethod = new InvocableHandlerMethod(myService, serviceMethod);

        HandlerMethodArgumentResolverComposite resolver = new HandlerMethodArgumentResolverComposite();
        resolver.addResolvers(new MyArgumentResolver());
        invocableHandlerMethod.setHandlerMethodArgumentResolvers(resolver);

        ServletWebRequest servletWebRequest = new ServletWebRequest(request, response);
        ModelAndViewContainer modelAndViewContainer = new ModelAndViewContainer();

        Object result = invocableHandlerMethod.invokeForRequest(servletWebRequest, modelAndViewContainer);
        response.getWriter().write(result.toString());
    }

    @GetMapping("/invokeService2")
    public void invokeService2(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Method serviceMethod= myService.getClass().getMethod("processRequest", User.class);
        ServletInvocableHandlerMethod invocableHandlerMethod = new ServletInvocableHandlerMethod(myService, serviceMethod);

        HandlerMethodArgumentResolverComposite resolver = new HandlerMethodArgumentResolverComposite();
        resolver.addResolvers(new MyArgumentResolver());

        HandlerMethodReturnValueHandlerComposite returnValueHandler = new HandlerMethodReturnValueHandlerComposite();
        returnValueHandler.addHandler(new MyReturnValueHandler());

        invocableHandlerMethod.setHandlerMethodArgumentResolvers(resolver);
        invocableHandlerMethod.setHandlerMethodReturnValueHandlers(returnValueHandler);

        ServletWebRequest servletWebRequest = new ServletWebRequest(request, response);
        ModelAndViewContainer modelAndViewContainer = new ModelAndViewContainer();

        invocableHandlerMethod.invokeAndHandle(servletWebRequest,modelAndViewContainer);
        if(modelAndViewContainer.containsAttribute("result")){
            response.getWriter().write(modelAndViewContainer.getModel().get("result").toString());
        }
    }
}
