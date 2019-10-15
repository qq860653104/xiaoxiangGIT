package zhihu.iptv.jiayin.xiaoxiangketang;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.AlertDialog;
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
import com.open.androidtvwidget.leanback.widget.OpenCardView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import java.util.ArrayList;
import java.util.Collections;


//历史记录
public class LishiJiLuActivity extends AppCompatActivity implements View.OnClickListener {
    private GridView movieGrid;
    private TextView title;
    private TvButtom2 canCle;
    private PowerManager.WakeLock mWakeLock = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE,LishiJiLuActivity.class.getName());
        mWakeLock.acquire();
        setContentView(R.layout.activity_lishi_ji_lu);

        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this,MobclickAgent.EScenarioType.E_UM_NORMAL);
        movieGrid = (GridView) findViewById(R.id.moviegrid);
        title = (TextView) findViewById(R.id.title);
        canCle = (TvButtom2) findViewById(R.id.cancle);

        canCle.setOnClickListener(this);
        canCle.requestFocus();
        title.setText("历史记录");

        //收藏展示 收藏列表
        String sc = SPUtils.getSharedStringData(this, "lishi");
        if (sc != null) {
            ShouCangBean shouCangBean = new Gson().fromJson(sc, ShouCangBean.class);
            //加载数据
            if (shouCangBean != null) {
                initMovieGrid(shouCangBean);
            }
        }

        //判断是否有存储的


        //    testLeanbackDemo();
    }

    @Override
    protected void onResume() {
        super.onResume();

        String sc = SPUtils.getSharedStringData(this, "lishi");
        ShouCangBean shouCangBean = new Gson().fromJson(sc, ShouCangBean.class);
        if (shouCangBean != null && shouCangBean.getMovieList() != null) {
            ArrayList<ScMovieBean> movieList = shouCangBean.getMovieList();
            Collections.reverse(movieList);
            searchRightGrid.setmDatas(movieList);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.cancle:
                //取消收藏
                TvButtom2 tvButtom = ((TvButtom2) view);


                String sc = SPUtils.getSharedStringData(this, "shoucang");
                ShouCangBean shouCangBean = null;
                if (sc != null) {
                    shouCangBean = new Gson().fromJson(sc, ShouCangBean.class);
                }

                if (tvButtom.getText().equals("删除全部历史")) {
//                    ((TvButtom) view).setText("取消删除");
//                    if (shouCangBean != null)
//                        searchRightGrid.setmDatas(shouCangBean.getMovieList());
                    new AlertDialog.Builder(this)
                            .setTitle("是否要删除历史记录？")
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
//                                    Toast.makeText(LishiJiLuActivity.this, "取消", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //重置历史记录
                                    SPUtils.setSharedStringData(LishiJiLuActivity.this, "lishi", null);

                                    //删除数据
                                    String sc = SPUtils.getSharedStringData(LishiJiLuActivity.this, "shoucang");
                                    ShouCangBean shouCangBean = null;
                                    if (sc != null) {
//                                        searchRightGrid.clearDatas();

                                        if (searchRightGrid != null) {
                                            searchRightGrid.clearDatas();
                                            Toast.makeText(LishiJiLuActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                                        }
                                    }


                                }
                            })
                            .create().show();

                } else {

                    if (shouCangBean != null)
                        searchRightGrid.setmDatas(shouCangBean.getMovieList());
                }
                break;

        }
    }

    LishiJiLuActivity.SearchRightGridViewAdapter searchRightGrid;
    View oldView;

    public void initMovieGrid(ShouCangBean shouCangBean) {

//        List<AllMovieBean.DataBean.DetailBean.MovieBean> movie = allMovieBean.getData().get(0).getDetail().getMovie();
        ArrayList<ScMovieBean> movieList = shouCangBean.getMovieList();
        Collections.reverse(movieList);
        searchRightGrid = new SearchRightGridViewAdapter(this, movieList);
        movieGrid.setVerticalSpacing(60);
        movieGrid.setAdapter(searchRightGrid);
        movieGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                ScMovieBean movieBean = (ScMovieBean) view.getTag(R.id.dybean);
                Intent intent = new Intent(LishiJiLuActivity.this, DetailActivity.class);
                intent.putExtra("type", "dy");
                intent.putExtra("title", movieBean.getTitle());
//                XiaoCuiTag.setCaCheBitMap(dyBean.getCaCheBitmap());

                intent.putExtra("lishi_id", movieBean.getId());
                StaticUtils.lishi = true;
                startActivity(intent);
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
                if (hasFocus) {
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
                } else {
                    if (oldView != null) {
                        oldView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                    }
                }
            }
        });
        movieGrid.post(new Runnable() {
            @Override
            public void run() {
                if (movieGrid.getChildAt(0) != null) {

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

                }

                Log.e("TAA", "当前的:" + movieGrid.getChildCount());
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
            if (this.mDatas != null) {
                Log.e("TAA", "DATAS:" + this.mDatas);
                this.mDatas = mDatas;
                notifyDataSetChanged();
            }
        }


        int tag = 0;

        public void clearDatas() {
//            this.mDatas = null;
//            if(mDatas==null) {
            tag = 1;
            notifyDataSetChanged();
//            }
        }

        public ArrayList<ScMovieBean> getmDatas() {
            return this.mDatas;
        }


        @Override
        public int getCount() {
            if (tag == 1) {
                return 0;
            }

            return mDatas.size();
        }

        @Override
        public Object getItem(int position) {
            if (tag == 1) {
                return "暂无";
            }

            return mDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LishiJiLuActivity.SearchRightGridViewAdapter.ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.movie_item, parent, false);
                convertView.setTag(new SearchRightGridViewAdapter.ViewHolder(convertView));
//                convertView.setFocusable(true);
            }

            viewHolder = (LishiJiLuActivity.SearchRightGridViewAdapter.ViewHolder) convertView.getTag();
            ScMovieBean movieBean = mDatas.get(position);
            ((TextView) viewHolder.cardView.findViewById(R.id.moretext)).setText(movieBean.getTitle());

            viewHolder.cardView.setTag(R.id.dybean, movieBean);
            ImageView my_img = (ImageView) viewHolder.cardView.findViewById(R.id.my_img);
//            viewHolder.cardView.findViewById(R.id.pingfen).setVisibility(View.GONE);

//            int bool = movieBean.getPic().indexOf("attachment");
            String imgText = movieBean.getPic();
//            if (bool > 0) {
//                imgText = "http://xiaocui.tv" + imgText;
//            } else {
//
//            }
//
//            if (bool != 0&&(!"".equals(imgText))) {
//                imgText = "http://www.uljf.cn/vod/image/pic/" + movieBean.getPic() + "/thumb/" + imgText;
//            }else{
//                imgText = "http://www.uljf.cn/vod/image/phpvod/nopic.gif";
//
//            }

            Glide.with(convertView.getContext())
                    .load(imgText)
                    .error(R.drawable.defult_movie2)
                    .into(my_img);

            View deleteView = convertView.findViewById(R.id.delete_img);

            if (canCle.getText().equals("删除历史")) {
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
            TextView delete_img;

            public ViewHolder(View view) {
//                this.itemView = view;
//                this.titleTv = (TextView) view.findViewById(R.id.movie_text);
                this.cardView = (OpenCardView) view;
                this.titleTv = view.findViewById(R.id.moretext);
                this.fm = view.findViewById(R.id.my_img);
                this.delete_img = findViewById(R.id.delete_img);
            }
        }
    }


}
