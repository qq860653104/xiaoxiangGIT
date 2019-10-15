package com.chunleikeji.mode;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chunleikeji.bean.HomeBean;
import com.chunleikeji.tag.TagUtils;
import com.chunleikeji.view.MoreTextView;
import com.chunleikeji.xiangxianglib.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.open.androidtvwidget.bean.Pg_DetailBean;
import com.open.androidtvwidget.leanback.mode.DefualtListPresenter;
import com.open.androidtvwidget.leanback.widget.OpenCardView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 * Leanback 横向item demo.
 * 如果你想改变标题头的样式，那就写自己的吧.
 * Created by hailongqiu on 2016/8/25.
 */
public class DetailMoviceListPresenter extends DefualtListPresenter {

    boolean mIsSelect;
    Drawable mDefaultBackground;
    /**
     *
     */
    int HEAD_STYLE = 1;
    int MOVIE_STYLE = 2;
    int ZT_STYLE = 3;

    int tag;

    public DetailMoviceListPresenter() {

    }


    public DetailMoviceListPresenter(int tag) {

        this.tag = tag;
        setTAG(tag);
    }

    List<HomeBean.DataBean.DyBean> movie;
    Context context;

    public DetailMoviceListPresenter(int tag, List<HomeBean.DataBean.DyBean> movie, Context context) {
        this.tag = tag;
        setTAG(tag);
        this.movie = movie;
        mDefaultBackground = context.getResources().getDrawable(R.drawable.defult_movie2);
        this.context = context;
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
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_item, parent, false);
        itemView.setTag(tag);

        return new ViewHolder(itemView);
    }


    public void setSelect(boolean isSelect) {
        this.mIsSelect = isSelect;
    }


    Map<Integer, Drawable> imageList = new HashMap<Integer, Drawable>();

    int i = 0;

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {


        final OpenCardView openCardView = (OpenCardView) viewHolder.view;
        openCardView.setTag(R.id.position,position);
        if (getItem(position) instanceof Pg_DetailBean.ListBean) {
            MoreTextView moreTextView = openCardView.findViewById(R.id.moretext);
            final RoundedImageView roundedImageView = openCardView.findViewById(R.id.my_img);
            Pg_DetailBean.ListBean dyBean = null;
            List<Pg_DetailBean.ListBean> tuijian = null;
//            DetailBean.TuijianBean tuijianBean = tuijian.get(0);
            dyBean = (Pg_DetailBean.ListBean) getItem(position);

//            Log.e("TAA","推荐的："+dyBean.getName()+"________________"+position);
            String imgText  = dyBean.getPic();
//            int bool = dyBean.getPic().indexOf("attachment");

//            if(bool>0){
//                imgText = "http://xiaocui.tv"+imgText;
//            }else{
//            }

            TextView pingfen =  openCardView.findViewById(R.id.pingfen);
//            pingfen.setText(dyBean.getD_score());

            openCardView.setTag(R.id.dybean,dyBean);
//            if(dyBean.getCaCheBitmap()!=null){
//                roundedImageView.setImageBitmap(dyBean.getCaCheBitmap());
//                moreTextView.setText(dyBean.getName());
//            }else {
                Glide.with(context)
                        .load(imgText)
                        .error(R.drawable.defult_movie2)
                        .into(roundedImageView);
                moreTextView.setText(dyBean.getTitle());
//            }
        }



        OpenCardView parent_img = (OpenCardView) openCardView.findViewById(R.id.img_parent);

        if (parent_img != null && !"ok".equals(parent_img.getTag())) {
            Drawable d = viewHolder.view.getResources().getDrawable(R.drawable.asdfgh);
            d = viewHolder.view.getResources().getDrawable(R.drawable.asdfgh);
//            parent_img.setShadowDrawable(d);
            parent_img.setTag("ok");

        }
        if (openCardView.getOnFocusChangeListener() == null) {
            openCardView.setOnFocusChangeListener(new View.OnFocusChangeListener() {


                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onFocusChange(final View v, boolean hasFocus) {


                    if (hasFocus) {
                        if (tag == TagUtils.HEAD_STYLE) {
                            v.animate().scaleX(1.02f).scaleY(1.1f).setDuration(300).start();
                        } else {
                            v.animate().scaleX(1.1f).scaleY(1.1f).setDuration(300).start();
                        }

                        MoreTextView viewById = (MoreTextView) openCardView.findViewById(R.id.moretext);
                        OpenCardView parent_img = (OpenCardView) openCardView.findViewById(R.id.img_parent);

                        if (parent_img != null) {
                            viewById.startMoreText();
                            Drawable d = viewHolder.view.getResources().getDrawable(R.drawable.test3);
//                            parent_img.setShadowDrawable(d);

                        }
                    } else {
                        v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).start();

                        MoreTextView viewById = (MoreTextView) openCardView.findViewById(R.id.moretext);
                        OpenCardView parent_img = (OpenCardView) openCardView.findViewById(R.id.img_parent);

                        if (parent_img != null) {
                            viewById.hintMoreText();
                            Drawable b = viewHolder.view.getResources().getDrawable(R.drawable.asdfgh);
//                            parent_img.setShadowDrawable(b);

                        }
                    }

                }

            });
        }

    }




}
