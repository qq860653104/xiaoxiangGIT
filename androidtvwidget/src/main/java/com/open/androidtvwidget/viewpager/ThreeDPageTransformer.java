package com.open.androidtvwidget.viewpager;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.open.androidtvwidget.R;
import com.open.androidtvwidget.utils.DensityUtil;

public class ThreeDPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.5f;
    private static final float MIN_angle = 1f;

    private float excursion = 0;

    public ThreeDPageTransformer(){
    }

    public ThreeDPageTransformer(float excursion){
        this.excursion = excursion;
    }

    @SuppressLint("NewApi")
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();  

        position = position + excursion;

//
//        if (position < -1) { // [-Infinity,-1)
//            view.setScaleX(MIN_SCALE);
//            view.setTranslationX(pageWidth/4);
//
//            view.setTranslationY(0);
//            view.animate().scaleY(1.0f).setDuration(100).start();
//            view.setTag(R.id.position,"no");
//        } else if (position <= 0) { // [-1,0]
//        	float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
//        	view.setScaleX(scaleFactor);
//
//            view.setTranslationX(pageWidth/4*Math.abs(position));
//
//
//            view.animate().scaleY(1.1f).setDuration(100).start();
//
//            view.setTag(R.id.position,"yes");
//
//
//        } else if (position <= 1) { // (0,1]
//        	float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
//            view.setScaleX(scaleFactor);
//            view.setTranslationX(-pageWidth/4*Math.abs(position));
//
//            view.setTranslationY(0);
//            view.animate().scaleY(1.0f).setDuration(100).start();
//
//            view.setTag(R.id.position,"no");
//
//        } else { // (1,+Infinity]
//        	view.setScaleX(MIN_SCALE);
//            view.setTranslationX(-pageWidth/4);
//            view.setTranslationY(0);
//            view.animate().scaleY(1.0f).setDuration(100).start();
//            view.setTag(R.id.position,"no");
//
//
//        }



    }  
}  