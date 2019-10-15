package zhihu.iptv.jiayin.xiaoxiangketang;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chunleikeji.bean.QuanBuBean;
import com.chunleikeji.network.view.AllMovieRecyclerView;
import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.OkHttpUtils;
import com.chunleikeji.util.StaticUtils;
import com.chunleikeji.view.BlurringView;
import com.chunleikeji.view.MoreTextView;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.open.androidtvwidget.leanback.adapter.GeneralAdapter;
import com.open.androidtvwidget.leanback.mode.ListRow;
import com.open.androidtvwidget.leanback.mode.ListRowPresenter;
import com.open.androidtvwidget.leanback.widget.OpenCardView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import zhihu.iptv.jiayin.xiaoxiangketang.Adapter.RecyclerViewPresenter;
import zhihu.iptv.jiayin.xiaoxiangketang.Adapter.SearchRightGridViewAdapter;


public class QuanBuActivity extends Activity {
    private AllMovieRecyclerView mSelectRecycler, mGridRecycler;
    private GridView mMovieRecycler;
    private BlurringView mBlurringView;
    private LinearLayout holdProgress;
    private PowerManager.WakeLock mWakeLock = null;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE,QuanBuActivity.class.getName());
        mWakeLock.acquire();
        setContentView(R.layout.activity_quan_bu);
        StaticUtils.setActivity(this);
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        mSelectRecycler = (AllMovieRecyclerView) findViewById(R.id.selectRecycler);
        mMovieRecycler = (GridView) findViewById(R.id.movieRecycler);
        mMovieRecycler.setSelector(new ColorDrawable(Color.TRANSPARENT));
        holdProgress = findViewById(R.id.live_progress);
        findViewById(R.id.search_btn).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    view.animate().scaleY(1.3f).scaleX(1.3f).setDuration(300).start();
                    findViewById(R.id.search_bg).setBackgroundResource(R.drawable.key_bg_rectangle2);
                    ((TextView) findViewById(R.id.search_text)).setTextColor(Color.BLACK);
                } else {
                    view.animate().scaleY(1.0f).scaleX(1.0f).setDuration(300).start();
                    findViewById(R.id.search_bg).setBackgroundResource(R.drawable.key_bg_rectangle);
                    ((TextView) findViewById(R.id.search_text)).setTextColor(Color.WHITE);

                    if (mSelectRecycler.getChildAt(0) != null) {
                        mSelectRecycler.getChildAt(0).setFocusable(true);
                        mSelectRecycler.getChildAt(0).setFocusableInTouchMode(true);
                        mSelectRecycler.getChildAt(0).requestFocus();
                        mSelectRecycler.getChildAt(0).requestFocusFromTouch();

                    }

                }
            }
        });

        loadData();


    }


    QuanBuBean firstDataBean;

    /**
     * 加载更多
     */
    public void firstLoad(String id, String start, final int postion, final SearchRightGridViewAdapter searchRightGrid) {
        Intent intent = getIntent();
        String str = intent.getStringExtra("data");

        final String loadMoreUrl = BaseUrl.BASE + "yingshiqb?video_type=" + str;
        Log.e("TAA", "测试数据加载_全部页：" + str);
        OkHttpUtils.getOkHttp(this, loadMoreUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                firstDataBean = new Gson().fromJson(body, QuanBuBean.class);

                Log.e("TAA", "测试数据加载：" + firstDataBean);
                if (firstDataBean.getData().get(0).getData() != null) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            searchRightGrid.setmDatas(firstDataBean.getData().get(0).getData(), firstDataBean.getData().get(0).getName());

                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(QuanBuActivity.this, "暂无片源", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });


    }

    String is_video;

    /**
     * 加载更多
     * <p>
     * loadMoreData(searchRightGrid.getId(), i2 + "", postion, (SearchRightGridViewAdapter) absListView.getAdapter());
     */
    public void loadMoreData(String id, String start, final int postion, final SearchRightGridViewAdapter searchRightGrid) {
        String user = StaticUtils.user;
//       BaseUrl.BASE+ getall_movie_updata?id=5&start=20
        final String moreUlr = BaseUrl.BASE + "getall_movie_updata?id=" + id + "&start=" + start +"&user="+user;


        Log.e("TAA", "接下来的链接：" + moreUlr);
        OkHttpUtils.getOkHttp(this, moreUlr, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String body = response.body().string();
                Log.e("TAA", "测试数据加载-返回json：" + body + "_____url:" + moreUlr);


                final QuanBuBean.DataBeanX cmsBean = new Gson().fromJson(body, QuanBuBean.DataBeanX.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        for (int x = 0; x < firstDataBean.getData().size(); x++) {
                            String cms_xid = firstDataBean.getData().get(x).getName();

                            Log.e("TAA", "BEAN0:" + cms_xid + "_______id:" + cmsBean);

                            if (cms_xid.equals(cmsBean.getName())) {
                                firstDataBean.getData().get(x).getData().addAll(cmsBean.getData());
                                searchRightGrid.setmDatas(firstDataBean.getData().get(x).getData(), firstDataBean.getData().get(x).getName());

//                                Log.e("TAA", "BEAN:成功了:" +firstDataBean.getData().get(x).getCms().getCms_data()+"Cms_xid:"+ firstDataBean.getData().get(x).getCms().getCms_xid());
                                break;
                            }
                        }


                    }
                });
            }
        });
    }

    int tag;

    public void gettag(int tag) {

        this.tag = tag;

    }

    private View mOldView;
    SearchRightGridViewAdapter searchRightGrid;
    View oldView;

    public void initMovieGrid() {

        searchRightGrid = new SearchRightGridViewAdapter(this, null, null);
        mMovieRecycler.setVerticalSpacing(60);
        mMovieRecycler.setAdapter(searchRightGrid);
        mMovieRecycler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("TAA", "卧槽点击了！" + i + "___:" + tag);
                StaticUtils.nextIndex = i;
                StaticUtils.showBarIndex = tag;

                if ("0".equals(firstDataBean.getData().get(tag).getData().get(i).getIs_video())) {
                    Log.e("TAA", "卧槽点击了去图片！");
                    Intent intent = new Intent(QuanBuActivity.this, CarouselImgActivity.class);
                    intent.putExtra("imgId", firstDataBean.getData().get(tag).getData().get(i).getId());

                    StaticUtils.imgId = firstDataBean.getData().get(tag).getData().get(i).getId();
                    startActivity(intent);
                    StaticUtils.TimelyNews = false;
                } else {
                    Log.e("TAA", "卧槽点击了正常全部！");
                    Log.e("TAA", "点击了！");
                    StaticUtils.sphttp = false;
                    QuanBuBean.DataBeanX.DataBean movieBean = (QuanBuBean.DataBeanX.DataBean) view.getTag(R.id.dybean);
                    Intent intent = new Intent(QuanBuActivity.this, DetailActivity.class);
                    intent.putExtra("type", "dy");
                    intent.putExtra("title", movieBean.getName());
                    Log.e("TAG", "onItemClick: " + movieBean.getId());
                    intent.putExtra("movie_id", movieBean.getId());
                    StaticUtils.movie_id = movieBean.getId() + "";
                    startActivity(intent);

                }
            }
        });

        mSelectRecycler.post(new Runnable() {
            @Override
            public void run() {

                int tagInt = getIntent().getIntExtra("tag", 0);

                try {
                    mSelectRecycler.getChildAt(tagInt).setFocusable(true);
                    mSelectRecycler.getChildAt(tagInt).setFocusableInTouchMode(true);
                    mSelectRecycler.getChildAt(tagInt).requestFocus();
                    mSelectRecycler.getChildAt(tagInt).requestFocusFromTouch();
                    holdProgress.setVisibility(View.GONE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mMovieRecycler.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {

                    mMovieRecycler.post(new Runnable() {
                        @Override
                        public void run() {
                            mMovieRecycler.getChildAt(0).setBackgroundResource(R.drawable.border_color2);
//                            mMovieRecycler.getChildAt(0).animate().scaleX(1.1f).scaleY(1.1f).setDuration(300).start();
                            MoreTextView viewById = mMovieRecycler.getChildAt(0).findViewById(R.id.moretext);
                            OpenCardView parent_img = (OpenCardView) mMovieRecycler.getChildAt(0).findViewById(R.id.img_parent);
                            mMovieRecycler.scrollTo(0, 0);
                            if (parent_img != null) {
                                viewById.startMoreText();
                                Drawable d = getResources().getDrawable(R.drawable.test3);
                                parent_img.setShadowDrawable(d);

                            }


                            mMovieRecycler.setSelection(0);

                            oldView = mMovieRecycler.getChildAt(0);

                        }
                    });
                    Log.e("TAA", "看着来这了！");

//                    }
                }

            }
        });

        mMovieRecycler.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

                Log.e("TAA", "测试滚动onScrollStateChanged：" + i);

            }

            private boolean lock;

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {


                if (i == (i2 - 12) && !lock) {

                    Toast.makeText(QuanBuActivity.this, "正在加载，稍候更精彩1。", Toast.LENGTH_SHORT).show();
                    String id = ((SearchRightGridViewAdapter) absListView.getAdapter()).getId();

                    int postion = ((SearchRightGridViewAdapter) absListView.getAdapter()).getPostion();

                    loadMoreData(searchRightGrid.getId(), i2 + "", postion, (SearchRightGridViewAdapter) absListView.getAdapter());
                    lock = true;
                } else if (i != (i2 - 12)) {
                    lock = false;
                }

            }
        });
        /**
         * 视频选中与未选中
         */
        mMovieRecycler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //  int[] location = new int[2];
                //    view.getLocationOnScreen(location);
                if (oldView == view) {
                    oldView = null;
                }

                Log.e("TAG", "onItemSelected: " + i);
