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

import com.example.a10483.weilog.Adapter.WeilogFragmentPagerAdapter;
import com.example.a10483.weilog.R;
import com.example.a10483.weilog.fragment.explorePage.hotpotpage;
import com.example.a10483.weilog.fragment.explorePage.trendpage;
import com.example.a10483.weilog.fragment.explorePage.videopage;

import java.util.ArrayList;

public class explorepage extends Fragment {


    private Toolbar explore_toolbar;
    private ImageView open_nav2;
    private ImageView search1;
    private TextView trend;
    private TextView hotpot;
    private TextView video;
    private ViewPager viewPager;
    private ArrayList<Fragment> list;
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

        trend=(TextView)view.findViewById(R.id.trend_pager);
        hotpot=(TextView)view.findViewById(R.id.hotpot_pager);
        video=(TextView)view.findViewById(R.id.video_pager);
        viewPager=(ViewPager)view.findViewById(R.id.explore_viewpager);
        trend.setTextColor(getResources().getColor(R.color.red));
        hotpotpage hotpot_page=new hotpotpage();
        trendpage trend_page=new trendpage();
        videopage video_page=new videopage();
        list=new ArrayList<>();
        list.add(trend_page);
        list.add(hotpot_page);
        list.add(video_page);
        WeilogFragmentPagerAdapter adapter=new WeilogFragmentPagerAdapter(getChildFragmentManager(),list);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        trend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });
        hotpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        trend.setTextColor(getResources().getColor(R.color.red));
                        hotpot.setTextColor(getResources().getColor(R.color.gray));
                        video.setTextColor(getResources().getColor(R.color.gray));
                        break;
                    case 1:
                        trend.setTextColor(getResources().getColor(R.color.gray));
                        hotpot.setTextColor(getResources().getColor(R.color.red));
                        video.setTextColor(getResources().getColor(R.color.gray));
                        break;
                    case 2:
                        trend.setTextColor(getResources().getColor(R.color.gray));
                        hotpot.setTextColor(getResources().getColor(R.color.gray));
                        video.setTextColor(getResources().getColor(R.color.red));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }




}
