package com.android.xunyi.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.xunyi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity  {

    @BindView(R.id.toRegister)
    Button toRegister;
    @BindView(R.id.toSignUp)
    Button toSignUp;
    @BindView(R.id.qq_sigup)
    ImageView qqSigup;
    @BindView(R.id.wechat_sigup)
    ImageView wechatSigup;
    @BindView(R.id.weibo_signup)
    ImageView weiboSignup;
    @BindView(R.id.next_sigup)
    LinearLayout nextSigup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

    }

        @OnClick({ R.id.toRegister, R.id.toSignUp, R.id.next_sigup })
        public void chooseway(View v){
            switch (v.getId()){
                case R.id.toRegister:
                    Intent intent=new Intent(WelcomeActivity.this,RegisterActivity.class);
                    startActivity(intent);
                    break;
                case R.id.toSignUp:
                    Intent intent2=new Intent(WelcomeActivity.this,LoginActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.next_sigup:
                    Intent intent3=new Intent(WelcomeActivity.this,Home_Activity.class);
                    startActivity(intent3);
                    break;
                default:
                    break;
            }
        }

    @OnClick({ R.id.qq_sigup, R.id.weibo_signup, R.id.wechat_sigup })
    public void toToast(View v){
        Toast.makeText(this,"正在火速开发中....",Toast.LENGTH_SHORT).show();
    }

}
