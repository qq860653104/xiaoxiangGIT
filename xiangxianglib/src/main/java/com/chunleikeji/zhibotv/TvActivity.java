package com.chunleikeji.zhibotv;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.allenliu.versionchecklib.core.AllenChecker;
import com.allenliu.versionchecklib.core.VersionDialogActivity;
import com.allenliu.versionchecklib.core.VersionParams;
import com.bumptech.glide.Glide;
import com.chunleikeji.bean.VerBean;
import com.chunleikeji.login.DataHttp;
import com.chunleikeji.login.HttpLonIn;
import com.chunleikeji.login.Login;
import com.chunleikeji.login.Return;
import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.Config;
import com.chunleikeji.util.SPUtils;
import com.chunleikeji.util.ToastUtils;
import com.chunleikeji.xiangxianglib.R;
import com.google.gson.Gson;
import com.pili.pldroid.player.AVOptions;
import com.pili.pldroid.player.PLOnAudioFrameListener;
import com.pili.pldroid.player.PLOnBufferingUpdateListener;
import com.pili.pldroid.player.PLOnCompletionListener;
import com.pili.pldroid.player.PLOnErrorListener;
import com.pili.pldroid.player.PLOnInfoListener;
import com.pili.pldroid.player.PLOnVideoFrameListener;
import com.pili.pldroid.player.PLOnVideoSizeChangedListener;
import com.pili.pldroid.player.widget.PLVideoView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class TvActivity extends Activity  {
    private static final int DEFAULT_SCREEN = 4;
    ListView ls_tab;
    ListView ls_content;
    ListView ls_XianLu;
    ListView ls_Sheng;
    ListView ls_Shi;
    RelativeLayout rl_tabList;
    //    private VitamioVideoView videoview;
    private PLVideoView videoview;
    private int videoWidth;
    private int videoHeight;
    private SeekBar seekbarVideo;

    public static String zhibo_img_intentkey = "zhibo_img";
    public static String zhibo_zimu_intentkey = "zhibo_zimu";
    /**
     * zhibo_zimu
     * 视频进度的更新
     */
    private static final int PROGRESS = 1;
    /**
     * 隐藏控制面板
     */
    private static final int HIDE_MEDIACONTROLLER = 2;

    /**
     * 显示网络速度
     */
    private static final int SHOW_SPEED = 3;
    /**
     * 全屏
     */
    private static final int FULL_SCREEN = 1;
    private Utils utils;
    private TextView tv_laoding_netspeed;
    private TextView tv_scrollTextView, tvText;
    private RelativeLayout rl_buffer;
    private LinearLayout ll_loading;
    private TextView tv_buffer_netspeed;
    private LinearLayout ll_menuList;
    private Spinner spList;
    private Spinner spSheng;
    private Spinner spShi;
    private ImageView iv_notifyImage;
    private boolean mIsLiveStreaming = true;
    private HideControl hideControl;
    private ImageView No_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        QuanWangTong.registNotify(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_tv);
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this,MobclickAgent.EScenarioType.E_UM_NORMAL);
        ls_tab = (ListView) findViewById(R.id.ls_tab);
        ls_content = (ListView) findViewById(R.id.ls_content);
        rl_tabList = (RelativeLayout) findViewById(R.id.rl_tabList);
        ll_menuList = (LinearLayout) findViewById(R.id.ll_menuList);
        videoview = (PLVideoView) findViewById(R.id.videoview1);
        seekbarVideo = (SeekBar) findViewById(R.id.seekbar_video);
        tv_laoding_netspeed = (TextView) findViewById(R.id.tv_laoding_netspeed);
        rl_buffer = (RelativeLayout) findViewById(R.id.rl_buffer);
        ll_loading = (LinearLayout) findViewById(R.id.ll_loading);
        tv_buffer_netspeed = (TextView) findViewById(R.id.tv_buffer_netspeed);
        tv_scrollTextView = (TextView) findViewById(R.id.tv_scrollTextView);
        spList = (Spinner) findViewById(R.id.spList);
        spSheng = (Spinner) findViewById(R.id.spSheng);
        spShi = (Spinner) findViewById(R.id.spShi);
        iv_notifyImage = (ImageView) findViewById(R.id.iv_notifyImage);
        No_img = (ImageView)findViewById(R.id.No_img);

        ls_XianLu = (ListView) findViewById(R.id.ls_XianLu);
        ls_Sheng = (ListView) findViewById(R.id.ls_Sheng);
        ls_Shi = (ListView) findViewById(R.id.ls_Shi);
        tvText = findViewById(R.id.tvText);

//        videoview.setDuplicateParentStateEnabled();

