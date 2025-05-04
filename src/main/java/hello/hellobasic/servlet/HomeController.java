package hello.hellobasic.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

@RestController
public class HomeController {

//    @GetMapping("/home")
    public String home(HttpServletRequest request, HttpServletResponse response){

        return "home";
    }

    @GetMapping("/info")
    public void info(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletWebRequest servletWebRequest = new ServletWebRequest(request, response);
        String header = servletWebRequest.getHeader("User-Agent");
        System.out.println("header = " + header);


        String name = servletWebRequest.getParameter("name");
        System.out.println("name = " + name);

        HttpServletRequest nativeRequest = servletWebRequest.getNativeRequest(HttpServletRequest.class);
        String requestURI = nativeRequest.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        HttpServletResponse nativeResponse = servletWebRequest.getNativeResponse(HttpServletResponse.class);
        nativeResponse.setStatus(HttpServletResponse.SC_OK);
        nativeResponse.getWriter().write("successful");

//      위와 동일함.
//       servletWebRequest.getResponse().setStatus(HttpServletResponse.SC_OK);
//       servletWebRequest.getResponse().getWriter().write("successful");

    }
}
