package com.chunleikeji.view;

import android.content.Context;
import android.util.AttributeSet;

import io.vov.vitamio.widget.VideoView;

/**
 * Created by wh on 2018/3/15.
 */

public class MyVideoView extends VideoView {
    public MyVideoView(Context context) {
        super(context);
    }

    public MyVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }



//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
//        int width = wm.getDefaultDisplay().getWidth();
//        int height = wm.getDefaultDisplay().getHeight();
//        setMeasuredDimension(width, height);
//    }
//    @Override
//    public void setVideoLayout(int layout, float aspectRatio) {
//                WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
//        int width = wm.getDefaultDisplay().getWidth();
//        int height = wm.getDefaultDisplay().getHeight();
//        getHolder().setFixedSize(width, height);
//    }
}
