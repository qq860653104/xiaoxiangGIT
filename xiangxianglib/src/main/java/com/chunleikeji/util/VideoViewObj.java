package com.chunleikeji.util;

import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.chunleikeji.VideoViewActivity;
import com.chunleikeji.xiangxianglib.R;
import com.pili.pldroid.player.PLOnCompletionListener;
import com.pili.pldroid.player.PLOnPreparedListener;
import com.pili.pldroid.player.PLOnSeekCompleteListener;
import com.pili.pldroid.player.widget.PLVideoView;

import java.text.SimpleDateFormat;
import java.util.TimeZone;


public class VideoViewObj {

    VideoViewActivity activity;
    PLVideoView videoView;
    Handler mHandler;

    boolean isPause = true;

    public void init(final VideoViewActivity activity) {
        this.activity = activity;
        this.videoView = activity.mVideoPlay;
        mHandler = new Handler();

//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                activity.mSeekbar.setMax((int) videoView.getDuration());
//                activity.mEndTime.setText(zhuanhuan(videoView.getDuration()));
//                activity.progressBar2.setVisibility(View.GONE);
//
//                startTimer();
//            }
//        });

//        videoView.setOnPreparedListener(new io.vov.vitamio.MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(io.vov.vitamio.MediaPlayer mp) {
//                activity.mSeekbar.setMax((int) videoView.getDuration());
//                activity.mEndTime.setText(zhuanhuan(videoView.getDuration()));
//                activity.progressBar2.setVisibility(View.GONE);
//                videoView.seekTo(activity.getIntent().getIntExtra("seek", 0));
//                startTimer();
//            }
//        });


        videoView.setOnPreparedListener(new PLOnPreparedListener() {
            @Override
            public void onPrepared(int i) {
                activity.mSeekbar.setMax((int) videoView.getDuration());
                activity.mEndTime.setText(zhuanhuan(videoView.getDuration()));
                activity.progressBar2.setVisibility(View.GONE);

                videoView.seekTo(activity.getIntent().getIntExtra("seek", 0));

                videoView.setOnSeekCompleteListener(new PLOnSeekCompleteListener() {
                    @Override
                    public void onSeekComplete() {
                        videoView.start();
                    }
                });

                startTimer();
            }
        });

        videoView.setOnCompletionListener(new PLOnCompletionListener() {
            @Override
            public void onCompletion() {
                if(StaticUtils.isStartVideoAd==1){
//                    endAd(activity);
                }else{
                    ToastUtils.showToast(activity,"视频已播放完");
                    activity.finish();
                }
            }
        });

//        videoView.setOnPreparedListener(new io.vov.vitamio.MediaPlayer.OnPreparedListener() {
//
//
//            @Override
//            public void onPrepared(io.vov.vitamio.MediaPlayer mp) {
//                activity.mSeekbar.setMax((int) videoView.getDuration());
//                activity.mEndTime.setText(zhuanhuan(videoView.getDuration()));
//                activity.progressBar2.setVisibility(View.GONE);
//
//                videoView.seekTo(activity.getIntent().getIntExtra("seek", 0));
//                videoView.setOnSeekCompleteListener(new io.vov.vitamio.MediaPlayer.OnSeekCompleteListener() {
//                    @Override
//                    public void onSeekComplete(io.vov.vitamio.MediaPlayer mp) {
//                        videoView.start();
//                    }
//                });
//
//                startTimer();
//            }
//        });
//        videoView.setOnCompletionListener(new io.vov.vitamio.MediaPlayer.OnCompletionListener() {
//
//
//            @Override
//            public void onCompletion(io.vov.vitamio.MediaPlayer mp) {
//                if(StaticUtils.isStartVideoAd==1){
//                    endAd(activity);
//                }else{
//                    ToastUtils.showToast(activity,"视频已播放完");
//                    activity.finish();
//                }
//            }
//        });

        show();

    }

//    private void endAd(final VideoViewActivity activity) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int j = 4; j > 0; j--) {
//
//                    if (!activity.isFinishing()) {
//
//                        final int finalJ = j;
//                        activity.runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                activity.mGg.setVisibility(View.VISIBLE);
//                                activity.mGgText.setText("广告："+finalJ + "秒后结束");
//                                Glide.with(activity)
//                                        .load(StaticUtils.endAd)
//                                        .error(R.drawable.defult_movie2)
//                                        .into(activity.mGgImg);
//                            }
//                        });
//                    }
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//
//                }
//
//                if (!activity.isFinishing()) {
//                    activity.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            activity.mGg.setVisibility(View.GONE);
//                            ToastUtils.showToast(activity,"视频已播放完");
//                            activity.finish();
//                        }
//                    });
//
//                }
//
//
//            }
//        }).start();
//    }

