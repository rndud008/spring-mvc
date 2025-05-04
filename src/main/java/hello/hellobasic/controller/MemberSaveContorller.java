package hello.hellobasic.controller;

import hello.hellobasic.model.Member;
import hello.hellobasic.model.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

public class MemberSaveContorller implements Controller {

    private final MemberRepository memberRepository =new MemberRepository();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Member newMember = new Member(username, password);
        memberRepository.save(newMember);

        request.setAttribute("member", newMember);

        return "/WEB-INF/jsp/result.jsp";
    }
}
