package com.android.xunyi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.xunyi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.search_cancel)
    TextView searchCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
    }

    @OnClick({ R.id.search_cancel })
    public void chooseway(View v){
        switch (v.getId()){
            case R.id.search_cancel:
                Intent intent=new Intent(SearchActivity.this,Home_Activity.class);
                startActivity(intent);
                finish();
                break;

            default:
                break;
        }
    }
}
