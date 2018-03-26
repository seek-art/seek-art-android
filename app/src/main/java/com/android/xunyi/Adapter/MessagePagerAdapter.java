package com.android.xunyi.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.android.xunyi.Fragment.ExhibitionNewsFragment;

/**
 * Created by zsd19 on 2018/3/26.
 */

public class MessagePagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles [] = new String [] {"展览动态", "系统消息", "话题动态"};
    private Context context;

    public MessagePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ExhibitionNewsFragment();
            case 1:
                return  new ExhibitionNewsFragment();
            case 2:
                return new ExhibitionNewsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
