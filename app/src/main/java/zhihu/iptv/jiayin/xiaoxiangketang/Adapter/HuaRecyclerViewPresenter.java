package zhihu.iptv.jiayin.xiaoxiangketang.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.open.androidtvwidget.leanback.adapter.GeneralAdapter;
import com.open.androidtvwidget.leanback.mode.OpenPresenter;

import zhihu.iptv.jiayin.xiaoxiangketang.R;


/**
 * 测试.
 * Created by hailongqiu on 2016/8/24.
 */
public class HuaRecyclerViewPresenter extends OpenPresenter {

    //    private final List<String> labels;
    // private final List<String> ids;
    private GeneralAdapter mAdapter;
    //    QuanBuBean allMovieBean;
    String[] arrStr;
//    SearchRightGridViewAdapter searchRightGrid;

    int layout, id;

    public HuaRecyclerViewPresenter(Context context, String[] allMovieBean, SearchRightGridViewAdapter searchRightGrid, int layout, int id) {
//        this.labels = new ArrayList<String>(count);
        this.layout = layout;
        this.id = id;
        this.arrStr = allMovieBean;
//        this.searchRightGrid = searchRightGrid;
//        this.labels = Arrays.asList(context.getResources().getStringArray(R.array.movie_name));
        //   ids = Arrays.asList(context.getResources().getStringArray(R.array.movie_id));

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
//
//        if(allMovieBean!=null&&allMovieBean.getData()!=null){
//
//            return allMovieBean.getData().size();
//        }

        return arrStr.length;
//        return labels.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        Log.e("TAA", "更新了布局：" + view);
        return new GridViewHolder(view);
    }


    View oldView;


    public interface OnItemFocu {

        public void onItemFocuse(int position, View view, boolean focuse);

    }

    public OnItemFocu getOnItemFocu() {
        return onItemFocu;
    }

    public void setOnItemFocu(OnItemFocu onItemFocu) {
        this.onItemFocu = onItemFocu;
    }

    OnItemFocu onItemFocu;

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        GridViewHolder gridViewHolder = (GridViewHolder) viewHolder;
        TextView textView = (TextView) gridViewHolder.tv.findViewById(id);
        textView.setText(arrStr[position]);
        textView.setTag(position);
        if (gridViewHolder.view.getOnFocusChangeListener() == null) {
            gridViewHolder.view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {


                    TextView myTitle = view.findViewById(id);
                    if (b) {

                        if (oldView != null) {

                            if(onItemFocu!=null){
                                onItemFocu.onItemFocuse(position,view,b);
                            }

                            oldView.setBackgroundColor(Color.TRANSPARENT);
                            TextView oldTitle = oldView.findViewById(R.id.title_tv);
                            oldTitle.setTextColor(view.getResources().getColorStateList(R.color.select_text));
                        }
//                        view.setBackgroundColor(0x005493);
                        view.setBackgroundColor(Color.parseColor("#005493"));
                        myTitle.setTextColor(view.getResources().getColorStateList(R.color.defult_text));
                        oldView = view;

//                            if (oldView != null) {
//                                oldView.setBackgroundResource(0);
////                            oldView.setBackgroundColor(Color.TRANSPARENT);
////                            TextView oldTitle = oldView.findViewById(R.id.title_tv);
////                            oldTitle.setTextColor(Color.WHITE);
//                            }
//                            view.setBackgroundResource(R.drawable.xian);
////                        view.setBackgroundColor(Color.WHITE);
////                        myTitle.setTextColor(view.getResources().getColorStateList(R.color.defult_text));
//                            oldView = view;
                    } else {
                    }

                }
            });
        }

    }

}
