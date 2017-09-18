package com.example.a10483.weilog;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
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
import com.example.a10483.weilog.utils.GetJson;
import com.example.a10483.weilog.utils.ViewHolder;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Activityaboutme extends BaseActivity {

    private Toolbar toolbar_inme;
    private ImageView back_me;
    private TextView info_me;
    private ImageView searchmylog;
    private ImageView codeofmine;
    private ImageView rewritemine;
    private ImageView usericon_inme;
    private TextView username_inme;
    private ImageView sex;
    private TextView talkofmine;
    private TextView address;
    private TextView followcount;
    private TextView fanscount;
    private LinearLayout followclick;
    private LinearLayout fansclick;
    private WeilogAdapter mAdapter;
    private List<String> aboutmedata;
    private Oauth2AccessToken AcessToken;
    private String uid;
    private static final String user_shou_url="https://api.weibo.com/2/users/show.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activityaboutme);
        AcessToken= AccessTokenKeeper.readAccessToken(this);
        SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        uid= sharedPreferences.getString("uid","");
        toolbar_inme=(Toolbar)findViewById(R.id.toolbar_inme);
        setSupportActionBar(toolbar_inme);
        toolbar_inme.getBackground().setAlpha(0);
        back_me=(ImageView)findViewById(R.id.back_in_me);
        info_me=(TextView)findViewById(R.id.infoaboutme);
        searchmylog=(ImageView)findViewById(R.id.searchmylog);
        ListView aboutme_listview=(ListView)findViewById(R.id.aboutme_listview);
        View headitem=View.inflate(this,R.layout.aboutmeheaditem,null);
        //WeilogAdapter adapter=new WeilogAdapter(this,minedata);
        initdata();
        aboutme_listview.addHeaderView(headitem);
        aboutme_listview.setAdapter(mAdapter=new WeilogAdapter(getApplicationContext(),aboutmedata,R.layout.weilogitem) {
            @Override
            public void convert(ViewHolder helper, Object item) {
                helper.setText(R.id.user_name,"Leothon");
            }
        });

        usericon_inme=(ImageView)findViewById(R.id.usericon_inme);
        username_inme=(TextView)findViewById(R.id.user_name_in_me);
        sex=(ImageView)findViewById(R.id.sex);
        talkofmine=(TextView)findViewById(R.id.talkofmine);
        address=(TextView)findViewById(R.id.user_adress);
        followcount=(TextView)findViewById(R.id.followcount);
        fanscount=(TextView)findViewById(R.id.fanscount);
        setListener();
        getJsondata();
    }

    public void getJsondata(){
        new Thread(){
            @Override
            public void run() {
                try{
                    String token=null;
                    token=AcessToken.getToken().toString();
                    String json= GetJson.getjson(user_shou_url+"?access_token="+token+"?uid="+uid);
                    Bundle bundle=new Bundle();
                    bundle.putString("jsondata",json);
                    Message message=new Message();
                    message.what=1;
                    message.setData(bundle);

                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        }.start();
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    String jsondata=msg.getData().getString("jsondata");
                    setdata(jsondata);
                    break;
                default:
                    break;
            }
        }
    };
    public void setdata(String json){
        JSONObject jsonObject=new JSONObject();
        try{
            String userName=jsonObject.getString("screen_name");
            String userAddress=jsonObject.getString("location");
            String userDescription=jsonObject.getString("description");
            final String userProfileImageUrl=jsonObject.getString("profile_image_url");
            String userSex=jsonObject.getString("gender");
            String userFollowersCount=jsonObject.getString("followers_count");
            String userFriendsCount=jsonObject.getString("friends_count");
            String userStatusesCount=jsonObject.getString("statuses_count");
            username_inme.setText(userName);
            address.setText(userAddress);
            talkofmine.setText(userDescription);
            followcount.setText(userFollowersCount);
            fanscount.setText(userFriendsCount);
            if (userSex.equals("m")){
                sex.setImageResource(R.drawable.male);
            }else if (userSex.equals("f")){
                sex.setImageResource(R.drawable.famale);
            }else{
                sex.setImageResource(R.drawable.unkownsex);
            }
            //usericon_inme.setImageBitmap(getBitmapFromUrl(userProfileImageUrl));
            /*new Thread(){
                @Override
                public void run() {
                    usericon_inme.setImageBitmap(getBitmapFromUrl(userProfileImageUrl));
                }
            }.start();
*/

        }catch (Exception e){
            e.printStackTrace();
        }


    }
    private Bitmap getBitmapFromUrl(String urlString) {
        Bitmap bitmap;
        InputStream is = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            is = new BufferedInputStream(connection.getInputStream());
            bitmap = BitmapFactory.decodeStream(is);
            connection.disconnect();
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert is != null;
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public void initdata(){
        aboutmedata=new ArrayList<String>();
        String one=new String("Leothon");
        aboutmedata.add(one);
        String two=new String("Leothon");
        aboutmedata.add(two);
        String three=new String("Leothon");
        aboutmedata.add(three);
        String four=new String("Leothon");
        aboutmedata.add(four);
        String five=new String("Leothon");
        aboutmedata.add(five);
        String six=new String("Leothon");
        aboutmedata.add(six);
        String seven=new String("Leothon");
        aboutmedata.add(seven);
        String eight=new String("Leothon");
        aboutmedata.add(eight);
        String nine=new String("Leothon");
        aboutmedata.add(nine);
        String ten=new String("Leothon");
        aboutmedata.add(ten);

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
