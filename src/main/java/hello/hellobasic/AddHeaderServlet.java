package hello.hellobasic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "addHeaderServlet", urlPatterns = "/addHeader")
public class AddHeaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 같은 이름의 헤더를 2번 추가
        response.addHeader("X-Custom-Header", "Value1");
        response.addHeader("X-Custom-Header", "Value2");

        response.setContentType("text/plain; charset=UTF-8");
        response.getWriter().println("X-Custom-Header가 2개 설정되었습니다. (Value1, Value2)");
    }
}