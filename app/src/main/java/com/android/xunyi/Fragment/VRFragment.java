package com.android.xunyi.Fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.xunyi.R;
import com.android.xunyi.Utils.MyApplication;
import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;

import static com.google.vr.cardboard.ThreadUtils.runOnUiThread;

/**
 * Created by Administrator on 2017/3/18.
 */

public class VRFragment extends Fragment {
    private static final String TAG = "MainActivity";
    private VrPanoramaView panoWidgetView;
    private String fileUri = "test2.png";

    private VrPanoramaView.Options panoOptions = new VrPanoramaView.Options();
    private ImageLoaderTask backgroundImageLoaderTask;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.vr_fragment,container,false);
        panoWidgetView = (VrPanoramaView) view.findViewById(R.id.pano_view);
        panoWidgetView.setEventListener(new ActivityEventListener());


        if (backgroundImageLoaderTask != null) {
            backgroundImageLoaderTask.cancel(true);
        }

        panoOptions.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
        backgroundImageLoaderTask = new ImageLoaderTask();
        backgroundImageLoaderTask.execute(Pair.create(fileUri, panoOptions));
        return  view;
    }

    class ImageLoaderTask extends AsyncTask<Pair<String, VrPanoramaView.Options>, Void, Boolean> {
        @Override
        protected Boolean doInBackground(final Pair<String, VrPanoramaView.Options>... fileInformation) {

            InputStream istr = null;
            try {
                istr = MyApplication.getContext().getAssets().open(fileInformation[0].first);
            } catch (IOException e) {
                Log.e(TAG, "Could not decode default bitmap: " + e);
                return false;
            }

            final Bitmap bitmap = BitmapFactory.decodeStream(istr);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    panoWidgetView.loadImageFromBitmap(bitmap, fileInformation[0].second);
                }
            });


            try {
                istr.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close input stream: " + e);
            }

            return true;
        }
    }

    private class ActivityEventListener extends VrPanoramaEventListener {

        @Override
        public void onLoadSuccess() {
            Log.e(TAG, "onLoadSuccess");
        }


        @Override
        public void onLoadError(String errorMessage) {
            Log.e(TAG, "Error loading pano: " + errorMessage);
        }

        @Override
        public void onClick() {
            super.onClick();
            Log.e(TAG, "onClick");
        }

        @Override
        public void onDisplayModeChanged(int newDisplayMode) {
            super.onDisplayModeChanged(newDisplayMode);
            Log.e(TAG, "onDisplayModeChanged");
        }
    }




    @Override
    public void onPause() {
        panoWidgetView.pauseRendering();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        panoWidgetView.resumeRendering();
    }

    @Override
    public void onDestroy() {
        panoWidgetView.shutdown();

        if (backgroundImageLoaderTask != null) {
            backgroundImageLoaderTask.cancel(true);
        }
        super.onDestroy();
    }


}
