package com.android.xunyi.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.xunyi.Fragment.H5Fragment;
import com.android.xunyi.Fragment.VRFragment;
import com.android.xunyi.Fragment.VideoFragment;

/**
 * Created by Administrator on 2017/3/18.
 */

public class H_V_FragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"办展","观展","VR"};
    private Context context;

    public H_V_FragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new H5Fragment();
            case 1:
                return  new VideoFragment();
            case 2:
                return new VRFragment();
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
