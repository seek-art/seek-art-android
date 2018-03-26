package com.android.xunyi.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.android.xunyi.Adapter.MessagePagerAdapter;
import com.android.xunyi.R;

/**
 * Created by zsd19 on 2018/3/26.
 */

public class MessageActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MessagePagerAdapter messagePagerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        messagePagerAdapter = new MessagePagerAdapter(getSupportFragmentManager(), this);
        viewPager = (ViewPager) findViewById(R.id.activity_message_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.message_tabs);

        viewPager.setAdapter(messagePagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
