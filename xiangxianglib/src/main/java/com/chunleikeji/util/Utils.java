package com.chunleikeji.util;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

public class Utils {

    //视频seek的同步进程
    public static int SEEK_CURRENT;
    public static int is_pause;

    public static View.OnFocusChangeListener getFocus() {
        return focus;
    }

    public void setFocus(View.OnFocusChangeListener focus) {
        this.focus = focus;
    }

    private static  View.OnFocusChangeListener focus = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(final View v, boolean hasFocus) {
//            ((TextView)findViewById(R.id.aiqiyi)).setTextColor(0xFF0000FF);

            if (hasFocus) {


                ObjectAnimator anim = ObjectAnimator//
                        .ofFloat(v, "zhy", 1.0F, 1.2F)//
                        .setDuration(500);//
                anim.start();
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float cVal = (Float) animation.getAnimatedValue();
                        v.setAlpha(cVal);
                        v.setScaleX(cVal);
                        v.setScaleY(cVal);
                    }
                });

                if(v instanceof TextView) {
                    ((TextView) v).setTextColor(Color.WHITE);
                }
//                animation.startNow();

            } else {
//                v.setBackgroundColor(Color.TRANSPARENT);
                ObjectAnimator anim = ObjectAnimator//
                        .ofFloat(v, "zhy", 1.2F, 1.0F)//
                        .setDuration(500);//
                anim.start();
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float cVal = (Float) animation.getAnimatedValue();
                        v.setAlpha(cVal);
                        v.setScaleX(cVal);
                        v.setScaleY(cVal);
                    }
                });


                if(v instanceof  TextView) {
                    ((TextView) v).setTextColor(Color.parseColor("#eeeeee"));
                }
//                animation.cancel();  dark_blue

            }

//            ((TextView)v).setTextColor(this.getResources().getColor(R.color.blue));
        }
    };

}
