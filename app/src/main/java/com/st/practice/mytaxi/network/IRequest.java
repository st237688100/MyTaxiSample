package com.st.practice.mytaxi.network;

import java.util.HashMap;

/**
 *
 */

public interface IRequest {

    String getUrl();

    String getMethod();

    HashMap<String,Object> getParams();

}
