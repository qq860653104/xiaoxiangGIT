/*
 * Copyright (C) 2016 hejunlin <hejunlin2013@gmail.com>
 * Github:https://github.com/hejunlin2013/TVSample
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chunleikeji.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;


/**
 * Created by hejunlin on 2015/7/19.
 * blog: http://blog.csdn.net/hejjunlin
 */
public class DrawingOrderRelativeLayout extends RelativeLayout {
    private int position = 0;

    public DrawingOrderRelativeLayout(Context context) {
        super(context);
    }

    public DrawingOrderRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setChildrenDrawingOrderEnabled(true);
    }

    public void setCurrentPosition(int pos) {
        this.position = pos;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
            View focused = findFocus();
            int pos = indexOfChild(focused);
            if (pos >= 0 && pos < getChildCount()) {
                setCurrentPosition(pos);
                postInvalidate();
            }
//        Log.e("TAA","  这是i："+pos+"_____"+event.getAction()+"_______"+ getChildCount());

        return super.dispatchKeyEvent(event);
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        View v = getFocusedChild();
        int pos = indexOfChild(v);
        if (pos >= 0 && pos < childCount)
            setCurrentPosition(pos);
        if (i == childCount - 1) {
//            Log.e("TAA","第一个-："+position);
            return position;
        }
        if (i == position) {
//            Log.e("TAA","第二个-："+(childCount - 1));

            return childCount - 1;
        }

        return i;
    }

//
//    @Override
//    public void setOnClickListener(@Nullable OnClickListener l) {
//
//
//        Log.e("TAA","PARENT "+l);
//
//
//        super.setOnClickListener(l);
//
//
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

//        Log.e("TAA","PARENT "+keyCode);
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public View focusSearch(View focused, int direction) {

//        Log.e("TAA","PARENT "+focused+"___"+direction);




//        if(focused.getId()== R.id.view4||focused.getId()== R.id.view5&&direction==33){
////            findViewById(R.id.topsousuo).requestFocus();
////            Log.e("TAA","PARENT ___"+direction+"_______"+focused+"_______"+getNextFocusForwardId()+"_______"+getNextFocusUpId()+"_________"+getNextFocusDownId()+"______"+getNextFocusLeftId()+"_________"+getNextFocusRightId());
////
////            if(onOutGroupLinstener!=null){
////                onOutGroupLinstener.onOut();
////            }
//            return super.focusSearch(focused, 130);
//
////            return  focused;
//        }
//
//        if(focused==first&&direction==17){
//
//            return  focused;
//        }


        return super.focusSearch(focused, direction);
    }


    public void setOnOutGroupLinstener( onOutGroup outGroupLinstener){

        this.onOutGroupLinstener = outGroupLinstener;
    }
    onOutGroup onOutGroupLinstener;

    public interface onOutGroup{

       public void  onOut();

    }


    @Override
    protected void onFocusChanged(boolean gainFocus, int direction,  Rect previouslyFocusedRect) {
//        Log.e("TAA","PARENT ___"+direction+"_______"+gainFocus+"_________"+getFocusedChild());
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
//        Log.e("TAA","PARENT __"+hasWindowFocus+"_________"+getFocusedChild());

        super.onWindowFocusChanged(hasWindowFocus);
    }


    //    @Override
//    public boolean callOnClick() {
//        Log.e("TAA","PARENT ");
//        return super.callOnClick();
//    }
}
