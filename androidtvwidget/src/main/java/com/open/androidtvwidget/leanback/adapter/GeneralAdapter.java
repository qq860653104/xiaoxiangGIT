package com.open.androidtvwidget.leanback.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.open.androidtvwidget.leanback.mode.OpenPresenter;

/**
 * RecyclerView 通用 Adapter.
 * Created by hailongqiu on 2016/8/22.
 */
public class GeneralAdapter extends RecyclerView.Adapter {

    private OpenPresenter mPresenter;

    public static final int TYPE_HEADER = 2;


    public View getmHeaderView() {
        return mHeaderView;
    }

    public void setmHeaderView(View mHeaderView) {
        this.mHeaderView = mHeaderView;
    }

    private View mHeaderView;

    public GeneralAdapter(OpenPresenter presenter) {
        this.mPresenter = presenter;
        if (this.mPresenter != null)
            this.mPresenter.setAdapter(this);
    }

    public OpenPresenter getPresenter() {
        return this.mPresenter;
    }

    @Override
    public int getItemViewType(int position) {
//        if (mHeaderView == null) {
//            return this.mPresenter.getItemViewType(position);
//
//        }
//        if (position == 0 && mHeaderView != null) {
//            return TYPE_HEADER;
//        }

        return this.mPresenter.getItemViewType(position);

//        Log.e("TAA","itemViewTypegetItemViewType:"+this.mPresenter.getItemViewType(position));
//        return this.mPresenter.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
       // return mHeaderView == null ? this.mPresenter.getItemCount() : 1;
        return this.mPresenter.getItemCount();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//
//        if (mHeaderView != null && viewType == TYPE_HEADER)
//            return new ViewHolder(mHeaderView, null, null);



        View view;
        OpenPresenter presenter = this.mPresenter;
        OpenPresenter.ViewHolder presenterVh;
        presenterVh = presenter.onCreateViewHolder(parent, viewType);
        view = presenterVh.view;
        ViewHolder viewHolder = new ViewHolder(view, presenter, presenterVh);
        return viewHolder;
    }

    public void notifyHolder() {

    }

    private boolean tag;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;

//        if (getItemViewType(position) == TYPE_HEADER) {
//            return;
//        }

        Log.e("TAG", "onCreateViewHolder: " + position );

//        viewHolder.setIsRecyclable(false);
//        if(!tag||position<5) {
        viewHolder.mPresenter.onBindViewHolder(viewHolder.getViewHolder(), position);
//        }

    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        ViewHolder viewHolder = (ViewHolder) holder;
        if (viewHolder.mPresenter != null)
            viewHolder.mPresenter.onViewAttachedToWindow(viewHolder.mHolder);
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        ViewHolder viewHolder = (ViewHolder) holder;
        if (viewHolder.mPresenter != null)
            viewHolder.mPresenter.onViewDetachedFromWindow(viewHolder.mHolder);
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        ViewHolder viewHolder = (ViewHolder) holder;
        if (viewHolder.mPresenter != null)
            viewHolder.mPresenter.onUnbindViewHolder(viewHolder.mHolder);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        OpenPresenter.ViewHolder mHolder;
        OpenPresenter mPresenter;


        public ViewHolder(View itemView) {
            super(itemView);
//            if (itemView == getmHeaderView()) {
//                return;
//            }
        }

        public ViewHolder(View itemView, OpenPresenter presenter, OpenPresenter.ViewHolder holder) {
            super(itemView);
//            if (itemView == getmHeaderView()) {
//                return;
//            }
            this.mPresenter = presenter;
            this.mHolder = holder;
//            super(itemView);
//            this.mPresenter = presenter;
//            this.mHolder = holder;

        }

        public OpenPresenter.ViewHolder getViewHolder() {
            return this.mHolder;
        }

        public OpenPresenter getOpenPresenter() {
            return this.mPresenter;
        }

    }
}
