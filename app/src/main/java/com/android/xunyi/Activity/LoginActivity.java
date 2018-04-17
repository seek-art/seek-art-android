package com.android.xunyi.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.android.xunyi.R;
import com.android.xunyi.Utils.MyApplication;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_back)
    ImageView loginBack;
    @BindView(R.id.sign_phone)
    EditText signPhone;
    @BindView(R.id.sign_password)
    EditText signPassword;
    @BindView(R.id.toSignup)
    Button toSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }



    @OnClick({R.id.login_back,R.id.toSignup})
    public void chooseway(View v) {
        switch (v.getId()) {
            case R.id.login_back:
                Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.toSignup:
                login();
                break;

            default:
                break;
        }
    }

    private void login() {
        String phone=signPhone.getText().toString().trim();
        String passworld=signPassword.getText().toString().trim();
        if(phone.equals("13888888888")&&passworld.equals("123456"))
        {
            final ProgressDialog progressDialog=new ProgressDialog(LoginActivity.this,R.style.AppTheme_Dark_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("登录中....");
            progressDialog.show();

            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.dismiss();
                }
            },4000);

            Toast.makeText(MyApplication.getContext(),"登录成功,欢迎Marvin",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MyApplication.getContext(),Home_Activity.class);
            startActivity(intent);

        }else{
            Toast.makeText(MyApplication.getContext(),"用户名或密码错误",Toast.LENGTH_SHORT).show();
        }


    }
}
