package com.hand.infra.util;

import org.springframework.context.ApplicationListener;

/**
 * @Program: JavaTest4
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-07 18:28
 **/
public class AfterInsertFilmEventListener implements ApplicationListener<AfterInsertFilmEvent> {

    @Override
    public void onApplicationEvent(AfterInsertFilmEvent afterInsertFilmEvent) {
        System.out.println(afterInsertFilmEvent.message());
    }
}
