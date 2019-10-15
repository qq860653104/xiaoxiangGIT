package com.chunleikeji.login;

import android.app.Activity;
import android.companion.CompanionDeviceManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.ClassSaveUtils;
import com.chunleikeji.util.SPUtils;
import com.chunleikeji.util.StaticUtils;
import com.google.gson.Gson;


import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class JudgeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        kaiJin();

    }

    private static final String TAG = "JudgeActivity: 看这里";

    public void kaiJin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        SharedPreferences sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
                        final String user = sharedPreferences.getString("username", "");
                        final String pwd = sharedPreferences.getString("password", "");
                        final String mac = MacUtils.getSerial(JudgeActivity.this);
                        final String ip = getLocalIp();
                        StaticUtils.user = user;
//                        MobclickAgent.onProfileSignIn(user);
                        Log.i(TAG, "这里----------------------123" + "账号:" + user + "密码:" + pwd + "MAC:" + mac + "IP:" + ip);
                        String http = BaseUrl.BASE + "checkLoginState";
                        String HTTP = http + "?user=" + user + "&pwd=" + pwd + "&mac=" + mac + "&ip=" + ip;

                        Log.i(TAG, "验证接口" + HTTP);

                        if (user == "" && pwd == "") {
                            //注册
                            startActivity(new Intent(JudgeActivity.this, Login.class));
                            overridePendingTransition(0, 0);
                            finish();

                        } else {

                            HttpLonIn.GetOkGttp(JudgeActivity.this, HTTP, new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(JudgeActivity.this, "网络错误,请配置网络。", Toast.LENGTH_LONG).show();

                                            try {
                                                Thread.sleep(3000);
                                            } catch (InterruptedException e1) {
                                                e1.printStackTrace();
                                            }
                                            finish();
                                        }
                                    });


                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                  String body = null;
                                    try {
                                         body = response.body().string();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    final Return return2 = new Gson().fromJson(body, Return.class);


                                    runOnUiThread(new TimerTask() {
                                        @Override
                                        public void run() {
                                            //tag 0是被顶替 ，1是正常
                                            int tag = return2.getTag();
                                            //VIP 0无VIP，1有
                                            int vip = return2.getVip();

                                            Log.i(TAG, "VIP看看是啥_验证接口开机：" + "tag:" + tag + "vip:" + vip);

                                            if (tag == 1) {
                                                //主页
                                                Intent intent = new Intent(JudgeActivity.this, ClassSaveUtils.MainActivity);
                                                SPUtils.setSharedIntData(JudgeActivity.this, "tagVIP", vip);
                                                startActivity(intent);
                                                overridePendingTransition(0, 0);
                                                finish();
                                            } else if (tag == 0) {
                                                // 登陆
                                                startActivity(new Intent(JudgeActivity.this, Login.class));
                                                overridePendingTransition(0, 0);
                                                finish();
                                            }
//                                                else if (vip == 0) {
//                                                    //充值
//                                                    startActivity(new Intent(SplishActivity.this, Recharge.class));
//                                                    finish();
//                                                }
//
                                        }
                                    });
                                }
                            });
                        }
                    }

                });

            }
        }).start();
    }

    //获取当前设备IP
    private static String getLocalIp() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()
                            && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {

        }
        return "0.0.0.0";
    }


}
