package zhihu.iptv.jiayin.xiaoxiangketang;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chunleikeji.bean.ScMovieBean;
import com.chunleikeji.bean.ShouCangBean;
import com.chunleikeji.util.SPUtils;
import com.chunleikeji.util.StaticUtils;
import com.chunleikeji.view.MoreTextView;
import com.chunleikeji.view.TvButtom2;
import com.google.gson.Gson;
import com.open.androidtvwidget.leanback.mode.ListRow;
import com.open.androidtvwidget.leanback.widget.OpenCardView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import java.util.ArrayList;
import java.util.List;



public class ShouCangActivity extends AppCompatActivity implements View.OnClickListener {
    private GridView movieGrid;
    private TextView title;
    private TvButtom2 upMovie, reSetPwd, canCle;
    private PowerManager.WakeLock mWakeLock = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //无title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE,ShouCangActivity.class.getName());
        mWakeLock.acquire();
        setContentView(R.layout.activity_shou_cang);
        StaticUtils.setActivity(this);
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this,MobclickAgent.EScenarioType.E_UM_NORMAL);
        movieGrid = (GridView) findViewById(R.id.moviegrid);
        title = (TextView) findViewById(R.id.title);
        upMovie = (TvButtom2) findViewById(R.id.upmpvie);
        reSetPwd = (TvButtom2) findViewById(R.id.resetpwd);
        canCle = (TvButtom2) findViewById(R.id.cancle);


        upMovie.setOnClickListener(this);
        reSetPwd.setOnClickListener(this);
        canCle.setOnClickListener(this);
        String gridType = getIntent().getStringExtra("type");

        gridType = "sc";
        if (gridType.equals("sc")) {
            title.setText("收藏列表");
            upMovie.setVisibility(View.GONE);
            reSetPwd.setVisibility(View.GONE);
            //收藏展示 收藏列表

            String sc = SPUtils.getSharedStringData(this, "shoucang");
            if (sc != null) {
                ShouCangBean shouCangBean = new Gson().fromJson(sc, ShouCangBean.class);
                //加载数据
                if(shouCangBean!=null) {
                    initMovieGrid(shouCangBean);
                }
            }

            //判断是否有存储的

        } else {
            title.setText("私人影院");
            canCle.setVisibility(View.GONE);
        }



        //    testLeanbackDemo();
    }

    List<ListRow> mListRows = new ArrayList<ListRow>();


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.resetpwd:
//                Intent intent = new Intent(this, PassWordActivity.class);
//                intent.putExtra("type", "cs");
//                startActivity(intent);
//                overridePendingTransition(R.anim.activity_in, R.anim.activity_over);
                break;
            case R.id.upmpvie:

                break;
            case R.id.cancle:
                //取消收藏
                TvButtom2 tvButtom = ((TvButtom2) view);


                String sc = SPUtils.getSharedStringData(this, "shoucang");
                ShouCangBean shouCangBean = null;
                if (sc != null) {
                    shouCangBean = new Gson().fromJson(sc, ShouCangBean.class);
                }

                if (tvButtom.getText().equals("取消收藏")) {
                    ((TvButtom2) view).setText("管理收藏");
                    if (shouCangBean != null)
                        searchRightGrid.setmDatas(shouCangBean.getMovieList());
                } else {
                    ((TvButtom2) view).setText("取消收藏");
                    if (shouCangBean != null)
                        searchRightGrid.setmDatas(shouCangBean.getMovieList());
                }
                break;

        }
    }

    SearchRightGridViewAdapter searchRightGrid;

    View oldView;

    public void initMovieGrid(ShouCangBean shouCangBean) {

//        List<AllMovieBean.DataBean.DetailBean.MovieBean> movie = allMovieBean.getData().get(0).getDetail().getMovie();
        ArrayList<ScMovieBean> movieList = shouCangBean.getMovieList();
        searchRightGrid = new SearchRightGridViewAdapter(this, movieList);
        movieGrid.setVerticalSpacing(60);
        movieGrid.setAdapter(searchRightGrid);
        movieGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (canCle.getText().equals("管理收藏")) {
//                    convertView.findViewById(R.id.delete_img).setVisibility(View.VISIBLE);
                    //删除数据
                    String sc = SPUtils.getSharedStringData(ShouCangActivity.this, "shoucang");
                    ShouCangBean shouCangBean = null;
                    if (sc != null) {
                        shouCangBean = new Gson().fromJson(sc, ShouCangBean.class);
                        shouCangBean.getMovieList().remove(i);
                        searchRightGrid.setmDatas(shouCangBean.getMovieList());
                        Toast.makeText(ShouCangActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                        String save = new Gson().toJson(shouCangBean, ShouCangBean.class);
                        SPUtils.setSharedStringData(ShouCangActivity.this, "shoucang", save);

                    }

                } else {

                    ScMovieBean movieBean = (ScMovieBean) view.getTag(R.id.dybean);
                    Intent intent = new Intent(ShouCangActivity.this, DetailActivity.class);

                    intent.putExtra("title", movieBean.getTitle());
//                XiaoCuiTag.setCaCheBitMap(dyBean.getCaCheBitmap());

                    intent.putExtra("scid", movieBean.getId());
                    Log.e("TAA", "看看是啥啊_走的是这吗1:" + movieBean.getId());
                    StaticUtils.shoucang = true;
                    startActivity(intent);
                }
            }
        });

        /**
         * 视频选中与未选中
         */
        movieGrid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int[] location = new int[2];
                view.getLocationOnScreen(location);
                Log.e("TAA", "__________" + location[0] + "________" + location[1]);

                view.animate().scaleX(1.1f).scaleY(1.1f).setDuration(300).start();
                MoreTextView viewById = view.findViewById(R.id.moretext);
                OpenCardView parent_img = (OpenCardView) view.findViewById(R.id.img_parent);

                if (parent_img != null) {
                    viewById.startMoreText();
                    Drawable d = getResources().getDrawable(R.drawable.test3);
                    parent_img.setShadowDrawable(d);

                }


                if (oldView != null) {
                    oldView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();

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

        movieGrid.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    if (movieGrid.getChildAt(0) != null && oldView == null) {

                        View view = movieGrid.getChildAt(0);
                          movieGrid.requestFocus();
                         view.requestFocus();
                        view.animate().scaleX(1.1f).scaleY(1.1f).setDuration(300).start();
                        MoreTextView viewById = view.findViewById(R.id.moretext);
                        OpenCardView parent_img = (OpenCardView) view.findViewById(R.id.img_parent);

                        if (parent_img != null) {
                            viewById.startMoreText();
                            Drawable d = getResources().getDrawable(R.drawable.test3);
                            parent_img.setShadowDrawable(d);

//                    parent_img.animate().translationZ(10f).setDuration(300).start();
                        }
                        oldView = view;

                    } else {
                        oldView.animate().scaleX(1.1f).scaleY(1.1f).setDuration(300).start();
                        MoreTextView viewById = oldView.findViewById(R.id.moretext);
                        OpenCardView parent_img = (OpenCardView) oldView.findViewById(R.id.img_parent);

                        if (parent_img != null) {
                            viewById.startMoreText();
                            Drawable d = getResources().getDrawable(R.drawable.test3);
                            parent_img.setShadowDrawable(d);

//                    parent_img.animate().translationZ(10f).setDuration(300).start();
                        }
                    }
                }else{
                    if(oldView!=null){
                        oldView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                    }
                }
            }
        });

        movieGrid.post(new Runnable() {
            @Override
            public void run() {


                Log.e("TAA","当前的:"+movieGrid.getChildCount());
            }
        });


    }


    /**
     * 电影的适配器
     */
    public class SearchRightGridViewAdapter extends BaseAdapter {

        ArrayList<ScMovieBean> mDatas;
        private final LayoutInflater mInflater;

        public SearchRightGridViewAdapter(Context context, ArrayList<ScMovieBean> data) {
            mDatas = data;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public void setmDatas(ArrayList<ScMovieBean> mDatas) {
            this.mDatas = mDatas;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Override
        public Object getItem(int position) {
            return mDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SearchRightGridViewAdapter.ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.movie_item, parent, false);
                convertView.setTag(new SearchRightGridViewAdapter.ViewHolder(convertView));
//                convertView.setFocusable(true);
            }

            viewHolder = (SearchRightGridViewAdapter.ViewHolder) convertView.getTag();
            ScMovieBean movieBean = mDatas.get(position);
            ((TextView) convertView.findViewById(R.id.moretext)).setText(movieBean.getTitle());

            convertView.setTag(R.id.dybean, movieBean);
            ImageView my_img = (ImageView) convertView.findViewById(R.id.my_img);

            int bool = movieBean.getPic().indexOf("attachment");
            String imgText = movieBean.getPic();
            if (bool > 0) {
                imgText = "http://xiaocui.tv" + imgText;
            } else {

            }
//
//            if(){
//
//            }
//            bg =  imgText;

            Glide.with(convertView.getContext())
                    .load(imgText)
                    .error(R.drawable.defult_movie2)
                    .into(my_img);
//            bindViewData(position, viewHolder);
//            convertView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    AllMovieBean.DataBean.DetailBean.MovieBean movieBean = (AllMovieBean.DataBean.DetailBean.MovieBean) view.getTag(R.id.dybean);
//                    Intent intent = new Intent(AllMovieActivity.this,DetailActivity.class);
//                    intent.putExtra("type","dy");
//                    intent.putExtra("title", movieBean.getTitle());
////                XiaoCuiTag.setCaCheBitMap(dyBean.getCaCheBitmap());
//
//                    intent.putExtra("movie_id",movieBean.getId());
//                    startActivity(intent);
//                }
//            });

            View deleteView =  convertView.findViewById(R.id.delete_img);
            if (canCle.getText().equals("管理收藏")) {
                deleteView.setVisibility(View.VISIBLE);
            } else {
                deleteView.setVisibility(View.INVISIBLE);
            }

            return convertView;
        }


        class ViewHolder {
            ImageView fm;
            MoreTextView titleTv;
            OpenCardView cardView;

            public ViewHolder(View view) {
//                this.itemView = view;
//                this.titleTv = (TextView) view.findViewById(R.id.movie_text);
                this.cardView = (OpenCardView) view;
                this.titleTv = view.findViewById(R.id.moretext);
                this.fm = view.findViewById(R.id.my_img);
            }
        }
    }
}
