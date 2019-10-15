package com.chunleikeji.bean;

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

public class SearchBean {


    /**
     * msg :
     * code :
     * data : [{"pic":"/attachment/vod/201803/14/2018031414302083247.jpg","title":"健康新7点 2018","id":"463"},{"pic":"/attachment/vod/201803/14/2018031414304595218.jpg","title":"非凡任务","id":"335"},{"pic":"/attachment/vod/201803/14/2018031414305197080.jpg","title":"咱们分手吧","id":"316"},{"pic":"/attachment/vod/201803/14/2018031414305032120.jpg","title":"唐人街探案","id":"342"},{"pic":"/attachment/vod/201803/14/2018031414303666882.jpg","title":"门当户对","id":"373"},{"pic":"/attachment/vod/201803/14/2018031414301642466.jpg","title":"爱的时差 第一季","id":"483"},{"pic":"/attachment/vod/201803/14/2018031414302058208.jpg","title":"门当户对 2018","id":"462"},{"pic":"/attachment/vod/201803/14/2018031414305610769.jpg","title":"健忘村","id":"334"},{"pic":"/attachment/vod/201803/14/2018031414302022618.jpg","title":"家庭幽默录像 2018","id":"471"},{"pic":"/attachment/vod/201803/14/2018031414303381735.jpg","title":"我的青春遇见你 DVD版","id":"418"},{"pic":"/attachment/vod/201803/14/2018031414302885974.jpg","title":"新笑傲江湖","id":"400"},{"pic":"/attachment/vod/201803/14/2018031414304017477.jpg","title":"暴走恐怖故事之惊门诡事","id":"390"},{"pic":"/attachment/vod/201803/14/2018031414301683330.jpg","title":"内地票房报告 2018","id":"486"},{"pic":"/attachment/vod/201803/14/2018031414302881222.jpg","title":"急诊科医生","id":"398"},{"pic":"/attachment/vod/201803/14/2018031414305619892.jpg","title":"樱桃小丸子 第2季","id":"327"},{"pic":"/attachment/vod/201803/14/2018031414304182222.jpg","title":"突击再突击","id":"348"},{"pic":"/attachment/vod/201803/14/2018031414304079181.jpg","title":"小猪班纳 第三季","id":"388"},{"pic":"/attachment/vod/201803/14/2018031414305129200.jpg","title":"诡眼","id":"318"},{"pic":"/attachment/vod/201803/14/2018031414302385114.jpg","title":"我看行 2018","id":"447"},{"pic":"/attachment/vod/201803/14/2018031414302042004.jpg","title":"明星10s时装周","id":"455"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public static SearchBean objectFromData(String str) {

        return new Gson().fromJson(str, SearchBean.class);
    }

    public static SearchBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), SearchBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<SearchBean> arraySearchBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<SearchBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<SearchBean> arraySearchBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<SearchBean>>() {
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
         * pic : /attachment/vod/201803/14/2018031414302083247.jpg
         * title : 健康新7点 2018
         * id : 463
         */

        private String pic;
        private String title;
        private int id;
        private String is_video;

        public String getIs_video() {
            return is_video;
        }

        public void setIs_video(String is_video) {
            this.is_video = is_video;
        }

        public String getPicfolder() {
            return picfolder;
        }

        public void setPicfolder(String picfolder) {
            this.picfolder = picfolder;
        }

        private String picfolder;
        public String getPf() {
            return pf;
        }

        public void setPf(String pf) {
            this.pf = pf;
        }

        private String pf;

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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
