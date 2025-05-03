package hello.hellobasic.order.member;

import hello.hellobasic.order.member.annotation.ClassAop;
import hello.hellobasic.order.member.annotation.MethodAop;
import org.springframework.stereotype.Component;

@ClassAop
@Component
public class MemberServiceImpl implements MemberService {
    @Override
    @MethodAop("test value")
    public String hello(String param) {
        return "ok";
    }

    String internal(String parma){
        return "ok";
    }


}
