package hello.advanced.v5;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.strategy.ContextV1;
import hello.advanced.trace.strategy.Strategy;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {

    public final OrderRepositoryV5 orderRepositoryV0;
    private final LogTrace trace;

    public void orderItem(String itemId){
        Strategy<Void> strategy = () -> {
            orderRepositoryV0.save(itemId);
            return null;
        };
        ContextV1 contextV1 = new ContextV1(strategy,"OrderService.orderItem",trace);
        contextV1.execute();
    }
}
