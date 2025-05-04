package hello.hellobasic.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "setHeaderServlet", urlPatterns = "/setHeader")
public class SetHeaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Cache-Control 헤더를 no-cache로 설정
        response.setHeader("X-Custom-Header", "X-Custom-Value1");
        response.setHeader("X-Custom-Header", "X-Custom-Value2");

        // 응답 바디
        response.setContentType("text/plain; charset=UTF-8");
        response.getWriter().println("X-Custom-Header: X-Custom-Value 헤더가 설정되었습니다.");
    }
}