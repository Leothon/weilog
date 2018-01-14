package com.example.a10483.weilog.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by 10483 on 2017/6/5.
 */
//抽象出来的ViewHolder
public class ViewHolder {
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;

    public View getConvertView(){
        return mConvertView;
    }

    public ViewHolder(Context context, ViewGroup parent,int layoutId,int position){
        this.mViews=new SparseArray<View>();
        this.mPosition=position;
        this.mConvertView= LayoutInflater.from(context).inflate(layoutId,parent,false);
        this.mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context,View convertView,ViewGroup parent,int layoutId,int postion){
        if (convertView==null){
            return new ViewHolder(context,parent,layoutId,postion);
        }else{
            ViewHolder holder=(ViewHolder)convertView.getTag();
            holder.mPosition=postion;
            return holder;
        }
    }

    public <T extends View>T getView(int viewId){
        View view=mViews.get(viewId);
        if (view==null){
            view=mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    public View getmConvertView(){
        return mConvertView;
    }
    //设置文字的通用方法
    public  ViewHolder setText(int viewId, String text)
    {
        TextView tv = getView(viewId);
        tv.setText(text);

        return this;
    }

    //设置本地图片的通用方法

    public ViewHolder setImageResource(int viewId,int drawableId){
        ImageView view =getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }
    //设置网络图片的通用方法
    public ViewHolder setImageBitmap(int viewId, Bitmap bm)
    {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }


    /*public ViewHolder setImageByUrl(int viewId, String url)
    {
        ImageLoader.getInstance(3, Type.LIFO).loadImage(url,
                (ImageView) getView(viewId));
        return this;
    }  */
    //设置视频的通用方法

}
