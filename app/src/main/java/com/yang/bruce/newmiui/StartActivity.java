package com.yang.bruce.newmiui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yang.bruce.newmiui.dynamic_image.DynamicActivity;
import com.yang.bruce.newmiui.radiobutton.CheckboxRadiobuttonDemoActivity;
import com.yang.bruce.newmiui.webview_progress.WebViewProgressActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-08-16 9:49
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class StartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        ButterKnife.inject(this);

    }

    @OnClick({R.id.dynamic_iamge, R.id.radio_button, R.id.webview_with_progress})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dynamic_iamge:
                startActivity(new Intent(this, DynamicActivity.class));
                break;
            case R.id.radio_button:
                startActivity(new Intent(this, CheckboxRadiobuttonDemoActivity.class));
                break;
            case R.id.webview_with_progress:
                startActivity(new Intent(this, WebViewProgressActivity.class));
                break;
        }
    }
}
