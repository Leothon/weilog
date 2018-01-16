package com.example.a10483.weilog.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.a10483.weilog.Adapter.WeilogAdapter;
import com.example.a10483.weilog.Data.dataBean;
import com.example.a10483.weilog.Data.statusBean;
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
            //statusBean sb=ParseJson.parseJson(jsonString);
            statusBean sb=gson.fromJson(jsonString,statusBean.class);

            JsonParser parser=new JsonParser();
            JsonObject jsonObject=parser.parse(jsonString).getAsJsonObject();
            JsonArray jsonArray=jsonObject.getAsJsonArray("statuses");//将每一条分成单个数组

            //getFile.getfile(jsonArray.toString());
            //Log.d("DownAsynctask",jsonArray.toString());
            for(int i=0;i<jsonArray.size();i++){
                JsonElement el=jsonArray.get(i);//获取到每一条微博的对象
                dataBean db=gson.fromJson(el,dataBean.class);
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
