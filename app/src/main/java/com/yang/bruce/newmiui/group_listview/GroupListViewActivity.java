package com.yang.bruce.newmiui.group_listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yang.bruce.newmiui.R;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-08-20 10:54
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class GroupListViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_listview_activity);

        initData();
    }

    private void initData() {

    }
}
