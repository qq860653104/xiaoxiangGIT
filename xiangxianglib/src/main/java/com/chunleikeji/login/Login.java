package com.chunleikeji.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chunleikeji.bean.Test;
import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.ClassSaveUtils;
import com.chunleikeji.util.SPUtils;
import com.chunleikeji.util.StaticUtils;
import com.chunleikeji.xiangxianglib.R;
import com.google.gson.Gson;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;



public class Login extends Activity {
    private static final String TAG = "Register: 看这里";
    EditText edPassword, edName;
    Button btLogIn, btJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        btLogIn = findViewById(R.id.btLogIn);
        btJump = findViewById(R.id.btJump);
        edName = findViewById(R.id.edName);
        edPassword = findViewById(R.id.edPassword);
        SharedPreferences sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
        String user = sharedPreferences.getString("username", "");
        String pwd = sharedPreferences.getString("password", "");
        Log.i(TAG, "这里123:" + user + "," + pwd);
        StaticUtils.user = user;
        MobclickAgent.onProfileSignIn(user);
    }


    String url = BaseUrl.BASE + "login";

    public void btClick(View view) {

        if (view.getId() == R.id.btLogIn) {
            verify();
        }


        if (view.getId() == R.id.btJump) {
            startActivity(new Intent(Login.this, Register.class));
            Login.this.finish();
        }

    }


    public void abc() {
        String user = edName.getText().toString();
        String pwd = edPassword.getText().toString();
        String mac = MacUtils.getSerial(this);
        final String ip = getLocalIp();
        saveLoginInfo(this, user, pwd);
        StaticUtils.user = user;
        String ABC = url + "?user=" + user + "&pwd=" + pwd + "&mac=" + mac + "&ip=" + ip;
//      Toast.makeText(MainActivity.this,"账号："+user+"，密码："+pwd,Toast.LENGTH_LONG).show();
        Log.i(TAG, "这里123:" + ABC);
        HttpLonIn.GetOkGttp(this, ABC, new Callback() {

            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Login.this, "网络错误", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                Log.i(TAG, "VIP看看是啥_验证接口：走得这2");

                final Return return1 = new Gson().fromJson(response.body().string(), Return.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int tag = return1.getTag();
                        String msg = return1.getMsg();
                        if (tag == 0) {
                            Toast.makeText(Login.this, msg, Toast.LENGTH_LONG).show();
                        } else if (tag == 1) {
                            try {
                                Log.e(TAG, "run: " + ClassSaveUtils.MainActivity  );
                                Toast.makeText(Login.this, msg, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Login.this, ClassSaveUtils.MainActivity);
                                startActivity(intent);
                                Login.this.finish();
                            } catch (Exception e) {

                            }
                        }
                    }
                });
            }
        });
    }

    String http = BaseUrl.BASE + "checkvip";

    public void verify() {

        String user = edName.getText().toString();
        String pwd = edPassword.getText().toString();
//        String mac = getMacAddressFromIp();
        String mac = MacUtils.getSerial(this);

        final String ip = getLocalIp();
        final String verifyHttp = http + "?user=" + user + "&pwd=" + pwd + "&mac=" + mac + "&ip=" + ip;
        Log.i(TAG, "VIP看看是啥_验证接口：走得这1" + verifyHttp);
        HttpLonIn.GetOkGttp(Login.this, verifyHttp, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, "VIP看看是啥_验证接口：走得这1");

                Test return3 = new Gson().fromJson(response.body().string(), Test.class);

                Log.i(TAG, "VIP看看是啥_验证接口Lonon：" + "TAG:" + return3.getTag() + "，vip:" + return3.getVip() + "，verifyHttp:" + verifyHttp);
                //主页传参
                SPUtils.setSharedIntData(Login.this, "tagVIP", return3.getVip());

            }
        });
        abc();
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


    /**
     * @param context
     * @param username
     * @param password
     */


    public static void saveLoginInfo(Context context, String username, String password) {
        //获取SharedPreferences对象
        SharedPreferences sharedPre = context.getSharedPreferences("config", context.MODE_PRIVATE);
        //获取Editor对象
        SharedPreferences.Editor editor = sharedPre.edit();
        //设置参数
        editor.putString("username", username);
        editor.putString("password", password);
        //提交
        editor.commit();
    }

}