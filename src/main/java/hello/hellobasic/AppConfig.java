package hello.hellobasic;

import hello.hellobasic.dicount.FixDiscountPolicy;
import hello.hellobasic.member.MemberService;
import hello.hellobasic.member.MemberServiceImpl;
import hello.hellobasic.member.MemoryMemberRepository;
import hello.hellobasic.order.OrderService;
import hello.hellobasic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
