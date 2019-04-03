package com.st.practice.mytaxi.network;

import java.util.HashMap;

/**
 *
 */
public class BaseRequest implements IRequest {

    private String url;

    private String method;

    private HashMap<String, Object> params;

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public HashMap<String, Object> getParams() {
        return params;
    }

}
