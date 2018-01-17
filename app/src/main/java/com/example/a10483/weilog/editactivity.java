package com.example.a10483.weilog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a10483.weilog.Adapter.editAdapter;

import java.util.List;

public class editactivity extends BaseActivity {

    //private List<editdata> editdataList;
    private ListView edit_listview;
    private ImageView backfromedit;
    private TextView clearedit;
    private Toolbar edit_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editactivity);
        backfromedit=(ImageView)findViewById(R.id.back_from_edit);
        clearedit=(TextView)findViewById(R.id.clear_edit);
        edit_toolbar=(Toolbar)findViewById(R.id.edit_toolbar);
        setSupportActionBar(edit_toolbar);
        edit_listview=(ListView)findViewById(R.id.edit_listview);
       // editAdapter adapter=new editAdapter(this,editdataList);
        //edit_listview.setAdapter(adapter);
        setListener();

    }

    public void setListener(){
        edit_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(editactivity.this,writeWeilog.class));
            }
        });
        backfromedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        clearedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出是否清空草稿箱
            }
        });



    }

}
