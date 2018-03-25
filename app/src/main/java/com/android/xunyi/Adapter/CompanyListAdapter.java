package com.android.xunyi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.xunyi.Activity.CompanyDetailActivity;
import com.android.xunyi.Entity.Company;
import com.android.xunyi.R;

import java.util.List;

/**
 * Created by zsd19 on 2018/3/24.
 */

public class CompanyListAdapter extends RecyclerView.Adapter<CompanyListAdapter.ViewHolder> {
    private List<Company> mCompanyList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View companyView;
        ImageView companyAvatar;
        TextView companyName;
        TextView companyBrief;

        public ViewHolder(View v) {
            super(v);
            companyView = v;
            companyAvatar = (ImageView) v.findViewById(R.id.company_avatar);
            companyName = (TextView) v.findViewById(R.id.company_name);
            companyBrief = (TextView) v.findViewById(R.id.company_brief);

        }
    }

    public CompanyListAdapter(List<Company> companyList) {
        mCompanyList = companyList;
    }

    @Override
    public CompanyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.company_item, parent, false);
        final ViewHolder vh = new ViewHolder(view);
        vh.companyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = vh.getAdapterPosition();
                Company company = mCompanyList.get(position);
                CompanyDetailActivity.actionStart(view.getContext(), company.getName(), company.getBrief(), company.getImageId());
            }
        });
        return vh;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        Company company = mCompanyList.get(position);
        holder.companyAvatar.setImageResource(company.getAvatarId());
        holder.companyName.setText(company.getName());
        holder.companyBrief.setText(company.getBrief());
    }

    @Override
    public int getItemCount() {
        return mCompanyList.size();
    }
}
