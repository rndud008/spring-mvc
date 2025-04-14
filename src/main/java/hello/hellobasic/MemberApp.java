package hello.hellobasic;

import hello.hellobasic.member.Grade;
import hello.hellobasic.member.Member;
import hello.hellobasic.member.MemberService;
import hello.hellobasic.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1l, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1l);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
