package com.yang.bruce.newmiui.bottombar.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yang.bruce.newmiui.R;


/**
 * Created by YoKeyword on 16/6/3.
 */
public class BottomBarTab extends FrameLayout {
    private ImageView mIcon;
    private TextView mTitle;
    private Context mContext;
    private int icon; //默认icon id
    private int selectIcon; //选中icon id
    private int mTabPosition = -1;


    public BottomBarTab(Context context, @DrawableRes int icon, @DrawableRes int selectIcon, String title) {
        this(context, null, icon, selectIcon, title);
    }

    public BottomBarTab(Context context, AttributeSet attrs, int icon, int selectIcon, String title) {
        this(context, attrs, 0, icon, selectIcon, title);
    }

    public BottomBarTab(Context context, AttributeSet attrs, int defStyleAttr, int icon, int selectIcon, String title) {
        super(context, attrs, defStyleAttr);
        init(context, icon, selectIcon, title);
    }

    private void init(Context context, int icon, int selectIcon, String title) {
        mContext = context;
        this.icon = icon; //默认icon的id
        this.selectIcon = selectIcon; //选中icon的id

        // bottom 布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.bottombar_view, null);
        view.setFocusable(true);
        mIcon = (ImageView) view.findViewById(R.id.tab_icon);
        mTitle = ((TextView) view.findViewById(R.id.tab_title));
        mIcon.setImageResource(icon); //默认icon
        mTitle.setText(title); //默认title颜色
        mTitle.setTextColor(mContext.getResources().getColor(R.color.main_tab_text_normal_color));

        view.setBackgroundResource(android.R.color.white); //bottombar布局默认颜色
        addView(view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1.0F));

    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            mIcon.setImageResource(selectIcon);
            mTitle.setTextColor(mContext.getResources().getColor(R.color.login_btn_color_pressed));
        } else {
            mIcon.setImageResource(icon);
            mTitle.setTextColor(mContext.getResources().getColor(R.color.main_tab_text_normal_color));
        }
    }

    public void setTabPosition(int position) {
        mTabPosition = position;
        if (position == 0) {
            setSelected(true);
        }
    }

    public int getTabPosition() {
        return mTabPosition;
    }
}
