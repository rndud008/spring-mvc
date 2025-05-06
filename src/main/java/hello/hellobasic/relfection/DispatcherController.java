package hello.hellobasic.relfection;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodIntrospector;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Method;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class DispatcherController {

    private final MethodExtractor methodExtractor;
    private final MyService myService;
    private final DynamicMethodInvoker methodInvoker;

    @GetMapping("/dynamic/invoke")
    public void invokeDynamicMethod(HttpServletRequest req, HttpServletResponse res) throws Exception {

        Set<Method> methods = methodExtractor.getAnnotatedMethods(MyService.class);

        String methodName = req.getParameter("method");
        for(Method method : methods) {
            if (method.getName().equals(methodName)) {
                methodInvoker.invoke(req, res, myService, method);
                return;
            }
        }

        res.setStatus(HttpServletResponse.SC_NOT_FOUND);
        res.getWriter().write("Method not found");
    }

}
