package hello.advanced.v5;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.strategy.ContextV1;
import hello.advanced.trace.strategy.Strategy;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final LogTrace trace;

    @GetMapping("/v5/request")
    public String request(String itemId) {
        Strategy<String> strategy = () -> {
            orderService.orderItem (itemId);
            return "ok";
        };
        ContextV1 contextV1 = new ContextV1(strategy,"OrderController.request",trace);
        return contextV1.execute();
    }
}
