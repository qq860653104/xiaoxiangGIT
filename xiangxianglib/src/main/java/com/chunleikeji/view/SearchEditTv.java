package com.chunleikeji.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by wh on 2018/1/1.
 */

public class SearchEditTv extends android.support.v7.widget.AppCompatTextView {
    public SearchEditTv(Context context) {
        super(context);
    }

    public SearchEditTv(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SearchEditTv(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    public SearchEditTv(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }


    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        if(text.toString()!=null&&onSearchTextChange!=null){
            onSearchTextChange.onChange(text.toString(),start,lengthBefore,lengthAfter);
        }
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }

    public OnSearchTextChange getOnSearchTextChange() {
        return onSearchTextChange;
    }

    public void setOnSearchTextChange(OnSearchTextChange onSearchTextChange) {
        this.onSearchTextChange = onSearchTextChange;
    }

    private OnSearchTextChange onSearchTextChange;

    public void delete() {
        if(getText().toString()!=null&&getText().toString().length()!=0) {
            setText(getText().subSequence(0, getText().length() - 1));
        }
    }

    public interface OnSearchTextChange{

        public  void  onChange(String text, int start, int lengthBefore, int lengthAfter);

    }


    public void setSearchText(String text){
        setText(getText()+text);
    }
}
