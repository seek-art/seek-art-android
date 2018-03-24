package com.android.xunyi.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.xunyi.Activity.ZoomImageView_Activity;
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

public class IntroduceFragment extends Fragment {
    private RecyclerView recyclerView;

    private SixCard[] cards={new SixCard(R.drawable.three1),new SixCard(R.drawable.three2),new SixCard(R.drawable.three3),new SixCard(R.drawable.three4),new SixCard(R.drawable.three5),new SixCard(R.drawable.three6)};
    private List<SixCard> cardList=new ArrayList<>();
    private SixCard_Adapter adapter;

    private RecyclerView user_recyclerView;
    private SixCard[] mUserimage={new SixCard(R.drawable.user1),new SixCard(R.drawable.user2),new SixCard(R.drawable.user3),new SixCard(R.drawable.user44),new SixCard(R.drawable.user55),new SixCard(R.drawable.user66)};
    private List<SixCard> mUserimagesList=new ArrayList<>();
    private UserImages_Adapter mUserAdapter;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.social_introduce,container,false);
            initImageList();
            recyclerView= (RecyclerView) view.findViewById(R.id.intro_recyclerview);
            GridLayoutManager layoutManager=new GridLayoutManager(MyApplication.getContext(),3);
            recyclerView.setLayoutManager(layoutManager);
            adapter=new SixCard_Adapter(cardList);
            recyclerView.setAdapter(adapter);

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





            return view;
        }
    private void initImageList() {
        cardList.clear();

        for(int i=0;i<cards.length;i++){
            cardList.add(cards[i]);
        }

        mUserimagesList.clear();
        for(int i=0;i<mUserimage.length;i++){
            mUserimagesList.add(mUserimage[i]);
        }

    }


}
