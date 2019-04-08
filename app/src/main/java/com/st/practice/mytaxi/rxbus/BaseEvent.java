package com.st.practice.mytaxi.rxbus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: shiteng
 * @Date: 2019/4/5 14:35
 */
@Data
@AllArgsConstructor
public class BaseEvent {

    protected int code;

    protected String message;

    protected Object data;

    public BaseEvent(int code) {
        this.code = code;
    }

    public BaseEvent(int code,String message) {
        this.code = code;
        this.message = message;
    }

}
