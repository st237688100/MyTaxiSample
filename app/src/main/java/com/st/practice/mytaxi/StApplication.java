package com.st.practice.mytaxi;

import android.app.Application;

public class StApplication extends Application {

    private static StApplication INSTANCE;

    public static StApplication getInstance() {
        return INSTANCE;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        this.INSTANCE = this;
        this.registerActivityLifecycleCallbacks(new AppLifecycleCallback());
    }


}
