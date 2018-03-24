package com.android.xunyi.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.xunyi.CustomView.GlideImageLoader;
import com.android.xunyi.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Shopping_item_details_Activity extends AppCompatActivity {

    @BindView(R.id.shopping_love)
    FloatingActionButton shoppingLove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_item_details_);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.shopping_item_toolbar);
        setSupportActionBar(toolbar);

        Banner banner = (Banner) findViewById(R.id.shopping_item_banner);
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.img_01);
        list.add(R.drawable.img_07);
        list.add(R.drawable.img_08);
        list.add(R.drawable.img_02);
        list.add(R.drawable.img_03);
        list.add(R.drawable.img_04);
        list.add(R.drawable.img_05);


        banner.setImages(list).setBannerAnimation(Transformer.Accordion).isAutoPlay(true).setDelayTime(4500).setBannerStyle(BannerConfig.CENTER)
                .setImageLoader(new GlideImageLoader())
                .start();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("商品详情");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shopping_item_toobar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shopping_car:
                Toast.makeText(this, "正在火速开发中", Toast.LENGTH_LONG).show();
                break;
            case R.id.shopping_share:
                Toast.makeText(this, "正在火速开发中", Toast.LENGTH_LONG).show();
                break;
            case android.R.id.home:
                Intent intent = new Intent(Shopping_item_details_Activity.this, Home_Activity.class);
                startActivity(intent);
                finish();
                break;
        }


        return true;
    }
    @OnClick({R.id.shopping_love})
    public void onClickEvent(View view){
        switch (view.getId()){
            case R.id.shopping_love:
                shoppingLove.setImageResource(R.drawable.love2);
                break;

        }


    }


}
