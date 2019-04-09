package com.st.practice.mytaxi;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.st.practice.mytaxi.network.MyClient;


public class TaxiApplication extends Application {

    private static TaxiApplication INSTANCE;

    public static TaxiApplication getInstance() {
        return INSTANCE;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        this.INSTANCE = this;
        this.registerActivityLifecycleCallbacks(new AppLifecycleCallback());
        Logger.addLogAdapter(new AndroidLogAdapter());
        MyClient.getInstance().init(this);
    }


}
