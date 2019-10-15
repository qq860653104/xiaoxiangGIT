package com.chunleikeji.mode;

/**
 * 用于Leanback 的数据测试.
 * Created by hailongqiu on 2016/8/25.
 */
public class Movie {
    private int mRes;
    private String mTitle;

    public static  final String ZT_MOVIE = "4";
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type ;
    public Movie(int res, String title) {
        this.mRes = res;
        this.mTitle = title;
    }

    public int getRes() {
        return this.mRes;
    }

    public String getTitle() {
        return this.mTitle;
    }

}
