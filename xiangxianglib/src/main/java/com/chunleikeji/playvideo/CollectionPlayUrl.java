package com.chunleikeji.playvideo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.WebView;

import com.chunleikeji.xiangxianglib.R;


public class CollectionPlayUrl extends  Activity {
private WebView collectionWeb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lishi_ji_lu);
        collectionWeb = findViewById(R.id.collectionWeb);
    }

    public static void platUrl(Activity context , String url){


        String[] playUrlArry = url.split(",");
        for (int i = 0; i < playUrlArry.length ; i++) {
            Log.e("TAG", "看一看拆分的对不对: "+ playUrlArry[i] );



        }


    }

}
