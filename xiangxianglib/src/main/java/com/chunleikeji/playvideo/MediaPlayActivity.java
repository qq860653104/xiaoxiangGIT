package com.chunleikeji.playvideo;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.WindowManager;
import android.widget.SeekBar;

import com.chunleikeji.bean.VideoPlayBean;
import com.chunleikeji.util.OkHttpUtils;
import com.chunleikeji.util.SPUtils;
import com.chunleikeji.xiangxianglib.R;
import com.google.gson.Gson;

import java.io.IOException;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MediaPlayActivity extends Activity implements TextureView.SurfaceTextureListener {


    private static final String TAG = "MediaPlayerDemo";
    private int mVideoWidth;
    private int mVideoHeight;
    public static MediaPlayer mMediaPlayer;
    private TextureView mTextureView;
    private String path;
    private Surface surf;

    private SeekBar sb;
    private boolean mIsVideoSizeKnown = false;
    private boolean mIsVideoReadyToBePlayed = false;
    private DefindeMideaController defindeMideaController;

    public String tag;

    private String playurl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this))
            return;

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_media_play);


        String saveTag = SPUtils.getSharedStringData(MediaPlayActivity.this, "tag");
//        if (saveTag.equals("1")) {
//            Toast.makeText(this, , Toast.LENGTH_SHORT).show();
            tag = "1";
//        } else {
//
//            tag = "0";
//            Toast.makeText(this, "您还不是VIP，视频只能试看6分钟", Toast.LENGTH_LONG).show();
//
//        }

        try {
            playurl = getIntent().getStringExtra("playurl");



            init();



        } catch (Exception e) {
            init();
        }

    }


    private void init() {

        Log.e("TAA", "进入init");
//        hold_progress = findViewById(R.id.hold_progress);
        mTextureView = (TextureView) findViewById(R.id.surface);
        mTextureView.setSurfaceTextureListener(this);
        // sb = (SeekBar) findViewById(R.id.sb);
        if (mMediaPlayer == null) {
            mMediaPlayer = new MediaPlayer(this, true);
        }
        defindeMideaController = (DefindeMideaController) findViewById(R.id.mymedia);
        defindeMideaController.init(mMediaPlayer, mTextureView);
        defindeMideaController.setTag(tag);


//        if (playurl == null) {
//            playurl = getIntent().getStringExtra("playurl");
//        }
        final String title = getIntent().getStringExtra("title");
        defindeMideaController.setTitle(title);
        defindeMideaController.setOnVideoOverLinstener(new DefindeMideaController.onVideoOverLinstener() {
            @Override
            public void onVideoOver(String playUrl) {
//                mediaVideoOver(playUrl);
//                defindeMideaController.center_layout.setVisibility(View.GONE);
//                defindeMideaController.startVideo(playurl);
            }
        });


//        Log.e("TAA", "播放的地址：:" + playurl);

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAA", "经历了！！！！！：");
//        releaseMediaPlayer();
//        doCleanUp();

    }

    @Override
    protected void onDestroy() {


        releaseMediaPlayer();
        doCleanUp();

        super.onDestroy();
    }


    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            //   Toast.makeText(this, "存储了！"+ mMediaPlayer.getCurrentPosition(), Toast.LENGTH_SHORT).show();
            SPUtils.setSharedlongData(this, playurl, mMediaPlayer.getCurrentPosition());

            mMediaPlayer.release();
            mMediaPlayer = null;

        }
    }

    private void doCleanUp() {
        mVideoWidth = 0;
        mVideoHeight = 0;
        mIsVideoReadyToBePlayed = false;
        mIsVideoSizeKnown = false;
    }


    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
//        playVideo(surface);

        //准备好了以后去开始加载数据
//        adjustAspectRatio(mMediaPlayer.getVideoWidth(), mMediaPlayer.getVideoHeight());
        Vitamio.isInitialized(MediaPlayActivity.this);

        defindeMideaController.initVideo(surface);
        String url = "http://api.dobanke.top:2020/api/video/playurl/ebo/" + playurl;

        Log.e("TAA", "云值URL" + url);

        OkHttpUtils.getOkHttp(this, url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();

                Log.e("TAA", "云值URL_body" + body);


                VideoPlayBean bean = new Gson().fromJson(body, VideoPlayBean.class);

//                    if() {
                playurl = bean.getUrl();

                Log.e("TAA","云值URL_URL:"+playurl);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if(playurl!=null) {
                            defindeMideaController.startVideo(playurl.trim());
                        }else{
//                            Toast.makeText(MediaPlayActivity.this, "资源已被删除", Toast.LENGTH_SHORT).show();
//                            finish();
                            defindeMideaController.startVideo("http://www.jiayinkeji.xin/404.mp4");

                        }

                    }
                });
            }
        });


//        play(surface);

    }

    //    private String getVideoUrl = "http://39.106.60.208/test/test4.php?url=";
    private String getVideoUrl = "http://39.106.60.208/waibao/tvmodule/yun/yunparse/app.php?url=";



    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
//        play( surface);
    }




    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    private int surfaceWidth;
    private int surfaceHeight;


//    @Override
//    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
//        changeVideoSize();
//    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        changeVideoSize();
    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();


//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    finish();
//                    overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
//                }
//            }, 500);
//
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//    Toast.makeText(this, "时间："+timeParse(mMediaPlayer.getDuration()), Toast.LENGTH_SHORT).show();
//    mMediaPlayer.seekTo();
//    defindeMideaController.hint();


        if ((keyCode == KeyEvent.KEYCODE_BACK) || (keyCode == KeyEvent.KEYCODE_BACKSLASH)) {
            return super.onKeyDown(keyCode, event);
        } else {
            return defindeMideaController.onMediaKeyDwon(keyCode, event);

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}
