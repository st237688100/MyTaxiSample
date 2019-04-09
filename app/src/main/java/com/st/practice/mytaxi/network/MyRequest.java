package com.st.practice.mytaxi.network;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.base.Request;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Response;

/**
 *
 */
public class MyRequest<T> extends BaseRequest<T>{

    protected String url;

    protected String method;

    protected HashMap<String, String> params;

    public MyRequest(RequestBuilder builder) {
        super(builder);
        url = builder.getUrl();
        method = builder.getMethod();
        params = builder.getParams();
    }

    public BaseResponse execute(){
        try {
            Response response = OkGo.getInstance().get(url).params(params).execute();
            if (response.code() == 200) {
                String bodyString = response.body().toString();
                BaseResponse baseResponse = new Gson().fromJson(bodyString, BaseResponse.class);
                return baseResponse;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    };


    /** 非阻塞方法，异步请求，但是回调在子线程中执行 */
    @Override
    public void execute(NetCallBack<BaseResponse<T>> callback) {
        Request okGoRequest = null;
        if (MyClient.METHOD_GET.equals(method)) {
            okGoRequest = OkGo.getInstance().<BaseResponse<T>>get(url).params(params);
        } else if (MyClient.METHOD_POST.equals(method)) {
            okGoRequest = OkGo.<BaseResponse<T>>post(url).upJson(new Gson().toJson(params));
        }
        okGoRequest.execute(new JsonCallback<BaseResponse<T>>() {
            @Override
            public void onSuccess(com.lzy.okgo.model.Response<BaseResponse<T>> response) {
                BaseResponse<T> baseResponse = response.body();
                callback.onSuccess(baseResponse);
            }

            @Override
            public void onError(com.lzy.okgo.model.Response<BaseResponse<T>> response) {
                super.onError(response);
                BaseResponse baseResponse = null;
                response.getException().printStackTrace();
                callback.onError(baseResponse);
            }
        });
    }

}
