package com.chunleikeji.util;

import java.util.List;

public class TimelyBean {


    /**
     * tag : 1
     * time : 16:12
     * group : [[{"name":"周二大讲堂","data":[{"id":2,"name":"周二大讲堂","type":"周二大讲堂","video_adr":"http://39.105.70.121/test3/MeiJiaDian/static/upload/1b4b92902e3e4c23/49706634bdc9bd71.mp4","is_deleted":"0","sort":"1","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/33880aadbfd7c25b/3fdce525b9cbad2c.png","create_at":"2018-10-12 22:56:22","pid":"0","duoji":"","pinyin":"dajiangtang","info":"周二大讲堂课程，每周二不同的老师传授课程","sx1":"3位周二大讲堂","sx2":"主讲人：项行良","iszb":"0","zipres":null,"is_video":null,"sudu":"0"}]}],[{"name":"创业大学","data":[{"id":8,"name":"坑位2分类1的测试视频","type":"创业大学","video_adr":"http://39.105.70.121/test3/MeiJiaDian/static/upload/29f0046fdf167e91/f2385afdad4e3f7f.mp4","is_deleted":"0","sort":"0","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/78ed2c70eef990b5/1be4643ee02e2bad.png","create_at":"2019-03-14 14:39:23","pid":"0","duoji":"","pinyin":"zchlyssp","info":"创业大学知识分享","sx1":"附加介绍1","sx2":"附加介绍2","iszb":"0","zipres":null,"is_video":null,"sudu":"0"},{"id":26,"name":"测试图片","type":"创业大学","video_adr":null,"is_deleted":"0","sort":"0","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/68c47ae19e69a770/a3872acb2e9fa0c3.png","create_at":"2019-08-15 16:38:26","pid":"0","duoji":null,"pinyin":null,"info":null,"sx1":null,"sx2":null,"iszb":null,"zipres":"/var/www/html/test3/MeiJiaDian/file/01da93342716bcb7","is_video":"0","sudu":"2"},{"id":30,"name":"测试图片3","type":"创业大学","video_adr":null,"is_deleted":"0","sort":"0","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/b2483d3a89e769b2/3abc0605b27f3fae.jpg","create_at":"2019-08-15 17:32:59","pid":"0","duoji":null,"pinyin":null,"info":null,"sx1":null,"sx2":null,"iszb":null,"zipres":"/var/www/html/test3/MeiJiaDian/file/b08974427f27d4b0","is_video":"0","sudu":"2"}]}]]
     * is_xh : 0
     * jinbo : {"data":[{"id":2,"user":"admin","create_at":"2019-08-16 11:26:05","pid":"0","sort":"0","status":"1","is_deleted":"0","name":"计划测试2","mac":null,"ip":null,"phone":null,"player":"周二大讲堂,创业大学","start":"15:03","is_xh":"1"},{"id":3,"user":"admin","create_at":"2019-08-18 15:30:04","pid":"0","sort":"0","status":"1","is_deleted":"0","name":"测试","mac":null,"ip":null,"phone":null,"player":"周二大讲堂,创业大学","start":"16:12","is_xh":"0"}],"id":3}
     */

    private int tag;
    private String time;
    private String is_xh;
    private JinboBean jinbo;
    private List<List<GroupBean>> group;
    private String clear;

    public String getClear() {
        return clear;
    }

    public void setClear(String clear) {
        this.clear = clear;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIs_xh() {
        return is_xh;
    }

    public void setIs_xh(String is_xh) {
        this.is_xh = is_xh;
    }

    public JinboBean getJinbo() {
        return jinbo;
    }

    public void setJinbo(JinboBean jinbo) {
        this.jinbo = jinbo;
    }

    public List<List<GroupBean>> getGroup() {
        return group;
    }

    public void setGroup(List<List<GroupBean>> group) {
        this.group = group;
    }

    public static class JinboBean {
        /**
         * data : [{"id":2,"user":"admin","create_at":"2019-08-16 11:26:05","pid":"0","sort":"0","status":"1","is_deleted":"0","name":"计划测试2","mac":null,"ip":null,"phone":null,"player":"周二大讲堂,创业大学","start":"15:03","is_xh":"1"},{"id":3,"user":"admin","create_at":"2019-08-18 15:30:04","pid":"0","sort":"0","status":"1","is_deleted":"0","name":"测试","mac":null,"ip":null,"phone":null,"player":"周二大讲堂,创业大学","start":"16:12","is_xh":"0"}]
         * id : 3
         */

        private int id;
        private List<DataBean> data;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 2
             * user : admin
             * create_at : 2019-08-16 11:26:05
             * pid : 0
             * sort : 0
             * status : 1
             * is_deleted : 0
             * name : 计划测试2
             * mac : null
             * ip : null
             * phone : null
             * player : 周二大讲堂,创业大学
             * start : 15:03
             * is_xh : 1
             */

            private int id;
            private String user;
            private String create_at;
            private String pid;
            private String sort;
            private String status;
            private String is_deleted;
            private String name;
            private Object mac;
            private Object ip;
            private Object phone;
            private String player;
            private String start;
            private String is_xh;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUser() {
                return user;
            }

            public void setUser(String user) {
                this.user = user;
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

            public String getIs_deleted() {
                return is_deleted;
            }

            public void setIs_deleted(String is_deleted) {
                this.is_deleted = is_deleted;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getMac() {
                return mac;
            }

            public void setMac(Object mac) {
                this.mac = mac;
            }

            public Object getIp() {
                return ip;
            }

            public void setIp(Object ip) {
                this.ip = ip;
            }

            public Object getPhone() {
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
            }

            public String getPlayer() {
                return player;
            }

            public void setPlayer(String player) {
                this.player = player;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getIs_xh() {
                return is_xh;
            }

            public void setIs_xh(String is_xh) {
                this.is_xh = is_xh;
            }
        }
    }

    public static class GroupBean {
        /**
         * name : 周二大讲堂
         * data : [{"id":2,"name":"周二大讲堂","type":"周二大讲堂","video_adr":"http://39.105.70.121/test3/MeiJiaDian/static/upload/1b4b92902e3e4c23/49706634bdc9bd71.mp4","is_deleted":"0","sort":"1","status":"1","fm_img":"http://39.105.70.121/test3/MeiJiaDian/static/upload/33880aadbfd7c25b/3fdce525b9cbad2c.png","create_at":"2018-10-12 22:56:22","pid":"0","duoji":"","pinyin":"dajiangtang","info":"周二大讲堂课程，每周二不同的老师传授课程","sx1":"3位周二大讲堂","sx2":"主讲人：项行良","iszb":"0","zipres":null,"is_video":null,"sudu":"0"}]
         */

        private String name;
        private List<DataBeanX> data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<DataBeanX> getData() {
            return data;
        }

        public void setData(List<DataBeanX> data) {
            this.data = data;
        }

        public static class DataBeanX {
            /**
             * id : 2
             * name : 周二大讲堂
             * type : 周二大讲堂
             * video_adr : http://39.105.70.121/test3/MeiJiaDian/static/upload/1b4b92902e3e4c23/49706634bdc9bd71.mp4
             * is_deleted : 0
             * sort : 1
             * status : 1
             * fm_img : http://39.105.70.121/test3/MeiJiaDian/static/upload/33880aadbfd7c25b/3fdce525b9cbad2c.png
             * create_at : 2018-10-12 22:56:22
             * pid : 0
             * duoji :
             * pinyin : dajiangtang
             * info : 周二大讲堂课程，每周二不同的老师传授课程
             * sx1 : 3位周二大讲堂
             * sx2 : 主讲人：项行良
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
