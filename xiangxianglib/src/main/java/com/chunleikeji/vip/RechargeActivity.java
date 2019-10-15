package com.chunleikeji.vip;

/**
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * ** * ┃　　　┃   神兽保佑
 * **** ┃　　　┃   代码无BUG！
 * **** ┃　　　┗━━━━┓
 * **** ┃　　　　　　　  ┣┓
 * *****┃　　　　　　　  ┏┛
 * *****┗┓┓┏━┳┓┏━┛
 * *******┃┫┫　┃┫┫
 * *******┗┻┛　┗┻┛
 */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chunleikeji.login.HttpLonIn;
import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.SPUtils;
import com.chunleikeji.util.StaticUtils;
import com.chunleikeji.xiangxianglib.R;
import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;




public class RechargeActivity extends Activity {
    String TAG = "看这里_________";

    private LinearLayout wx, zfb, linearC, linClick1, linClick2, linClick3, linClick4;
    private TextView textOne, textTwo, textThree, textFour, textMoney, vipDetails, VipText, userName;
    private FrameLayout showFrame, linImg, fbackimg;

    List<String> list = new ArrayList<>();
    private List<String> moneylist = new ArrayList<>();
    private List<String> qrcCodelist = new ArrayList<>();
    private List<String> wxvip = new ArrayList<>();

