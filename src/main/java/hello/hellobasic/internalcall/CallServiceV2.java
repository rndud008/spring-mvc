package hello.hellobasic.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV2 {


//    private final ApplicationContext applicationContext;
//
//    public CallServiceV2(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }

    private final ObjectProvider<CallServiceV2> callServiceV2Provider;

    public CallServiceV2(ObjectProvider<CallServiceV2> callServiceV2Provider) {
        this.callServiceV2Provider = callServiceV2Provider;
    }

//    위 의 방법들을 사용하려면  스프링 부트 2.6 이상이라면 이 설정을 꼭 추가 추가해야 한다.
//   (properties = "spring.main.allow-circular-references=true")


    public void external() {
        log.info("call external");
//        CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class);
        CallServiceV2 callServiceV2 = callServiceV2Provider.getObject();
        callServiceV2.internal();// 외부 메서드 호출
    }

    public void internal() {
        log.info("call internal");
    }
}
