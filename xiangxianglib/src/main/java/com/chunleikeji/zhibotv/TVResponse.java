package com.chunleikeji.zhibotv;



import java.util.List;


public class TVResponse {

    /**
     * msg : 200
     * data : [{"name":"中央1","url":"http://ivi.bupt.edu.cn/hls/cctv1.m3u8"},{"name":" 中央2","url":"http://ivi.bupt.edu.cn/hls/cctv2.m3u8"},{"name":" 中央3","url":"http://ivi.bupt.edu.cn/hls/cctv3.m3u8"},{"name":" 中央4","url":"http://ivi.bupt.edu.cn/hls/cctv4.m3u8"},{"name":" 中央5","url":"http://ivi.bupt.edu.cn/hls/cctv5.m3u8"},{"name":" 中央6","url":"http://ivi.bupt.edu.cn/hls/cctv6.m3u8"},{"name":" 中央7","url":"http://ivi.bupt.edu.cn/hls/cctv7.m3u8"},{"name":" 中央8","url":"http://ivi.bupt.edu.cn/hls/cctv8.m3u8"},{"name":" 中央9","url":"http://ivi.bupt.edu.cn/hls/cctv9.m3u8"},{"name":" 中央10","url":"http://ivi.bupt.edu.cn/hls/cctv10.m3u8"},{"name":" 中央11","url":"http://ivi.bupt.edu.cn/hls/cctv11.m3u8"},{"name":" 中央12","url":"http://ivi.bupt.edu.cn/hls/cctv12.m3u8"},{"name":" 中央13","url":"http://ivi.bupt.edu.cn/hls/cctv13.m3u8"},{"name":" 中央14","url":"http://ivi.bupt.edu.cn/hls/cctv14.m3u8"},{"name":" 中央15","url":"http://ivi.bupt.edu.cn/hls/cctv15.m3u8"}]
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
         * name : 中央1
         * url : http://ivi.bupt.edu.cn/hls/cctv1.m3u8
         */

        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
