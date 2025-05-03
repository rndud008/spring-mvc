package hello.hellobasic.member;

import hello.hellobasic.member.annotation.ClassAop;
import hello.hellobasic.member.annotation.MethodAop;
import org.springframework.stereotype.Component;

@ClassAop
@Component
public class MemberServiceImpl implements MemberService {
    @Override
    @MethodAop("test value")
    public String hello(String param) {
        return "ok";
    }

    public String internal(String parma){
        return "ok";
    }


}
