package com.st.practice.mytaxi.network;

import lombok.Builder;
import lombok.Data;

/**
 *
 */
@Data
@Builder
public class SimpleResponse{

    protected int code;

    protected String message;


    public BaseResponse toBaseResponse() {
        BaseResponse lzyResponse = new BaseResponse();
        lzyResponse.code = code;
        lzyResponse.message = message;
        return lzyResponse;
    }

}
