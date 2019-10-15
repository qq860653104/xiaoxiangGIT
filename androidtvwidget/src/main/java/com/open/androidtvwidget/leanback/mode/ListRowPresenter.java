package com.open.androidtvwidget.leanback.mode;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.open.androidtvwidget.R;
import com.open.androidtvwidget.leanback.adapter.GeneralAdapter;
import com.open.androidtvwidget.leanback.recycle.RecyclerViewTV;
import com.open.androidtvwidget.leanback.widget.ItemContainerView;
import com.open.androidtvwidget.menu.OpenMenuItemView;
import com.open.androidtvwidget.utils.DensityUtil;
import com.open.androidtvwidget.viewpager.ImagePagerAdapter;
import com.open.androidtvwidget.viewpager.ThreeDPageTransformer;

import java.util.ArrayList;
import java.util.List;


/**
 * Leanback ListRowPresenter 控制层.
 * Created by hailongqiu on 2016/8/24.
 */
public class ListRowPresenter extends OpenPresenter {

    OpenPresenter mItemHeaderPresenter;//  item 标题头的 Presenter.
    OpenPresenter mItemListPresenter;// item 标题头下面的 横向 items.

    List<ListRow> mItems;
    GeneralAdapter mAdapter;

    /**
     * 你可以设置自己的 头 presenter, 还有横向 presenter.
     *
     * @param items
     * @param headPresenter
     * @param listPresenter
     */
    public ListRowPresenter(List<ListRow> items, OpenPresenter headPresenter, OpenPresenter listPresenter) {
        this.mItems = items;
        this.mItemHeaderPresenter = headPresenter;
        this.mItemListPresenter = listPresenter;

    }

    public ListRowPresenter(List<ListRow> items) {
        this(items, null, null);
    }

    @Override
    public void setAdapter(GeneralAdapter adapter) {
        this.mAdapter = adapter;
    }

    public void setItems(List<ListRow> items, int position) {
        this.mItems = items;
        if (this.mAdapter != null)
            this.mAdapter.notifyItemChanged(position);
    }

    public void setItems(List<ListRow> items) {
        this.mItems = items;
        if (this.mAdapter != null)
            this.mAdapter.notifyDataSetChanged();
    }

    public List<ListRow> getItems() {
        return this.mItems;
    }

    @Override
    public int getItemCount() {
        return mItems != null ? mItems.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    boolean isadd;

    /**
     * 设置标题头的Presenter.
     */
    public void setHeadPresenter(OpenPresenter presenter) {
        this.mItemHeaderPresenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        ItemContainerView itemContainerView = new ItemContainerView(parent.getContext());

        // 添加标题头.
        ViewHolder headVH = null;
        if (mItemHeaderPresenter != null) {
            headVH = mItemHeaderPresenter.onCreateViewHolder(parent, viewType);
            itemContainerView.addHeaderView(headVH.view);
        }
        // 添加横向控件.
        ItemListPresenter.ItemListViewHolder listVH = null;
        if (mItemListPresenter != null) {
            listVH = (ItemListPresenter.ItemListViewHolder) mItemListPresenter.onCreateViewHolder(parent, viewType);
            itemContainerView.addRowView(listVH.view);

        }
        return new ListRowViewHolder(itemContainerView, headVH, listVH);
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    private int textSize;
    private int textColor;

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
//        if(){
//
//        }

        ListRowViewHolder listRowViewHolder = (ListRowViewHolder) viewHolder;
        ListRow listRow = mItems.get(position);

        if (listRowViewHolder.mHeadViewHolder != null) {
            mItemHeaderPresenter.onBindViewHolder(listRowViewHolder.mHeadViewHolder, listRow.getHeaderItem());
        }

        if (listRowViewHolder.mListViewHolder != null) {
            mItemListPresenter.onBindViewHolder(listRowViewHolder.mListViewHolder, listRow);
        }

    }

    public static class ListRowViewHolder extends OpenPresenter.ViewHolder {

        ViewHolder mHeadViewHolder;
        ViewHolder mListViewHolder;

        public ListRowViewHolder(View view, ViewHolder headVH, ViewHolder lilstVH) {
            super(view);
            this.mHeadViewHolder = headVH;
            this.mListViewHolder = lilstVH;
        }

        public ViewHolder getListViewHolder() {
            return mListViewHolder;
        }
    }

    public ListRowItemClickListener getListRowItemClickListener() {
        return listRowItemClickListener;
    }

    public void setListRowItemClickListener(ListRowItemClickListener listRowItemClickListener) {
        this.listRowItemClickListener = listRowItemClickListener;
    }

    ListRowItemClickListener listRowItemClickListener;

    public interface ListRowItemClickListener {

        public void onItemClick();

    }


}
