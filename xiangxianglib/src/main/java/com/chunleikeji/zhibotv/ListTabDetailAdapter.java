package com.chunleikeji.zhibotv;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chunleikeji.xiangxianglib.R;

import java.util.List;



/**
 * 作者：杨光福 on 2016/7/18 10:16
 * 微信：yangguangfu520
 * QQ号：541433511
 * 作用：NetVideoPager的适配器
 */
public class ListTabDetailAdapter extends BaseAdapter {

    private Context context;
    private List<TabDetail> dataList;

    public ListTabDetailAdapter(Context context, List<TabDetail> dataList){
        this.context = context;
        this.dataList = dataList;
    }


    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder viewHoder;
        if(convertView ==null){
            convertView = View.inflate(context, R.layout.ls_tab_item_detail,null);
            viewHoder = new ViewHoder();
            viewHoder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHoder.tv_number = (TextView) convertView.findViewById(R.id.tv_number);
            viewHoder.tv_detail = (TextView) convertView.findViewById(R.id.tv_detail);
            convertView.setTag(viewHoder);
        }else{
            viewHoder = (ViewHoder) convertView.getTag();
        }

        TabDetail data = this.dataList.get(position);
        viewHoder.tv_name.setText(data.name);
        viewHoder.tv_number.setText(position+"");
        viewHoder.tv_detail.setText(data.detail);
        //1.使用xUtils3请求图片
//        x.image().bind(viewHoder.iv_icon,mediaItem.getImageUrl());
        //2.使用Glide请求图片
//        Glide.with(context).load(mediaItem.getImageUrl())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.drawable.video_default)
//                .error(R.drawable.video_default)
//                .into(viewHoder.iv_icon);

        return convertView;
    }

    public void setData(List<TabDetail> data) {
        this.dataList = data;
        notifyDataSetChanged();
    }


    static class ViewHoder{
        TextView tv_name;
        TextView tv_detail;
        TextView tv_number;
      //  ImageView iv_icon;
    }

}

