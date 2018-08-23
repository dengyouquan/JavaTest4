package com.hand.infra.util;

import org.springframework.context.ApplicationListener;

/**
 * @Program: JavaTest4
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-07 18:28
 **/
public class BeforeInsertFilmEventListener implements ApplicationListener<BeforeInsertFilmEvent> {
    @Override
    public void onApplicationEvent(BeforeInsertFilmEvent beforeInsertFilmEvent) {
        System.out.println(beforeInsertFilmEvent.message());
    }
}
