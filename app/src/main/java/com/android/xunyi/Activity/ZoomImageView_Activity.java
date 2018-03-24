package com.android.xunyi.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.android.xunyi.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

import static android.view.View.Z;

public class ZoomImageView_Activity extends Activity {
    @BindView(R.id.iv_photo)
    PhotoView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.photoview_layout);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent != null) {
            String ImageIdString = getIntent().getStringExtra("ImageId");
            int ImageId = Integer.parseInt(ImageIdString);
            Glide.with(this).load(ImageId).diskCacheStrategy(DiskCacheStrategy.ALL).into(ivPhoto);
        }

        ivPhoto.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                finish();
            }
        });


    }
}
