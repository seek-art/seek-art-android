package com.android.xunyi.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.xunyi.Entity.ImageH5;
import com.android.xunyi.Entity.SixCard;
import com.android.xunyi.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */

public class SixCard_Adapter extends RecyclerView.Adapter<SixCard_Adapter.ViewHolder>{
    private Context mContext;
    private List<SixCard> mSixCardList;



    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;

        public ViewHolder(View view){
            super(view);
            img= (ImageView) view.findViewById(R.id.card);

        }
    }

    public SixCard_Adapter(List<SixCard> mSixCardList) {
        this.mSixCardList = mSixCardList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.sixcard_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SixCard card=mSixCardList.get(position);
        Glide.with(mContext).load(card.getImgId()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mSixCardList.size();
    }
}
