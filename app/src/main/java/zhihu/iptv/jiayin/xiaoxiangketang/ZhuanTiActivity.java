package zhihu.iptv.jiayin.xiaoxiangketang;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chunleikeji.mode.MoviceListPresenter;
import com.chunleikeji.util.OkHttpUtils;
import com.chunleikeji.util.StaticUtils;
import com.google.gson.Gson;
import com.open.androidtvwidget.bean.ZhuanTiBean;
import com.open.androidtvwidget.leanback.adapter.GeneralAdapter;
import com.open.androidtvwidget.leanback.mode.ItemDetailHeaderPresenter;
import com.open.androidtvwidget.leanback.mode.ItemHeaderPresenter;
import com.open.androidtvwidget.leanback.mode.ItemListPresenter;
import com.open.androidtvwidget.leanback.mode.ListRow;
import com.open.androidtvwidget.leanback.mode.ListRowPresenter;
import com.open.androidtvwidget.leanback.recycle.LinearLayoutManagerTV;
import com.open.androidtvwidget.leanback.recycle.RecyclerViewTV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class ZhuanTiActivity  extends Activity {

    private RecyclerViewTV mRecyclerView;
    private ImageView bgImg;
    private TextView currentText,toText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuan_ti);
        StaticUtils.setActivity(this);

        mRecyclerView = (RecyclerViewTV) findViewById(R.id.recyclerView);
        currentText = (TextView) findViewById(R.id.current_text);
        toText = (TextView) findViewById(R.id.group_text);
        bgImg = (ImageView) findViewById(R.id.bg_img);

        String bgUlr =  getIntent().getStringExtra("bg_img");
        Log.e("TAA","专题背景:222:"+bgUlr);

        if(bgUlr!=null) {
            Log.e("TAA","专题背景:222加载了:"+bgUlr);

            Glide.with(ZhuanTiActivity.this)
                    .load(bgUlr)
                    .error(R.drawable.defult_movie2)
                    .into(bgImg);
        }

        loadData(getIntent().getStringExtra("id"));

//        testLeanbackDemo();
    }

    public String getMovieUrl=   "http://39.96.198.153/ZhihuAdmin/chuanbojiekou/think_test/public/index.php/index/index/getzhuanti";

    public void loadData(String movieid){
        getMovieUrl+= "?id="+getIntent().getStringExtra("id")+"&type="+ getIntent().getStringExtra("type");



        Log.e("TAA","专题url："+getMovieUrl);
        OkHttpUtils.getOkHttp(this, getMovieUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String body = response.body().string();
                Log.e("TAA", "BODY:" + body);
                final ZhuanTiBean zhuanTiBean = new Gson().fromJson(body, ZhuanTiBean.class);




                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        movieDetailBean.getData().getInfo().ge
                        Log.e("TAA","获取的背景:"+body);
//                        if(zhuanTiBean.getBg()!=null){
//                            //处理轮播图 跳转无图
                            Glide.with(ZhuanTiActivity.this)
                                    .load(zhuanTiBean.getBg())
                                    .error(R.drawable.defult_movie2)
                                    .into(bgImg);
//                        }
                        testLeanbackDemo(zhuanTiBean);
                    }
                });
            }
        });
    }

    private GeneralAdapter.ViewHolder mSelectedViewHolder;
    List<ListRow> mListRows = new ArrayList<ListRow>();
    ListRowPresenter mListRowPresenter;

    /**
     * Leanback Demo.
     * @param zhuanTiBean
     */
    private void testLeanbackDemo(ZhuanTiBean zhuanTiBean) {

        toText.setText("/"+zhuanTiBean.getData().size()+"");

        LinearLayoutManagerTV layoutManager = new LinearLayoutManagerTV(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setSelectedItemAtCentered(true); // 设置item在中间移动.
        // 添加测试数据。
        for (int i = 0; i < 1; i++) {
            String txt = "ASD";
            // 添加一行的数据.
            ListRow listRow = new ListRow(txt); // 标题头.
//            List<ZhuanTiBean.DataBean> data = zhuanTiBean.getData();
            List<ZhuanTiBean.DataBean> movies =  zhuanTiBean.getData();
//            ZhuanTiBean.DataBean  gd = new ZhuanTiBean.DataBean();
//            gd.setTag("gd");
//            movies.add(gd);
            listRow.setOpenPresenter(new MoviceListPresenter(currentText)); // 设置列的item样式.
//                listRow.setHeaderItem(null);



            listRow.addAll(movies); // 添加列的数据.

            // 添加一行的数据（标题头，列的数据)
            mListRows.add(listRow);
        }
        mListRowPresenter = new ListRowPresenter(mListRows,
                new ItemDetailHeaderPresenter(31, Color.WHITE,16,47,89,12,ItemHeaderPresenter.XLIE),
                new ItemListPresenter());

        GeneralAdapter generalAdapter = new GeneralAdapter(mListRowPresenter);


        mRecyclerView.setAdapter(generalAdapter);


        mRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.getChildAt(0).requestFocus();
            }
        });



//       mRecyclerView.setOnItemClickListener(new RecyclerViewTV.OnItemClickListener() {
//           @Override
//           public void onItemClick(RecyclerViewTV parent, View itemView, int position) {
//               ZhuanTiBean.DataBean movie = (ZhuanTiBean.DataBean) itemView.getTag();
//               Intent intent = new Intent(ZhuanTiActivity.this,DetailActivity.class);
//               intent.putExtra("type", "dy");
//               intent.putExtra("title", movie.getTitle());
//
//               intent.putExtra("movie_id", movie.getId());
//               startActivity(intent);
//           }
//       });

        mRecyclerView.setOnChildClick(R.id.dybean,DetailActivity.class,QuanBuActivity.class,ZhuanTiActivity.class);


        // 行选中的事件.
//        mRecyclerView.setOnChildViewHolderSelectedListener(mRowSelectedListener);
        // 更新数据测试.
//        handler.sendEmptyMessageDelayed(10, 6666);
    }

}
