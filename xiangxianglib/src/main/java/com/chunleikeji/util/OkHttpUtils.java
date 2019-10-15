package com.chunleikeji.util;

import android.app.Activity;
import android.content.Context;

import com.chunleikeji.ZhiHuApp;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by wh on 2018/2/28.
 */

public class OkHttpUtils {


    public static void  getOkHttp(Context context, String url, Callback callback){
        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient okHttpClient = null ;
        if(context instanceof ZhiHuApp){
            okHttpClient  = ((ZhiHuApp) context).getmHttpClient();
        }else{
            okHttpClient  = ((ZhiHuApp) ((Activity) context).getApplication()).getmHttpClient();

        }


            okHttpClient.newCall(request).enqueue(callback);

    }
}
