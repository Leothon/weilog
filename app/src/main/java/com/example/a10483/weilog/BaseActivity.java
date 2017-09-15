package com.example.a10483.weilog;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
