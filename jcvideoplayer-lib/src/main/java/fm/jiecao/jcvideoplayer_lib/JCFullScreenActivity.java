package fm.jiecao.jcvideoplayer_lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.lang.reflect.Constructor;

/**
 * <p>全屏的activity</p>
 * <p>fullscreen activity</p>
 * Created by Nathen
 * On 2015/12/01 11:17
 */
public class JCFullScreenActivity extends Activity {
    protected float mDownX;
    protected float mDownY;

    static void startActivityFromNormal(Context context, int state, String url, Class videoPlayClass, Object... obj) {
        CURRENT_STATE = state;
        DIRECT_FULLSCREEN = false;
        URL = url;
        VIDEO_PLAYER_CLASS = videoPlayClass;
        OBJECTS = obj;
        Intent intent = new Intent(context, JCFullScreenActivity.class);
        context.startActivity(intent);
    }

    public static String htmlUrlA;

    public static void setUrlAndClass(Class wanNengPlayer, String htmlUrl) {
        wanNengPlayerA = wanNengPlayer;
        htmlUrlA = htmlUrl;

    }

    /**
     * <p>直接进入全屏播放</p>
     * <p>Full screen play video derictly</p>
     *
     * @param context        context
     * @param url            video mUrl
     * @param videoPlayClass your videoplayer extends JCAbstraceVideoPlayer
     * @param obj            custom param
     */
    public static void startActivity(Context context, String url, Class videoPlayClass, Object... obj) {
        CURRENT_STATE = JCVideoPlayer.CURRENT_STATE_NORMAL;
        URL = url;
        DIRECT_FULLSCREEN = true;
        VIDEO_PLAYER_CLASS = videoPlayClass;
        OBJECTS = obj;
        Intent intent = new Intent(context, JCFullScreenActivity.class);
        context.startActivity(intent);
    }

    public static Class wanNengPlayerA;


    private JCVideoPlayer mJcVideoPlayer;
    /**
     * 刚启动全屏时的播放状态
     */
    static int CURRENT_STATE = -1;
    public static String URL;
    static boolean DIRECT_FULLSCREEN = false;//this is should be in videoplayer
    static Class VIDEO_PLAYER_CLASS;
    static Object[] OBJECTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        View decor = this.getWindow().getDecorView();
//        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        try {
            Constructor<JCVideoPlayerStandard> constructor = VIDEO_PLAYER_CLASS.getConstructor(Context.class);
            mJcVideoPlayer = constructor.newInstance(this);
            setContentView(mJcVideoPlayer);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mJcVideoPlayer.mIfCurrentIsFullscreen = true;
        mJcVideoPlayer.mIfFullscreenIsDirectly = DIRECT_FULLSCREEN;
        mJcVideoPlayer.setUp(URL, OBJECTS);
        mJcVideoPlayer.setStateAndUi(CURRENT_STATE);
        mJcVideoPlayer.addTextureView();
        if (mJcVideoPlayer.mIfFullscreenIsDirectly) {
            mJcVideoPlayer.startButton.performClick();
        } else {
            JCVideoPlayer.IF_RELEASE_WHEN_ON_PAUSE = true;
            JCMediaManager.instance().listener = mJcVideoPlayer;
            if (CURRENT_STATE == JCVideoPlayer.CURRENT_STATE_PAUSE) {
                JCMediaManager.instance().mediaPlayer.seekTo(JCMediaManager.instance().mediaPlayer.getCurrentPosition());
            }
        }

//        JCMediaManager.instance().listener = new JCMediaManager.JCMediaPlayerListener() {
//            @Override
//            public void onPrepared() {
//
//            }
//
//            @Override
//            public void onAutoCompletion() {
//
//            }
//
//            @Override
//            public void onCompletion() {
//
//            }
//
//            @Override
//            public void onBufferingUpdate(int percent) {
//
//            }
//
//            @Override
//            public void onSeekComplete() {
//
//            }
//
//            @Override
//            public void onError(int what, int extra) {
//                Toast.makeText(JCFullScreenActivity.this, "播放错误拦截了", Toast.LENGTH_SHORT).show();
//                //去解析界面 进行再次解析
//                Intent intent  =  new Intent(JCFullScreenActivity.this,wanNengPlayerA);
//                intent.putExtra("playurl",htmlUrlA);
//                intent.putExtra("tag","1");
//                intent.putExtra("errorurl",URL+"");
//                startActivity(intent);
//                startActivity(intent);
//                finish();
//            }
//
//            @Override
//            public void onInfo(int what, int extra) {
//                Toast.makeText(JCFullScreenActivity.this, "onInfo", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onVideoSizeChanged() {
//
//            }
//
//            @Override
//            public void onBackFullscreen() {
//
//            }
//        };

