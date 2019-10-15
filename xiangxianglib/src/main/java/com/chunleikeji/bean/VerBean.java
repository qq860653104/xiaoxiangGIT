package com.chunleikeji.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wh on 2018/3/26.
 */

public class VerBean {

    /**
     * verid : 测试id
     * vercontent : 测试内容
     * vertime : 测试时间
     * address : 测试地址
     * id : 1
     */

    private String verid;
    private String vercontent;
    private String vertime;
    private String address;
    private String id;

    public static VerBean objectFromData(String str) {

        return new Gson().fromJson(str, VerBean.class);
    }

    public static VerBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), VerBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<VerBean> arrayVerBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<VerBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<VerBean> arrayVerBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<VerBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getVerid() {
        return verid;
    }

    public void setVerid(String verid) {
        this.verid = verid;
    }

    public String getVercontent() {
        return vercontent;
    }

    public void setVercontent(String vercontent) {
        this.vercontent = vercontent;
    }

    public String getVertime() {
        return vertime;
    }

    public void setVertime(String vertime) {
        this.vertime = vertime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
