package com.liqy.wallpaper.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.liqy.wallpaper.R;
import com.squareup.picasso.Picasso;
import com.wuxiaolong.androidutils.library.DisplayMetricsUtil;

import java.util.ArrayList;

/**
 * Created by liqy on 2016/6/28.
 */
public class BingPagerAdapter extends RecyclingPagerAdapter {

    private LayoutInflater inflater;
    private Activity activity;
    private ArrayList<String> pics;
    private int w;
    private int h;

    public BingPagerAdapter(Activity activity, int count) {
        this.activity = activity;
        this.inflater = LayoutInflater.from(activity);
        this.h = DisplayMetricsUtil.getScreenHeight(activity);
        this.w = DisplayMetricsUtil.getScreenWidth(activity);
        this.pics = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            this.pics.add(getImageUrl(i, w, h));
        }
    }

    private String getImageUrl(int i, int w, int h) {
        return String.format("https://api.ioliu.cn/bing/?d=%1$d&w=%2$d&h=%3$d", i, w, h);
    }

    private String getItem(int pos){
        return this.pics.get(pos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.pager_item, container, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(activity).load(getItem(position)).into(holder.imageView);
        return convertView;
    }

    @Override
    public int getCount() {
        return this.pics.size();
    }

    private static class ViewHolder {
        ImageView imageView;
        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.item_img);
        }
    }

}
