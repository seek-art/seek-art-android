package com.android.xunyi.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.android.xunyi.Adapter.CompanyListAdapter;
import com.android.xunyi.Entity.Company;
import com.android.xunyi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsd19 on 2018/3/24.
 */

public class CompanyListActivity extends AppCompatActivity {
    private List<Company> companyList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.company_list_toolbar);
        mToolbar.setTitle("企业文化");
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.company_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CompanyListAdapter adapter = new CompanyListAdapter(companyList);
        recyclerView.setAdapter(adapter);
    }

    public void initFruits() {
        Company apple = new Company(1, "Apple", "苹果公司，原称苹果电脑公司，是源于美国的跨国科技公司，总部位于美国加州库比蒂诺。", R.drawable.company_apple, R.drawable.company_1_img);
        Company ms = new Company(2, "MicroSoft", "微软是美国一家跨国电脑科技公司，以研发、制造、授权和提供广泛的电脑软件服务为主。", R.drawable.company_ms, R.drawable.company_2_img);
        companyList.add(apple);
        companyList.add(ms);
    }
}
