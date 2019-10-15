package com.chunleikeji;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.chunleikeji.ActivityClass.ActivityCollector;
import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.ClassSaveUtils;
import com.chunleikeji.util.OkHttpUtils;
import com.chunleikeji.util.StaticUtils;
import com.chunleikeji.util.TimelyBean;
import com.chunleikeji.xiangxianglib.R;
import com.google.gson.Gson;
import com.umeng.commonsdk.UMConfigure;
import com.yhao.floatwindow.PermissionListener;
import com.yhao.floatwindow.ViewStateListener;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by wh on 2018/2/28.
 */

public class ZhiHuApp extends Application {


    ViewStateListener mViewStateListener = new ViewStateListener() {
        @Override
        public void onPositionUpdate(int i, int i1) {

        }

        @Override
        public void onShow() {

        }

        @Override
        public void onHide() {

        }

        @Override
        public void onDismiss() {

        }

        @Override
        public void onMoveAnimStart() {

        }

        @Override
        public void onMoveAnimEnd() {

        }

        @Override
        public void onBackToDesktop() {

        }
    };
    private PermissionListener mPermissionListener = new PermissionListener() {
        @Override
        public void onSuccess() {

        }

        @Override
        public void onFail() {

        }
    };
    View tongzhiView;

    public OkHttpClient getmHttpClient() {
        return mHttpClient;
    }

    public void setmHttpClient(OkHttpClient mHttpClient) {
        this.mHttpClient = mHttpClient;
    }

    OkHttpClient mHttpClient;
    boolean isEliminate;
    Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_BOX, "5d521d1a0cafb2686700081b");

        mHttpClient = new OkHttpClient();

        LayoutInflater inflater = LayoutInflater.from(this);

        //调用inflate加载mybutton.xml布局，返回的是按钮布局的view实例
        tongzhiView = inflater.inflate(R.layout.tongzhi, null);


        //     imageView.setImageResource(R.drawable.icon);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int heigth = dm.heightPixels;
        int width = dm.widthPixels;
//        FloatWindow
//                .with(getApplicationContext())
//                .setView(tongzhiView)
//                .setWidth(width) //设置悬浮控件宽高
//                .setHeight(Screen.height, 0.2f)
//                .setX(0)
//                .setY(0)
//                .setMoveType(MoveType.slide, 100, -100)
//                .setMoveStyle(500, new BounceInterpolator())
//                .setFilter(true, MainActivity.class, QuanBuActivity.class,DetailActivity.class,ZhuanTiActivity.class,SearchActivity.class,VideoViewActivity.class,ShouCangActivity.class)
//                .setViewStateListener(mViewStateListener)
//                .setPermissionListener(mPermissionListener)
//                .setDesktopShow(true)
//                .setTag("new")
//                .build();
//
//        FloatWindow.get("new").hide();

