package com.chunleikeji.bean;

import java.util.List;

public class    ImgBean {


    /**
     * time : 10
     * data : [{"id":"4","name":"图片1","is_deleted":"0","sort":"0","status":"1","fm_img":"http://39.106.60.208/test/YuncaiZixun/static/upload/8c64b7144c4da412/895b1e00a2b85993.png","create_at":"2018-12-17 00:52:00","pid":"0"},{"id":"5","name":"图片2","is_deleted":"0","sort":"0","status":"1","fm_img":"http://39.106.60.208/test/YuncaiZixun/static/upload/c1ae99b2dd720e56/6fb645a3f218a5bf.png","create_at":"2018-12-17 00:52:59","pid":"0"},{"id":"6","name":"图片3","is_deleted":"0","sort":"0","status":"1","fm_img":"http://39.106.60.208/test/YuncaiZixun/static/upload/2306ed63b8495d39/f250fb82b65b12be.png","create_at":"2018-12-17 00:53:14","pid":"0"},{"id":"7","name":"图片4","is_deleted":"0","sort":"0","status":"1","fm_img":"http://39.106.60.208/test/YuncaiZixun/static/upload/b0f689b9b132b436/d0b607c6ad1afaef.jpg","create_at":"2018-12-17 00:53:27","pid":"0"}]
     */

    private String time;
    private List<DataBean> data;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 4
         * name : 图片1
         * is_deleted : 0
         * sort : 0
         * status : 1
         * fm_img : http://39.106.60.208/test/YuncaiZixun/static/upload/8c64b7144c4da412/895b1e00a2b85993.png
         * create_at : 2018-12-17 00:52:00
         * pid : 0
         */

        private String id;
        private String name;
        private String is_deleted;
        private String sort;
        private String status;
        private String fm_img;
        private String create_at;
        private String pid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFm_img() {
            return fm_img;
        }

        public void setFm_img(String fm_img) {
            this.fm_img = fm_img;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }
    }
}
