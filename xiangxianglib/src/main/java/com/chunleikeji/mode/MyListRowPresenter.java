package com.chunleikeji.mode;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chunleikeji.xiangxianglib.R;
import com.open.androidtvwidget.leanback.adapter.GeneralAdapter;
import com.open.androidtvwidget.leanback.mode.ListRow;
import com.open.androidtvwidget.leanback.mode.OpenPresenter;
import com.open.androidtvwidget.leanback.widget.ItemContainerView;
import com.open.androidtvwidget.leanback.widget.OpenCardView;
import com.open.androidtvwidget.menu.OpenMenuItemView;

import java.util.List;


/**
 * Created by wh on 2018/1/3.
 */

public class MyListRowPresenter extends OpenPresenter {

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
    public MyListRowPresenter(List<ListRow> items, OpenPresenter headPresenter, OpenPresenter listPresenter) {
        this.mItems = items;
        this.mItemHeaderPresenter = headPresenter;
        this.mItemListPresenter = listPresenter;

    }

    public MyListRowPresenter(List<ListRow> items) {
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

    /**
     * 设置标题头的Presenter.
     */
    public void setHeadPresenter(OpenPresenter presenter) {
        this.mItemHeaderPresenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemContainerView itemContainerView = new ItemContainerView(parent.getContext());

        // 添加标题头.
        ViewHolder headVH = null;
//        if (mItemHeaderPresenter != null) {
//            Log.e("TAA","————————————"+viewType);
//            headVH = mItemHeaderPresenter.onCreateViewHolder(parent, viewType);
//            itemContainerView.addHeaderView(headVH.view);
//        }
//        // 添加横向控件.
//        ViewHolder listVH = null;
//        if (mItemListPresenter != null) {
//            listVH = mItemListPresenter.onCreateViewHolder(parent, viewType);
//            itemContainerView.addRowView(listVH.view);
//        }
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_right_item_gridview, parent, false);
        itemContainerView.addRowView(itemView);


        OpenCardView openCardView = (OpenCardView) itemView;
        openCardView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                    v.findViewById(R.id.item_img).animate().scaleX(1.1f).scaleY(1.1f).translationZ(30.0f).setDuration(300).start();

                } else {

                    v.findViewById(R.id.item_img).animate().scaleX(1.0f).scaleY(1.0f).translationZ(8.0f).setDuration(300).start();

                }
            }

        });

        openCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myItemClick!=null){
                    myItemClick.onClick(view);
                }
            }
        });

        //
        return new MyListRowPresenter.ListRowViewHolder(itemContainerView, headVH, null);
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

    private int textSize ;
    private int textColor;
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        MyListRowPresenter.ListRowViewHolder listRowViewHolder = (MyListRowPresenter.ListRowViewHolder) viewHolder;
        ListRow listRow = mItems.get(position);

        if (listRowViewHolder.mHeadViewHolder != null) {


            mItemHeaderPresenter.onBindViewHolder(listRowViewHolder.mHeadViewHolder, listRow.getHeaderItem());

            if(listRow.getHeaderItem()!=null){
//                listRowViewHolder.mHeadViewHolder.view.setPadding(88,73,31,0);
//                ((OpenMenuItemView)listRowViewHolder.mHeadViewHolder.view).setTextSize(textSize);
//                ((OpenMenuItemView)listRowViewHolder.mHeadViewHolder.view).setTextColor(textColor);

//                Log.e("TAA","onBindViewHolder:"+ listRowViewHolder.mHeadViewHolder.view);
                if( viewHolder.view instanceof OpenMenuItemView) {
//                    ((OpenMenuItemView) viewHolder.view).setTextSize(textSize);//40
//                    ((OpenMenuItemView) viewHolder.view).setTextColor(textColor);//Color.DKGRAY
                }
            }

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

    public MyItemClick getMyItemClick() {
        return myItemClick;
    }

    public void setMyItemClick(MyItemClick myItemClick) {
        this.myItemClick = myItemClick;
    }

    MyItemClick myItemClick;

    public interface MyItemClick{

        public void onClick(View view);


    }

}
