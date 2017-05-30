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

import com.example.a10483.weilog.Adapter.WeilogFragmentPagerAdapter;
import com.example.a10483.weilog.R;
import com.example.a10483.weilog.fragment.noticePage.aboutmepage;
import com.example.a10483.weilog.fragment.noticePage.likemepage;
import com.example.a10483.weilog.fragment.noticePage.messagemepage;
import com.example.a10483.weilog.fragment.noticePage.talkaboutmepage;

import java.util.ArrayList;


public class noticepage extends Fragment {

    private ImageView open_nav3;
    private ImageView message;
    private TextView aboutme;
    private TextView talkaboutme;
    private TextView likeme;
    private TextView messageme;
    private ViewPager notice_viewpager;
    private Toolbar notice_toolbar;
    private ArrayList<Fragment> list;
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
        aboutme=(TextView)view.findViewById(R.id.aboutme);
        talkaboutme=(TextView)view.findViewById(R.id.talkaboutme);
        likeme=(TextView)view.findViewById(R.id.likeme);
        messageme=(TextView)view.findViewById(R.id.messageme);
        notice_viewpager=(ViewPager)view.findViewById(R.id.notice_viewpager);
        aboutme.setTextColor(getResources().getColor(R.color.red));
        aboutmepage aboutmepage=new aboutmepage();
        likemepage likemepage=new likemepage();
        messagemepage messagemepage=new messagemepage();
        final talkaboutmepage talkaboutmepage=new talkaboutmepage();
        list=new ArrayList<>();
        list.add(aboutmepage);
        list.add(talkaboutmepage);
        list.add(likemepage);
        list.add(messagemepage);
        WeilogFragmentPagerAdapter adapter=new WeilogFragmentPagerAdapter(getChildFragmentManager(),list);
        notice_viewpager.setAdapter(adapter);
        notice_viewpager.setCurrentItem(0);

        aboutme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice_viewpager.setCurrentItem(0);
            }
        });
        talkaboutme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice_viewpager.setCurrentItem(1);
            }
        });
        likeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice_viewpager.setCurrentItem(2);
            }
        });
        messageme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice_viewpager.setCurrentItem(3);
            }
        });

        notice_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        aboutme.setTextColor(getResources().getColor(R.color.red));
                        talkaboutme.setTextColor(getResources().getColor(R.color.gray));
                        likeme.setTextColor(getResources().getColor(R.color.gray));
                        messageme.setTextColor(getResources().getColor(R.color.gray));
                        break;
                    case 1:
                        aboutme.setTextColor(getResources().getColor(R.color.gray));
                        talkaboutme.setTextColor(getResources().getColor(R.color.red));
                        likeme.setTextColor(getResources().getColor(R.color.gray));
                        messageme.setTextColor(getResources().getColor(R.color.gray));
                        break;
                    case 2:
                        aboutme.setTextColor(getResources().getColor(R.color.gray));
                        talkaboutme.setTextColor(getResources().getColor(R.color.gray));
                        likeme.setTextColor(getResources().getColor(R.color.red));
                        messageme.setTextColor(getResources().getColor(R.color.gray));
                        break;
                    case 3:
                        aboutme.setTextColor(getResources().getColor(R.color.gray));
                        talkaboutme.setTextColor(getResources().getColor(R.color.gray));
                        likeme.setTextColor(getResources().getColor(R.color.gray));
                        messageme.setTextColor(getResources().getColor(R.color.red));
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        return view;
    }


}
