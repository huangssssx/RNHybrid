package com.example.rnhybridandroid;

import android.widget.Toast;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class MyNativeModule extends ReactContextBaseJavaModule {
    // 创建一个上下文，放到构造函数中，得到reactContext
    private ReactApplicationContext mContext;

    public MyNativeModule(ReactApplicationContext reactContext){

        super(reactContext);

        mContext = reactContext;
    }
    @Override
    public String getName() {
        // 一定要有名字 RN代码要通过名字来调用该类的方法
        return "MyNativeModule";
    }

    //方法不能返回值 因为被调用的原生代码是异步的 原生代码执行结束之后只能通过回调函数或者发送消息给RN
    @ReactMethod
    public void rnCallNative(String msg, Promise promise){
        //这个方法是说弹出一个弹窗到界面Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
        promise.resolve("回执已收到");
        new Test(mContext).sendMsg();
    }
}
