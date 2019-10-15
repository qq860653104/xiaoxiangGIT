package com.chunleikeji.playvideo;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.chunleikeji.bean.JujiBean;
import com.chunleikeji.bean.PlayBean;
import com.chunleikeji.tag.TagUtils;
import com.chunleikeji.util.ToastUtils;
import com.chunleikeji.xiangxianglib.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import io.vov.vitamio.MediaPlayer;


/**
 * Created by wh on 2018/4/1.
 */

public class DefindeMideaController extends FrameLayout implements MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {

    private MediaPlayer mediaPlayer;

    @Override
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    private String tag ;

    public DefindeMideaController(@NonNull Context context) {
        super(context);
    }

    public DefindeMideaController(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DefindeMideaController(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private FrameLayout top;
    private TextView title, total, currentTimer;
    private RelativeLayout buttom;
    private SeekBar seekBar;
    public LinearLayout center_layout;
    private Thread thread;
    private ImageView pause;
    private int showTimer;
    private TextureView mTextureView;

    public void init(MediaPlayer mediaPlayer, TextureView mTextureView) {
        this.mediaPlayer = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this);
        this.mTextureView = mTextureView;
        total = (TextView) findViewById(R.id.mediacontroller_time_total);
        top = (FrameLayout) findViewById(R.id.top);
        title = (TextView) findViewById(R.id.title);
        buttom = (RelativeLayout) findViewById(R.id.buttom);
        seekBar = (SeekBar) findViewById(R.id.mediacontroller_seekbar);
        center_layout = (LinearLayout) findViewById(R.id.center_layout);
        currentTimer = (TextView) findViewById(R.id.mediacontroller_time_current);
        pause = (ImageView) findViewById(R.id.mediacontroller_play_pause);
        mediaPlayer.setOnSeekCompleteListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setOnCompletionListener(this);

        showThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (showTimer = 0; showTimer < 5; showTimer++) {
                        Log.e("TAA", "剩余时间：" + showTimer);
                        Thread.sleep(1000);
                        if (showTimer == 4) {
                            hint();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        showThread.start();
    }


    public void setTitle(String text) {
        if (title != null) {
            title.setText(text);
        }

    }


    private boolean isShow;

    public void hint() {
//        if(isShow){
//            show();
        isShow = false;
//        }else{
//

        ((Activity) getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                top.animate().setDuration(300).translationY(-top.getHeight()).start();
                buttom.animate().setDuration(300).translationY(buttom.getHeight() * 2).start();
            }
        });

//        isShow = true;
//        }
    }


    public void show() {
        isShow = true;
        ((Activity) getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                showThread.start();
                top.animate().setDuration(300).translationY(0).start();
                buttom.animate().setDuration(300).translationY(0).start();
            }
        });

    }

    private boolean isPropared;

    public void changeVideoSize() {
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
//        Toast.makeText(getContext(), ""+videoHeight, Toast.LENGTH_SHORT).show();

//        Toast.makeText(getContext(), "当前视频的："+videoHeight+"_________"+videoWidth, Toast.LENGTH_LONG).show();
        Log.e("TAA", "当前视频的：" + videoHeight + "_________" + videoWidth);
        if (videoHeight < 600) {
            videoHeight = 808;
        } else if (videoHeight > 600 && videoHeight < 800) {
            videoHeight = LayoutParams.MATCH_PARENT;
        }

        LayoutParams fram = new LayoutParams(LayoutParams.MATCH_PARENT, videoHeight);
        fram.gravity = Gravity.CENTER;
        mTextureView.setLayoutParams(fram);
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        //更新 右侧总进度
        total.setText(timeParse(mp.getDuration()));
        mp.start();

        seekBar.setMax((int) mediaPlayer.getDuration());

        //初次加载
        isPropared = true;

        // 创建一个线程
        thread = new Thread(new SeekBarThread());
        // 启动线程
        thread.start();
        changeVideoSize();
    }


    public static String timeParse(long duration) {
        String time = "";
        long minute = duration / 60000;
        long seconds = duration % 60000;
        long second = Math.round((float) seconds / 1000);
        if (minute < 10) {
            time += "0";
        }
        time += minute + ":";
        if (second < 10) {
            time += "0";
        }
        time += second;
        return time;
    }

    @Override
    public void onSeekComplete(MediaPlayer mp) {

        Log.e("TAA", "收到监听了：" + mediaPlayer.getCurrentPosition());
//        seekBar.setProgress((int) (mediaPlayer.getCurrentPosition()));
        //加载圈消失
        center_layout.setVisibility(GONE);

        hint();
    }

    public void mediaSeek(final int seekTo) {

//        if (!isPropared) {
//            return;
//        }
//        Toast.makeText(getContext(), "Seek啦："+seekTo, Toast.LENGTH_SHORT).show();


        center_layout.setVisibility(VISIBLE);

        final long nextSeek = mediaPlayer.getCurrentPosition() + seekTo;


        Log.e("TAA", "总进度：" + mediaPlayer.getDuration() + "_________" + nextSeek);
        if (mediaPlayer.getDuration() > 1000 && mediaPlayer.getDuration() < nextSeek) {
//            Log.e("TAA","检测快进：再seek"+mediaPlayer.getDuration()+"_______"+postion);
//
//            nextVideo();
//            return;
            ToastUtils.showToast(getContext(), "加载中，请稍候。");
//            Toast.makeText(getContext(), "加载中，请稍候。", Toast.LENGTH_SHORT).show();

        }


        ((Activity) getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seekTo((int) nextSeek);
                seekBar.setProgress((int) nextSeek);
                //设置当前进度
                currentTimer.setText(timeParse(nextSeek));
            }
        });

    }

    //暂停
    public void pause() {
        show();

        mediaPlayer.pause();
        pause.setVisibility(VISIBLE);
        showTimer = 0;
    }


    public void startSegmentsVideo(String[] urls, Context context) {

        try {
//            mediaPlayer.setDataSource("http://pl-ali.youku.com/playlist/m3u8?vid=XMjk1NzE0OTU2MA==&type=hd3&ups_client_netip=76be92aa&utid=+IBLE8bsJjoCAXa+kqq1cqWc&ccode=0502&psid=88d45ff0e779c192dcba1f861c7c9ece&duration=5465&expire=18000&ups_ts=1522832120&onOff=0&encr=0&ups_key=9f5a315e9e8c0d5002a58bcd44b5f5cb");
//            mediaPlayer.release();

//            mediaPlayer.stop();
//            mediaPlayer.release();
//            mediaPlayer.set
//            mediaPlayer.setsource
            //   mediaPlayer.setVideoChroma(MediaPlayer.VIDEOCHROMA_RGB565);
            mediaPlayer.reset();
//            mediaPlayer.setDisplay(surf);
            Log.e("TAA", "播放地址：多段拼接的第一段：" + urls[0]);
//            mediaPlayer.setDataSource(url.trim());
            mediaPlayer.setDataSegments(urls, context.getCacheDir().toString());
            mediaPlayer.setSurface(surf);
            mediaPlayer.prepare();


//            mediaPlayer.prepareAsync();
            //    mediaPlayer.start();
            ((Activity) getContext()).setVolumeControlStream(AudioManager.STREAM_MUSIC);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void startVideo(String url) {

        try {
//            mediaPlayer.setDataSource("http://pl-ali.youku.com/playlist/m3u8?vid=XMjk1NzE0OTU2MA==&type=hd3&ups_client_netip=76be92aa&utid=+IBLE8bsJjoCAXa+kqq1cqWc&ccode=0502&psid=88d45ff0e779c192dcba1f861c7c9ece&duration=5465&expire=18000&ups_ts=1522832120&onOff=0&encr=0&ups_key=9f5a315e9e8c0d5002a58bcd44b5f5cb");
//            mediaPlayer.release();

//            mediaPlayer.stop();
//            mediaPlayer.release();
//            mediaPlayer.set
//            mediaPlayer.setsource
            mediaPlayer.setVideoChroma(MediaPlayer.VIDEOCHROMA_RGB565);
            mediaPlayer.reset();
//            mediaPlayer.setDisplay(surf);
            Log.e("TAA", "播放地址：" + url);
            mediaPlayer.setDataSource(url.trim());
            mediaPlayer.setSurface(surf);
            mediaPlayer.prepare();


//            mediaPlayer.prepareAsync();
//            mediaPlayer.start();
            ((Activity) getContext()).setVolumeControlStream(AudioManager.STREAM_MUSIC);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void startSegmentsVideo(List<PlayBean.DataBean.StreamsBean.SegsBean> segs) {

        try {
            String[] urls = new String[segs.size()];

            for (int x = 0; x < segs.size(); x++) {
                urls[x] = segs.get(x).getUrl();
                Log.e("TAA", "监测分段：url:" + urls[x]);

            }
            HashMap<String, String> options = new HashMap<String, String>();
//            options.put("referer", "http://www.bilibili.com/");
//            options.put("user-Agent", "Mozilla/5.0 AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
//            mediaPlayer.setDataSource(urls[0],options);
            Log.e("TAA", "监测分段：单端的:" + urls[0]);

            mediaPlayer.setDataSegments(urls, getContext().getCacheDir().toString());
//            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            //    mediaPlayer.start();
            ((Activity) getContext()).setVolumeControlStream(AudioManager.STREAM_MUSIC);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private SurfaceTexture surfaceTexture;
    private Surface surf;
    private int postion = 0;

    public void initVideo(SurfaceTexture surface) {
        if (surf == null) {
            surfaceTexture = surface;
            surf = new Surface(surface);
            mediaPlayer.setSurface(surf);
        }


    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        Toast.makeText(getContext(), "视频出错，请联系管理员。", Toast.LENGTH_SHORT).show();
        ((Activity) getContext()).finish();
        return true;
    }

    public DefindeMideaController.onVideoOverLinstener getOnVideoOverLinstener() {
        return onVideoOverLinstener;
    }

    public void setOnVideoOverLinstener(DefindeMideaController.onVideoOverLinstener onVideoOverLinstener) {
        this.onVideoOverLinstener = onVideoOverLinstener;
    }

    private onVideoOverLinstener onVideoOverLinstener;

    public interface onVideoOverLinstener {
        public void onVideoOver(String playUrl);
    }

    String playurl = null;

    @Override
    public void onCompletion(MediaPlayer mp) {

        hint();

        if (TagUtils.list != null) {
            //那么就自动下一集

//            mediaPlayer.stop();
//            mediaPlayer.release();
            nextVideo();

            Log.e("TAA", "检测快进：再onCompletion");

        } else {
            //退出
            Toast.makeText(getContext(), "已播放完", Toast.LENGTH_SHORT).show();
            finish();
        }

    }


    public void nextVideo() {


        if (postion == 0) {
            postion = ((Activity) getContext()).getIntent().getIntExtra("postion", 0);
            postion += 1;
        } else {
            postion = postion + 1;
        }

        if (TagUtils.list != null && postion < TagUtils.list.size()) {
            JujiBean jujiBean = TagUtils.list.get(postion);

            if (jujiBean != null) {
                playurl = jujiBean.getUrl();
                if (onVideoOverLinstener != null) {
                    onVideoOverLinstener.onVideoOver(playurl);
                }
                setTitle("第" + (postion + 1) + "集");
                ToastUtils.showToast(getContext(), "正在加载第" + (postion + 1) + "集");
//                Toast.makeText(getContext(), "正在加载第" + (postion + 1) + "集", Toast.LENGTH_SHORT).show();
            }
//                                    videoPlayer.setVideoPath(jujiBean.getUrl());
//                                    videoPlayer.start();
        } else {
            Toast.makeText(getContext(), "已播放完", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    public void finish() {
        ((Activity) getContext()).finish();
    }


    // 自定义的线程
    private class SeekBarThread implements Runnable {

        @Override
        public void run() {
            while (mediaPlayer != null && seekBar != null && getContext() != null) {
                // 将SeekBar位置设置到当前播放位置
                ((Activity) getContext()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (seekBar != null && mediaPlayer != null && currentTimer != null && getContext() != null) {

                            try {
                                long current = mediaPlayer.getCurrentPosition();
                                seekBar.setProgress((int) current);
                                currentTimer.setText(timeParse(current));
                            } catch (Exception e) {
                                mediaPlayer = null;
                            }

                        }
                    }
                });

                try {
                    ((Activity) getContext()).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            // 每100毫秒更新一次位置
                            if (mediaPlayer != null && mediaPlayer.getCurrentPosition() > 360000&&tag.equals("0")) {
                                Toast.makeText(getContext(), "试看时间结束", Toast.LENGTH_SHORT).show();
                                finish();

                            }
                        }
                    });

                    Thread.sleep(800);
//                    Log.e("TAA","动着那");
//                    Log.e("TAA",mediaPlayer.getCurrentPosition()+"");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    public boolean onMediaKeyDwon(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME || keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {

            if (mediaPlayer.isPlaying()) {
                pause();
                pause.setVisibility(View.VISIBLE);

            } else {
                mediaPlayer.start();
                pause.setVisibility(View.GONE);
                hint();
            }

            return true;
        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            if (pause.getVisibility() == View.VISIBLE) {
                pause.setVisibility(View.GONE);
            }
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }

            if (!isShow) {
                show();
            }

            showTimer = 0;
            mediaSeek(-30000);
            return true;

        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {

            if (pause.getVisibility() == View.VISIBLE) {
                pause.setVisibility(View.GONE);
            }

            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }


            if (!isShow) {
                show();
            }
            showTimer = 0;
            mediaSeek(30000);
            return true;
        }


        return super.onKeyDown(keyCode, event);
    }

    private Thread showThread;


}
