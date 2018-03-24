package com.android.xunyi.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.xunyi.Adapter.H_V_FragmentPagerAdapter;
import com.android.xunyi.R;

public class H5_VR_Activity extends AppCompatActivity {

    private H_V_FragmentPagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5__vr_);

        pagerAdapter = new H_V_FragmentPagerAdapter(getSupportFragmentManager(), this);
        viewPager = (ViewPager) findViewById(R.id.H_V_viewPager);
        tabLayout = (TabLayout) findViewById(R.id.H_V_tablayout);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

    }
}
