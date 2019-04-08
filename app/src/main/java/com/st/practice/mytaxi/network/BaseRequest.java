package com.st.practice.mytaxi.network;

import java.util.HashMap;

/**
 *
 */
public class BaseRequest implements IRequest {

    protected String url;

    protected String method;

    protected HashMap<String, String> params;

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

}
