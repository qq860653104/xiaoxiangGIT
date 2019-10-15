package com.chunleikeji.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chunleikeji.xiangxianglib.R;
import com.open.androidtvwidget.bean.ZhuanTiBean;
import com.open.androidtvwidget.leanback.mode.DefualtListPresenter;
import com.open.androidtvwidget.leanback.widget.OpenCardView;




/**
 * Leanback 横向item demo.
 * 如果你想改变标题头的样式，那就写自己的吧.
 * Created by hailongqiu on 2016/8/25.
 */
public class MoviceListPresenter extends DefualtListPresenter {

    boolean mIsSelect;

    /**
     *
     */
    int HEAD_STYLE = 1;
    int MOVIE_STYLE = 2;
    int ZT_STYLE = 3;

    TextView tag;

    public MoviceListPresenter(TextView tag) {

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


        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.zhuanti_movie_item, parent, false);


//        itemView.setTag(tag);

        return new ViewHolder(itemView);
    }

    public void setSelect(boolean isSelect) {
        this.mIsSelect = isSelect;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        ZhuanTiBean.DataBean movie = ((ZhuanTiBean.DataBean) getItem(position));






        final OpenCardView openCardView = (OpenCardView) viewHolder.view;
        openCardView.setTag(R.id.position,position);

//        TextView pf =  openCardView.findViewById(R.id.pingfen);
//
//        if(pf!=null&&movie.getPf()!=null){//设置评分
//
//
//            pf.setText(movie.getPf());
//
//
//        }


        final ImageView roundedImageView = openCardView.findViewById(R.id.my_img);
        MoreTextView moreTextView = openCardView.findViewById(R.id.moretext);
        TextView bq = openCardView.findViewById(R.id.pingfen);
        bq.setText(movie.getPf());
        moreTextView.setTag(position+1);
        openCardView.setTag(R.id.dybean,movie);

        if (openCardView.getOnFocusChangeListener() == null) {
            openCardView.setOnFocusChangeListener(new View.OnFocusChangeListener() {



                @Override
                public void onFocusChange(final View v, boolean hasFocus) {


                    if (hasFocus) {
                        v.animate().scaleX(1.1f).scaleY(1.1f).setDuration(300).start();

                        MoreTextView viewById = (MoreTextView) openCardView.findViewById(R.id.moretext);
                        OpenCardView parent_img = (OpenCardView) openCardView.findViewById(R.id.img_parent);

                        if (parent_img != null) {
                            viewById.startMoreText();
                            Drawable d = viewHolder.view.getResources().getDrawable(R.drawable.test3);
                            parent_img.setShadowDrawable(d);

                        }
                        tag.setText(viewById.getTag()+"");
                    } else {
                        v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();

                        MoreTextView viewById = (MoreTextView) openCardView.findViewById(R.id.moretext);
                        OpenCardView parent_img = (OpenCardView) openCardView.findViewById(R.id.img_parent);

                        if (parent_img != null) {
                            viewById.hintMoreText();
                            Drawable b = viewHolder.view.getResources().getDrawable(R.drawable.asdfgh);
                            parent_img.setShadowDrawable(b);

                        }
                    }

                }

            });
        }




        moreTextView.setText(movie.getTitle());

        String img = movie.getPic();
        if(img!=null) {

            Glide.with(roundedImageView.getContext())
                    .load(img)
                    .error(R.drawable.defult_movie2)
                    .into(roundedImageView);

        }

//        if ((int) openCardView.getTag() == HEAD_STYLE) {
//            openCardView.setBackgroundResource(R.drawable.asd);
//
//        } else if ((int) openCardView.getTag() == MOVIE_STYLE) {
//            openCardView.findViewById(R.id.item_img).setBackgroundResource(R.mipmap.movie);
//
//        }

//        if (openCardView.findViewById(R.id.item_img) != null) {
//            ((OpenCardView) openCardView.findViewById(R.id.item_img)).setBackgroundResource(R.mipmap.movie);
//        }

        if (openCardView.findViewById(R.id.item_img) != null && openCardView.findViewById(R.id.movie_text) != null) {
//            openCardView.findViewById(R.id.item_img).animate().translationZ(8.0f).setDuration(100).start();
//            openCardView.findViewById(R.id.movie_text).animate().translationZ(8.0f).setDuration(100).start();

        }
//        Drawable d = viewHolder.view.getResources().getDrawable(R.drawable.shili);
//        openCardView.setShadowDrawable(d);

//        openCardView.setTranslationZ(8.0f);


        Log.e("TAA", "啊啊啊啊啊：" + openCardView.getTag());
//        if(tag!=4) {
    //    RecyclerViewTV.LayoutParams layoutParams = (RecyclerViewTV.LayoutParams) openCardView.getLayoutParams();
//        layoutParams.setMargins(0, 0, 32, 16);
     //   openCardView.setLayoutParams(layoutParams);
//        }else{
//
//        }


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
