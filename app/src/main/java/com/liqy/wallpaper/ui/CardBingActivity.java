package com.liqy.wallpaper.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liqy.wallpaper.R;
import com.liqy.wallpaper.ui.adapter.BingCardAdapter;
import com.meetic.shuffle.Shuffle;

public class CardBingActivity extends AppCompatActivity {

    Shuffle shuffle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_bing);
        shuffle=(Shuffle)findViewById(R.id.shuffle);
        shuffle.setShuffleAdapter(new BingCardAdapter(this,30));
    }
}
