package com.chunleikeji.util;


import android.content.Context;
import android.os.CountDownTimer;


public class CountTimer extends CountDownTimer {
    private Context context;

    /**
     * 参数 millisInFuture       倒计时总时间（如60S，120s等）
     * 参数 countDownInterval    渐变时间（每次倒计1s）
     */
    public CountTimer(long millisInFuture, long countDownInterval,Context context) {
        super(millisInFuture, countDownInterval);
        this.context=context;
    }
    // 计时完毕时触发
    @Override
    public void onFinish() {
//        UIHelper.showMainActivity((Activity) context);
//        ToastUtils.showToast(context,"屏保开启中。");
//        context.startActivity(new Intent(context,PingbaoActivity.class));
    }
    // 计时过程显示
    @Override
    public void onTick(long millisUntilFinished) {
    }
}