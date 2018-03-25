package com.android.xunyi.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.android.xunyi.R;

public class MorePopWin extends PopupWindow {

    private Context mContext;

    private View view;

    private Button btn_show1, btn_show2,btn_show3,btn_show4, btn_cancel;


    public MorePopWin(Context mContext, View.OnClickListener itemsOnClick) {

        this.view = LayoutInflater.from(mContext).inflate(R.layout.more_pop, null);

        btn_show1 = (Button) view.findViewById(R.id.more_pop_show);
        btn_show2 = (Button) view.findViewById(R.id.more_pop_cate);
        btn_show3 = (Button) view.findViewById(R.id.more_pop_vr);
        btn_show4 = (Button) view.findViewById(R.id.more_company);
        btn_cancel = (Button) view.findViewById(R.id.more_pop_return);
        // 取消按钮
        btn_cancel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // 销毁弹出框
                dismiss();
            }
        });
        // 设置按钮监听
        btn_show1.setOnClickListener(itemsOnClick);
        btn_show2.setOnClickListener(itemsOnClick);
        btn_show3.setOnClickListener(itemsOnClick);
        btn_show4.setOnClickListener(itemsOnClick);


        // 设置外部可点击
        this.setOutsideTouchable(true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        this.view.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                int height = view.findViewById(R.id.pop_layout).getTop();

                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });


    /* 设置弹出窗口特征 */
        // 设置视图
        this.setContentView(this.view);
        // 设置弹出窗体的宽和高
        this.setHeight(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);

        // 设置弹出窗体可点击
        this.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xbb000000);
        // 设置弹出窗体的背景
        this.setBackgroundDrawable(dw);

        // 设置弹出窗体显示时的动画，从底部向上弹出
        this.setAnimationStyle(R.style.take_photo_anim);

    }
}