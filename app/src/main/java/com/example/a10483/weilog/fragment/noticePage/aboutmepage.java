package com.example.a10483.weilog.fragment.noticePage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.a10483.weilog.Data.statusBean;
import com.example.a10483.weilog.R;

import java.util.List;

public class aboutmepage extends Fragment {

    private ListView aboutme_listview;
    private List<statusBean> aboutmedatas;

    public aboutmepage() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_aboutmepage, container, false);
        aboutme_listview=(ListView)view.findViewById(R.id.aboutme_listview);
        //initdata();
        //aboutmepageAdapter adapter=new aboutmepageAdapter(getContext(),aboutmedatas,R.layout.aboutmeitem);
        //aboutme_listview.setAdapter(adapter);
        return view;
    }

    public void initdata(){
        /*aboutmedatas=new ArrayList<statusBean>();
        statusBean aboutmedata=new statusBean("Leothon","微博内容微博内容微博内容微博内容微博内容微博内容微博内容微博内容" +
                "微博内容微博内容微博内容微博内容微博内容微博内容微博内容","nubia Z11miniS","10","190","1 小时前");
        aboutmedatas.add(aboutmedata);
        aboutmedata=new statusBean("Leothon","微博内容微博内容微博内容微博内容微博内容微博内容微博内容微博内容" +
                "微博内容微博内容微博内容微博内容微博内容微博内容微博内容","nubia Z11miniS","10","190","1 小时前");
        aboutmedatas.add(aboutmedata);
        aboutmedata=new statusBean("Leothon","微博内容微博内容微博内容微博内容微博内容微博内容微博内容微博内容" +
                "微博内容微博内容微博内容微博内容微博内容微博内容微博内容","nubia Z11miniS","10","190","1 小时前");
        aboutmedatas.add(aboutmedata);
        aboutmedata=new statusBean("Leothon","微博内容微博内容微博内容微博内容微博内容微博内容微博内容微博内容" +
                "微博内容微博内容微博内容微博内容微博内容微博内容微博内容","nubia Z11miniS","10","190","1 小时前");
        aboutmedatas.add(aboutmedata);
        aboutmedata=new statusBean("Leothon","微博内容微博内容微博内容微博内容微博内容微博内容微博内容微博内容" +
                "微博内容微博内容微博内容微博内容微博内容微博内容微博内容","nubia Z11miniS","10","190","1 小时前");
        aboutmedatas.add(aboutmedata);
        aboutmedata=new statusBean("Leothon","微博内容微博内容微博内容微博内容微博内容微博内容微博内容微博内容" +
                "微博内容微博内容微博内容微博内容微博内容微博内容微博内容","nubia Z11miniS","10","190","1 小时前");
        aboutmedatas.add(aboutmedata);
        aboutmedata=new statusBean("Leothon","微博内容微博内容微博内容微博内容微博内容微博内容微博内容微博内容" +
                "微博内容微博内容微博内容微博内容微博内容微博内容微博内容","nubia Z11miniS","10","190","1 小时前");
        aboutmedatas.add(aboutmedata);
        aboutmedata=new statusBean("Leothon","微博内容微博内容微博内容微博内容微博内容微博内容微博内容微博内容" +
                "微博内容微博内容微博内容微博内容微博内容微博内容微博内容","nubia Z11miniS","10","190","1 小时前");
        aboutmedatas.add(aboutmedata);
        aboutmedata=new statusBean("Leothon","微博内容微博内容微博内容微博内容微博内容微博内容微博内容微博内容" +
                "微博内容微博内容微博内容微博内容微博内容微博内容微博内容","nubia Z11miniS","10","190","1 小时前");
        aboutmedatas.add(aboutmedata);
        aboutmedata=new statusBean("Leothon","微博内容微博内容微博内容微博内容微博内容微博内容微博内容微博内容" +
                "微博内容微博内容微博内容微博内容微博内容微博内容微博内容","nubia Z11miniS","10","190","1 小时前");
        aboutmedatas.add(aboutmedata);
    }*/
    /*class aboutmepageAdapter extends CommonAdapter<statusBean>{
       public aboutmepageAdapter(Context context, List<statusBean> aboutmedatas,int layoutId){
           super(context,aboutmedatas,layoutId);
       }
       @Override
       public void convert(ViewHolder holder,final statusBean aboutmedata){
           holder.setText(R.id.user_name_inaboutme,aboutmedata.getUsername())
                   .setText(R.id.weilog_time_inaboutme,aboutmedata.getTime())
                   .setText(R.id.from_device_inaboutme,aboutmedata.getfromdevice())
                   .setText(R.id.like_button_inaboutme,aboutmedata.getlike())
                   .setText(R.id.talk_button_inaboutme,aboutmedata.gettalk());
       }*/

    }


}
