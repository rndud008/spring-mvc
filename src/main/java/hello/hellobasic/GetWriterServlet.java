package hello.hellobasic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getWriterServlet", urlPatterns = "/getWriter")
public class GetWriterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Content-Type 지정 (평문)
        response.setContentType("text/plain; charset=UTF-8");

        // PrintWriter 얻기
        PrintWriter out = response.getWriter();

        out.println("안녕하세요. getWriter() 예제입니다.");
        out.println("이렇게 텍스트 응답을 보낼 수 있습니다.");
    }
}