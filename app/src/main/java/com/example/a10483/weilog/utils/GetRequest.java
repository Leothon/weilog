package com.example.a10483.weilog.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.util.Log;

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
import com.example.a10483.weilog.Data.user;
import com.example.a10483.weilog.MyApplication;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by 10483 on 2018/1/12.
 */

public class GetRequest {


    public  static void  getRequest(String url){


        RequestQueue queue= MyApplication.requestQueue;
        final JsonObjectRequest getrequest=new JsonObjectRequest(url,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.print("Error");
            }
        });

        queue.add(getrequest);
    }
}
