package com.chunleikeji.obj;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WanNengPlayerObj {


     WebView webView;
    boolean over;
    public void init(final WebView webView, final Activity activity, String tag) {
        //初始化
        this.webView = webView;

        //设置

        webView.getSettings().setJavaScriptEnabled(true);
        //解析核心
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if ((url.indexOf(".mp4") != -1) || (url.indexOf(".m3u8") != -1) && !over) {

                    //去掉前缀
                    String playr = url;
                    android.util.Log.e("TAA", "去前缀:" + playr);
                    while (playr.indexOf("?url=") != -1) {
                        playr = url.substring(url.indexOf("=") + 1);
                        android.util.Log.e("TAA", "去前缀:" + playr + "____之前:" + url);

                    }
//                    final String  playr  =   url.substring(url.indexOf("=")+1);

                    final String playrFinal = playr;

                    //是要跳回的
//                    if("1".equals(activity.getIntent().getStringExtra("tag"))){
//
//                        //错误的加载 跳出
//                        if(playrFinal.equals(activity.getIntent().getStringExtra("errorurl"))){
//                            return super.shouldInterceptRequest(view, request);
//
//                        }
//
//                    }

                    android.util.Log.e("TAA", "播放地址:" + playrFinal);

                    ((Activity) webView.getContext()).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //启动播放器 已经解析出地址

                            if (onOverJiexi != null) {
                                onOverJiexi.onOverPlayer(playrFinal);
                            }
                        }
                    });

                    over = true;


                }
                return super.shouldOverrideUrlLoading(view, url);
            }
            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {


                 final String url = request.getUrl() + "";

                if ((url.indexOf(".mp4") != -1) || (url.indexOf(".m3u8") != -1)&&!over) {

                    //去掉前缀
                    String  playr  = url;
                    while (playr.indexOf("?url=")!=-1){
                        playr =   url.substring(url.indexOf("=")+1);
                        android.util.Log.e("TAA", "去前缀:" + playr+"____之前:"+url);

                    }
//                    final String  playr  =   url.substring(url.indexOf("=")+1);

                    final String playrFinal =  playr;

                    //是要跳回的
                    if("1".equals(activity.getIntent().getStringExtra("tag"))){

                        //错误的加载 跳出
                        if(playrFinal.equals(activity.getIntent().getStringExtra("errorurl"))){
                            return super.shouldInterceptRequest(view, request);

                        }

                    }

                    android.util.Log.e("TAA", "播放地址:" + playrFinal);

                    ((Activity) webView.getContext()).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //启动播放器 已经解析出地址

                            if(onOverJiexi!=null){
                                onOverJiexi.onOverPlayer(playrFinal);
                            }
                        }
                    });

                    over = true;

                    return null;
                }


                return super.shouldInterceptRequest(view, request);
            }
        });


    }

    public OnOverJiexi getOnOverJiexi() {
        return onOverJiexi;
    }

    public void setOnOverJiexi(OnOverJiexi onOverJiexi) {
        this.onOverJiexi = onOverJiexi;
    }

    public OnOverJiexi onOverJiexi;

    public interface OnOverJiexi {

        public abstract void onOverPlayer(String url);

    }


    //用于加载新接口
    public void loadWebViewUrl(String url) {

        webView.loadUrl(url);


    }


}
