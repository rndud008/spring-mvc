package hello.hellobasic.custom;

import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.ControllerAdviceBean;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.*;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomServletInvocableHandlerMethod extends ServletInvocableHandlerMethod {

    private final HandlerMethod handlerMethod;
    private final Map<ControllerAdviceBean, Set<Method>> customAttributeAdviceCache;
    private final List<HandlerMethodArgumentResolver> argumentResolvers;

    public CustomServletInvocableHandlerMethod(HandlerMethod handlerMethod,
                                               Map<ControllerAdviceBean, Set<Method>> customAttributeAdviceCache,
                                               List<HandlerMethodArgumentResolver> argumentResolvers) {
        super(handlerMethod);
        this.handlerMethod = handlerMethod;
        this.customAttributeAdviceCache = customAttributeAdviceCache;
        this.argumentResolvers = argumentResolvers;

    }

    @Override
    public void invokeAndHandle(ServletWebRequest webRequest, ModelAndViewContainer mavContainer, Object... providedArgs) throws Exception {

        Class<?> handlerType = handlerMethod.getBeanType();
        List<InvocableHandlerMethod> attrMethods = new ArrayList<>();
        // Global methods first
        this.customAttributeAdviceCache.forEach((controllerAdviceBean, methodSet) -> {
            if (controllerAdviceBean.isApplicableToBeanType(handlerType)) {
                Object bean = controllerAdviceBean.resolveBean();
                for (Method method : methodSet) {
                    attrMethods.add(createCustomAnnotationMethod(bean, method));
                }
            }
        });

        for(InvocableHandlerMethod invocableHandlerMethod : attrMethods) {
            Object result = invocableHandlerMethod.invokeForRequest(webRequest, mavContainer, providedArgs);
            System.out.println("result = " + result);
        }


        super.invokeAndHandle(webRequest, mavContainer, providedArgs);
    }

    private InvocableHandlerMethod createCustomAnnotationMethod(Object bean, Method method) {
        InvocableHandlerMethod attrMethod = new InvocableHandlerMethod(bean, method);
        if (this.argumentResolvers != null) {
            HandlerMethodArgumentResolverComposite resolvers = new HandlerMethodArgumentResolverComposite();
            resolvers.addResolvers(argumentResolvers);
            attrMethod.setHandlerMethodArgumentResolvers(resolvers);
        }
        return attrMethod;
    }
}