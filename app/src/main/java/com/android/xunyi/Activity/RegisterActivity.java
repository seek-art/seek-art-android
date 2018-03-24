package com.android.xunyi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.xunyi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.register_back)
    ImageView registerBack;
    @BindView(R.id.checkBox)
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({ R.id.register_back })
    public void chooseway(View v){
        switch (v.getId()){
            case R.id.register_back:
                Intent intent=new Intent(RegisterActivity.this,WelcomeActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }

}
