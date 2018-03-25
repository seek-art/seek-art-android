package com.android.xunyi.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.xunyi.R;

/**
 * Created by zsd19 on 2018/3/25.
 */

public class CompanyDetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView content;

    public static void actionStart(Context context, String companyName, String companyIntro,int companyImage) {
        Intent intent = new Intent(context, CompanyDetailActivity.class);
        intent.putExtra("company_name", companyName);
        intent.putExtra("company_intro", companyIntro);
        intent.putExtra("company_image", companyImage);
        context.startActivity(intent);
    }

    static SpannableString createIndentedText(String text, int marginFirstLine, int marginNextLines) {
        SpannableString result=new SpannableString(text);
        result.setSpan(new LeadingMarginSpan.Standard(marginFirstLine, marginNextLines),0,text.length(),0);
        return result;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_detail);
        String companyName = getIntent().getStringExtra("company_name");
        String companyIntro = getIntent().getStringExtra("company_intro");
        int companyImage = getIntent().getIntExtra("company_image", 1);
        content = (TextView) findViewById(R.id.company_intro);
        imageView = (ImageView) findViewById(R.id.company_image);
        content.setText(createIndentedText(companyIntro, 10, 10));
        imageView.setImageResource(companyImage);
    }
}
