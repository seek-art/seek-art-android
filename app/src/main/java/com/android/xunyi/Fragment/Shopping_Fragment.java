package com.android.xunyi.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.android.xunyi.Activity.CustomizeActivity;
import com.android.xunyi.Activity.Shopping_item_details_Activity;
import com.android.xunyi.Activity.ZoomImageView_Activity;
import com.android.xunyi.CustomView.GlideImageLoader;
import com.android.xunyi.Entity.Ysys;
import com.android.xunyi.Adapter.ShoppingAdapter;
import com.android.xunyi.R;
import com.android.xunyi.Utils.MyApplication;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */

public class Shopping_Fragment extends Fragment{
    private Ysys [] ysyses={new Ysys(R.drawable.img_01,"造起来无框画","¥ 350"),new Ysys(R.drawable.img_06,"造起来无框画","¥ 350"),
            new Ysys(R.drawable.img_07,"造起来无框画","¥ 350"),
            new Ysys(R.drawable.img_08,"造起来无框画","¥ 350")};
    private Ysys [] ysyses2={new Ysys(R.drawable.shoes,"艺术雪地靴","¥ 660"),new Ysys(R.drawable.chinese,"陶瓷","¥ 368"),new Ysys(R.drawable.shoes,"艺术雪地靴","¥ 660"),
            new Ysys(R.drawable.chinese,"陶瓷","¥ 368")};
    private List<Ysys> YsysList=new ArrayList<>();
    private List<Ysys> YsysList2=new ArrayList<>();
    private ShoppingAdapter adapter;
    private ShoppingAdapter adapter2;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_shopping,container,false);

        Banner banner = (Banner) view.findViewById(R.id.shopping_banner);
        List<Integer> list=new ArrayList<>();
        list.add(R.drawable.shop1);
        list.add(R.drawable.shop2);
        banner.setImages(list).setBannerAnimation(Transformer.ZoomOutSlide).setDelayTime(3000)
                .setImageLoader(new GlideImageLoader())
                .start();




        initShoppingList();
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.recyclerview_ysys);
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ShoppingAdapter(YsysList);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickListener(new ShoppingAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(MyApplication.getContext(),Shopping_item_details_Activity.class);
                startActivity(intent);


            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MyApplication.getContext(), "长按事件", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerView2= (RecyclerView) view.findViewById(R.id.recyclerview_xydz);
        GridLayoutManager layoutManager2=new GridLayoutManager(getContext(),2);
        recyclerView2.setLayoutManager(layoutManager2);
        adapter2=new ShoppingAdapter(YsysList2);
        recyclerView2.setAdapter(adapter2);

        adapter2.setOnItemClickListener(new ShoppingAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MyApplication.getContext(), ZoomImageView_Activity.class);
                int imageId=ysyses2[position].getImageId();
                intent.putExtra("ImageId",imageId+"");
                startActivity(intent);
              /*  Intent intent=new Intent(MyApplication.getContext(),Shopping_item_details_Activity.class);
                startActivity(intent);*/

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MyApplication.getContext(), "长按事件", Toast.LENGTH_SHORT).show();
            }
        });


        // customizeBtn
        LinearLayout customizeBtn = (LinearLayout)  view.findViewById(R.id.customize_button);
        customizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent customizeIntent = new Intent(MyApplication.getContext(), CustomizeActivity.class);
                startActivity(customizeIntent);
            }
        });

        ViewFlipper vp= (ViewFlipper) view.findViewById(R.id.shopping_vf);
        vp.addView(View.inflate(MyApplication.getContext(),R.layout.ad_one,null));
        vp.addView(View.inflate(MyApplication.getContext(),R.layout.ad_two,null));
        vp.addView(View.inflate(MyApplication.getContext(),R.layout.ad_three,null));





        return view;
    }

    private void initShoppingList() {
        YsysList.clear();
        YsysList2.clear();
        for (int i=0;i<ysyses.length;i++){
            YsysList.add(ysyses[i]);
        }
        for (int i=0;i<ysyses2.length;i++){
            YsysList2.add(ysyses2[i]);
        }
    }
}
