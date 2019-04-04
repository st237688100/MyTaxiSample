package com.st.practice.mytaxi;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    public static final String TAG = ExampleInstrumentedTest.class.getSimpleName();

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.st.practice.mytaxi", appContext.getPackageName());
    }

    @Test
    public void testRxAndroid(){
        Observable.just("one", "two", "three", "four", "five")
            .subscribeOn(Schedulers.newThread())
            .map(text->{
                Log.d(TAG,"map:" + text +  Thread.currentThread().getName());
                return text + "map";
            })
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<String>() {
                @Override
                public void onSubscribe(Disposable d) {
                    Log.d(TAG,"onSubscribe:" + Thread.currentThread().getName());
                }

                @Override
                public void onNext(String s) {
                    Log.d(TAG, s + Thread.currentThread().getName());
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {
                    Log.d(TAG, "onComplete:" + Thread.currentThread().getName());
                }
            });
    }
}
