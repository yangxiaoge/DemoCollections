package com.yang.bruce.newmiui.judge_json;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yang.bruce.newmiui.ChangeProfileEventBean;
import com.yang.bruce.newmiui.R;
import com.yang.bruce.newmiui.SPUtils;
import com.yang.bruce.newmiui.ShowDialogForNetWorkState;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-08-17 12:50
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class JudgeJsonActivity extends AppCompatActivity {
    @InjectView(R.id.json_str)
    EditText jsonStr;
    @InjectView(R.id.textView)
    EditText textView;
    @InjectView(R.id.textView2)
    TextView afterDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.judge_json_activity);
        ButterKnife.inject(this);
        EventBus.getDefault().register(this);
        SPUtils spUtils = new SPUtils(this, "showDialog");

//        while (spUtils.getBoolean("show")){
//            ShowDialogForNetWorkState.showDialog(this, "无网络o(╯□╰)o");
//        }

    }

    @Subscribe
    public void hideWaitingDialog(ChangeProfileEventBean event) {
        Toast.makeText(this, event.showDialog + " : " + event.success, Toast.LENGTH_SHORT).show();
        // 其中一个接口访问结束(成功失败都算)
        if (event.showDialog && event.success) {
            ShowDialogForNetWorkState.showDialog(this, "mpt  有网络 judge_dialog");
            Toast.makeText(this, "judge", Toast.LENGTH_SHORT).show();
        }
        if (event.showDialog && !event.success) {
            ShowDialogForNetWorkState.showDialog(this, "非 mpt 无网络");

        }

    }

    @OnClick({R.id.button2, R.id.button3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2:
                String json = jsonStr.getText().toString().trim();
                isJson(json);
                break;
            case R.id.button3:
                String textViewStr = textView.getText().toString().trim();
                if (!TextUtils.isEmpty(textViewStr)) {
                    String str2 = getNumberString(textViewStr);
                    afterDeal.setText("取出非数字: " + str2);
                    Toast.makeText(this, "取出非数字后: " + str2, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void isJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            Toast.makeText(this, "yes, it is", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "no, it isn't", Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    private String getNumberString(String textViewStr) {
        String str = "";
        for (int i = 0; i < textViewStr.length(); i++) {
            if (Character.isDigit(textViewStr.charAt(i))) {
                str += textViewStr.charAt(i);
            }
        }
        return str;
    }
}
