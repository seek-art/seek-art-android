package com.android.xunyi.Adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.xunyi.Entity.Exhibition;
import com.android.xunyi.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by zsd19 on 2018/3/25.
 */

public class ExhibitionListAdapter extends RecyclerView.Adapter<ExhibitionListAdapter.ViewHolder> {
    private List<Exhibition> mData; //定义数据源
    public static class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView avatar;
        TextView name;
        TextView intro;
        View exhibitionView;

        public ViewHolder(View itemView) {
            super(itemView);
            exhibitionView = itemView;
            avatar = (SimpleDraweeView) itemView.findViewById(R.id.exhibition_avatar);
            intro = (TextView) itemView.findViewById(R.id.exhibition_intro);
            name = (TextView) itemView.findViewById(R.id.exhibition_name);
        }
    }

    public ExhibitionListAdapter(List<Exhibition> mData) {
        this.mData = mData;
    }

    @Override
    public ExhibitionListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.acitivity_exhibition_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Exhibition exhibition = mData.get(position);
        Uri uri = Uri.parse(exhibition.avatarUrl);
        holder.avatar.setImageURI(uri);
        holder.name.setText(exhibition.getName());
        holder.avatar.getLayoutParams().height = exhibition.imgHeight;
        holder.intro.setText(exhibition.getIntro());
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }
}
