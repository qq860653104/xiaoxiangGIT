package zhihu.iptv.jiayin.xiaoxiangketang;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.chunleikeji.bean.JujiBean;
import com.chunleikeji.bean.ScMovieBean;
import com.chunleikeji.bean.ShouCangBean;
import com.chunleikeji.playvideo.IjkPlayActivity;
import com.chunleikeji.tag.TagUtils;
import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.SPUtils;
import com.chunleikeji.view.BlurringView;
import com.google.gson.Gson;
import com.umeng.commonsdk.UMConfigure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class XuanJiActivity extends Activity {

    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter adapter;
    View oldView;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuan_ji);
        gridView = (GridView) findViewById(R.id.gridview);
        UMConfigure.setLogEnabled(true);
//        final ImageView imageView =(ImageView) findViewById(R.id.bg_img);
        final BlurringView mBlurringView = (BlurringView) findViewById(R.id.blurring_view);
        final TextView title = (TextView) findViewById(R.id.jujititle);

        String imgText = getIntent().getStringExtra("bg");
        final String titleText = getIntent().getStringExtra("title");

        title.setText(titleText);

//        View blurredView = ((Activity)context).findViewById(R.id.recyclerView);
        //给出了模糊视图并刷新模糊视图。
//        Glide.with(XuanJiActivity.this)
//                .load(imgText)
//                .error(R.drawable.defult_movie2)
//                .into(new GlideDrawableImageViewTarget(imageView) {
//                    @Override
//                    public void onResourceReady(GlideDrawable drawable, GlideAnimation anim) {
//                        super.onResourceReady(drawable, anim);
//                        //在这里添加一些图片加载完成的操作
//                        mBlurringView.setBlurredView(imageView);
//                        mBlurringView.invalidate();
//                    }
//                });


        //初始化数据
        initData();


        String[] from = {"text"};

        int[] to = {R.id.text};

        adapter = new SimpleAdapter(this, dataList, R.layout.juji_item, from, to);
        text = findViewById(R.id.text);
        gridView.setAdapter(adapter);


        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(XuanJiActivity.this, "i:"+i, Toast.LENGTH_SHORT).show();
//                Drawable d = view.getResources().getDrawable(R.drawable.episode_focus_bg);
//                view.setBackgroundResource(R.drawable.episode_focus_bg);
//                ((LinearLayout)view).setsd
//                view.setBackground(d);
                view.setBackgroundColor(Color.WHITE);

                if (oldView != null) {

                    oldView.setBackgroundColor(Color.TRANSPARENT);
//                    oldView.setba
                }
                oldView = view;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

//                Drawable d = view.getResources().getDrawable(R.drawable.episode_focus_bg);
//                view.setBackground(d);

            }
        });
        gridView.post(new Runnable() {
            @Override
            public void run() {
                gridView.getChildAt(0).setBackgroundColor(Color.WHITE);
                oldView = gridView.getChildAt(0);
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Log.e("TAA", i + "__________________" + l);
                String jiStr = titleText + "第" + (i + 1) + "集";
                JujiBean jujiBean = TagUtils.list.get(i);
                saveLiShi(jiStr, jujiBean, i);


                Intent intent = new Intent(XuanJiActivity.this, IjkPlayActivity.class);
                intent.putExtra("playurl", jujiBean.getUrl());
                String url = getIntent().getStringExtra("baseUrl");
                intent.putExtra("baseUrl", url);
                intent.putExtra("is", "false");
                Log.e("TAA", i + "__________________" + jujiBean.getUrl());
                intent.putExtra("postion", i);
                intent.putExtra("title", "第" + (i + 1) + "集");
                startActivity(intent);
                finish();
            }
        });


        gridView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
//                    gridView.getChildAt(0).requestFocus();
                    gridView.getChildAt(0).setFocusable(true);
                    gridView.getChildAt(0).setFocusableInTouchMode(true);
                    gridView.getChildAt(0).requestFocus();
                    gridView.getChildAt(0).requestFocusFromTouch();
                }
            }
        });

    }

    void initData() {

        dataList = new ArrayList<Map<String, Object>>();
        //图标下的文字
        for (int x = 0; x < TagUtils.list.size(); x++) {
            String name = TagUtils.list.get(x).getName();
            String url = TagUtils.list.get(x).getUrl();
            String http = BaseUrl.BASE + "playerJiekou?url=";
            Log.e("TAA", "播放URL：" + http + url);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("text", name);
            map.put("url", http + url);
            dataList.add(map);
        }


        int length = TagUtils.list.get(0).getName().length();
        if (length >= 6) {
            gridView.setNumColumns(5);
            gridView.setColumnWidth(180);
        }
//        String name[]={"时钟","信号","宝箱","秒钟","大象","FF","记事本","书签","印象","商店","主题","迅雷"};
//        for (int i = 0; i <name.length; i++) {
//            Map<String, Object> map=new HashMap<String, Object>();
//            map.put("text",name[i]);
//            dataList.add(map);
//        }
    }


    public void saveLiShi(String title, JujiBean jujiBean, int i) {


        String sc = SPUtils.getSharedStringData(this, "lishi");
        ShouCangBean shouCangBean = null;
//        MovieDetailBean.DataBean.InfoBean info = movieDetailBean.getData().getInfo();


//        String img = dyBean.getPic();
        String imgText = getIntent().getStringExtra("bg");
        String id = getIntent().getStringExtra("id");

        ScMovieBean scMovieBean = new ScMovieBean();
        scMovieBean.setTitle(title);
        scMovieBean.setPic(imgText);
        scMovieBean.setPostion(i);
        if (jujiBean != null) {
            scMovieBean.setUrl(jujiBean.getUrl());
        }
        scMovieBean.setId(id + "");

        if (sc != null && !"".equals(sc)) {
            shouCangBean = new Gson().fromJson(sc, ShouCangBean.class);
            ArrayList<ScMovieBean> movieList = shouCangBean.getMovieList();

            for (int x = 0; x < movieList.size(); x++) {
                ScMovieBean scMovieBean1 = movieList.get(x);

                if (scMovieBean1.getId().equals(scMovieBean.getId())) {
                    //删除原来的 增加 新的
                    movieList.remove(scMovieBean1);
                    movieList.add(scMovieBean);
                    break;
                }
            }
            if (movieList.size() != 0) {
                ScMovieBean scMovieBean1 = movieList.get(movieList.size() - 1);

                Log.e("TAA", "添加比对：" + scMovieBean1.getId() + "_______" + scMovieBean.getId());
                if (scMovieBean1.getId().equals(scMovieBean.getId())) {
                    //最后一个重复不添加
                    movieList.remove(scMovieBean1);
                    movieList.add(scMovieBean);
                    shouCangBean.setMovieList(movieList);
                    String gson = new Gson().toJson(shouCangBean, ShouCangBean.class);
                    SPUtils.setSharedStringData(this, "lishi", gson);
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


    public String getRealUrl(String base, String folder) {


        if ((base.indexOf("jpg") != -1 || base.indexOf("png") != -1 || base.indexOf("jpeg") != -1) && folder != null && !(base.indexOf("http") != -1)) {
//                echo "ok";
            base = "http://www.uljf.cn/vod/image/pic/" + folder + "/thumb/" + base;

        } else {
            if (base == null || "".equals(base)) {
                base = "http://www.uljf.cn/vod/image/phpvod/nopic.gif";
            }

        }


        Log.e("TAA", "图片检测：" + base);

        return base;
    }


}
