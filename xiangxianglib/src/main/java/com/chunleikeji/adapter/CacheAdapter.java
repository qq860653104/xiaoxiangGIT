package com.chunleikeji.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.chunleikeji.xiangxianglib.R;

import java.util.List;




public class CacheAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static String TAG = "你瞅啥，瞅你咋滴";

    private LayoutInflater layoutInflater;
        static List<String> listName ;


    public CacheAdapter(Context context, List<String> list) {
        layoutInflater = LayoutInflater.from(context);

        listName = list;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.cacheitem, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.checkBox.setText(listName.get(position));

    }

    @Override
    public int getItemCount() {


        return listName.size();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        CheckBox checkBox;

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox);
            checkBox.requestFocus();
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(v,listName.get(getAdapterPosition()),getAdapterPosition());
                }
            });


        }


    }


    //在定义接口对象（需要的数据）
    public interface OnItemClickListener {
        /**
         * 当RecyclerVIew某个被点击的时候回调
         *  @param listName  点击得到的数据
         * @param view  点击item的视图
         * @param listName
         * @param index 点击得到下标
         */

        void onItemClick(View view, String listName, int index);

    }

    private static OnItemClickListener onItemClickListener;

    /**
     * 设置RecyclerView 某个的监听
     *
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;

    }
//
//
//    public interface OnFocusChangeL {
//        void OnFocusChange(View view, MemberBean.DataBeanX.ItemBean  data, int index);
//
//    }
//
//    private static OnFocusChangeL onFocusChangeListener1;
//
//    public static void setOnFocusChangeListener(OnFocusChangeL onFocusChangeListener) {
//        onFocusChangeListener1 = onFocusChangeListener;
//
//    }


}
