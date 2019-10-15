package zhihu.iptv.jiayin.xiaoxiangketang.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chunleikeji.bean.QuanBuBean;
import com.open.androidtvwidget.leanback.adapter.GeneralAdapter;
import com.open.androidtvwidget.leanback.mode.OpenPresenter;

import java.util.Arrays;
import java.util.List;

import zhihu.iptv.jiayin.xiaoxiangketang.QuanBuActivity;
import zhihu.iptv.jiayin.xiaoxiangketang.R;



/**
 * 测试.
 * Created by hailongqiu on 2016/8/24.
 */
public class RecyclerViewPresenter extends OpenPresenter {


    //    private final List<String> labels;
    private final List<String> ids;
    private GeneralAdapter mAdapter;
    QuanBuBean allMovieBean;
    SearchRightGridViewAdapter searchRightGrid;
QuanBuActivity quanBuActivity;


    public RecyclerViewPresenter(Context context, QuanBuBean allMovieBean, SearchRightGridViewAdapter searchRightGrid , QuanBuActivity quanBuActivity) {
//        this.labels = new ArrayList<String>(count);
        this.allMovieBean = allMovieBean;
        this.searchRightGrid = searchRightGrid;
        this.quanBuActivity = quanBuActivity;
//        this.labels = Arrays.asList(context.getResources().getStringArray(R.array.movie_name));
        ids = Arrays.asList(context.getResources().getStringArray(R.array.movie_id));

    }



    @Override
    public void setAdapter(GeneralAdapter adapter) {
        this.mAdapter = adapter;
    }

    /**
     * 用于数据加载更多测试.
     */
    public void addDatas(int count) {
//        int sum = labels.size();
//        for (int i = sum; i < sum + count; i++) {
//            labels.add(String.valueOf(i));
//        }
//        this.mAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        if(allMovieBean!=null&&allMovieBean.getData()!=null){

            return allMovieBean.getData().size();
        }

        return 0;
//        return labels.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allmovie_select_item, parent, false);
        Log.e("TAA","更新了布局："+view);
        return new GridViewHolder(view);
    }


    View oldView;


    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int tag;
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        GridViewHolder gridViewHolder = (GridViewHolder) viewHolder;
        TextView textView = (TextView) gridViewHolder.tv.findViewById(R.id.title_tv);
        textView.setText(allMovieBean.getData().get(position).getName());
        textView.setTag(position);
        if (gridViewHolder.view.getOnFocusChangeListener() == null) {
            gridViewHolder.view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    TextView myTitle = view.findViewById(R.id.title_tv);
//                    GridViewHolder gridViewHolder = (GridViewHolder) viewHolder;
//                    TextView textView = view.findViewById(R.id.title_tv);


//                    QuanBuBean.DataBean dataBean = allMovieBean.getData().get((Integer) myTitle.getTag());

                    List<QuanBuBean.DataBeanX.DataBean> cms_data = allMovieBean.getData().get((Integer) myTitle.getTag()).getData();
//                    ArrayList<AllMovieBean.DataBean.DetailBean.MovieBean> movie = allMovieBean.getData().get((Integer) myTitle.getTag()).getDetail().getMovie();

                    if(allMovieBean.getData().size()<=(Integer) myTitle.getTag()){
                        Log.e("TAA", "超了 再 recyclerviewpresent " +(Integer) myTitle.getTag()+"_________"+cms_data.size());
                        return;
                    }
                    String id = allMovieBean.getData().get((Integer) myTitle.getTag()).getName();

                    Log.e("TAA","设置了id:__AA_________"+myTitle.getTag()+"_________________id:"+id);

//                    String id = cms_data.get((Integer) myTitle.getTag()).getCid();
//                    searchRightGrid.set
                    searchRightGrid.setmDatas(cms_data, id, (Integer) myTitle.getTag());
                    if (b) {

                        try {
                            tag = Integer.parseInt(myTitle.getTag()+"");
                        }catch (Exception e){
                            Log.e("TAA","字符强转出错："+myTitle.getTag());

                        }
                        quanBuActivity.gettag(tag);
                        Log.e("TAA","设置了id:__B________" + tag);
                        if (oldView != null) {
                            oldView.setBackgroundColor(Color.TRANSPARENT);
                            TextView oldTitle = oldView.findViewById(R.id.title_tv);
                            oldTitle.setTextColor(Color.WHITE);

                        }
                        view.setBackgroundColor(Color.WHITE);
                        myTitle.setTextColor(view.getResources().getColorStateList(R.color.black));
                        myTitle.animate().scaleX(1.1f).scaleY(1.1f).setDuration(300).start();
                        oldView = view;
                    } else {
                        view.setBackgroundColor(Color.LTGRAY);
//                        myTitle.setTextColor(Color.BLACK);
                        myTitle.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                    }
                }
            });
        }

    }
}
