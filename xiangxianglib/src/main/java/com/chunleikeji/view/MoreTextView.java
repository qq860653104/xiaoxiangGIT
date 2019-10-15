package com.chunleikeji.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by wh on 2018/2/28.
 */

public class MoreTextView extends android.support.v7.widget.AppCompatTextView {
    public MoreTextView(Context context) {
        super(context);
    }

    public MoreTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MoreTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        init();
    }

    public void moreTextView(){
//        animate().sety.setDuration(100).start();
//        setY(1.3f);
        scrollTo(0,-30);
    }

    public void startMoreText(){
        Log.e("TAA","显示标题");

        setVisibility(VISIBLE);
//        setMovementMethod(ScrollingMovementMethod.getInstance());
//        setText("adsadadasda啊实打实大苏打倒萨");
//        TranslateAnimation translateAnimation = new TranslateAnimation(400, 0,0,0);
//        translateAnimation.setRepeatCount(Animation.INFINITE);
//        translateAnimation.setRepeatMode(Animation.REVERSE);
//        translateAnimation.setDuration(300);
//        startAnimation(translateAnimation);
        setSingleLine(true);

        setEllipsize(TextUtils.TruncateAt.MARQUEE);

        setHorizontallyScrolling(true);
    }



    public void hintMoreText(){
//        setVisibility(GONE);

    }
    private void init() {
        setClickable(true);
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }
    @Override
    public boolean isFocused() {
        return true;
    }
}
