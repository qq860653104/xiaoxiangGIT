package com.chunleikeji.zhibotv;

import android.content.Context;
import android.view.LayoutInflater;
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
public class ListTabAdapter extends BaseAdapter {

    private Context context;
    private final List<TVTabBean> dataList;

    public ListTabAdapter(Context context, List<TVTabBean> dataList){
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
        if(convertView == null){


            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ls_tab_item,parent,false);
            viewHoder = new ViewHoder();
            viewHoder.tv_text = (TextView) convertView.findViewById(R.id.tv_text1);
            convertView.setTag(viewHoder);
        }else{


            viewHoder = (ViewHoder) convertView.getTag();
        }

        String data = this.dataList.get(position).Name;
        viewHoder.tv_text.setText(data.trim());

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


    static class ViewHoder{
        TextView tv_text;
      //  ImageView iv_icon;
    }

}

