package com.hand.infra.util;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * @Program: JavaTest4
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-07 18:16
 **/
public class StartApplicationContext implements ApplicationListener<ContextStartedEvent> {

    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("Context Start");
    }
}
