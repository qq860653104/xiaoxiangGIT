package com.chunleikeji.bean;

import java.util.List;

public class CarouselBean {

    /**
     * time :
     * data : [{"fm_img":"http://39.105.70.121/test3/MeiJiaDian/file/552e879808487954/6ec5206c96cf69ba16b9a02122ed2775.jpg"},{"fm_img":"http://39.105.70.121/test3/MeiJiaDian/file/552e879808487954/96553379a674ee7e71037090a9992251.jpeg"},{"fm_img":"http://39.105.70.121/test3/MeiJiaDian/file/552e879808487954/b0cffd6c3bbc902bfdbbfa0a20972546.jpeg"},{"fm_img":"http://39.105.70.121/test3/MeiJiaDian/file/552e879808487954/b690b89fa8120eda37ed9c43ee9a080a.jpeg"},{"fm_img":"http://39.105.70.121/test3/MeiJiaDian/file/552e879808487954/e8d388a225b910d27c1fcd994bbb8375.jpeg"}]
     * parent : [{"id":20,"name":"坑位1分类1测试图组","type":"坑位1-分类1","video_adr":null,"is_deleted":"0","sort":"0","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png","create_at":"2019-07-07 22:57:05","pid":"0","duoji":null,"pinyin":null,"info":null,"sx1":null,"sx2":null,"iszb":null,"zipres":"/var/www/html/test3/MeiJiaDian/file/552e879808487954","is_video":"0","sudu":"10"}]
     */

    private String time;
    private List<DataBean> data;
    private List<ParentBean> parent;

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

    public List<ParentBean> getParent() {
        return parent;
    }

    public void setParent(List<ParentBean> parent) {
        this.parent = parent;
    }

    public static class DataBean {
        /**
         * fm_img : http://39.105.70.121/test3/MeiJiaDian/file/552e879808487954/6ec5206c96cf69ba16b9a02122ed2775.jpg
         */

        private String fm_img;

        public String getFm_img() {
            return fm_img;
        }

        public void setFm_img(String fm_img) {
            this.fm_img = fm_img;
        }
    }

    public static class ParentBean {
        /**
         * id : 20
         * name : 坑位1分类1测试图组
         * type : 坑位1-分类1
         * video_adr : null
         * is_deleted : 0
         * sort : 0
         * status : 1
         * fm_img : http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png
         * create_at : 2019-07-07 22:57:05
         * pid : 0
         * duoji : null
         * pinyin : null
         * info : null
         * sx1 : null
         * sx2 : null
         * iszb : null
         * zipres : /var/www/html/test3/MeiJiaDian/file/552e879808487954
         * is_video : 0
         * sudu : 10
         */

        private int id;
        private String name;
        private String type;
        private Object video_adr;
        private String is_deleted;
        private String sort;
        private String status;
        private String fm_img;
        private String create_at;
        private String pid;
        private Object duoji;
        private Object pinyin;
        private Object info;
        private Object sx1;
        private Object sx2;
        private Object iszb;
        private String zipres;
        private String is_video;
        private String sudu;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getVideo_adr() {
            return video_adr;
        }

        public void setVideo_adr(Object video_adr) {
            this.video_adr = video_adr;
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

        public Object getDuoji() {
            return duoji;
        }

        public void setDuoji(Object duoji) {
            this.duoji = duoji;
        }

        public Object getPinyin() {
            return pinyin;
        }

        public void setPinyin(Object pinyin) {
            this.pinyin = pinyin;
        }

        public Object getInfo() {
            return info;
        }

        public void setInfo(Object info) {
            this.info = info;
        }

        public Object getSx1() {
            return sx1;
        }

        public void setSx1(Object sx1) {
            this.sx1 = sx1;
        }

        public Object getSx2() {
            return sx2;
        }

        public void setSx2(Object sx2) {
            this.sx2 = sx2;
        }

        public Object getIszb() {
            return iszb;
        }

        public void setIszb(Object iszb) {
            this.iszb = iszb;
        }

        public String getZipres() {
            return zipres;
        }

        public void setZipres(String zipres) {
            this.zipres = zipres;
        }

        public String getIs_video() {
            return is_video;
        }

        public void setIs_video(String is_video) {
            this.is_video = is_video;
        }

        public String getSudu() {
            return sudu;
        }

        public void setSudu(String sudu) {
            this.sudu = sudu;
        }
    }
}
