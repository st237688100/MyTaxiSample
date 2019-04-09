package com.st.practice.mytaxi.network;

import java.util.HashMap;

/**
 *
 */
public class BaseRequest<T>{

    protected String url;

    protected String method;

    protected HashMap<String, String> params;

    public BaseRequest(RequestBuilder builder) {
        url = builder.getUrl();
        method = builder.getMethod();
        params = builder.getParams();
    }

    public BaseResponse<T> execute(){
        return null;
    };

    /** 非阻塞方法，异步请求，但是回调在子线程中执行 */
    public void execute(NetCallBack<BaseResponse<T>> callback){};

}
