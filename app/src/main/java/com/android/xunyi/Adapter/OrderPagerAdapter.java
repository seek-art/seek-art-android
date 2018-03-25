package com.android.xunyi.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.android.xunyi.Fragment.AllOrdersFragment;

/**
 * Created by zsd19 on 2018/3/25.
 */

public class OrderPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles [] = new String [] {"全部订单", "待支付", "支付成功"};
    private Context context;

    public OrderPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AllOrdersFragment();
            case 1:
                return  new AllOrdersFragment();
            case 2:
                return new AllOrdersFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
