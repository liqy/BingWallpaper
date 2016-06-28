package com.liqy.wallpaper.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.liqy.wallpaper.R;
import com.meetic.shuffle.Shuffle;

/**
 * Created by liqy on 2016/6/28.
 */
public class ShuffleViewHolder extends Shuffle.ViewHolder {

    public ImageView imageView;

    public ShuffleViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.item_img);
    }

}
