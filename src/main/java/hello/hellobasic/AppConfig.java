package hello.hellobasic;

import hello.hellobasic.dicount.DiscountPolicy;
import hello.hellobasic.dicount.FixDiscountPolicy;
import hello.hellobasic.member.MemberRepository;
import hello.hellobasic.member.MemberService;
import hello.hellobasic.member.MemberServiceImpl;
import hello.hellobasic.member.MemoryMemberRepository;
import hello.hellobasic.order.OrderService;
import hello.hellobasic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

}
