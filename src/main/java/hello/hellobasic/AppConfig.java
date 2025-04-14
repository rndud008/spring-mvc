package hello.hellobasic;

import hello.hellobasic.dicount.DiscountPolicy;
import hello.hellobasic.dicount.FixDiscountPolicy;
import hello.hellobasic.dicount.RateDiscountPolicy;
import hello.hellobasic.member.MemberRepository;
import hello.hellobasic.member.MemberService;
import hello.hellobasic.member.MemberServiceImpl;
import hello.hellobasic.member.MemoryMemberRepository;
import hello.hellobasic.order.OrderService;
import hello.hellobasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public  MemberRepository memberRepository() {
            return new MemoryMemberRepository();
        }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
