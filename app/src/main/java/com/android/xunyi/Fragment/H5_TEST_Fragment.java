package com.android.xunyi.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.android.xunyi.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/13.
 */

public class H5_TEST_Fragment extends Fragment {

    private RecyclerView mRecyclerView;
   // private ItemAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> items = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.h5_test_fragment, container, false);
        initView(view);
       // RelativeLayout rl= (RelativeLayout) view.findViewById(R.id.AR_draw);
/*        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                ComponentName cn=new ComponentName("com.YourCompany.xunyi","com.epicgames.ue4.SplashActivity");
                intent.setComponent(cn);
                startActivity(intent);
            }
        });*/
       // ButterKnife.bind(this, view);
        return view;
    }
    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.test_recyclerView);
        //列数为两列
        int spanCount = 2;
        mLayoutManager = new StaggeredGridLayoutManager(
                spanCount,
                StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //构建一个临时数据源
        for (int i = 0; i < 100; i++) {
            items.add("i:" + i);
        }
     //   mAdapter = new ItemAdapter(items);
     //   mRecyclerView.setAdapter(mAdapter);
    }
    @OnClick({ })
    public void chooseway(View v){
        switch (v.getId()){


            default:
                break;
        }
    }
}
