package com.example.a10483.weilog.utils;

import android.content.Context;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
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

        String filePath = null;

        boolean hasSDCard =Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);

        if (hasSDCard) {

            filePath =Environment.getExternalStorageDirectory().toString() + File.separator +"json.txt";

        } else

            filePath =Environment.getDownloadCacheDirectory().toString() + File.separator +"json.txt";



        try {

            File file = new File(filePath);

            if (!file.exists()) {

                File dir = new File(file.getParent());

                dir.mkdirs();

                file.createNewFile();

            }

            FileOutputStream outStream = new FileOutputStream(file);

            outStream.write(string.getBytes());

            outStream.close();

        } catch (Exception e) {

            e.printStackTrace();

        }



        }

    }

