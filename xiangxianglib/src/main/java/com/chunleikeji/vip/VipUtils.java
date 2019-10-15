package com.chunleikeji.vip;

import java.util.List;

public class VipUtils {

    /**
     * msg : 获取成功
     * data : [{"pay":"0.01","time":"30","info":"一个月","qrcode":"weixin://wxpay/bizpayurl?pr=XxxHDVW"},{"pay":"60","time":"60","info":"二个月","qrcode":"weixin://wxpay/bizpayurl?pr=xFK7FRV"},{"pay":"90","time":"90","info":"三个月","qrcode":"weixin://wxpay/bizpayurl?pr=aJczJML"},{"pay":"120","time":"120","info":"四个月","qrcode":"weixin://wxpay/bizpayurl?pr=TeLBdx6"}]
     */
    private int tag;
    private String msg;
    private String end_time;
    private List<DataBean> data;

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

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
         * pay : 0.01
         * time : 30
         * info : 一个月
         * qrcode : weixin://wxpay/bizpayurl?pr=XxxHDVW
         */

        private String pay;
        private String time;
        private String info;
        private String qrcode;

        public String getPay() {
            return pay;
        }

        public void setPay(String pay) {
            this.pay = pay;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }
    }
}
