package com.example.a10483.weilog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class hisScan extends BaseActivity {

    private Toolbar his_toolbar;
    private ImageView back_from_his;
    private TextView item2;
    private WebView his_webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.his_scan);

        his_toolbar=(Toolbar)findViewById(R.id.hisscan_toolbar);
        setSupportActionBar(his_toolbar);
        back_from_his=(ImageView)findViewById(R.id.back_from_hisscan);
        item2=(TextView)findViewById(R.id.item2);
        his_webview=(WebView)findViewById(R.id.web_view_his);

        back_from_his.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        his_webview.loadUrl("www.github.com");
        his_webview.setWebViewClient(new WebViewClient());
    }
}
