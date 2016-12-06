package com.yang.bruce.newmiui.MultiType_Use_Demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yang.bruce.newmiui.MultiType_Use_Demo.model.Category;
import com.yang.bruce.newmiui.MultiType_Use_Demo.model.CategoryViewProvider;
import com.yang.bruce.newmiui.MultiType_Use_Demo.model.Song;
import com.yang.bruce.newmiui.MultiType_Use_Demo.model.SongViewProvider;
import com.yang.bruce.newmiui.R;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * <pre>
 *      Author: Yang.JiaNan
 *      Time: 2016/12/6 14:26
 *      Email: yang.jianan@zte.com.cn
 *      Desc:
 * </pre>
 */
public class MultiType_Demo_Activity extends AppCompatActivity {

    private MultiTypeAdapter adapter;
    /* Items 等价于 ArrayList<Object> */
    private Items items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mutitype_main_activity);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        items = new Items();
        adapter = new MultiTypeAdapter(items);
        /* 注册类型和 View 的对应关系 */
        adapter.register(Category.class, new CategoryViewProvider());
        adapter.register(Song.class, new SongViewProvider());

        /* 模拟加载数据，也可以稍后再加载，然后使用
         * adapter.notifyDataSetChanged() 刷新列表 */
        for (int i = 0; i < 20; i++) {
            items.add(new Category("专辑" + i + 1));
            items.add(new Song("" + i, R.drawable.dayu));
        }
        recyclerView.setAdapter(adapter);

    }
}
