package com.yang.bruce.newmiui;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;

/**
 * <pre>
 *      Author: Yang.JiaNan
 *      Time: 2016/12/13 18:24
 *      Email: yang.jianan@zte.com.cn
 *      Desc:
 * </pre>
 */
public class TranslucetActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

    }

//    @Override
//    public void onBackPressed() {
//
//    }
}
