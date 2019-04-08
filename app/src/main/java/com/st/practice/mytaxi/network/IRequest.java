package com.st.practice.mytaxi.network;

/**
 *
 */

public interface IRequest {

    String getUrl();

    String getMethod();

    Object getParams();

}
