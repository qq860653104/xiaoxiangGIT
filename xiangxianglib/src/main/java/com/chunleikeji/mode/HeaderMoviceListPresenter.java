package com.chunleikeji.mode;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chunleikeji.tag.TagUtils;
import com.chunleikeji.xiangxianglib.R;
import com.open.androidtvwidget.leanback.mode.DefualtListPresenter;
import com.open.androidtvwidget.leanback.recycle.RecyclerViewTV;
import com.open.androidtvwidget.leanback.widget.OpenCardView;



/**
 * Leanback 横向item demo.
 * 如果你想改变标题头的样式，那就写自己的吧.
 * Created by hailongqiu on 2016/8/25.
 */
public class HeaderMoviceListPresenter extends DefualtListPresenter {

    boolean mIsSelect;

    /**
     *
     */
    int HEAD_STYLE = 1;
    int MOVIE_STYLE = 2;
    int ZT_STYLE = 3;

    int tag;

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    int itemCount = 5;

    public HeaderMoviceListPresenter() {

    }

    @Override
    public int getItemCount() {
        return 20;
    }


    @Override
    public Object getItem(int pos) {
        return super.getItem(pos/itemCount);
    }

    public HeaderMoviceListPresenter(int tag) {

        this.tag = tag;
        setTAG(tag);
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
        if (tag == TagUtils. HEAD_STYLE) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.head_item, parent, false);
        } else if (tag ==TagUtils.  MOVIE_STYLE) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        } else if (tag ==TagUtils.  ZT_STYLE) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.zt_item, parent, false);

        } else if (tag ==TagUtils.  DETAIL_STYLE) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);

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
        Movie movie = ((Movie) getItem(position));
        OpenCardView openCardView = (OpenCardView) viewHolder.view;
        openCardView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

//                    if(v.findViewById(R.id.my_img)!=null){
//
//                        v.findViewById(R.id.my_img).animate().scaleX(1.1f).scaleY(1.1f).translationZ(100.0f).setDuration(300).start();
//
//                    }else{
                        v.animate().scaleX(1.1f).scaleY(1.1f).translationZ(100.0f).setDuration(300).start();

//                    }

                } else {

//                    if(v.findViewById(R.id.my_img)!=null){
//                        v.findViewById(R.id.my_img).animate().scaleX(1.0f).scaleY(1.0f).translationZ(8.0f).setDuration(300).start();
//
//                    }else{
                        v.animate().scaleX(1.0f).scaleY(1.0f).translationZ(8.0f).setDuration(300).start();

//                    }

                }
            }

        });

        if((int)openCardView.getTag()==HEAD_STYLE){
            ((ImageView) openCardView.findViewById(R.id.my_img)).setImageResource(R.drawable.asd);

        }else if((int)openCardView.getTag()==MOVIE_STYLE){
            ( openCardView.findViewById(R.id.my_img)).setBackgroundResource(R.mipmap.movie);

        }

//        Drawable d = viewHolder.view.getResources().getDrawable(R.drawable.shili);
//        openCardView.setShadowDrawable(d);

//        if(openCardView.findViewById(R.id.my_img)!=null) {
//            openCardView.findViewById(R.id.my_img).setTranslationZ(8.0f);
//
//        }else {
            openCardView.setTranslationZ(8.0f);
//        }

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
            }else if((int)openCardView.getTag()==TagUtils.DETAIL_STYLE){
                RecyclerViewTV.LayoutParams layoutParams = (RecyclerViewTV.LayoutParams) openCardView.getLayoutParams();
                layoutParams.setMargins(91, 18, 25, 70);
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
            }else if((int)openCardView.getTag()==TagUtils.DETAIL_STYLE){
                RecyclerViewTV.LayoutParams layoutParams = (RecyclerViewTV.LayoutParams) openCardView.getLayoutParams();
                layoutParams.setMargins(25, 18, 91, 70);
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
            }else if((int)openCardView.getTag()==TagUtils.DETAIL_STYLE){
                RecyclerViewTV.LayoutParams layoutParams = (RecyclerViewTV.LayoutParams) openCardView.getLayoutParams();
                layoutParams.setMargins(25, 18, 25, 70);
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


}
