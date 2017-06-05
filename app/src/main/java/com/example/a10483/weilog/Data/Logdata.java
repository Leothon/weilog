package com.example.a10483.weilog.Data;

/**
 * Created by 10483 on 2017/6/5.
 */

public class Logdata {

        private String username;
        private String content;
        private String fromdevice;
        private String like;
        private String talk;
        private String time;

        public Logdata(String username,String content,String fromdevice,
                           String like,String talk,String time){
            this.username=username;
            this.content=content;
            this.fromdevice=fromdevice;
            this.like=like;
            this.talk=talk;
            this.time=time;
        }

        public String getUsername(){
            return username;
        }
        public void setUsername(String username){
            this.username=username;
        }
        public String getContent(){
            return content;
        }
        public void setContent(String content){
            this.content=content;
        }
        public String getfromdevice(){
            return fromdevice;
        }
        public void setfromdevice(String fromdevice){
            this.fromdevice=fromdevice;
        }
        public String getlike(){
            return like;
        }
        public void setlike(String like){
            this.like=like;
        }
        public String gettalk(){
            return talk;
        }
        public void settalk(String talk){
            this.talk=talk;
        }
        public String getTime(){
            return time;
        }
        public void setTime(String time){
            this.time=time;
        }
    }

