package com.chunleikeji.bean;

import java.util.List;

/**
 * Created by wh on 2018/6/4.
 */

public class QuanBuBean {

    /**
     * msg : 200
     * data : [{"name":"坑位1-分类1","data":[{"id":4,"name":"坑位1测试视频","type":"坑位1-分类1","video_adr":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/872c90a07a42d7ba/d98974ee9529e9d2.mp4","is_deleted":"0","sort":"2","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png","create_at":"2019-01-20 19:42:53","pid":"0","duoji":"","pinyin":"ylssggjy","info":"这是坑位1的 测试视频","sx1":"小剧场","sx2":"小剧场","iszb":"0","zipres":null,"is_video":null,"sudu":"0"},{"id":19,"name":"分类1图组测试","type":"坑位1-分类1","video_adr":null,"is_deleted":"1","sort":"0","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png","create_at":"2019-07-07 22:53:28","pid":"0","duoji":null,"pinyin":null,"info":null,"sx1":null,"sx2":null,"iszb":null,"zipres":"http://39.105.70.121/test3/MeiJiaDian/static/upload/af3ba98233bc8c0b/4bc700f1db5b674c.zip","is_video":null,"sudu":"10"},{"id":20,"name":"坑位1分类1测试图组","type":"坑位1-分类1","video_adr":null,"is_deleted":"0","sort":"0","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png","create_at":"2019-07-07 22:57:05","pid":"0","duoji":null,"pinyin":null,"info":null,"sx1":null,"sx2":null,"iszb":null,"zipres":"http://39.105.70.121/test3/MeiJiaDian/static/upload/af3ba98233bc8c0b/4bc700f1db5b674c.zip","is_video":"0","sudu":"10"}]},{"name":"坑位1-分类2","data":[{"id":2,"name":"这是坑位1的 测试视频","type":"坑位1-分类2","video_adr":"http://v.a-hh.cn/1e9d0b974f4143feb8746c49c49fb5a6/836185349eb34bc7a132b4133fb8854c-8f65e20c2fec9cb23beb36b64916a4c9-ld.m3u8","is_deleted":"0","sort":"1","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png","create_at":"2018-10-12 22:56:22","pid":"0","duoji":"","pinyin":"ylsjxsggjy","info":"这是坑位1 分类2的 测试视频 ","sx1":"坑位2","sx2":"主讲人：于老师","iszb":"0","zipres":null,"is_video":null,"sudu":"0"}]}]
     */

    private String msg;
    private List<DataBeanX> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * name : 坑位1-分类1
         * data : [{"id":4,"name":"坑位1测试视频","type":"坑位1-分类1","video_adr":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/872c90a07a42d7ba/d98974ee9529e9d2.mp4","is_deleted":"0","sort":"2","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png","create_at":"2019-01-20 19:42:53","pid":"0","duoji":"","pinyin":"ylssggjy","info":"这是坑位1的 测试视频","sx1":"小剧场","sx2":"小剧场","iszb":"0","zipres":null,"is_video":null,"sudu":"0"},{"id":19,"name":"分类1图组测试","type":"坑位1-分类1","video_adr":null,"is_deleted":"1","sort":"0","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png","create_at":"2019-07-07 22:53:28","pid":"0","duoji":null,"pinyin":null,"info":null,"sx1":null,"sx2":null,"iszb":null,"zipres":"http://39.105.70.121/test3/MeiJiaDian/static/upload/af3ba98233bc8c0b/4bc700f1db5b674c.zip","is_video":null,"sudu":"10"},{"id":20,"name":"坑位1分类1测试图组","type":"坑位1-分类1","video_adr":null,"is_deleted":"0","sort":"0","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png","create_at":"2019-07-07 22:57:05","pid":"0","duoji":null,"pinyin":null,"info":null,"sx1":null,"sx2":null,"iszb":null,"zipres":"http://39.105.70.121/test3/MeiJiaDian/static/upload/af3ba98233bc8c0b/4bc700f1db5b674c.zip","is_video":"0","sudu":"10"}]
         */

        private String name;
        private List<DataBean> data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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
             * name : 坑位1测试视频
             * type : 坑位1-分类1
             * video_adr : http://39.105.70.121/test3/ZhihuAdmin/static/upload/872c90a07a42d7ba/d98974ee9529e9d2.mp4
             * is_deleted : 0
             * sort : 2
             * status : 1
             * fm_img : http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png
             * create_at : 2019-01-20 19:42:53
             * pid : 0
             * duoji :
             * pinyin : ylssggjy
             * info : 这是坑位1的 测试视频
             * sx1 : 小剧场
             * sx2 : 小剧场
             * iszb : 0
             * zipres : null
             * is_video : null
             * sudu : 0
             */

            private int id;
            private String name;
            private String type;
            private String video_adr;
            private String is_deleted;
            private String sort;
            private String status;
            private String fm_img;
            private String create_at;
            private String pid;
            private String duoji;
            private String pinyin;
            private String info;
            private String sx1;
            private String sx2;
            private String iszb;
            private Object zipres;
            private Object is_video;
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

            public String getVideo_adr() {
                return video_adr;
            }

            public void setVideo_adr(String video_adr) {
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

            public String getDuoji() {
                return duoji;
            }

            public void setDuoji(String duoji) {
                this.duoji = duoji;
            }

            public String getPinyin() {
                return pinyin;
            }

            public void setPinyin(String pinyin) {
                this.pinyin = pinyin;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getSx1() {
                return sx1;
            }

            public void setSx1(String sx1) {
                this.sx1 = sx1;
            }

            public String getSx2() {
                return sx2;
            }

            public void setSx2(String sx2) {
                this.sx2 = sx2;
            }

            public String getIszb() {
                return iszb;
            }

            public void setIszb(String iszb) {
                this.iszb = iszb;
            }

            public Object getZipres() {
                return zipres;
            }

            public void setZipres(Object zipres) {
                this.zipres = zipres;
            }

            public Object getIs_video() {
                return is_video;
            }

            public void setIs_video(Object is_video) {
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
}