//                view.animate().scaleX(1.1f).scaleY(1.1f).setDuration(300).start();
                view.setBackgroundResource(R.drawable.border_color2);
                MoreTextView viewById = view.findViewById(R.id.moretext);
                OpenCardView parent_img = (OpenCardView) view.findViewById(R.id.img_parent);

                Log.e("TAA", "监听选中：已选中");
                if (parent_img != null) {
                    viewById.startMoreText();
                    Drawable d = getResources().getDrawable(R.drawable.test3);
                    parent_img.setShadowDrawable(d);

                }


                if (oldView != null) {
//                    oldView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                    oldView.setBackgroundResource(R.drawable.border_color1);
                    viewById = (MoreTextView) oldView.findViewById(R.id.moretext);
                    parent_img = (OpenCardView) oldView.findViewById(R.id.img_parent);

                    if (parent_img != null) {
                        viewById.hintMoreText();
                        Drawable b = getResources().getDrawable(R.drawable.asdfgh);
                        parent_img.setShadowDrawable(b);

                    }
                }
                oldView = view;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private GeneralAdapter.ViewHolder mSelectedViewHolder;
    List<ListRow> mListRows = new ArrayList<ListRow>();
    ListRowPresenter mListRowPresenter;
    ArrayList idList = new ArrayList();

    RecyclerViewPresenter mRecyclerViewPresenter;
    GeneralAdapter mGeneralAdapter;

    /**
     * 测试LinerLayout.
     */
    private void testRecyclerViewLinerLayout(int orientation) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(orientation);
