package com.yang.bruce.newmiui.nice_loading_progress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yang.bruce.newmiui.R;

import butterknife.ButterKnife;

/**
 * <pre>
 *      Author: Yang.JiaNan
 *      Time: 2016/12/15 14:01
 *      Email: yang.jianan@zte.com.cn
 *      Desc:
 * </pre>
 */
public class NiceLoadingProgressBar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nice_loading_progress);
        ButterKnife.inject(this);
    }
}