        JCMediaManager.instance().mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(JCFullScreenActivity.this, "资源已失效", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
                //去解析界面 进行再次解析
//                Intent intent = new Intent(JCFullScreenActivity.this, wanNengPlayerA);
//                intent.putExtra("playurl", htmlUrlA);
//                intent.putExtra("tag", "1");
//                intent.putExtra("errorurl", URL + "");
//                startActivity(intent);
//                startActivity(intent);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        mJcVideoPlayer.backFullscreen();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
        finish();
    }
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_DPAD_DOWN://按向下键
//
//                Toast.makeText(this, "遥控按向下键", Toast.LENGTH_LONG).show();
//
//                break;
//            case KeyEvent.KEYCODE_DPAD_UP:// 按向上键
//
//                Toast.makeText(this, "遥控按向上键", Toast.LENGTH_LONG).show();
//                break;
//            case KeyEvent.KEYCODE_DPAD_LEFT://按向左键
//
//                Toast.makeText(this, "遥控按向左键", Toast.LENGTH_LONG).show();
//                break;
//            case KeyEvent.KEYCODE_DPAD_RIGHT://按向右键
//                mJcVideoPlayer.startProgressTimer();
//                mJcVideoPlayer.showProgressDialog(100);
//                mJcVideoPlayer.mDownPosition = mJcVideoPlayer.getCurrentPositionWhenPlaying();
//                if (mJcVideoPlayer.JC_BURIED_POINT != null && JCMediaManager.instance().listener == this) {
//                    mJcVideoPlayer.JC_BURIED_POINT.onTouchScreenSeekPosition(mJcVideoPlayer.mUrl, mJcVideoPlayer.mObjects);
//                }
//
//                ViewParent vpdown = (ViewParent)getParent();
//                while (vpdown != null) {
//                    vpdown.requestDisallowInterceptTouchEvent(true);
//                    vpdown = vpdown.getParent();
//                }
//                break;
//
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }


    public static JCBuriedPointStandard jcBuriedPointStandard = new JCBuriedPointStandard() {
        @Override
        public void onClickStartThumb(String url, Object... objects) {
            Log.i("Buried_Point1：", "onClickStartThumb" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onClickBlank(String url, Object... objects) {
            Log.i("Buried_Point2：", "onClickBlank" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onClickBlankFullscreen(String url, Object... objects) {
            Log.i("Buried_Point3：", "onClickBlankFullscreen" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onClickStartIcon(String url, Object... objects) {
            Log.i("Buried_Point4：", "onClickStartIcon" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onClickStartError(String url, Object... objects) {
            Log.i("Buried_Point5：", "onClickStartError" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onClickStop(String url, Object... objects) {
            Log.i("Buried_Point6：", "onClickStop" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onClickStopFullscreen(String url, Object... objects) {
            Log.i("Buried_Point7：", "onClickStopFullscreen" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onClickResume(String url, Object... objects) {
            Log.i("Buried_Point8：", "onClickResume" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onClickResumeFullscreen(String url, Object... objects) {
            Log.i("Buried_Point9：", "onClickResumeFullscreen" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onClickSeekbar(String url, Object... objects) {
            Log.i("Buried_Point10：", "onClickSeekbar" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onClickSeekbarFullscreen(String url, Object... objects) {
            Log.i("Buried_Point11：", "onClickSeekbarFullscreen" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onAutoComplete(String url, Object... objects) {
            Log.i("Buried_Point12：", "onAutoComplete" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onAutoCompleteFullscreen(String url, Object... objects) {
            Log.i("Buried_Point13：", "onAutoCompleteFullscreen" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onEnterFullscreen(String url, Object... objects) {
            Log.i("Buried_Point14：", "onEnterFullscreen" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onQuitFullscreen(String url, Object... objects) {
            Log.i("Buried_Point15：", "onQuitFullscreen" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onTouchScreenSeekVolume(String url, Object... objects) {
            Log.i("Buried_Point16：", "onTouchScreenSeekVolume" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }

        @Override
        public void onTouchScreenSeekPosition(String url, Object... objects) {
            Log.i("Buried_Point17：", "onTouchScreenSeekVolume" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " mUrl is : " + url);
        }
    };


}
