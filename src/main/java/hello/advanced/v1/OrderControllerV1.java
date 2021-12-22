package hello.advanced.v1;

import hello.advanced.hellotrace.HelloTraceV1;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;
    private final HelloTraceV1 trace;

    @GetMapping("/v1/request")
    public String request(String itemId){
        TraceStatus status = trace.begin("OrderControllerV1.request");
        try {
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        }catch(Exception e){
            trace.exception(status,e);
            throw e;
        }

    }
}
