package zhihu.iptv.jiayin.xiaoxiangketang;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

import com.bumptech.glide.Glide;
import com.chunleikeji.bean.SearchBean;
import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.OkHttpUtils;
import com.chunleikeji.util.SPUtils;
import com.chunleikeji.util.StaticUtils;
import com.chunleikeji.util.ToastUtils;
import com.chunleikeji.view.MoreTextView;
import com.chunleikeji.view.SearchEditTv;
import com.google.gson.Gson;
import com.open.androidtvwidget.leanback.adapter.GeneralAdapter;
import com.open.androidtvwidget.leanback.mode.ListRow;
import com.open.androidtvwidget.leanback.widget.OpenCardView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;



public class SearchActivity extends Activity {


    private List<String> data;
    //    private MainUpView mainUpView1;
    private View mOldView;
    private GridView searchGrid;
    private GridView movieGrid;
    private SearchLeftGridViewAdapter searchLeftGrid;
//    private SearchRightGridViewAdapter searchRightGrid;

    private int mSavePos = -1;
    private int mCount = 50;

    private SearchEditTv searchEditTv;
    private TextView kongge, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_search);
        StaticUtils.setActivity(this);
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this,MobclickAgent.EScenarioType.E_UM_NORMAL);
        kongge = (TextView) findViewById(R.id.kongge);
        delete = (TextView) findViewById(R.id.delete);

        searchEditTv = (SearchEditTv) findViewById(R.id.search_edit_tv);

        searchGrid = (GridView) findViewById(R.id.search_left_grid);
        movieGrid = (GridView) findViewById(R.id.search_right_grid);
//        searchMovieGrid = (GridViewTV) findViewById(R.id.search_right_grid);
//        searchMovieGrid.setHorizontalSpacing(12);
        // 加载数据.
        getData(200);
        //
        updateGridViewAdapter();
        searchGrid.setSelector(new ColorDrawable(Color.TRANSPARENT));
//        searchMovieGrid.setSelector(new ColorDrawable(Color.TRANSPARENT));

        //
        kongge.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    view.setBackgroundResource(R.drawable.key_bg_rectangle2);
                    view.findViewById(R.id.kongge).animate().scaleX(1.05f).scaleY(1.05f).setDuration(300).start();
                    ((TextView) view).setTextColor(Color.BLACK);
                    if (mOldView != null && mOldView.findViewById(R.id.textView) != null) {
                        mOldView.setBackgroundResource(R.drawable.key_bg_rectangle);
                        mOldView.findViewById(R.id.textView).animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                        ((TextView) mOldView.findViewById(R.id.textView)).setTextColor(getResources().getColorStateList(R.color.black));
                    }
                } else {
                    view.setBackgroundResource(R.drawable.key_bg_rectangle);
                    ((TextView) view.findViewById(R.id.kongge)).setTextColor(getResources().getColorStateList(R.color.black));
                    view.findViewById(R.id.kongge).animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                }
            }
        });
        delete.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {

                if (hasFocus) {
                    view.setBackgroundResource(R.drawable.key_bg_rectangle2);
                    view.animate().scaleX(1.05f).scaleY(1.05f).setDuration(300).start();
                    ((TextView) view).setTextColor(Color.BLACK);

                    if (mOldView != null && mOldView.findViewById(R.id.textView) != null) {
                        mOldView.setBackgroundResource(R.drawable.key_bg_rectangle);
                        mOldView.findViewById(R.id.textView).animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
//                        ((TextView)mOldView.findViewById(R.id.textView)).setTextColor(getColor(R.color.defult_text));
                        ((TextView) mOldView.findViewById(R.id.textView)).setTextColor(getResources().getColorStateList(R.color.black));

                    }
                } else {
                    view.setBackgroundResource(R.drawable.key_bg_rectangle);
//                    ((TextView)view.findViewById(R.id.delete)).setTextColor(getColor(R.color.defult_text));
                    ((TextView) view.findViewById(R.id.delete)).setTextColor(getResources().getColorStateList(R.color.black));

                    view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                }
            }
        });
        searchGrid.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {

                if (hasFocus) {

                    if (mOldView != null && mOldView.findViewById(R.id.textView) != null) {
                        mOldView.setBackgroundResource(R.drawable.key_bg_rectangle2);
                        mOldView.findViewById(R.id.textView).animate().scaleX(1.2f).scaleY(1.2f).setDuration(300).start();
                        ((TextView) mOldView.findViewById(R.id.textView)).setTextColor(Color.BLACK);
                    } else {
//                        mOldView.findViewById(R.id.textView).animate().scaleX(1.2f).scaleY(1.2f).setDuration(300).start();
                    }
                } else {
                    if (mOldView != null && mOldView.findViewById(R.id.textView) != null) {
                        mOldView.setBackgroundResource(R.drawable.key_bg_rectangle);

                        mOldView.findViewById(R.id.textView).animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                        ((TextView) mOldView.findViewById(R.id.textView)).setTextColor(getResources().getColorStateList(R.color.black));

                    }

                }
            }
        });


