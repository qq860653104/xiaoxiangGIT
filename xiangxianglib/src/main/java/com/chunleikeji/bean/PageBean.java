package com.chunleikeji.bean;

import java.util.List;

public class PageBean {

    /**
     * page : 1-10
     * number : [1,2,3,4,5,6,7,8,9,10]
     */

    private String page;
    private List<Integer> number;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setNumber(List<Integer> number) {
        this.number = number;
    }

}
