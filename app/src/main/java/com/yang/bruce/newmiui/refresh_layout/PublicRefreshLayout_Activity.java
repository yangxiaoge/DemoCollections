package com.yang.bruce.newmiui.refresh_layout;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.github.cjj.library.HaoKanRefreshLayout;
import com.github.cjj.library.listener.OnRefreshListener;
import com.yang.bruce.newmiui.R;

/**
 * Created by yjn on 2016/12/5.
 */

public class PublicRefreshLayout_Activity extends AppCompatActivity {
    private HaoKanRefreshLayout haoKanRefreshLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去掉标题栏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.refresh_layout);


        haoKanRefreshLayout = (HaoKanRefreshLayout) findViewById(R.id.haokan_refresh);
        haoKanRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        haoKanRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        haoKanRefreshLayout.setRefreshing(true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                haoKanRefreshLayout.setRefreshing(false);
            }
        }, 3000);

        haoKanRefreshLayout.setWaveBackgroundColor(getResources().getColor(R.color.colorPrimary));
//        haoKanRefreshLayout.setWaveBackgroundColor(Color.parseColor("#3F51B5"));
    }
}
