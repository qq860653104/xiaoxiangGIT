package zhihu.iptv.jiayin.xiaoxiangketang.apk;

import java.util.List;

public class HttpUtils {

    /**
     * data : [{"id":20,"is_deleted":"0","sort":"0","pid":"0","status":"1","fl_type":"空分类","is_download":"0","apk_addr":"http://39.105.70.121/test3/v3final/static/upload/4bfc4124f86c9a22/e58875d2968b3184.apk","type":null,"apk_name":"未来启蒙","apk_bm":"com.weilaiqimeng.www","apk_icon":"http://www.jiayinkeji.xin/test/apk/temp/3625aaf4285a900c/res/drawable/logo_yuan.png","apk_versioncode":"2","apk_size":null,"create_at":"2019-03-08 22:40:48","day_tag":"2019-05-08","day_zx":"19","day_count":"57","zx_count":"485","click_count":"57","parent":"admin","form_user":"admin","lever":"2","user":"admin","crd_time":"2019-05-12 05:59:25pm"}]
     * msg :
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
         * id : 20
         * is_deleted : 0
         * sort : 0
         * pid : 0
         * status : 1
         * fl_type : 空分类
         * is_download : 0
         * apk_addr : http://39.105.70.121/test3/v3final/static/upload/4bfc4124f86c9a22/e58875d2968b3184.apk
         * type : null
         * apk_name : 未来启蒙
         * apk_bm : com.weilaiqimeng.www
         * apk_icon : http://www.jiayinkeji.xin/test/apk/temp/3625aaf4285a900c/res/drawable/logo_yuan.png
         * apk_versioncode : 2
         * apk_size : null
         * create_at : 2019-03-08 22:40:48
         * day_tag : 2019-05-08
         * day_zx : 19
         * day_count : 57
         * zx_count : 485
         * click_count : 57
         * parent : admin
         * form_user : admin
         * lever : 2
         * user : admin
         * crd_time : 2019-05-12 05:59:25pm
         */

        private int id;
        private String is_deleted;
        private String sort;
        private String pid;
        private String status;
        private String fl_type;
        private String is_download;
        private String apk_addr;
        private Object type;
        private String apk_name;
        private String apk_bm;
        private String apk_icon;
        private String apk_versioncode;
        private Object apk_size;
        private String create_at;
        private String day_tag;
        private String day_zx;
        private String day_count;
        private String zx_count;
        private String click_count;
        private String parent;
        private String form_user;
        private String lever;
        private String user;
        private String crd_time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFl_type() {
            return fl_type;
        }

        public void setFl_type(String fl_type) {
            this.fl_type = fl_type;
        }

        public String getIs_download() {
            return is_download;
        }

        public void setIs_download(String is_download) {
            this.is_download = is_download;
        }

        public String getApk_addr() {
            return apk_addr;
        }

        public void setApk_addr(String apk_addr) {
            this.apk_addr = apk_addr;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public String getApk_name() {
            return apk_name;
        }

        public void setApk_name(String apk_name) {
            this.apk_name = apk_name;
        }

        public String getApk_bm() {
            return apk_bm;
        }

        public void setApk_bm(String apk_bm) {
            this.apk_bm = apk_bm;
        }

        public String getApk_icon() {
            return apk_icon;
        }

        public void setApk_icon(String apk_icon) {
            this.apk_icon = apk_icon;
        }

        public String getApk_versioncode() {
            return apk_versioncode;
        }

        public void setApk_versioncode(String apk_versioncode) {
            this.apk_versioncode = apk_versioncode;
        }

        public Object getApk_size() {
            return apk_size;
        }

        public void setApk_size(Object apk_size) {
            this.apk_size = apk_size;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public String getDay_tag() {
            return day_tag;
        }

        public void setDay_tag(String day_tag) {
            this.day_tag = day_tag;
        }

        public String getDay_zx() {
            return day_zx;
        }

        public void setDay_zx(String day_zx) {
            this.day_zx = day_zx;
        }

        public String getDay_count() {
            return day_count;
        }

        public void setDay_count(String day_count) {
            this.day_count = day_count;
        }

        public String getZx_count() {
            return zx_count;
        }

        public void setZx_count(String zx_count) {
            this.zx_count = zx_count;
        }

        public String getClick_count() {
            return click_count;
        }

        public void setClick_count(String click_count) {
            this.click_count = click_count;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getForm_user() {
            return form_user;
        }

        public void setForm_user(String form_user) {
            this.form_user = form_user;
        }

        public String getLever() {
            return lever;
        }

        public void setLever(String lever) {
            this.lever = lever;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getCrd_time() {
            return crd_time;
        }

        public void setCrd_time(String crd_time) {
            this.crd_time = crd_time;
        }
    }
}
