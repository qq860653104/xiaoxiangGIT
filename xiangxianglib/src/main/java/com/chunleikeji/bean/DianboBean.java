package com.chunleikeji.bean;

import java.util.List;

public class DianboBean {

    public ImgBean getAd() {
        return ad;
    }

    public void setAd(ImgBean ad) {
        this.ad = ad;
    }

    private ImgBean ad;
    private String msg;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 片分类1
         * list : [{"name":"测试视频","type":"片分类1","video_adr":"http://39.106.60.208/test/ThinkAdmin-master/static/upload/783c9e3e0814a6de/55967fd33acc59d3.mp4","fm_img":"http://39.106.60.208/test/ThinkAdmin-master/static/upload/f25c2bfb4b572b45/4acd62548d853b9c.jpg"},{"name":"测试分类","type":"片分类1","video_adr":"http://39.106.60.208/test/ThinkAdmin-master/static/upload/783c9e3e0814a6de/55967fd33acc59d3.mp4","fm_img":"http://39.106.60.208/test/ThinkAdmin-master/static/upload/5457a89ac60f7782/6f19382f9f7b1712.png"}]
         */

        private String name;
        private List<ListBean> list;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            /**
             * name : 测试视频
             * type : 片分类1
             * video_adr : http://39.106.60.208/test/ThinkAdmin-master/static/upload/783c9e3e0814a6de/55967fd33acc59d3.mp4
             * fm_img : http://39.106.60.208/test/ThinkAdmin-master/static/upload/f25c2bfb4b572b45/4acd62548d853b9c.jpg
             */
            private String id;

            public String getIszb() {
                return iszb;
            }

            public void setIszb(String iszb) {
                this.iszb = iszb;
            }

            private String iszb;

            private String name;
            private String type;
            private String video_adr;
            private String fm_img;

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

            public String getFm_img() {
                return fm_img;
            }

            public void setFm_img(String fm_img) {
                this.fm_img = fm_img;
            }
        }
    }
}
