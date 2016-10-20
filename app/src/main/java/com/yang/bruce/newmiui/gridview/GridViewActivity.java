package com.yang.bruce.newmiui.gridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.yang.bruce.newmiui.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-10-20 13:36
 * Version: 1.0
 * TaskId:
 * Descriptin:
 */

public class GridViewActivity extends AppCompatActivity {
    private GridView gridView;
    // gridView 菜单数据
    private List<HashMap<String, Object>> menuData = new ArrayList<>();
    private HomeGridViewAdapter menuGridViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        initView();
        //初始化数据
        initMenuData();
        //加载适配器
        menuGridViewAdapter = new HomeGridViewAdapter(this, menuData);
        gridView.setAdapter(menuGridViewAdapter);
    }

    /**
     * 初始化组件
     */
    private void initView() {
        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = null;
                switch (position) {
                    case 0:
                        msg = "TopUp";
                        break;
                    case 1:
                        msg = "OrderHistory";
                        break;
                    case 2:
                        msg = "MyBill";
                        break;
                    case 3:
                        msg = "ContactUs";
                        break;
                    case 4:
                        msg = "Store";
                        break;
                    case 5:
                        msg = "Flow";
                        break;
                    case 6:
                        msg = "Bill";
                        break;
                    case 7:
                        msg = "Hot Bundle";
                        break;
                }
                if (msg != null)
                    Toast.makeText(GridViewActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 初始化首页网格菜单
     */
    private void initMenuData() {
        int[] mainTypeImageId = {R.mipmap.menu_bar_help_center, R.mipmap.menu_bar_help_center_focus,
                R.mipmap.menu_bar_home, R.mipmap.ic_launcher, R.mipmap.menu_bar_my_facous,
                R.mipmap.menu_bar_service_entry, R.mipmap.menu_bar_service_entry_facous, R.mipmap.menu_bar_my};
        String[] menuName = getResources().getStringArray(R.array.home_menu_name);

        for (int i = 0; i < menuName.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", menuName[i]);
            map.put("image", mainTypeImageId[i]);
            map.put("mTypeId", i);
            menuData.add(map);
        }
    }
}
