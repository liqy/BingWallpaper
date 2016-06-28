package com.liqy.wallpaper.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liqy.wallpaper.R;
import com.liqy.wallpaper.ui.adapter.BingPagerAdapter;

import cn.yangbingqiang.android.parallaxviewpager.ParallaxViewPager;

public class MainActivity extends AppCompatActivity {

    private ParallaxViewPager parallaxViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initView();
        initViewPager();
    }

    private void initView() {
        parallaxViewPager = (ParallaxViewPager) findViewById(R.id.viewpager);
    }

    private void initViewPager() {
        BingPagerAdapter adapter = new BingPagerAdapter(this, 30);
        parallaxViewPager.setAdapter(adapter);
    }
}
