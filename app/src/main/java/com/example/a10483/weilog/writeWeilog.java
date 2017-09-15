package com.example.a10483.weilog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class writeWeilog extends BaseActivity implements View.OnClickListener{

    private ImageView backfromwrite;
    private TextView usernameinwrite;
    private ImageView sendlog;
    private EditText editText;
    private ImageView mediainwr;
    private ImageView taginwr;
    private ImageView atinwr;
    private ImageView faceinwr;
    private ImageView moreinwr;
    private TextView editcount;
    private int limit=140;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_weilog);
        backfromwrite=(ImageView)findViewById(R.id.back_from_writelog);
        usernameinwrite=(TextView)findViewById(R.id.user_name_in_context);
        sendlog=(ImageView)findViewById(R.id.sendweilog);
        editText=(EditText)findViewById(R.id.edittext);
        mediainwr=(ImageView)findViewById(R.id.wrimage);
        taginwr=(ImageView)findViewById(R.id.wrtopic);
        atinwr=(ImageView)findViewById(R.id.wrat);
        faceinwr=(ImageView)findViewById(R.id.biaoqing);
        moreinwr=(ImageView)findViewById(R.id.wredit);
        editcount=(TextView)findViewById(R.id.wrcount);
        weigetsetListener();
    }
    public void weigetsetListener(){
        backfromwrite.setOnClickListener(this);
        sendlog.setOnClickListener(this);
        mediainwr.setOnClickListener(this);
        taginwr.setOnClickListener(this);
        atinwr.setOnClickListener(this);
        faceinwr.setOnClickListener(this);
        moreinwr.setOnClickListener(this);
        editText.addTextChangedListener(new TextWatcher() {
            private CharSequence temp;
            private int selectionStart;
            private int selectionEnd;
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp = s;
            }

            public void afterTextChanged(Editable s) {
                int number = limit - s.length();
                editcount.setText("剩余" + number+"字");
                selectionStart = editText.getSelectionStart();
                selectionEnd = editText.getSelectionEnd();
                if (temp.length() > limit) {
                    s.delete(selectionStart - 1, selectionEnd);
                    int tempSelection = selectionEnd;
                    editText.setText(s);
                    editText.setSelection(tempSelection);//设置光标在最后
                    //sendlog.setColorFilter(Color.GRAY);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_from_writelog:
                cancel();
                break;
            case R.id.sendweilog:
                sendWeilog();
                break;
            case R.id.wrimage:
                wriamge();
                break;
            case R.id.wrtopic:
                tag();
                break;
            case R.id.wrat:
                atwr();
                break;
            case R.id.biaoqing:
                face();
                break;
            case R.id.wredit:
                more();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==4){//防止输入法的回退键退出页面
            cancel();
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void cancel(){
        if (editText.length()==0){
            finish();
        }else{
            AlertDialog.Builder dialog=new AlertDialog.Builder(writeWeilog.this);
            dialog.setTitle("是否保存到草稿");
            dialog.setCancelable(true);
            dialog.setNegativeButton("不保存", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    editText.setText(null);
                    finish();
                }
            });
            dialog.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //设计数据的保存
                }
            });
            dialog.show();
        }
    }
    protected void sendWeilog(){
        //发送微博，读取edittext中数据，包括文字，图片视频，进行打包传送
    }
    protected void wriamge(){
        //跳转系统图库
    }
    protected void tag(){
        //话题
    }
    protected void atwr(){
        //@某人
    }
    protected void face(){
        //表情包
    }
    protected void more(){
        startActivity(new Intent(writeWeilog.this,editactivity.class));
    }
}
