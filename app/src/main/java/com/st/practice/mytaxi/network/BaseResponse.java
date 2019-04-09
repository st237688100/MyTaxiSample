package com.st.practice.mytaxi.network;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@Data
@NoArgsConstructor
public class BaseResponse<T>{

    protected int code;

    protected String message;

    protected T data;

}
