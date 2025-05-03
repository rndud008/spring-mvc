package hello.hellobasic.app.v5;

import hello.hellobasic.trace.callback.TraceTemplate;
import hello.hellobasic.trace.logtrace.LogTrace;
import org.springframework.stereotype.Repository;


@Repository

public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace logTrace) {
        this.template = new TraceTemplate(logTrace);
    }

    public void save( String itemId) {
        template.execute("OrderRepositoryV5.save()", ()->{
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            return null;
        });


    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
