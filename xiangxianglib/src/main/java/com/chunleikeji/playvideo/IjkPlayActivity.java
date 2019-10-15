package com.chunleikeji.playvideo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.chunleikeji.bean.JujiBean;
import com.chunleikeji.bean.VideoPlayBean;
import com.chunleikeji.tag.TagUtils;
import com.chunleikeji.util.OkHttpUtils;
import com.chunleikeji.xiangxianglib.R;
import com.dl7.player.media.IjkPlayerView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class IjkPlayActivity extends AppCompatActivity {

    private static final String VIDEO_URL = "http://1255681533.vod2.myqcloud.com/ccebe2e6vodgzp1255681533/894e6d277447398155240047705/WYzNAa8Q5DAA.mp4";
    //    private static final String IMAGE_URL = "http://vimg3.ws.126.net/image/snapshot/2016/11/C/T/VC628QHCT.jpg";
    IjkPlayerView mPlayerView;

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_down_load);
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this,MobclickAgent.EScenarioType.E_UM_NORMAL);
        String ABC = "http://baidu.com,http://tengxun.com,http://haozi.com,http://aliu.com";
        CollectionPlayUrl.platUrl(IjkPlayActivity.this,ABC);
//          mPlayerView = findViewById(R.id.ijk_id);

//        Glide.with(this).load(IMAGE_URL).fitCenter().into(mPlayerView.mPlayerThumb);
        final String playurl = getIntent().getStringExtra("playurl");


        if (TextUtils.isEmpty(playurl)) {


            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Toast.makeText(IjkPlayActivity.this, "暂无片源", Toast.LENGTH_LONG).show();

                    finish();
                }
            });
        }else {

          final String title = getIntent().getStringExtra("title");
            String url = "http://v3tv.sieget.com/v3final/chuanbojiekou/think_test/public/index.php/index/index/playerJiekou?url=" + playurl;

            Log.e("TAA", "云值URL_____:" + url + "，看看啥：" + playurl + " 剧集：" + title);

            OkHttpUtils.getOkHttp(this, url, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                            Toast.makeText(IjkPlayActivity.this, "暂无片源", Toast.LENGTH_LONG).show();

                            finish();
                        }
                    });
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    String body = null;
                    try {
                        body = response.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (TextUtils.isEmpty(body)){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast.makeText(IjkPlayActivity.this, "暂无片源", Toast.LENGTH_LONG).show();

                                finish();
                            }
                        });

                    }else {

                        Log.e("TAA", "云值URL_body____：" + body +"---");

                      VideoPlayBean bean = null;
                        try {
                            bean = new Gson().fromJson(body, VideoPlayBean.class);
                        } catch (JsonSyntaxException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    Toast.makeText(IjkPlayActivity.this, "片源出现未知错误，请重新尝试", Toast.LENGTH_LONG).show();

                                    finish();
                                }
                            });
                            e.printStackTrace();
                        }
//                        try {
//                            bean =
//                        } catch (JsonSyntaxException e) {
//                            runOnUiThread(new Runnable() {
//                                              @Override
//                                              public void run() {
//
//
//                                                  Toast.makeText(IjkPlayActivity.this, "片源错误", Toast.LENGTH_LONG).show();
//
//                                                  finish();
//                                              }
//                            });
//                            e.printStackTrace();
//                        }

//                        int result2 = bean.getMsg().indexOf("服务器");
//                        Log.e("TAA", "含有服务器:" + bean.getMsg());
//                        if (result2 != -1) {
//                            Log.e("TAA", "含有服务器 漂亮");
//                        }


