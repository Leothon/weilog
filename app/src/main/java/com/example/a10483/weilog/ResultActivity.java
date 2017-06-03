package com.example.a10483.weilog;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;



public class ResultActivity extends Activity {

	private TextView mResultText;
	private ImageView back_from_web;
	private TextView item;
	private WebView web_view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		Bundle extras = getIntent().getExtras();
		mResultText = (TextView) findViewById(R.id.result_text);
		web_view=(WebView)findViewById(R.id.web_view);
		back_from_web=(ImageView)findViewById(R.id.back_from_web);
		item=(TextView)findViewById(R.id.item);
		if (null != extras) {
			String result = extras.getString("result");
			mResultText.setText(result);
		}
		back_from_web.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				finish();
			}
		});
		String url=extras.getString("result");
		web_view.getSettings().setJavaScriptEnabled(true);
		web_view.loadUrl(url);
		web_view.setWebViewClient(new WebViewClient());
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode==KeyEvent.KEYCODE_BACK)&&web_view.canGoBack()){
			web_view.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
