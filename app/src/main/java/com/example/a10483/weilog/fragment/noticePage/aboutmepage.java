package com.example.a10483.weilog.fragment.noticePage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.a10483.weilog.Adapter.WeilogAdapter;
import com.example.a10483.weilog.Data.Weilog;
import com.example.a10483.weilog.R;

import java.util.List;

public class aboutmepage extends Fragment {

    private ListView aboutme_listview;
    private List<Weilog> aboutmedata;

    public aboutmepage() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_aboutmepage, container, false);
        aboutme_listview=(ListView)view.findViewById(R.id.aboutme_listview);
        WeilogAdapter adapter=new WeilogAdapter(getActivity(),aboutmedata);
        aboutme_listview.setAdapter(adapter);
        return view;
    }


}
