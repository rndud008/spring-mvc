package hello.hellobasic;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class MyAuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        LoginUser loginUser = new LoginUser(1l, "springmvc", "a@a.com");
        req.setAttribute("loginUser", loginUser);

        filterChain.doFilter(request,response);
    }
}
