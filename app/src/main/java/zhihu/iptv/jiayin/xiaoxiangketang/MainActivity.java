package zhihu.iptv.jiayin.xiaoxiangketang;

import android.animation.Animator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.allenliu.versionchecklib.core.AllenChecker;
import com.allenliu.versionchecklib.core.VersionDialogActivity;
import com.allenliu.versionchecklib.core.VersionParams;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chunleikeji.ActivityClass.ActivityCollector;
import com.chunleikeji.bean.HomePageBean;
import com.chunleikeji.bean.KaiJIBean;
import com.chunleikeji.bean.ShenFaBean;
import com.chunleikeji.bean.VerBean;
import com.chunleikeji.login.HttpLonIn;
import com.chunleikeji.login.Login;
import com.chunleikeji.login.MacUtils;
import com.chunleikeji.login.Return;
import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.ClassSaveUtils;
import com.chunleikeji.util.OkHttpUtils;
import com.chunleikeji.util.SPUtils;
import com.chunleikeji.util.StaticUtils;
import com.chunleikeji.util.ToastUtils;
import com.chunleikeji.util.Utils;
import com.chunleikeji.view.DrawingOrderRelativeLayout;
import com.chunleikeji.view.MarqueeText;
import com.chunleikeji.view.MetroItemFrameLayout;
import com.chunleikeji.view.MetroViewBorderHandler;
import com.chunleikeji.view.MetroViewBorderImpl;
import com.chunleikeji.vip.RechargeActivity;
import com.chunleikeji.zhibotv.CustomVersionDialogActivity;
import com.chunleikeji.zhibotv.DemoService;
import com.chunleikeji.zhibotv.OKHttpUtils;
import com.chunleikeji.zhibotv.TvActivity;
import com.chunleikeji.zhibotv.VerUtils;
import com.google.gson.Gson;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;


import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import zhihu.iptv.jiayin.xiaoxiangketang.Adapter.SearchRightGridViewAdapter;
import zhihu.iptv.jiayin.xiaoxiangketang.apk.ConstCommon;
import zhihu.iptv.jiayin.xiaoxiangketang.apk.HttpUtils;
import zhihu.iptv.jiayin.xiaoxiangketang.apk.InstallAPKUtils;


public class MainActivity extends Activity implements View.OnClickListener {
    private String TAG = "你瞅啥，";
    private MetroItemFrameLayout mView10;
    private MetroItemFrameLayout mView11;
    private MetroItemFrameLayout mView;
    private MetroItemFrameLayout mView4;
    private MetroItemFrameLayout mView2;
    private MetroItemFrameLayout mView3;
    private MetroItemFrameLayout mView5;
    private MetroItemFrameLayout mView6;
    private MetroItemFrameLayout view_style;
    private DrawingOrderRelativeLayout mList;

    private ImageView image10, image11, image, image4, image3, image2, image5, image6;

    //view10 , view11 , view view4 view3 view2 view5 view6

    /**
     * 搜索
     */
//    private TextView mSearchText;
//    private LinearLayout mTopsousuo;
    private TextView mDateHome;
    /**
     * 收藏
     */
    private TextView mShoucang;
    /**
     * 会员中心
     */
    private TextView vip;
    /**
     * 历史
     */
    private TextView lishi;
    /**
     * 搜索
     */
    private TextView mSousuo;
    /**
     * 设置
     */
    private TextView mShezhi;
    /**
     * 关于我们
     */
    private TextView mGuanyu;
    private MarqueeText mTongzhi;
    private ImageView mRootview;
    /**
     *
     */
    private TextView mAddress;
    /**
     *
     */
    private TextView mWendu;
    /**
     * 2018-3-1
     */
    private TextView mTimeyear;
    /**
     * 18:00
     */
    private TextView mTimedate;
    /**
     * 星期四
     */
    private TextView mXingqi;

    private TextView eliminate;

