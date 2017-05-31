package com.example.a10483.weilog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a10483.weilog.Adapter.WeilogAdapter;
import com.example.a10483.weilog.Data.Weilog;

import java.util.List;

public class Activityaboutme extends AppCompatActivity {

    private Toolbar toolbar_inme;
    private ImageView back_me;
    private TextView info_me;
    private ImageView searchmylog;
    private List<Weilog> minedata;
    private ImageView codeofmine;
    private ImageView rewritemine;
    private ImageView usericon_inme;
    private TextView username_inme;
    private ImageView sex;
    private TextView talkofmine;
    private TextView adress;
    private TextView followcount;
    private TextView fanscount;
    private LinearLayout followclick;
    private LinearLayout fansclick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activityaboutme);

        toolbar_inme=(Toolbar)findViewById(R.id.toolbar_inme);
        setSupportActionBar(toolbar_inme);
        toolbar_inme.getBackground().setAlpha(0);
        back_me=(ImageView)findViewById(R.id.back_in_me);
        info_me=(TextView)findViewById(R.id.infoaboutme);
        searchmylog=(ImageView)findViewById(R.id.searchmylog);
        ListView aboutme_listview=(ListView)findViewById(R.id.aboutme_listview);
        View headitem=View.inflate(this,R.layout.aboutmeheaditem,null);
        WeilogAdapter adapter=new WeilogAdapter(this,minedata);
        aboutme_listview.addHeaderView(headitem);
        aboutme_listview.setAdapter(adapter);
        setListener();

    }
    public void setListener(){
        back_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        searchmylog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到搜索我的微博界面
                Toast.makeText(getApplicationContext(),"this is searchmylog ",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
