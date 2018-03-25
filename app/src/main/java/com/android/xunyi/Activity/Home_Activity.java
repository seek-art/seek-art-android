package com.android.xunyi.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import com.android.xunyi.Fragment.*;
import com.android.xunyi.R;

public class Home_Activity extends BaseActivity implements View.OnClickListener {

    private MorePopWin takePhotoPopWin;

    private HomePage_Fragment fg1;
    private Social_Fragment fg2;
    private Shopping_Fragment fg3;
    private Mine_Fragment fg4;
    private H5Fragment fg5;
    private VideoFragment fg6;
    private VRFragment fg7;

    private FrameLayout flayout;

    private RelativeLayout homepage_layout;
    private RelativeLayout social_layout;
    private RelativeLayout shopping_layout;
    private RelativeLayout mine_layout;
    private RelativeLayout more_layout;

    private ImageView homepage_image;
    private ImageView social_image;
    private ImageView more_image;
    private ImageView shopping_image;
    private ImageView mine_image;

    private TextView homepage_text;
    private TextView social_text;
    private TextView shopping_text;
    private TextView mine_text;

    private int black = 0xFF000000;
    private int mblack = 0xFF979797;

    private FloatingActionButton fab;
    private FloatingActionButton fab2;
    private FloatingActionButton fab3;

    //定义FragmentManager对象
    FragmentManager fManager;
    private ScrollView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        initViews();
        fManager = getSupportFragmentManager();
        setChioceItem(0);

        sv = (ScrollView) findViewById(R.id.homesrollview);
        sv.smoothScrollTo(0, 20);

