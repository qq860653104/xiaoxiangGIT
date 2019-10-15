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

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;


/**
 * Created by hejunlin on 2015/7/19.
 * blog: http://blog.csdn.net/hejjunlin
 */
public class MetroItemFrameLayout extends FrameLayout implements IMetroItemRound {

    private MetroItemRound mMetroItemRound;

    public MetroItemFrameLayout(Context context) {
        super(context);
        init(context, null, 0);
    }

    public MetroItemFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public MetroItemFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        mMetroItemRound = new MetroItemRound(this, context, attrs, defStyle);
        setWillNotDraw(false);

    }

//    @Override
//    public boolean onKeyUp(int keyCode, KeyEvent event) {
////        Log.e("TAA","MOVE_UP"+keyCode+"_________"+getId());
////        Toast.makeText(getContext(),"MOVE_UP"+keyCode+"_________"+getId()+"________________"+ R.id.view4,Toast.LENGTH_LONG).show();
////        Log.e("TAA",""+event.);
////        Log.e("TAA","_____action__"+event.get);
//        if(keyCode==23){
//            switch (getId()){
//
//                case R.id.view4://视频
//                    GetBean.modole="video";
//                    GetBean.tag = "http://kphz.kpsns.cn/index.php?c=api&m=data2&auth=e16ecea319d246ca3335cac2a0188d6a&param=function&name=dr_kphz_video_list&p1=video&p2=20";
//                 getContext().startActivity(new Intent(getContext(), MainActivity.class));
//                break;
//
//                case R.id.view10://历史纪录
//                    GetBean.modole="video";
//                    Toast.makeText(getContext(),"功能暂未开放",Toast.LENGTH_SHORT).show();
////                    getContext().startActivity(new Intent(getContext(), MainActivity.class));
//                    break;
//                case R.id.view11://离线下载
//                    GetBean.modole="video";
////                    getContext().startActivity(new Intent(getContext(), MainActivity.class));
//                    Toast.makeText(getContext(),"功能暂未开放",Toast.LENGTH_SHORT).show();
//
//                    break;
//                case R.id.view2://社区e站
//                    GetBean.modole="hunhe";
//                    GetBean.tag = "http://kphz.kpsns.cn/index.php?c=api&m=data2&auth=7011a87ed2154b8e6b21584aa02583a1&function=dr_function_ezhan&param=list action=content id=1 module=special";
//
//                    getContext().startActivity(new Intent(getContext(), MainActivity.class));
//                    break;
//                case R.id.view6://农村e站
//                    GetBean.modole="hunhe";
//                    GetBean.tag = "http://kphz.kpsns.cn/index.php?c=api&m=data2&auth=7011a87ed2154b8e6b21584aa02583a1&function=dr_function_ezhan&param=list action=content id=2 module=special";
//
//                    getContext().startActivity(new Intent(getContext(), MainActivity.class));
//                    break;
//                case R.id.view3://精准扶贫
//                    GetBean.modole="news";
//                    GetBean.tag = "http://kphz.kpsns.cn/index.php?c=api&m=data2&auth=e16ecea319d246ca3335cac2a0188d6a&param=function&name=dr_kphz_news_list&p1=jzfp&p2=20";
//
//                    getContext().startActivity(new Intent(getContext(), MainActivity.class));
//                    break;
//                case R.id.view5://咨询
//                    GetBean.modole="news";
//                    GetBean.tag = "http://kphz.kpsns.cn/index.php?c=api&m=data2&auth=e16ecea319d246ca3335cac2a0188d6a&param=function&name=dr_kphz_news_list&p1=news&p2=20";
//
//                    getContext().startActivity(new Intent(getContext(), MainActivity.class));
//                    break;
//                case R.id.view12://图库
//                    GetBean.modole="images";
//                    GetBean.tag = "http://kphz.kpsns.cn/index.php?c=api&m=data2&auth=e16ecea319d246ca3335cac2a0188d6a&param=function&name=dr_kphz_photo_list&p1=photo&p2=20";
//
//                    getContext().startActivity(new Intent(getContext(), MainActivity.class));
//                    break;
//                case R.id.view13://校园e站
//                    GetBean.modole="hunhe";
//                    GetBean.tag = "http://kphz.kpsns.cn/index.php?c=api&m=data2&auth=7011a87ed2154b8e6b21584aa02583a1&function=dr_function_ezhan&param=list action=content id=3 module=special";
//
//                    getContext().startActivity(new Intent(getContext(), MainActivity.class));
//                    break;
//                case R.id.view7://通知
//                    GetBean.modole="news";
//                    GetBean.tag = "http://kphz.kpsns.cn//index.php?c=api&m=data2&auth=e16ecea319d246ca3335cac2a0188d6a&param=function&name=dr_api_note&p1=1";
//                    Toast.makeText(getContext(),"该功能因为返回数据 list 为null 无法预览",Toast.LENGTH_SHORT).show();
//
////                    getContext().startActivity(new Intent(getContext(), MainActivity.class));
//                    break;
//                case R.id.view8://技术支持
//                    GetBean.modole="video";
////                    getContext().startActivity(new Intent(getContext(), MainActivity.class));
//                    Toast.makeText(getContext(),"功能暂未开放",Toast.LENGTH_SHORT).show();
//
//                    break;
//
//
//
//            }
//        }
//        return super.onKeyUp(keyCode, event);
//    }



    @SuppressLint("MissingSuperCall")
    @Override
    public void draw(Canvas canvas) {
        mMetroItemRound.draw(canvas);
    }

    @Override
    public MetroItemRound getRoundImpl() {
        return mMetroItemRound;
    }

    @Override
    public void drawRadious(Canvas canvas) {
        super.draw(canvas);
    }
}

