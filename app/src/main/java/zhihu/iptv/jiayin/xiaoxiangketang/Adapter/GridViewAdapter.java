package zhihu.iptv.jiayin.xiaoxiangketang.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.chunleikeji.bean.AllMovieBean;
import com.chunleikeji.bean.DianboBean;
import com.chunleikeji.view.MoreTextView;
import com.open.androidtvwidget.leanback.widget.OpenCardView;
import java.util.List;
import zhihu.iptv.jiayin.xiaoxiangketang.R;


/**
 * Created by wh on 2018/6/4.
 */

public class GridViewAdapter extends BaseAdapter {

    private List<DianboBean.DataBean.ListBean> cms_data;
    private final LayoutInflater mInflater;

    private Context context;

    public GridViewAdapter(Context context, List<AllMovieBean.DataBean.DetailBean.MovieBean> data, String id) {
        this.context = context;
//        mDatas = data;
        this.id = id;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    private int postion;

//    public void setmDatas(List<DianboBean.DataBean.ListBean> cms_data, String id) {
//        this.cms_data = cms_data;
//        Log.e("TAA", "设置了id:____________setmDatas" + id);
//        this.id = id;
//        notifyDataSetChanged();
//    }

    public void setmDatas(List<DianboBean.DataBean.ListBean> mDatas, String id, int postion) {
        this.cms_data = mDatas;
        Log.e("TAA", "设置了id:____________setmDatas_2" + id+"___"+postion);

        this.id = id;
        this.postion = postion;

        notifyDataSetChanged();

//        if (id.equals("40") || id.equals("41")) {
//            mMovieRecycler.setNumColumns(2);
//            mMovieRecycler.requestFocus();
//
//        } else {
//            mMovieRecycler.setNumColumns(4);
//        }
    }

    @Override
    public int getCount() {
        if (cms_data == null) {
            return 0;
        }

        return cms_data.size();
    }

    @Override
    public Object getItem(int position) {
        return cms_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridViewAdapter.ViewHolder viewHolder = null;

        convertView = mInflater.inflate(R.layout.movie_item, parent, false);


        convertView.setTag(new GridViewAdapter.ViewHolder(convertView));

        viewHolder = (GridViewAdapter.ViewHolder) convertView.getTag();
        DianboBean.DataBean.ListBean listBean = cms_data.get(position);

        ((TextView) convertView.findViewById(R.id.moretext)).setText(listBean.getName());


        convertView.setTag(R.id.dybean, listBean);
        ImageView my_img = (ImageView) convertView.findViewById(R.id.my_img);

        OpenCardView parent_img = (OpenCardView) convertView.findViewById(R.id.img_parent);

        if (parent_img != null) {
            Drawable b = context.getResources().getDrawable(R.drawable.asdfgh);
            parent_img.setShadowDrawable(b);

        }

        if("1".equals(listBean.getIszb())){
            ((TextView) convertView.findViewById(R.id.pingfen)).setVisibility(View.VISIBLE);
        }

        String imgText = listBean.getFm_img();

        Glide.with(convertView.getContext())
                .load(imgText)
                .error(R.drawable.defult_movie2)
                .into(my_img);

        return convertView;
    }


    class ViewHolder {
        ImageView fm;
        MoreTextView titleTv;
        OpenCardView cardView;

        public ViewHolder(View view) {
            this.cardView = (OpenCardView) view;
            this.titleTv = view.findViewById(R.id.moretext);
            this.fm = view.findViewById(R.id.my_img);
        }
    }

}
