package com.example.a10483.weilog.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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

import com.example.a10483.weilog.R;

import static com.example.a10483.weilog.R.id.nav_view;

public class allpage extends Fragment{


    private Toolbar allpage_toolbar;
    private ImageView open_nav1;
    private ImageView search;
    private ListView allpage_listview;
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
        //allpage_toolbar=(Toolbar)view.findViewById(R.id.allpage_toolbar);
        //((AppCompatActivity)getActivity()).setSupportActionBar(allpage_toolbar);
        //open_nav1=(ImageView)view.findViewById(R.id.open_nav1);
        //search=(ImageView)view.findViewById(R.id.search);
        allpage_listview=(ListView)view.findViewById(R.id.allpage_listview);

        //open_nav1.setOnClickListener(this);
        setListener();
        return view;
    }
    public void setListener(){

    }
    //public void onClick(View view){
        //DrawerLayout drawer = (DrawerLayout)view.findViewById(R.id.drawer_layout);
        //drawer.openDrawer(nav_view);
    //}
}





