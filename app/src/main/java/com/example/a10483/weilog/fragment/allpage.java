package com.example.a10483.weilog.fragment;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.example.a10483.weilog.Data.picUrls;
import com.example.a10483.weilog.Data.user;
import com.example.a10483.weilog.R;
import com.example.a10483.weilog.utils.AsyncImageLoader;
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
        allpage_listview.setDividerHeight(3);
        setListener();
        return view;
    }
    public void setdata(ViewHolder helper,dataBean db){
        user us=db.getUsers();
        ArrayList<picUrls> picUrlsdata=db.getPics_urls();
        dataBean redb=db.getRetweeted_status();

        int[] weightId=new int[9];
        weightId[0]=R.id.image_in_context1;
        weightId[1]=R.id.image_in_context2;
        weightId[2]=R.id.image_in_context3;
        weightId[3]=R.id.image_in_context4;
        weightId[4]=R.id.image_in_context5;
        weightId[5]=R.id.image_in_context6;
        weightId[6]=R.id.image_in_context7;
        weightId[7]=R.id.image_in_context8;
        weightId[8]=R.id.image_in_context9;

        int[] reweightId=new int[9];
        reweightId[0]=R.id.re_image_in_context1;
        reweightId[1]=R.id.re_image_in_context2;
        reweightId[2]=R.id.re_image_in_context3;
        reweightId[3]=R.id.re_image_in_context4;
        reweightId[4]=R.id.re_image_in_context5;
        reweightId[5]=R.id.re_image_in_context6;
        reweightId[6]=R.id.re_image_in_context7;
        reweightId[7]=R.id.re_image_in_context8;
        reweightId[8]=R.id.re_image_in_context9;

        if(redb!=null){
            helper.setWeightVisible(R.id.share_layout,1);
            user reus=db.getRetweeted_status().getUsers();
            ArrayList<picUrls> repicUrlsdata=db.getRetweeted_status().getPics_urls();
            helper.setText(R.id.shareUsername,"@"+reus.getName());
            helper.setText(R.id.share_context,redb.getText());
            if(repicUrlsdata!=null){
                setreAllWeightGone(helper);
                for(int j=0;j<repicUrlsdata.size();j++){
                    helper.setImageUrl(reweightId[j],repicUrlsdata.get(j).getThumbnail_pic()).setWeightVisible(reweightId[j],1);
                }
            }else{
                setreAllWeightGone(helper);
            }
        }else{
            helper.setWeightVisible(R.id.share_layout,0);
        }

        if(picUrlsdata!=null){
            setAllWeightGone(helper);
            for(int i=0;i<picUrlsdata.size();i++){//设置图片的控件显示，否则不显示
                helper.setImageUrl(weightId[i],picUrlsdata.get(i).getThumbnail_pic()).setWeightVisible(weightId[i],1);
                //Log.d("allpage",picUrlsdata.get(i).getThumbnail_pic()+" "+i);
            }


        }else{
            setAllWeightGone(helper);
            //helper.setWeightVisible(R.id.pic_layout,0);
            //Log.d("allpage","数据空白");
        }
        //Log.d("allpage","pic的 长度是"+picUrlsdata.size());

        /*picUrls pu1=picUrlsdata.get(0);
        picUrls pu2=picUrlsdata.get(1);
        picUrls pu3=picUrlsdata.get(2);
        Log.d("allpage","图片链接是"+pu1);
        Log.d("allpage","图片链接是"+pu2);
        Log.d("allpage","图片链接是"+pu3);*/
        helper.setImageUrl(R.id.user_head,us.getProfile_image_url());
        helper.setText(R.id.user_name,us.getName());
        String timetext= UsualUtil.transTime(db.getCreated_at());
        helper.setText(R.id.weilog_context,db.getText());
        helper.setCount(R.id.talk_button,db.getComments_count());
        helper.setCount(R.id.like_button,db.getAttitudes_count());
        helper.setCount(R.id.share_button,db.getReposts_count());
        helper.setText(R.id.weilog_time,timetext);
        helper.setText(R.id.from_device,UsualUtil.parserFrom(db.getSource()));
        //Log.d("allpage",db.getSource());



    }

    public void setAllWeightGone(ViewHolder helper){
        helper.setWeightVisible(R.id.image_in_context1,0);
        helper.setWeightVisible(R.id.image_in_context2,0);
        helper.setWeightVisible(R.id.image_in_context3,0);
        helper.setWeightVisible(R.id.image_in_context4,0);
        helper.setWeightVisible(R.id.image_in_context5,0);
        helper.setWeightVisible(R.id.image_in_context6,0);
        helper.setWeightVisible(R.id.image_in_context7,0);
        helper.setWeightVisible(R.id.image_in_context8,0);
        helper.setWeightVisible(R.id.image_in_context9,0);

    }
    public void setreAllWeightGone(ViewHolder helper){
        helper.setWeightVisible(R.id.re_image_in_context1,0);
        helper.setWeightVisible(R.id.re_image_in_context2,0);
        helper.setWeightVisible(R.id.re_image_in_context3,0);
        helper.setWeightVisible(R.id.re_image_in_context4,0);
        helper.setWeightVisible(R.id.re_image_in_context5,0);
        helper.setWeightVisible(R.id.re_image_in_context6,0);
        helper.setWeightVisible(R.id.re_image_in_context7,0);
        helper.setWeightVisible(R.id.re_image_in_context8,0);
        helper.setWeightVisible(R.id.re_image_in_context9,0);

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





