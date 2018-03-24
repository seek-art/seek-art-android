package com.android.xunyi.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.xunyi.Activity.ZoomImageView_Activity;
import com.android.xunyi.Adapter.ShoppingAdapter;
import com.android.xunyi.Adapter.SixCard_Adapter;
import com.android.xunyi.Adapter.UserImages_Adapter;
import com.android.xunyi.Entity.SixCard;
import com.android.xunyi.R;
import com.android.xunyi.Utils.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */

public class CareFragment extends Fragment {

    private RecyclerView user_recyclerView;
    private SixCard[] mUserimage={new SixCard(R.drawable.care1),new SixCard(R.drawable.care2),new SixCard(R.drawable.care3),new SixCard(R.drawable.care4),new SixCard(R.drawable.care5),new SixCard(R.drawable.care6)};
    private List<SixCard> mUserimagesList=new ArrayList<>();
    private UserImages_Adapter mUserAdapter;

    private RecyclerView user_recyclerView1;
    private SixCard[] mUserimage1={new SixCard(R.drawable.star1),new SixCard(R.drawable.star2),new SixCard(R.drawable.star3),new SixCard(R.drawable.star4),new SixCard(R.drawable.star5),new SixCard(R.drawable.star6)};
    private List<SixCard> mUserimagesList1=new ArrayList<>();
    private UserImages_Adapter mUserAdapter1;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           View view=inflater.inflate(R.layout.social_care,container,false);
            initImageList();

            user_recyclerView=(RecyclerView) view.findViewById(R.id.usershow_recyclerview);
            GridLayoutManager layoutManager2=new GridLayoutManager(MyApplication.getContext(),3);
            user_recyclerView.setLayoutManager(layoutManager2);
            mUserAdapter=new UserImages_Adapter(mUserimagesList);
            user_recyclerView.setAdapter(mUserAdapter);


            mUserAdapter.setOnItemClickListener(new UserImages_Adapter.OnItemClickListener(){

                @Override
                public void onItemClick(View view, int position) {
                    Intent intent = new Intent(MyApplication.getContext(), ZoomImageView_Activity.class);
                    int imageId=mUserimage[position].getImgId();
                    intent.putExtra("ImageId",imageId+"");
                    startActivity(intent);

                }

                @Override
                public void onItemLongClick(View view, int position) {
                    Toast.makeText(MyApplication.getContext(), "长按事件", Toast.LENGTH_SHORT).show();
                }
            });







            user_recyclerView1=(RecyclerView) view.findViewById(R.id.usershow_recyclerview1);
            GridLayoutManager layoutManager1=new GridLayoutManager(MyApplication.getContext(),3);
            user_recyclerView1.setLayoutManager(layoutManager1);
            mUserAdapter1=new UserImages_Adapter(mUserimagesList1);
            user_recyclerView1.setAdapter(mUserAdapter1);



            mUserAdapter1.setOnItemClickListener(new UserImages_Adapter.OnItemClickListener(){

                @Override
                public void onItemClick(View view, int position) {
                    Intent intent = new Intent(MyApplication.getContext(), ZoomImageView_Activity.class);
                    int imageId=mUserimage[position].getImgId();
                    intent.putExtra("ImageId",imageId+"");
                    startActivity(intent);

                }

                @Override
                public void onItemLongClick(View view, int position) {
                    Toast.makeText(MyApplication.getContext(), "长按事件", Toast.LENGTH_SHORT).show();
                }
            });






            return view;
        }

    private void initImageList() {
        mUserimagesList.clear();
        for(int i=0;i<mUserimage.length;i++){
            mUserimagesList.add(mUserimage[i]);
        }

        mUserimagesList1.clear();
        for(int i=0;i<mUserimage1.length;i++){
            mUserimagesList1.add(mUserimage1[i]);
        }

    }

}
