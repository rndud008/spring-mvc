package hello.hellobasic.web.session;

import hello.hellobasic.domain.member.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;

class SessionManagerTest {


    SessionManager sessionManager = new SessionManager();

    @Test
    void sessionTest(){

        //세션 생성
        MockHttpServletResponse response = new MockHttpServletResponse();
        Member member = new Member();
        sessionManager.createSession(member,response);

        //요청에 응답 쿠키 저장
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        Object result = sessionManager.getSession(request);
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member);

        // 세션만료
        sessionManager.expire(request);
        Object expired = sessionManager.getSession(request);
        org.assertj.core.api.Assertions.assertThat(expired).isNull();
    }
}