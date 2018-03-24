package com.android.xunyi.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.xunyi.CustomView.GlideImageLoader;
import com.android.xunyi.Entity.Gallery;
import com.android.xunyi.Adapter.GalleryAdapter;
import com.android.xunyi.R;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */

public class HomePage_Fragment extends Fragment{

    private GalleryAdapter adapter;
    List<Integer> list2=new ArrayList<Integer>(){{add(R.drawable.imm1);add(R.drawable.imm2);}};
    List<Integer> list3=new ArrayList<Integer>(){{add(R.drawable.imn1);add(R.drawable.imn2);add(R.drawable.cat3);add(R.drawable.cat4);add(R.drawable.cat5);}};
    List<Integer> list4=new ArrayList<Integer>(){{add(R.drawable.home0);add(R.drawable.home);add(R.drawable.home3);add(R.drawable.home4);add(R.drawable.home5);}};
    List<Integer> list5=new ArrayList<Integer>(){{add(R.drawable.art1);add(R.drawable.art2);add(R.drawable.art3);add(R.drawable.art4);add(R.drawable.art5);}};
    List<Integer> list6=new ArrayList<Integer>(){{add(R.drawable.model1);add(R.drawable.model2);add(R.drawable.model3);add(R.drawable.model4);add(R.drawable.model5);}};
    Gallery [] galleries={new Gallery(list2,"艺.无界-瑃燕","四九画廊 | 北京","2017.07.10-08.20"),new Gallery(list3,"吉莲.艾尔斯的抽象绘画","中央美术学院美术馆 | 北京","2017.07.30-08.27"),
            new Gallery(list4,"Monster","艾米李画廊 | 北京","2017.02.17-03.19"),new Gallery(list5,"Jimmy","艾米李画廊 | 北京","2017.02.17-03.19")};
    List<Gallery> lists=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_homepage,container,false);
        Banner banner = (Banner) view.findViewById(R.id.banner);
        initGalleryList();

        List<Integer> list=new ArrayList<>();
        list.add(R.mipmap.zhan1);
        list.add(R.mipmap.zhan2);
        list.add(R.mipmap.zhan3);
        banner.setImages(list).setBannerAnimation(Transformer.ZoomOutSlide).setDelayTime(3000)
                .setImageLoader(new GlideImageLoader())
                .start();


        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.recyclerview_gallery);
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new GalleryAdapter(lists);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void initGalleryList() {
        lists.clear();
        for (int i=0;i<galleries.length;i++){
            lists.add(galleries[i]);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
