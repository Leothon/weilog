package com.example.a10483.weilog.utils;

import com.example.a10483.weilog.Data.statusBean;
import com.google.gson.Gson;

/**
 * Created by 10483 on 2017/9/16.
 */
//解析获得的json数据
public class ParseJson {

    /**
     * *在这个方法中，要根据传入的String类型的json数据进行解析，解析为文字，图片，视频等等，并返回
     * 返回之后，要在每个页面写一个初始化数据的方法，让数据导入每一个控件之中。
     * 难点1、json解析的方法
     * 难点2、数据返回的方法
     * 难点3、Adapter重新修改编写
     */

    public static statusBean parseJson(String json){
        Gson gson=new Gson();
        statusBean sb=gson.fromJson(json,statusBean.class);
        return sb;
    }
}
