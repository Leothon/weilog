package com.example.a10483.weilog.fragment;

import android.content.Context;
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
import com.example.a10483.weilog.Data.Weilog;
import com.example.a10483.weilog.R;

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
    private List<Weilog> weilogdata;
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
        WeilogAdapter adapter=new WeilogAdapter(getActivity(),weilogdata);
        allpage_listview.setAdapter(adapter);
        allpage_listview.setDividerHeight(0);
        setListener();
        return view;
    }
    public void setListener(){


    }
}





