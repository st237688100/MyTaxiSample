package com.st.practice.mytaxi;

import android.widget.Toast;

/**
 * @Author: shiteng
 * @Date: 2019/4/9 00:19
 */
public class ToastUtils {


    public static void showLongToast(String message) {
        Toast.makeText(TaxiApplication.getInstance(),message,Toast.LENGTH_LONG).show();
    }


    public static void showShortToast(String message) {
        Toast.makeText(TaxiApplication.getInstance(),message,Toast.LENGTH_SHORT).show();
    }
}
