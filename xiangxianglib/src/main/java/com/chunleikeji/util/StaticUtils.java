package com.chunleikeji.util;

import android.app.Activity;

import com.chunleikeji.bean.DianboBean;
import com.chunleikeji.bean.HomePageBean;
import com.chunleikeji.bean.KaiJIBean;
import com.chunleikeji.bean.QuanBuBean;



public class StaticUtils {




    public static Activity getActivity() {
        return activity;
    }

    public static void setActivity(Activity activity2) {
        activity = activity2;
    }

    public static Activity activity;

    public static DianboBean.DataBean.ListBean  getInfobean() {
        return infobean;
    }

    public static void setInfobean(DianboBean.DataBean.ListBean infobean) {
        StaticUtils.infobean = infobean;
    }
    //    public static String baseUrl = "http://192.168.99.163/";
    public static String baseUrl = "http://39.96.198.153/";

    public static DianboBean.DataBean.ListBean  infobean;

    public static  Class CarouselImgActivity;

    public static int isStartVideoAd  ;
    public static String startAd  ;
    public static String endAd  ;

    public static String movie_id  ;
    public static String user  ;
    public static String time  ;


    public static int imgId  ;
    public static int imgIndex ;

    public static TimelyBean jishiBean;

    public static int getIsFirst() {
        return isFirst;
    }

    public static void setIsFirst(int isFirst) {
        StaticUtils.isFirst = isFirst;
    }

    public static int isFirst  ;
    public static boolean isHome  ;
    /**
     * true  搜索
     *
     * false  全部页
     * */
    public static boolean sphttp;
    /**
     * true  收藏
     * */
    public static boolean shoucang;

    /**
     * true 历史
     * */
    public static boolean lishi;


    public static QuanBuBean dataBase;
    public static  int  nextIndex;
    public static  int  showBarIndex;
    /**
     * true 播放页去了图片页
     * */
    public static boolean VideoSkip ;

    /**
     * true 及时转换
     * */
    public static boolean TimelyNews  ;
    public static  int TimelyOne;
    public static  int TimelyTwo;
    public static  int TimelyThree;

    public static  String Timelyurl  ;

    /**
     * true 循环
     *
     * false 不循环
     * */
    public static boolean Timelyisxh;


    public static HomePageBean listName;
    /**
     * true 搜索来的
     *
     *
     * */
    public static boolean isSear;
    /**
     * true 开机时判断是否更替首页皮肤
     *
     *
     * */
    public static boolean isReplace;
    public static KaiJIBean ReplaceJson ;
}
