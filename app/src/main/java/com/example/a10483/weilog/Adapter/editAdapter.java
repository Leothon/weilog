package com.example.a10483.weilog.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a10483.weilog.Data.editdata;
import com.example.a10483.weilog.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 10483 on 2017/6/2.
 */

public class editAdapter extends BaseAdapter {
    private List<editdata> editdataLists;
    private LayoutInflater layoutInflater;

    private TextView edit_content;
    private TextView edit_time;
    public editAdapter(Context context,List<editdata> editdataList){
        layoutInflater=LayoutInflater.from(context);
        editdataLists=editdataList;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        //return editdataLists.size();
        return 2;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        convertView=layoutInflater.inflate(R.layout.edit_item,null);
        edit_content=(TextView)convertView.findViewById(R.id.edit_content);
        edit_time=(TextView)convertView.findViewById(R.id.edit_time);
        return convertView;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

}
