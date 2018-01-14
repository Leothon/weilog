package com.example.a10483.weilog.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.a10483.weilog.Adapter.WeilogAdapter;
import com.example.a10483.weilog.R;
import com.example.a10483.weilog.utils.GetJson;
import com.example.a10483.weilog.utils.ViewHolder;
import com.example.a10483.weilog.writeWeilog;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

import java.util.ArrayList;
import java.util.List;

public class allpage extends Fragment{


    private Toolbar allpage_toolbar;
    private ImageView open_nav1;
    private ImageView search;
    private ListView allpage_listview;
    private FloatingActionButton cameraButton;
    private FloatingActionButton write_button;
    private ArrayList<String> allpagedata;
    private WeilogAdapter mAdapter;
    private Oauth2AccessToken accessToken;
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
        //cameraButton=(FloatingActionButton)view.findViewById(R.id.camera_button);
        write_button=(FloatingActionButton)view.findViewById(R.id.write);
        //WeilogAdapter adapter=new WeilogAdapter(getActivity(),weilogdata);
        //allpage_listview.setAdapter(adapter);
        accessToken=AccessTokenKeeper.readAccessToken(getContext());
        initdata();
        //getJson();
        allpage_listview.setAdapter(mAdapter=new WeilogAdapter<String>(
                getActivity(),allpagedata,R.layout.weilogitem) {
                    @Override
                    public void convert(ViewHolder helper, String item) {
                        helper.setText(R.id.user_name,"Leothon");
                    }
                }

                    );

        allpage_listview.setDividerHeight(0);
        setListener();
        return view;
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

    public void settimelineData(String str){

    }
    public void initdata(){
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

    }
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