//                    if() {
                        String beanUrl = null;
                        if (bean != null) {
                            try {
                                beanUrl = bean.getUrl().trim();
                                name = bean.getMsg();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            Log.e("TAA", "我擦播放地址详情页：" + beanUrl + "，播放名字：" + name);


                            final String finalBeanUrl = beanUrl;
                            final VideoPlayBean finalBean = bean;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    if (finalBeanUrl == null) {


                                    }

                                    int result1 = 0;
                                    int result3 = 0;
                                    try {
                                        result1 = finalBeanUrl.indexOf("https");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    if (result1 != -1) {
                                        Log.e("TAA", "我擦是https：");
//                                        JCFullScreenActivity.startActivity(IjkPlayActivity.this, finalBean.getUrl().trim(), JCVideoPlayerStandard.class, "");
//                                        overridePendingTransition(0, 0);
//                                        finish();
                                    } else {
                                        result3 = finalBeanUrl.indexOf("http");
                                        Log.e("TAA", "我擦是http：");
                                        if(result3 != -1){
                                            Log.e("TAA", "我擦嘞本来头HTTP了：" + finalBeanUrl);

                                            mPlayerView = new IjkPlayerView(IjkPlayActivity.this);
                                            setContentView(mPlayerView);
                                            mPlayerView.init()
                                                    .alwaysFullScreen()
                                                    .setVideoPath(finalBeanUrl)
                                                    .enableDanmaku()
                                                    .setTitle(title)
                                                    .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
                                                    .start();
                                        }else {
                                            Log.e("TAA", "我擦嘞加上HTTP了：" + "http:"+finalBeanUrl);
                                            mPlayerView = new IjkPlayerView(IjkPlayActivity.this);
                                            setContentView(mPlayerView);
                                            mPlayerView.init()
                                                    .alwaysFullScreen()
                                                    .setVideoPath("http:"+finalBeanUrl)
                                                    .enableDanmaku()
                                                    .setTitle(title)
                                                    .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
                                                    .start();
                                        }






                                        mPlayerView.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
                                            @Override
                                            public void onCompletion(IMediaPlayer iMediaPlayer) {

                                                //播放结束的监听
                                                if (TagUtils.list != null) {
                                                    //那么就自动下一集

                                                    if (postion == 0) {
                                                        postion = getIntent().getIntExtra("postion", 0);
                                                        postion += 1;
                                                    } else {
                                                        postion = postion + 1;
                                                    }

                                                    JujiBean jujiBean = TagUtils.list.get(postion);
                                                    if (jujiBean != null) {
                                                        Log.e("TAA", "剧集啊啊啊：" + jujiBean.getUrl() + "___________" + postion);
//
                                                        String httpJson = "http://v3tv.sieget.com/v3final/chuanbojiekou/think_test/public/index.php/index/index/playerJiekou?url=" + jujiBean.getUrl().trim();
                                                        OkHttpUtils.getOkHttp(IjkPlayActivity.this, httpJson, new Callback() {
                                                            @Override
                                                            public void onFailure(Call call, IOException e) {

                                                            }

                                                            @Override
                                                            public void onResponse(Call call, Response response) throws IOException {
                                                                String body = response.body().string();
                                                                if (body != null) {
                                                                    Log.e("TAA", "云值URL_body：" + body);

                                                                    VideoPlayBean bean = null;
                                                                    try {
                                                                        bean = new Gson().fromJson(body, VideoPlayBean.class);
                                                                    } catch (JsonSyntaxException e) {
                                                                        bean = new Gson().fromJson(body, VideoPlayBean.class);
                                                                        e.printStackTrace();
                                                                    }

                                                                    final String beanurl = bean.getUrl().trim();
                                                                    int result2 = beanurl.indexOf("http:");

                                                                    if (result2 != -1) {
                                                                        postion += 1;
                                                                        final String juji = "第" + postion + "集";
                                                                        Log.e("TAA", "是啥捏云值URL_body——————:" + bean.getUrl() + "，多少：" + juji  + ",这个是啥：" + result2);
                                                                        runOnUiThread(new Runnable() {
                                                                            @Override
                                                                            public void run() {
                                                                                mPlayerView.setScreen();
                                                                                mPlayerView.setVideoPath(beanurl);
                                                                                mPlayerView.setTitle(juji);
                                                                                mPlayerView.start();
//
                                                                            }
                                                                        });
                                                                    }else {
                                                                        postion += 1;
                                                                        final String juji = "第" + postion + "集";
                                                                        Log.e("TAA", "是啥捏云值URL_body——————:" + bean.getUrl() + "，多少：" + juji);
                                                                        runOnUiThread(new Runnable() {
                                                                            @Override
                                                                            public void run() {
                                                                                mPlayerView.setScreen();
                                                                                mPlayerView.setVideoPath("http:"+beanurl);
                                                                                mPlayerView.setTitle(juji);
                                                                                mPlayerView.start();

                                                                            }
                                                                        });
                                                                    }

                                                                }
                                                            }
                                                        });

                                                        Toast.makeText(IjkPlayActivity.this, "正在加载第" + (postion + 1) + "集", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Toast.makeText(IjkPlayActivity.this, "已播放完", Toast.LENGTH_SHORT).show();
                                                        finish();
                                                    }
//                                    videoPlayer.setVideoPath(jujiBean.getUrl());
//                                    videoPlayer.start();

                                                } else {
                                                    //退出
                                                    Toast.makeText(IjkPlayActivity.this, "已播放完", Toast.LENGTH_SHORT).show();
                                                    finish();
                                                }
                                            }
                                        });
                                    }
                                }
                            });

                        }else {
                            Log.e("TAA", "来过——————:" );

                        }


                    }
                }
            });
        }
    }

    int postion = 0;

    @Override
    protected void onPause() {
        try {
            super.onPause();
            mPlayerView.onPause();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onResume() {
        try {
            super.onResume();
            mPlayerView.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void onDestroy() {

        try {
            super.onDestroy();
            mPlayerView.onDestroy();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {



        if ((keyCode == KeyEvent.KEYCODE_BACK) || (keyCode == KeyEvent.KEYCODE_BACKSLASH)) {

            if (mPlayerView.jindu.getVisibility() == View.VISIBLE){
                mPlayerView.jindu.setVisibility(View.GONE);
                mPlayerView.currentBack = 0;
                mPlayerView.currentNext = 0;
            }
            return super.onKeyDown(keyCode, event);
        } else {
            return mPlayerView.onMediaKeyDwon(keyCode, event);
        }
    }

    @Override
    public void onBackPressed() {
        if (mPlayerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }




}