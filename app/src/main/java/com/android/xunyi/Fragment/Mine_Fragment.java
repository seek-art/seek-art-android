package com.android.xunyi.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.android.xunyi.Activity.ExhibitionListActivity;
import com.android.xunyi.Activity.MyCollectionActivity;
import com.android.xunyi.Activity.OrderActivity;
import com.android.xunyi.R;
import com.android.xunyi.Utils.MyApplication;
import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by Administrator on 2017/3/13.
 */

public class Mine_Fragment extends Fragment {
    MaterialDialog mMaterialDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mine, container, false);
        RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.AR_draw);
//        RelativeLayout r2=(RelativeLayout) view.findViewById(R.id.img_updateArt);
        RelativeLayout myCollection = (RelativeLayout) view.findViewById(R.id.my_collection);
        RelativeLayout myOrder = (RelativeLayout) view.findViewById(R.id.my_order);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//               mMaterialDialog = new MaterialDialog(getActivity())
//                        .setTitle("选择展示模式")
//                        .setMessage(" ")
//                        .setPositiveButton("VR模式", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Intent intent=new Intent(Intent.ACTION_MAIN);
//                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
//                                ComponentName cn=new ComponentName("com.YourCompany.Museum_VR","com.epicgames.ue4.GameActivity");
//                                intent.setComponent(cn);
//                                startActivity(intent);
//                                mMaterialDialog.dismiss();
//
//                            }
//                        })
//                        .setNegativeButton("普通模式", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                Intent intent=new Intent(Intent.ACTION_MAIN);
//                                intent.addCategory(Intent.CATEGORY_LAUNCHER);
//                                ComponentName cn=new ComponentName("com.YourCompany.Museum_normal","com.epicgames.ue4.SplashActivity");
//                                intent.setComponent(cn);
//                                startActivity(intent);
//                                mMaterialDialog.dismiss();
//
//                            }
//                        });
//
//                mMaterialDialog.show();
                Intent exhibitionItent = new Intent(MyApplication.getContext(), ExhibitionListActivity.class);
                startActivity(exhibitionItent);
            }
        });

//        r2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2=new Intent(MyApplication.getContext(), UploadImage.class);
//                startActivity(intent2);
//            }
//        });

        myCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent collectionIntent = new Intent(MyApplication.getContext(), MyCollectionActivity.class);
                startActivity(collectionIntent);
            }
        });

        myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderIntent = new Intent(MyApplication.getContext(), OrderActivity.class);
                startActivity(orderIntent);
            }
        });


        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({})
    public void chooseway(View v) {
        switch (v.getId()) {


            default:
                break;
        }
    }
}
