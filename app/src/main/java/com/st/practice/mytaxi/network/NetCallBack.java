package com.st.practice.mytaxi.network;

/**
 * @Author: shiteng
 * @Date: 2019/4/8 17:11
 */
public interface NetCallBack<T> {

    public void onSuccess(T response);

    public void onError(T response);

}
