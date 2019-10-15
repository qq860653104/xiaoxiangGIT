package com.chunleikeji.bean;

import java.util.List;

public class BzBean {


    /**
     * msg : 正常
     * data : [{"id":1,"title":"热门问题","local_url":"/test3/ZhihuAdmin/static/plugs/uploader/theme/image.png","show_cover_pic":0,"author":"石头","digest":"\n这是标题\n\n \n\n这是内容ABC\n","content":"<p><br />\n<span style=\"font-size:24px;\"><strong>这是标题<\/strong><\/span><\/p>\n\n<p> <\/p>\n\n<p>这是内容ABC<\/p>\n","content_source_url":"","create_at":"2019-02-19 21:58:57","create_by":10000},{"id":2,"title":"会员相关","local_url":"/test3/ZhihuAdmin/static/plugs/uploader/theme/image.png","show_cover_pic":0,"author":"ASDA","digest":"会员相关问题\n\n \n\n问题ABCD\n","content":"<p>会员相关问题<\/p>\n\n<p> <\/p>\n\n<p>问题ABCD<\/p>\n","content_source_url":"","create_at":"2019-02-19 21:59:50","create_by":10000},{"id":3,"title":"使用帮助","local_url":"/test3/ZhihuAdmin/static/plugs/uploader/theme/image.png","show_cover_pic":0,"author":"sss","digest":"使用帮助使用帮助使用帮助使用帮助使用帮助使用帮助使用帮助\n\n使用帮助使用帮助使用帮助使用帮助使用帮助使用帮助\n\n\n\t\n\t\t\n\t\t\t \n\t\t\t \n\t\t\n\t\t\n\t\t\t \n\t\t\t \n\t\t\n\t\t\n\t\t\t&nb","content":"<p>使用帮助使用帮助使用帮助使用帮助使用帮助使用帮助使用帮助<\/p>\n\n<p>使用帮助使用帮助使用帮助使用帮助使用帮助使用帮助<\/p>\n\n<table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" style=\"width:500px;\">\n\t<tbody>\n\t\t<tr>\n\t\t\t<td> <\/td>\n\t\t\t<td> <\/td>\n\t\t<\/tr>\n\t\t<tr>\n\t\t\t<td> <\/td>\n\t\t\t<td> <\/td>\n\t\t<\/tr>\n\t\t<tr>\n\t\t\t<td> <\/td>\n\t\t\t<td> <\/td>\n\t\t<\/tr>\n\t<\/tbody>\n<\/table>\n\n<p> <\/p>\n","content_source_url":"","create_at":"2019-02-19 22:01:21","create_by":10000}]
     */

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
         * id : 1
         * title : 热门问题
         * local_url : /test3/ZhihuAdmin/static/plugs/uploader/theme/image.png
         * show_cover_pic : 0
         * author : 石头
         * digest :
         这是标题



         这是内容ABC

         * content : <p><br />
         <span style="font-size:24px;"><strong>这是标题</strong></span></p>

         <p> </p>

         <p>这是内容ABC</p>

         * content_source_url :
         * create_at : 2019-02-19 21:58:57
         * create_by : 10000
         */

        private int id;
        private String title;
        private String local_url;
        private int show_cover_pic;
        private String author;
        private String digest;
        private String content;
        private String content_source_url;
        private String create_at;
        private int create_by;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLocal_url() {
            return local_url;
        }

        public void setLocal_url(String local_url) {
            this.local_url = local_url;
        }

        public int getShow_cover_pic() {
            return show_cover_pic;
        }

        public void setShow_cover_pic(int show_cover_pic) {
            this.show_cover_pic = show_cover_pic;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent_source_url() {
            return content_source_url;
        }

        public void setContent_source_url(String content_source_url) {
            this.content_source_url = content_source_url;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public int getCreate_by() {
            return create_by;
        }

        public void setCreate_by(int create_by) {
            this.create_by = create_by;
        }
    }
}
