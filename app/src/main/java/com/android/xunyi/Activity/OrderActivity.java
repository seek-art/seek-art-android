package com.android.xunyi.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.android.xunyi.Adapter.OrderPagerAdapter;
import com.android.xunyi.R;

/**
 * Created by zsd19 on 2018/3/25.
 */

public class OrderActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private OrderPagerAdapter orderPagerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        orderPagerAdapter = new OrderPagerAdapter(getSupportFragmentManager(), this);
        viewPager = (ViewPager) findViewById(R.id.activity_order_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.order_tabs);
        viewPager.setAdapter(orderPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }
}
