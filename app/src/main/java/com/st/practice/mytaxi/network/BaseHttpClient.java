package com.st.practice.mytaxi.network;

import android.app.Application;

/**
 *
 */
public abstract class BaseHttpClient<T extends BaseRequest, K extends BaseResponse>{

    protected String baseUrl;

    public abstract void init(Application application);

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

}
