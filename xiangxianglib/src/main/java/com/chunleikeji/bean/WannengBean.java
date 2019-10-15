package com.chunleikeji.bean;

import java.util.List;

public class WannengBean {


    /**
     * msg : 获取成功
     * data : ["http://jx.drgxj.com/?url=","https://jx.lache.me/cc/?url=","https://cdn.yangju.vip/k/?url=","https://jx.000180.top/jx/?url="]
     */

    private String msg;
    private List<String> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
