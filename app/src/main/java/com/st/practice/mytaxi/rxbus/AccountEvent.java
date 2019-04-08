package com.st.practice.mytaxi.rxbus;

import lombok.Data;

/**
 * @Author: shiteng
 * @Date: 2019/4/5 14:35
 */
@Data
public class AccountEvent extends BaseEvent{

    public AccountEvent(int code) {
        super(code);
    }

    public AccountEvent(int code,String message) {
        super(code,message);
    }

}
