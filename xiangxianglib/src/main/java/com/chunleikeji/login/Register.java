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

import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.ClassSaveUtils;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Callback;
import okhttp3.Response;



public class Register extends Activity {
    private static final String TAG = "Register: 看这里";
    EditText edPassword, edName, edphone;
    Button btLogIn, btJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_register);

        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        edName = findViewById(R.id.edName);
        edPassword = findViewById(R.id.edPassword);
        btJump = findViewById(R.id.btJump);
        btLogIn = findViewById(R.id.btLogIn);
        edphone = findViewById(R.id.textPhone);
        SharedPreferences sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);

        String user = sharedPreferences.getString("username", "");
        String pwd = sharedPreferences.getString("password", "");
        Log.i(TAG, "这里----------------------" + user + "," + pwd);
        Log.i(TAG, "这里----------------------来过");
        MobclickAgent.onProfileSignIn(user);
//        this.edName.setOnFocusChangeListener(new OnFocusHandler());
//        this.edPassword.setOnFocusChangeListener(new OnFocusHandler());
//        this.btJump.setOnFocusChangeListener(new OnFocusHandler());
//        this.btLogIn.setOnFocusChangeListener(new OnFocusHandler());
    }


    private String URL = BaseUrl.BASE + "tvregiest";

    //    private class OnFocusHandler implements OnFocusChangeListener {
//
//        @SuppressLint("ResourceAsColor")
//        @Override
//        public void onFocusChange(View v, boolean hasFocus) {
//            switch (v.getId()) {
//                case R.id.edName:
//                    if (hasFocus){
//
//                    }else {
//                        Toast.makeText(Register.this,"NO",Toast.LENGTH_LONG).show();
//                    }
//                    break;
//                case R.id.edPassword:
//                    if (hasFocus){
//
//                    }else {
//
//                    }
//                    break;
//                case R.id.btLogIn:
//                    if (hasFocus){
//
//                        btLogIn.setBackgroundColor(Color.RED);
//                        btLogIn.setRawInputType(8);
//                    }else {
//                        btLogIn.setBackgroundColor(Color.WHITE);
//                        btLogIn.setRawInputType(8);
//                    }
//
//                    break;
//                case R.id.btJump:
//                    if (hasFocus){
//
//                        btJump.System.out.println( "hehe\n" );
//                    }else {
//                        btJump.setBackgroundColor(Color.WHITE);
//                    }
//
//                    break;
//            }
//        }
//    }
    public void btClick(View view) {

        if (view.getId() == R.id.btLogIn) {
            abc();
        }

        if (view.getId() == R.id.btJump) {
            startActivity(new Intent(Register.this, Login.class));
            Register.this.finish();
        }


    }


    public void abc() {
        final String user = edName.getText().toString();
        String pwd = edPassword.getText().toString();
        String phone = edphone.getText().toString();
        String mac = MacUtils.getSerial(this);
        Log.i(String.valueOf(this), "mac" + mac);
        String ip = getLocalIp();
        StaticUtils.user = user;
        Log.d(String.valueOf(this), "ip" + ip);
        saveLoginInfo(this, user, pwd);
        final String ABC = URL + "?user=" + user + "&pwd=" + pwd + "&mac=" + mac + "&ip=" + ip;
//      Toast.makeText(MainActivity.this,"账号："+user+"，密码："+pwd,Toast.LENGTH_LONG).show();
        Log.i(TAG, "abc: -----------" + ABC);
//        if (phone.length() < 11 ){
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(Register.this,"手机号少于11位",Toast.LENGTH_LONG).show();
//                }
//            });
//
//        }else if (isMobile(phone) == false){
//            Toast.makeText(Register.this,"请输入正确手机号",Toast.LENGTH_LONG).show();
//
//        }else {


        HttpLonIn.GetOkGttp(this, ABC, new Callback() {


            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Toast.makeText(Register.this, "网络错误", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                final Return return1 = new Gson().fromJson(response.body().string(), Return.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int tag = return1.getTag();
                        String msg = return1.getMsg();
                        if (tag == 0) {

                            Toast.makeText(Register.this, msg, Toast.LENGTH_LONG).show();

                        } else if (tag == 1) {
                            try {
                                StaticUtils.user = user;
                                startActivity(new Intent(Register.this, ClassSaveUtils.MainActivity));
                                Register.this.finish();

                            } catch (Exception e) {
                                Toast.makeText(Register.this, "", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }
                });
            }

        });
//    }
    }

    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,6,7,8,9][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
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