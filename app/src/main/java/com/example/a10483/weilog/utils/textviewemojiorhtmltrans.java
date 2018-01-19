package com.example.a10483.weilog.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 10483 on 2018/1/19.
 */

public class textviewemojiorhtmltrans {
    public static SpannableString getEmotionContent(final Context context, final TextView tv,String resource){
        SpannableString spannableString=new SpannableString(resource);
        Resources res=context.getResources();

        String regexEmotion="\\[([\u4e00-\u9fa5\\w])+\\]";

        Pattern patternEmotion=Pattern.compile(regexEmotion);
        Matcher matcherEmotion=patternEmotion.matcher(spannableString);

        while (matcherEmotion.find()){
            String key=matcherEmotion.group();
            int start=matcherEmotion.start();
            //Integer imgRes=EmotionUtils.getImgByName(key);
            Bitmap bitmap=new EmotionUtils(context).getImgByName(key);
            if(bitmap!=null){
                int size=(int)tv.getTextSize();
                //Bitmap bitmap= BitmapFactory.decodeResource(res,imgRes);
                Bitmap scaleBitmap=Bitmap.createScaledBitmap(bitmap,size,size,true);
                ImageSpan span=new ImageSpan(context,scaleBitmap);
                spannableString.setSpan(span,start,start+key.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return spannableString;

    }
}
