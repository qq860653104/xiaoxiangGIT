package com.chunleikeji.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by wh on 2018-08-15.
 */

public class HomeForceFrameLayout extends FrameLayout {
    public HomeForceFrameLayout( Context context) {
        super(context);
    }

    public HomeForceFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeForceFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public View focusSearch(int direction) {

//        Log.e("TAA","当前的："+direction+"________"+getFocusedChild());

        return super.focusSearch(direction);
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {


//        Log.e("TAA", "当前的 dis：" + event.getKeyCode() + "________" + getFocusedChild());
//
//        SmoothHorizontalScrollView smoothHorizontalScrollView  =  findViewById(R.id.list);
//
//        if (getFocusedChild() instanceof SmoothHorizontalScrollView) {
//            if(smoothHorizontalScrollView.getFocusedChild().getId()==R.id.view4) {
//                findViewById(R.id.topsousuo).setFocusable(true);
//                findViewById(R.id.topsousuo).setFocusableInTouchMode(true);
//                findViewById(R.id.topsousuo).requestFocus();
//                findViewById(R.id.topsousuo).requestFocusFromTouch();
//                return true;
//            }
//        }

        return super.dispatchKeyEvent(event);
    }
}
