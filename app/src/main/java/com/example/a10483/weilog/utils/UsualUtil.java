package com.example.a10483.weilog.utils;

import android.util.Log;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 10483 on 2018/1/16.
 */

public class UsualUtil {

    public static String transTime(String time){

        //String tim="Tue Jan 01 00:38:25 +0800 2013";
        String[] str=time.split("\\s+");
        String week=str[0];
        String monthstr=str[1];
        int  day=Integer.parseInt(str[2]);
        String puretime=str[3];
        String timearea=str[4];
        int year=Integer.parseInt(str[5]);
        int month=0;
        String[] monthcount=new String[12];
        monthcount[0]="Jan";
        monthcount[1]="Feb";
        monthcount[2]="Mar";
        monthcount[3]="Apr";
        monthcount[4]="May";
        monthcount[5]="Jun";
        monthcount[6]="Jul";
        monthcount[7]="Aug";
        monthcount[8]="sep";
        monthcount[9]="Oct";
        monthcount[10]="Nov";
        monthcount[11]="Dec";
        for(int i=0;i<monthcount.length;i++){
            if(monthcount[i].equals(monthstr)){
                month=i+1;
            }
        }

        String[] puretimes=puretime.split(":");
        int hour=Integer.parseInt(puretimes[0]);
        int min=Integer.parseInt(puretimes[1]);
        int sec=Integer.parseInt(puretimes[2]);


        Calendar c=Calendar.getInstance();
        int sysyear=c.get(Calendar.YEAR);
        int sysmonth=c.get(Calendar.MONTH)+1;
        int sysday=c.get(Calendar.DAY_OF_MONTH);
        int syshour=c.get(Calendar.HOUR_OF_DAY);
        int sysmin=c.get(Calendar.MINUTE);


        //Log.d("UsualUtil",""+sysyear+" "+sysmonth+" "+sysday+" "+syshour+" "+sysmin);

        if(year==sysyear){
            if(month==sysmonth&&day==sysday){
                int nettime=hour*60+min;
                int systime=syshour*60+sysmin;
                int num=systime-nettime;
                if(num<1){
                    return "刚刚";
                }else if(num<60){
                    return Integer.toString(num)+"分钟前";
                }else{
                    return Integer.toString(num/60)+"小时前";
                }
            }else{
                return Integer.toString(month)+"-"+Integer.toString(day);
            }
        }else{
            return Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day);
        }

    }

    public static String parserFrom(String source){
        Pattern p = Pattern.compile("<a[^>]*>(.*?)</a>");
        Matcher m = p.matcher(source);
        if(m.find()){
            return m.group(1);
        }else{
            return null;
        }
    }
}
