package zhihu.iptv.jiayin.xiaoxiangketang;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;

import com.chunleikeji.login.Login;
import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.NetWorkUtils;
import com.chunleikeji.util.StaticUtils;
import com.chunleikeji.view.TvButtom;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;


public class SplishActivity extends Activity {


    private String checkUrl = BaseUrl.BASE + "regiestsin";

    private EditText shouquan;

    private TvButtom tvButtom;
    VideoView videoview;
    ImageView ivImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splish);

// 测试友盟是否连接成功
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        if (StaticUtils.isFirst == 1 && !StaticUtils.isHome) {
            Log.e("TAA", "免1");
            startActivity(new Intent(SplishActivity.this, Login.class));
            Log.e("TAA", "去哪里4");

            finish();
        } else if (StaticUtils.isHome) {
            Log.e("TAA", "免2");
            Log.e("TAA", "去哪里3");

            finish();
        } else {
            Log.e("TAA", "免3");
            Log.e("TAA", "去哪里2");

            boolean hasNet = NetWorkUtils.isNetworkAvailable(SplishActivity.this, null);
            Log.e("TAA", "网络检测12333：" + hasNet);

            if (hasNet) {
                Log.e("TAA", "去哪里5");
                startActivity(new Intent(SplishActivity.this, KaijiActivity.class));
                finish();
            } else {
                startActivity(new Intent(SplishActivity.this, CheckActivity.class));
                Log.e("TAA", "去哪里1");
            }
            videoview = (VideoView) findViewById(R.id.videoview);
            ivImg = (ImageView) findViewById(R.id.ivImg);

            videoview.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(android.media.MediaPlayer mediaPlayer) {

                }
            });
            videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    findViewById(R.id.load).setVisibility(View.GONE);
                }
            });

            videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.player));
            videoview.start();


//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                    try {
//                        Thread.sleep(8000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            boolean hasNet = NetWorkUtils.isNetworkAvailable(SplishActivity.this, null);
//                            Log.e("TAA","网络检测12333："+hasNet);
//
//                            if(hasNet) {
//                                startActivity(new Intent(SplishActivity.this, KaijiActivity.class));
//                                finish();
//                            }else{
//                                startActivity(new Intent(SplishActivity.this, CheckActivity.class));
//                                finish();
//                            }
//                        }
//                    });
//
//                }
//            }).start();
        }


    }


    public static String getWifiMac(Context ctx) {
        WifiManager wifi = (WifiManager) ctx.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        String str = info.getMacAddress();
        if (str == null) str = "";
        return str;
    }


    @Override
    protected void onResume() {
        super.onResume();

//        processRequest();
    }


}