//        searchMovieGrid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                view.animate().scaleX(1.05f).scaleY(1.05f).translationZ(60.0f).setDuration(300).start();
//
//                if (mOldView != null) {
//                    mOldView.animate().scaleX(1.0f).scaleY(1.0f).translationZ(0f).setDuration(300).start();
//                }
//                mOldView = view;
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });


        searchGrid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                view.setBackgroundResource(R.drawable.key_bg_rectangle2);
                view.findViewById(R.id.textView).animate().scaleX(1.2f).scaleY(1.2f).setDuration(300).start();
                ((TextView) view.findViewById(R.id.textView)).setTextColor(Color.BLACK);

                if (mOldView != null && mOldView.findViewById(R.id.textView) != null) {
                    mOldView.setBackgroundResource(R.drawable.key_bg_rectangle);
                    mOldView.findViewById(R.id.textView).animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                    ((TextView) mOldView.findViewById(R.id.textView)).setTextColor(getResources().getColorStateList(R.color.black));

                }
                mOldView = view;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        searchGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView viewById = (TextView) view.findViewById(R.id.textView);

                if (viewById != null) {//更新输入框
                    searchEditTv.setSearchText(viewById.getText().toString());
                    //搜索并更新数据
//                    if(viewById.getText().toString()!=""&&searchEditTv.getText().toString()!=null) {
                    searchData(searchEditTv.getText().toString());
//                    }
                }

            }
        });

        loadData();


        kongge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEditTv.setSearchText(" ");
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEditTv.delete();
                if(searchEditTv.getText().toString()==null||searchEditTv.getText().toString()==""){

                }else{
                    searchData(searchEditTv.getText().toString());

                }


            }
        });

    }

    SearchRightGridViewAdapter searchRightGrid;

    View oldView = null;

    private void initMovieGrid() {

        List<SearchBean.DataBean> movie = searchBean.getData();
        searchRightGrid = new SearchRightGridViewAdapter(this, movie);
        movieGrid.setVerticalSpacing(60);
        movieGrid.setAdapter(searchRightGrid);
        movieGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                StaticUtils.sphttp = true ;
                SearchBean.DataBean movieBean = (SearchBean.DataBean) view.getTag(R.id.dybean);
                if ("0".equals(movieBean.getIs_video())){
                    Intent intent = new Intent(SearchActivity.this,CarouselImgActivity.class);
                    intent.putExtra("imgId",movieBean.getId());
                    StaticUtils.imgId = movieBean.getId();
                    startActivity(intent);
                        StaticUtils.isSear = true;
                }else {

                    Intent intent = new Intent(SearchActivity.this, DetailActivity.class);
                    intent.putExtra("type", "dianbo");
                    intent.putExtra("title", movieBean.getTitle());
//                XiaoCuiTag.setCaCheBitMap(dyBean.getCaCheBitmap());
                    intent.putExtra("id", movieBean.getId());
                    StaticUtils.movie_id = movieBean.getId()+"";
                    Log.e("TAA", "看看是啥啊_SearchActivity：" + movieBean.getId());
                    SPUtils.put(SearchActivity.this, "id", movieBean.getId());
                    startActivity(intent);
                    StaticUtils.isSear = true;
                }

            }
        });


        movieGrid.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    if (oldView == null) {

                        view = movieGrid.getChildAt(0);

                        view.animate().scaleX(1.1f).scaleY(1.1f).setDuration(300).start();
                        MoreTextView viewById = view.findViewById(R.id.moretext);
                        OpenCardView parent_img = (OpenCardView) view.findViewById(R.id.img_parent);

                        if (parent_img != null) {
                            viewById.startMoreText();
                            Drawable d = getResources().getDrawable(R.drawable.test3);
                            parent_img.setShadowDrawable(d);
                        }
                        oldView = view;
                    } else {
                        view = oldView;

                        view.animate().scaleX(1.1f).scaleY(1.1f).setDuration(300).start();
                        MoreTextView viewById = view.findViewById(R.id.moretext);
                        OpenCardView parent_img = (OpenCardView) view.findViewById(R.id.img_parent);

                        if (parent_img != null) {
                            viewById.startMoreText();
                            Drawable d = getResources().getDrawable(R.drawable.test3);
                            parent_img.setShadowDrawable(d);
                        }
                    }
                } else {
                    if (oldView != null) {
                        oldView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                        MoreTextView viewById = oldView.findViewById(R.id.moretext);
                        OpenCardView parent_img = (OpenCardView) oldView.findViewById(R.id.img_parent);

                        viewById = (MoreTextView) oldView.findViewById(R.id.moretext);
                        parent_img = (OpenCardView) oldView.findViewById(R.id.img_parent);

                        if (parent_img != null) {
                            viewById.hintMoreText();
                            Drawable asd = getResources().getDrawable(R.drawable.asdfgh);
                            parent_img.setShadowDrawable(asd);

                        }
                    }

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
    }


    //加载数据 先都加载出来 每一个12个 获取所有的数量
    private String allMovieUrl = BaseUrl.BASE+"search";
    private SearchBean searchBean;


    //开始搜索数据
    public void searchData(String key) {
        String url = allMovieUrl + "?key=" + key;
        Log.e("TAA", "搜索连接：" + url);
        OkHttpUtils.getOkHttp(this, url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.e("TAA", "搜索结果：" + body);

                try {
                    searchBean = null;
                    searchBean = new Gson().fromJson(body, SearchBean.class);
                } catch (Exception e) {

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (searchRightGrid != null && searchBean != null) {
                            searchRightGrid.setmDatas(searchBean.getData());
                        } else {
                            ToastUtils.showToast(SearchActivity.this, "暂无数据。");
                        }
                    }
                });

            }
        });

    }

    public void loadData() {
        Log.e("TAG", "loadData: " +  allMovieUrl);
        OkHttpUtils.getOkHttp(this, allMovieUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                searchBean = new Gson().fromJson(body, SearchBean.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        getData(1);
                        initMovieGrid();
                        //    testRecyclerViewLinerLayout(LinearLayoutManager.VERTICAL);

                    }
                });
            }
        });

    }


    private GeneralAdapter.ViewHolder mSelectedViewHolder;
    List<ListRow> mListRows = new ArrayList<ListRow>();


