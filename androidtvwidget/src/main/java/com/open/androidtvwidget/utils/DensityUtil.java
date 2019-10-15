package com.open.androidtvwidget.utils;

import android.content.Context;

/**
 * Created by wh on 2018/1/11.
 */

public class DensityUtil {

    /**
     * 6.     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     * 7.
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 14.     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     * 15.
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


}
