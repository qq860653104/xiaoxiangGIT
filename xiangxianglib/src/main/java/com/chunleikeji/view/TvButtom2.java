package com.chunleikeji.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.chunleikeji.xiangxianglib.R;


/**
 * Created by wh on 2018/1/3.
 */

public class TvButtom2 extends TextView {
    public TvButtom2(Context context) {
        super(context);
    }

    public TvButtom2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TvButtom2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
//        setTranslationZ(3f);

        setBackgroundResource(R.drawable.tv_btn);
    }
    Drawable drawable;
    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if(focused){
            post(new Runnable() {
                @Override
                public void run() {
                    setBackgroundResource(R.drawable.tv_button_select2);
                }
            });
            setTextColor(getResources().getColor(R.color.black));
            animate().scaleX(1.1f).scaleX(1.1f).setDuration(300).start();

            if(focr!=0){
                drawable = getResources().getDrawable(
                        focr);
            }

            Log.e("TvButton2","获取了焦点："+focused);
        }else{
            setBackgroundResource(R.drawable.tv_btn);
            setTextColor(getResources().getColor(R.color.black));
            animate().scaleY(1.0f).scaleX(1.0f).setDuration(300).start();

            if(defult!=0) {
                drawable = getResources().getDrawable(
                        defult);
            }
        }
        if(drawable!=null) {
            drawable.setBounds(0, 0, 30,
                    30);
            setCompoundDrawables(drawable, null, null, null);
        }
    }


    int defult ;
    int focr;

    public void setDrawable(int defult , int focr){
            this.defult  = defult;
            this.focr = focr;
        setBackgroundResource(R.drawable.tv_btn);
        setTextColor(getResources().getColor(R.color.black));
        animate().scaleY(1.0f).scaleX(1.0f).setDuration(300).start();

        drawable = getResources().getDrawable(
                defult);
        drawable.setBounds(0, 0, 30,
                30);
        setCompoundDrawables(drawable, null, null, null);
    }


}
