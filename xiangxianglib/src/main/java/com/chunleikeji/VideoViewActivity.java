package com.chunleikeji;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.chunleikeji.ActivityClass.ActivityCollector;
import com.chunleikeji.bean.QuanBuBean;
import com.chunleikeji.util.ClassSaveUtils;
import com.chunleikeji.util.StaticUtils;
import com.chunleikeji.util.TimelyBean;
import com.chunleikeji.util.Utils;
import com.chunleikeji.util.VideoViewObj;
import com.chunleikeji.xiangxianglib.R;
import com.pili.pldroid.player.AVOptions;
import com.pili.pldroid.player.PLOnCompletionListener;
import com.pili.pldroid.player.widget.PLVideoView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.vov.vitamio.Vitamio;


public class VideoViewActivity extends Activity {

    public PLVideoView mVideoPlay;
    /**
     * 我不是药神
     */
    public TextView mTitle;
    public ImageView mIvVip;
    /**
     * 12：00
     */
    public TextView mCurrentTime;
    public ImageView mIvPlay;
    public SeekBar mSeekbar;
    /**
     * 45:10
     */
    public TextView mEndTime;

    VideoViewObj videoViewObj;
    public LinearLayout mLeftMenu;
    public LinearLayout mBtnMenu;
    /**  */
    public TextView mJindu;
    public ImageView mCenterBtn;
    public ProgressBar progressBar2;
    public ImageView mGgImg;
//  public FrameLayout mGg;
    /**
     * 5秒后结束
     */
    public TextView mGgText;
//  public DianboBean.DataBean.ListBean listBean;

    public int isPause;
    int index = StaticUtils.nextIndex;
    TimelyBean tongzhiBean = StaticUtils.jishiBean;
    int oneTag;
    int twoTag;
    int threeTag;
    String url;

    AVOptions options = new AVOptions();
    String dir = Environment.getExternalStorageDirectory() + "/xiaoxiangketnag";
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    private PowerManager.WakeLock mWakeLock = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE, VideoViewActivity.class.getName());
        mWakeLock.acquire();


        setContentView(R.layout.activity_video_view);
        ActivityCollector.addActivity(this);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
        StaticUtils.setActivity(this);
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        initView();
        videoViewObj = new VideoViewObj();
        videoViewObj.init(this);


        // 解码方式:
        // AVOptions.MEDIA_CODEC_HW_DECODE，硬解
        // AVOptions.MEDIA_CODEC_SW_DECODE, 软解
        // AVOptions.MEDIA_CODEC_AUTO, 硬解优先，失败后自动切换到软解
        // 默认值是：MEDIA_CODEC_SW_DECODE
//        options.setInteger(AVOptions.KEY_MEDIACODEC, AVOptions.MEDIA_CODEC_AUTO);
        // 默认的缓存大小，单位是 ms
        // 默认值是：500
        options.setInteger(AVOptions.KEY_CACHE_BUFFER_DURATION, 1500);
        // 最大的缓存大小，单位是 ms
        // 默认值是：2000，若设置值小于 KEY_CACHE_BUFFER_DURATION 则不会生效
        options.setInteger(AVOptions.KEY_MAX_CACHE_BUFFER_DURATION, 20000);
//        options.setString(AVOptions.KEY_CACHE_DIR, dir);
//        listBean = StaticUtils.getInfobean();
        // 设置偏好的视频格式，设置后会加快对应格式视频流的打开速度，但播放其他格式会出错
        // m3u8 = 1, mp4 = 2, flv = 3
        options.setInteger(AVOptions.KEY_PREFER_FORMAT, 2);
        // 快开模式，启用后会加快该播放器实例再次打开相同协议的视频流的速度
