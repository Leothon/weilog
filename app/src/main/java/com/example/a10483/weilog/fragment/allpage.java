package com.example.a10483.weilog.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.a10483.weilog.Adapter.WeilogAdapter;
import com.example.a10483.weilog.Data.dataBean;
import com.example.a10483.weilog.R;
import com.example.a10483.weilog.utils.DownAsynctask;
import com.example.a10483.weilog.utils.GetJson;
import com.example.a10483.weilog.utils.UsualUtil;
import com.example.a10483.weilog.utils.ViewHolder;
import com.example.a10483.weilog.utils.getFile;
import com.example.a10483.weilog.writeWeilog;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class allpage extends Fragment{


    private Toolbar allpage_toolbar;
    private ImageView open_nav1;
    private ImageView search;
    private ListView allpage_listview;
    private FloatingActionButton cameraButton;
    private FloatingActionButton write_button;
    private ArrayList<dataBean> allpagedata;
    private WeilogAdapter mAdapter;
    private Oauth2AccessToken accessToken;
    private ExecutorService es;
    private final static String get_timeline_url="https://api.weibo.com/2/statuses/home_timeline.json";
    public allpage() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_allpage,container,false);
        allpage_listview=(ListView)view.findViewById(R.id.allpage_listview);
        allpage_listview.setVerticalScrollBarEnabled(false);
        //cameraButton=(FloatingActionButton)view.findViewById(R.id.camera_button);
        write_button=(FloatingActionButton)view.findViewById(R.id.write);
        //WeilogAdapter adapter=new WeilogAdapter(getActivity(),weilogdata);
        //allpage_listview.setAdapter(adapter);
        accessToken=AccessTokenKeeper.readAccessToken(getContext());
        String token= accessToken.getToken().toString();
        //initdata();
        //getJson();
        allpagedata=new ArrayList<>();//记得初始化，否则数据无法绑定
        allpage_listview.setAdapter(mAdapter=new WeilogAdapter(getActivity(),allpagedata,R.layout.weilogitem) {
                    @Override
                    public void convert(ViewHolder helper, Object item) {
                        allpagedata=this.getDatas();
                        dataBean db=allpagedata.get(getPosition());
                        setdata(helper,db);
                    }
                }

                    );

        es= Executors.newFixedThreadPool(1);
        new DownAsynctask(allpagedata,mAdapter,getContext()).executeOnExecutor(es,get_timeline_url+"?access_token="+token);
        allpage_listview.setDividerHeight(0);
        setListener();
        return view;
    }
    public void setdata(ViewHolder helper,dataBean db){
        String timetext= UsualUtil.transTime(db.getCreated_at());
        helper.setText(R.id.weilog_context,db.getText());
        helper.setCount(R.id.talk_button,db.getComments_count());
        helper.setCount(R.id.like_button,db.getAttitudes_count());
        helper.setCount(R.id.share_button,db.getReposts_count());
        helper.setText(R.id.weilog_time,timetext);
        helper.setText(R.id.from_device,UsualUtil.parserFrom(db.getSource()));
        //Log.d("allpage",db.getSource());

    }
    /*public void getJson(){
        new Thread(){
            public void run(){
                try{
                    String token= accessToken.getToken().toString();
                    String timelinejson = GetJson.getjson(get_timeline_url + "?access_token=" + token+"&count="+30);
                    Bundle bundle=new Bundle();
                    bundle.putString("timelinejson",timelinejson);
                    Message message=new Message();
                    message.what=1;
                    message.setData(bundle);
                    handler.sendMessage(message);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
    }*/


    /*public Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    String timeLineJson=msg.getData().getString("timelinejson");
                    settimelineData(timeLineJson);
            }
        }
    };*/


    /*public void initdata(){
        allpagedata=new ArrayList<String>();
        String one=new String("Leothon");
        allpagedata.add(one);
        String two=new String("Leothon");
        allpagedata.add(two);
        String three=new String("Leothon");
        allpagedata.add(three);
        String four=new String("Leothon");
        allpagedata.add(four);
        String five=new String("Leothon");
        allpagedata.add(five);
        String six=new String("Leothon");
        allpagedata.add(six);
        String seven=new String("Leothon");
        allpagedata.add(seven);
        String eight=new String("Leothon");
        allpagedata.add(eight);
        String nine=new String("Leothon");
        allpagedata.add(nine);
        String ten=new String("Leothon");
        allpagedata.add(ten);

    }*/
    public void setListener(){
        write_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),writeWeilog.class);
                startActivity(intent);
            }
        });

    }
}





