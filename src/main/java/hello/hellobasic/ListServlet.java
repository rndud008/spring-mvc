package hello.hellobasic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "listServlet" , urlPatterns = "/servlet/list")
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<Member> members = RegisterServlet.getMemberList();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><meta charset='UTF-8'><title>Member List</title></head>");
        out.println("<body>");
        out.println("<h1>Member List (Servlet)</h1>");
        out.println("<ul>");
        for (Member m : members) {
            out.println("<li>" + m.getUsername() + " / " + m.getPassword() + "</li>");
        }
        out.println("</ul>");
        out.println("<a href='/servlet/registerForm'>Go to Register Form</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
