package com.chunleikeji.mode;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chunleikeji.xiangxianglib.R;
import com.open.androidtvwidget.leanback.mode.DefualtListPresenter;
import com.open.androidtvwidget.leanback.recycle.RecyclerViewTV;
import com.open.androidtvwidget.leanback.widget.OpenCardView;




/**
 * Leanback 横向item demo.
 * 如果你想改变标题头的样式，那就写自己的吧.
 * Created by hailongqiu on 2016/8/25.
 */
public class HeadTestMoviceListPresenter extends DefualtListPresenter {

    boolean mIsSelect;

    /**
     *
     */
    int HEAD_STYLE = 1;
    int MOVIE_STYLE = 2;
    int ZT_STYLE = 3;

    int tag;

    public HeadTestMoviceListPresenter(int tag) {

        this.tag = tag;
    }

    /**
     * 你可以重写这里，传入AutoGridViewLayoutManger.
     */
    @Override
    public RecyclerView.LayoutManager getLayoutManger(Context context) {
        return super.getLayoutManger(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = null;
        if (tag == HEAD_STYLE) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.head_item, parent, false);
        } else if (tag == MOVIE_STYLE) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);

        } else if (tag == ZT_STYLE) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.zt_item, parent, false);

        }
        itemView.setTag(tag);

        return new ViewHolder(itemView);
    }

    public void setSelect(boolean isSelect) {
        this.mIsSelect = isSelect;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        Movie movie = ((Movie) getItem(position%getItemCount()));
        OpenCardView openCardView = (OpenCardView) viewHolder.view;
        openCardView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
//                    v.animate().scaleX(1.2f).scaleY(1.2f).setDuration(300).start();
//                    v.setBackgroundResource(R.drawable.shili2);
//                    Drawable d = v.getResources().getDrawable(R.drawable.shili);
//                    ((OpenCardView) v).setShadowDrawable(d);
//                    v.setTranslationZ(5000);
                    v.animate().scaleX(1.05f).scaleY(1.05f).translationZ(30.0f).setDuration(300).start();
//                    v.setElevation(6.0f);

                } else {

//                    v.setBackgroundResource(R.drawable.shili);

//                    Drawable d = v.getResources().getDrawable(R.drawable.shili);
//                    ((OpenCardView) v).setShadowDrawable(d);
//                    v.setTranslationZ(200);
//                    v.setZ(500);
                    v.animate().scaleX(1.0f).scaleY(1.0f).translationZ(5.0f).setDuration(300).start();
//                    v.setElevation(5.0f);
//                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();
                }
            }

        });

        if((int)openCardView.getTag()==HEAD_STYLE){
            openCardView.setBackgroundResource(R.drawable.asd);

        }else if((int)openCardView.getTag()==MOVIE_STYLE){
            openCardView.setBackgroundResource(R.mipmap.movie);

        }

//        Drawable d = viewHolder.view.getResources().getDrawable(R.drawable.shili);
//        openCardView.setShadowDrawable(d);

        openCardView.setTranslationZ(5.0f);


        Log.e("TAA", "啊啊啊啊啊：" + openCardView.getTag());
        if (position == 0) {

            if((int)openCardView.getTag()==ZT_STYLE){
                RecyclerViewTV.LayoutParams layoutParams = (RecyclerViewTV.LayoutParams) openCardView.getLayoutParams();
                layoutParams.setMargins(88, 140, 24, 24);
                openCardView.setLayoutParams(layoutParams);
            }else if((int)openCardView.getTag()==MOVIE_STYLE){
                RecyclerViewTV.LayoutParams layoutParams = (RecyclerViewTV.LayoutParams) openCardView.getLayoutParams();
                layoutParams.setMargins(88, 24, 24, 24);
                openCardView.setLayoutParams(layoutParams);
            }

        } else if (position == getItemCount() - 1) {
            if((int)openCardView.getTag()==ZT_STYLE){
                RecyclerViewTV.LayoutParams layoutParams = (RecyclerViewTV.LayoutParams) openCardView.getLayoutParams();
                layoutParams.setMargins(24, 140, 88, 24);
                openCardView.setLayoutParams(layoutParams);
            }else if((int)openCardView.getTag()==MOVIE_STYLE) {
                RecyclerViewTV.LayoutParams layoutParams = (RecyclerViewTV.LayoutParams) openCardView.getLayoutParams();
                layoutParams.setMargins(24, 24, 88, 24);
                openCardView.setLayoutParams(layoutParams);
            }
        } else {
            if((int)openCardView.getTag()==ZT_STYLE){
                RecyclerViewTV.LayoutParams layoutParams = (RecyclerViewTV.LayoutParams) openCardView.getLayoutParams();
                layoutParams.setMargins(24, 140, 24, 24);
                openCardView.setLayoutParams(layoutParams);
            }else if((int)openCardView.getTag()==MOVIE_STYLE){
                RecyclerViewTV.LayoutParams layoutParams = (RecyclerViewTV.LayoutParams) openCardView.getLayoutParams();
                layoutParams.setMargins(24, 24, 24, 24);
                openCardView.setLayoutParams(layoutParams);
            }

        }

        //
//        TextView tv = (TextView) openCardView.findViewById(R.id.title_tv);
//        tv.setText("aaaa");
        //
        if (this.mIsSelect) {
            openCardView.setAlpha(0.5f);
        } else {
            openCardView.setAlpha(1.0f);
        }
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

}
