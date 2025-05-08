package hello.hellobasic;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        String acceptHeader = request.getHeader("Accept");
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        try{

            if(acceptHeader.contains(MediaType.TEXT_HTML_VALUE)){
                return new ModelAndView("error", Map.of("message", ex.getMessage()));

            }else if(acceptHeader.contains(MediaType.APPLICATION_JSON_VALUE)){
                Map<String, String> message = Map.of("message", ex.getMessage());
                response.getWriter().write(message.toString());
                return new ModelAndView();

            }else if(ex instanceof RuntimeException){
                response.sendError(HttpServletResponse.SC_FORBIDDEN, ex.getMessage());
                return new ModelAndView();
            }else{
                return null;
            }

        }catch(Exception e){
            return null;
        }
    }
}