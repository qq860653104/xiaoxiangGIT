package com.open.androidtvwidget.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wh on 2018/3/17.
 */

public class ZhuanTiBean {


    /**
     * msg :
     * code :
     * data : [{"pic":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2455050536.jpg","title":"上传电影测试","id":"495"},{"pic":"/attachment/vod/201803/14/2018031414304595218.jpg","title":"非凡任务","id":"335"},{"pic":"/attachment/vod/201803/14/2018031414305129455.jpg","title":"追击","id":"343"},{"pic":"/attachment/vod/201803/14/2018031414304511734.jpg","title":"赏金猎人","id":"365"},{"pic":"/attachment/vod/201803/14/2018031414302887558.jpg","title":"宝贝特攻","id":"395"},{"pic":"/attachment/vod/201803/14/2018031414304151163.jpg","title":"唐人街探案","id":"392"}]
     */

    private String msg;
    private String code;

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    private String bg;
    private List<DataBean> data;

    public static ZhuanTiBean objectFromData(String str) {

        return new Gson().fromJson(str, ZhuanTiBean.class);
    }

    public static ZhuanTiBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), ZhuanTiBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<ZhuanTiBean> arrayZhuanTiBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ZhuanTiBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<ZhuanTiBean> arrayZhuanTiBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ZhuanTiBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * pic : http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2455050536.jpg
         * title : 上传电影测试
         * id : 495
         */

        private String pic;
        private String title;
        private String id;

        public String getPf() {
            return pf;
        }

        public void setPf(String pf) {
            this.pf = pf;
        }

        private String pf;

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        private String tag;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public static DataBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DataBean> arrayDataBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DataBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
