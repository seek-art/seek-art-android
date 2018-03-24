package com.android.xunyi.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.xunyi.Fragment.CareFragment;
import com.android.xunyi.Fragment.IntroduceFragment;
import com.android.xunyi.Fragment.LastFragment;

/**
 * Created by Administrator on 2017/3/18.
 */

public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    private String[] tabTilte;
    public MyFragmentStatePagerAdapter(FragmentManager fm, String[] tabTitle) {
        super(fm);
        this.tabTilte = tabTitle;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new IntroduceFragment();
            case 1:
                return new CareFragment();
            case 2:
                return  new LastFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabTilte.length;
    }
}
