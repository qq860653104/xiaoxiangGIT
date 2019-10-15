package com.chunleikeji.playvideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.transition.Transition;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chunleikeji.bean.JujiBean;
import com.chunleikeji.bean.PlayBean;
import com.chunleikeji.bean.SwitchVideoModel;
import com.chunleikeji.tag.TagUtils;
import com.chunleikeji.util.OkHttpUtils;
import com.chunleikeji.util.SPUtils;
import com.chunleikeji.xiangxianglib.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;



public class VideoActivity extends Activity implements MyMediaController.OnItemClickListener {

    public final static String IMG_TRANSITION = "IMG_TRANSITION";
    public final static String TRANSITION = "TRANSITION";


    private boolean isTransition;

    private Transition transition;

    private FrameLayout hold_progress;
    private VideoView videoPlayer;
    private ProgressDialog mPD;

    private LinearLayout pause;
//    private TextView progress_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video);
        Vitamio.isInitialized(this);

        TextView holdText =  findViewById(R.id.hold_text);
        holdText.setText(getIntent().getStringExtra("title"));
//        progress_text = findViewById(R.id.progress_text);
        pause = findViewById(R.id.pause);
        videoPlayer = findViewById(R.id.surface_view);
//        ButterKnife.bind(this);
        isTransition = getIntent().getBooleanExtra(TRANSITION, false);

//        String url  = "http://pl-ali.youku.com/playlist/m3u8?vid=XMjc3MDA1NjY5Mg%3D%3D&type=mp4&ups_client_netip=2f68ab10&utid=WEAxE%2BRvh0ICAS9oqxBFam%2FV&ccode=0502&psid=bc0017c667bd11c967b1ff1e697e6e32&duration=5222&expire=18000&ups_ts=1521111640&onOff=0&encr=0&ups_key=ec3672c3d1d7731f5a8a89e775af9ffb";
//
//        videoPlayer.setVideoPath(url);
//        videoPlayer.setVideoChroma(MediaPlayer.VIDEOCHROMA_RGB565);
        myMediaController = new MyMediaController(this, videoPlayer, this);
        myMediaController.setOnItemClickListener(this);
        videoPlayer.setMediaController(myMediaController);
//        videoPlayer.setVideoQuality(MediaPlayer.VIDEOQUALITY_MEDIUM);//画质 标清
//        videoPlayer.setBufferSize(10240);
//        videoPlayer.setVideoChroma(MediaPlayer.VIDEOCHROMA_RGB565);
//        videoPlayer.start();
//        findViewById(R.id.hold_progress).setVisibility(View.GONE);

