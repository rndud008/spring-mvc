package hello.hellobasic.controller;

import hello.hellobasic.model.Member;
import hello.hellobasic.model.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;


public class MemberListContorller implements Controller {

    private final MemberRepository memberRepository =new MemberRepository();
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);

        return "/WEB-INF/jsp/list.jsp";
    }
}
