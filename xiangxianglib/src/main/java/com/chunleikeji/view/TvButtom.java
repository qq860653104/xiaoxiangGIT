package com.chunleikeji.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.chunleikeji.xiangxianglib.R;


/**
 * Created by wh on 2018/1/3.
 */

public class TvButtom extends TextView {
    public TvButtom(Context context) {
        super(context);
    }

    public TvButtom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TvButtom(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

        setBackgroundResource(R.drawable.tv_button_select);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if(focused){
            setBackgroundResource(R.drawable.tv_button_select2);
            animate().scaleX(1.1f).scaleX(1.1f).setDuration(300).start();

        }else{
            setBackgroundResource(R.drawable.tv_button_select);
            animate().scaleY(1.0f).scaleX(1.0f).setDuration(300).start();
        }
    }
}