//        int codec = AVOptions.MEDIA_CODEC_AUTO;
        int codec = getIntent().getIntExtra("mediaCodec", AVOptions.MEDIA_CODEC_SW_DECODE);
        AVOptions options = new AVOptions();
        // the unit of timeout is ms
        options.setInteger(AVOptions.KEY_PREPARE_TIMEOUT, 10 * 1000);
        // 1 -> hw codec enable, 0 -> disable [recommended]
        options.setInteger(AVOptions.KEY_MEDIACODEC, codec);
        options.setInteger(AVOptions.KEY_LIVE_STREAMING, mIsLiveStreaming ? 1 : 0);
        boolean disableLog = getIntent().getBooleanExtra("disable-log", false);
        // options.setString(AVOptions.KEY_DNS_SERVER, "127.0.0.1");
        options.setInteger(AVOptions.KEY_LOG_LEVEL, disableLog ? 5 : 0);
        boolean cache = getIntent().getBooleanExtra("cache", false);
        if (!mIsLiveStreaming && cache) {
            options.setString(AVOptions.KEY_CACHE_DIR, Config.DEFAULT_CACHE_DIR);
        }
        boolean vcallback = getIntent().getBooleanExtra("video-data-callback", false);
        if (vcallback) {
            options.setInteger(AVOptions.KEY_VIDEO_DATA_CALLBACK, 1);
        }
        boolean acallback = getIntent().getBooleanExtra("audio-data-callback", false);
        if (acallback) {
            options.setInteger(AVOptions.KEY_AUDIO_DATA_CALLBACK, 1);
        }
        if (!mIsLiveStreaming) {
            int startPos = getIntent().getIntExtra("start-pos", 0);
            options.setInteger(AVOptions.KEY_START_POSITION, startPos * 1000);
        }
        // options.setString(AVOptions.KEY_COMP_DRM_KEY,"cWoosgRk");
        videoview.setAVOptions(options);
        //    videoview.setAVOptions(options);

        videoview.setBufferingIndicator(No_img);
        videoview.setOnInfoListener(mOnInfoListener);
        videoview.setOnVideoSizeChangedListener(mOnVideoSizeChangedListener);
        videoview.setOnBufferingUpdateListener(mOnBufferingUpdateListener);
        videoview.setOnCompletionListener(mOnCompletionListener);
        videoview.setOnErrorListener(mOnErrorListener);
        videoview.setOnVideoFrameListener(mOnVideoFrameListener);
        videoview.setOnAudioFrameListener(mOnAudioFrameListener);
        videoview.setDisplayAspectRatio(PLVideoView.ASPECT_RATIO_16_9);
//        videoview.setVideoPath(videoPath);
        videoview.setLooping(getIntent().getBooleanExtra("loop", false));

        // You can also use a custom `MediaController` widget

//        handler.postDelayed(runnable, 5000);
        testChuanBo();

        //检测版本更新
//        checkAPKUpdate();
        /*initNetData();
        showPlayer();*/


/*
        initXianLu();
        init_Sheng();
        init_Shi();*/
        /*  getIntentData();*/
//        timerTask();
        hideControl = new HideControl();