        if (ContextCompat.checkSelfPermission(Home_Activity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Home_Activity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    break;
                } else {
                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    private void initViews() {
        homepage_image = (ImageView) findViewById(R.id.homepage_image);
        social_image = (ImageView) findViewById(R.id.social_image);
        more_image = (ImageView) findViewById(R.id.more_image);
        shopping_image = (ImageView) findViewById(R.id.shopping_image);
        mine_image = (ImageView) findViewById(R.id.mine_image);

        homepage_text = (TextView) findViewById(R.id.homepage_text);
        social_text = (TextView) findViewById(R.id.social_text);
        shopping_text = (TextView) findViewById(R.id.shopping_text);
        mine_text = (TextView) findViewById(R.id.mine_text);

        homepage_layout = (RelativeLayout) findViewById(R.id.homepage_layout);
        social_layout = (RelativeLayout) findViewById(R.id.social_layout);
        shopping_layout = (RelativeLayout) findViewById(R.id.shopping_layout);
        more_layout = (RelativeLayout) findViewById(R.id.more_layout);
        mine_layout = (RelativeLayout) findViewById(R.id.mine_layout);

        sv = (ScrollView) findViewById(R.id.homesrollview);
        // fab= (FloatingActionButton) findViewById(R.id.plus);
        fab2 = (FloatingActionButton) findViewById(R.id.fangda);
        fab3 = (FloatingActionButton) findViewById(R.id.write);

        homepage_layout.setOnClickListener(this);
        social_layout.setOnClickListener(this);
        shopping_layout.setOnClickListener(this);
        mine_layout.setOnClickListener(this);
        more_layout.setOnClickListener(this);

        //  fab.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homepage_layout:
                setChioceItem(0);
                break;
            case R.id.social_layout:
                setChioceItem(1);
                break;
            case R.id.shopping_layout:
                setChioceItem(2);
                break;
            case R.id.mine_layout:
                setChioceItem(3);
                break;
            case R.id.plus:
                Intent intent2 = new Intent(Home_Activity.this, H5_VR_Activity.class);
                startActivity(intent2);
                break;
            case R.id.fangda:
                Intent intent = new Intent(Home_Activity.this, SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.write:
                Toast.makeText(this, "正在火速开发中....", Toast.LENGTH_SHORT).show();
                break;
            case R.id.more_layout:
                //Toast.makeText(this,"更多",Toast.LENGTH_SHORT).show();
                takePhotoPopWin = new MorePopWin(this, onClickListener);
                //showAtLocation(View parent, int gravity, int x, int y)
                takePhotoPopWin.showAtLocation(findViewById(R.id.activity_home_page), Gravity.CENTER, 0, 0);
            default:
                break;
        }
    }

    //定义一个选中一个item后的处理
    public void setChioceItem(int index) {
        //重置选项+隐藏所有Fragment
        FragmentTransaction transaction = fManager.beginTransaction();
        clearChioce();
        hideFragments(transaction);
        switch (index) {
            case 0:
                //fab.setVisibility(View.VISIBLE);
                fab2.setVisibility(View.VISIBLE);
                fab3.setVisibility(View.GONE);
                homepage_image.setImageResource(R.drawable.home2);
                homepage_text.setTextColor(black);

                if (fg1 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg1 = new HomePage_Fragment();
                    transaction.add(R.id.content, fg1);  //R.id.content--->framelayout

                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg1);
                    sv.smoothScrollTo(0, 20);
                }
                break;

            case 1:
                //fab.setVisibility(View.GONE);
                fab2.setVisibility(View.GONE);
                fab3.setVisibility(View.VISIBLE);
                social_image.setImageResource(R.drawable.social2);
                social_text.setTextColor(black);
                sv.smoothScrollTo(0, 20);
                if (fg2 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg2 = new Social_Fragment();
                    transaction.add(R.id.content, fg2);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg2);
                }
                break;

            case 2:
                //fab.setVisibility(View.GONE);
                fab2.setVisibility(View.GONE);
                fab3.setVisibility(View.GONE);
                shopping_image.setImageResource(R.drawable.shopping2);
                shopping_text.setTextColor(black);
                sv.smoothScrollTo(0, 20);
                if (fg3 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg3 = new Shopping_Fragment();
                    transaction.add(R.id.content, fg3);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg3);
                }
                break;

            case 3:
                //fab.setVisibility(View.GONE);
                fab2.setVisibility(View.GONE);
                fab3.setVisibility(View.GONE);
                mine_image.setImageResource(R.drawable.mine2);
                mine_text.setTextColor(black);
                sv.smoothScrollTo(0, 20);
                if (fg4 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg4 = new Mine_Fragment();
                    transaction.add(R.id.content, fg4);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg4);
                }
                break;
            case 4:
                Intent intent2 = new Intent(Home_Activity.this, H5_VR_Activity.class);
                startActivity(intent2);
                if (fg1 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg1 = new HomePage_Fragment();
                    transaction.add(R.id.content, fg1);  //R.id.content--->framelayout

                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg1);
                    sv.smoothScrollTo(0, 20);
                }
                break;
            case 5:
                //fab.setVisibility(View.GONE);
                fab2.setVisibility(View.GONE);
                fab3.setVisibility(View.GONE);
                sv.smoothScrollTo(0, 20);
                if (fg6 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg6 = new VideoFragment();
                    transaction.add(R.id.content, fg6);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg6);
                }
                break;
            case 6:
                //fab.setVisibility(View.GONE);
                fab2.setVisibility(View.GONE);
                fab3.setVisibility(View.GONE);
                sv.smoothScrollTo(0, 20);
                if (fg7 == null) {
                    // 如果fg1为空，则创建一个并添加到界面上
                    fg7 = new VRFragment();
                    transaction.add(R.id.content, fg7);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(fg7);
                }
                break;
        }
        transaction.commit();
    }

    //隐藏所有的Fragment,避免fragment混乱
    private void hideFragments(FragmentTransaction transaction) {
        if (fg1 != null) {
            transaction.hide(fg1);
        }
        if (fg2 != null) {
            transaction.hide(fg2);
        }
        if (fg3 != null) {
            transaction.hide(fg3);
        }
        if (fg4 != null) {
            transaction.hide(fg4);
        }
        if (fg5 != null) {
            transaction.hide(fg5);
        }
        if (fg6 != null) {
            transaction.hide(fg6);
        }
        if (fg7 != null) {
            transaction.hide(fg7);
        }
    }

    //定义一个重置所有选项的方法
    public void clearChioce() {
        homepage_image.setImageResource(R.drawable.home1);
        homepage_text.setTextColor(mblack);
        social_image.setImageResource(R.drawable.social1);
        social_text.setTextColor(mblack);
        shopping_image.setImageResource(R.drawable.shopping1);
        shopping_text.setTextColor(mblack);
        mine_image.setImageResource(R.drawable.mine1);
        mine_text.setTextColor(mblack);
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.more_pop_show:
                    setChioceItem(4);
                    takePhotoPopWin.dismiss();
                    break;
                case R.id.more_pop_cate:
                    setChioceItem(5);
                    takePhotoPopWin.dismiss();
                    break;
                case R.id.more_pop_vr:
                    setChioceItem(6);
                    takePhotoPopWin.dismiss();
                    break;
                case R.id.more_company:
                    Intent intent = new Intent(Home_Activity.this, CompanyListActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

}
