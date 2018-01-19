package com.example.a10483.weilog.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

import com.example.a10483.weilog.Data.emotionbean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 10483 on 2018/1/19.
 */

public class EmotionUtils {
    public  Map<String,Bitmap> emotion=new HashMap<>();

    private final static String get_emotion_url="https://api.weibo.com/2/emotions.json";
    private Oauth2AccessToken oauth2AccessToken;
    private Context context;

    public EmotionUtils(Context context){
        this.context=context;
    }


    class emotionAsynctask extends AsyncTask<String,Void,byte[]> {


        @Override
        protected byte[] doInBackground(String... strings) {

            return GetJson.getjson(strings[0]);
        }

        @Override
        protected void onPostExecute(byte[] bytes) {
            super.onPostExecute(bytes);
            if(bytes!=null){

                String jsonString=new String(bytes);
                try{
                    JSONArray emotionarray=new JSONArray(jsonString);

                    if(emotionarray.length()!=0){
                        for(int i=0;i<emotionarray.length();i++){
                            /*JsonElement jsonElement=emotionarray.get(i);
                            final emotionbean eb=gson.fromJson(jsonElement,emotionbean.class);*/
                            final emotionbean eb=new emotionbean();
                            JSONObject jsonObject=emotionarray.getJSONObject(i);
                            String phrase=jsonObject.getString("phrase");
                            String url=jsonObject.getString("url");
                            eb.setPhrase(phrase);
                            eb.setUrl(url);
                            AsyncImageLoader asyncImageLoader=new AsyncImageLoader();
                            asyncImageLoader.loadDrawable(eb.getUrl(), new AsyncImageLoader.ImageCallback() {
                                @Override
                                public void imageLoaded(Drawable imageDrawable) {
                                    Resources res=context.getResources();
                                    BitmapDrawable bitmapDrawable=(BitmapDrawable)imageDrawable;
                                    Bitmap bitmap=bitmapDrawable.getBitmap();
                                    emotion.put(eb.getPhrase(),bitmap);
                                }
                            });
                        }

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }



            }

        }
    }


    public  Bitmap getImgByName(String key){

        oauth2AccessToken= AccessTokenKeeper.readAccessToken(context);
        String token=oauth2AccessToken.getToken().toString();
        new emotionAsynctask().execute(get_emotion_url+"?access_token="+token);
        Bitmap bitmap=emotion.get(key);
        return bitmap;
    }
}
