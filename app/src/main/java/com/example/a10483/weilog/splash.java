package com.example.a10483.weilog;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

public class splash extends BaseActivity {

    private Oauth2AccessToken token;
    private Boolean islogin=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);
        token = AccessTokenKeeper.readAccessToken(this);
        if (token.isSessionValid()) {
            islogin=true;
        }
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
