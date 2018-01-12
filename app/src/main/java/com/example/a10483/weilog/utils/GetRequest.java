package com.example.a10483.weilog.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a10483.weilog.MyApplication;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by 10483 on 2018/1/12.
 */

public class GetRequest {


    String requestJson=null;
    public String transJson(JSONObject jsonObject){
        String requestJson=jsonObject.toString();
        return requestJson;
    }

    public String getRequest(String url){

        RequestQueue queue1= MyApplication.requestQueue;
        JsonObjectRequest getrequest=new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                requestJson=jsonObject.toString();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        queue1.add(getrequest);
        return requestJson;
    }
}
