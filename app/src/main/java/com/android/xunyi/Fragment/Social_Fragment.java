package com.android.xunyi.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.xunyi.Adapter.MyFragmentStatePagerAdapter;
import com.android.xunyi.R;


/**
 * Created by Administrator on 2017/3/13.
 */

public class Social_Fragment extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String[] tabTitle = {"推荐","关注","最新"};//每个页面顶部标签的名字


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_social, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        initData();
        return view;
    }

    private void initData() {

        for (int i=0; i<tabTitle.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabTitle[i]));
        }

        //这里注意的是，因为我是在fragment中创建MyFragmentStatePagerAdapter，所以要传getChildFragmentManager()
        viewPager.setAdapter(new MyFragmentStatePagerAdapter(getChildFragmentManager(),tabTitle));
        //在设置viewpager页面滑动监听时，创建TabLayout的滑动监听
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //在选中的顶部标签时，为viewpager设置currentitem
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