    public void startAd(final VideoViewActivity activity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 4; j > 0; j--) {

//                    if (!activity.isFinishing()) {
//
//                        final int finalJ = j;
//                        activity.runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//
//                                activity.mGgText.setText("广告："+finalJ + "秒后结束");
//                                if(finalJ==4){
//                                    activity.mGg.setVisibility(View.VISIBLE);
//                                    Glide.with(activity)
//                                            .load(StaticUtils.startAd)
//                                            .error(R.drawable.defult_movie2)
//                                            .into(activity.mGgImg);
//
//
//
//                                }
//
//                            }
//                        });
//                    }

                    if(j==1){
                        if (!activity.isFinishing()) {
                            activity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    String url = activity.getIntent().getStringExtra("url");
                                    videoView.setVideoPath(url);
                                    videoView.seekTo(activity.getIntent().getIntExtra("seek", 0));
                                    videoView.setOnSeekCompleteListener(new PLOnSeekCompleteListener() {
                                        @Override
                                        public void onSeekComplete() {
                                            videoView.start();
                                        }
                                    });

//                                    videoView.setOnSeekCompleteListener(new io.vov.vitamio.MediaPlayer.OnSeekCompleteListener() {
//                                        @Override
//                                        public void onSeekComplete(io.vov.vitamio.MediaPlayer mp) {
//                                            videoView.start();
//                                        }
//
//
//                                    });

                                    //  videoView.start();
                                    startTimer();

                                }
                            });

                        }
                    }


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
//                activity.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        activity.mGg.setVisibility(View.GONE);
//                    }
//                });



            }
        }).start();
    }


    public String zhuanhuan(long ms) {


        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String hms = formatter.format(ms);
        return hms;
    }

    private void startTimer() {


//        videoView.seton

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    while (true) {
                        Thread.sleep(1000);
                        activity.mSeekbar.setProgress((int) videoView.getCurrentPosition());
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                activity.mCurrentTime.setText(zhuanhuan(videoView.getCurrentPosition()) + "");
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();


    }


    /**
     * false 是隐藏
     * true 是显示
     */
    private boolean isShow;

    public void hint() {

        if (isShow) {
            Log.e("TAA", "执行了hint");
            activity.mLeftMenu.animate().translationY(-activity.mLeftMenu.getHeight() - 200).setDuration(300).start();
            activity.mCurrentTime.animate().translationY(-activity.mCurrentTime.getHeight() - 200).setDuration(300).start();
            activity.mBtnMenu.animate().translationY(activity.mBtnMenu.getHeight() * 2).setDuration(300).start();
            isShow = false;
        }


    }


    public void show() {


        if (!isShow) {
            activity.mLeftMenu.animate().translationY(1.0f).setDuration(150).start();
            activity.mCurrentTime.animate().translationY(1.0f).setDuration(150).start();
            activity.mBtnMenu.animate().translationY(1.0f).setDuration(150).start();
            isShow = true;
            mHandler.removeCallbacks(mRunnable);//取消待执行的消息
            mHandler.postDelayed(mRunnable, 3000/* delayMillis */);
        }


    }


    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            hint();
        }
    };
    Runnable btnRunnable = new Runnable() {
        @Override
        public void run() {
            activity.mCenterBtn.setVisibility(View.GONE);
        }
    };

    public void back() {

    }


    public void next() {

    }


    int currentNext, currentBack;
    boolean isback;

    public boolean onKeyDown(int keyCode, KeyEvent event) {


        if (keyCode == KeyEvent.KEYCODE_HOME || keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {

            if (videoView.isPlaying()) {
//                _showControlBar(3000);

                show();

                if (activity.mJindu.getVisibility() == View.VISIBLE) {

                    if (!isback) {
                        videoView.seekTo(currentNext);
                        currentNext = 0;
                    } else {
                        videoView.seekTo(videoView.getCurrentPosition() - currentBack);

                        currentBack = 0;
                    }
                    activity.mJindu.setVisibility(View.GONE);
                } else {
                    activity.isPause = 1;
                    pause();

                }

            } else {
//                _showControlBar(3000);
                show();
//                start();
                start();
            }

            return true;
        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
//            _showControlBar(3000);
            show();
            isback = true;
            if (activity.mJindu.getVisibility() == View.GONE) {
                activity.mJindu.setVisibility(View.VISIBLE);
            }

            if ((videoView.getCurrentPosition() - currentBack) >= 0) {
                currentBack += 30000;

            }

            if (!((videoView.getCurrentPosition() - currentBack) < 0)) {
                activity.mJindu.setText(formatDuring("快退至：", videoView.getCurrentPosition() - currentBack));
            } else {
                currentBack -= 30000;
            }
            return true;

        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
//            _showControlBar(3000);
            show();
            isback = false;
            currentBack = 0;

            if (currentNext >= videoView.getDuration()) {
                currentNext = (int) (videoView.getDuration() - 30000);
                return true;
            }

            if (currentNext < videoView.getCurrentPosition()) {
                currentNext = (int) (videoView.getCurrentPosition() + 30000);

            } else {
                if (activity.mJindu.getVisibility() == View.VISIBLE) {
                    currentNext += 30000;
                }
            }

            if (activity.mJindu.getVisibility() == View.GONE) {
                activity.mJindu.setVisibility(View.VISIBLE);
            }

            activity.mJindu.setText(formatDuring("快进至：", currentNext));

            return true;
        }

        return true;

    }


    public static String formatDuring(String tag, long mss) {
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;

        hours = hours * 60;
        minutes += hours;
        String end = "8";

        if (seconds > 10) {
            end = "";
        }

        return tag + minutes + ":" + seconds + end;
    }


    private void start() {

        mHandler.removeCallbacks(btnRunnable);//取消待执行的消息
        mHandler.postDelayed(btnRunnable, 1500/* delayMillis */);
        activity.mCenterBtn.setVisibility(View.VISIBLE);
        activity.mCenterBtn.setImageResource(R.drawable.pause_btn);
        activity.mIvPlay.setImageResource(R.drawable.hua_btn_pause);
        videoView.start();

    }


    private void pause() {
        mHandler.removeCallbacks(btnRunnable);//取消待执行的消息
        mHandler.postDelayed(btnRunnable, 1500/* delayMillis */);
        activity.mCenterBtn.setVisibility(View.VISIBLE);
        activity.mCenterBtn.setImageResource(R.drawable.start_btn);
        activity.mIvPlay.setImageResource(R.drawable.hua_btn_play);
        videoView.pause();

    }


}