    private PowerManager.WakeLock mWakeLock = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE, MainActivity.class.getName());
        mWakeLock.acquire();
        setContentView(R.layout.activity_main);
        ActivityCollector.addActivity(this);
        StaticUtils.setActivity(this);
        initView();
        handler.postDelayed(runnable, 5000);


/**
 * 设置组件化的Log开关
 * 参数: boolean 默认为false，如需查看LOG设置为true
 */
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.setSessionContinueMillis(1000);
        initHomeView();
        tiaozhaun1();


        ClassSaveUtils.CarouselImgActivity = CarouselImgActivity.class;
        ClassSaveUtils.DetailInfoActivity = DetailInfoActivity.class;

    }

    private void initHomeView() {


        FrameLayout roundedFrameLayout = new FrameLayout(this);
        roundedFrameLayout.setClipChildren(false);

        final MetroViewBorderImpl metroViewBorderImpl = new MetroViewBorderImpl(roundedFrameLayout);
        metroViewBorderImpl.setBackgroundResource(R.drawable.border_color);

        ViewGroup list = (ViewGroup) findViewById(R.id.list);
        metroViewBorderImpl.attachTo(list);

        metroViewBorderImpl.getViewBorder().addOnFocusChanged(new MetroViewBorderHandler.FocusListener() {
            @Override
            public void onFocusChanged(View oldFocus, final View newFocus) {
                metroViewBorderImpl.getView().setTag(newFocus);

            }
        });
        metroViewBorderImpl.getViewBorder().addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                View t = metroViewBorderImpl.getView().findViewWithTag("top");
                if (t != null) {
                    ((ViewGroup) t.getParent()).removeView(t);
                    View of = (View) metroViewBorderImpl.getView().getTag(metroViewBorderImpl.getView().getId());
                    ((ViewGroup) of).addView(t);
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                View nf = (View) metroViewBorderImpl.getView().getTag();
                if (nf != null) {
                    View top = nf.findViewWithTag("top");
                    if (top != null) {
                        ((ViewGroup) top.getParent()).removeView(top);
                        ((ViewGroup) metroViewBorderImpl.getView()).addView(top);
                        metroViewBorderImpl.getView().setTag(metroViewBorderImpl.getView().getId(), nf);

                    }
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    private void initView() {
        mView10 = (MetroItemFrameLayout) findViewById(R.id.view10);
        mView11 = (MetroItemFrameLayout) findViewById(R.id.view11);
        mView = (MetroItemFrameLayout) findViewById(R.id.view);

        mView4 = (MetroItemFrameLayout) findViewById(R.id.view4);
        mView2 = (MetroItemFrameLayout) findViewById(R.id.view2);
        mView3 = (MetroItemFrameLayout) findViewById(R.id.view3);
        mView5 = (MetroItemFrameLayout) findViewById(R.id.view5);
        mView6 = (MetroItemFrameLayout) findViewById(R.id.view6);

        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image = findViewById(R.id.image);
        image4 = findViewById(R.id.image4);
        image3 = findViewById(R.id.image3);
        image2 = findViewById(R.id.image2);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);


        //image10 ,image11,image,image4,image3,image2,image5,image6;
        mList = (DrawingOrderRelativeLayout) findViewById(R.id.list);
        mDateHome = (TextView) findViewById(R.id.date_home);
        mShoucang = (TextView) findViewById(R.id.shoucang);
        mSousuo = (TextView) findViewById(R.id.sousuo);
//        mShezhi = (TextView) findViewById(R.id.shezhi);
        mGuanyu = (TextView) findViewById(R.id.guanyu);
        mTongzhi = (MarqueeText) findViewById(R.id.tongzhi);
        vip = (TextView) findViewById(R.id.vip);
        lishi = (TextView) findViewById(R.id.lishi);
        eliminate = (TextView) findViewById(R.id.eliminate);


        mView10.setOnClickListener(this);

        mView.setOnClickListener(this);
        eliminate.setOnClickListener(this);
        mView4.setOnClickListener(this);
        mView2.setOnClickListener(this);
        mView3.setOnClickListener(this);
        mView5.setOnClickListener(this);
        mView6.setOnClickListener(this);
        mList.setOnClickListener(this);
        mDateHome.setOnClickListener(this);
        mShoucang.setOnClickListener(this);
        mSousuo.setOnClickListener(this);
//        mShezhi.setOnClickListener(this);
        mGuanyu.setOnClickListener(this);
        mTongzhi.setOnClickListener(this);
        vip.setOnClickListener(this);
        lishi.setOnClickListener(this);

        //设置焦点

        mShoucang.setOnFocusChangeListener(Utils.getFocus());
        mGuanyu.setOnFocusChangeListener(Utils.getFocus());
        mSousuo.setOnFocusChangeListener(Utils.getFocus());
//        mShezhi.setOnFocusChangeListener(Utils.getFocus());
        vip.setOnFocusChangeListener(Utils.getFocus());
        lishi.setOnFocusChangeListener(Utils.getFocus());
        eliminate.setOnFocusChangeListener(Utils.getFocus());

        //设置时间
        final TextView mTimeyear = (TextView) findViewById(R.id.timeyear);
        final TextView mTimedate = (TextView) findViewById(R.id.timedate);

        final SimpleDateFormat year = new SimpleDateFormat("MM月dd日");// HH:mm:ss
        final SimpleDateFormat mills = new SimpleDateFormat("HH:mm");// HH:mm:ss

//获取当前时间
        final Date date = new Date(System.currentTimeMillis());
        date.setTime(System.currentTimeMillis());
        mTimeyear.setText(year.format(date));
        mTimedate.setText(mills.format(date));


        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(60000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                date.setTime(System.currentTimeMillis());
                                mTimeyear.setText(year.format(date));
                                mTimedate.setText(mills.format(date));

                            }
                        });


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
        loadHomePage();
        mRootview = (ImageView) findViewById(R.id.rootview);

    }

    /*获取星期几*/
    public static String getWeek() {
        Calendar cal = Calendar.getInstance();
        int i = cal.get(Calendar.DAY_OF_WEEK);
        switch (i) {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
            default:
                return "";
        }
    }

    int tag;

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            default:
                break;
            case R.id.view10:
                tag = 0;
                tiaozhaun();

                break;
            case R.id.view11:
                tag = 1;
                tiaozhaun();
                //直播

                break;
            case R.id.view:
                tag = 2;
                tiaozhaun();

                break;
            case R.id.view4:
                tag = 3;
                tiaozhaun();

                break;
            case R.id.view3:
                tag = 4;
                tiaozhaun();

                break;
            case R.id.view2:
                tag = 5;
                tiaozhaun();

                break;
            case R.id.view5:
                tag = 6;
                tiaozhaun();

                break;
            case R.id.view6:
                tag = 7;
                tiaozhaun();

                break;
            case R.id.list:
                break;

            case R.id.date_home:
                break;
            case R.id.shoucang:
                startActivity(new Intent(MainActivity.this, ShouCangActivity.class));
