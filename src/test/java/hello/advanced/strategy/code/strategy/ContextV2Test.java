package hello.advanced.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1(){
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());

    }

    @Test
    void strategyV2(){
        ContextV2 context = new ContextV2();
        context.execute (() -> log.info("비즈니스 1 실행"));
        context.execute (() -> log.info("비즈니스 2 실행"));

    }

}
