package hello.hellobasic.order;

import hello.hellobasic.dicount.FixDiscountPolicy;
import hello.hellobasic.member.Grade;
import hello.hellobasic.member.Member;
import hello.hellobasic.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    void createOrder(){

        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1l,"name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1l, "itemA", 10000);
        Assertions.assertThat(order.getDisCountPrice()).isEqualTo(1000);

    }

}