package hello.hellobasic.controller;

import hello.hellobasic.model.Member;
import hello.hellobasic.model.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registerControllerServlet", urlPatterns = "/model2/register")
public class RegisterControllerServlet extends HttpServlet {

    private final MemberRepository memberRepository = new MemberRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Member newMember = new Member(username, password);
        memberRepository.save(newMember);

        // 리스트 페이지로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/model2/list");

    }
}
