package com.st.practice.mytaxi.network;

/**
 *
 */
public interface IHttpClient {

    public String getBaseUrl();

    public IResponse call(IRequest request);

}
