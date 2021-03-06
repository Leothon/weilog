package com.example.a10483.weilog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.a10483.weilog.Data.emotionbean;
import com.example.a10483.weilog.Data.user;
import com.example.a10483.weilog.fragment.allpage;
import com.example.a10483.weilog.fragment.explorepage;
import com.example.a10483.weilog.fragment.noticepage;
import com.example.a10483.weilog.utils.AsyncImageLoader;
import com.example.a10483.weilog.utils.DataCleanManager;
import com.example.a10483.weilog.utils.GetJson;
import com.example.a10483.weilog.utils.GetRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.makeramen.roundedimageview.RoundedImageView;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity
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
    private RoundedImageView nav_usericon;
    private TextView nav_username;

    private Oauth2AccessToken accessToken;
    private final static String get_emotion_url="https://api.weibo.com/2/emotions.json";

    private static final String user_show_url="https://api.weibo.com/2/users/show.json";
    private String token;



    @Override
    public boolean releaseInstance() {
        return super.releaseInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accessToken=AccessTokenKeeper.readAccessToken(this);

        //getEmotion();

        allPage=(ImageView)findViewById(R.id.allPage);
        explorePage=(ImageView)findViewById(R.id.explorePage);
        noticePage=(ImageView)findViewById(R.id.noticePage);
        nav_usericon=(RoundedImageView)findViewById(R.id.nav_usericon);
        nav_username=(TextView)findViewById(R.id.nav_username);
        switchFragment(ALLPAGE);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        //getActionBar().setDisplayHomeAsUpEnabled(true);
        token=accessToken.getToken().toString();
        //new emotionAsynctask().execute(get_emotion_url+"?access_token="+token);
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


        /*SharedPreferences sharedPreferences=getSharedPreferences("uiddata",MODE_PRIVATE);


        String uid=sharedPreferences.getString("uid","");
        //Log.d("String",uid+"   "+token);
        RequestQueue queue= MyApplication.requestQueue;
        JsonObjectRequest getuserinforequest=new JsonObjectRequest(user_show_url+"?access_token="+token+"&uid="+uid,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try{
                    String profile_image_url=jsonObject.getString("profile_image_url");
                    String username=jsonObject.getString("screen_name");
                    Log.d("MainActivity",profile_image_url+"  "+username);
                    //AsyncImageLoader asyncImageLoader=new AsyncImageLoader();
                    /*Drawable cacheImage=asyncImageLoader.loadDrawable(profile_image_url, new AsyncImageLoader.ImageCallback() {
                        @Override
                        public void imageLoaded(Drawable imageDrawable) {
                            nav_usericon.setImageDrawable(imageDrawable);
                        }
                    });

                    if(cacheImage!=null){
                        nav_usericon.setImageDrawable(cacheImage);
                    }*/
                    //Drawable drawable=Drawable.createFromStream(new URL(profile_image_url).openStream(),null);
                    /*nav_usericon.setImageResource(R.drawable.usericon);
                    nav_username.setText(username);
                }catch (Exception e){
                    e.printStackTrace();
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.print("Error");
            }
        });

        queue.add(getuserinforequest);*/
        setTabListener();

    }



    /*private Map<String,Drawable> emotion=new HashMap<>();

    class emotionAsynctask extends AsyncTask<String,Void,byte[]> {


        @Override
        protected byte[] doInBackground(String... strings) {

            return GetJson.getjson(strings[0]);
        }

        @Override
        protected void onPostExecute(byte[] bytes) {
            super.onPostExecute(bytes);
            if(bytes!=null){

                String jsonString=new String(bytes);
                try{
                    JSONArray emotionarray=new JSONArray(jsonString);

                    if(emotionarray.length()!=0){
                        for(int i=0;i<emotionarray.length();i++){
                            //JsonElement jsonElement=emotionarray.get(i);
                            //final emotionbean eb=gson.fromJson(jsonElement,emotionbean.class);
                            final emotionbean eb=new emotionbean();
                            JSONObject jsonObject=emotionarray.getJSONObject(i);
                            String phrase=jsonObject.getString("phrase");
                            String url=jsonObject.getString("url");
                            eb.setPhrase(phrase);
                            eb.setUrl(url);
                            AsyncImageLoader asyncImageLoader=new AsyncImageLoader();
                            asyncImageLoader.loadDrawable(eb.getUrl(), new AsyncImageLoader.ImageCallback() {
                                @Override
                                public void imageLoaded(Drawable imageDrawable) {
                                    //Resources res=context.getResources();
                                    //BitmapDrawable bitmapDrawable=(BitmapDrawable)imageDrawable;
                                    //Bitmap bitmap=bitmapDrawable.getBitmap();
                                    emotion.put(eb.getPhrase(),imageDrawable);
                                }
                            });
                        }

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }



            }

        }
    }*/


    //用accesstoken获取UID并存入SharePreferences中
    /*public  void getJson(){
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
    }*/


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

            default:
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
    protected void Listenhisview(){
        startActivity(new Intent(MainActivity.this,hisScan.class));
    }
    protected void Listensettings(){
        startActivity(new Intent(MainActivity.this,setting.class));
    }
    protected void Listennightmode(){//暂时用作清除掉存放在Share Preferences中的token和UID信息
        AccessTokenKeeper.clear(getApplicationContext());
        SharedPreferences sp=getSharedPreferences("uid",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.clear();
        editor.commit();
        //accessToken=new Oauth2AccessToken();
        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);

    }
    protected void Listenclearcache(){
        //DataCleanManager dataCleanManager=new DataCleanManager();
        DataCleanManager.cleanInternalCache(this);
        try{
            String cachesize=DataCleanManager.getCacheSize(getCacheDir());
            String mine=new String("清除"+cachesize+"缓存");
            Toast.makeText(this,mine,Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
