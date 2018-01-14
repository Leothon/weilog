package com.example.a10483.weilog.Data;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by 10483 on 2018/1/14.
 */

public class dataBean {

    private String created_at;
    private String text;
    private String attitudes_count;
    private String comments_count;
    private String reposts_count;
    private ArrayList<user> users;
     /*public dataBean(String created_at, String text,
                      String attitudes_count, String comments_count, String reposts_count) {
        this.created_at = created_at;
        this.text = text;
        this.attitudes_count = attitudes_count;
        this.comments_count = comments_count;
        this.reposts_count = reposts_count;
    }*/

    public ArrayList<user> getUsers(){
        return users;
    }
    public void setUsers(ArrayList<user> users){
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

    public String getAttitudes_count() {
        return attitudes_count;
    }

    public void setAttitudes_count(String attitudes_count) {
        this.attitudes_count = attitudes_count;
    }

    public String getComments_count() {
        return comments_count;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }

    public String getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(String reposts_count){
        this.reposts_count=reposts_count;
    }




}
