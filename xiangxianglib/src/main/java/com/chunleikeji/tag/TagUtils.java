package com.chunleikeji.tag;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;

import com.chunleikeji.bean.JujiBean;

import java.util.ArrayList;


/**
 * Created by wh on 2018/1/8.
 */

public class TagUtils {

    //头布局
    public static final int HEAD_STYLE = 1;
    //电影布局
    public static final int MOVIE_STYLE = 2;
    //系列布局
    public static final int ZT_STYLE = 3;
    //详情页布局
    public static final int DETAIL_STYLE = 4;

    public static Bitmap getCacheBitmap() {
        return cacheBitmap;
    }

    public static void setCacheBitmap(Bitmap cacheBitmap) {
        TagUtils.cacheBitmap = cacheBitmap;
    }

    public static   Bitmap cacheBitmap;

    public static ArrayList<JujiBean> getList() {
        return list;
    }

    public static void setList(ArrayList<JujiBean> list) {
        TagUtils.list = list;
    }

    public static ArrayList<JujiBean> list;
    private static Toast toast;

    public static void showToast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context,
                    content,
                    Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();

    }


}
