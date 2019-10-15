package zhihu.iptv.jiayin.xiaoxiangketang;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chunleikeji.ActivityClass.ActivityCollector;
import com.chunleikeji.VideoViewActivity;
import com.chunleikeji.bean.CarouselBean;
import com.chunleikeji.bean.QuanBuBean;
import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.OkHttpUtils;
import com.chunleikeji.util.StaticUtils;
import com.chunleikeji.util.TimelyBean;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.nostra13.universalimageloader.core.ImageLoader;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoaderInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class CarouselImgActivity extends Activity {
    Banner CarouselImg;
    private PowerManager.WakeLock mWakeLock = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE,CarouselImgActivity.class.getName());
        mWakeLock.acquire();

        setContentView(R.layout.activity_carousel_img);
        ActivityCollector.addActivity(this);
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        initView();
        init();
    }

    public void initView() {
        CarouselImg = findViewById(R.id.CarouselImg);
    }

    List<String> list = new ArrayList<>();
    int item;
    int imgindex;
    //定位数据下标
    int oneTag;
    int twoTag;
    int threeTag;
    //因监听滑动方法会执行多次 ，因此需要阻止
    int ending;

    TimelyBean tongzhiBean = StaticUtils.jishiBean;

    public void init() {

        final int imgID = StaticUtils.imgId;
        ending = 0;
        String url = BaseUrl.BASE + "getImgList?id=" + imgID;
        Log.e("TAG", "onResponse12: " +  url);
        OkHttpUtils.getOkHttp(this, url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String body = response.body().string();
                Log.e("TAG", "onResponse: " + "____:" + call);
                CarouselBean cmsBean = null;
                try {
                    cmsBean = new Gson().fromJson(body, CarouselBean.class);
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
                final CarouselBean finalCmsBean = cmsBean;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Log.e("TAG", "run轮播间隔时间: " + finalCmsBean.getParent().get(0).getSudu());
                        int dataItem = Integer.parseInt(finalCmsBean.getParent().get(0).getSudu());


                        if (TextUtils.isEmpty(finalCmsBean.getData().size() + "")) {
                            Toast.makeText(CarouselImgActivity.this, "暂无资源,请联系管理员", Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            for (int i = 0; i < finalCmsBean.getData().size(); i++) {
                                list.add(finalCmsBean.getData().get(i).getFm_img());
                                Log.e("TAG", "轮播图: " + list.get(i));
                            }

                            if (TextUtils.isEmpty(dataItem + "")) {
                                dataItem = 3;
                                CarouselImg.setImageLoader(new MyLoader());
                                CarouselImg.setImages(list);
                                CarouselImg.setDelayTime(dataItem * 1000);
                                CarouselImg.isAutoPlay(true);
                                CarouselImg.start();


                            } else {
                                CarouselImg.setImageLoader(new MyLoader());
                                CarouselImg.setImages(list);
                                CarouselImg.setDelayTime(dataItem * 1000);
                                CarouselImg.isAutoPlay(true);
                                CarouselImg.start();


                            }
                        }
                        imgindex = StaticUtils.nextIndex;
                        final int finalDataItem = dataItem;
                        CarouselImg.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


                            @Override
                            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                                Log.e("TAG", "onPageSelected1: " + position);
                                if (finalCmsBean.getData().size() == position && ending != position) {
                                    ending = position;

                                    mHandler.postDelayed(runnable,  finalDataItem * 1000);

                                }
                            }

                            @Override
                            public void onPageSelected(int position) {
                                Log.e("TAG", "onPageSelected2: " + position);


                            }

                            @Override
                            public void onPageScrollStateChanged(int state) {
                                Log.e("TAG", "onPageSelected3: " + state);
                                if (state == 2) {
//                                    CarouselImg.isAutoPlay(false);
                                    CarouselImg.stopAutoPlay();
                                    Log.e("TAG", "onPageSelected3: 执行了停止");
                                } else if (state == 0) {
//                                    CarouselImg.isAutoPlay(true);
                                    CarouselImg.startAutoPlay();
                                    Log.e("TAG", "onPageSelected3: 执行了滑动");
                                }
                            }
                        });


                    }


                });

            }
        });

    }
    Handler mHandler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
                    if (StaticUtils.isSear) {
                    } else {
                        if (StaticUtils.TimelyNews) {
                            oneTag = StaticUtils.TimelyOne;
                            twoTag = StaticUtils.TimelyTwo;
                            threeTag = StaticUtils.TimelyThree;

                            threeTag += 1;
                            Log.e("TAG", "onCompletion: 轮播完毕执行了1" + oneTag + "___:" + twoTag + "____:" + threeTag);
                            if (tongzhiBean.getGroup() != null) {
                                if (oneTag < tongzhiBean.getGroup().size()) {
                                    a:
                                    for (int i = oneTag; i < tongzhiBean.getGroup().size(); i++) {
                                        if (twoTag > tongzhiBean.getGroup().get(oneTag).size()) {
                                            oneTag += 1;

                                        } else {
                                            Log.e("TAG", "onCompletion: 轮播完毕执行了2" + oneTag + "___:" + twoTag + "____:" + threeTag);
                                            for (int j = twoTag; j < tongzhiBean.getGroup().get(oneTag).size(); j++) {
                                                if (threeTag >= tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().size()) {
                                                    if (oneTag >= (tongzhiBean.getGroup().size() - 1)) {
                                                        oneTag = 0;
                                                        twoTag = 0;
                                                        threeTag = 0;
                                                        Log.e("TAG", "onCompletion: 播放完毕执行了重新");
                                                        restart();
                                                        return;
                                                    } else {
                                                        oneTag += 1;
                                                        twoTag = 0;
                                                        threeTag = 0;
                                                        Log.e("TAG", "onCompletion: 播放完毕执行了继续");
                                                        continue a;
                                                    }
                                                } else {
                                                    Log.e("TAG", "onCompletion: 轮播完毕执行了3" + oneTag + "___:" + twoTag + "____:" + threeTag);

                                                    for (int k = threeTag; k < tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().size(); k++) {
                                                        if (tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().get(threeTag).getName() != null) {
                                                            Log.e("TAG", "onCompletion: 轮播完毕执行了4" + oneTag + "___:" + twoTag + "____:" + threeTag);
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
                        } else {

                            QuanBuBean quanBuBean = StaticUtils.dataBase;
                            int tag = StaticUtils.showBarIndex;

                            imgindex += 1;
                            Log.e("TAG", "onPageSelected1: " + quanBuBean.getData().get(tag).getData().size() + "___:" + imgindex);
                            if (imgindex >= quanBuBean.getData().get(tag).getData().size()) {
                                imgindex = 0;
                                Log.e("TAG", "onPageScrolled11: " + imgindex);
                            }

                            Log.e("TAG", "onPageScrolled11: " + imgindex);
                            if ("0".equals(quanBuBean.getData().get(tag).getData().get(imgindex).getIs_video())) {

                                Intent intent = new Intent(CarouselImgActivity.this, CarouselImgActivity.class);
                                StaticUtils.imgId = quanBuBean.getData().get(tag).getData().get(imgindex).getId();
                                StaticUtils.nextIndex = imgindex;
                                startActivity(intent);
                                finish();

                            } else {

                                Intent intent = new Intent(CarouselImgActivity.this, VideoViewActivity.class);
                                intent.putExtra("url", quanBuBean.getData().get(tag).getData().get(imgindex).getVideo_adr());
                                StaticUtils.nextIndex = imgindex;
                                startActivity(intent);
                                finish();

                            }
                        }
                    }

        }
    };

     public void skip() {
        Log.e("TAG", "skipImg: " + oneTag + "___:" + twoTag + "____:" + threeTag);

        if ("0".equals(tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().get(threeTag).getIs_video())) {
            Intent intent = new Intent(CarouselImgActivity.this, CarouselImgActivity.class);
            StaticUtils.imgId = tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().get(threeTag).getId();
            StaticUtils.TimelyOne = oneTag;
            StaticUtils.TimelyTwo = twoTag;
            StaticUtils.TimelyThree = threeTag;
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();

        } else {
            Intent intent = new Intent(CarouselImgActivity.this, VideoViewActivity.class);
            intent.putExtra("url", tongzhiBean.getGroup().get(oneTag).get(twoTag).getData().get(threeTag).getVideo_adr());
            StaticUtils.TimelyOne = oneTag;
            StaticUtils.TimelyTwo = twoTag;
            StaticUtils.TimelyThree = threeTag;
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();

        }


    }

    public void restart() {
        Log.e("TAG", "restart: " +  StaticUtils.Timelyisxh);
        if (StaticUtils.Timelyisxh) {
            for (int i = oneTag; i < tongzhiBean.getGroup().size(); i++) {
                for (int j = twoTag; j < tongzhiBean.getGroup().get(i).size(); j++) {
                    for (int k = threeTag; k < tongzhiBean.getGroup().get(i).get(j).getData().size(); k++) {
                        if (tongzhiBean.getGroup().get(i).get(j).getData().get(k).getName() != null) {
                            oneTag = i;
                            twoTag = j;
                            threeTag = k;
                            skip();
                            return;
                        }
                    }
                }
            }
        } else {
            startActivity(new Intent(CarouselImgActivity.this,MainActivity.class));
            ActivityCollector.finishAll();
        }
    }

    private class MyLoader extends ImageLoader implements ImageLoaderInterface {


        @Override
        public void displayImage(Context context, Object path, View imageView) {
            Glide.with(context).load((String) path).into((ImageView) imageView);
        }

        @Override
        public View createImageView(Context context) {
//            Toast.makeText(CarouselImgActivity.this,"执行了",Toast.LENGTH_LONG).show();

            return null;
        }

    }

    /**
     * 倒计时60秒，一次1秒
     */
    CountDownTimer timer = new CountDownTimer(item * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub
            Log.e("TAG", "onFinish__________:" + millisUntilFinished);
        }

        @Override
        public void onFinish() {
//            Toast.makeText(CarouselImgActivity.this,"执行了",Toast.LENGTH_LONG).show();
            Log.e("TAG", "onFinish: 执行了" + item);
        }
    }.start();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Log.e("TAG", "onFinish: 执行了返回键");
            if (StaticUtils.VideoSkip) {
                finish();
            }
            if (StaticUtils.TimelyNews) {
                return true;
            }
        mHandler.removeCallbacks(runnable);
            finish();
            return super.onKeyDown(keyCode, event);
        } else  {

            return super.onKeyDown(keyCode, event);
        }
    }


}
