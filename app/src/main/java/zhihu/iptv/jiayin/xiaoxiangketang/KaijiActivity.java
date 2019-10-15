package zhihu.iptv.jiayin.xiaoxiangketang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.chunleikeji.bean.KaiJIBean;
import com.chunleikeji.login.JudgeActivity;
import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.ClassSaveUtils;
import com.chunleikeji.util.OkHttpUtils;
import com.chunleikeji.util.StaticUtils;
import com.google.gson.Gson;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class KaijiActivity extends Activity {
    VideoView videoview;
    ImageView ivImg;
    FrameLayout kaijiVideo ,kaijiiMG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kaiji);
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.get(KaijiActivity.this).clearDiskCache();
            }
        }).start();
        initView();
        ClassSaveUtils.MainActivity = MainActivity.class;
    }

    private void initView() {
        videoview = (VideoView) findViewById(R.id.Video_View);
        ivImg = (ImageView) findViewById(R.id.ivImg);
        kaijiVideo = findViewById(R.id.kaijiVideo);
        kaijiiMG = findViewById(R.id.kaiji);
        videoview.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(android.media.MediaPlayer mediaPlayer) {
                startActivity(new Intent(KaijiActivity.this, JudgeActivity.class));
                finish();
            }
        });

//        setTimerForConnect();
        processRequest();
    }

    String kaijiurl = BaseUrl.BASE + "kaijiJson";

    private void processRequest() {
        Log.e("TAA", "请求地址：" + kaijiurl);

        //判断本地是不是有图片有的话就用
        String saveAdr = "/mnt/sdcard/saveimg.png";
        final File f = new File(saveAdr);
        if (f.exists()) {
            //有本地图片就用本地图
            nativeLoadImg(f);
            Log.e("TAA", "大调02：没走网络了");
            //然后去下载图片
            try {
                network(0);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            //没图片就去请求网络
            try {
                Log.e("TAA", "大调02：走网络了");

                network(1);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private void network(final int tag) throws IOException {
        OkHttpUtils.getOkHttp(KaijiActivity.this, kaijiurl, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        ll_loading.setVisibility(View.VISIBLE);
                        Log.e("TAA", "你瞅啥 走网络连接失败");
                        Toast.makeText(KaijiActivity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.e("TAA", "你瞅啥1" + response.body());

                String body = response.body().string();

                final KaiJIBean kaiJIBean = new Gson().fromJson(body, KaiJIBean.class);

                Log.e("TAA", "你瞅啥" + kaiJIBean.getRestype());

                if (kaiJIBean.getPifu().size() != 0) {
                    Log.e("TAG", "onResponse1: 更改"  );
                    StaticUtils.isReplace = true;
                    StaticUtils.ReplaceJson = kaiJIBean;
                    if ("1".equals(kaiJIBean.getRestype())) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("TAA", "你瞅啥开机动画");
                                kaijiVideo.setVisibility(View.VISIBLE);
                                videoview.setVideoPath(kaiJIBean.getPifu().get(0).getShipin());
                                videoview.start();
                            }
                        });
                    } else{
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("TAA", "你瞅啥开机图片");
                                kaijiiMG.setVisibility(View.VISIBLE);
                                ivImg.setVisibility(View.VISIBLE);

                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        File file = null;
                                        try {
                                            final String url = kaiJIBean.getPifu().get(0).getTupian();
                                            String saveAdr = "/mnt/sdcard/saveimg.png";
                                            final File f = new File(saveAdr);
                                            //不存在去下载。存在去使用
                                            if (tag == 1) {
                                                new Thread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        try {
                                                            File file2 = Glide.with(KaijiActivity.this)
                                                                    .load(url)
                                                                    .downloadOnly(1280, 720)
                                                                    .get();
                                                            copy(file2, f);
                                                        } catch (InterruptedException e) {
                                                            e.printStackTrace();
                                                        } catch (ExecutionException e) {
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                }).start();
                                                firstLoadImg(url, f);
                                                Log.e("TAA", "大调02：第一次下载");
                                            } else {
                                                new Thread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        try {
                                                            File file2 = Glide.with(KaijiActivity.this)
                                                                    .load(url)
                                                                    .downloadOnly(1280, 720)
                                                                    .get();
                                                            copy(file2, f);
                                                        } catch (InterruptedException e) {
                                                            e.printStackTrace();
                                                        } catch (ExecutionException e) {
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                }).start();
                                                Log.e("TAA", "大调01：去更新图片了");
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).start();
                            }
                        });
                }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            findViewById(R.id.live_progress).setVisibility(View.GONE);
                        }

                    });
                }else {
                    Log.e("TAG", "onResponse1: 原有"  );
                    StaticUtils.isReplace = false;
                    if ("1".equals(kaiJIBean.getRestype())) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("TAA", "你瞅啥 开机动画");
//                            startActivity(new Intent(KaijiActivity.this, JudgeActivity.class));
                                kaijiVideo.setVisibility(View.VISIBLE);
                                videoview.setVideoPath(kaiJIBean.getVideourl());
                                videoview.start();

                            }
                        });

                    } else{

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("TAA", "你瞅啥 开机图片");
                                kaijiiMG.setVisibility(View.VISIBLE);
                                ivImg.setVisibility(View.VISIBLE);

                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {

                                        File file = null;
                                        try {
                                            final String url = kaiJIBean.getImageurl();
                                            String saveAdr = "/mnt/sdcard/saveimg.png";
                                            final File f = new File(saveAdr);

                                            //不存在去下载。存在去使用
                                            if (tag == 1) {
                                                new Thread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        try {
                                                            File file2 = Glide.with(KaijiActivity.this)
                                                                    .load(url)
                                                                    .downloadOnly(1280, 720)
                                                                    .get();
                                                            copy(file2, f);
                                                        } catch (InterruptedException e) {
                                                            e.printStackTrace();
                                                        } catch (ExecutionException e) {
                                                            e.printStackTrace();
                                                        }

                                                    }
                                                }).start();
                                                firstLoadImg(url, f);
                                                Log.e("TAA", "大调02：第一次下载");

                                            } else {
                                                new Thread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        try {
                                                            File file2 = Glide.with(KaijiActivity.this)
                                                                    .load(url)
                                                                    .downloadOnly(1280, 720)
                                                                    .get();
                                                            copy(file2, f);
                                                        } catch (InterruptedException e) {
                                                            e.printStackTrace();
                                                        } catch (ExecutionException e) {
                                                            e.printStackTrace();
                                                        }

                                                    }
                                                }).start();


                                                Log.e("TAA", "大调01：去更新图片了");
                                            }

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    }
                                }).start();


                            }
                        });
                }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            findViewById(R.id.live_progress).setVisibility(View.GONE);
                        }

                    });


                }

            }


        });
    }

    private void nativeLoadImg(final File f) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Glide.with(KaijiActivity.this)
                        .load(f)
                        .listener(new RequestListener<File, GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, File model, Target<GlideDrawable> target, boolean isFirstResource) {
                                //图片加载失败
                                try {
                                    f.delete();
                                    KaijiActivity.this.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            startActivity(new Intent(KaijiActivity.this, JudgeActivity.class));
                                            finish();
                                        }
                                    });
                                } catch (Exception err) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                f.delete();
                                                KaijiActivity.this.runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        startActivity(new Intent(KaijiActivity.this, JudgeActivity.class));
                                                        finish();
                                                    }
                                                });
                                            } catch (Exception e1) {

                                            }
                                        }
                                    });
                                }
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(GlideDrawable resource, File model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            Thread.sleep(5000);
                                            KaijiActivity.this.runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    startActivity(new Intent(KaijiActivity.this, JudgeActivity.class));
                                                    finish();
                                                }
                                            });
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).start();
                                return false;
                            }
                        })
                        .placeholder(R.drawable.kj_bg)
                        .into(ivImg);


                Log.e("TAA", "使用了本地:");
            }
        });
    }

    private void firstLoadImg(final String url, final File f) {


        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Log.e("TAA", "使用了下载图链接;:" + url);

                Glide.with(KaijiActivity.this)
                        .load(url)
                        .listener(new RequestListener<String, GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                try {
//                                    Thread.sleep(5000);
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                Thread.sleep(5000);
                                                KaijiActivity.this.runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        startActivity(new Intent(KaijiActivity.this, JudgeActivity.class));
                                                        finish();
                                                    }
                                                });
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }).start();

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                return false;
                            }
                        })
                        .into(ivImg);

//


                Log.e("TAA", "使用了下载图:");
            }
        });
    }

    /**
     * 复制文件
     *
     * @param source 输入文件
     * @param target 输出文件
     */
    public void copy(File source, File target) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(source);
            fileOutputStream = new FileOutputStream(target);
            byte[] buffer = new byte[1024];
            while (fileInputStream.read(buffer) > 0) {
                fileOutputStream.write(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
