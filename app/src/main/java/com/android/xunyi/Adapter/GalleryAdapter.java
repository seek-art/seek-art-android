package com.android.xunyi.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.xunyi.CustomView.GlideImageLoader;
import com.android.xunyi.Entity.Gallery;
import com.android.xunyi.R;
import com.android.xunyi.Utils.LogUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */

public class GalleryAdapter  extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>{
    private Context mContext;
    private List<Gallery> mGalleryList;



    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout gallery_linearLayout;
        Banner gallery_banner;
        TextView gallery_name;
        TextView gallery_place;
        TextView gallery_time;

        public ViewHolder(View view){
            super(view);
            gallery_linearLayout= (LinearLayout) view;
            gallery_banner= (Banner) view.findViewById(R.id.gallery_banner);
            gallery_name= (TextView) view.findViewById(R.id.gallery_name);
            gallery_place= (TextView) view.findViewById(R.id.gallery_place);
            gallery_time= (TextView) view.findViewById(R.id.gallery_time);
        }
    }

    public GalleryAdapter(List<Gallery> mGalleryList) {
        this.mGalleryList = mGalleryList;
        LogUtil.d("Test-------",mGalleryList.size()+"");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.gallery_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Gallery gallery=mGalleryList.get(position);

        holder.gallery_banner.setImages(gallery.getList()).setBannerAnimation(Transformer.ZoomOutSlide).isAutoPlay(false).setDelayTime(3000).setBannerStyle(BannerConfig.NUM_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .start();
        holder.gallery_name.setText(gallery.getName());
        holder.gallery_place.setText(gallery.getPlace());
        holder.gallery_time.setText(gallery.getTime());

    }

    @Override
    public int getItemCount() {
        return mGalleryList.size();
    }
}