//        mRecyclerView.set

        mSelectRecycler.setLayoutManager(layoutManager);
        mRecyclerViewPresenter = new RecyclerViewPresenter(this, firstDataBean, searchRightGrid, QuanBuActivity.this);
        mGeneralAdapter = new GeneralAdapter(mRecyclerViewPresenter);
        mSelectRecycler.setAdapter(mGeneralAdapter);

        mSelectRecycler.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Log.e("TAA", "_setOnFocusChangeListener______________" + b);

                if (b) {
//                    Log.e("TAA", "_setOnFocusChangeListener____22__________" + mSelectRecycler.getFocusedChild());

                    mSelectRecycler.getChildAt(mRecyclerViewPresenter.getTag()).requestFocus();
                    Log.e("TAA", "_setOnFocusChangeListener______________" + mRecyclerViewPresenter.getTag());
                } else {
//                    Log.e("TAA", "_setOnFocusChangeListener____11__________" + mSelectRecycler.getFocusedChild()+"______________");

                }
            }
        });


        //定位跳转
        mSelectRecycler.post(new Runnable() {
            @Override
            public void run() {
                int tagInt = getIntent().getIntExtra("tag", 0);
                mSelectRecycler.getChildAt(tagInt).setFocusable(true);
                mSelectRecycler.getChildAt(tagInt).setFocusableInTouchMode(true);
                mSelectRecycler.getChildAt(tagInt).requestFocus();
                mSelectRecycler.getChildAt(tagInt).requestFocusFromTouch();
            }


        });


    }


    public void getMovieData(String url) {

    }


    public void onSearch(View view) {
        startActivity(new Intent(QuanBuActivity.this, SearchActivity.class));
//        Toast.makeText(this, "该功能正在调整中...", Toast.LENGTH_SHORT).show();
    }


    ArrayList<Map<String, String>> dataBase;

    //加载数据 先都加载出来 每一个12个 获取所有的数量
