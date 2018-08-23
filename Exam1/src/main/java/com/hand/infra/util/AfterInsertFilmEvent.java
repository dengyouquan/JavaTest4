package com.hand.infra.util;

import org.springframework.context.ApplicationEvent;

/**
 * @Program: JavaTest4
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-07 18:23
 **/
public class AfterInsertFilmEvent extends ApplicationEvent {
    public AfterInsertFilmEvent(Object source) {
        super(source);
    }
    public String message(){
        return "After Insert Film Data";
    }
}