//        abc();
    }


    private PLOnInfoListener mOnInfoListener = new PLOnInfoListener() {
        @Override
        public void onInfo(int what, int extra) {
            Log.i(TAG, "OnInfo, what = " + what + ", extra = " + extra);
            switch (what) {
                case PLOnInfoListener.MEDIA_INFO_BUFFERING_START:
                    break;
                case PLOnInfoListener.MEDIA_INFO_BUFFERING_END:
                    break;
                case PLOnInfoListener.MEDIA_INFO_VIDEO_RENDERING_START:
//                    com.pili.pldroid.playerdemo.utils.Utils.showToastTips(TvActivity.this, "first video render time: " + extra + "ms");
//                    Log.i(TAG, "Response: " + videoview.getResponseInfo());
                    break;
                case PLOnInfoListener.MEDIA_INFO_AUDIO_RENDERING_START:
                    break;
                case PLOnInfoListener.MEDIA_INFO_VIDEO_FRAME_RENDERING:
                    Log.i(TAG, "video frame rendering, ts = " + extra);
                    break;
                case PLOnInfoListener.MEDIA_INFO_AUDIO_FRAME_RENDERING:
                    Log.i(TAG, "audio frame rendering, ts = " + extra);
                    break;
                case PLOnInfoListener.MEDIA_INFO_VIDEO_GOP_TIME:
                    Log.i(TAG, "Gop Time: " + extra);
                    break;
                case PLOnInfoListener.MEDIA_INFO_SWITCHING_SW_DECODE:
                    Log.i(TAG, "Hardware decoding failure, switching software decoding!");
                    break;
                case PLOnInfoListener.MEDIA_INFO_METADATA:
                    Log.i(TAG, videoview.getMetadata().toString());
                    break;
                case PLOnInfoListener.MEDIA_INFO_VIDEO_BITRATE:
                case PLOnInfoListener.MEDIA_INFO_VIDEO_FPS:
                    updateStatInfo();
                    break;
                case PLOnInfoListener.MEDIA_INFO_CONNECTED:
                    Log.i(TAG, "Connected !");
                    break;
                case PLOnInfoListener.MEDIA_INFO_VIDEO_ROTATION_CHANGED:
                    Log.i(TAG, "Rotation changed: " + extra);
                    break;
                case PLOnInfoListener.MEDIA_INFO_LOOP_DONE:
                    Log.i(TAG, "Loop done");
                    break;
                case PLOnInfoListener.MEDIA_INFO_CACHE_DOWN:
                    Log.i(TAG, "Cache done");
                    break;
                default:
                    break;
            }
        }
    };

    private void updateStatInfo() {
        long bitrate = videoview.getVideoBitrate() / 1024;
//        final String stat = bitrate + "kbps, " + mVideoView.getVideoFps() + "fps";
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                mStatInfoTextView.setText(stat);
//            }
//        });
    }

    private PLOnErrorListener mOnErrorListener = new PLOnErrorListener() {
        @Override
        public boolean onError(int errorCode) {
            Log.e(TAG, "Error happened, errorCode = " + errorCode);


            switch (errorCode) {
                case PLOnErrorListener.ERROR_CODE_IO_ERROR:
                    /**
                     * SDK will do reconnecting automatically
                     */
                    Log.i(TAG, "链接无法播放0");
                    return false;
                case PLOnErrorListener.ERROR_CODE_OPEN_FAILED:
//                    com.pili.pldroid.playerdemo.utils.Utils.showToastTips(TvActivity.this, "failed to open player !");
//                    Toast.makeText(TvActivity.this, "链接无法播放", Toast.LENGTH_SHORT).show();
                    Log.i(TAG, "链接无法播放1");
//                    No_img.setVisibility(View.VISIBLE);
//                    showErrorDialog();
                    break;
                case PLOnErrorListener.ERROR_CODE_SEEK_FAILED:
                    Log.i(TAG, "链接无法播放2");
//                    com.pili.pldroid.playerdemo.utils.Utils.showToastTips(TvActivity.this, "failed to seek !");
//                    showErrorDialog();
                    return true;
                case PLOnErrorListener.ERROR_CODE_CACHE_FAILED:
                    Log.i(TAG, "链接无法播放3");
//                    com.pili.pldroid.playerdemo.utils.Utils.showToastTips(TvActivity.this, "failed to cache url !");
                    No_img.setVisibility(View.VISIBLE);

                    break;
                case PLOnErrorListener.ERROR_CODE_HW_DECODE_FAILURE:
                    Log.i(TAG, "链接无法播放4");
                    break;
                default:
//                    com.pili.pldroid.playerdemo.utils.Utils.showToastTips(TvActivity.this, "unknown error !");
                    break;
            }

            return true;
        }
    };

    private PLOnCompletionListener mOnCompletionListener = new PLOnCompletionListener() {
        @Override
        public void onCompletion() {
            Log.i(TAG, "Play Completed !");
//            com.pili.pldroid.playerdemo.utils.Utils.showToastTips(TvActivity.this, "Play Completed !");
            if (!mIsLiveStreaming) {
//                mMediaController.refreshProgress();
            }
            //finish();
        }
    };

    private String bytesToHex(byte[] bytes) {
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private PLOnBufferingUpdateListener mOnBufferingUpdateListener = new PLOnBufferingUpdateListener() {
        @Override
        public void onBufferingUpdate(int precent) {
            Log.i(TAG, "onBufferingUpdate: " + precent);
        }
    };

    private PLOnVideoSizeChangedListener mOnVideoSizeChangedListener = new PLOnVideoSizeChangedListener() {
        @Override
        public void onVideoSizeChanged(int width, int height) {
            Log.i(TAG, "onVideoSizeChanged: width = " + width + ", height = " + height);


        }
    };

    private PLOnVideoFrameListener mOnVideoFrameListener = new PLOnVideoFrameListener() {
        @Override
        public void onVideoFrameAvailable(byte[] data, int size, int width, int height, int format, long ts) {
            Log.i(TAG, "onVideoFrameAvailable: " + size + ", " + width + " x " + height + ", " + format + ", " + ts);
            if (format == PLOnVideoFrameListener.VIDEO_FORMAT_SEI && bytesToHex(Arrays.copyOfRange(data, 19, 23)).equals("74733634")) {
                // If the RTMP stream is from Qiniu
                // Add &addtssei=true to the end of BaseUrl to enable SEI timestamp.
                // Format of the byte array:
                // 0:       SEI TYPE                    This is part of h.264 standard.
                // 1:       unregistered user data      This is part of h.264 standard.
                // 2:       payload length              This is part of h.264 standard.
                // 3-18:    uuid                        This is part of h.264 standard.
                // 19-22:   ts64                        Magic string to mark this stream is from Qiniu
                // 23-30:   timestamp                   The timestamp
                // 31:      0x80                        Magic hex in ffmpeg
                Log.i(TAG, " timestamp: " + Long.valueOf(bytesToHex(Arrays.copyOfRange(data, 23, 31)), 16));
            }
        }
    };

    private PLOnAudioFrameListener mOnAudioFrameListener = new PLOnAudioFrameListener() {
        @Override
        public void onAudioFrameAvailable(byte[] data, int size, int samplerate, int channels, int datawidth, long ts) {
            Log.i(TAG, "onAudioFrameAvailable: " + size + ", " + samplerate + ", " + channels + ", " + datawidth + ", " + ts);
        }
    };

    private MediaController.OnClickSpeedAdjustListener mOnClickSpeedAdjustListener = new MediaController.OnClickSpeedAdjustListener() {
        @Override
        public void onClickNormal() {
            // 0x0001/0x0001 = 2
            videoview.setPlaySpeed(0X00010001);
            Log.i(TAG, "链接无法播放4");

        }

        @Override
        public void onClickFaster() {
            // 0x0002/0x0001 = 2
            videoview.setPlaySpeed(0X00020001);
            Log.i(TAG, "链接无法播放5");

        }

        @Override
        public void onClickSlower() {
            // 0x0001/0x0002 = 0.5
            videoview.setPlaySpeed(0X00010002);
            Log.i(TAG, "链接无法播放6");

        }
    };

    private Timer timer;

    private void timerTask() {
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
//                Message message = mHandler.obtainMessage(1);
//                mHandler.sendMessage(message);
                checkAPKUpdate();
            }
        };
        timer.schedule(task, 2000, 1800000);
    }


    //    String listUrl = "http://39.105.70.121/test2/goiptvThink/think_test/public/index.php/index/index/getGoTvList";
