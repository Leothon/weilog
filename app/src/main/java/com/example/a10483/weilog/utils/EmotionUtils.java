package com.example.a10483.weilog.utils;

import android.graphics.drawable.Drawable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 10483 on 2018/1/19.
 */

public class EmotionUtils {
    public static Map<String,Drawable> emotion=new HashMap<>();


    public static Drawable getImgByName(String key){

        Drawable drawable=emotion.get(key);
        return drawable;
    }
}
