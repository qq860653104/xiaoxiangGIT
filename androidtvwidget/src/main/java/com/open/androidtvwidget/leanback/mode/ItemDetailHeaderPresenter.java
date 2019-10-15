package com.open.androidtvwidget.leanback.mode;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.open.androidtvwidget.R;
import com.open.androidtvwidget.menu.OpenMenuItemView;

/**
 * 标题头的 Presenter. (test)
 * Created by hailongqiu on 2016/8/24.
 */
public class ItemDetailHeaderPresenter extends OpenPresenter {

    public static final int XLIE = 1;//系列的

    public ItemDetailHeaderPresenter() {

    }

    private int textSize;
    private int textColor;
    private int pandingTop;
    private int pandingLeft;
    private int pandingRight;
    private int pandingBottom;
    private int tag;


    public ItemDetailHeaderPresenter(int textSize, int textColor, int pandingLeft, int pandingTop,
                                     int pandingRight, int pandingBottom, int tag) {
        this.textSize = textSize;
        this.textColor = textColor;
        this.pandingTop = pandingTop;
        this.pandingLeft = pandingLeft;
        this.pandingRight = pandingRight;
        this.pandingBottom = pandingBottom;
        this.tag = tag;
    }

    public ItemDetailHeaderPresenter(int textSize, int textColor, int pandingLeft, int pandingTop,
                                     int pandingRight, int pandingBottom) {
        this.textSize = textSize;
        this.textColor = textColor;
        this.pandingTop = pandingTop;
        this.pandingLeft = pandingLeft;
        this.pandingRight = pandingRight;
        this.pandingBottom = pandingBottom;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View headview = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu_item_layout, parent, false);
        TextView viewById = (TextView) headview.findViewById(R.id.title_tv);
        if (viewById != null && !"ok".equals(viewById.getTag())) {
            viewById.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            viewById.setTextColor(textColor);
            viewById.setPadding(pandingLeft, pandingTop, pandingRight, pandingBottom);
            viewById.setTag("ok");
            if (tag == XLIE) {
                viewById.setVisibility(View.GONE);

                TextView viewById2 = (TextView) headview.findViewById(R.id.movie_right_number);
                viewById2.setVisibility(View.VISIBLE);
                viewById2.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                viewById2.setTextColor(textColor);
                viewById2.setPadding(pandingLeft, pandingTop, pandingRight, pandingBottom);
            }

        }

        return new ItemHeadViewHolder(headview);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) viewHolder.view.getLayoutParams();

        ((OpenMenuItemView) viewHolder.view).setTitle((String) item);
//         if ("最新电影".equals((String) item)) {
//            ((OpenMenuItemView) viewHolder.view).setPadding(pandingLeft,pandingTop,pandingRight,pandingBottom);
            lp.height = 0;
            ((OpenMenuItemView) viewHolder.view).setVisibility(View.INVISIBLE);

//        }
    }

    static class ItemHeadViewHolder extends ViewHolder {
        public ItemHeadViewHolder(View view) {
            super(view);
        }
    }

}