    private ImageView qrcCode, bcrImg, geimg, backImg;  //imageview图片
    private int w, h;        //图片宽度w,高度h
    private static int CON_ZHI_TWO = 9;
    private PowerManager.WakeLock mWakeLock = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE, RechargeActivity.class.getName());
        mWakeLock.acquire();
        setContentView(R.layout.activity_recharge_);
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        initialstart();
        linClick1.requestFocus();

        Vip();

        vipUser();

    }

    public void initialstart() {
        wx = findViewById(R.id.wx);
        zfb = findViewById(R.id.zfb);
        showFrame = findViewById(R.id.showFrame);
        linearC = findViewById(R.id.linearC);
        linClick1 = findViewById(R.id.linclick1);
        linClick2 = findViewById(R.id.linClick2);
        linClick3 = findViewById(R.id.linClick3);
        linClick4 = findViewById(R.id.linClick4);
        textOne = findViewById(R.id.textOne);
        textTwo = findViewById(R.id.textTwo);
        textThree = findViewById(R.id.textThree);
        textFour = findViewById(R.id.textFour);
        textMoney = findViewById(R.id.textMoney);
        vipDetails = findViewById(R.id.vipDetails);
        bcrImg = findViewById(R.id.bcrImg);
        VipText = findViewById(R.id.VipText);
        userName = findViewById(R.id.userName);
        geimg = findViewById(R.id.geimg);
        linImg = findViewById(R.id.linImg);
        backImg = findViewById(R.id.backImg);
        fbackimg = findViewById(R.id.fbackimg);
    }

    public void linOnClick(View view) {

        if (view.getId() == R.id.linclick1) {
            CON_ZHI_TWO = 0;

            showFrame.setVisibility(View.VISIBLE);
            textMoney.setText(moneylist.get(CON_ZHI_TWO));
            vipDetails.setText(list.get(CON_ZHI_TWO));

            handler.postDelayed(runnable, 1000);
            wx.requestFocus();
        }

        if (view.getId() == R.id.linClick2) {


            CON_ZHI_TWO = 1;

            showFrame.setVisibility(View.VISIBLE);
            textMoney.setText(moneylist.get(CON_ZHI_TWO));
            vipDetails.setText(list.get(CON_ZHI_TWO));

            handler.postDelayed(runnable, 1000);
            wx.requestFocus();
        }
        if (view.getId() == R.id.linClick3) {

            CON_ZHI_TWO = 2;

            showFrame.setVisibility(View.VISIBLE);
            textMoney.setText(moneylist.get(CON_ZHI_TWO));
            vipDetails.setText(list.get(CON_ZHI_TWO));

            handler.postDelayed(runnable, 1000);
            wx.requestFocus();
        }
        if (view.getId() == R.id.linClick4) {

            CON_ZHI_TWO = 3;

            showFrame.setVisibility(View.VISIBLE);
            textMoney.setText(moneylist.get(CON_ZHI_TWO));
            vipDetails.setText(list.get(CON_ZHI_TWO));
            handler.postDelayed(runnable, 1000);
            wx.requestFocus();
        }
        if (view.getId() == R.id.btn_gengxi) {


            vipUser();

        }

    }


    private String vipuserhttp = BaseUrl.BASE + "getChongzhiInfo?user=";

    public void vipUser() {

        SharedPreferences sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
        String user = sharedPreferences.getString("username", "");
        if (TextUtils.isEmpty(user)) {
            user = StaticUtils.user;
        }


        String userhttp = vipuserhttp + user;
        Log.i(TAG, "看看是啥" + userhttp);
        userName.setText(user);
        HttpLonIn.GetOkGttp(this, userhttp, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                VipUtils vip = new Gson().fromJson(response.body().string(), VipUtils.class);
                String end_time = SPUtils.getSharedStringData(RechargeActivity.this, "end_time");
                if (end_time == null && end_time.equals(vip.getEnd_time())) {

                } else {
                    SPUtils.setSharedStringData(RechargeActivity.this, "end_time", vip.getEnd_time());
                }
                if (CON_ZHI_TWO == 0 || CON_ZHI_TWO == 1 || CON_ZHI_TWO == 2 || CON_ZHI_TWO == 3) {
                    if (showFrame.getVisibility() == View.VISIBLE) {

                        Log.i(TAG, "VIP时间_看看轮询没:" + end_time);
                        if (vip.getTag() == 1) {
                            if (end_time.equals(vip.getEnd_time())) {

                            } else {
                                SPUtils.setSharedIntData(RechargeActivity.this, "tagVIP", vip.getTag());
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        showFrame.setVisibility(View.GONE);
                                        handler.removeCallbacks(runnable);
                                        Toast.makeText(RechargeActivity.this, "充值成功", Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }
                        Log.i(TAG, "点击了_看看轮询没 :" + vip.getTag() + "，日期：" + vip.getEnd_time() + "CON_ZHI_TWO :" + CON_ZHI_TWO);
                    }

                }
                Log.i(TAG, "看看轮询没——点击了");

                if (vip.getTag() == 0) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            VipText.setText("您还未成为会员");

                        }
                    });

                } else if (vip.getTag() == 1) {
                    final String vipTime = vip.getEnd_time();
                    Log.i(TAG, "看看是啥" + vipTime);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            VipText.setText(vipTime);
                        }
                    });

                }

            }
        });
    }


    public void Vip() {
        new Thread() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
                String user = sharedPreferences.getString("username", "");
                String Http = "http://39.105.70.121/test/meijiazhifu/meijia_wx_native.php?user=" + user;
                Log.i(TAG, "看看是啥 VIP:" + Http);

                HttpLonIn.GetOkGttp(RechargeActivity.this, Http, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final VipUtils vip = new Gson().fromJson(response.body().string(), VipUtils.class);

//                        if (vip.getTag() == 0) {
                        if (vip != null) {
                            for (int i = 0; i < vip.getData().size(); i++) {
//                        VipHttp.dataHttp data = vip.getData().get(i);
                                VipUtils.DataBean data = vip.getData().get(i);
                                list.add(data.getInfo());
                                moneylist.add(data.getPay());
//                                    qrcCodelist.add(data.getZfb_url());
                                wxvip.add(data.getQrcode());

                            }


                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    textOne.setText(list.get(0));
                                    textTwo.setText(list.get(1));
                                    textThree.setText(list.get(2));
                                    textFour.setText(list.get(3));


                                }
                            });
                        }
