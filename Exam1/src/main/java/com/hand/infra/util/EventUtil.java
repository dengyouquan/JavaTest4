package com.hand.infra.util;

/**
 * @Program: JavaTest4
 * @Description: publish Spring的事件
 * @Author: Youquan Deng
 * @Create: 2018-08-07 14:39
 **/
public class EventUtil {
    public void beforeInsertFilmEvent() {
        System.out.println("Before Insert Film Data");
    }

    public void afterInsertFilmEvent() {
        System.out.println("After Insert Film Data");
    }
}
