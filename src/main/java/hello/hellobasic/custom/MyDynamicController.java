package hello.hellobasic.custom;


import hello.hellobasic.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

@Controller
@RequiredArgsConstructor
public class MyDynamicController {

    private final RequestMappingHandlerMapping requestMappingHandlerMapping;
    private final RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    public ModelAndView getDynamic(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Method method = MyDynamicController.class.getMethod("getDynamic2", new Class[]{User.class, HttpServletRequest.class, HttpServletResponse.class});
        HandlerMethod handlerMethod = new HandlerMethod(this, method);
        ModelAndView mv = requestMappingHandlerAdapter.handle(request, response, handlerMethod);
        return mv;
    }

    public String getDynamic2(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HandlerExecutionChain handler = requestMappingHandlerMapping.getHandler(request);
        return "home";
    }
}