package com.st.practice.mytaxi.network;

/**
 *
 */
public interface IHttpClient<T extends IRequest,K extends IResponse> {

    String getBaseUrl();

    K call(T request);

}
