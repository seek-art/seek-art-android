package com.android.xunyi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.xunyi.Entity.Ysys;
import com.android.xunyi.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder>{
    private Context mContext;
    private List<Ysys> mShoppingList;
    private List<Integer> mHeights;
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout shopping_linearLayout;
        ImageView shopping_pic;
        TextView shopping_name;
        TextView shopping_price;

        public ViewHolder(View view){
            super(view);
            shopping_linearLayout= (LinearLayout) view;
            shopping_pic= (ImageView) view.findViewById(R.id.shopping_pic);
            shopping_name= (TextView) view.findViewById(R.id.shopping_name);
            shopping_price= (TextView) view.findViewById(R.id.shopping_price);
        }
    }

    public ShoppingAdapter(List<Ysys> mShoppingList) {
        this.mShoppingList = mShoppingList;
        mHeights=new ArrayList<Integer>();
        for (int i=0;i<mShoppingList.size();i++){
            mHeights.add((int)(100+Math.random()*300));
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.shopping_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Ysys ysys=mShoppingList.get(position);
        holder.shopping_name.setText(ysys.getName());
        holder.shopping_price.setText(ysys.getPrice());
        Glide.with(mContext).load(ysys.getImageId()).into(holder.shopping_pic);

        if (mOnItemClickListener != null) {

            holder.shopping_pic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.shopping_pic,pos);
                }
            });

            holder.shopping_pic.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos=holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.shopping_pic,pos);

                    return false;
                }
            });





        }



    }

    @Override
    public int getItemCount() {
        return mShoppingList.size();
    }

    public void removeData(int position)
    {
//        mDatas.remove(position);//List或ArrayList才有添加移除方法

        notifyItemRemoved(position);
    }




}