//                ToastUtils.showToast(this, "暂无开通，敬请期待");
                break;
            case R.id.vip:
                startActivity(new Intent(MainActivity.this, RechargeActivity.class));
//                ToastUtils.showToast(this, "暂无开通，敬请期待");
                break;
            case R.id.sousuo:
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
//                ToastUtils.showToast(this, "暂无开通，敬请期待");
                break;
//            case R.id.shezhi:
//                //com.android.settings
//                startActivity(new Intent(MainActivity.this, SheZhiActivity.class));
//                break;
            case R.id.guanyu:
//                startActivity(new Intent(MainActivity.this, GuanYuActivity.class));
                ToastUtils.showToast(this, "暂无开通，敬请期待");
                break;
            case R.id.lishi:
                startActivity(new Intent(MainActivity.this, LishiJiLuActivity.class));
//                ToastUtils.showToast(this, "暂无开通，敬请期待");
                break;
            case R.id.tongzhi:
                break;
            case R.id.eliminate:

//                ToastUtils.showToast(this, "正在清除缓存");
//                findViewById(R.id.live_progress).setVisibility(View.VISIBLE);
//                handler.postDelayed(runnable1,3000);
                startActivity(new Intent(MainActivity.this, CacheActivity.class));
                break;
        }
    }

    Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    ToastUtils.showToast(MainActivity.this, "清除完毕");
                    findViewById(R.id.live_progress).setVisibility(View.GONE);
                }
            });

        }
    };

    SearchRightGridViewAdapter searchRightGrid;

    public void tiaozhaun() {

        searchRightGrid = new SearchRightGridViewAdapter(this, null, null);


        OKHttpUtils.getOkHttp(this, homePageUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();

                int urlid = SPUtils.getSharedIntData(MainActivity.this, "tagVIP");

                HomePageBean homePageBean = new Gson().fromJson(body, HomePageBean.class);
                Intent intent = new Intent(MainActivity.this, QuanBuActivity.class);
                Intent intent3 = new Intent(MainActivity.this, TvActivity.class);


                int tagtype = homePageBean.getData().get(tag).getRes_type();

                int datavip = homePageBean.getData().get(tag).getVip();

                if (homePageBean.getData().get(tag).getName() != null) {
                    String type = homePageBean.getData().get(tag).getName();
                    intent.putExtra("data", type + "");


                    SPUtils.setSharedStringData(MainActivity.this, "type", type);
                    Log.e("TAA", "应用_走的是这吗_主页" + type);
                }
                Log.e("TAA", "VIP看看是啥_哈哈_datavip:" + datavip + ",urVid:" + urlid);


                //权限  0所有人可进  ， 1可进入
                if (datavip == 0) {
                    if (tagtype == 0) {
                        Log.e("TAA", "应用_直播:" + tagtype);
                        startActivity(new Intent(MainActivity.this, TvActivity.class));
                    } else if (tagtype == 1) {
                        Log.e("TAA", "应用_影视:" + tagtype);
                        startActivity(intent);

                    }
//                    else if (tagtype == 2) {
//                        Log.e("TAA", "应用_APP:" + tagtype);
//
//                        appJson(homePageBean.getData().get(tag).getApk_type());
//                        ToastUtils.showToast(MainActivity.this, "正在开发中，敬请期待");
//                    }

                } else if (datavip == 1) {


                    if (urlid == 0) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                showErrorDialog();

                            }
                        });
                    } else if (urlid == 1) {
                        if (tagtype == 0) {
                            Log.e("TAA", "应用_直播:" + tagtype);
                            startActivity(new Intent(MainActivity.this, TvActivity.class));

                        } else if (tagtype == 1) {
                            Log.e("TAA", "应用_影视:" + tagtype);
                            startActivity(intent);

                        }
//                        else if (tagtype == 2) {
//                            Log.e("TAA", "应用_APP:" + tagtype);
//
//                          appJson(homePageBean.getData().get(tag).getApk_type());
//
//                        }
                    }

                }

                Log.e("TAA", "应用_APP:" + tagtype);

                //选择影视类型


            }

        });


    }

    public void tiaozhaun1() {

        searchRightGrid = new SearchRightGridViewAdapter(this, null, null);


        OKHttpUtils.getOkHttp(this, homePageUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();

                HomePageBean homePageBean = new Gson().fromJson(body, HomePageBean.class);

                StaticUtils.listName = homePageBean;


            }

        });


    }

    private void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("您还不是会员，请联系管理员开通");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                startActivity(new Intent(MainActivity.this, RechargeActivity.class));
            }
        });
        builder.show();
    }

    public void appJson(String appname) {


        Log.e("TAA", "应用_走的是这吗_主页:" + ConstCommon.apkName + appname);

        OKHttpUtils.getOkHttp(this, ConstCommon.apkName + appname, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                HttpUtils dataBean = new Gson().fromJson(body, HttpUtils.class);
                Log.e(TAG, "onResponse111: " + body);
                if (dataBean != null && dataBean.getData() != null && dataBean.getData().get(0).getApk_addr() != null) {
                    String apkUrl = dataBean.getData().get(0).getApk_addr();
                    String downName = dataBean.getData().get(0).getApk_name();
                    String appName = dataBean.getData().get(0).getApk_bm();
                    instal(downName, apkUrl, appName);

                }

            }
        });


    }

    InstallAPKUtils installPos3 = null;
    boolean p3IsDownLoad;

    private void instal(String downName, String apkUrl, String appName) {

        Log.e("TAA", "应用_走的是这吗_insta:" + "APP名字：" + downName + "，下载地址：" + apkUrl);

        if (installPos3 == null) {
            installPos3 = new InstallAPKUtils();
        }
        if (p3IsDownLoad) {
            Log.e("TAA", "应用_走的是这吗_insta:1");

            openAPK(null, null, null, null, installPos3);
        } else {

            Log.e("TAA", "应用_走的是这吗_insta:2");

            openAPK(downName, apkUrl, appName, new InstallAPKUtils.IsDownLoadOk() {
                @Override
                public void isDownLoad(boolean isOk) {
                    p3IsDownLoad = isOk;
                }
            }, installPos3);
        }
    }

    private void openAPK(final String pageName, final String apkUrl, String appName, final InstallAPKUtils.IsDownLoadOk isDownLoadOk, final InstallAPKUtils isstall) {
        Log.e("TAA", "应用_走的是这了吗44" + appName);
        if (isAppExist(appName)) {

            Log.e("TAA", "应用_走的是这了吗33" + appName);
            doStartApplicationWithPackageName(appName);
        } else {
            //启动指定应用
            if (pageName == null) {

                Log.e("TAA", "应用_走的是这了吗11");

                if (isstall.progressDialog != null) {

                    try {
                        isstall.progressDialog.show();
                    } catch (Exception e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "请稍后，正在下载", Toast.LENGTH_LONG).show();
                            }
                        });
                        e.printStackTrace();
                    }

                }


            } else {
                Log.e("TAA", "应用_走的是这了吗22");
                //没有安装，则去下载APK进行安装
                //为避免多次点击，在安装之前，判断下载是否成功
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        isstall.getApkUrl(MainActivity.this, apkUrl, pageName, isDownLoadOk);
                    }
                });
            }


        }
    }

    private void doStartApplicationWithPackageName(String packagename) {

        // 通过包名获取此APP详细信息，包括Activities、services、versioncode、name等等
        PackageInfo packageinfo = null;

        try {
            packageinfo = getPackageManager().getPackageInfo(packagename, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if (packageinfo == null) {
            return;
        }

        // 创建一个类别为CATEGORY_LAUNCHER的该包名的Intent
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(packageinfo.packageName);

        // 通过getPackageManager()的queryIntentActivities方法遍历
        List<ResolveInfo> resolveinfoList = getPackageManager()
                .queryIntentActivities(resolveIntent, 0);

        ResolveInfo resolveinfo = resolveinfoList.iterator().next();
        if (resolveinfo != null) {
            // packagename = 参数packname
            String packageName = resolveinfo.activityInfo.packageName;
            // 这个就是我们要找的该APP的LAUNCHER的Activity[组织形式：packagename.mainActivityname]
            String className = resolveinfo.activityInfo.name;
            // LAUNCHER Intent
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);

            // 设置ComponentName参数1:packagename参数2:MainActivity路径
            ComponentName cn = new ComponentName(packageName, className);

            intent.setComponent(cn);
            startActivity(intent);
        }
    }


    protected boolean isAppExist(String pkgName) {
        ApplicationInfo info;
        try {
            info = getPackageManager().getApplicationInfo(pkgName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            info = null;
        }

        return info != null;
    }

    /**
     * 自动加载首页图片与文字
     */
    private String homePageUrl = BaseUrl.BASE + "getHomePage";

    //阻止多次执行 ， 只允许执行一次
    boolean is_one = true;

    private void loadHomePage() {
        Log.e("TAA", "走的是这吗1" + homePageUrl);

        OkHttpUtils.getOkHttp(this, homePageUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String body = response.body().string();
                Log.e(TAG, "onResponse: " + body);
                final HomePageBean homePageBean = new Gson().fromJson(body, HomePageBean.class);
                List<HomePageBean.DataBean> data = homePageBean.getData();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //    mTongzhi.setSpeed(4);
                        //    mTongzhi.setHorizontal(false);
                        Log.e("TAA", "滚动的字幕:" + homePageBean.getTitle());
                        mTongzhi.setMyContext(homePageBean.getTitle());
                        mTongzhi.setL2r(false);
                        mTongzhi.setMySpeed(1);
                        mTongzhi.startScroll();
//                        mTongzhi.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                Log.e("TAA","宽："+mTongzhi.getMeasuredWidth()+"______");
//                                TranslateAnimation translateAnimation = new TranslateAnimation(mTongzhi.getMeasuredWidth(), -(mTongzhi.getMeasuredWidth()+200), 0, 0);
//                                translateAnimation.setRepeatCount(Animation.INFINITE);
////        translateAnimation.setRepeatMode(Animation.REVERSE);
//                                translateAnimation.setInterpolator(new LinearInterpolator());
//                                translateAnimation.setDuration(17000);
//                                mTongzhi.startAnimation(translateAnimation);
//                            }
//                        });

                    }
                });

                //初始化广告设置
                try {
//                    StaticUtils.isStartVideoAd = Integer.parseInt(homePageBean.getGuanggao().get(0).getType());
//                    StaticUtils.startAd = homePageBean.getGuanggao().get(0).getKaiji_gg();
//                    StaticUtils.endAd = homePageBean.getGuanggao().get(0).getEnd_gg();
                } catch (Exception e) {
                    Log.e("TAA", "广告加载失败：" + e.getMessage());

                }

                for (int i = 0; i < data.size(); i++) {

                    ImageView imageView = null;
                    TextView textView = null;

                    switch (i) {

                        case 0:
                            imageView = (ImageView) ((ViewGroup) findViewById(R.id.view10)).getChildAt(0);
                            textView = (TextView) ((ViewGroup) findViewById(R.id.view10)).getChildAt(1);
                            break;
                        case 1:
                            imageView = (ImageView) ((ViewGroup) findViewById(R.id.view11)).getChildAt(0);
                            textView = (TextView) ((ViewGroup) findViewById(R.id.view11)).getChildAt(1);
                            break;
                        case 2:
                            imageView = (ImageView) ((ViewGroup) findViewById(R.id.view)).getChildAt(0);
                            textView = (TextView) ((ViewGroup) findViewById(R.id.view)).getChildAt(1);
                            break;
                        case 3:
                            imageView = (ImageView) ((ViewGroup) findViewById(R.id.view4)).getChildAt(0);
                            textView = (TextView) ((ViewGroup) findViewById(R.id.view4)).getChildAt(1);
                            break;
                        case 4:
                            imageView = (ImageView) ((ViewGroup) findViewById(R.id.view3)).getChildAt(0);
                            textView = (TextView) ((ViewGroup) findViewById(R.id.view3)).getChildAt(1);
                            break;
                        case 5:
                            imageView = (ImageView) ((ViewGroup) findViewById(R.id.view2)).getChildAt(0);
                            textView = (TextView) ((ViewGroup) findViewById(R.id.view2)).getChildAt(1);
                            break;
                        case 6:
                            imageView = (ImageView) ((ViewGroup) findViewById(R.id.view5)).getChildAt(0);
                            textView = (TextView) ((ViewGroup) findViewById(R.id.view5)).getChildAt(1);
                            break;
                        case 7:
                            imageView = (ImageView) ((ViewGroup) findViewById(R.id.view6)).getChildAt(0);
                            textView = (TextView) ((ViewGroup) findViewById(R.id.view6)).getChildAt(1);
                            break;


                    }

                    final HomePageBean.DataBean dataBean = data.get(i);

                    if (textView != null && imageView != null) {
                        final TextView finalTextView = textView;
                        final ImageView finalImageView = imageView;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                finalTextView.setText(dataBean.getName());
                                if (StaticUtils.isReplace && is_one) {
                                    is_one = false;
                                    Replace();

                                } else if (is_one) {

                                    Glide.with(MainActivity.this)
                                            .load(dataBean.getFm_img())
                                            .skipMemoryCache(true)
                                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                                            .error(R.drawable.bg1)
                                            .into(finalImageView);

                                    Glide.with(MainActivity.this)
                                            .load(homePageBean.getHomebg())
                                            .skipMemoryCache(true)
                                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                                            .error(R.drawable.bg1)
                                            .into(mRootview);
                                }
                            }
                        });


                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        findViewById(R.id.live_progress).setVisibility(View.GONE);
                    }
                });

