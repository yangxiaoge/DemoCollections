package com.yang.bruce.newmiui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.yang.bruce.newmiui.bottombar.BottomBarActivity;
import com.yang.bruce.newmiui.day_night_theme.activity.DayNightActivity;
import com.yang.bruce.newmiui.dynamic_image.DynamicActivity;
import com.yang.bruce.newmiui.group_listview.PinnedSectionListActivity;
import com.yang.bruce.newmiui.judge_json.JudgeJsonActivity;
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

        //构造json 数组
        constructionJsonArray();

    }

    private void constructionJsonArray() {
        Object[] object = new Object[]{"111", "222", "24G"};
        JsonArray jsonArr = new JsonArray();
        for (Object anObject : object) {
            JsonObject jo = new JsonObject(); //构造json
            jo.addProperty("offerCode", (String) anObject);
            jsonArr.add(jo);
        }
        Toast.makeText(this, "构造json 数组  " + jsonArr.toString(), Toast.LENGTH_SHORT).show();
        System.out.println("jsonArr:  " + jsonArr.toString());
    }

    @OnClick({R.id.dynamic_iamge, R.id.radio_button, R.id.webview_with_progress,
            R.id.judge_json, R.id.listview, R.id.expandListView, R.id.button_bar, R.id.day_night})
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
            case R.id.judge_json:
                startActivity(new Intent(this, JudgeJsonActivity.class));
                break;
            case R.id.listview:
                startActivity(new Intent(this, PinnedSectionListActivity.class));
                break;
            case R.id.expandListView:
                //startActivity(new Intent(this, ExpandListViewActivity.class));
                break;
            case R.id.button_bar:
                startActivity(new Intent(this, BottomBarActivity.class));
                break;
            case R.id.day_night:
                startActivity(new Intent(this, DayNightActivity.class));
                break;
        }
    }
}
