package com.yang.bruce.newmiui.reselect_radiobutton;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yang.bruce.newmiui.R;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-10-24 10:56
 * Version: 1.0
 * TaskId:
 * Description:
 */

public class ReSelectRadioButtonActivity extends AppCompatActivity {
    private RadioGroup rg;
    private RadioButton mm;
    private RadioButton en;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton_reselected);
        rg = (RadioGroup) findViewById(R.id.rg);
        mm = (RadioButton) findViewById(R.id.mm);
        en = (RadioButton) findViewById(R.id.en);

        if ("mm".equals(SharedPreferencesUtil.getString(this, "language", "mm"))) {
            mm.setChecked(true);
        } else {
            en.setChecked(true);
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.mm:
                        SharedPreferencesUtil.setString(ReSelectRadioButtonActivity.this, "language", "mm");
                        startActivity(new Intent(ReSelectRadioButtonActivity.this, ReSelectRadioButtonActivity.class));
                        finish();
                        break;
                    case R.id.en:
                        SharedPreferencesUtil.setString(ReSelectRadioButtonActivity.this, "language", "en");
                        startActivity(new Intent(ReSelectRadioButtonActivity.this, ReSelectRadioButtonActivity.class));
                        finish();
                        break;

                }
            }
        });

    }
}
