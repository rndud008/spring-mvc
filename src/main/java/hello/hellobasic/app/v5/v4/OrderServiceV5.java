package hello.hellobasic.app.v5.v4;

import hello.hellobasic.trace.callback.TraceCallback;
import hello.hellobasic.trace.callback.TraceTemplate;
import hello.hellobasic.trace.logtrace.LogTrace;
import hello.hellobasic.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace logTrace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(logTrace);
    }

    public void orderItem(String itemId) {
        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });



    }
}
