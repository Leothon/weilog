package com.example.a10483.weilog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class setting extends BaseActivity implements View.OnClickListener{

    private Toolbar setting_toolbar;
    private ImageView back_from_setting;
    private LinearLayout user_manage;
    private TextView user_name_in_setting;
    private LinearLayout autoplayvideosetting;
    private SwitchCompat auto_setting;
    private LinearLayout vioce_settings;
    private SwitchCompat vioce_setting;
    private LinearLayout notice_settings;
    private SwitchCompat notice_setting;
    private LinearLayout view_setting;
    private LinearLayout language;
    private TextView language_show;
    private LinearLayout explore_settings;
    private TextView explore_setting;
    private LinearLayout somethings;
    private TextView aboutapp;
    private TextView login_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initWeiget();
    }
    public void initWeiget(){
        setting_toolbar=(Toolbar)findViewById(R.id.setting_toolbar);
        setSupportActionBar(setting_toolbar);
        back_from_setting=(ImageView)findViewById(R.id.back_from_setting);
        back_from_setting.setOnClickListener(this);
        user_manage=(LinearLayout)findViewById(R.id.user_manage);
        user_manage.setOnClickListener(this);
        user_name_in_setting=(TextView)findViewById(R.id.user_name_in_setting);
        //user_name_in_setting.setOnClickListener(this);
        autoplayvideosetting=(LinearLayout)findViewById(R.id.autoplayvideosetting);
        autoplayvideosetting.setOnClickListener(this);
        auto_setting=(SwitchCompat)findViewById(R.id.auto_setting);
        //auto_setting.setOnClickListener(this);
        vioce_settings=(LinearLayout)findViewById(R.id.vioce_settings);
        vioce_settings.setOnClickListener(this);
        vioce_setting=(SwitchCompat) findViewById(R.id.vioce_setting);
        //vioce_setting.setOnClickListener(this);
        notice_settings=(LinearLayout)findViewById(R.id.notice_settings);
        notice_settings.setOnClickListener(this);
        notice_setting=(SwitchCompat)findViewById(R.id.notice_setting);
        //notice_setting.setOnClickListener(this);
        view_setting=(LinearLayout)findViewById(R.id.view_setting);
        view_setting.setOnClickListener(this);
        language=(LinearLayout)findViewById(R.id.language);
        language.setOnClickListener(this);
        language_show=(TextView)findViewById(R.id.language_show);
        //language_show.setOnClickListener(this);
        explore_settings=(LinearLayout)findViewById(R.id.explore_settings);
        explore_settings.setOnClickListener(this);
        explore_setting=(TextView)findViewById(R.id.explore_setting);
        //explore_setting.setOnClickListener(this);
        somethings=(LinearLayout)findViewById(R.id.somethings);
        somethings.setOnClickListener(this);
        aboutapp=(TextView) findViewById(R.id.aboutapp);
        aboutapp.setOnClickListener(this);
        login_out=(TextView) findViewById(R.id.login_out);
        login_out.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_from_setting:
                back();
                break;
            case R.id.user_manage:
                usersettings();
                break;
            case R.id.autoplayvideosetting:
                autoplay();
                break;
            case R.id.vioce_settings:
                viocesettings();
                break;
            case R.id.notice_settings:
                noticesettings();
                break;
            case R.id.view_setting:
                viewsettings();
                break;
            case R.id.language:
                languagesettings();
                break;
            case R.id.explore_settings:
                exploresettings();
                break;
            case R.id.somethings:
                somethingssettings();
                break;
            case R.id.aboutapp:
                aboutappsettings();
                break;
            case R.id.login_out:
                loginoutsettings();
                break;

            default:
                break;
        }
    }

    protected void back(){
        finish();
    }
    protected void usersettings(){
        //跳转账户管理
    }
    protected void autoplay(){
        //让switch动作，并打开自动播放开关
    }
    protected void viocesettings(){
        //打开声音开关
    }
    protected void noticesettings(){
        //打开通知开关
    }
    protected void viewsettings(){
        //跳转到显示设置页面
    }
    protected void languagesettings(){
        //语言设置，弹出对话框，选择语言，同时更改languageshow中显示
    }
    protected void exploresettings(){
        //浏览器设置，弹出对话框，选择浏览器，并显示
    }
    protected void somethingssettings(){
        //跳转隐私设置界面
    }
    protected void aboutappsettings(){
        //跳转到关于weilog的页面
    }
    protected void loginoutsettings(){
        //弹出对话框，选择是否登出，登出之后动作
    }
}
