package com.chunleikeji.playvideo;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.chunleikeji.xiangxianglib.R;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


/**
 * Created by 鹤 on 2015/10/29.
 */
public class MyMediaController extends MediaController {

    private static final int HIDEFRAM = 0;
    private static final int SHOW_PROGRESS = 2;

    //    private GestureDetector mGestureDetector;
    private LinearLayout mediacontroller_quality_ll; //画面质量1
    private TextView textViewQuality1; //画面质量1
    private TextView textViewQuality2; //画面质量2
    private TextView textViewQuality3; //画面质量3

    private String quality1 = ""; //画面质量1
    private String quality2 = ""; //画面质量2
    private String quality3 = ""; //画面质量3

    private VideoView videoView;
    private Activity activity;
    private Context context;
    private int controllerWidth = 0;//设置mediaController高度为了使横屏时top显示在屏幕顶端

    private View mVolumeBrightnessLayout;
    private ImageView mOperationBg;
    private TextView mOperationTv;
    private AudioManager mAudioManager;

    private int mLayout = VideoView.VIDEO_LAYOUT_ZOOM;

    private SeekBar progress;
    private boolean mDragging;
    private MediaPlayerControl player;
    //最大声音
    private int mMaxVolume;
    // 当前声音
    private int mVolume = -1;
    //当前亮度
    private float mBrightness = -1f;

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void itemClick(View view);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    //返回监听
    private View.OnClickListener backListener = new View.OnClickListener() {
        public void onClick(View v) {

            if (v.getId() == R.id.mediacontroller_quality1) {


                quality1 = textViewQuality1.getText().toString().trim();
                if (mediacontroller_quality_ll.getVisibility() == View.VISIBLE) {
                    mediacontroller_quality_ll.setVisibility(View.GONE);
                } else {
                    mediacontroller_quality_ll.setVisibility(View.VISIBLE);
                    show(6000);
                }
//                    qualityChange(v);
            }
            if (v.getId() == R.id.mediacontroller_quality2) {

                quality2 = textViewQuality2.getText().toString().trim();
                mediacontroller_quality_ll.setVisibility(View.GONE);
                qualityChange(v);
            }
            if (v.getId() == R.id.mediacontroller_quality3) {
                quality3 = textViewQuality3.getText().toString().trim();
                mediacontroller_quality_ll.setVisibility(View.GONE);
                qualityChange(v);
            }
        }
    };

