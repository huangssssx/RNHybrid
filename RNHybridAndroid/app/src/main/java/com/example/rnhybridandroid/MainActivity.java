package com.example.rnhybridandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean useMode2 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.mode1){
                    useMode2 = false;
                }
                else if(checkedId == R.id.mode2){
                    useMode2 = true;
                }
            }
        });
    }

    @Override
    public void onClick(View v){
        int id = v.getId();
        if(id==R.id.jump){
            doJump();
        }
    }



    private void doJump(){
        if(useMode2){
            RNPageActivity.start(this);
        }
        else{
            ReactPageActivity.start(this);
        }
    }
}
