package com.example.a10483.weilog;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class splash extends AppCompatActivity {

    private Boolean islogin=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (islogin){
                    Intent intent=new Intent(splash.this,MainActivity.class);
                    startActivity(intent);
                    splash.this.finish();
                }else {
                    Intent intent = new Intent(splash.this, LoginActivity.class);
                    startActivity(intent);
                    splash.this.finish();
                }
            }
        },3000);
    }
}
