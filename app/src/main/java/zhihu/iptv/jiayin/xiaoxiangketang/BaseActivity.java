package zhihu.iptv.jiayin.xiaoxiangketang;

import android.app.Activity;
import android.os.Bundle;


public class BaseActivity extends Activity {
//    CountTimer countTimerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initCreate();
    }

//    private void initCreate() {
//
//        countTimerView=new CountTimer(360000,1000,BaseActivity.this);
//
//    }
//
//    @Override
//    public boolean dispatchKeyEvent(KeyEvent event) {
//        android.util.Log.e("TAA","anjiankey:"+event.getAction());
//        switch (event.getAction()){
//            //获取触摸动作，如果ACTION_UP，计时开始。
//            case MotionEvent.ACTION_UP:
////                countTimerView.start();
//                android.util.Log.e("TAA","anjian:开始了:"+event.getAction());
//
//                break;
//            //否则其他动作计时取消
//            default:countTimerView.cancel();
//                android.util.Log.e("TAA","anjian:取消了:"+event.getAction());
//
//                break;
//        }
//        return super.dispatchKeyEvent(event);
//    }

    @Override
    protected void onPause() {

        super.onPause();
//        countTimerView.cancel();
        android.util.Log.e("TAA","anjian:取消了onPause:");

    }
    @Override
    protected void onResume() {

        super.onResume();
//        countTimerView.start();
        android.util.Log.e("TAA","anjian:开始了onResume:");

    }

}
