package hello.hellobasic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="registerFormServlet",urlPatterns = "/servlet/registerForm")
public class RegisterFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><meta charset='UTF-8'><title>Register Form</title></head>");
        out.println("<body>");
        out.println("<h1>Register Form (Servlet)</h1>");
        out.println("<form action='/servlet/register' method='post'>");
        out.println("Username: <input type='text' name='username'><br>");
        out.println("Password: <input type='password' name='password'><br>");
        out.println("<button type='submit'>Register</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
