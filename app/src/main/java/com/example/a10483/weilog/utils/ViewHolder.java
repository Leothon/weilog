package com.example.a10483.weilog.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a10483.weilog.R;


/**
 * Created by 10483 on 2017/6/5.
 */
//抽象出来的ViewHolder
public class ViewHolder extends RecyclerView.ViewHolder{
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;
    private Context context;


    /*public View getConvertView(){
        return mConvertView;
    }*/

    public ViewHolder(Context context,View itemView,ViewGroup parent,int position){
        super(itemView);
        this.context=context;
        this.mConvertView=itemView;
        this.mPosition=position;
        mViews=new SparseArray<>();
    }
    /*public ViewHolder(Context context, ViewGroup parent,int layoutId,int position){
        this.mViews=new SparseArray<View>();
        this.mPosition=position;
        this.mConvertView= LayoutInflater.from(context).inflate(layoutId,parent,false);
        this.mConvertView.setTag(this);
        this.context=context;
    }*/

    public static ViewHolder get(Context context,ViewGroup parent,int layoutId,int postion){
        /*if (convertView==null){
            return new ViewHolder(context,parent,layoutId,postion);
        }else{
            ViewHolder holder=(ViewHolder)convertView.getTag();
            holder.mPosition=postion;
            return holder;
        }*/
        View itemView=LayoutInflater.from(context).inflate(layoutId,parent,false);
        ViewHolder holder=new ViewHolder(context,itemView,parent,postion);
        return holder;
    }

    public <T extends View>T getView(int viewId){
        View view=mViews.get(viewId);
        if (view==null){
            view=itemView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    /*public View getmConvertView(){
        return mConvertView;
    }*/

    public void setOnItemClickListener(View.OnClickListener listener){
        itemView.setOnClickListener(listener);
    }
    public void setOnItemLongClickListener(View.OnLongClickListener listener){
        itemView.setOnLongClickListener(listener);
    }
    //设置文字的通用方法
    public  ViewHolder setText(int viewId, String text)
    {
        TextView tv = getView(viewId);
        /*SpannableString spannableString=textviewemojiorhtmltrans.getEmotionContent(context,text);
        Log.d("ViewHolder","数据是"+spannableString);
        tv.setText(spannableString);*/
        tv.setText(text);
        tv.setAutoLinkMask(Linkify.WEB_URLS);

        return this;
    }

    public ViewHolder setCount(int viewId,int count){
        TextView textcount=getView(viewId);
        if(count>10000){
            textcount.setText(""+count/10000+"万");
        }else{
            textcount.setText(""+count);
        }
        //单纯用count做参数，setText会把count当作ResourceId使用导致没有找到错误
        return this;
    }

    //设置本地图片的通用方法

    public ViewHolder setImageResource(int viewId,int drawableId){
        ImageView view =getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    public ViewHolder setWeightVisible(int viewId,int bool){//第二个参数是表示该控件三种状态：0-gone，1-visible，2-invisible
        View view=getView(viewId);
        if(bool==0){
            view.setVisibility(View.GONE);
        }else if(bool==1){
            view.setVisibility(View.VISIBLE);
        }else{
            view.setVisibility(View.INVISIBLE);
        }
        return this;

    }

    public ViewHolder setImageUrl(int viewId, String url){
        final ImageView view=getView(viewId);
        view.setTag(url);
        view.setImageResource(R.drawable.ic_launcher);

        AsyncImageLoader asyncImageLoader=new AsyncImageLoader();


        if(view.getTag()!=null&&view.getTag().equals(url)){
            Drawable cacheImage=asyncImageLoader.loadDrawable(url, new AsyncImageLoader.ImageCallback() {
                @Override
                public void imageLoaded(Drawable imageDrawable) {
                    view.setImageDrawable(imageDrawable);
                }
            });

            if(cacheImage!=null){
                view.setImageDrawable(cacheImage);
            }

        }

        /*if(cacheImage!=null){
            view.setImageDrawable(cacheImage);
        }*/
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
