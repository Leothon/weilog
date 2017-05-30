package com.example.a10483.weilog.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.a10483.weilog.Data.Weilog;
import com.example.a10483.weilog.R;

import java.util.Date;
import java.util.List;
import java.util.zip.Inflater;


public class WeilogAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private List<Weilog> weilogdatas;
    public WeilogAdapter(Context context, List<Weilog> weilogdata ){
        inflater= LayoutInflater.from(context);
        weilogdatas=weilogdata;

    }
    @Override
    public int getCount() {
        //return weilogdatas.size();
        return 10;
    }

    @Override
    public View getView(int position, View contertView, ViewGroup parent) {

        ViewHolder holder=null;

        if (contertView==null){
            holder=new ViewHolder();
            contertView=inflater.inflate(R.layout.weilogitem,null);
            holder.user_head=(ImageView)contertView.findViewById(R.id.user_head);
            holder.user_name=(TextView)contertView.findViewById(R.id.user_name);
            holder.user_v=(ImageView)contertView.findViewById(R.id.user_v);
            holder.weilog_time=(TextView)contertView.findViewById(R.id.weilog_time);
            holder.weilog_context=(TextView)contertView.findViewById(R.id.weilog_context);
            holder.image_in_context=(ImageView)contertView.findViewById(R.id.image_in_context);
            holder.video_in_context=(VideoView)contertView.findViewById(R.id.video_in_context);
            holder.share_layout=(LinearLayout)contertView.findViewById(R.id.share_layout);
            holder.share_context=(TextView)contertView.findViewById(R.id.share_context);
            holder.image_in_sharecontext=(ImageView)contertView.findViewById(R.id.image_in_sharecontext);
            holder.video_in_sharecontext=(VideoView)contertView.findViewById(R.id.video_in_sharecontext);
            holder.from_deivce=(TextView)contertView.findViewById(R.id.from_device);
            holder.share_button=(TextView)contertView.findViewById(R.id.share_button);
            holder.talk_button=(TextView)contertView.findViewById(R.id.talk_button);
            holder.like_button=(TextView)contertView.findViewById(R.id.like_button);
            contertView.setTag(holder);
        }else{
            holder=(ViewHolder)contertView.getTag();
        }

        return contertView;
    }
    public final class ViewHolder{
        public ImageView user_head;
        public TextView user_name;
        public ImageView user_v;
        public TextView weilog_time;
        public TextView weilog_context;
        public ImageView image_in_context;
        public VideoView video_in_context;
        public LinearLayout share_layout;
        public TextView share_context;
        public ImageView image_in_sharecontext;
        public VideoView video_in_sharecontext;
        public TextView from_deivce;
        public TextView share_button;
        public TextView talk_button;
        public TextView like_button;
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }

}
