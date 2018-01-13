package com.example.a10483.weilog.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by 10483 on 2018/1/13.
 */

public class getFile {

    public static void getfile(String string){

        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            String sdPath=Environment.getExternalStorageDirectory().getAbsolutePath();
            String filePath="";
            File file=new File(Environment.getExternalStorageDirectory(),"json.txt");
            if(file.exists()){
                filePath=file.getAbsolutePath();
            }


            try {
                BufferedWriter bf=new BufferedWriter(new FileWriter(file,true));
                bf.write(string);
                bf.flush();
                bf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }



        }

    }
}
