package com.chunleikeji.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by wh on 2018-09-12.
 */

public class ButtonView extends TextView {
    public ButtonView(Context context) {
        super(context);
    }

    public ButtonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ButtonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private int defult_img,focu_img;


    public ButtonViewFocu getButtonViewFocu() {
        return buttonViewFocu;
    }

    public void setButtonViewFocu(ButtonViewFocu buttonViewFocu) {
        this.buttonViewFocu = buttonViewFocu;
    }

    ButtonViewFocu buttonViewFocu;

    public interface ButtonViewFocu{
        public void onFocuse(boolean b, View view);

    }

    public void init(final int defult_img, final int focu_img){
           this.defult_img = defult_img;
           this.focu_img = focu_img;
           setOnFocusChangeListener(new OnFocusChangeListener() {



               @Override
               public void onFocusChange(View v, boolean hasFocus) {


                   if(hasFocus){
                       //选中则设置选中图
                      setBackgroundResource(focu_img);

                   }else{
                       //未选中的图
                       setBackgroundResource(defult_img);


                   }

                   if(buttonViewFocu!=null){
                       buttonViewFocu.onFocuse(hasFocus,v);
                   }


               }
           });


    }


}
