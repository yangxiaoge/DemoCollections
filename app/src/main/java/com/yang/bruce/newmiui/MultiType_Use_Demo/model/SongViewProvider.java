package com.yang.bruce.newmiui.MultiType_Use_Demo.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yang.bruce.newmiui.R;

import me.drakeet.multitype.ItemViewProvider;

/**
 * <pre>
 *      Author: Yang.JiaNan
 *      Time: 2016/12/6 15:36
 *      Email: yang.jianan@zte.com.cn
 *      Desc:
 * </pre>
 */
public class SongViewProvider
        extends ItemViewProvider<Song, SongViewProvider.ViewHolder> {


    class ViewHolder extends RecyclerView.ViewHolder {
        @NonNull
        private final TextView song;
        @NonNull
        private final ImageView image;

        private String value = "";

        ViewHolder(View itemView) {
            super(itemView);
            this.song = (TextView) itemView.findViewById(R.id.song);
            this.image = (ImageView) itemView.findViewById(R.id.image);

            song.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),
                            "song item's value: " + "今天你要嫁给我吗?" + value, Toast.LENGTH_SHORT).show();
                }
            });
        }

        void setData(@NonNull final Song textItem) {
            this.value = textItem.song;
        }
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_song, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(
            @NonNull ViewHolder holder, @NonNull Song song) {
        holder.song.setText("今天你要嫁给我" + song.song);
        holder.image.setImageResource(song.drawableId);

        holder.setData(song);
    }

}