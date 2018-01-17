package com.example.a10483.weilog.utils;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.logging.LogRecord;

/**
 * Created by 10483 on 2018/1/17.
 */

public class AsyncImageLoader {

    //图片缓存设置，将图片缓存入一个map中

    public Map<String,SoftReference<Drawable>> imageCache=new HashMap<String,SoftReference<Drawable>>();

    private ExecutorService executorService= Executors.newFixedThreadPool(5);

    private final Handler handler=new Handler();
    /*public Drawable loadDrawable(final String imageUrl){


        if(imageCache.containsKey(imageUrl)){
            SoftReference<Drawable> softReference=imageCache.get(imageUrl);
            if(softReference.get()!=null){
                return softReference.get();
            }
        }


        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    final Drawable drawable=loadImageFromUrl(imageUrl);
                    imageCache.put(imageUrl,new SoftReference<Drawable>(drawable));
                    loadDrawable(imageUrl);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //loadDrawable(imageUrl);//此处递归，在主线程重新调用该方法，若缓存中有则递归结束。
                        }
                    });
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        });
        return null;
    }*/

    public Drawable loadDrawable(final String imageUrl,final ImageCallback callback){

        if(imageCache.containsKey(imageUrl)){
            SoftReference<Drawable> softReference=imageCache.get(imageUrl);
            if(softReference.get()!=null){
                return softReference.get();
            }
        }

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    final Drawable drawable=loadImageFromUrl(imageUrl);
                    imageCache.put(imageUrl,new SoftReference<Drawable>(drawable));
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.imageLoaded(drawable);
                        }
                    });
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        });
        return null;
    }
    //从网络下载图片
    protected Drawable loadImageFromUrl(String imageurl) {

        try{
            return Drawable.createFromStream(new URL(imageurl).openStream(),null);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public interface ImageCallback{
        public void imageLoaded(Drawable imageDrawable);
    }

}
