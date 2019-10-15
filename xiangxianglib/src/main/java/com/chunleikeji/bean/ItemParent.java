package com.chunleikeji.bean;



import java.util.List;

public class ItemParent {


    /**
     * detail : [{"id":4,"name":"坑位1测试视频","type":"坑位1-分类1","video_adr":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/872c90a07a42d7ba/d98974ee9529e9d2.mp4","is_deleted":"0","sort":"2","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png","create_at":"2019-01-20 19:42:53","pid":"0","duoji":"","pinyin":"ylssggjy","info":"这是坑位1的 测试视频","sx1":"小剧场","sx2":"小剧场","iszb":"0","zipres":null,"is_video":null,"sudu":"0"}]
     * page : {"mu":{"tag":["测试"],"info":[{"0":{"btn":{"name":"测试"}},"zi":[{"btn":{"video":"测试"}}]}]}}
     * list : [{"title":"直播测试","biaoqian":"健康直通车","pic":"http://39.106.60.208/test/ThinkAdmin-master/static/upload/f25c2bfb4b572b45/4acd62548d853b9c.jpg","id":1},{"title":"这是坑位1的 测试视频","biaoqian":"坑位1-分类2","pic":"http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png","id":2},{"title":"测试分类","biaoqian":"每天五分钟","pic":"http://39.106.60.208/test/ThinkAdmin-master/static/upload/5457a89ac60f7782/6f19382f9f7b1712.png","id":3},{"title":"坑位1测试视频","biaoqian":"坑位1-分类1","pic":"http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png","id":4},{"title":"坑位2分类1测试视频","biaoqian":"坑位2-分类1","pic":"http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png","id":5},{"title":"测试","biaoqian":"健康直通车","pic":"http://39.105.70.121/test3/ZhihuAdmin/static/upload/2f5b449e0cf8e95f/980b9d8096e6f7b1.jpg","id":6}]
     */

    private PageBean page;
    private List<DetailBean> detail;
    private List<ListBean> list;

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public List<DetailBean> getDetail() {
        return detail;
    }

    public void setDetail(List<DetailBean> detail) {
        this.detail = detail;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class PageBean {
        /**
         * mu : {"tag":["测试"],"info":[{"0":{"btn":{"name":"测试"}},"zi":[{"btn":{"video":"测试"}}]}]}
         */

        private MuBean mu;

        public MuBean getMu() {
            return mu;
        }

        public void setMu(MuBean mu) {
            this.mu = mu;
        }

        public static class MuBean {
            private List<String> tag;
            private List<InfoBean> info;

            public List<String> getTag() {
                return tag;
            }

            public void setTag(List<String> tag) {
                this.tag = tag;
            }

            public List<InfoBean> getInfo() {
                return info;
            }

            public void setInfo(List<InfoBean> info) {
                this.info = info;
            }

            public static class InfoBean {
                /**
                 * 0 : {"btn":{"name":"测试"}}
                 * zi : [{"btn":{"video":"测试"}}]
                 */


                private _$0Bean _$0;
                private List<ZiBean> zi;

                public _$0Bean get_$0() {
                    return _$0;
                }

                public void set_$0(_$0Bean _$0) {
                    this._$0 = _$0;
                }

                public List<ZiBean> getZi() {
                    return zi;
                }

                public void setZi(List<ZiBean> zi) {
                    this.zi = zi;
                }

                public static class _$0Bean {
                    /**
                     * btn : {"name":"测试"}
                     */

                    private BtnBean btn;

                    public BtnBean getBtn() {
                        return btn;
                    }

                    public void setBtn(BtnBean btn) {
                        this.btn = btn;
                    }

                    public static class BtnBean {
                        /**
                         * name : 测试
                         */

                        private String name;

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }
                    }
                }

                public static class ZiBean {
                    /**
                     * btn : {"video":"测试"}
                     */

                    private BtnBeanX btn;

                    public BtnBeanX getBtn() {
                        return btn;
                    }

                    public void setBtn(BtnBeanX btn) {
                        this.btn = btn;
                    }

                    public static class BtnBeanX {
                        /**
                         * video : 测试
                         */

                        private String video;

                        public String getVideo() {
                            return video;
                        }

                        public void setVideo(String video) {
                            this.video = video;
                        }
                    }
                }
            }
        }
    }

    public static class DetailBean {
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

    public static class ListBean {
        /**
         * title : 直播测试
         * biaoqian : 健康直通车
         * pic : http://39.106.60.208/test/ThinkAdmin-master/static/upload/f25c2bfb4b572b45/4acd62548d853b9c.jpg
         * id : 1
         */

        private String title;
        private String biaoqian;
        private String pic;
        private int id;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBiaoqian() {
            return biaoqian;
        }

        public void setBiaoqian(String biaoqian) {
            this.biaoqian = biaoqian;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
