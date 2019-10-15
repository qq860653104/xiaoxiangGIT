package com.chunleikeji.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by wh on 2018/4/3.
 */

public class ToastUtils {

    private static Context context  ;
    private static Toast toast ;

    public static void showToast(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
