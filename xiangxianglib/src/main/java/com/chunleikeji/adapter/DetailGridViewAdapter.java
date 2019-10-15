package com.chunleikeji.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.chunleikeji.bean.ScMovieBean;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by wh on 2018-09-16.
 */

public class DetailGridViewAdapter extends BaseAdapter {
    private List<ScMovieBean> mDatas;
    private final LayoutInflater mInflater;

    int layout ;
    public DetailGridViewAdapter(Context context, int layout) {
//        mDatas = data;
        this.layout = layout;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setmDatas(ArrayList<ScMovieBean> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }


    public void setCount(int count) {
        this.count = count;
    }

    int count = 0;

    @Override
    public int getCount() {

        return count;
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public ItemViewInit getItemViewInit() {
        return itemViewInit;
    }

    public void setItemViewInit(ItemViewInit itemViewInit) {
        this.itemViewInit = itemViewInit;
    }

    ItemViewInit itemViewInit;

    public interface ItemViewInit{

        public void initItemView(int position, View convertView, ViewGroup parent);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(layout, parent, false);
            convertView.setTag(new ViewHolder(convertView));
//                convertView.setFocusable(true);
        }
//        Log.e("TAA", "_22222111111_________" + position + "________");

        if (itemViewInit!=null){
            itemViewInit.initItemView(position,convertView,parent);
        }

//        SearchBean.DataBean movieBean = mDatas.get(position);
//        ((TextView) convertView.findViewById(R.id.moretext)).setText(movieBean.getTitle());
//        ((TextView) convertView.findViewById(R.id.pingfen)).setText(movieBean.getPf());
//
//        convertView.setTag(R.id.dybean, movieBean);
//        ImageView my_img = (ImageView) convertView.findViewById(R.id.my_img);
//
//        int bool = movieBean.getPic().indexOf("attachment");
//        String imgText = movieBean.getPic();

//        Glide.with(convertView.getContext())
//                .load(imgText)
//                .error(R.drawable.defult_movie2)
//                .into(my_img);
        return convertView;
    }


    class ViewHolder {
//        RoundedImageView fm;
//        MoreTextView titleTv;
//        OpenCardView cardView;

        public ViewHolder(View view) {
//                this.itemView = view;
//                this.titleTv = (TextView) view.findViewById(R.id.movie_text);
//            this.cardView = (OpenCardView) view;
//            this.titleTv = view.findViewById(R.id.moretext);
//            this.fm = view.findViewById(R.id.my_img);
        }
    }



}
