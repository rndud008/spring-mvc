package hello.hellobasic.custom;

import org.springframework.context.annotation.Primary;
import org.springframework.core.MethodIntrospector;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.method.ControllerAdviceBean;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Primary
public class CustomRequestMappingHandlerAdapter extends RequestMappingHandlerAdapter {

    private final Map<ControllerAdviceBean, Set<Method>> customAttributeAdviceCache = new LinkedHashMap<>();

    public static final ReflectionUtils.MethodFilter CUSTOM_ANNOTATION_METHODS = method ->
            AnnotatedElementUtils.hasAnnotation(method, CustomAnnotation.class);

    @Override
    public void afterPropertiesSet() {

        List<ControllerAdviceBean> adviceBeans = ControllerAdviceBean.findAnnotatedBeans(getApplicationContext());

        for (ControllerAdviceBean adviceBean : adviceBeans) {
            Class<?> beanType = adviceBean.getBeanType();
            if (beanType == null) {
                throw new IllegalStateException("Unresolvable type for ControllerAdviceBean: " + adviceBean);
            }
            Set<Method> attrMethods = MethodIntrospector.selectMethods(beanType, CUSTOM_ANNOTATION_METHODS);
            if (!attrMethods.isEmpty()) {
                this.customAttributeAdviceCache.put(adviceBean, attrMethods);
            }
        }

        super.afterPropertiesSet();
    }

    @Override
    protected ServletInvocableHandlerMethod createInvocableHandlerMethod(HandlerMethod handlerMethod) {
        return new CustomServletInvocableHandlerMethod(handlerMethod, customAttributeAdviceCache, getArgumentResolvers());
    }
}
