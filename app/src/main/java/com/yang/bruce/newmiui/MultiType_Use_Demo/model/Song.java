package com.yang.bruce.newmiui.MultiType_Use_Demo.model;

import android.support.annotation.NonNull;

import me.drakeet.multitype.Item;

/**
 * <pre>
 *      Author: Yang.JiaNan
 *      Time: 2016/12/6 15:36
 *      Email: yang.jianan@zte.com.cn
 *      Desc:
 * </pre>
 */
public class Song{
    @NonNull
    public String song;
    @NonNull
    public int drawableId;

    public Song(@NonNull String song ,@NonNull int drawableId) {
        this.song = song;
        this.drawableId = drawableId;
    }
}