package com.example.a10483.weilog.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.example.a10483.weilog.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 10483 on 2018/1/19.
 */

public class textviewemojiorhtmltrans {
    public static SpannableString getEmotionContent(final Context context,String resource){
        SpannableString spannableString=new SpannableString(resource);
        Resources res=context.getResources();

        String regexEmotion="\\[[^\\[\\]]*\\]";

        Pattern patternEmotion=Pattern.compile(regexEmotion);
        Matcher matcherEmotion=patternEmotion.matcher(spannableString);

        while (matcherEmotion.find()){
            String key=matcherEmotion.group();
            int start=matcherEmotion.start();
            //Integer imgRes=EmotionUtils.getImgByName(key);
            Drawable drawable=EmotionUtils.getImgByName(key);
            if(drawable!=null){
                //int size=(int)tv.getTextSize();
                //Bitmap bitmap= BitmapFactory.decodeResource(res,imgRes);
                //Bitmap scaleBitmap=Bitmap.createScaledBitmap(bitmap,size,size,true);
                ImageSpan span=new ImageSpan(drawable);
                spannableString.setSpan(span,start,start+key.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return spannableString;

    }
}
