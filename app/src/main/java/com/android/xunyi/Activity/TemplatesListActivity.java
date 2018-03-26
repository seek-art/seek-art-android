package com.android.xunyi.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.android.xunyi.Adapter.TemplateAdapter;
import com.android.xunyi.Entity.Template;
import com.android.xunyi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsd19 on 2018/3/26.
 */
// Todo
public class TemplatesListActivity extends AppCompatActivity {
    private List<Template> templateList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);
        Toolbar mToolBar = (Toolbar) findViewById(R.id.my_templates_toolbar);
        mToolBar.setTitle("根据您的需求，我们推荐如下模板");
        setSupportActionBar(mToolBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        initTemplates();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.templates_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TemplateAdapter adapter = new TemplateAdapter(templateList);
        recyclerView.setAdapter(adapter);
    }

    public void initTemplates() {
//        Template scientific = new Template(1, "酷炫科技风", R.drawable.)
    }
}
