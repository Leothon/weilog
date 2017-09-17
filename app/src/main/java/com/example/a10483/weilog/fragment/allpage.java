package com.example.a10483.weilog.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.a10483.weilog.Adapter.WeilogAdapter;
import com.example.a10483.weilog.Data.Logdata;
import com.example.a10483.weilog.Data.Weilog;
import com.example.a10483.weilog.R;
import com.example.a10483.weilog.utils.ViewHolder;
import com.example.a10483.weilog.writeWeilog;

import java.util.ArrayList;
import java.util.List;

import static com.example.a10483.weilog.R.id.nav_view;
import static com.example.a10483.weilog.R.id.user_head;
import static com.example.a10483.weilog.R.id.user_name;

public class allpage extends Fragment{


    private Toolbar allpage_toolbar;
    private ImageView open_nav1;
    private ImageView search;
    private ListView allpage_listview;
    private FloatingActionButton cameraButton;
    private FloatingActionButton write_button;
    private List<String> allpagedata;
    private WeilogAdapter mAdapter;
    public allpage() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_allpage,container,false);
        allpage_listview=(ListView)view.findViewById(R.id.allpage_listview);
        //cameraButton=(FloatingActionButton)view.findViewById(R.id.camera_button);
        write_button=(FloatingActionButton)view.findViewById(R.id.write);
        //WeilogAdapter adapter=new WeilogAdapter(getActivity(),weilogdata);
        //allpage_listview.setAdapter(adapter);
        initdata();
        allpage_listview.setAdapter(mAdapter=new WeilogAdapter<String>(
                getActivity(),allpagedata,R.layout.weilogitem) {
                    @Override
                    public void convert(ViewHolder helper, String item) {
                        helper.setText(R.id.user_name,"Leothon");
                    }
                }

                    );

        allpage_listview.setDividerHeight(0);
        setListener();
        return view;
    }
    public void initdata(){
        allpagedata=new ArrayList<String>();
        String one=new String("Leothon");
        allpagedata.add(one);
        String two=new String("Leothon");
        allpagedata.add(two);
        String three=new String("Leothon");
        allpagedata.add(three);
        String four=new String("Leothon");
        allpagedata.add(four);
        String five=new String("Leothon");
        allpagedata.add(five);
        String six=new String("Leothon");
        allpagedata.add(six);
        String seven=new String("Leothon");
        allpagedata.add(seven);
        String eight=new String("Leothon");
        allpagedata.add(eight);
        String nine=new String("Leothon");
        allpagedata.add(nine);
        String ten=new String("Leothon");
        allpagedata.add(ten);

    }
    public void setListener(){
        write_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),writeWeilog.class);
                startActivity(intent);
            }
        });

    }
}





