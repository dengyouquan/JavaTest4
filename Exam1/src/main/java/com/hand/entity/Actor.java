package com.hand.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Program: TestJava
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-06 09:54
 **/
@Setter
@Getter
@ToString
public class Actor implements Serializable {
    private int actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;
}
