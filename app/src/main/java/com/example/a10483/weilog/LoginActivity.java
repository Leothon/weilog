package com.example.a10483.weilog;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a10483.weilog.utils.GetJson;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;

import org.json.JSONObject;

import java.text.SimpleDateFormat;


public class LoginActivity extends BaseActivity {


    private Context context;
    private Button Authbutton;
    private Button logout;
    private Button refershtoken;
    private TextView tokentext;
    private AuthInfo mAuthInfo;
    //private static final String TAG = "weibosdk";
    private Oauth2AccessToken mAccessToken;
    private SsoHandler mSsoHandler;
    //private SinaUserInfo mUserInfo;
    private final static String get_uid_url="https://api.weibo.com/2/account/get_uid.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context=this;
        mAuthInfo=new AuthInfo(context,Constants.APP_KEY,Constants.REDIRECT_URL,Constants.SCOPE);
        WbSdk.install(LoginActivity.this,mAuthInfo);
        mSsoHandler=new SsoHandler(LoginActivity.this);
        Authbutton=(Button)findViewById(R.id.authbutton);
        Authbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSsoHandler.authorize(new SelfWbAuthListener());
            }
        });


        logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccessTokenKeeper.clear(getApplicationContext());
                mAccessToken=new Oauth2AccessToken();
                updateTokenView(false);

            }
        });
        refershtoken=(Button)findViewById(R.id.refershtoken);
        tokentext=(TextView)findViewById(R.id.tokentext);
        refershtoken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(mAccessToken.getRefreshToken())){
                    AccessTokenKeeper.refreshToken(Constants.APP_KEY, LoginActivity.this, new RequestListener() {
                        @Override
                        public void onComplete(String s) {

                        }

                        @Override
                        public void onWeiboException(WeiboException e) {

                        }
                    });
                }
            }
        });
        //从Share Preferences中读取保存好的token信息
        mAccessToken=AccessTokenKeeper.readAccessToken(this);
        if (mAccessToken.isSessionValid()){
            updateTokenView(true);
        }

    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        //SSO授权回调
        if(mSsoHandler!=null){
            mSsoHandler.authorizeCallBack(requestCode,resultCode,data);
        }
    }
    public Handler handler=new Handler(){
        public void handleMessage(Message msg){
            if (msg.what==1){
                getJson(mAccessToken,get_uid_url);
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        }
    };
    private class SelfWbAuthListener implements WbAuthListener{
        @Override
        public void onSuccess(final Oauth2AccessToken token) {
            LoginActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mAccessToken=token;
                    if (mAccessToken.isSessionValid()){
                        //保存token到sharePreferences
                        AccessTokenKeeper.writeAccessToken(LoginActivity.this,mAccessToken);
                        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        Message message=Message.obtain();
                        message.what=1;
                        handler.sendMessage(message);
                    }
                }
            });
        }

        @Override
        public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
            Toast.makeText(LoginActivity.this,"授权失败",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void cancel() {
            Toast.makeText(LoginActivity.this,"取消授权",Toast.LENGTH_SHORT).show();
        }
    }

    private void updateTokenView(boolean hasExisted){
        String date=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date(mAccessToken.getExpiresTime()));
        String format=("Token：%1$s \n有效期：%2$s");
        tokentext.setText(String.format(format,mAccessToken.getToken(),date));

        String message = String.format(format, mAccessToken.getToken(), date);
        if (hasExisted) {
            message = ("Token仍在有效期，无需登录") + "\n" + message;
        }
        tokentext.setText(message);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityCollector.finishAll();
    }

    public  void getJson(final Oauth2AccessToken accessToken,final String get_uid_url){
        new Thread(){
            @Override
            public void run() {
                try{
                    String token=accessToken.getToken().toString();
                    byte[] bytes= GetJson.getjson(get_uid_url+"?access_token="+token);
                    String uidjson=new String(bytes);
                    //Log.d("MainActivity",json);
                    JSONObject jsonObject=new JSONObject(uidjson);
                    String UID=jsonObject.getString("uid");
                    //Log.d("MainActivity",UID);
                    SharedPreferences.Editor editor=getSharedPreferences("uiddata",MODE_PRIVATE).edit();
                    editor.putString("uid",UID);
                    editor.commit();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
        //JSONObject jsonObject=new JSONObject(json);
    }
}
