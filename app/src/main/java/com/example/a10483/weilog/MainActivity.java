package com.example.a10483.weilog;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a10483.weilog.fragment.allpage;
import com.example.a10483.weilog.fragment.explorepage;
import com.example.a10483.weilog.fragment.noticepage;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private ImageView allPage;
    private ImageView explorePage;
    private ImageView noticePage;

    private static final String ALLPAGE="allpage";
    private static final String EXPLOREPAGE="explorepage";
    private static final String NOTICEPAGE="noticepage";

    private FragmentTransaction transaction;
    private allpage allPagefragment;
    private explorepage explorePagefragment;
    private noticepage noticePagefragment;

    private ImageView open_nav;
    private TextView titlename;
    private ImageView search;
    private ImageView nav_usericon;
    private TextView nav_username;

    @Override
    public boolean releaseInstance() {
        return super.releaseInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allPage=(ImageView)findViewById(R.id.allPage);
        explorePage=(ImageView)findViewById(R.id.explorePage);
        noticePage=(ImageView)findViewById(R.id.noticePage);
        nav_usericon=(ImageView)findViewById(R.id.nav_usericon);
        nav_username=(TextView)findViewById(R.id.nav_username);
        switchFragment(ALLPAGE);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        open_nav=(ImageView)findViewById(R.id.open_nav);
        titlename=(TextView)findViewById(R.id.titlename);
        search=(ImageView)findViewById(R.id.search);
        open_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        /*nav_usericon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到我的页面
                Intent intent=new Intent(MainActivity.this,Activityaboutme.class);
                startActivity(intent);
            }
        });*/
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setTabListener();



    }




    public void setTabListener(){
        allPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment(ALLPAGE);
                titlename.setText("全部");
                search.setImageResource(R.drawable.ic_search);
            }
        });
        explorePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment(EXPLOREPAGE);
                titlename.setText("探索");
                search.setImageResource(R.drawable.ic_search);
            }
        });
        noticePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment(NOTICEPAGE);
                titlename.setText("消息提醒");
                search.setImageResource(R.drawable.message);
            }
        });
    }

    public void switchFragment(String pagename){
        FragmentManager manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        ClearAllFragment(transaction);
        switch (pagename){
            case ALLPAGE:
                allPage.setImageResource(R.drawable.allpagedark);
                if (allPagefragment==null){
                    allPagefragment=new allpage();
                    transaction.add(R.id.contentlayout,allPagefragment,ALLPAGE);
                }else{
                    transaction.show(allPagefragment);
                }
                break;
            case EXPLOREPAGE:
                explorePage.setImageResource(R.drawable.explorepagedark);
                if (explorePagefragment==null){
                    explorePagefragment=new explorepage();
                    transaction.add(R.id.contentlayout,explorePagefragment,EXPLOREPAGE);
                }else{
                    transaction.show(explorePagefragment);
                }
                break;
            case NOTICEPAGE:
                noticePage.setImageResource(R.drawable.noyicepagedark);
                if (noticePagefragment==null){
                    noticePagefragment=new noticepage();
                    transaction.add(R.id.contentlayout,noticePagefragment,NOTICEPAGE);
                }else{
                    transaction.show(noticePagefragment);
                }
                break;
        }
        transaction.commit();
    }

    public void ClearAllFragment(FragmentTransaction transaction){
        if (allPagefragment!=null){
            transaction.hide(allPagefragment);
            allPage.setImageResource(R.drawable.allpage);
        }
        if (explorePagefragment!=null){
            transaction.hide(explorePagefragment);
            explorePage.setImageResource(R.drawable.explorepage);
        }
        if (noticePagefragment!=null){
            transaction.hide(noticePagefragment);
            noticePage.setImageResource(R.drawable.noticepage);
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.nav_user:
                Listenuser();
                break;
            case R.id.nav_edit:
                Listenedit();
                break;
            case R.id.nav_scan:
                Listenscan();
                break;
            case R.id.nav_hisview:
                Listenhisview();
                break;
            case R.id.nav_settings:
                Listensettings();
                break;
            case R.id.nav_nightmode:
                Listennightmode();
                break;
            case R.id.nav_clearcache:
                Listenclearcache();
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    protected void Listenuser(){
        //跳转到我的页面
        Intent intent=new Intent(MainActivity.this,Activityaboutme.class);
        startActivity(intent);
    }
    protected void Listenedit(){
        Intent intent=new Intent(MainActivity.this,editactivity.class);
        startActivity(intent);
    }
    protected void Listenscan(){
        startActivity(new Intent(MainActivity.this,CaptureActivity.class));
    }
    protected void Listenhisview(){}
    protected void Listensettings(){}
    protected void Listennightmode(){}
    protected void Listenclearcache(){}
}
