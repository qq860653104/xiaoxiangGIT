package com.chunleikeji.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chunleikeji.util.ClassSaveUtils;
import com.chunleikeji.xiangxianglib.R;




/**
 * Created by wh on 2018/1/5.
 */

public class DetailTextMoreView extends TextView implements View.OnClickListener {


    public DetailTextMoreView(Context context) {
        super(context);
    }

    public DetailTextMoreView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DetailTextMoreView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
//        setBackgroundResource(R.drawable.tv_button_select);
        setOnClickListener(this);
    }

    //原来的完整内容
    private String saveText;

    /**
     * @param text 显示的内容
     * @param end  终结的尾巴
     */
    public void setMoreText(String text, int end) {
        if (text != null) {
            saveText = text;
            String txt = text;
            Log.e("TAA","setMoreText:"+txt.length()+"_________"+end+"____is:"+(txt.length() <= end));
            if (txt.length() > end) {
                txt = text.substring(0, end) + "...";
            }


            setText(Html.fromHtml(text));
        } else {
            setText("暂无介绍...");
        }
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (focused) {
//            this.animate().translationZ(15.0f).setDuration(300).start();
            setBackgroundResource(R.drawable.tv_button_select);

//            setbac
        } else {
//            this.animate().translationZ(3.0f).setDuration(300).start();
            setBackgroundResource(0);

        }


        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }


    //进入详情页
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), ClassSaveUtils.DetailInfoActivity);
        intent.putExtra("info", saveText);
        intent.putExtra("bg", bg_img);

        v.getContext().startActivity(intent);
        ((Activity) v.getContext()).overridePendingTransition(R.anim.activity_in, R.anim.activity_over);
    }

    private String bg_img ;
    public void setInfoBg(String img ) {
        int bool = img.indexOf("attachment");
        String imgText  =img;
        if(bool>0){
            imgText = "http://xiaocui.tv"+imgText;
        }else{
        }
        bg_img =  imgText;
    }
}