//    public void test2(View view) {
//        if (view.getId() == R.id.kongge) {
//            searchEditTv.setSearchText(" ");
//        } else {
//            searchEditTv.delete();
//        }
//
//    }


    private void initGridViewData(int position) {
        String text = "position:" + position;
        // 测试数据更新.
        if (position == 0) {
            mCount += 10;
            getData(mCount);
            updateGridViewAdapter();
            text += "-->更新数据3个";
        } else if (position == 1) {
            mCount += 20;
            getData(mCount);
            updateGridViewAdapter();
            text += "-->更新数据100个";
        } else if (position == 2) {
            mCount += 30;
            getData(mCount);
            updateGridViewAdapter();
            text += "-->更新数据2000个";
        } else {
            // ... ...
        }
    }

    String[] key = new String[]{"A", "B", "C", "D", "E", "F"
            , "G", "H", "I", "J", "K", "L"
            , "M", "N", "O", "P", "Q", "R"
            , "S", "T", "U", "V", "W", "X"
            , "Y", "Z", "1", "2", "3", "4"
            , "5", "6", "7", "8", "9", "0"};

    public List<String> getData(int count) {
        data = new ArrayList<String>();
        for (int i = 0; i < key.length; i++) {
            String text = key[i];
            data.add(text);
        }
        return data;
    }

    private void updateGridViewAdapter() {
        searchLeftGrid = new SearchLeftGridViewAdapter(this, data);
        searchGrid.setAdapter(searchLeftGrid);
        searchLeftGrid.notifyDataSetChanged();


//        searchRightGrid = new SearchRightGridViewAdapter(this, data);
//        searchMovieGrid.setAdapter(searchRightGrid);
//        searchRightGrid.notifyDataSetChanged();
    }

    ///// Adapter 类 start start //////////

    class SearchLeftGridViewAdapter extends BaseAdapter {

        private List<String> mDatas;
        private final LayoutInflater mInflater;

        public SearchLeftGridViewAdapter(Context context, List<String> data) {
            mDatas = data;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_gridview, parent, false);
                convertView.setTag(new ViewHolder(convertView));
            }
            if (convertView.getOnFocusChangeListener() == null) {
//                convertView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                    @Override
//                    public void onFocusChange(View view, boolean hasFocus) {
//                        if(hasFocus){
//                            view.setBackgroundResource(R.drawable.key_bg_rectangle2);
//                            view.findViewById(R.id.textView).animate().scaleX(1.2f).scaleY(1.2f).setDuration(300).start();
//                        }else{
//                            view.setBackgroundResource(R.drawable.key_bg_rectangle);
//                            view.findViewById(R.id.textView).animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
//                        }
//                    }
//                });

            }

            viewHolder = (ViewHolder) convertView.getTag();
            bindViewData(position, viewHolder);
            return convertView;
        }

        private void bindViewData(int position, ViewHolder viewHolder) {
            String title = mDatas.get(position);
            viewHolder.titleTv.setText(title);
        }

        class ViewHolder {
            View itemView;
            TextView titleTv;

            public ViewHolder(View view) {
                this.itemView = view;
                this.titleTv = (TextView) view.findViewById(R.id.textView);
            }
        }
    }


    /**
     * 电影的适配器
     */
    public class SearchRightGridViewAdapter extends BaseAdapter {

        private List<SearchBean.DataBean> mDatas;
        private final LayoutInflater mInflater;

        public SearchRightGridViewAdapter(Context context, List<SearchBean.DataBean> data) {
            mDatas = data;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public void setmDatas(List<SearchBean.DataBean> mDatas) {
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
                convertView = mInflater.inflate(R.layout.search_movie_item, parent, false);
                convertView.setTag(new SearchRightGridViewAdapter.ViewHolder(convertView));
//                convertView.setFocusable(true);
            }

            viewHolder = (SearchRightGridViewAdapter.ViewHolder) convertView.getTag();
            SearchBean.DataBean movieBean = mDatas.get(position);
            ((TextView) convertView.findViewById(R.id.moretext)).setText(movieBean.getTitle());
//            ((TextView) convertView.findViewById(R.id.pingfen)).setText(movieBean.getPf());

            convertView.setTag(R.id.dybean, movieBean);
            ImageView my_img = (ImageView) convertView.findViewById(R.id.my_img);

            int bool = movieBean.getPic().indexOf("http");
            String imgText = movieBean.getPic();
            if (bool != 0) {
                imgText = "http://vod.mnrjc.cn/image/pic/" + movieBean.getPicfolder() + "/thumb/" + imgText;
            } else {
                imgText = movieBean.getPic();
            }

//            Log.e("TAA","之前："+bool+"___________"+movieBean.getPic()+"__________"+(bool != 0)+"_________"+(bool==0)+"________"+imgText);
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

