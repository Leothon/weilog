package com.example.a10483.weilog.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.a10483.weilog.Adapter.WeilogAdapter;
import com.example.a10483.weilog.Data.dataBean;
import com.example.a10483.weilog.Data.picUrls;
import com.example.a10483.weilog.Data.statusBean;
import com.example.a10483.weilog.Data.user;
import com.example.a10483.weilog.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10483 on 2018/1/14.
 */

public class DownAsynctask extends AsyncTask<String,Void,byte[]> {
    //ArrayList<statusBean> data;
    ArrayList<dataBean> dataBeans;
    WeilogAdapter adapter;
    Context context;

    public DownAsynctask(ArrayList<dataBean> data, WeilogAdapter adapter, Context context){
        super();
        this.dataBeans=data;
        this.adapter=adapter;
        this.context=context;
    }

    @Override
    protected byte[] doInBackground(String... strings) {
        return GetJson.getjson(strings[0]);
    }

    @Override
    protected void onPostExecute(byte[] bytes) {
        super.onPostExecute(bytes);
        if(bytes!=null){
            Gson gson=new Gson();
            String jsonString=new String(bytes);
            //getFile.getfile(jsonString);
            statusBean sb=gson.fromJson(jsonString,statusBean.class);

            JsonParser parser=new JsonParser();
            JsonObject jsonObject=parser.parse(jsonString).getAsJsonObject();
            JsonArray jsonArray=jsonObject.getAsJsonArray("statuses");//将每一条分成单个数组

            //getFile.getfile(jsonArray.toString());
            //Log.d("DownAsynctask",jsonArray.toString());

            for(int i=0;i<jsonArray.size();i++){//该循环是逐条获取微博信息
                ArrayList<picUrls> pus=new ArrayList<>();
                ArrayList<picUrls> repus=new ArrayList<>();//初始化一定要放在里面
                JsonElement el=jsonArray.get(i);//获取到每一条微博的对象
                dataBean db=gson.fromJson(el,dataBean.class);
                JsonObject singleweibojsonobject=el.getAsJsonObject();
                JsonObject userjsonobject=singleweibojsonobject.getAsJsonObject("user");
                user us=gson.fromJson(userjsonobject,user.class);//用户信息不是数组所以直接解析加入
                JsonArray picjsonarray=singleweibojsonobject.getAsJsonArray("pic_urls");

                JsonObject retweeted_statusjsonobject=singleweibojsonobject.getAsJsonObject("retweeted_status");
                if(retweeted_statusjsonobject!=null){
                    dataBean redb=gson.fromJson(retweeted_statusjsonobject,dataBean.class);
                    JsonObject reuserjsonobject=retweeted_statusjsonobject.getAsJsonObject("user");
                    user reus=gson.fromJson(reuserjsonobject,user.class);
                    JsonArray repicjsonarray=retweeted_statusjsonobject.getAsJsonArray("pic_urls");
                    if(repicjsonarray.size()!=0){
                        for(int k=0;k<repicjsonarray.size();k++){
                            JsonElement repicjsonelement=repicjsonarray.get(k);
                            picUrls repu=gson.fromJson(repicjsonelement,picUrls.class);
                            repus.add(repu);
                        }
                    }
                    redb.setPics_urls(repus);
                    redb.setUsers(reus);
                    db.setRetweeted_status(redb);
                }

                //Log.d("allpage","图片数组的长度"+picjsonarray.size());
                if(picjsonarray.size()!=0){
                    for(int j=0;j<picjsonarray.size();j++){//该循环是逐条获取图片链接
                        JsonElement picjsonelement=picjsonarray.get(j);
                        picUrls pu=gson.fromJson(picjsonelement,picUrls.class);
                        //Log.d("allpage","添加数组"+pu.getThumbnail_pic()+j);
                        pus.add(pu);//获取到每条微博中的图片链接，把他添加到一个数组中
                    }
                }else{
                    pus=null;
                }
                /*
                for(int j=0;j<picjsonarray.size();j++){//该循环是逐条获取图片链接
                    JsonElement picjsonelement=picjsonarray.get(j);
                    picUrls pu=gson.fromJson(picjsonelement,picUrls.class);
                    //Log.d("allpage","添加数组"+pu.getThumbnail_pic()+j);
                    pus.add(pu);//获取到每条微博中的图片链接，把他添加到一个数组中
                }*/

                db.setPics_urls(pus);//把数组添加到统一的databean中便于处理
                db.setUsers(us);
                dataBeans.add(db);
            }
            adapter.notifyDataSetChanged();

            /*if(sb.data==null){
                return;
            }*/
            //Log.d("DownAsynctask",sb.data.toString()+"datdaaaaaaaaaa");
            //data.addAll(sb.data);
            //adapter.notifyDataSetChanged();//刷新数据

        }else{
            Toast.makeText(context,"网络异常",Toast.LENGTH_SHORT).show();
        }

    }


    public static void updateUI(ViewHolder helper){
        helper.setText(R.id.user_name,"Context");
        helper.setText(R.id.weilog_context,"dauobfaubfoaibfoahfoalibfnia");
        //for(int i=0;i<)
    }
}
