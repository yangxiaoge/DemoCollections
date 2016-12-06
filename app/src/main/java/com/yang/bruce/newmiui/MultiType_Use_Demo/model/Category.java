package com.yang.bruce.newmiui.MultiType_Use_Demo.model;

import android.support.annotation.NonNull;

import me.drakeet.multitype.Item;

/**
 * <pre>
 *      Author: Yang.JiaNan
 *      Time: 2016/12/6 14:09
 *      Email: yang.jianan@zte.com.cn
 *      Desc: 数据类型或 Java bean/model
 * </pre>
 */
public class Category{
    @NonNull
    public String text;

    public Category(@NonNull final String text) {
        this.text = text;
    }
}
