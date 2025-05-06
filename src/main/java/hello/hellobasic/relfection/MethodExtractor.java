package hello.hellobasic.relfection;


import org.springframework.core.MethodIntrospector;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Set;

@Component
public class MethodExtractor {
    public Set<Method> getAnnotatedMethods(Class<?> clazz) {
        return MethodIntrospector.selectMethods(clazz,
                (ReflectionUtils.MethodFilter)  method -> method.isAnnotationPresent(CustomAnnotation.class));
    }
}