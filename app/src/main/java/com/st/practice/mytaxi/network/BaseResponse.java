package com.st.practice.mytaxi.network;

/**
 *
 */
public class BaseResponse<T> implements IResponse {

    private int code;

    private String message;

    private T data;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

}