//    String listUrl = "http://39.105.70.121/test/ThinkAdmin-master/chuanbojiekou/think_test/public/index.php/index/index/getshebei";
//    String listUrl = StaticUtils.baseUrl + "ThinkAdmin-master/chuanbojiekou/think_test/public/index.php/index/index/getshebei";
//    String listUrl = "http://39.106.60.208/waibao/chuanbo/shipin.txt";
//    String listUrl = "http://192.168.1.221:20001/chuabo/shipin.txt";
//      String listUrl = "http://39.105.70.121/test2/fuyin/jiekou/public/index.php/index/index/getGoTvList";

    String type = SPUtils.getSharedStringData(TvActivity.this, "type");

    List<TVTabBean> urllist = new ArrayList<>();


    private void testChuanBo() {
        utils = new Utils();


        String listUrl = BaseUrl.BASE + "getZhibo?type=" + type;
        Log.i(TAG, "链接无法播放78:" + listUrl);
//
//        listUrl = "http://39.106.60.208/waibao/chuanbo/"+type+".txt";
//        listUrl = "http://192.168.1.221:20001/chuabo/" + type + ".txt";
        OKHttpUtils.getOkHttp(this, listUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, "链接无法播放7");

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                // list.removeAll(list);
//                String[] strings2 = body.split("\n");
//                for (int x = 0; x < strings2.length; x++) {
//                    String[] split = strings2[x].split("[$]");
//                    Log.e("TAA", "body:" + body);
//
//                    if (split != null && split.length == 1) {
//                        return;
//                    }
//
//                    if (split[0] != null && split[1] != null) {
//                        Log.e("TAA", "name:" + split[0] + "__________url++:" + split[1]);
//                    }
//                    //     list.add(new ListBean(split[0], split[1]));
//                    tabList.add(new TVTabBean(split[0], replaceBlank(split[1].trim())));
//
//                }
                if (body != null) {
                    TVResponse tvResponse = new Gson().fromJson(body, TVResponse.class);
                    if (tvResponse.getData() != null) {
                        for (int i = 0; i < tvResponse.getData().size(); i++) {

                            urllist.add(new TVTabBean(tvResponse.getData().get(i).getName(), tvResponse.getData().get(i).getUrl()));

                        }

                        Log.e("TAA", "链接无法播放8：" + urllist);
                    }

//                homeAdapter.notifyDataSetChanged();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            initLsTab();
                            showPlayer();

                        }
                    });
                }else {
                    ToastUtils.showToast(TvActivity.this,"暂无内容");
                }
            }
        });

    }

    public static String replaceBlank(String str) {

        String dest = "";

        if (str != null) {

            Pattern p = Pattern.compile("\\s*|\t|\r|\n");

            Matcher m = p.matcher(str);

            dest = m.replaceAll("");

        }

        return dest;

    }

    String zhibo_img;
    String zhibo_zimu;

    private void getIntentData() {
        zhibo_img = getIntent().getStringExtra(zhibo_img_intentkey);
        zhibo_zimu = getIntent().getStringExtra(zhibo_zimu_intentkey);
    }

    private void checkAPKUpdate() {
//        new APKUpdate(TvActivity.this, ConstCommon.getAPKCheckTV(), tv_scrollTextView);
    }

    private void setData() {
//        videoview.setVideoChroma(MediaPlayer.VIDEOCHROMA_RGB565);
        Log.e("TAA", "链接无法播放9:" + urllist.get(0).url);
        videoview.setVideoPath(urllist.get(0).url);

    }


    private void showPlayer() {
    /*//设置视频的宽和高
        videoview.setVideoSize(200, 200);*/
        setData();
        setListener();

        //设置SeeKbar状态变化的监听
        // seekbarVideo.setOnSeekBarChangeListener(new VideoOnSeekBarChangeListener());


    }

    @Override
    protected void onResume() {
        super.onResume();
        videoview.start();
//        checkVersion();

    }

    private String upVersion = "http://39.105.70.121/test2/fuyin/jiekou/public/index.php/index/index/updataApp";

    public void checkVersion() {
        OKHttpUtils.getOkHttp(this, upVersion, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.e("TAA", "updataBODY:" + body);
                final VerBean verBean = new Gson().fromJson(body, VerBean.class);
//                final VerBean verBean = gson.fromJson(result, VerBean.class);
//                Log.e("VerBean", "返回信息" + verBean.getVerid() + "__________" + VerUtils.getVersion(TvActivity.this) + "_____" + (!(verBean.getVerid().equals(VerUtils.getVersion(TvActivity.this)))));

                if (verBean.getVerid() != null && verBean.getVerid() != "" && !(verBean.getVerid().equals(VerUtils.getVersion(TvActivity.this)))) {//版本不一样 下载 并安装apk


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            VersionParams.Builder builder = new VersionParams.Builder()
                                    .setRequestUrl("http://www.baidu.com")
                                    .setService(DemoService.class);
                            stopService(new Intent(TvActivity.this, DemoService.class));

                            CustomVersionDialogActivity.customVersionDialogIndex = 2;
                            builder.setCustomDownloadActivityClass(CustomVersionDialogActivity.class);
                            CustomVersionDialogActivity.isCustomDownloading = false;
                            builder.setCustomDownloadActivityClass(VersionDialogActivity.class);
                            CustomVersionDialogActivity.isForceUpdate = false;
                            builder.setCustomDownloadActivityClass(CustomVersionDialogActivity.class);
                            builder.setSilentDownload(false);
                            builder.setForceRedownload(true);
                            builder.setOnlyDownload(true)
                                    .setDownloadUrl(verBean.getAddress())
                                    .setTitle("检测到新版本" + verBean.getVerid())
                                    .setUpdateMsg(verBean.getVercontent());
                            builder.setShowNotification(false);
                            builder.setShowDownloadingDialog(true);
                            AllenChecker.startVersionCheck(TvActivity.this, builder.build());

                            Log.e(" TAA", "去下载了？" + verBean.getAddress());
                        }
                    });

                }

            }
        });

    }



    public void show(String notify, String imagUrl) {
        showScrollText(notify);
        if (imagUrl != null) {
            iv_notifyImage.setVisibility(View.VISIBLE);
            if (TextUtils.isEmpty(zhibo_img)) {
                Glide.with(this).load(imagUrl).into(iv_notifyImage);
            } else {
                Glide.with(this).load(zhibo_img).into(iv_notifyImage);
            }

        }

    }

    public void showScrollText(String notify) {
        tv_scrollTextView.setVisibility(View.VISIBLE);
        if (TextUtils.isEmpty(zhibo_zimu)) {
            tv_scrollTextView.setText(notify);
        } else {
            tv_scrollTextView.setText(zhibo_zimu);
        }

        tv_scrollTextView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                tv_scrollTextView.getViewTreeObserver().removeOnPreDrawListener(this);
                DisplayMetrics dm = new DisplayMetrics();

                getWindowManager().getDefaultDisplay().getMetrics(dm);
                int screenWidth = dm.widthPixels;
                int screenHeigh = dm.heightPixels;

                TranslateAnimation animation = new TranslateAnimation(screenWidth, 0 - tv_scrollTextView.getWidth() - 50, 0, 0);
                animation.setDuration(12000);//设置动画持续时间
                animation.setRepeatCount(2);//设置重复次数

                tv_scrollTextView.setAnimation(animation);
                animation.startNow();

                return false;
            }
        });
    }

    class VideoOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {

        /**
         * 当手指滑动的时候，会引起SeekBar进度变化，会回调这个方法
         *
         * @param seekBar
         * @param progress
         * @param fromUser 如果是用户引起的true,不是用户引起的false
         */
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                videoview.seekTo(progress);
            }

        }

        /**
         * 当手指触碰的时候回调这个方法
         *
         * @param seekBar
         */
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

            // handler.removeMessages(HIDE_MEDIACONTROLLER);
        }

        /**
         * 当手指离开的时候回调这个方法
         *
         * @param seekBar
         */
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            //  handler.sendEmptyMessageDelayed(HIDE_MEDIACONTROLLER, 4000);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //移除所有的消息
        handler.removeCallbacksAndMessages(null);
