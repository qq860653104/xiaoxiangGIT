package com.iptv.chunlei.luncher;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends Activity {

    private static int tag = 0;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        videoView   =findViewById(R.id.videoview);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                findViewById(R.id.load).setVisibility(View.GONE);
            }
        });


    }


    @Override
    protected void onResume() {
        super.onResume();
       if(tag==0){
           tag=1;
//           first();
           firstVideo();
       }else{
           openOtherApp1();

       }



      //  openOtherApp1();
    }

    private void firstVideo(){

        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.player));
        videoView.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(8000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            openOtherApp1();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void first(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(8000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            openOtherApp1();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
//        openOtherApp1();
    }

    private void openOtherApp1()
    {
//        ComponentName apk2Component1 = new ComponentName("chuanbo.com.jiayin.yuncaizixun","chuanbo.com.jiayin.yuncaizixun.SplashActivity");
        ComponentName apk2Component1 = new ComponentName("zhihu.iptv.jiayin.zhihuiptv","zhihu.iptv.jiayin.zhihuiptv.SplishActivity");

        Intent mIntent = new Intent();
        mIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        mIntent.setComponent(apk2Component1);

        startActivity(mIntent);
    }

}
