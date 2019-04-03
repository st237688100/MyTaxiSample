package com.st.practice.mytaxi.network;

/**
 *
 */
public abstract class BaseHttpClient implements IHttpClient{

    protected String baseUrl;

    public abstract void init();

    public abstract BaseResponse call(BaseRequest request);

    public String getBaseUrl(){
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
    }

}
