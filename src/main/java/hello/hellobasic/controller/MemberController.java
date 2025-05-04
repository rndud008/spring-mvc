package hello.hellobasic.controller;

import hello.hellobasic.model.Member;
import hello.hellobasic.model.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/front-controller/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/new-form")
    public String showForm(){
        return "form";
    }

    @PostMapping("/save")
    public String saveMember(Member member , Model model){

        memberRepository.save(member);
        model.addAttribute("member", member);
        return "result";
    }

    @GetMapping("/list")
    public String listMember(Model model){

        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "list";
    }
}