//    private String allMovieUrl = "http://39.106.60.208/waibao/xiaocuitv/php-article-master/admin/bTabs/php/AdminContoller.php?type=getalldata";
//    private AllMovieBean allMovieBean;

    public void loadData() {

        dataBase = new ArrayList<Map<String, String>>();

        List<String> ids = Arrays.asList(getResources().getStringArray(R.array.movie_id));
        final List<String> names = Arrays.asList(getResources().getStringArray(R.array.movie_name));


        //填充
//        for (int x = 0; x < ids.size(); x++) {
//            Map<String, String> map = new HashMap<String, String>();
//            map.put(names.get(x), ids.get(x));
//            dataBase.add(map);
//        }
        Intent intent = getIntent();
        String str = intent.getStringExtra("data");
        String user = StaticUtils.user;
        String loadMoreUrl = BaseUrl.BASE + "getVideoAndImage?type=" + str + "&user=" + user;
        Log.e("TAA", "走的是这吗_全部页：" + ",________:" + loadMoreUrl );

        OkHttpUtils.getOkHttp(this, loadMoreUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
//                allMovieBean = new Gson().fromJson(body, AllMovieBean.class);


                try {
                    firstDataBean = new Gson().fromJson(body, QuanBuBean.class);
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
                Log.e("TAA", "first data:" + firstDataBean);

                StaticUtils.dataBase = firstDataBean;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //     Toast.makeText(QuanBuActivity.this, "" + allMovieBean.getData().size(), Toast.LENGTH_SHORT).show();

                        try {
                            Log.e("TAA", "看看：" + firstDataBean.getData().get(0).getData() + "，看看是啥：" + firstDataBean.getData().get(0).getName());
                            if (firstDataBean.getData().get(0).getData() != null) {
                                initMovieGrid();
                                testRecyclerViewLinerLayout(LinearLayoutManager.VERTICAL);
                                searchRightGrid.setmDatas(firstDataBean.getData().get(0).getData(), firstDataBean.getData().get(0).getName());
                            }
                        } catch (Exception e) {

                            Toast.makeText(QuanBuActivity.this, "暂无片源", Toast.LENGTH_LONG).show();

                            e.printStackTrace();
                        }

                    }
                });


            }
        });

    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK ) {
//
//            return true;
//        } else
//            return super.onKeyDown(keyCode, event);
//
//    }

}
