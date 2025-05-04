package hello.hellobasic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "setContentTypeServlet", urlPatterns = "/setContentType")
public class SetContentTypeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // JSON 형태로 응답
        response.setContentType("application/json; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("{");
        out.println("  \"result\": \"ok\",");
        out.println("  \"message\": \"JSON 응답 예시\"");
        out.println("}");
    }
}