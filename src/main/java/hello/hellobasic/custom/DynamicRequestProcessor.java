package hello.hellobasic.custom;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodIntrospector;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class DynamicRequestProcessor {

    private final RequestMappingHandlerMapping handlerMapping;
    private final ApplicationContext applicationContext;

    @PostConstruct
    public void handleDynamicMapping() throws Exception {

        processRequest("myDynamicController");
        processRequest("restDynamicController");
    }

    public void processRequest(Object handler) {

        Class<?> handlerType = (handler instanceof String beanName ?
                applicationContext.getType(beanName) : applicationContext.getClass());

        if (handlerType != null) {
            Class<?> userType = ClassUtils.getUserClass(handlerType);
            Map<Method, RequestMappingInfo> methods = MethodIntrospector.selectMethods(userType,
                    (MethodIntrospector.MetadataLookup<RequestMappingInfo>) method -> {
                        try {
                            return getMappingForMethod(method, userType);
                        } catch (Throwable ex) {
                            throw new IllegalStateException("Invalid mapping on handler class [" +
                                    userType.getName() + "]: " + method, ex);
                        }
                    });
            methods.forEach((method, mapping) -> {
                Method invocableMethod = AopUtils.selectInvocableMethod(method, userType);
                handlerMapping.registerMapping(mapping, handler, invocableMethod);
            });
        }
    }

    private RequestMappingInfo getMappingForMethod(Method method, Class<?> userType) {

        RequestMethod requestMethod = RequestMethod.GET; // Default
        if (method.getName().startsWith("post")) {
            requestMethod = RequestMethod.POST;
        } else if (method.getName().startsWith("delete")) {
            requestMethod = RequestMethod.DELETE;
        }

        return RequestMappingInfo
                .paths("/" + method.getName())
                .methods(requestMethod)
                .build();
    }
}