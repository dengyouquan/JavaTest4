package com.hand.infra.util;

import org.springframework.context.ApplicationEvent;

/**
 * @Program: JavaTest4
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-07 18:23
 **/
public class BeforeInsertFilmEvent extends ApplicationEvent {
    public BeforeInsertFilmEvent(Object source) {
        super(source);
    }
    public String message(){
        return "Before Insert Film Data";
    }
}
