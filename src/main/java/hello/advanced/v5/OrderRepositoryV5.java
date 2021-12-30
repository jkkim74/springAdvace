package hello.advanced.v5;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.strategy.ContextV1;
import hello.advanced.trace.strategy.Strategy;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV5 {

    private final LogTrace trace;
    public void save(String itemId){
        Strategy<Void> strategy = () -> {
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외발생!!!!!");
            }
            return null;
        };
        ContextV1 contextV1 = new ContextV1(strategy,"OrderRepository.save",trace);
        contextV1.execute();
    }
}
