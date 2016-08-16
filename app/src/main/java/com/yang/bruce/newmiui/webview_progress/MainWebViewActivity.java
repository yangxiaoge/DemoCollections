package com.yang.bruce.newmiui.webview_progress;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.yang.bruce.newmiui.R;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-07-25 18:21
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class MainWebViewActivity extends Activity{

    private ImageView mIvBack;
    private TextView mTvTitle;
    private LoadingWebView mLoadingWebView;

    private String mTitle = "";
    private String mUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        initView();
        initData();
    }

    private void initView() {
        mLoadingWebView = (LoadingWebView) findViewById(R.id.wv_loading);
        mLoadingWebView.addProgressBar();
    }

    private void initData() {
        mTitle = getIntent().getStringExtra("title");
        mUrl = getIntent().getStringExtra("url");


        mLoadingWebView.loadMessageUrl(mUrl);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mLoadingWebView.destroyWebView();
    }

    /**
     * 按返回键时， 不退出程序而是返回WebView的上一页面
     */
    @Override
    public void onBackPressed() {
        if (mLoadingWebView.canGoBack())
            mLoadingWebView.goBack();
        else {
            super.onBackPressed();
        }
    }
}
