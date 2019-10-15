package zhihu.iptv.jiayin.xiaoxiangketang;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.os.Bundle;
import android.view.KeyEvent;


import com.chunleikeji.util.NetWorkUtils;

import java.util.Timer;
import java.util.TimerTask;



public class CheckActivity extends Activity {
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        boolean hasNet = NetWorkUtils.isNetworkAvailable(CheckActivity.this, null);

       if(hasNet){
            startActivity(new Intent(CheckActivity.this,KaijiActivity.class));
            finish();
        }else{
            checkNetWork();
        }
    }


    int count = 0;
    boolean exeOne = true;
    public void checkNetWork(){

        timer = new Timer(true);

        TimerTask task = new TimerTask() {
            public void run() {
                count++;

                //每次需要执行的代码放到这里面。
                boolean hasNet = NetWorkUtils.isNetworkAvailable(CheckActivity.this, null);
                if(hasNet){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(exeOne){
                                exeOne = false;
                                timer.cancel();
//                                processRequest();
                                startActivity(new Intent(CheckActivity.this,KaijiActivity.class));
                                finish();
                            }

                        }
                    });

                }else{
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(CheckActivity.this, "正在重连网络。。", Toast.LENGTH_SHORT).show();
//                        }
//                    });
                }
            }
        };
        timer.schedule(task, 1000,1000);

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);

        return  true;
    }
}