    private SeekBar.OnSeekBarChangeListener seekListener = new SeekBar.OnSeekBarChangeListener() {
        public void onStartTrackingTouch(SeekBar bar) {

        }

        public void onProgressChanged(SeekBar bar, int progress, boolean fromuser) {

        }

        public void onStopTrackingTouch(SeekBar bar) {

        }
    };


    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            long pos;
            switch (msg.what) {
                case HIDEFRAM:
                    mVolumeBrightnessLayout.setVisibility(View.GONE);
                    mOperationTv.setVisibility(View.GONE);
                    break;
            }
        }
    };


    //videoview 用于对视频进行控制的等，activity为了退出
    public MyMediaController(Context context, VideoView videoView, Activity activity) {
        super(context);
        this.context = context;
        this.videoView = videoView;
        this.activity = activity;
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        controllerWidth = wm.getDefaultDisplay().getWidth();
//        mGestureDetector = new GestureDetector(context, new MyGestureListener());
    }

    public void setTitle(String text) {
        if (title != null) {
            title.setText(text);
        }
    }

    private TextView title;

    @Override
    protected View makeControllerView() {
        View v = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(getResources().getIdentifier("mymediacontroller", "layout", getContext().getPackageName()), this);
        v.setMinimumHeight(controllerWidth);
        //TOP
//        img_back = (ImageButton) v.findViewById(getResources().getIdentifier("mediacontroller_top_back", "id", context.getPackageName()));
//        img_Battery = (ImageView) v.findViewById(getResources().getIdentifier("mediacontroller_imgBattery", "id", context.getPackageName()));
//        img_back.setOnClickListener(backListener);
//        textViewBattery = (TextView)v.findViewById(getResources().getIdentifier("mediacontroller_Battery", "id", context.getPackageName()));
//        textViewTime = (TextView)v.findViewById(getResources().getIdentifier("mediacontroller_time", "id", context.getPackageName()));

        mediacontroller_quality_ll = (LinearLayout) v.findViewById(R.id.mediacontroller_quality_ll);
        title = (TextView) v.findViewById(R.id.file_name);

        textViewQuality1 = (TextView) v.findViewById(R.id.mediacontroller_quality1);
        textViewQuality1.setClickable(true);
        textViewQuality1.setOnClickListener(backListener);

        textViewQuality2 = (TextView) v.findViewById(R.id.mediacontroller_quality2);
        textViewQuality2.setClickable(true);
        textViewQuality2.setOnClickListener(backListener);

        textViewQuality3 = (TextView) v.findViewById(R.id.mediacontroller_quality3);
        textViewQuality3.setClickable(true);
        textViewQuality3.setOnClickListener(backListener);

        progress = (SeekBar) v.findViewById(R.id.mediacontroller_seekbar);
        progress.setOnSeekBarChangeListener(seekListener);
        //mid
        mVolumeBrightnessLayout = (RelativeLayout) v.findViewById(R.id.operation_volume_brightness);
        mOperationBg = (ImageView) v.findViewById(R.id.operation_bg);
        mOperationTv = (TextView) v.findViewById(R.id.operation_tv);
        mOperationTv.setVisibility(View.GONE);
        mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        mMaxVolume = mAudioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        return v;

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        System.out.println("MYApp-MyMediaController-dispatchKeyEvent");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        if (mGestureDetector.onTouchEvent(event)) return true;
//        // 处理手势结束
//        switch (event.getAction() & MotionEvent.ACTION_MASK) {
//            case MotionEvent.ACTION_UP:
//                endGesture();
//                break;
//        }
        return super.onTouchEvent(event);
    }


    //横向滑动改变进度
    public void onSeekChange(float v) {

        if (videoView.isPlaying()) {

            long currentPosition = videoView.getCurrentPosition();
            long duration = videoView.getDuration();
            long positon = (long) (currentPosition - ((v * duration) / 10));
//        Log.d("", "--------currentPosition-------" + currentPosition);
//        Log.d("", "--------duration-------" + duration);
//        Log.d("", "--------positon-------" + positon);
//        Log.d("", "--------v-------" + v);
            if (positon > duration) {
                videoView.seekTo(duration);
            } else if (positon < 0) {
                videoView.seekTo(0);
            } else {
                videoView.seekTo(positon);
            }

        }
    }


    //隐藏/显示
    private void toggleMediaControlsVisiblity() {
        if (isShowing()) {
            hide();
        } else {
            show();
        }
    }

    //播放与暂停
    private void playOrPause() {
        if (videoView != null)
            if (videoView.isPlaying()) {
                videoView.pause();
            } else {
                videoView.start();
            }
    }


    private void qualityChange(View view) {

        if (view.getId() == R.id.mediacontroller_quality2) {

            textViewQuality1.setText(quality2);
            textViewQuality2.setText(quality1);
        }
        if (view.getId() == R.id.mediacontroller_quality3) {


            textViewQuality1.setText(quality3);
            textViewQuality3.setText(quality1);
        }

        change();
    }

    private void change() {

        long currentPosition = videoView.getCurrentPosition();

        String str = textViewQuality1.getText().toString().trim();
        if (str.equals("流畅")) {
            Toast.makeText(activity, "流畅", Toast.LENGTH_LONG).show();
            Log.e("", "---------------------流畅----------");

            videoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_LOW);//画质 流畅

        } else if (str.equals("标清")) {
            Toast.makeText(activity, "标清", Toast.LENGTH_LONG).show();
            Log.e("", "---------------------标清----------");

            videoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_MEDIUM);//画质 标清


        } else if (str.equals("高清")) {
            Toast.makeText(activity, "高清", Toast.LENGTH_LONG).show();
            Log.e("", "---------------------高清----------");

            videoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//画质 高清


        }

        videoView.resume();

    }

    public boolean isHede() {
        return isHede;
    }

    public void setHede(boolean hede) {
        isHede = hede;
    }

    private boolean isHede;

    @Override
    public void hide() {
        if (!videoView.isPlaying()) {
            super.hide();
        }
    }
}
