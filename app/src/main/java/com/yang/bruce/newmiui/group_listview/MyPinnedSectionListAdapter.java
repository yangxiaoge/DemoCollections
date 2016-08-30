package com.yang.bruce.newmiui.group_listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-08-20 11:00
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class MyPinnedSectionListAdapter extends BaseAdapter implements PinnedSectionListView.PinnedSectionListAdapter {
    @Override
    public boolean isItemViewTypePinned(int viewType) {
        return false;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
