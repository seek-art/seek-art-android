package com.android.xunyi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.xunyi.Activity.TemplateActivity;
import com.android.xunyi.Entity.Template;
import com.android.xunyi.R;

import java.util.List;

/**
 * Created by zsd19 on 2018/3/26.
 */

public class TemplateAdapter extends RecyclerView.Adapter<TemplateAdapter.ViewHolder> {
    private List<Template> mTemplateList;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        View templateView;
        ImageView templateAvatar;
        TextView templateTitle;

        public ViewHolder(View v) {
            super(v);
            templateView = v;
            templateAvatar = (ImageView) v.findViewById(R.id.template_avatar);
            templateTitle = (TextView) v.findViewById(R.id.template_name);
        }
    }

    public TemplateAdapter(List<Template> mTemplateList) {
        this.mTemplateList = mTemplateList;
    }

    @Override
    public TemplateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_template_item, parent, false);
        final ViewHolder vh = new ViewHolder(view);
        vh.templateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = vh.getAdapterPosition();
                Template template = mTemplateList.get(position);
                TemplateActivity.actionStart(view.getContext(), template.getTitle(), template.getIntro(), template.getAvatarId());
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Template template = mTemplateList.get(position);
        holder.templateTitle.setText(template.getTitle());
        holder.templateAvatar.setImageResource(template.getAvatarId());
    }

    @Override
    public int getItemCount() {
        return mTemplateList.size();
    }
}
