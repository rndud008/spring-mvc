package hello.hellobasic.singleton;

import hello.hellobasic.AppConfig;
import hello.hellobasic.member.MemberRepository;
import hello.hellobasic.member.MemberServiceImpl;
import hello.hellobasic.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService",OrderServiceImpl.class);

        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        System.out.println("memberService.getMemberRepository() = " + memberService.getMemberRepository());
        System.out.println("orderService.getMemberRepository() = " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }
}
