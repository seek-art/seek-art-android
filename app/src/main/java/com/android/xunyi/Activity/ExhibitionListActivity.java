package com.android.xunyi.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
        String[] names = {"神庙画展", "神庙画展", "神庙画展", "神庙画展"};
        String[] intros = {
                "投身于古典气息的神庙，充分领略现代画作带来的魅力吧",
                "投身于古典气息的神庙，充分领略现代画作带来的魅力吧",
                "投身于古典气息的神庙，充分领略现代画作带来的魅力吧",
                "投身于古典气息的神庙，充分领略现代画作带来的魅力吧",
        };
        String[] imgUrs = {
                "http://o6ljw8wcq.bkt.clouddn.com/xunyi/temple.png",
                "http://o6ljw8wcq.bkt.clouddn.com/xunyi/temple.png",
                "http://o6ljw8wcq.bkt.clouddn.com/xunyi/temple.png",
                "http://o6ljw8wcq.bkt.clouddn.com/xunyi/temple.png"
        };
        List<Exhibition> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Exhibition p = new Exhibition(names[i], imgUrs[i], intros[i], (i % 2) * 100 + 400);
            list.add(p);
        }
        return list;
    }

}
