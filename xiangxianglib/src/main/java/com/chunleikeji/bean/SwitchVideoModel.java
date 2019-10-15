package com.chunleikeji.bean;

import java.util.List;

/**
 * Created by wh on 2018/3/15.
 */

public class SwitchVideoModel {
    public SwitchVideoModel(String title, String url, List<PlayBean.DataBean.StreamsBean.SegsBean> segs) {
        this.segs = segs;
        this.title = title;
        this.url = url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    private String tag;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String img) {
        this.url = img;
    }

    private String url;

    public List<PlayBean.DataBean.StreamsBean.SegsBean> getSegs() {
        return segs;
    }

    public void setSegs(List<PlayBean.DataBean.StreamsBean.SegsBean> segs) {
        this.segs = segs;
    }

    private List<PlayBean.DataBean.StreamsBean.SegsBean> segs;

}
