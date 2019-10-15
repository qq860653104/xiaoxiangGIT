package com.chunleikeji.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.io.Serializable;


public class MyContentLayout extends LinearLayout {

    public MyContentLayout(Context context) {
        super(context);
    }

    public MyContentLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyContentLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static class SendItemDetail implements Serializable {
        public static String KEY=SendItemDetail.class.getName();

        public String id;//必填  根据id获取每个条目的详细数据
        public String uid;//非必填 用户id
        public int type;//必填 1电影 2 听戏音频 3听戏视频
        public int style;// 非必填 1单集 全剧 专辑
    }
}
