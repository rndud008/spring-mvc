package hello.hellobasic;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.HttpRequestHandler;

import java.io.IOException;

public class MyHttpRequestHandler implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.getWriter().write("SimpleUrlHandlerMapping!");
    }
}