//                        } else if (vip.getTag() == 1) {
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    linImg.setVisibility(View.VISIBLE);
//                                    linImg.requestFocus();
//                                    showFrame.setVisibility(View.INVISIBLE);
//                                    Glide.with(RechargeActivity.this)
//                                            .load(vip.getImg())
//                                            .into(geimg);
//                                }
//                            });
//                        }
                    }
                });
            }
        }.start();
        final ImageView bcrImg = (ImageView) findViewById(R.id.bcrImg);
        wx.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    if (wxvip != null) {
                        createQRcodeImage(wxvip.get(CON_ZHI_TWO));

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Glide.with(RechargeActivity.this)
                                        .load(R.drawable.vipex)
                                        .skipMemoryCache(true)
                                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                                        .into(bcrImg);

                            }
                        });
                    }
                    Log.i(TAG, "微信获得焦点");
                    // 获得焦点
                } else {
                    // 失去焦点
                    Log.i(TAG, "微信失去焦点");
                }

            }


        });
//        zfb.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus) {
//
//                    Log.i(TAG, "多少数字:" + CON_ZHI_TWO);
//                    if (qrcCodelist != null) {
//                        createQRcodeImage(qrcCodelist.get(CON_ZHI_TWO));
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Glide.with(RechargeActivity.this)
//                                        .load(R.drawable.zfbvip)
//                                        .into(bcrImg);
//
//                            }
//                        });
//
//                    }
//                    Log.i(TAG, "支付宝获得焦点");
//                    // 获得焦点
//                } else {
//                    // 失去焦点
//                    Log.i(TAG, "支付宝失去焦点");
//                }
//            }
//
//
//        });


    }


    private Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Log.i(TAG, "看看轮询没：");
            vipUser();
            handler.postDelayed(this, 1000);
        }
    };


    @SuppressLint("WrongConstant")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            handler.removeCallbacks(runnable);
            if (showFrame.getVisibility() == View.VISIBLE) {
                showFrame.setVisibility(View.INVISIBLE);

                switch (CON_ZHI_TWO) {
                    case 0:
                        Log.i(TAG, "一号位给予焦点");
                        linClick1.requestFocus();
                        break;
                    case 1:
                        Log.i(TAG, "二号位给予焦点");
                        linClick2.requestFocus();
                        break;
                    case 2:
                        Log.i(TAG, "三号位给予焦点");
                        linClick3.requestFocus();
                        break;
                    case 3:
                        Log.i(TAG, "四号位给予焦点");
                        linClick4.requestFocus();
                        break;
                }

                return false;
            } else {
                return super.onKeyDown(keyCode, event);
            }
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    public void createQRcodeImage(String url) {
        qrcCode = findViewById(R.id.qrcCode);
        w = qrcCode.getWidth();
        h = qrcCode.getHeight();
        try {
            //判断URL合法性
            if (url == null || "".equals(url) || url.length() < 1) {
                return;
            }
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            //图像数据转换，使用了矩阵转换
            BitMatrix bitMatrix = new QRCodeWriter().encode(url, BarcodeFormat.QR_CODE, w, h, hints);
            int[] pixels = new int[w * h];
            //下面这里按照二维码的算法，逐个生成二维码的图片，
            //两个for循环是图片横列扫描的结果
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * w + x] = 0xff000000;
                    } else {
                        pixels[y * w + x] = 0xffffffff;
                    }
                }
            }
            //生成二维码图片的格式，使用ARGB_8888
            Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, w, 0, 0, w, h);
            //显示到我们的ImageView上面
            qrcCode.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            Toast.makeText(this, "正在加载中...", Toast.LENGTH_LONG).show();
            fbackimg.setVisibility(View.VISIBLE);
            backImg.requestFocus();
            Log.i(TAG, " 121正在加载中...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        fbackimg.setVisibility(View.INVISIBLE);
        linClick1.requestFocus();
        Log.i(TAG, " 121 加载完成");

    }


}
