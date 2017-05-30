package com.example.a10483.weilog.Data;

import android.media.Image;
import android.provider.MediaStore;

/**
 * Created by 10483 on 2017/5/30.
 */

public class Weilog {
    public String username;
    public String content;
    public Image  usericon;
    public Image image;
    public Image  shareimage;
    public MediaStore.Video video;
    public MediaStore.Video sharevideo;


    public String getContent() {
        return content;
    }
}
