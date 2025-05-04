package hello.hellobasic.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registerFormControllerServlet", urlPatterns = "/model2/registerForm")
public class RegisterFormControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/jsp/registerForm.jsp";
        request.getRequestDispatcher(viewPath).forward(request,response);

    }
}
