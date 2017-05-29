package com.example.a10483.weilog.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a10483.weilog.R;


public class noticepage extends Fragment {

    private ImageView open_nav3;
    private ImageView message;
    private TextView aboutme;
    private TextView talkaboutme;
    private TextView likeme;
    private TextView messageme;
    private ViewPager notice_viewpager;
    private Toolbar notice_toolbar;
    public noticepage() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_noticepage, container, false);
        //open_nav3=(ImageView)view.findViewById(R.id.open_nav3);
        //message=(ImageView)view.findViewById(R.id.message);
        aboutme=(TextView)view.findViewById(R.id.aboutme);
        talkaboutme=(TextView)view.findViewById(R.id.talkaboutme);
        likeme=(TextView)view.findViewById(R.id.likeme);
        messageme=(TextView)view.findViewById(R.id.messageme);
        notice_viewpager=(ViewPager)view.findViewById(R.id.notice_viewpager);
        //notice_toolbar=(Toolbar)view.findViewById(R.id.notice_toolbar);
        //((AppCompatActivity)getActivity()).setSupportActionBar(notice_toolbar);
        return view;
    }


}
