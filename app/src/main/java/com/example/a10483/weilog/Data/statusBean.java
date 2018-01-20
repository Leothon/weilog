package com.example.a10483.weilog.Data;

import java.util.ArrayList;

/**
 * Created by 10483 on 2017/6/5.
 */

public class statusBean {

    private ArrayList<dataBean> dataBeans;

    private String since_id;
    private String max_id;
    public String getSince_id(){
        return since_id;
    }

    public void setSince_id(String since_id){
        this.since_id=since_id;
    }

    public String getMax_id(){
        return max_id;
    }
    public void setMax_id(String max_id){
        this.max_id=max_id;
    }
    public void setDataBeans(ArrayList<dataBean> dataBeans){
        this.dataBeans=dataBeans;
    }

    public ArrayList<dataBean> getDataBeans(){
        return dataBeans;
    }


}