        init();
//        myMediaController.setTitle("aaaa1");
//        myMediaController.show(100000);
//        View view = myMediaController.makeControllerView();
//        view.setVisibility(View.VISIBLE);
    }

    private String getVideoUrl = "http://39.106.60.208/test/test4.php?url=";
    MyMediaController myMediaController;

    public String getPlayurl() {
        return playurl;
    }

    public void setPlayurl(String playurl) {
        this.playurl = playurl;
    }

    String playurl = null;
    private void init() {

        hold_progress = findViewById(R.id.hold_progress);
        if(playurl==null) {
            playurl = getIntent().getStringExtra("playurl");
        }
        final String title = getIntent().getStringExtra("title");

        myMediaController = new MyMediaController(this, videoPlayer, this);

        if (playurl.indexOf(".mp4") > 0||playurl.indexOf(".mkv") > 0||playurl.indexOf(".m3u8") > 0||playurl.indexOf(".flv") > 0) {//加载本地视频


            videoPlayer.setVideoPath(playurl.trim());
//            videoPlayer.setVideoChroma(MediaPlayer.VIDEOCHROMA_RGB565);
            videoPlayer.setMediaController(myMediaController);
//            videoPlayer.setVideoQuality(MediaPlayer.VIDEOQUALITY_MEDIUM);//画质 标清

//            videoPlayer.setBufferSize(1024 * 1024);
//            videoPlayer.setVideoChroma(MediaPlayer.VIDEOCHROMA_RGB565);
            hold_progress.setVisibility(View.GONE);

            videoPlayer.start();

            //播放完成后
            videoPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                    if(TagUtils.list!=null){
                        //那么就自动下一集

                        if(postion==0) {
                            postion = getIntent().getIntExtra("postion", 0);
                            postion +=1;
                        }else{
                            postion = postion+1;
                        }

                        JujiBean jujiBean = TagUtils.list.get(postion);
                        if(jujiBean!=null) {
                            Log.e("TAA","剧集啊啊啊："+jujiBean.getUrl()+"___________"+postion);
                            setPlayurl(jujiBean.getUrl().trim());
                            init();
                            Toast.makeText(VideoActivity.this, "正在加载第"+(postion+1)+"集", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(VideoActivity.this, "已播放完", Toast.LENGTH_SHORT).show();
                            finish();
                        }
//                                    videoPlayer.setVideoPath(jujiBean.getUrl());
//                                    videoPlayer.start();

                    }else{
                        //退出
                        Toast.makeText(VideoActivity.this, "已播放完", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                }
            });
            videoPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    Log.e("TAA","出现了错误？？？");
                    videoPlayer.setVideoPath(playurl.trim());
                    videoPlayer.resume();
                    videoPlayer.start();
                    return true;
                }
            });

            long current =  SPUtils.getSharedlongData(VideoActivity.this,playurl);
            if(current!=0&&videoPlayer!=null&&playurl!=null){
                videoPlayer.seekTo(current);
            }

        } else {
            //小孩的解析
//               xhdjx(title, list);
            //点亮解析
            dljx(playurl, title);
        }

        //String url = "http://7xse1z.com1.z0.glb.clouddn.com/1491813192";
        //需要路径的
        //videoPlayer.setUp(url, true, new File(FileUtils.getPath()), "");

        //借用了jjdxm_ijkplayer的URL


//        videoPlayer.setUp(list, true, "测试视频");

        //增加封面
//        ImageView imageView = new ImageView(this);
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setImageResource(R.mipmap.aab);
//        videoPlayer.setThumbImageView(imageView);
        //增加title
//        videoPlayer.getTitleTextView().setVisibility(View.VISIBLE);

        //设置旋转
//        orientationUtils = new OrientationUtils(this, videoPlayer);

        //是否可以滑动调整
//        videoPlayer.setIsTouchWiget(true);
//        videoPlayer.setIsTouchWigetFull(true);
//        videoPlayer.startWindowFullscreen(this,true,true);
        //设置返回按键功能
//        videoPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });

