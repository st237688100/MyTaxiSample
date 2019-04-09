package com.st.practice.mytaxi.rxbus;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: shiteng
 * @Date: 2019/4/5 14:35
 */
@Data
@EqualsAndHashCode
public class AccountEvent extends BaseEvent{

    public AccountEvent(int code) {
        super(code);
    }

    public AccountEvent(int code,String message) {
        super(code,message);
    }

}