//开启循环去请求

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    while (true) {
//                        Log.e("TAG", "无限循环正在执行中"  );
                        loadZiMuData();
                        Thread.sleep(10000);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.e("justh", "onActivityCreated");


            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.w("justh", "onActivityStarted");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.e("justh", "onActivityResumed");
                if (isShow) {
//                    FloatWindow.get("new").show();

                } else {
//                    FloatWindow.get("new").hide();

                }
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.i("justh", "onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.i("justh", "onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Log.i("justh", "onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });

//        new Handler(Looper.getMainLooper()).post(new Runnable() {
//            @Override
//            public void run() {
//                //主线程异常拦截
//                while (true) {
//
//
//                    try {
//                        Looper.loop();//主线程的异常会从这里抛出
//                    } catch (Throwable e) {
//                        Log.e("TAG", "异常run: "+e );
//                    }
//                }
//            }
//        });
//
//        Thread.UncaughtExceptionHandler sUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
//        //所有线程异常拦截，由于主线程的异常都被我们catch住了，所以下面的代码拦截到的都是子线程的异常
//        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread t, Throwable e) {
//                Log.e("TAG", "uncaughtException12: " + t+"___:"+e );
//            }
//        });
    }


    String saveTime = "";


    /**
     * false 为不显示
     * true 为显示
     */
    private boolean isShow;
    int oneTag = 0;
    int twoTag = 0;
    int threeTag = 0;

    int dataID;
    TimelyBean tongzhiBean;
    DateFormat sdf = new SimpleDateFormat("HH:mm");

    public void loadZiMuData() {
        String user = StaticUtils.user;
        if (!TextUtils.isEmpty(user)) {
            String zimuUrl = BaseUrl.BASE + "getDingShi?user=" + user;
            Log.e("TAG", "loadZiMuData: " + zimuUrl);
            OkHttpUtils.getOkHttp(this, zimuUrl, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String body = response.body().string();

                    Log.e("TAA", "判断：json：" + body);
                    tongzhiBean = new Gson().fromJson(body, TimelyBean.class);


                    Log.e("TAG", "onResponse: " + StaticUtils.time + "__________:" + tongzhiBean.getTime());

                    // +"_____;"+ tongzhiBean.getGroup().get(oneTag).get(0).getData().size()
                    String time = StaticUtils.time;
                    //!StaticUtils.time.equals(tongzhiBean.getTime())
                    if ("1".equals(tongzhiBean.getIs_xh())) {
                        Log.e("TAA", "判断_1：是否循环1：" + tongzhiBean.getIs_xh());
                        StaticUtils.Timelyisxh = false;

                    } else if ("0".equals(tongzhiBean.getIs_xh())) {
                        Log.e("TAA", "判断_2：是否循环2：" + tongzhiBean.getIs_xh());
                        StaticUtils.Timelyisxh = true;

                    }
                    if (time == null) {
                        StaticUtils.time = "00:00";
                    }

                    if (tongzhiBean.getTag() == 1 && tongzhiBean.getGroup() != null) {
                        try {
                            if (sdf.parse(StaticUtils.time).getTime() != sdf.parse(tongzhiBean.getTime()).getTime()) {


                                StaticUtils.time = tongzhiBean.getTime();
                                StaticUtils.TimelyNews = true;
                                StaticUtils.jishiBean = tongzhiBean;
                                dataID = tongzhiBean.getJinbo().getId();
                                if (tongzhiBean.getGroup() != null) {
                                    if (oneTag < tongzhiBean.getGroup().size()) {
                                        a:
                                        for (int i = oneTag; i < tongzhiBean.getGroup().size(); i++) {
                                            if (twoTag > tongzhiBean.getGroup().get(oneTag).size()) {
                                                oneTag += 1;
                                            } else {
                                                Log.e("TAG", "onCompletion: 播放完毕执行了2" + oneTag + "___:" + twoTag + "____:" + threeTag);
                                                for (int j = twoTag; j <= tongzhiBean.getGroup().get(oneTag).size(); j++) {
                                                    if (threeTag >= tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().size()) {
                                                        Log.e("TAG", "onCompletion: 播放完毕执行了查看" + oneTag + "___:" + tongzhiBean.getGroup().size());
                                                        if (oneTag >= (tongzhiBean.getGroup().size() - 1)) {
                                                            oneTag = 0;
                                                            twoTag = 0;
                                                            threeTag = 0;
                                                            Log.e("TAG", "onCompletion: 播放完毕执行了重新");
                                                            return;
                                                        } else {
                                                            oneTag += 1;
                                                            twoTag = 0;
                                                            threeTag = 0;
                                                            Log.e("TAG", "onCompletion: 播放完毕执行了继续");
                                                            continue a;
                                                        }
                                                    } else {
                                                        Log.e("TAG", "onCompletion: 播放完毕执行了3" + oneTag + "___:" + twoTag + "____:" + threeTag);
                                                        for (int k = threeTag; k < tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().size(); k++) {
                                                            if (tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().get(threeTag).getName() != null) {
                                                                Log.e("TAG", "onCompletion: 播放完毕执行了4" + oneTag + "___:" + twoTag + "____:" + threeTag);
                                                                skip();
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                    } else {
                                        oneTag = 0;
                                        twoTag = 0;
                                        threeTag = 0;
                                    }
                                }
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    } else {
                        for (int i = 0; i < tongzhiBean.getJinbo().getData().size(); i++) {
                            if (dataID == tongzhiBean.getJinbo().getData().get(i).getId()) {
                                Log.e("TAG", "onResponse12: " + dataID + "___:" + tongzhiBean.getJinbo().getData().get(i).getStatus());
                                if (!"1".equals(tongzhiBean.getJinbo().getData().get(i).getStatus())) {
                                    ActivityCollector.finishAll();
                                }
                            }

                        }
                    }
                    String dir = Environment.getExternalStorageDirectory() + "/xiaoxiangketnag";
                    if ("1".equals(tongzhiBean.getGroup())) {

                        if (isEliminate) {
                            isEliminate = false;
                            delete(dir);
                        }
                    } else {
                        isEliminate = true;
                    }


                }
            });
        }
    }

    public void skip() {
        Log.e("TAG", "skipAPP: " + oneTag + "___:" + twoTag + "____:" + threeTag);
        ActivityCollector.finishAll();
        if ("0".equals(tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().get(threeTag).getIs_video())) {
            //图片
            StaticUtils.imgId = tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().get(threeTag).getId();
            StaticUtils.TimelyOne = oneTag;
            StaticUtils.TimelyTwo = twoTag;
            StaticUtils.TimelyThree = threeTag;

            Intent intent1 = new Intent(ZhiHuApp.this, ClassSaveUtils.CarouselImgActivity);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent1);
            StaticUtils.time = tongzhiBean.getTime();
        } else {
            //视频
            Intent intent = new Intent(getApplicationContext(), VideoViewActivity.class);
            StaticUtils.Timelyurl = tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().get(threeTag).getVideo_adr();
            intent.putExtra("url", tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().get(threeTag).getVideo_adr());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            StaticUtils.TimelyOne = oneTag;
            StaticUtils.TimelyTwo = twoTag;
            StaticUtils.TimelyThree = threeTag;
            startActivity(intent);
            StaticUtils.time = tongzhiBean.getTime();
        }
    }


    /**
     * 删除文件，可以是文件或文件夹
     *
     * @param delFile 要删除的文件夹或文件名
     * @return 删除成功返回true，否则返回false
     */
    private boolean delete(String delFile) {
        File file = new File(delFile);
        if (!file.exists()) {
            Toast.makeText(getApplicationContext(), "已无缓存", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            if (file.isFile())
                return deleteSingleFile(delFile);
            else
                return deleteDirectory(delFile);
        }
    }

    /**
     * 删除单个文件
     *
     * @param filePath$Name 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    private boolean deleteSingleFile(String filePath$Name) {
        File file = new File(filePath$Name);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                Log.e("--Method--", "Copy_Delete.deleteSingleFile: 删除单个文件" + filePath$Name + "成功！");
                return true;
            } else {
                Toast.makeText(getApplicationContext(), "删除单个文件" + filePath$Name + "失败！", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(getApplicationContext(), "删除单个文件失败：" + filePath$Name + "不存在！", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    /**
     * 删除目录及目录下的文件
     *
     * @param filePath 要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    private boolean deleteDirectory(String filePath) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!filePath.endsWith(File.separator))
            filePath = filePath + File.separator;
        File dirFile = new File(filePath);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            Toast.makeText(getApplicationContext(), "删除目录失败：" + filePath + "不存在！", Toast.LENGTH_SHORT).show();
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (File file : files) {
            // 删除子文件
            if (file.isFile()) {
                flag = deleteSingleFile(file.getAbsolutePath());
                if (!flag)
                    break;
            }
            // 删除子目录
            else if (file.isDirectory()) {
                flag = deleteDirectory(file
                        .getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            Toast.makeText(getApplicationContext(), "删除目录失败！", Toast.LENGTH_SHORT).show();
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            Log.e("--Method--", "Copy_Delete.deleteDirectory: 删除目录" + filePath + "成功！");
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "删除目录：" + filePath + "失败！", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
