package hello.hellobasic;

import hello.hellobasic.member.*;
import hello.hellobasic.order.Order;
import hello.hellobasic.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService =appConfig.orderService();

        Long memberId = 1l;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order= orderService.createOrder(memberId,"itemA",10000);
        System.out.println("order = " + order);
    }
}
