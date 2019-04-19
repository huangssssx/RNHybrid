package com.example.rnhybridandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.react.ReactActivity;

public class ReactPageActivity extends ReactActivity {

    public static void start(Activity activity){
        Intent intent = new Intent(activity,ReactPageActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected String getMainComponentName(){
        return "App1";
    }
}
