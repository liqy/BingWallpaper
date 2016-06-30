package com.liqy.wallpaper.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liqy.wallpaper.Config;
import com.liqy.wallpaper.R;
import com.meetic.shuffle.Shuffle;
import com.squareup.picasso.Picasso;
import com.wuxiaolong.androidutils.library.DisplayMetricsUtil;

import java.util.ArrayList;

/**
 * Created by liqy on 2016/6/28.
 */
public class BingCardAdapter extends Shuffle.Adapter<ShuffleViewHolder> {

    private Activity activity;

    private ArrayList<String> pics;
    private int w;
    private int h;

    public BingCardAdapter(Activity activity, int count) {
        this.activity = activity;
        this.h = DisplayMetricsUtil.getScreenHeight(activity);
        this.w = DisplayMetricsUtil.getScreenWidth(activity);
        addData(count);
    }

    public void addData(int count) {
        if (this.pics == null) {
            this.pics = new ArrayList<>(count);
        }
        int size = this.pics.size();
        if (size == 0) size = 1;
        count = count + size;
        for (int i = size; i < count; i++) {
            this.pics.add(getImageUrl(i));
        }
        notifyDataSetChanged();
    }

    private String getImageUrl(int i) {
        return String.format("https://api.ioliu.cn/bing/?d=%1$d&w=%2$d&h=%3$d", i, Config.IMG_BASE_W, Config.IMG_BASE_H);
    }

    @Override
    public ShuffleViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pager_item, viewGroup, false);
        return new ShuffleViewHolder(view);
    }

    private String getItem(int pos) {
        return this.pics.get(pos);
    }

    @Override
    public void onBindViewHolder(ShuffleViewHolder viewHolder, int position) {
        Picasso.with(activity)
                .load(getItem(position))
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return this.pics.size();
    }
}
