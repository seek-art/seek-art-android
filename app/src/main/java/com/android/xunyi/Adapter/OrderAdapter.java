package com.android.xunyi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.xunyi.Entity.Ysys;
import com.android.xunyi.R;

import java.util.List;

/**
 * Created by zsd19 on 2018/3/25.
 */

public class  OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private List<Ysys> ysysList;

    public OrderAdapter(List<Ysys> ysysList) {
        this.ysysList = ysysList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View orderView;
        ImageView orderAvatar;
        TextView orderName;
        TextView orderPrice;

        public ViewHolder(View v) {
            super(v);
            orderView = v;
            orderAvatar = (ImageView) v.findViewById(R.id.order_avatar);
            orderName = (TextView) v.findViewById(R.id.order_name);
            orderPrice = (TextView) v.findViewById(R.id.order_price);
        }
    }

    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        final ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Ysys ysys = ysysList.get(position);
        holder.orderAvatar.setImageResource(ysys.getImageId());
        holder.orderName.setText(ysys.getName());
        holder.orderPrice.setText(ysys.getPrice());
    }

    @Override
    public int getItemCount() {
        return ysysList.size();
    }
}
