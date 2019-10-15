package zhihu.iptv.jiayin.xiaoxiangketang;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.chunleikeji.VideoViewActivity;
import com.chunleikeji.bean.JujiBean;
import com.chunleikeji.bean.ScMovieBean;
import com.chunleikeji.bean.ShouCangBean;
import com.chunleikeji.mode.DetailMoviceListPresenter;
import com.chunleikeji.mode.LeanbackTestData;
import com.chunleikeji.tag.TagUtils;
import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.OkHttpUtils;
import com.chunleikeji.util.SPUtils;
import com.chunleikeji.util.StaticUtils;
import com.chunleikeji.view.BlurringView;
import com.chunleikeji.view.DetailTextMoreView;
import com.chunleikeji.view.MoreTextView;
import com.chunleikeji.view.TvButtom;
import com.google.gson.Gson;
import com.open.androidtvwidget.bean.MovieDetailBean;
import com.open.androidtvwidget.bean.Pg_DetailBean;
import com.open.androidtvwidget.leanback.adapter.GeneralAdapter;
import com.open.androidtvwidget.leanback.mode.ItemDetailHeaderPresenter;
import com.open.androidtvwidget.leanback.mode.ItemListPresenter;
import com.open.androidtvwidget.leanback.mode.ListRow;
import com.open.androidtvwidget.leanback.mode.ListRowPresenter;
import com.open.androidtvwidget.leanback.recycle.LinearLayoutManagerTV;
import com.open.androidtvwidget.leanback.recycle.RecyclerViewTV;
import com.open.androidtvwidget.utils.XiaoCuiTag;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;



public class DetailActivity extends Activity {
    private RecyclerViewTV mRecyclerView;
//    private MovieDetailBean movieDetailBean;

    private Pg_DetailBean detailBean;
//    private String getMovieUrl = "http://39.106.60.208/waibao/xiaocuitv/php-article-master/admin/bTabs/php/AdminContoller.php?type=getmovie&id=";

//    private String getDetail = BaseUrl.BASE + "getDetail?id=";

    private DetailTextMoreView detailinfo;
    private TextView addressinfo, daoyan;
    private MoreTextView title;
    private TextView[] zhuyan;
    private ImageView detailImg;
    private FrameLayout progress;

    private void initIds() {
        title = findViewById(R.id.title);
        addressinfo = findViewById(R.id.addressinfo);
        daoyan = findViewById(R.id.daoyan);
        detailinfo = findViewById(R.id.detail);
        detailImg = findViewById(R.id.detail_img);
        zhuyan = new TextView[4];
        zhuyan[0] = findViewById(R.id.zhuyan01);
        zhuyan[1] = findViewById(R.id.zhuyan02);
        zhuyan[2] = findViewById(R.id.zhuyan03);
        zhuyan[3] = findViewById(R.id.zhuyan04);

    }

