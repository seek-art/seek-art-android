package com.android.xunyi.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.xunyi.Adapter.OrderAdapter;
import com.android.xunyi.Entity.Ysys;
import com.android.xunyi.R;
import com.android.xunyi.Utils.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsd19 on 2018/3/25.
 */

public class AllOrdersFragment extends Fragment {
    private View view;
    private List<Ysys> ysysList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.all_orders_fragment, container, false);
        initOrdersList();
        initView();
        return view;
    }

    private void initView() {
        recyclerView = (RecyclerView) view.findViewById(R.id.all_orders_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getContext());
        recyclerView.setLayoutManager(layoutManager);
        orderAdapter = new OrderAdapter(ysysList);
        recyclerView.setAdapter(orderAdapter);
    }

    private void initOrdersList() {
        Ysys ys1 = new Ysys(R.drawable.shoes,"艺术雪地靴","¥ 660");
        Ysys ys2 = new Ysys(R.drawable.chinese,"陶瓷","¥ 368");
        ysysList.add(ys1);
        ysysList.add(ys2);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
