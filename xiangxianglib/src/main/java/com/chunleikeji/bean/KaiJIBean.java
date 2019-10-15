package com.chunleikeji.bean;

import java.util.List;

public class KaiJIBean {

    /**
     * videourl : http://39.105.70.121/test3/ZhihuAdmin/static/upload/d229c5d867f3fd6e/061be3c096420d24.mp4
     * imageurl : http://39.105.70.121/test3/v3final/static/upload/2b011d426f5f5e74/d2f18a1aac563c7f.png
     * restype : 0
     */

    private String videourl;
    private String imageurl;
    private String restype;
    private List<PifuBean> pifu;

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getRestype() {
        return restype;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }

    public List<PifuBean> getPifu() {
        return pifu;
    }

    public void setPifu(List<PifuBean> pifu) {
        this.pifu = pifu;
    }

    public static class PifuBean {
        /**
         * id : 1
         * user : null
         * create_at : 2019-08-18 22:54:54
         * pid : 0
         * sort : 0
         * status : 1
         * is_deleted : 0
         * name : 测试
         * mac : null
         * ip : null
         * phone : null
         * player : null
         * start : 2019-08-18 00:00:00
         * is_xh : null
         * pi1 : http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png
         * pi2 : http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png
         * pi3 : http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png
         * pi0 : http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png
         * pi4 : http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png
         * pi5 : http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png
         * pi6 : http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png
         * pi7 : http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png
         * tupian : http://39.105.70.121/test3/MeiJiaDian/static/upload/456fc9ffcddccf59/c70df0e9cdf5439f.png
         * beijing : http://39.105.70.121/test3/MeiJiaDian/static/upload/91aee0890039caf3/94541258f63dcd38.png
         */

        private int id;
        private Object user;
        private String create_at;
        private String pid;
        private String sort;
        private String status;
        private String is_deleted;
        private String name;
        private Object mac;
        private Object ip;
        private Object phone;
        private Object player;
        private String start;
        private Object is_xh;
        private String pi1;
        private String pi2;
        private String pi3;
        private String pi0;
        private String pi4;
        private String pi5;
        private String pi6;
        private String pi7;
        private String tupian;
        private String beijing;
        private String shipin;

        public String getShipin() {
            return shipin;
        }

        public void setShipin(String shipin) {
            this.shipin = shipin;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getUser() {
            return user;
        }

        public void setUser(Object user) {
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

        public Object getPlayer() {
            return player;
        }

        public void setPlayer(Object player) {
            this.player = player;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public Object getIs_xh() {
            return is_xh;
        }

        public void setIs_xh(Object is_xh) {
            this.is_xh = is_xh;
        }

        public String getPi1() {
            return pi1;
        }

        public void setPi1(String pi1) {
            this.pi1 = pi1;
        }

        public String getPi2() {
            return pi2;
        }

        public void setPi2(String pi2) {
            this.pi2 = pi2;
        }

        public String getPi3() {
            return pi3;
        }

        public void setPi3(String pi3) {
            this.pi3 = pi3;
        }

        public String getPi0() {
            return pi0;
        }

        public void setPi0(String pi0) {
            this.pi0 = pi0;
        }

        public String getPi4() {
            return pi4;
        }

        public void setPi4(String pi4) {
            this.pi4 = pi4;
        }

        public String getPi5() {
            return pi5;
        }

        public void setPi5(String pi5) {
            this.pi5 = pi5;
        }

        public String getPi6() {
            return pi6;
        }

        public void setPi6(String pi6) {
            this.pi6 = pi6;
        }

        public String getPi7() {
            return pi7;
        }

        public void setPi7(String pi7) {
            this.pi7 = pi7;
        }

        public String getTupian() {
            return tupian;
        }

        public void setTupian(String tupian) {
            this.tupian = tupian;
        }

        public String getBeijing() {
            return beijing;
        }

        public void setBeijing(String beijing) {
            this.beijing = beijing;
        }
    }
}
