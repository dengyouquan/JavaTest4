package com.hand.infra.util;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * @Program: JavaTest4
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-07 18:16
 **/
public class StopApplicationContext implements ApplicationListener<ContextStoppedEvent> {
    @Override
    public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
        System.out.println("Context stop");
    }
}