    BlurringView mBlurringView2;
    BlurringView mBlurringView;
    private PowerManager.WakeLock mWakeLock = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE,DetailActivity.class.getName());
        mWakeLock.acquire();
        setContentView(R.layout.activity_detail);

        init();

    }

    public void init() {
        initIds();
        progress = findViewById(R.id.hold_progress);
        mRecyclerView = (RecyclerViewTV) findViewById(R.id.recyclerView);

        final ImageView imageView = (ImageView) findViewById(R.id.bg_img);
        FrameLayout detail_frame = (FrameLayout) findViewById(R.id.detail_frame);
        //加载模糊视图
        mBlurringView2 = (BlurringView) findViewById(R.id.blurring_view2);
        mBlurringView = (BlurringView) findViewById(R.id.blurring_view);
//        JujiBean jujiBean = list.get(0);
//        Log.e("TAA", "检测URL 哈哈：" + jujiBean.getUrl());
        findViewById(R.id.play_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (detailBean != null && detailBean.getDetail().get(0).getVideo_adr() != null) {
                    //加入历史
                    saveLiShi();
                    Log.e("TAG", "看看播放地址: " + HTTPURL );
//                    JCFullScreenActivity.startActivity(DetailActivity.this,
//                            HTTPURL, JCVideoPlayerStandard.class, "");
//                    overridePendingTransition(0, 0);
                    TagUtils.setList(null);
//                    JujiBean jujiBean = list.get(0);
                    Intent intent = new Intent(DetailActivity.this, VideoViewActivity.class);
//                    Log.e("TAA", "云值URL1检测URL：" + jujiBean.getUrl());
                    intent.putExtra("url", detailBean.getDetail().get(0).getVideo_adr());
                    intent.putExtra("title", detailBean.getDetail().get(0).getName() );
                    StaticUtils.Timelyurl = detailBean.getDetail().get(0).getVideo_adr();
                    if (list != null && list.size() > 1) {
                        TagUtils.setList(list);
                        intent.putExtra("postion", 0);
                    }

                    startActivity(intent);

                }else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(DetailActivity.this,"暂无片源",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });

        findViewById(R.id.jujibutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String bg = detailBean.getDetail().get(0).getFm_img();
//                Log.e("TAA", "点击了" + detailBean.getDetail().get(0).getD_name() + "选集");
                Intent intent = new Intent(DetailActivity.this, XuanJiActivity.class);

                TagUtils.setList(list);

                int bool = bg.indexOf("attachment");
                String imgText = bg;
                if (bool > 0) {
                    imgText = "http://xiaocui.tv" + imgText;
                } else {
                }
                bg = imgText;
                intent.putExtra("title", detailBean.getDetail().get(0).getName() + "选集");
                intent.putExtra("bg", bg);
                if (list.size() > 1) {
                    startActivity(intent);

                }
            }
        });

        findViewById(R.id.sc_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TvButtom myview = ((TvButtom) view);
                if (myview.getText().equals("已收藏")) {
                    return;
                }

                if (detailBean == null) {
                    Toast.makeText(DetailActivity.this, "正在加载", Toast.LENGTH_SHORT).show();
                    return;
                }

                String sc = SPUtils.getSharedStringData(DetailActivity.this, "shoucang");
                ShouCangBean shouCangBean = null;
//                MovieDetailBean.DataBean.InfoBean info = detailBean.getData().get(0).getName();

                ScMovieBean scMovieBean = new ScMovieBean();
                scMovieBean.setTitle(detailBean.getDetail().get(0).getName());
                scMovieBean.setPic(detailBean.getDetail().get(0).getFm_img());
                scMovieBean.setId(detailBean.getDetail().get(0).getId() + "");

                if (sc != null && !"".equals(sc)) {
                    shouCangBean = new Gson().fromJson(sc, ShouCangBean.class);
                    ArrayList<ScMovieBean> movieList = shouCangBean.getMovieList();
                    movieList.add(scMovieBean);
                    shouCangBean.setMovieList(movieList);
                } else {
                    //第一次创建新的
                    shouCangBean = new ShouCangBean();
                    ArrayList<ScMovieBean> list = new ArrayList<ScMovieBean>();
                    list.add(scMovieBean);
                    shouCangBean.setMovieList(list);
//            shouCangBean.getMovieList().add(scMovieBean);
                }
                String gson = new Gson().toJson(shouCangBean, ShouCangBean.class);
                SPUtils.setSharedStringData(DetailActivity.this, "shoucang", gson);
//        Toast.makeText(this, "已收藏", Toast.LENGTH_SHORT).show();
//        ((TextView)view
                myview.setText("已收藏");
            }
        });


        TextView textView = findViewById(R.id.hold_text);
        textView.setText(getIntent().getStringExtra("title"));
        if (XiaoCuiTag.getCaCheBitMap() != null) {
            BlurringView hold_blurring = (BlurringView) findViewById(R.id.hold_blurring);
            ImageView holdImg = (ImageView) findViewById(R.id.hold_img);
            holdImg.setImageBitmap(XiaoCuiTag.getCaCheBitMap());
            hold_blurring.setBlurredView(holdImg);
            hold_blurring.invalidate();
        }
        detail_frame.post(new Runnable() {
            @Override
            public void run() {
                TvButtom play_btn = findViewById(R.id.play_btn);
                play_btn.setFocusable(true);
                play_btn.setFocusableInTouchMode(true);
                play_btn.requestFocus();
                play_btn.requestFocusFromTouch();

            }
        });

        String movieid = getIntent().getStringExtra("movie_id");
        String lishi_id = getIntent().getStringExtra("lishi_id");
        String scurlid = getIntent().getStringExtra("scid");
        String urlid = getIntent().getStringExtra("id");
        if (movieid == null) {
            Log.e("TAG", "init:+ 空的 "  );
            movieid = StaticUtils.movie_id;
        }
        if (lishi_id == null) {
            lishi_id = StaticUtils.movie_id;
        }
        if (scurlid == null) {
            scurlid = StaticUtils.movie_id;
        }
        if (urlid == null){
            urlid = StaticUtils.movie_id;
        }

        String getHttp = null;

        SharedPreferences sharedPreferences = getSharedPreferences("config", MODE_PRIVATE);
        final String user = sharedPreferences.getString("username", "");
        String type = StaticUtils.movie_id;
        String getDetail = BaseUrl.BASE + "getDetail?id=";
        String httpurl = getDetail + type + "&user=" + user;

        if (StaticUtils.lishi) {
            //历史记录来的
            getHttp = getDetail + lishi_id + "&user=" + user;
            Log.e("TAA", "看看是啥啊_走的是这吗_历史：" + getHttp);
        } else if (StaticUtils.shoucang) {
            //收藏记录来的
            getHttp = getDetail + scurlid + "&user=" + user;
            Log.e("TAA", "看看是啥啊_走的是这吗_收藏：" + getHttp);
        } else if (StaticUtils.sphttp) {
            //搜索来的
            getHttp = getDetail + urlid + "&user=" + user;

        } else {
            //全部页来的
            getHttp = getDetail + movieid + "&user=" + user;

        }
        Log.e("TAA", "看看是啥啊_走的是这吗_movieid：" + getHttp);

        OkHttpUtils.getOkHttp(this, getHttp, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String body = response.body().string();
                Log.e("TAA", "BODY:1" + body);
                detailBean = new Gson().fromJson(body, Pg_DetailBean.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (detailBean.getDetail() == null || detailBean.getDetail().size() == 0) {

                            Toast.makeText(DetailActivity.this,"该内容不存在，可能已被管理员删除", Toast.LENGTH_SHORT).show();

                            return;
                        }
                        Log.e("TAA", "都有啥"+"d_name:"+detailBean.getDetail().get(0).getName()+"D_directed:"+detailBean.getDetail().get(0).getCreate_at()+"D_pic:"+detailBean.getDetail().get(0).getVideo_adr());
//                        movieDetailBean.getData().getInfo().ge

                        detailinfo.setInfoBg(detailBean.getDetail().get(0).getVideo_adr().trim());

                        detailinfo.setMoreText(detailBean.getDetail().get(0).getInfo().trim(), 80);
                        title.setText(detailBean.getDetail().get(0).getName().trim());
                        title.startMoreText();
//                        String addressText = detailBean.getDetail().get(0).getD_remarks() + "   " + detailBean.getData().get(0).getD_area().trim() + "   " + detailBean.getData().get(0).getD_year();
//                        addressinfo.setText(addressText);
//                        daoyan.setText(detailBean.getDetail().get(0).getD_directed().trim());
//                        String zhuyanText = detailBean.getDetail().get(0).getD_starring().trim();
//                        String[] split = zhuyanText.split("/");

//                            int bool = detailBean.getData().get(0).getPic().indexOf("attachment");
                        String imgText = detailBean.getDetail().get(0).getFm_img();
//                            if (bool > 0) {
//                                imgText = "http://xiaocui.tv" + imgText;
//                            } else {
//
//                            }

                        //loadBitmap(detailBean.getTuijian());

                        if (null == DetailActivity.this) {
                            return;
                        }

                        try {
                            Glide.with(DetailActivity.this)
                                    .load(imgText)
                                    .error(R.drawable.bg1)
                                    .into(new GlideDrawableImageViewTarget(imageView) {
                                        @Override

                                        public void onResourceReady(GlideDrawable drawable, GlideAnimation anim) {
                                            super.onResourceReady(drawable, anim);
                                            //在这里添加一些图片加载完成的操作

                                            if (imageView != null) {
                                                mBlurringView2.setBlurredView(imageView);
                                                mBlurringView2.invalidate();
                                                mBlurringView.setBlurredView(imageView);
                                                mBlurringView.invalidate();
                                            }

//                                            progress.setVisibility(View.GONE);
                                        }
                                    });
                            progress.setVisibility(View.GONE);
                            Glide.with(DetailActivity.this)
                                    .load(imgText)
                                    .error(R.drawable.defult_movie2)
                                    .into(detailImg);
                        } catch (Exception e) {

                        }
//                        for (int x = 0; x < split.length; x++) {
//
//                            Log.e("TAA", "BODY:" + split[x]);
//
//                            if (x < zhuyan.length) {
//                                zhuyan[x].setText(split[x]);
//                            }
//                        }

                        initShouCang();
                        //加载推荐
                        testLeanbackDemo(detailBean.getList());
                        Log.e("TAG", "run13: " +detailBean.getDetail() );
                        setMovieUrlList();

                    }
                });
            }
        });


    }

    private GeneralAdapter.ViewHolder mSelectedViewHolder;
    List<ListRow> mListRows = new ArrayList<ListRow>();
    ListRowPresenter mListRowPresenter;


    //    Map<String,String> map = new HashMap<>();
    ArrayList<JujiBean> list = new ArrayList<JujiBean>();
    String HTTPURL ;
    public void setMovieUrlList() {
        String url = detailBean.getDetail().get(0).getVideo_adr();

        url = url.replace("ydisk###", "");

        Log.e("TAA", "____内容地址http1111:" + url);
        HTTPURL =  url;
        try {
            String[] strings2 = url.split("#");
//        String[] strings = strings2.split("[$]");

//        Log.e("TAA", "setMovieUrlList2:" +strings[1]);
            int saveid = -1;
            for (int x = 0; x < strings2.length; x++) {
                String[] split = strings2[x].split("[$]");

                list.add(new JujiBean(split[0], split[1]));

                Log.e("TAA", "____内容地址http_:" + split[1]);

            }

            if (list.size() > 1) {

                findViewById(R.id.jujibutton).setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //第一种：普遍使用，二次取值
//        System.out.println("通过Map.keySet遍历key和value：");


    }


    /**
     * Leanback Demo.
     *
     * @param tuijian
     */
    private void testLeanbackDemo(List<Pg_DetailBean.ListBean> tuijian) {


        LinearLayoutManagerTV layoutManager = new LinearLayoutManagerTV(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setSelectedItemAtCentered(true); // 设置item在中间移动.
        // 添加测试数据。
        for (int i = 0; i < 1; i++) {
            String txt = LeanbackTestData.MOVIE_CATEGORY[i];
            // 添加一行的数据.
            ListRow listRow = new ListRow(txt); // 标题头.
//            List<Movie> movies = LeanbackTestData.MOVIE_ITEMS;
            listRow.setOpenPresenter(new DetailMoviceListPresenter(4, null, this)); // 设置列的item样式.
//            if (i % 2 == 1)
//                movies = LeanbackTestData.MOVIE_ITEMS2;
            listRow.addAll(tuijian); // 添加列的数据.
            // 添加一行的数据（标题头，列的数据)
            mListRows.add(listRow);
        }
        mListRowPresenter = new ListRowPresenter(mListRows,
                new ItemDetailHeaderPresenter(24, Color.DKGRAY, 91, 45, 0, 0),
                new ItemListPresenter());

        GeneralAdapter generalAdapter = new GeneralAdapter(mListRowPresenter);


        mRecyclerView.setAdapter(generalAdapter);
        mRecyclerView.setOnChildClick(R.id.dybean, DetailActivity.class, QuanBuActivity.class, ZhuanTiActivity.class);

    }


    private void loadBitmap(final List<MovieDetailBean.DataBean.TuijianBean> movie) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int x = 0; x < (movie.size()); x++) {

//                        FutureTarget<File> future = Glide.with(context)
//                                .load(dyBean.getImg())
//                                .downloadOnly(500, 500);

                    MovieDetailBean.DataBean.TuijianBean dyBean = movie.get(x);
                    Bitmap myBitmap = null;

                    try {
                        String img = dyBean.getPic();
                        int bool = img.indexOf("attachment");
                        String imgText = img;
                        if (bool > 0) {
                            imgText = "http://xiaocui.tv" + imgText;
                        } else {
                        }
                        img = imgText;

                        myBitmap = Glide.with(DetailActivity.this)
                                .load(img)
                                .asBitmap()
                                .centerCrop()
                                .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                                .get();
                        dyBean.setCaCheBitmap(myBitmap);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void saveLiShi() {


        String sc = SPUtils.getSharedStringData(this, "lishi");
        ShouCangBean shouCangBean = null;
//        MovieDetailBean.DataBean.InfoBean info = movieDetailBean.getData().getInfo();


        ScMovieBean scMovieBean = new ScMovieBean();
        scMovieBean.setTitle(detailBean.getDetail().get(0).getName());
        scMovieBean.setPic(detailBean.getDetail().get(0).getFm_img());
        scMovieBean.setId(detailBean.getDetail().get(0).getId() + "");

        if (sc != null && !"".equals(sc)) {
            shouCangBean = new Gson().fromJson(sc, ShouCangBean.class);
            ArrayList<ScMovieBean> movieList = shouCangBean.getMovieList();

            for (int x = 0; x < movieList.size(); x++) {
                ScMovieBean scMovieBean1 = movieList.get(x);

                if (scMovieBean1.getId().equals(scMovieBean.getId())) {
                    break;
                }
            }
            if (movieList.size() != 0) {
                ScMovieBean scMovieBean1 = movieList.get(movieList.size() - 1);

                Log.e("TAA", "添加比对：" + scMovieBean1.getId() + "_______" + scMovieBean.getId());
                if (scMovieBean1.getId().equals(scMovieBean.getId())) {
                    //最后一个重复不添加
                    return;
                }
            }

            movieList.add(scMovieBean);
            shouCangBean.setMovieList(movieList);


        } else {
            //第一次创建新的
            shouCangBean = new ShouCangBean();
            ArrayList<ScMovieBean> list = new ArrayList<ScMovieBean>();
            list.add(scMovieBean);
            shouCangBean.setMovieList(list);
//            shouCangBean.getMovieList().add(scMovieBean);
        }
        String gson = new Gson().toJson(shouCangBean, ShouCangBean.class);
        SPUtils.setSharedStringData(this, "lishi", gson);
//        Toast.makeText(this, "已收藏", Toast.LENGTH_SHORT).show();
//        ((TextView)view
    }

    /**
     * 收藏逻辑
     * 如果有包含的id 那么就设置为已收藏
     */
    public void initShouCang() {
        String sc = SPUtils.getSharedStringData(this, "shoucang");
        if (detailBean == null) {
//            Toast.makeText(this, "还没加载好", Toast.LENGTH_SHORT).show();
            return;
        }

        if (sc != null && !"".equals(sc)) {
            ShouCangBean shouCangBean = new Gson().fromJson(sc, ShouCangBean.class);

            String movieid = detailBean.getDetail().get(0).getId() + "";
            for (int x = 0; x < shouCangBean.getMovieList().size(); x++) {
//                shouCangBean.getMovieList()
                ScMovieBean scMovieBean = shouCangBean.getMovieList().get(x);

                if (movieid.equals(scMovieBean.getId())) {
                    ((TvButtom) findViewById(R.id.sc_id)).setText("已收藏");
//                    Log.e("TAA","查看id："+movieDetailBean.getData().getInfo().getId()+"__________"+scMovieBean.getId());

                }
            }
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {


            case KeyEvent.KEYCODE_BACK:    //返回键
                if (StaticUtils.lishi) {
                    StaticUtils.lishi = false;
                    finish();
                } else if (StaticUtils.shoucang) {
                    StaticUtils.shoucang = false ;
                    Log.e("TAA", "添加比对：" + StaticUtils.shoucang);
                    finish();
                }
                finish();
                return true;


        }
        return super.onKeyDown(keyCode, event);

    }
}