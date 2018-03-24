package com.android.xunyi.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.android.xunyi.Adapter.H5_Image_Adapter;
import com.android.xunyi.Entity.ImageH5;
import com.android.xunyi.R;
import com.android.xunyi.Utils.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/18.
 */

public class H5Fragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private Context context ;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private ImageH5[] imgh5={new ImageH5(R.drawable.h1),new ImageH5(R.drawable.h2),new ImageH5(R.drawable.h3),new ImageH5(R.drawable.h4),new ImageH5(R.drawable.h5),new ImageH5(R.drawable.h6)};
    private List<ImageH5>h5List=new ArrayList<>();
    private H5_Image_Adapter adapter;
    private Handler handler;
    private final static int REFRESH=1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       final View view=inflater.inflate(R.layout.h5_fragment,container,false);
        initImageList();
        initView(view);
        context=getContext();
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.black));

        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch(msg.what){
                    case REFRESH:
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(MyApplication.getContext(),"刷新成功",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        return  view;
    }

    private void initImageList() {
        h5List.clear();
        for(int i=0;i<imgh5.length;i++){
            h5List.add(imgh5[i]);
        }
    }

    private void initView(View view) {
        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.h5_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView= (RecyclerView) view.findViewById(R.id.h5_recyclerview);
        GridLayoutManager layoutManager=new GridLayoutManager(MyApplication.getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new H5_Image_Adapter(h5List);
        recyclerView.setAdapter(adapter);
    }

    private void refreshH5() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                    Message message = new Message();
                    message.what=REFRESH;
                    handler.sendMessage(message);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    @Override
    public void onRefresh() {
      refreshH5();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
