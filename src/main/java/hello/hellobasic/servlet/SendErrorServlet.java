package hello.hellobasic.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sendErrorServlet", urlPatterns = "/sendError")
public class SendErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 404 Not Found 에러를 보낸다.
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "잘못된 요청 방식입니다.");
    }
}