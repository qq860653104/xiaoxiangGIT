package com.chunleikeji.bean;

/**
 * Created by wh on 2018/3/15.
 */

public class JujiBean {

    public JujiBean(String name , String url){
        this.name= name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String name;
    private String url;
}
