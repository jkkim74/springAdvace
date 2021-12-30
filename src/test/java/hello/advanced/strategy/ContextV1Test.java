package hello.advanced.strategy;

import hello.advanced.strategy.code.strategy.ContextV1;
import hello.advanced.strategy.code.strategy.Strategy;
import hello.advanced.strategy.code.strategy.StrategyLogic1;
import hello.advanced.strategy.code.strategy.StrategyLogic2;
import hello.advanced.template.AbstractTemplate;
import hello.advanced.template.SubClassLogic1;
import hello.advanced.template.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0(){
        logic();
        logic2();
    }

    private void logic() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직 1 실행!!!");

        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        log.info("resultTime={}",resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직 2 실행!!!");

        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        log.info("resultTime={}",resultTime);
    }

    @Test
    void strategyV1(){
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    @Test
    void strategyV2(){

        ContextV1 contextV1 = new ContextV1(() -> log.info ("비즈니스 로직1 실행"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(() -> log.info ("비즈니스 로직2 실행"));
        contextV2.execute();

    }

}
