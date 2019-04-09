package com.st.practice.mytaxi.network;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Response;

/**
 * @Author: shiteng
 * @Date: 2019/4/8 17:42
 */
public class NetClient {

    public void get(String url) {
        OkGo.get(url).execute(new AbsCallback<Object>() {
            @Override
            public void onSuccess(Response<Object> response) {

            }

            @Override
            public Object convertResponse(okhttp3.Response response) throws Throwable {
                return null;
            }
        });
    }

    public void execute(NetCallBack netCallBack) {
        if (netCallBack == null) {
            throw new NullPointerException("netCallBack null");
        }
    }

}
