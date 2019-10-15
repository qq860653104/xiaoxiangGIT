package com.chunleikeji.network.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chunleikeji.xiangxianglib.R;




/**
 * Created by wh on 2018/4/8.
 */

public class AllMovieRecyclerView extends RecyclerView {


    public AllMovieRecyclerView(Context context) {
        super(context);
    }

    public AllMovieRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AllMovieRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public View focusSearch(int direction) {

        Log.e("TAA","经过了2：" + direction);
        return super.focusSearch(direction);

    }


    private int saveTag;
    private View saveFocused;

    @Override
    public View focusSearch(View focused, int direction) {
        final TextView textView = (TextView) focused.findViewById(R.id.title_tv);

//        textView.setText(labels.get(position));

        Log.e("TAA","经过了1:"+textView.getTag()+"_____"+direction);

        int tag = (int) textView.getTag();


        return super.focusSearch(focused, direction);

//        if((tag+1)==saveTag||(tag-1)==saveTag||tag==saveTag){
//            saveFocused =  focused;
//            return super.focusSearch(focused, direction);
//
//        }else{
//            if(saveFocused!=null) {
//                return super.focusSearch(saveFocused, direction);
//            }else{
//                return super.focusSearch(focused, direction);
//            }
//
//        }
    }

    @Override
    public void requestChildFocus(View child, View focused) {

        Log.e("TAA","经过了3："  );

        super.requestChildFocus(child, focused);
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        Log.e("TAA","经过了4：" + direction);

        return super.requestFocus(direction, previouslyFocusedRect);
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        Log.e("TAA","去右边了"+keyCode);
//
//        if(keyCode==KeyEvent.KEYCODE_DPAD_RIGHT){
////            Log.e("TAA","去右边了"+keyCode);
////            Toast.makeText(getContext(), "去了右边", Toast.LENGTH_SHORT).show();
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }


    //    focus
}

