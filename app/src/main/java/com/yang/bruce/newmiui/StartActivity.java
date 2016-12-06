package com.yang.bruce.newmiui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.yang.bruce.newmiui.MultiType_Use_Demo.MultiType_Demo_Activity;
import com.yang.bruce.newmiui.bottombar.BottomBarActivity;
import com.yang.bruce.newmiui.day_night_theme.activity.DayNightActivity;
import com.yang.bruce.newmiui.dynamic_image.DynamicActivity;
import com.yang.bruce.newmiui.gridview.GridViewActivity;
import com.yang.bruce.newmiui.group_listview.PinnedSectionListActivity;
import com.yang.bruce.newmiui.judge_json.JudgeJsonActivity;
import com.yang.bruce.newmiui.radiobutton.CheckboxRadiobuttonDemoActivity;
import com.yang.bruce.newmiui.refresh_layout.PublicRefreshLayout_Activity;
import com.yang.bruce.newmiui.reselect_radiobutton.ReSelectRadioButtonActivity;
import com.yang.bruce.newmiui.view_move.MoveViewDemoActivity;
import com.yang.bruce.newmiui.webview_progress.WebViewProgressActivity;

import java.util.ArrayList;

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

        Log.d("onCreate: ", "onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart: ", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume: ", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause: ", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop: ", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy: ", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart: ", "onRestart");
    }

    private void constructionJsonArray() {
        Object[] object = new Object[]{"111", "222", "24G"};
        JsonArray jsonArr = new JsonArray();
        for (Object anObject : object) {
            JsonObject jo = new JsonObject(); //构造json
            jo.addProperty("offerCode", (String) anObject);
            jo.addProperty("action", "1");
            jsonArr.add(jo);
        }
        Toast.makeText(this, "构造json 数组  " + jsonArr.toString(), Toast.LENGTH_SHORT).show();
        System.out.println("jsonArr:  " + jsonArr.toString());

        //得到手机最大允许内存的,即超过指定内存,则开始回收
        long maxMemory = Runtime.getRuntime().maxMemory();
        Toast.makeText(this, "maxMemory : " + maxMemory, Toast.LENGTH_SHORT).show();

        ArrayList<String> removeFreebiesCodeList = new ArrayList<>();
        removeFreebiesCodeList.add("1");
        removeFreebiesCodeList.add("2");
        removeFreebiesCodeList.add("3");
        removeFreebiesCodeList.add("4");
        removeFreebiesCodeList.add("5");
        System.out.println("list to string" + removeFreebiesCodeList.toString());
        Toast.makeText(this, removeFreebiesCodeList.toString(), Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("removeFreebiesCodeList", removeFreebiesCodeList);
        ArrayList<String> string = bundle.getStringArrayList("removeFreebiesCodeList");
        string.add("21312");
        System.out.println("新的removeFreebiesCodeList" + string.toString());
    }

    @OnClick({R.id.dynamic_iamge, R.id.radio_button, R.id.webview_with_progress,
            R.id.judge_json, R.id.listview, R.id.expandListView, R.id.button_bar,
            R.id.day_night, R.id.gridview, R.id.radiobutton_select, R.id.refresh_layout,
            R.id.move_view_demo,R.id.multi_type_demo})
    public void onClickLis(View view) {
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
            case R.id.gridview:
                startActivity(new Intent(this, GridViewActivity.class));
                break;
            case R.id.radiobutton_select:
                startActivity(new Intent(this, ReSelectRadioButtonActivity.class));
                break;
            case R.id.refresh_layout:
                startActivity(new Intent(this, PublicRefreshLayout_Activity.class));
                break;
            case R.id.move_view_demo:
                startActivity(new Intent(this, MoveViewDemoActivity.class));
                break;
            case R.id.multi_type_demo:
                startActivity(new Intent(this, MultiType_Demo_Activity.class));
                break;
        }
    }
}
