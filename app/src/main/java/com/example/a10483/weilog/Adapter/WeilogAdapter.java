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
import com.example.a10483.weilog.utils.ViewHolder;

import java.util.Date;
import java.util.List;
import java.util.zip.Inflater;

//通用的Adapter，使用时只需要引用内部类即可调用，参数为上下文，数据List，Item的Id。
public abstract class WeilogAdapter<T> extends BaseAdapter {

    protected LayoutInflater inflater;
    protected Context mContext;
    protected List<T> weilogdatas;
    protected final int mItemLayoutId;
    public WeilogAdapter(Context context, List<T> weilogdata ,int ItemLayoutId){
        inflater= LayoutInflater.from(context);
        this.mContext=context;
        weilogdatas=weilogdata;
        this.mItemLayoutId=ItemLayoutId;

    }
    @Override
    public int getCount() {
        return weilogdatas.size();

    }

    /*@Override
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
    }*/


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public T getItem(int position) {
        return weilogdatas.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder=getViewHolder(position,convertView,parent);
        convert(viewHolder,getItem(position));
        return viewHolder.getConvertView();
    }

    public abstract void convert(ViewHolder helper,T item);

    private ViewHolder getViewHolder(int position,View convertView,ViewGroup parent){
        return ViewHolder.get(mContext,convertView,parent,mItemLayoutId,position);
    }
}
