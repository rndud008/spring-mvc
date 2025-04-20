package hello.hellobasic.web.frontcontroller.v1.controller;

import hello.hellobasic.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPAth = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPAth);
        dispatcher.forward(request, response); // 다른 서블릿이나 JSP로 이동할수 잇는 기능. 서버 내부에서 다시 호출이 발생.

    }
}
