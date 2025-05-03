package hello.hellobasic.pureproxy.decorator;

import hello.hellobasic.pureproxy.decorator.code.Component;
import hello.hellobasic.pureproxy.decorator.code.DecoratorPatternClient;
import hello.hellobasic.pureproxy.decorator.code.MessageDecorator;
import hello.hellobasic.pureproxy.decorator.code.RealComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator(){
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);

        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void decorator(){
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);

        client.execute();
        client.execute();
        client.execute();
    }
}
