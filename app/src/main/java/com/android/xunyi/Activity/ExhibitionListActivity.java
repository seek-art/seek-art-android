package com.android.xunyi.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.android.xunyi.Adapter.ExhibitionListAdapter;
import com.android.xunyi.Entity.Exhibition;
import com.android.xunyi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsd19 on 2018/3/25.
 */

public class ExhibitionListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ExhibitionListAdapter exhibitionListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibition_list);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.exhibition_list_toolbar);
        mToolbar.setTitle("展览");
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        init();
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.exhibition_list);
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        exhibitionListAdapter = new ExhibitionListAdapter(buildData());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(exhibitionListAdapter);
    }

    private List<Exhibition> buildData() {
        String[] names = {"神庙画展", "艺术收藏馆", "欧式简约风", "简洁素雅"};
        String[] intros = {
                "投身于古典气息的神庙，充分领略现代画作带来的魅力吧",
                "这个拥有三层空间的收藏馆囊括了蚀刻版画、釉瓷以及绿松石艺术品",
                "仿照欧式风格的办公场所，简约的布置风格和宽敞的空间使人心情舒畅",
                "投身于古典气息的神庙，充分领略现代画作带来的魅力吧",
        };
        String[] imgUrs = {
                "http://103.80.27.100:8008/immortal/temple.png",
                "http://103.80.27.100:8008/immortal/all8.png",
                "http://103.80.27.100:8008/immortal/all12.png",
                "http://103.80.27.100:8008/immortal/all5.png"
        };
        List<Exhibition> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Exhibition p = new Exhibition(names[i], imgUrs[i], intros[i], (i % 2) * 100 + 400);
            list.add(p);
        }
        return list;
    }

}
