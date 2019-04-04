package com.st.practice.mytaxi.presenter;

import com.st.practice.mytaxi.iview.IView;

/**
 * @Author: shiteng
 * @Date: 2019/4/3 17:39
 */
public interface IPresenter<T extends IView> {

    public void attach(T iview);

    public void detach();

}