//        QuanWangTong.unRegistNotify(this);
        videoview.stopPlayback();
        videoview.destroyDrawingCache();

        videoview = null;
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SHOW_SPEED://显示网速
                    //1.得到网络速度
                    String netSpeed = utils.getNetSpeed(TvActivity.this);

                    //显示网络速
                    tv_laoding_netspeed.setText("玩命加载中..." + netSpeed);
                    tv_buffer_netspeed.setText("" + netSpeed);

                    //2.每两秒更新一次
                    handler.removeMessages(SHOW_SPEED);
                    handler.sendEmptyMessageDelayed(SHOW_SPEED, 2000);

                    break;
                case HIDE_MEDIACONTROLLER://隐藏控制面板
                    //  hideMediaController();
                    break;
                case PROGRESS:

                    //1.得到当前的视频播放进程
                    int currentPosition = (int) videoview.getCurrentPosition();//0

                    //2.SeekBar.setProgress(当前进度);
                    seekbarVideo.setProgress(currentPosition);


                    //更新文本播放进度
                    // tvCurrentTime.setText(utils.stringForTime(currentPosition));


                    //设置系统时间
                    // tvSystemTime.setText(getSysteTime());

                    //缓存进度的更新
                    /*if (isNetUri) {
                        //只有网络资源才有缓存效果
                        int buffer = videoview.getBufferPercentage();//0~100
                        int totalBuffer = buffer * seekbarVideo.getMax();
                        int secondaryProgress = totalBuffer / 100;
                        seekbarVideo.setSecondaryProgress(secondaryProgress);
                    } else {
                        //本地视频没有缓冲效果
                        seekbarVideo.setSecondaryProgress(0);
                    }*/

                    //监听卡
                    /*if (!isUseSystem && videoview.isPlaying()) {

                        if(videoview.isPlaying()){
                            int buffer = currentPosition - precurrentPosition;
                            if (buffer < 500) {
                                //视频卡了
                                ll_buffer.setVisibility(View.VISIBLE);
                            } else {
                                //视频不卡了
                                ll_buffer.setVisibility(View.GONE);
                            }
                        }else{
                            ll_buffer.setVisibility(View.GONE);
                        }

                    }


                    precurrentPosition = currentPosition;*/

                    //3.每秒更新一次
                    handler.removeMessages(PROGRESS);
                    handler.sendEmptyMessageDelayed(PROGRESS, 1000);

                    break;
            }
        }
    };

    private void setListener() {
        //准备好的监听
//        videoview.setOnPreparedListener(new MyOnPreparedListener());

        //播放出错了的监听
//        videoview.setOnErrorListener(new MyOnErrorListener());

        //播放完成了的监听
//        videoview.setOnCompletionListener(new MyOnCompletionListener());

        //设置SeeKbar状态变化的监听
        seekbarVideo.setOnSeekBarChangeListener(new VideoOnSeekBarChangeListener());

        //监听视频播放卡-系统的api
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            videoview.setOnInfoListener(new MyOnInfoListener());
        }

    }

    class MyOnInfoListener implements MediaPlayer.OnInfoListener {

        @Override
        public boolean onInfo(MediaPlayer mp, int what, int extra) {
            switch (what) {
                case MediaPlayer.MEDIA_INFO_BUFFERING_START://视频卡了，拖动卡
//                    Toast.makeText(SystemVideoPlayer.this, "卡了", Toast.LENGTH_SHORT).show();
                    rl_buffer.setVisibility(View.VISIBLE);
                    break;

                case MediaPlayer.MEDIA_INFO_BUFFERING_END://视频卡结束了，拖动卡结束了
//                    Toast.makeText(SystemVideoPlayer.this, "卡结束了", Toast.LENGTH_SHORT).show();
                    rl_buffer.setVisibility(View.GONE);
                    break;
            }
            return true;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        videoview.pause();
    }


//    class MyOnPreparedListener implements io.vov.vitamio.MediaPlayer.OnPreparedListener {
//
//        //当底层解码准备好的时候
//        @Override
//        public void onPrepared(io.vov.vitamio.MediaPlayer mp) {
//            videoWidth = mp.getVideoWidth();
//            videoHeight = mp.getVideoHeight();
//            //指定视频的宽高
//            videoview.start();//开始播放
//            //1.视频的总时长，关联总长度
//            int duration = (int) videoview.getDuration();
//            seekbarVideo.setMax(duration);
//            //tvDuration.setText(utils.stringForTime(duration));
//
//            //  hideMediaController();//默认是隐藏控制面板
//            //2.发消息
//            handler.sendEmptyMessage(PROGRESS);
//            handler.sendEmptyMessage(SHOW_SPEED);
//
////            videoview.setVideoSize(200,200);
////            videoview.setVideoSize(mp.getVideoWidth(),mp.getVideoHeight());
//
//            //屏幕的默认播放
//            // setVideoType(DEFAULT_SCREEN);
//
//            //把加载页面消失掉
//            ll_loading.setVisibility(View.GONE);
//
////            mp.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
////                @Override
////                public void onSeekComplete(MediaPlayer mp) {
////                    Toast.makeText(SystemVideoPlayer.this, "拖动完成", Toast.LENGTH_SHORT).show();
////                }
////            });
//
//
//        }
//    }


    private void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("源出现错误，无法播放");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                finish();
            }
        });
        builder.show();
    }


    ListTabDetailAdapter tabDetailAdapter;
    HashMap<Integer, List<TabDetail>> tabDetailMap = new HashMap<>();

