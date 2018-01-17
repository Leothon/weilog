package com.example.a10483.weilog.Data;

/**
 * Created by 10483 on 2018/1/13.
 */

public class user {

    private String name;
    private String screen_name;
    private String location;
    private String description;
    //private String Icon;
    private int  followers_count;
    private int  friends_count;
    private int statuses_count;
    private int favourites_count;
    private String created_at;
    private boolean following;

    private String profile_image_url;

    //private boolean isfollow;
    //private boolean isfollowme;


    /*public user(String name,String location,String description,String follower,String friends,String status){
        this.name=name;
        this.description=description;
        this.location=location;
        this.follower=follower;
        this.friends=friends;
        this.status=status;
    }*/

    public  String getProfile_image_url(){
        return profile_image_url;
    }
    public void setProfile_image_url(String profile_image_url){
        this.profile_image_url=profile_image_url;
    }
    public boolean isFollowing(){
        return true;
    }
    public void setFollowing(boolean following){
        this.following=following;
    }
    public String getCreated_at(){
        return created_at;
    }
    public void setCreated_at(String created_at){
        this.created_at=created_at;
    }
    public int getFavourites_count(){
        return favourites_count;
    }
    public void setFavourites_count(int favourites_count){
        this.favourites_count=favourites_count;
    }
    public int getStatuses_count(){
        return statuses_count;
    }
    public void setStatuses_count(int statuses_count){
        this.statuses_count=statuses_count;
    }
    public int getFriends_count(){
        return friends_count;
    }
    public void setFriends_count(int friends_count){
        this.friends_count=friends_count;
    }
    public int getFollowers_count(){
        return followers_count;
    }
    public void setFollowers_count(int followers_count){
        this.followers_count=followers_count;
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getScreen_name(){
        return screen_name;
    }
    public void setScreen_name(String screen_name){
        this.screen_name=screen_name;
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


}