//        videoPlayer.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//                Log.e("TAA","获取key："+keyEvent.getAction());
//
//                return false;
//            }
//        });


    }

    private boolean isError;

    private void xhdjx(String title, String videoUrl) {
        String url = "http://api.zzshj.com/aps.php?uid=800007185&token=WxP5vpSTErZO3MhoqXF2&url=" + videoUrl;
        SwitchVideoModel switchVideoModel = new SwitchVideoModel("测试", url,null);
//        list.add(switchVideoModel);
//        videoPlayer.setUp(list, true, title);
//        videoPlayer.getTitleTextView().setVisibility(View.VISIBLE);
//

//
//        videoPlayer.setIsTouchWiget(true);
//        videoPlayer.setIsTouchWigetFull(true);
//        initTransition();
        hold_progress.setVisibility(View.GONE);
        videoPlayer.requestFocus();
        videoPlayer.setVideoPath(url);
        myMediaController = new MyMediaController(VideoActivity.this, videoPlayer, VideoActivity.this);
        myMediaController.setOnItemClickListener(VideoActivity.this);
        videoPlayer.setMediaController(myMediaController);
        videoPlayer.start();
        Toast.makeText(this, "已自动切换至二号线路", Toast.LENGTH_SHORT).show();
        isError = true;

        videoPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {

                Toast.makeText(VideoActivity.this, "数据出错了！", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            }
        });
    }

    private int postion = 0 ;
    private void dljx(final String playurl, final String title) {
        String url = getVideoUrl + playurl;
        Log.e("TAA", "BaseUrl----------------------------------------:" + url);
        OkHttpUtils.getOkHttp(this, url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String body = response.body().string();
                Log.e("TAA", "BODY:" + body);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        PlayBean playBean = new Gson().fromJson(body, PlayBean.class);

                        if (playBean.getData() != null) {
                            List<PlayBean.DataBean.StreamsBean> streams = playBean.getData().getStreams();
                            final List<SwitchVideoModel> list = new ArrayList<>();
                            for (int x = 0; x < streams.size(); x++) {
                                PlayBean.DataBean.StreamsBean streamsBean = streams.get(x);
                                PlayBean.DataBean.StreamsBean.SegsBean segsBean = streamsBean.getSegs().get(0);

                                Log.e("TAA", "BaseUrl----------------------------------------:" + streamsBean.getSubType());
                                SwitchVideoModel switchVideoModel = new SwitchVideoModel(streamsBean.getQuality(), segsBean.getUrl(),null);

                                //如果是M3U8  或者 MP4 并且是整段的那么 就添加
                                if("MP4".equals(streamsBean.getType()) &&"M3U8".equals(streamsBean.getType()) &&streamsBean.getSegs().size() == 1){
                                    list.add( switchVideoModel);

                                }
                                //如果是MP4 并且是整段的  那么则依次 从 高 到低选择 视频
                                if ("MP4".equals(streamsBean.getSubType()) && streamsBean.getSegs().size() == 1) {
                                    if("SUPERHD".equals(streamsBean.getQuality())) {
                                        list.add(0, switchVideoModel);
                                        break;
                                    }else if ("HD".equals(streamsBean.getQuality())){
                                        list.add(0, switchVideoModel);
                                        break;
                                    }
                                    //如果是M3U8 并且是整段的  那么则依次 从 高 到低选择 视频
                                }else if("M3U8".equals(streamsBean.getType()) && streamsBean.getSegs().size() == 1){

                                    //如果是M3U8的 那么  符合标准，从 超清 到 标清 依次 选择
                                    if("SUPERHD".equals(streamsBean.getQuality())) {
                                        list.add(0, switchVideoModel);
                                        break;
                                    }else if ("HD".equals(streamsBean.getQuality())){
                                        list.add(0, switchVideoModel);
                                        break;
                                    }
                                }
                                list.add(switchVideoModel);

                            }
                            Log.e("TAA", "即将播放：:" + list.get(0).getUrl());


                            hold_progress.setVisibility(View.GONE);
                            Vitamio.isInitialized(VideoActivity.this);

                            videoPlayer.requestFocus();



                            if(playurl.indexOf("bilibili") > 0){
                                HashMap<String, String> options = new HashMap<String, String>();
                                options.put("referer", "http://www.bilibili.com/");
                                options.put("user-Agent", "Mozilla/5.0 AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
//                                videoPlayer
//                                videoPlayer
//                                videoPlayer.set(list.get(0).getUrl(),options);

                            }else{
                                videoPlayer.setVideoPath(list.get(0).getUrl());

                            }
//                        videoPlayer.setVideoChroma(MediaPlayer.VIDEOCHROMA_RGB565);
                            myMediaController = new MyMediaController(VideoActivity.this, videoPlayer, VideoActivity.this);
                            myMediaController.setOnItemClickListener(VideoActivity.this);
                            videoPlayer.setMediaController(myMediaController);
//                        videoPlayer.setVideoQuality(MediaPlayer.VIDEOQUALITY_MEDIUM);//画质 标清
                            videoPlayer.start();
                            videoPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                                @Override
                                public boolean onError(MediaPlayer mp, int what, int extra) {
                                    Log.e("TAA", "已启动错误处理");
                                    if (!isError) {
                                        xhdjx(null, list.get(0).getUrl());
                                    } else {
                                        Toast.makeText(VideoActivity.this, "数据出错了！", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                    return true;
                                }
                            });
                            videoPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                @Override
                                public void onPrepared(MediaPlayer mp) {
                                    long current =  SPUtils.getSharedlongData(VideoActivity.this,playurl);

                                    if(current!=0&&videoPlayer!=null&&playurl!=null){
                                        videoPlayer.seekTo(current);
                                    }
                                }
                            });
                        } else {
                            String playurl = getIntent().getStringExtra("playurl");
                            xhdjx(null, playurl);
                        }


                        //播放完成后
                        videoPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {

                                if(TagUtils.list!=null){
                                    //那么就自动下一集

                                    if(postion==0) {
                                        postion = getIntent().getIntExtra("postion", 0);
                                        postion +=1;
                                    }else{
                                        postion = postion+1;
                                    }

                                    JujiBean jujiBean = TagUtils.list.get(postion);
                                    if(jujiBean!=null) {
                                        setPlayurl(jujiBean.getUrl());
                                        init();
                                        Toast.makeText(VideoActivity.this, "正在加载第"+(postion+1)+"集", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(VideoActivity.this, "已播放完", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
//                                    videoPlayer.setVideoPath(jujiBean.getUrl());
//                                    videoPlayer.start();

                                }else{
                                    //退出
                                    Toast.makeText(VideoActivity.this, "已播放完", Toast.LENGTH_SHORT).show();
                                    finish();
                                }

                            }
                        });

                    }
                });
            }
        });
        videoPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                Log.e("TAA",percent+"");
                if(percent>90){
                    if(pause.getVisibility()==View.VISIBLE) {
                        pause.setVisibility(View.GONE);
                    }

                }
            }
        });




