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
import com.chunleikeji.bean.QuanBuBean;
import com.chunleikeji.view.MoreTextView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.open.androidtvwidget.leanback.widget.OpenCardView;

import java.util.List;

import zhihu.iptv.jiayin.xiaoxiangketang.R;

/**
 * Created by wh on 2018/6/4.
 */

public class SearchRightGridViewAdapter extends BaseAdapter {


    private List<QuanBuBean.DataBeanX.DataBean> cms_data;
    private final LayoutInflater mInflater;

    private Context context;

    public SearchRightGridViewAdapter(Context context, List<AllMovieBean.DataBean.DetailBean.MovieBean> data, String id) {
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

    public void setmDatas(List<QuanBuBean.DataBeanX.DataBean> cms_data , String id) {
        this.cms_data = cms_data;
        Log.e("TAA","设置了id:____________setmDatas"+id);
        this.id= id;
        notifyDataSetChanged();
    }

    public void setmDatas(List<QuanBuBean.DataBeanX.DataBean> mDatas, String id, int postion) {
        this.cms_data = mDatas;
        Log.e("TAA","设置了id:____________setmDatas_2"+id);

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
        SearchRightGridViewAdapter.ViewHolder viewHolder = null;
        if (!("40".equals(id)) && !("41".equals(id))) {

            convertView = mInflater.inflate(R.layout.all_movie_item, parent, false);


            convertView.setTag(new SearchRightGridViewAdapter.ViewHolder(convertView));
//                convertView.setFocusable(true);
        } else if ((("40".equals(id)) || ("41".equals(id)))) {
//                if("40".equals(id)) {
            try {
                convertView = mInflater.inflate(R.layout.zt_item, parent, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            convertView.setTag(new SearchRightGridViewAdapter.ViewHolder(convertView));
            convertView.setTag(R.id.position,"ok");
            Log.e("TAA", "检测布局：加载了2" + (("40".equals(id)) || ("41".equals(id))));
//                convertView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(AllMovieActivity.this, "被点击了！", Toast.LENGTH_SHORT).show();
//                        view.requestFocus();
//                        view.animate().scaleY(1.5f).setDuration(300).start();
//                    }
//                });

            final View finalConvertView = convertView;
//                convertView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                    @Override
//                    public void onFocusChange(View view, boolean b) {
//                        finalConvertView.animate().scaleY(1.1f).setDuration(300).start();
//                    }
//                });

//                }
        }

//            Log.e("TAA", "_22222111111_________" + position + "________");

        viewHolder = (SearchRightGridViewAdapter.ViewHolder) convertView.getTag();
        QuanBuBean.DataBeanX.DataBean cmsDataBean = cms_data.get(position);

//        AllMovieBean.DataBean.DetailBean.MovieBean movieBean = mDatas.get(position);
        ((TextView) convertView.findViewById(R.id.moretext)).setText(cmsDataBean.getName());
//        ((TextView) convertView.findViewById(R.id.pingfen)).setText(cmsDataBean.getD_score());

        convertView.setTag(R.id.dybean, cmsDataBean);
        ImageView my_img = (ImageView) convertView.findViewById(R.id.my_img);
//        my_img.setBackgroundResource(R.drawable.border_color_style);
        OpenCardView parent_img = (OpenCardView) convertView.findViewById(R.id.img_parent);

        if (parent_img != null) {
//                viewById.hintMoreText();
            Drawable b = context.getResources().getDrawable(R.drawable.asdfgh);
            parent_img.setShadowDrawable(b);

        }

//        int bool = cmsDataBean.getD_pic().indexOf("attachment");
        String imgText = cmsDataBean.getFm_img();
//        if (bool > 0) {
//            imgText = "http://xiaocui.tv" + imgText;
//        } else {
//
//        }
//            bg =  imgText;

        try {
            Glide.with(convertView.getContext())
                    .load(imgText)
                    .error(R.drawable.quanbuitmebg)
                    .into(my_img);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        RoundedImageView fm;
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
