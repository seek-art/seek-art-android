package com.android.xunyi.Utils;

import android.app.Application;
import android.content.Context;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2017/3/18.
 */

public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Fresco.initialize(this);
    }

    public static Context getContext(){
        return instance;
    }
}
