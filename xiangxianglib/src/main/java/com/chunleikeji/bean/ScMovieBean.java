package com.chunleikeji.bean;

/**
 * Created by wh on 2018/3/17.
 */

public class ScMovieBean {

    public ScMovieBean(){

    }

    public int getPostion() {
        return Postion;
    }

    public void setPostion(int postion) {
        Postion = postion;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String pic;
    private String id;
    private String url ;
    private int Postion;
}