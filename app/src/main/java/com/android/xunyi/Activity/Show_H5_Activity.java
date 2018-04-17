package com.android.xunyi.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.xunyi.R;

public class Show_H5_Activity extends AppCompatActivity {

    private WebView mWebView;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_h5);

        mWebView= (WebView) findViewById(R.id.h5_webview);
        back= (ImageView) findViewById(R.id.showh5_back);

        WebSettings webSettings = mWebView.getSettings();

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("http://103.80.27.100:8008/immortal/webpage/h5-show.html");

       /* webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        webSettings.setLoadsImagesAutomatically(true);
     //   webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true);   //缩放操作
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mWebView.setWebChromeClient(new MyWebChromeClient());
        mWebView.getSettings().setDomStorageEnabled(true);
        MyWebChromeClient myWebChromeClient = new MyWebChromeClient();
        mWebView.setWebChromeClient(myWebChromeClient);
        mWebView.loadUrl("http://120.24.60.121/show/index.html#page1");*/


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Show_H5_Activity.this,H5_VR_Activity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    protected void onPause() {
        mWebView.reload();
        super.onPause();
    }

    final class MyWebChromeClient extends WebChromeClient {
        @Override
        public boolean onConsoleMessage(ConsoleMessage cm) {
            Log.d("test", cm.message() + " -- From line "
                    + cm.lineNumber() + " of "
                    + cm.sourceId() );
            return true;
        }
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            //Toast.makeText(Show_H5_Activity.this, message, Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
