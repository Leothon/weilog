package com.example.a10483.weilog.fragment.explorePage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a10483.weilog.Adapter.WeilogAdapter;
import com.example.a10483.weilog.Adapter.WeilogFragmentPagerAdapter;
import com.example.a10483.weilog.Data.Weilog;
import com.example.a10483.weilog.R;

import java.util.List;

public class hotpotpage extends Fragment {

    private ListView hotpot_listview;
    private List<Weilog> hotpotdata;

    public hotpotpage() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.hotpotpager,container,false);
        hotpot_listview=(ListView)view.findViewById(R.id.hotpot_listview);
        //WeilogAdapter adapter=new WeilogAdapter(getActivity(),hotpotdata);
        //hotpot_listview.setAdapter(adapter);
        //hotpot_listview.setDividerHeight(0);
        return view;
    }


}
