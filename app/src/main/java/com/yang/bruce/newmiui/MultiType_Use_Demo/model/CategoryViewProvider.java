package com.yang.bruce.newmiui.MultiType_Use_Demo.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yang.bruce.newmiui.R;

import me.drakeet.multitype.ItemViewProvider;

/**
 * <pre>
 *      Author: Yang.JiaNan
 *      Time: 2016/12/6 14:13
 *      Email: yang.jianan@zte.com.cn
 *      Desc:
 * </pre>
 */
public class CategoryViewProvider extends ItemViewProvider<Category, CategoryViewProvider.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {
        @NonNull
        private final TextView cateforyText;
        @NonNull
        private final ImageView imageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cateforyText = (TextView) itemView.findViewById(R.id.text);
            this.imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.mutitype_item_category, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Category category) {
        holder.cateforyText.setText(category.text);
        holder.imageView.setImageResource(R.drawable.aaa);
    }

}
