package com.example.a10483.weilog.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a10483.weilog.R;

public class explorepage extends Fragment {


    private Toolbar explore_toolbar;
    private ImageView open_nav2;
    private ImageView search1;
    private TextView trend;
    private TextView hotpot;
    private TextView video;
    private ViewPager viewPager;
    public explorepage() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_explorepage, container, false);

        //explore_toolbar=(Toolbar)view.findViewById(R.id.explore_toolbar);
        //((AppCompatActivity)getActivity()).setSupportActionBar(explore_toolbar);
        //open_nav2=(ImageView)view.findViewById(R.id.open_nav2);
        //search1=(ImageView)view.findViewById(R.id.search1);
        trend=(TextView)view.findViewById(R.id.trend_pager);
        hotpot=(TextView)view.findViewById(R.id.hotpot_pager);
        video=(TextView)view.findViewById(R.id.video_pager);
        viewPager=(ViewPager)view.findViewById(R.id.explore_viewpager);
        return view;
    }

}
