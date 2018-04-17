package com.android.xunyi.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.android.xunyi.Adapter.MyStepperAdapter;
import com.android.xunyi.R;
import com.stepstone.stepper.StepperLayout;

/**
 * Created by zsd19 on 2018/4/14.
 */

public class CustomizeActivity extends AppCompatActivity {

    private StepperLayout mStepperLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.my_customize_toolbar);
        mToolbar.setTitle("个性化定制");

        mStepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
        mStepperLayout.setAdapter(new MyStepperAdapter(getSupportFragmentManager(), this));
    }
}
