package com.android.xunyi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.xunyi.Activity.Show_H5_Activity;
import com.android.xunyi.CustomView.GlideImageLoader;
import com.android.xunyi.Entity.Gallery;
import com.android.xunyi.Entity.ImageH5;
import com.android.xunyi.R;
import com.android.xunyi.Utils.LogUtil;
import com.android.xunyi.Utils.MyApplication;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */

public class H5_Image_Adapter extends RecyclerView.Adapter<H5_Image_Adapter.ViewHolder>{
    private Context mContext;
    private List<ImageH5> mH5List;



    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        CardView cardView;

        public ViewHolder(View view){
            super(view);
            cardView= (CardView) view;
            img= (ImageView) view.findViewById(R.id.h5_img);

        }
    }

    public H5_Image_Adapter(List<ImageH5> mH5List) {
        this.mH5List = mH5List;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.h5_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Intent intent=new Intent(mContext, Show_H5_Activity.class);

                mContext.startActivity(intent);

            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageH5 h5=mH5List.get(position);
        Glide.with(mContext).load(h5.getImageId()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mH5List.size();
    }
}
