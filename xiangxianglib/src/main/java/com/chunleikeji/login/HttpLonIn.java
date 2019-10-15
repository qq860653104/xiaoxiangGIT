package com.chunleikeji.login;

import android.content.Context;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpLonIn {
    public static void GetOkGttp(Context context , String url , Callback callback){
        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(callback);
    }

}
