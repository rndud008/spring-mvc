package hello.hellobasic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

@WebServlet(name ="registerServlet",urlPatterns = "/servlet/register")
public class RegisterServlet extends HttpServlet {

    private static List<Member> memberList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Member member = new Member(username,password);
        memberList.add(member);

        response.sendRedirect("/servlet/list");
    }

    public static List<Member> getMemberList() {
        return memberList;
    }
}
