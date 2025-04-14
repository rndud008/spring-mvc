package hello.hellobasic;

import hello.hellobasic.member.Grade;
import hello.hellobasic.member.Member;
import hello.hellobasic.member.MemberService;
import hello.hellobasic.member.MemberServiceImpl;
import hello.hellobasic.order.Order;
import hello.hellobasic.order.OrderService;
import hello.hellobasic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1l;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order= orderService.createOrder(memberId,"itemA",10000);
        System.out.println("order = " + order);
    }
}
