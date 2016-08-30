package com.yang.bruce.newmiui.bottombar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yang.bruce.newmiui.R;
import com.yang.bruce.newmiui.bottombar.widget.BottomBar;
import com.yang.bruce.newmiui.bottombar.widget.BottomBarTab;

import butterknife.ButterKnife;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-08-27 10:44
 * Version: 1.0
 * TaskId:
 * Description:
 * 具体使用可以看 fragmentation或者 AthenaMI
 */
public class BottomBarActivity extends AppCompatActivity implements BottomBar.OnTabSelectedListener {
    private BottomBar bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottombar_activity);
        ButterKnife.inject(this);

        initBottomNavigationBar();
    }

    private void initBottomNavigationBar() {
        bottomNavigationBar = (BottomBar) findViewById(R.id.navigateTabBar);
        bottomNavigationBar.addItem(new BottomBarTab(this, R.mipmap.menu_bar_home, R.mipmap.menu_bar_home_facous, "Home"));
        bottomNavigationBar.addItem(new BottomBarTab(this, R.mipmap.menu_bar_service_entry, R.mipmap.menu_bar_service_entry_facous, "Service Entry"));
        bottomNavigationBar.addItem(new BottomBarTab(this, R.mipmap.menu_bar_help_center, R.mipmap.menu_bar_help_center_focus, "Help Center"));
        bottomNavigationBar.addItem(new BottomBarTab(this, R.mipmap.menu_bar_my, R.mipmap.menu_bar_my_facous, "My"));

        bottomNavigationBar.setOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(int position, int prePosition) {

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
