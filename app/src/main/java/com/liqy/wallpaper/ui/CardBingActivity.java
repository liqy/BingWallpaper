package com.liqy.wallpaper.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liqy.wallpaper.R;
import com.liqy.wallpaper.ui.adapter.BingCardAdapter;
import com.meetic.dragueur.Direction;
import com.meetic.dragueur.DraggableView;
import com.meetic.shuffle.Shuffle;

public class CardBingActivity extends AppCompatActivity implements Shuffle.Listener {

    Shuffle shuffle;
    BingCardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_bing);
        shuffle = (Shuffle) findViewById(R.id.shuffle);
        cardAdapter = new BingCardAdapter(this, 15);
        shuffle.setShuffleAdapter(cardAdapter);
        shuffle.addListener(this);
    }

    @Override
    public void onViewChanged(int position) {

    }

    @Override
    public void onScrollStarted() {

    }

    @Override
    public void onScrollFinished() {
        cardAdapter.addData(15);
    }

    @Override
    public void onViewExited(DraggableView draggableView, Direction direction) {

    }

    @Override
    public void onViewScrolled(DraggableView draggableView, float percentX, float percentY) {

    }
}
