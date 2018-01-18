package com.example.a10483.weilog.Data;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by 10483 on 2018/1/14.
 */

public class dataBean {

    private String created_at;
    private String text;
    private int  attitudes_count;
    private int  comments_count;
    private int  reposts_count;
    private user users;
    private String source;
    private ArrayList<picUrls> pics_urls;

    private dataBean retweeted_status;

     /*public dataBean(String created_at, String text,
                      String attitudes_count, String comments_count, String reposts_count) {
        this.created_at = created_at;
        this.text = text;
        this.attitudes_count = attitudes_count;
        this.comments_count = comments_count;
        this.reposts_count = reposts_count;
    }*/

    public dataBean getRetweeted_status(){
        return retweeted_status;
    }
    public void setRetweeted_status(dataBean retweeted_status){
        this.retweeted_status=retweeted_status;
    }
    public ArrayList<picUrls> getPics_urls(){
        return pics_urls;
    }
    public void setPics_urls(ArrayList<picUrls> pics_urls){
        this.pics_urls=pics_urls;
    }
    public String getSource(){
        return source;
    }
    public void setSource(String source){
        this.source=source;
    }
    public user getUsers(){
        return users;
    }
    public void setUsers(user users){
        this.users=users;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAttitudes_count() {
        return attitudes_count;
    }

    public void setAttitudes_count(int attitudes_count) {
        this.attitudes_count = attitudes_count;
    }

    public int  getComments_count() {
        return comments_count;
    }

    public void setComments_count(int  comments_count) {
        this.comments_count = comments_count;
    }

    public int  getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(int  reposts_count){
        this.reposts_count=reposts_count;
    }




}