//    private void initListTabDetail() {
//        List<TVResponse.MorenBean> moren = tvVResponse.getMoren();
//        for (int i = 0; i < moren.size(); i++) {
//            TVResponse.MorenBean morenBean = moren.get(i);
//            String erji_list = morenBean.getErji_list();
//            addDataToTabDetailMap(Integer.parseInt(morenBean.getId()), erji_list);
//        }
//
//        List<TVResponse.TanceBean> tance = tvVResponse.getTance();
//        for (int i = 0; i < tance.size(); i++) {
//            TVResponse.TanceBean tanceBean = tance.get(i);
//            String erji_list = tanceBean.getErji_list();
//            addDataToTabDetailMap(Integer.parseInt(tanceBean.getId()), erji_list);
//        }
//
//
//       /* for(int i=0;i<4;i++){
//            ArrayList<TabDetail> objList = new ArrayList<>();
//            for(int j=0;j<20;j++){
//                TabDetail tabDetail = new TabDetail();
//                tabDetail.name=i+"TV"+j;
//                if(j%2 ==0){
//                    tabDetail.url = "http://ivi.bupt.edu.cn/hls/cctv15.m3u8";
//                }else {
//                    tabDetail.url = "http://ivi.bupt.edu.cn/hls/cctv14.m3u8";
//                }
//                objList.add(tabDetail);
//            }
//            tabDetailMap.put(i,objList);
//        }*/
//        tabDetailAdapter = new ListTabDetailAdapter(this, tabDetailMap.get(tabList.get(0).id));
//        ls_content.setAdapter(tabDetailAdapter);
//        ls_content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Toast.makeText(view.getContext(),"地址:"+tabDetailMap.get(tabList.get(currentSelectTab).id).get(position).url),Toast.LENGTH_LONG);
////                Toast.makeText(TVActivity.this, "" + tabDetailMap.get(tabList.get(currentSelectTab).id).get(position).url, Toast.LENGTH_SHORT).show();
////                Log.e("TAA","")
//                Log.e("TAA", "1播放地址" + tabDetailMap.get(tabList.get(currentSelectTab).id).get(position).url);
////                videoview.getSurfaceView().clearAnimation();
////                videoview.stopPlayback();
//                videoview.setVideoPath(tabDetailMap.get(tabList.get(currentSelectTab).id).get(position).url.trim());
////                videoview.start();
//            }
//        });
//    }

    private void addDataToTabDetailMap(Integer id, String erji_list) {
        String[] split = erji_list.split("\n");
        ArrayList<TabDetail> objList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String[] map = split[i].split("\\$");
            TabDetail tabDetail = new TabDetail();
            tabDetail.name = map[0];
            tabDetail.url = map[1];
            objList.add(tabDetail);
        }
        tabDetailMap.put(id, objList);

    }


    private int[] getScaleWidthAndHeight(int mVideoWidth, int mVideoHeight, int screenWidth, int screenHeight) {
        int scaleWidth = 0;
        int scaleHeight = 0;
        if (mVideoWidth * screenHeight < screenWidth * mVideoHeight) {
            //Log.i("@@@", "image too wide, correcting");
            scaleWidth = screenHeight * mVideoWidth / mVideoHeight;
        } else if (mVideoWidth * screenHeight > screenWidth * mVideoHeight) {
            //Log.i("@@@", "image too tall, correcting");
            scaleHeight = screenWidth * mVideoHeight / mVideoWidth;
        }
        int[] tmp = new int[2];
        tmp[0] = scaleWidth;
        tmp[1] = scaleHeight;
        return tmp;
    }

    List<TVTabBean> tabList = new ArrayList<>();
    int currentSelectTab = 0;

    private void initLsTab() {
//        tabList = getTabList();
        ListTabAdapter tabAdapter = new ListTabAdapter(this, urllist);
        ls_tab.setAdapter(tabAdapter);

        ls_tab.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                No_img.setVisibility(View.GONE);
                hideControl.resetHideTimer();
                Log.e("TAA", "链接无法播放10:" + urllist.get(position).url);
//                videoview.setVideoPath(tabList.get(position).url.trim());
//                videoview.getSurfaceView().clearAnimation();
//                videoview.stopPlayback();
//                videoview.setVideoPath(tabDetailMap.get(tabList.get(currentSelectTab).id).get(position).url.trim());
                videoview.setVideoPath(urllist.get(position).url.trim());
//                videoview.getSurfaceView().notifyAll();
                videoview.start();
            }
        });
    }

    public class HideControl {
        public final static int MSG_HIDE = 0x01;

        private HideHandler mHideHandler;

        public HideControl() {
            mHideHandler = new HideHandler();
        }

        public class HideHandler extends Handler {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case MSG_HIDE:
                        ls_tab.setVisibility(View.INVISIBLE);
                        break;
                }

            }
        }

        private Runnable hideRunable = new Runnable() {

            @Override
            public void run() {
                mHideHandler.obtainMessage(MSG_HIDE).sendToTarget();
            }
        };

        public void startHideTimer() {//开始计时,五秒后执行runable
            mHideHandler.removeCallbacks(hideRunable);
            if (ls_tab.getVisibility() == View.INVISIBLE) {
                ls_tab.setVisibility(View.VISIBLE);
            }
            mHideHandler.postDelayed(hideRunable, 5000);
        }

        public void endHideTimer() {//移除runable,将不再计时
            mHideHandler.removeCallbacks(hideRunable);
        }

        public void resetHideTimer() {//重置计时
            mHideHandler.removeCallbacks(hideRunable);
            mHideHandler.postDelayed(hideRunable, 5000);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {

            case KeyEvent.KEYCODE_ENTER:     //确定键enter
            case KeyEvent.KEYCODE_HOME:
            case KeyEvent.KEYCODE_DPAD_CENTER:
                processEnter();
                hideControl.startHideTimer();
                break;
            case KeyEvent.KEYCODE_MENU:     //菜单键
                // ToastUtils.showToast(TVActivity.this,"菜单");
                ll_menuList.setVisibility(View.VISIBLE);
                videoview.setFocusable(false);
                break;
            case KeyEvent.KEYCODE_BACK:    //返回键
                if (rl_tabList.getVisibility() == View.GONE && (ll_menuList.getVisibility() == View.GONE)) {
                    super.onKeyDown(keyCode, event);
                } else {
                    rl_tabList.setVisibility(View.GONE);
                    ll_menuList.setVisibility(View.GONE);
                    return true;
                }

            case KeyEvent.KEYCODE_DPAD_LEFT:
                //音量控制,初始化定义
                AudioManager mAudioManager = (AudioManager) TvActivity.this.getSystemService(Context.AUDIO_SERVICE);
                int maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                //当前音量
                int currentVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume - 1, 0);

                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                //音量控制,初始化定义
                AudioManager mAudioManager2 = (AudioManager) TvActivity.this.getSystemService(Context.AUDIO_SERVICE);
                int maxVolume2 = mAudioManager2.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                //当前音量
                int currentVolume2 = mAudioManager2.getStreamVolume(AudioManager.STREAM_MUSIC);


                mAudioManager2.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume2 + 1, 0);

                break;
            //这里由于break会退出，所以我们自己要处理掉 不返回上一层

        }
        return super.onKeyDown(keyCode, event);

    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_UP) {
            Log.i(TAG, "onKeyDown: ++++++" + 1);
            hideControl.resetHideTimer();
        } else if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_DOWN) {
            Log.i(TAG, "onKeyDown: ++++++" + 2);
            hideControl.resetHideTimer();

        }
