package com.yang.bruce.newmiui.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yang.bruce.newmiui.R;

import java.util.HashMap;
import java.util.List;

public class HomeGridViewAdapter extends BaseAdapter {
    private Context context;
    private List<HashMap<String,Object>> shopTypeInfo ;
    public HomeGridViewAdapter(Context context,List<HashMap<String, Object>> shopTypeInfo){
        this.context =context;
        this.shopTypeInfo = shopTypeInfo;
    }
    @Override
    public int getCount() {
        if(shopTypeInfo!=null){
            return shopTypeInfo.size();
        }
        return 0;
    }


    @Override
    public Object getItem(int positon) {
        if(shopTypeInfo!=null){
            return shopTypeInfo.get(positon);
        }
        return null;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        public TextView typeName;
        public ImageView image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.home_menu_grid_item, parent, false);
            holder = new ViewHolder();
            holder.typeName = (TextView) convertView.findViewById(R.id.home_shop_type_name);
            holder.image = (ImageView) convertView.findViewById(R.id.home_shop_type_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.typeName.setText(shopTypeInfo.get(position).get("name").toString());
        holder.image.setImageResource((Integer) shopTypeInfo.get(position).get("image"));
        return convertView;
    }

}
