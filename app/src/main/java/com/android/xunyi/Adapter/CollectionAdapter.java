package com.android.xunyi.Adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.xunyi.Entity.MyCollection;
import com.android.xunyi.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by zsd19 on 2018/3/25.
 */

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ViewHolder> {
    private List<MyCollection> mData; //定义数据源

    public static class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView avatar;
        TextView name;
        TextView intro;
        View collectionView;

        public ViewHolder(View itemView) {
            super(itemView);
            collectionView = itemView;
            avatar = (SimpleDraweeView) itemView.findViewById(R.id.collection_avatar);
            intro = (TextView) itemView.findViewById(R.id.collection_intro);
            name = (TextView) itemView.findViewById(R.id.collection_name);
        }
    }

    public CollectionAdapter(List<MyCollection> mData) {
        this.mData = mData;
    }

    @Override
    public CollectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_collection_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        MyCollection myCollection = mData.get(position);
        Uri uri = Uri.parse(myCollection.avatarUrl);
        holder.avatar.setImageURI(uri);
        holder.name.setText(myCollection.getName());
        holder.avatar.getLayoutParams().height = myCollection.imgHeight; //从数据源中获取图片高度，动态设置到控件上
        holder.intro.setText(myCollection.getIntro());
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

}
