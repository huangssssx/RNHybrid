package com.example.rnhybridandroid;

import android.content.Context;
import android.provider.Settings;
import android.support.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;


public class Test {

    //定义上下文对象
    public ReactContext myContext;

    public Test(ReactContext context) {
        this.myContext = context;
    }

    //定义发送事件的函数
    public void sendEventToUi(ReactContext reactContext, String eventName, @Nullable WritableMap params) {
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, params);
    }

    public void sendMsg()
    {
        //在该方法中开启线程，并且延迟1秒，然后向JavaScript端发送事件。
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //发送事件,事件名为EventName
                WritableMap wm = Arguments.createMap();
                sendEventToUi(myContext,"EventName", wm);
            }
        }).start();
    }
}