//        myMediaController.setOnShownListener(new MediaController.OnShownListener() {
//            @Override
//            public void onShown() {
//
//            }
//        });


    }


    @Override
    protected void onPause() {
        super.onPause();
//        videoPlayer.onVideoPause();
    }

    @Override
    protected void onResume() {
        super.onResume();


//        videoPlayer.onVideoResume();
//        videoPlayer.setDismissControlTime(100);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onDestroy() {

        super.onDestroy();

//        if (orientationUtils != null)
//            orientationUtils.releaseListener();
    }



    @Override
    public void onBackPressed() {
        if(videoPlayer!=null&&playurl!=null){
            SPUtils.setSharedlongData(this,playurl, videoPlayer.getCurrentPosition());
        }

        if (isTransition && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            super.onBackPressed();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                    overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
                }
            }, 500);
        }
    }


    private void initTransition() {
        if (isTransition && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            postponeEnterTransition();
            ViewCompat.setTransitionName(videoPlayer, IMG_TRANSITION);

            startPostponedEnterTransition();
        } else {
//            videoPlayer.startPlayLogic();
        }
    }

    public static String timeParse(long duration) {
        String time = "" ;
        long minute = duration / 60000 ;
        long seconds = duration % 60000 ;
        long second = Math.round((float)seconds/1000) ;
        if( minute < 10 ){
            time += "0" ;
        }
        time += minute+":" ;
        if( second < 10 ){
            time += "0" ;
        }
        time += second ;
        return time ;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME || keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {

            if (videoPlayer.isPlaying()) {
                videoPlayer.pause();
                pause.setVisibility(View.VISIBLE);
                String timeParse = timeParse(videoPlayer.getCurrentPosition());

//                progress_text.setText(timeParse);

            } else {
                videoPlayer.start();
                pause.setVisibility(View.GONE);
            }

            return true;
        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
//            videoPlayer.uiStopSeek(-60000);

//            if (videoPlayer.isPlaying()) {
//                videoPlayer.pause();
            if(pause.getVisibility()==View.VISIBLE) {
                pause.setVisibility(View.GONE);
            }
//            }
            videoPlayer.seekTo(videoPlayer.getCurrentPosition() - 30000);
            String timeParse = timeParse(videoPlayer.getCurrentPosition());

//            progress_text.setText(timeParse);
            return true;

        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
//            videoPlayer.uiStopSeek(60000);

            if(pause.getVisibility()==View.VISIBLE) {
                pause.setVisibility(View.GONE);
            }
            videoPlayer.seekTo(videoPlayer.getCurrentPosition() + 30000);
//            videoPlayer.setTimedTextShown(true);
//            videoPlayer.showContextMenu();
//            myMediaController.show();
//            myMediaController.show(50000);
//            View view = myMediaController.makeControllerView();
//            view.setVisibility(View.VISIBLE);
            String timeParse = timeParse(videoPlayer.getCurrentPosition());
//            progress_text.setText(timeParse);

//            videoPlayer.hideAllWidget();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void itemClick(View view) {

    }



}
