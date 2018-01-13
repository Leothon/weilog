package com.example.a10483.weilog.Data;

/**
 * Created by 10483 on 2018/1/13.
 */

public class user {

    private String name;
    private String location;
    private String description;
    //private String Icon;
    private String follower;
    private String friends;
    private String status;
    //private boolean isfollow;
    //private boolean isfollowme;


    public user(String name,String location,String description,String follower,String friends,String status){
        this.name=name;
        this.description=description;
        this.location=location;
        this.follower=follower;
        this.friends=friends;
        this.status=status;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location=location;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public String getFollower(){
        return follower;
    }
    public void setFollower(String follower){
        this.follower=follower;
    }

    public String getFriends(){
        return friends;
    }
    public void setFriends(String friends){
        this.friends=friends;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }
}
