package com.yang.bruce.newmiui;

/**
 * Created by yjn on 2016/11/14.
 */

public class ChangeProfileEventBean {
    public boolean showDialog;
    public boolean success;

    public ChangeProfileEventBean(boolean isChanged,boolean success) {
        this.showDialog = isChanged;
        this.success = success;
    }
}
