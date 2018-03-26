package com.android.xunyi.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.android.xunyi.R;

/**
 * Created by zsd19 on 2018/3/26.
 */

public class TemplateActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        Toolbar mToolBar = (Toolbar) findViewById(R.id.template_toolbar);
        mToolBar.setTitle("模板详情");
        setSupportActionBar(mToolBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public static void actionStart(Context context, String templateName, String templateIntro,int templateImage) {
        Intent intent = new Intent(context, TemplateActivity.class);
        intent.putExtra("template_name", templateName);
        intent.putExtra("template_intro", templateIntro);
        intent.putExtra("template_image", templateImage);
        context.startActivity(intent);
    }
}
