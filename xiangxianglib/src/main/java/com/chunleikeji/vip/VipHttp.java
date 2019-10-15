package com.chunleikeji.vip;

import java.util.List;

public class VipHttp {

    private String msg;
    private List<dataHttp> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<dataHttp> getData() {
        return data;
    }

    public void setData(List<dataHttp> data) {
        this.data = data;
    }

    public static class dataHttp {
        /**
         "pay":"0.01",
         "time":"3",
         "info":"（原价128元）3个月",
         "qrcode":"weixin://wxpay/bizpayurl?pr=gawkmcu"
         * */
        private String pay;
        private int time;
        private String info;
        private String qrcode;

        public String getPay() {
            return pay;
        }

        public void setPay(String pay) {
            this.pay = pay;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
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
