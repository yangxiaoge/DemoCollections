package com.yang.bruce.newmiui.radiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yang.bruce.newmiui.R;

import java.util.ArrayList;
import java.util.List;


public class CheckboxRadiobuttonDemoActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private RadioGroupAuto rgp;
    private RadioGroup yuansheng;

    private String[] loanList;
    private String[] loanFeeList;
    private List<String> loanAndFeeList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //获取屏幕信息
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;

        loanAndFeeList = new ArrayList<>();
        loanList = "800,1000,1600,200,300,500,700".split(",");
        loanFeeList = "50,80,100,20,30,50,70".split(",");
        int max = Integer.parseInt(loanList[0]);
        int min = Integer.parseInt(loanList[0]);
        for (String i : loanList) {
            int j = Integer.parseInt(i);
            max = max > j ? max : j;
            min = min < j ? min : j;
        }
        //Toast.makeText(this, max + " " + min, Toast.LENGTH_SHORT).show();
        String maxS = String.valueOf(max);
        int maxLen = maxS.length();

        for (int i = 0; i < loanList.length; i++) {
            loanAndFeeList.add(loanList[i] + "," + loanFeeList[i]);
        }

        int ij = 1;
        rgp = (RadioGroupAuto) findViewById(R.id.RadioGroup01);

        int len = loanAndFeeList.size();

        for (int j = 0; j < len; j++) {

            RadioButton radioButton = new RadioButton(this);
            radioButton.setPadding(20, 0, screenWidth / 6, 0);                 // 设置文字距离按钮四周的距离
            radioButton.setButtonDrawable(R.drawable.transfer_radiobutton_drawable);
            int jj = 1;
            String newLoanList = loanList[j];
            if (loanList[j].length() < maxLen) {
                newLoanList = newLoanList + getCount(maxLen - loanList[j].length());

                // 实现 TextView同时显示两种风格文字 http://txlong-onz.iteye.com/blog/1142781
                SpannableStringBuilder sb = new SpannableStringBuilder(newLoanList);
                final ForegroundColorSpan fcs = new ForegroundColorSpan(getResources().getColor(R.color.transparent));
                sb.setSpan(fcs, loanList[j].length(), maxLen, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                radioButton.setText(sb);
            } else {
                newLoanList = loanList[j];
                radioButton.setText(newLoanList);
            }

            radioButton.setId(j); //设置RadioButton的id
            radioButton.setTag(loanAndFeeList.get(j));
            radioButton.setTextSize(13); //默认单位是 sp
            radioButton.setHeight(60); //默认单位是px
            rgp.addView(radioButton);

        }
        rgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton clickRadioButton = (RadioButton) group.findViewById(checkedId);
                String tipInfo = "id: " + clickRadioButton.getId() + " text: " + clickRadioButton.getText() +
                        /*"hint: " + clickRadioButton.getHint() +*/ " tag:" + clickRadioButton.getTag();
                System.out.println(tipInfo);

                Toast.makeText(CheckboxRadiobuttonDemoActivity.this, tipInfo,
                        Toast.LENGTH_SHORT).show();
            }
        });

        //根据这个来设置默认选中的项, 注意,这个要设置在监听之后!,否则默认点击监听不到!虽然有选中效果
        //参考 http://blog.csdn.net/lzqjfly/article/details/16963645
        rgp.check(0);
    }

    public String getCount(int count) {
        String st = "";
        if (count < 0) {
            count = 0;
        }
        for (int i = 0; i < count; i++) {
            st = st + "s";
        }
        return st;
    }
}