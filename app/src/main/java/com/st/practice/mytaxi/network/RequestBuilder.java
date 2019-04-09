package com.st.practice.mytaxi.network;

import java.util.HashMap;

public class RequestBuilder {
    private String                  url;
    private String                  method;
    private HashMap<String, String> params;

    public RequestBuilder() {
    }

    public RequestBuilder url(String val) {
        url = val;
        return this;
    }

    public RequestBuilder method(String val) {
        method = val;
        return this;
    }

    public RequestBuilder params(HashMap<String, String> val) {
        params = val;
        return this;
    }

    public RequestBuilder param(String key, String val) {
        if (params == null) params = new HashMap<>();
        params.put(key, val);
        return this;
    }

    public BaseRequest build() {
        return new MyRequest(this);
    }


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