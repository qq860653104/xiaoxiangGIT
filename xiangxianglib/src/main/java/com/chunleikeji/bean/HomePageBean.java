package com.chunleikeji.bean;

import java.util.List;

public class HomePageBean {


    /**
     * homebg : http://39.105.70.121/test3/ZhihuAdmin/static/upload/3fc0cc02691f0a4d/f87bc9cce2d66a67.png
     * data : [{"id":1,"name":"健康直通车","fm_img":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/261e09a8798e1e55/64d85632ec55256b.png"},{"id":2,"name":"每天五分钟","fm_img":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/d22d6fbdcfa8fc38/f7f71ccab5293ac2.png"},{"id":3,"name":"名医堂","fm_img":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/e434312632860d21/674c233d3c2d27dc.png"},{"id":4,"name":"执壶小剧场","fm_img":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/70194651bbfbdc8d/6d26b76a136fa3ab.png"},{"id":5,"name":"多彩生活","fm_img":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/38fdd9ee1b95b20d/b993fc8f98519fcd.png"},{"id":6,"name":"文娱经典","fm_img":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/ffb2d514c4ca4c7c/0570d7d03ff76849.png"},{"id":7,"name":"养老资讯","fm_img":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/0de93c04c667676e/c8daec9da54eacdf.png"},{"id":8,"name":"金牌护理员","fm_img":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/5029a56f7e82d573/20b9b4dcf143f5d9.png"}]
     * title : 默认滚动字幕
     * guanggao : [{"id":5,"status":"1","is_deleted":"0","sort":"0","pid":"0","kaiji_gg":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/6605b4b8e43e81f4/b9cf921d57c5eb6e.png","crd_time":"2019-03-12 01:56:22am","type":"1","end_gg":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/6605b4b8e43e81f4/b9cf921d57c5eb6e.png"}]
     */

    private String homebg;
    private String title;
    private List<DataBean> data;
    private List<GuanggaoBean> guanggao;

    public String getHomebg() {
        return homebg;
    }

    public void setHomebg(String homebg) {
        this.homebg = homebg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<GuanggaoBean> getGuanggao() {
        return guanggao;
    }

    public void setGuanggao(List<GuanggaoBean> guanggao) {
        this.guanggao = guanggao;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 健康直通车
         * fm_img : http://39.105.70.121/test3/ZhihuAdmin/static/upload/261e09a8798e1e55/64d85632ec55256b.png
         */

        private int id;
        private String name;
        private String fm_img;
        private String video_type;
        private String apk_type;
        private int res_type;
        private int vip;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFm_img() {
            return fm_img;
        }

        public void setFm_img(String fm_img) {
            this.fm_img = fm_img;
        }

        public String getVideo_type() {
            return video_type;
        }

        public void setVideo_type(String video_type) {
            this.video_type = video_type;
        }

        public String getApk_type() {
            return apk_type;
        }

        public void setApk_type(String apk_type) {
            this.apk_type = apk_type;
        }

        public int getRes_type() {
            return res_type;
        }

        public void setRes_type(int res_type) {
            this.res_type = res_type;
        }

        public int getVip() {
            return vip;
        }

        public void setVip(int vip) {
            this.vip = vip;
        }
    }

    public static class GuanggaoBean {
        /**
         * id : 5
         * status : 1
         * is_deleted : 0
         * sort : 0
         * pid : 0
         * kaiji_gg : http://39.105.70.121/test3/ZhihuAdmin/static/upload/6605b4b8e43e81f4/b9cf921d57c5eb6e.png
         * crd_time : 2019-03-12 01:56:22am
         * type : 1
         * end_gg : http://39.105.70.121/test3/ZhihuAdmin/static/upload/6605b4b8e43e81f4/b9cf921d57c5eb6e.png
         */

        private int id;
        private String status;
        private String is_deleted;
        private String sort;
        private String pid;
        private String kaiji_gg;
        private String crd_time;
        private String type;
        private String end_gg;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIs_deleted() {
            return is_deleted;
        }

        public void setIs_deleted(String is_deleted) {
            this.is_deleted = is_deleted;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getKaiji_gg() {
            return kaiji_gg;
        }

        public void setKaiji_gg(String kaiji_gg) {
            this.kaiji_gg = kaiji_gg;
        }

        public String getCrd_time() {
            return crd_time;
        }

        public void setCrd_time(String crd_time) {
            this.crd_time = crd_time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getEnd_gg() {
            return end_gg;
        }

        public void setEnd_gg(String end_gg) {
            this.end_gg = end_gg;
        }


    }
}