//                Log.e("TAA","查看"+body+"_______"+vipBean);
            }
        });

    }


    private String shenfa = "http://www.jiayinkeji.xin/shenfa/index.php?cp = xiaoxiangketang";

    public void Replace() {
        Log.e(TAG, "Replace: 更换皮肤执行了");
        KaiJIBean kaiJIBean = StaticUtils.ReplaceJson;

        Glide.with(MainActivity.this)
                .load(kaiJIBean.getPifu().get(0).getBeijing())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.bg1)
                .into(mRootview);
        Glide.with(MainActivity.this)
                .load(kaiJIBean.getPifu().get(0).getPi0())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.bg1)
                .into(image10);
        Glide.with(MainActivity.this)
                .load(kaiJIBean.getPifu().get(0).getPi1())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.bg1)
                .into(image11);
        Glide.with(MainActivity.this)
                .load(kaiJIBean.getPifu().get(0).getPi2())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.bg1)
                .into(image);
        Glide.with(MainActivity.this)
                .load(kaiJIBean.getPifu().get(0).getPi3())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.bg1)
                .into(image4);
        Glide.with(MainActivity.this)
                .load(kaiJIBean.getPifu().get(0).getPi4())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.bg1)
                .into(image3);
        Glide.with(MainActivity.this)
                .load(kaiJIBean.getPifu().get(0).getPi5())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.bg1)
                .into(image2);
        Glide.with(MainActivity.this)
                .load(kaiJIBean.getPifu().get(0).getPi6())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.bg1)
                .into(image5);
        Glide.with(MainActivity.this)
                .load(kaiJIBean.getPifu().get(0).getPi7())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.bg1)
                .into(image6);
        //image10 ,image11,image,image4,image3,image2,image5,image6;

    }

    @Override
    protected void onPause() {
        super.onPause();
        StaticUtils.isHome = false;
        Log.e("TAA", "免onPause" + StaticUtils.isHome);

    }

    @Override
    protected void onResume() {
        super.onResume();
        StaticUtils.isFirst = 1;
        StaticUtils.isHome = true;
        Log.e("TAA", "免onPause" + StaticUtils.isHome);

        try {
            OkHttpUtils.getOkHttp(this, shenfa, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String body = response.body().string();
                    Log.e("TAA", "BODY:" + body);
                    final ShenFaBean shenFaBean = new Gson().fromJson(body, ShenFaBean.class);

                    if (shenFaBean.getTag().equals("0")) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, shenFaBean.getMsg() + "程序将在三秒后退出。", Toast.LENGTH_SHORT).show();
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            Thread.sleep(3000);
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    System.exit(0);

                                                }
                                            });
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).start();

                            }
                        });
                    }

                }
            });

            //版本更新
            checkVersion();
        } catch (Exception e) {

        }

    }


    private String upVersion = BaseUrl.Update_BASE + "updataApp";

    public void checkVersion() {
        OkHttpUtils.getOkHttp(this, upVersion, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.e("TAA", "updataBODY:" + body);
                final VerBean verBean = new Gson().fromJson(body, VerBean.class);
//                final VerBean verBean = gson.fromJson(result, VerBean.class);
                Log.e("VerBean", "返回信息" + verBean.getVerid() + "__________" + VerUtils.getVersion(MainActivity.this) + "_____" + (!(verBean.getVerid().equals(VerUtils.getVersion(MainActivity.this)))));

                if (verBean.getVerid() != null && verBean.getVerid() != "" && !(verBean.getVerid().equals(VerUtils.getVersion(MainActivity.this)))) {//版本不一样 下载 并安装apk


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            VersionParams.Builder builder = new VersionParams.Builder()
                                    .setRequestUrl("http://www.baidu.com")
                                    .setService(DemoService.class);
                            stopService(new Intent(MainActivity.this, DemoService.class));

                            CustomVersionDialogActivity.customVersionDialogIndex = 2;
                            builder.setCustomDownloadActivityClass(CustomVersionDialogActivity.class);
                            CustomVersionDialogActivity.isCustomDownloading = false;
                            builder.setCustomDownloadActivityClass(VersionDialogActivity.class);
                            CustomVersionDialogActivity.isForceUpdate = false;
                            builder.setCustomDownloadActivityClass(CustomVersionDialogActivity.class);
                            builder.setSilentDownload(false);
                            builder.setForceRedownload(true);
                            builder.setOnlyDownload(true)
                                    .setDownloadUrl(verBean.getAddress())
                                    .setTitle("检测到新版本" + verBean.getVerid())
                                    .setUpdateMsg(verBean.getVercontent());
                            builder.setShowNotification(false);
                            builder.setShowDownloadingDialog(true);
                            AllenChecker.startVersionCheck(MainActivity.this, builder.build());

                            Log.e(" TAA", "去下载了？" + verBean.getAddress());
                        }
                    });

                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        //按返回键返回桌面
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    private String verifyUrl = BaseUrl.BASE + "checkLoginState";
    private Handler handler = new Handler();
    String user;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            SharedPreferences sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
            user = sharedPreferences.getString("username", "");
            StaticUtils.user = user;
            //当前设备MAC
            final String mac = MacUtils.getSerial(MainActivity.this);
            //当前设备IP
            String ip = getLocalIp();

            final String ABCD = verifyUrl + "?user=" + user + "&mac=" + mac;

            final String TAG = "你愁啥";
            Log.e(TAG, "run: " + ABCD);
            HttpLonIn.GetOkGttp(MainActivity.this, ABCD, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
//                    Log.e(TAG, "onResponse: "+response.body().string() );
                    String body = response.body().string();

                    Return ren = new Gson().fromJson(body, Return.class);
                    int Tag = ren.getTag();
                    String msg = ren.getMsg();


                    if (Tag == 0) {

                        if (TextUtils.isEmpty(user)) {
                            handler.removeCallbacks(runnable);
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(MainActivity.this, Login.class));
                                    MainActivity.this.finish();
                                    ToastUtils.showToast(MainActivity.this, "您已被顶替");
                                    handler.removeCallbacks(runnable);
                                }
                            });
                        }
                    }
                }
            });
            //每5秒轮询提交一次
            handler.postDelayed(this, 5000);
        }

    };

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