//        else if (event.getKeyCode() == KeyEvent.KEYCODE_BACK){
//            Intent intent = new Intent(TvActivity.this, MainActivity.class);
//            intent.putExtra("data", "2");
//            startActivity(intent);
//            this.finish();
//        }
        return super.dispatchKeyEvent(event);
    }

    private void processEnter() {
        videoview.setFocusable(false);
        rl_tabList.setVisibility(View.VISIBLE);

    }

    String TAG = "TvActivity";
    private String verifyUrl = BaseUrl.BASE + "checkLoginState";

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            SharedPreferences sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
            String user = sharedPreferences.getString("username", "");

            //当前设备MAC
            final String mac = getMacAddressFromIp();
            //当前设备IP
            String ip = getLocalIp();

            final String ABCD = verifyUrl + "?user=" + user + "&mac=" + mac + "&ip=" + ip;
            Log.i(TAG, "连接 " + ABCD);
            HttpLonIn.GetOkGttp(TvActivity.this, ABCD, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Return ren = new Gson().fromJson(response.body().string(), Return.class);
                    int Tag = ren.getTag();
                    String msg = ren.getMsg();
                    if (Tag == 0) {

                        startActivity(new Intent(TvActivity.this, Login.class));
                        TvActivity.this.finish();
                        handler.removeCallbacks(runnable);
                    }
                }
            });
            //每5秒轮询提交一次
            handler.postDelayed(this, 5000);
        }

    };

    //获取当前设备IP
    private static String getLocalIp() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()
                            && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {

        }
        return "0.0.0.0";
    }

    //获取当前设备mac（网卡）
    private static String getMacAddressFromIp() {
        String mac_s = "";
        StringBuilder buf = new StringBuilder();
        try {
            byte[] mac;
            NetworkInterface ne = NetworkInterface.getByInetAddress(InetAddress.getByName(getLocalIp()));
            mac = ne.getHardwareAddress();
            for (byte b : mac) {
                buf.append(String.format("%02X:", b));
            }
            if (buf.length() > 0) {
                buf.deleteCharAt(buf.length() - 1);
            }
            mac_s = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mac_s;
    }

    //滚动消息
    public void abc() {
        final List<String> list = new ArrayList<>();
        String tvUrl = "http://39.105.70.121/test2/fuyin/jiekou/public/index.php/index/index/getZimu";
        HttpLonIn.GetOkGttp(this, tvUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                DataHttp dataHttp = new Gson().fromJson(response.body().string(), DataHttp.class);
                if (dataHttp.getData() != null) {
                    for (int i = 0; i < dataHttp.getData().size(); i++) {
                        DataHttp.DataBean dataBean = dataHttp.getData().get(i);
                        list.add(dataBean.getMsg());
                    }

                }

                runOnUiThread(new TimerTask() {
                    @Override
                    public void run() {
                        tvText.setText(list.get(0));
                        tvText.post(new Runnable() {
                            @Override
                            public void run() {
                                TranslateAnimation translateAnimation = new TranslateAnimation
                                        (tvText.getMeasuredWidth() + 1000, -(tvText.getMeasuredWidth() + 200), 0, 0);
                                translateAnimation.setRepeatCount(Animation.INFINITE);
//                              translateAnimation.setRepeatMode(Animation.REVERSE);
                                translateAnimation.setInterpolator(new LinearInterpolator());
                                translateAnimation.setDuration(10000);
                                tvText.startAnimation(translateAnimation);
                            }
                        });

                    }
                });
            }
        });

    }


}