//        options.setInteger(AVOptions.KEY_FAST_OPEN, 1);
        Log.e("TAG", "onCreate: " + dir);
        mVideoPlay.setAVOptions(options);


        url = getIntent().getStringExtra("url");
        mVideoPlay.addCache(url);

        if (url == null) {
            url = StaticUtils.Timelyurl;
        }

        Log.e("TAA", "播放url____：" + StaticUtils.isStartVideoAd);

        if (url != null) {

            progressBar2.setVisibility(View.VISIBLE);

            if (StaticUtils.isStartVideoAd == 1) {

                videoViewObj.startAd(   this);

            } else {
                Log.e("TAG", "onCompletion: 播放执行了" + url);

                mVideoPlay.setVideoPath(url);

            }
            mVideoPlay.setOnCompletionListener(new PLOnCompletionListener() {
                @Override
                public void onCompletion() {
                    Log.e("TAG", "onCompletion: 播放完毕执行了");

                    if (StaticUtils.isSear) {
                        mVideoPlay.setVideoPath(url);
                    } else {
                        mVideoPlay.delCache(url);
                        mVideoPlay.delIOCache(url);
                        if (StaticUtils.TimelyNews) {
                            oneTag = StaticUtils.TimelyOne;
                            twoTag = StaticUtils.TimelyTwo;
                            threeTag = StaticUtils.TimelyThree;
                            threeTag += 1;

                            Log.e("TAG", "onCompletion: 播放完毕执行了1" + oneTag + "___:" + twoTag + "____:" + threeTag);
                            if (tongzhiBean.getGroup() != null) {
                                if (oneTag < tongzhiBean.getGroup().size()) {
                                    a:
                                    for (int i = oneTag; i < tongzhiBean.getGroup().size(); i++) {
                                        if (twoTag > tongzhiBean.getGroup().get(oneTag).size()) {
                                            oneTag += 1;
                                        } else {
                                            Log.e("TAG", "onCompletion: 播放完毕执行了2" + oneTag + "___:" + twoTag + "____:" + threeTag);
                                            for (int j = twoTag; j <= tongzhiBean.getGroup().get(oneTag).size(); j++) {
                                                if (threeTag >= tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().size()) {
                                                    Log.e("TAG", "onCompletion: 播放完毕执行了查看" + oneTag + "___:" + tongzhiBean.getGroup().size());
                                                    if (oneTag >= (tongzhiBean.getGroup().size() - 1)) {
                                                        oneTag = 0;
                                                        twoTag = 0;
                                                        threeTag = 0;
                                                        Log.e("TAG", "onCompletion: 播放完毕执行了重新");
                                                        restart();
                                                        return;
                                                    } else {
                                                        oneTag += 1;
                                                        twoTag = 0;
                                                        threeTag = 0;
                                                        Log.e("TAG", "onCompletion: 播放完毕执行了继续");
                                                        continue a;
                                                    }
                                                } else {
                                                    Log.e("TAG", "onCompletion: 播放完毕执行了3" + oneTag + "___:" + twoTag + "____:" + threeTag);

                                                    for (int k = threeTag; k < tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().size(); k++) {
                                                        if (tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().get(threeTag).getName() != null) {
                                                            Log.e("TAG", "onCompletion: 播放完毕执行了4" + oneTag + "___:" + twoTag + "____:" + threeTag);
                                                            skip();
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                } else {
                                    oneTag = 0;
                                    twoTag = 0;
                                    threeTag = 0;
                                }
                            }
                        } else {

                            QuanBuBean quanBuBean = StaticUtils.dataBase;


                            int tag = StaticUtils.showBarIndex;
                            index += 1;
                            if (index >= quanBuBean.getData().get(tag).getData().size()) {
                                index = 0;
                            }
                            if ("0".equals(quanBuBean.getData().get(tag).getData().get(index).getIs_video())) {
                                Intent intent = new Intent(VideoViewActivity.this,ClassSaveUtils.CarouselImgActivity);
                                StaticUtils.imgId = quanBuBean.getData().get(tag).getData().get(index).getId();
                                StaticUtils.nextIndex = index;
                                StaticUtils.VideoSkip = true;
                                startActivity(intent);
                                finish();
                            } else {
                                mVideoPlay.setVideoPath(quanBuBean.getData().get(tag).getData().get(index).getVideo_adr());
                                StaticUtils.nextIndex = index;
                            }
                        }
                    }
                }
            });
        }
    }


    public void skip() {
        Log.e("TAG", "skipVideo: " + oneTag + "___:" + twoTag + "____:" + threeTag);

        Log.e("TAG", "看看Video1: " + oneTag + "____:" + twoTag + "____:" + threeTag);
        if ("0".equals(tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().get(threeTag).getIs_video())) {
            Intent intent = new Intent(VideoViewActivity.this, ClassSaveUtils.CarouselImgActivity);
            StaticUtils.imgId = tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().get(threeTag).getId();
            StaticUtils.TimelyOne = oneTag;
            StaticUtils.TimelyTwo = twoTag;
            StaticUtils.TimelyThree = threeTag;
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();

        } else {

            mVideoPlay.setVideoPath(tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().get(threeTag).getVideo_adr());
            StaticUtils.TimelyOne = oneTag;
            StaticUtils.TimelyTwo = twoTag;
            StaticUtils.TimelyThree = threeTag;

        }


    }

    public void restart() {
        Log.e("TAG", "restart: " + StaticUtils.Timelyisxh);
        if (StaticUtils.Timelyisxh) {
            for (int i = oneTag; i < tongzhiBean.getGroup().size(); i++) {
                for (int j = twoTag; j < tongzhiBean.getGroup().get(i).size(); j++) {
                    for (int k = threeTag; k < tongzhiBean.getGroup().get(i).get(j).getData().size(); k++) {
                        if (tongzhiBean.getGroup().get(i).get(j).getData().get(k).getName() != null) {
                            oneTag = i;
                            twoTag = j;
                            threeTag = k;
                            skip();
                            return;
                        }
                    }
                }
            }
        } else {
            startActivity(new Intent(VideoViewActivity.this, ClassSaveUtils.MainActivity));
            ActivityCollector.finishAll();
        }
    }

    int tag;

    public void getVideotag(int tag) {
        this.tag = tag;

    }

    @Override
    protected void onResume() {
        super.onResume();
        mVideoPlay.start();
    }

    private void initView() {
        mVideoPlay = (PLVideoView) findViewById(R.id.VideoView);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int heigth = dm.heightPixels;
        int width = dm.widthPixels;


        mTitle = (TextView) findViewById(R.id.title);
        mCurrentTime = (TextView) findViewById(R.id.current_time);
        mIvPlay = (ImageView) findViewById(R.id.iv_play);
        mSeekbar = (SeekBar) findViewById(R.id.seekbar);
        mEndTime = (TextView) findViewById(R.id.end_time);
        mLeftMenu = (LinearLayout) findViewById(R.id.left_menu);
        mBtnMenu = (LinearLayout) findViewById(R.id.btn_menu);
        mJindu = (TextView) findViewById(R.id.jindu);
        mCenterBtn = (ImageView) findViewById(R.id.center_btn);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);


        new TimeThread().start();

//        mGgImg = (ImageView) findViewById(R.id.gg_img);
//        mGg = (FrameLayout) findViewById(R.id.gg);
//        mGgText = (TextView) findViewById(R.id.gg_text);
    }


    public class TimeThread extends Thread {
        @Override
        public void run() {
            super.run();
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    mCurrentTime.setText(new SimpleDateFormat("HH:mm").format(new Date(System.currentTimeMillis())));
                    break;
            }
            return false;
        }
    });


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {


        if ((keyCode == KeyEvent.KEYCODE_BACK) || (keyCode == KeyEvent.KEYCODE_BACKSLASH)) {

            Utils.SEEK_CURRENT = (int) mVideoPlay.getCurrentPosition();
            Utils.is_pause = isPause;
            if (StaticUtils.TimelyNews) {
                return true;
            }

            Intent i = new Intent();
            Log.e("TAA", "seek测试3：推出前：" + mVideoPlay.getCurrentPosition());
//
            i.putExtra("currentPlayPosition", mVideoPlay.getCurrentPosition());
            i.putExtra("pause", isPause);

            setResult(111, i);
            mVideoPlay.stopPlayback();
            finish();

            if (StaticUtils.VideoSkip) {

                finish();
            }

            return true;
        } else if (keyCode == KeyEvent.KEYCODE_HOME || keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_DPAD_LEFT
                || keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            return videoViewObj.onKeyDown(keyCode, event);

        } else {
            return super.onKeyDown(keyCode, event);
        }
    }


    @Override
    protected void onDestroy() {
//        mVideoPlay.stopPlayback();
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        mVideoPlay.stopPlayback();
    }

    protected void onStop() {
        super.onStop();
        mVideoPlay.stopPlayback();
    }

    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {

            } else {
                Log.e("TAG", "onReceive: 没网了");
//                options.setInteger(AVOptions.KEY_VIDEO_DATA_CALLBACK, 1);
            }
        }
    }


    ;


}