package hello.hellobasic.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/htmlResponse")
public class HtmlResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Content-Type 지정
        response.setContentType("text/html;charset=UTF-8");

        // PrintWriter 획득
        PrintWriter out = response.getWriter();

        // HTML 응답
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8' />");
        out.println("    <title>HTML 응답 예제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>HTML 화면 처리 예제</h1>");
        out.println("    <p>이 영역은 HTML 태그를 통해 표현됩니다.</p>");
        out.println("</body>");
        out.println("</html>");

        // 자원 정리
        out.close();
    }
}