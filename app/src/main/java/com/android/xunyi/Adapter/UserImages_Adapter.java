package com.android.xunyi.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.xunyi.Entity.SixCard;
import com.android.xunyi.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */

public class UserImages_Adapter extends RecyclerView.Adapter<UserImages_Adapter.ViewHolder> {
    private Context mContext;
    private List<SixCard> mUserImagesList;
    private List<Integer> mHeights;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;

    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.user_images);

        }
    }

    public UserImages_Adapter(List<SixCard> mUserImagesList) {
        this.mUserImagesList = mUserImagesList;
        mHeights = new ArrayList<Integer>();
        for (int i = 0; i < mUserImagesList.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        SixCard images = mUserImagesList.get(position);
        Glide.with(mContext).load(images.getImgId()).into(holder.img);

        if (mOnItemClickListener != null) {
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.img, pos);
                }
            });

            holder.img.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.img, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mUserImagesList.size();
    }

    public void removeData(int position) {
        notifyItemRemoved(position);
    }
    
}