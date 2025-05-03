package hello.hellobasic.pureproxy.concreteproxy;

import hello.hellobasic.pureproxy.concreteproxy.code.ConcreteClient;
import hello.hellobasic.pureproxy.concreteproxy.code.ConcreteLogic;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);

        client.execute();
    }
}
