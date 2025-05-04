package hello.hellobasic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "setStatusServlet", urlPatterns = "/setStatus")
public class SetStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 200 OK 로 설정
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        // 브라우저에 메시지 전송
        response.setContentType("text/plain; charset=UTF-8");
        response.getWriter().println("HTTP Status를 403 FORBIDDEN  설정했습니다.");
    }
}