package hello.advanced.v4;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    public final OrderRepositoryV4 orderRepositoryV0;
    private final LogTrace trace;

    public void orderItem(String itemId){
        AbstractTemplate<Void> template = new AbstractTemplate<Void> (trace) {
            @Override
            protected Void call() {
                orderRepositoryV0.save(itemId);
                return null;
            }
        };
        template.execute ("OrderService.orderItem");
    }
}
