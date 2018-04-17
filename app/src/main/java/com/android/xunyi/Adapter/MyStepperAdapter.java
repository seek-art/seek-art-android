package com.android.xunyi.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import com.android.xunyi.Fragment.CustomizeStepFourthFragment;
import com.android.xunyi.Fragment.CustomizeStepOneFragment;
import com.android.xunyi.Fragment.CustomizeStepThreeFragment;
import com.android.xunyi.Fragment.CustomizeStepTwoFragment;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

/**
 * Created by zsd19 on 2018/4/14.
 */

public class MyStepperAdapter extends AbstractFragmentStepAdapter {
    public MyStepperAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        Bundle b = new Bundle();
        b.putInt("CURRENT_STEP_POSITION_KEY", position);
        switch (position) {
            case 0:
                return new CustomizeStepOneFragment();
            case 1:
                return new CustomizeStepTwoFragment();
            case 2:
                return new CustomizeStepThreeFragment();
            case 3:
                return new CustomizeStepFourthFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        //Override this method to set Step title for the Tabs, not necessary for other stepper types
        return new StepViewModel.Builder(context)
                .create();
    }
}
