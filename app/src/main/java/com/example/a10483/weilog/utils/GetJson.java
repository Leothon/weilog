package com.example.a10483.weilog.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 10483 on 2017/9/16.
 */
//这个类专门用来获取json数据
public class GetJson {
    public static String getjson(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        if (connection.getResponseCode() == 200) {
            InputStream in = connection.getInputStream();
            byte[] data = StreamTool.read(in);
            String json = new String(data);
            return json;
        }
        return null;
    }
}
