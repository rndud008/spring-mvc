package hello.hellobasic.scan;

import hello.hellobasic.AutoAppConfig;
import hello.hellobasic.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService m = ac.getBean(MemberService.class);
        Assertions.assertThat(m).isInstanceOf(MemberService.class);
    }
}
