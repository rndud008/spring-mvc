package hello.hellobasic.order;

import hello.hellobasic.member.Grade;
import hello.hellobasic.member.Member;
import hello.hellobasic.member.MemberService;
import hello.hellobasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1l;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDisCountPrice()).isEqualTo(1000);
    }
}
