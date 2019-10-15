package zhihu.iptv.jiayin.xiaoxiangketang;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chunleikeji.bean.BzBean;
import com.chunleikeji.network.view.AllMovieRecyclerView;
import com.chunleikeji.util.OkHttpUtils;
import com.chunleikeji.view.TvButtom2;
import com.google.gson.Gson;
import com.open.androidtvwidget.leanback.adapter.GeneralAdapter;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import zhihu.iptv.jiayin.xiaoxiangketang.Adapter.HuaRecyclerViewPresenter;


public class SheZhiActivity extends Activity implements View.OnClickListener {

    private AllMovieRecyclerView mSelectRecycler;
    private TvButtom2 mSetting;

    private LinearLayout mTest;
    private FrameLayout mParent;
    private WebView mBangzhustr;
    /**
     * 帮助中心
     */
    private TextView mBiaoti;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_she_zhi);
        initView();

        TvButtom2 mSetting = findViewById(R.id.xitongshezhi);
        mSetting.setOnClickListener(this);

        findViewById(R.id.test).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                //    Log.e("TAA", "嗷嗷嗷：" + hasFocus);

            }
        });


        findViewById(R.id.parent).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {

                    int tagInt = getIntent().getIntExtra("tag", 0);
                    mSelectRecycler.getChildAt(tagInt).setFocusable(true);
                    mSelectRecycler.getChildAt(tagInt).setFocusableInTouchMode(true);
                    mSelectRecycler.getChildAt(tagInt).requestFocus();
                    mSelectRecycler.getChildAt(tagInt).requestFocusFromTouch();
                }
            }
        });

        String viptag = getIntent().getStringExtra("viptag");
        String viptext = getIntent().getStringExtra("viptext");


//        initMovieGrid();


        OkHttpUtils.getOkHttp(this, bangzhuUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();



                userInfo = new Gson().fromJson(body, BzBean.class);

                if (userInfo == null || userInfo.getData() == null || userInfo.getData().get(0) == null) {
                    return;
                }

                bz = findViewById(R.id.bangzhustr);
                bz.setBackgroundColor(0);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        bz.loadData(userInfo.getData().get(0).getContent(), "text/html;charset=utf-8","utf-8");
                    }
                });

//                allMovieBean = new Gson().fromJson(body, AllMovieBean.class);
                final String[] arr = new String[userInfo.getData().size()];
                for (int x = 0; x < arr.length; x++) {
                    arr[x] = userInfo.getData().get(x).getTitle();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initData(arr);
                    }
                });


            }
        });


    }

    private String bangzhuUrl = "http://39.96.198.153/ZhihuAdmin/chuanbojiekou/think_test/public/index.php/index/index/getbangzhu";

    BzBean userInfo;
    HuaRecyclerViewPresenter mRecyclerViewPresenter;
    GeneralAdapter mGeneralAdapter;

    WebView bz;

    private void initData(String[] arrStr) {


        mSelectRecycler = (AllMovieRecyclerView) findViewById(R.id.selectRecycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mSelectRecycler.setLayoutManager(layoutManager);

        mRecyclerViewPresenter = new HuaRecyclerViewPresenter(this, arrStr, null, R.layout.allmovie_select_item, R.id.title_tv);
        mGeneralAdapter = new GeneralAdapter(mRecyclerViewPresenter);
        mSelectRecycler.setAdapter(mGeneralAdapter);
//
        mRecyclerViewPresenter.setOnItemFocu(new HuaRecyclerViewPresenter.OnItemFocu() {
            @Override
            public void onItemFocuse(int position, View view, boolean focuse) {

                if (focuse) {
                    view.setBackgroundResource(R.drawable.xian);
//                    if(position==0){
//                        ((TextView)findViewById(R.id.biaoti)).setText("记录");
//                    }else{
//                        ((TextView)findViewById(R.id.biaoti)).setText("收藏");
//                    }
                    if (userInfo != null) {
                        bz = findViewById(R.id.bangzhustr);
                        String str = "";
                        str = userInfo.getData().get(position).getContent();

                        final String finalStr = str;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                bz.loadData(finalStr+"", "text/html;charset=utf-8","utf-8");
                            }
                        });
                    }
                } else {
                    view.setBackgroundResource(0);
                }
            }
        });
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


    private void initView() {

        mTest = (LinearLayout) findViewById(R.id.test);
        mSelectRecycler = (AllMovieRecyclerView) findViewById(R.id.selectRecycler);
        mParent = (FrameLayout) findViewById(R.id.parent);
        mBangzhustr = (WebView) findViewById(R.id.bangzhustr);
        mBiaoti = (TextView) findViewById(R.id.biaoti);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;

            case R.id.xitongshezhi:
                Intent intent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
                break;

        }
    }
}
