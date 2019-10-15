package com.open.androidtvwidget.bean;

import android.graphics.Bitmap;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wh on 2018/2/28.
 */

public class HomeBean {


    /**
     * data : {"lunbo":[{"movie_id":"87","img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1519736052567&di=a635ab6d842aa89a6523c44d33b2b054&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D69b792f43301213fdb3e469f3c8e5ca4%2Fb90e7bec54e736d1cb892a2591504fc2d5626901.jpg","res_id":"1"},{"movie_id":"141","img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1519830069222&di=9c9cd6c05e9a9f42bbd673cf49f9ebb6&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D89679b510046f21fdd3956109e4d0115%2Fbf096b63f6246b60529e67dee1f81a4c500fa28c.jpg","res_id":"10"},{"movie_id":"9","img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1519791226346&di=2aee191fe847a166a40cffc16bf7ad76&imgtype=0&src=http%3A%2F%2Fupload.soyohui.com%2Fupsoyo%2Fimage%2F201507%2F1436424356567395.jpg","res_id":"6"},{"movie_id":"86","img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1519792296761&di=128f23ccbe9b5b3f324a238973a8e41a&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F314e251f95cad1c8b71b56d3753e6709c83d51a5.jpg","res_id":"7"},{"movie_id":"94","img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1519792454737&di=aad7d111508a7abfa9a23d52d493dc81&imgtype=0&src=http%3A%2F%2Fimg010.hc360.cn%2Fy3%2FM02%2F02%2F42%2FwKhQh1URwUmEdZzoAAAAAE5uOdA388.jpg","res_id":"8"}],"dy":[{"movie_id":"2","res_id":"59","title":"【新人向】刀剑神域：GAMESTART","img":"http://imgs.aixifan.com/content/2018_01_16/1516075754.png"},{"movie_id":"4","res_id":"56","title":"Anitama\u2014\u20142017年年度作画集锦","img":"http://i0.hdslb.com/bfs/archive/9d3713bb8a5c20486e7f29cab15689e3d98e8708.jpg"},{"movie_id":"55","res_id":"63","title":"Ask第四期","img":"http://i0.hdslb.com/bfs/archive/3fde9bf67c2f1759e64e03dd0749c1a76684743e.jpg"},{"movie_id":"2","res_id":"58","title":"【新人向】刀剑神域：GAMESTART","img":"http://imgs.aixifan.com/content/2018_01_16/1516075754.png"},{"movie_id":"9","res_id":"50","title":"【燃】海贼王强者的骄傲","img":"http://imgs.aixifan.com/content/2018_01_16/1516069651.png"},{"movie_id":"8","res_id":"51","title":"来自鲤鱼王（李煜）小姐姐的剧情视频~！请各位摄政查收~！","img":"http://imgs.aixifan.com/content/2018_01_16/1516107619.jpg"},{"movie_id":"3","res_id":"42","title":"【国家队/MAD】你就是我的达令了","img":"http://imgs.aixifan.com/content/2018_01_16/1516084351.jpg"},{"movie_id":"3","res_id":"55","title":"【国家队/MAD】你就是我的达令了","img":"http://imgs.aixifan.com/content/2018_01_16/1516084351.jpg"},{"movie_id":"3","res_id":"54","title":"【国家队/MAD】你就是我的达令了","img":"http://imgs.aixifan.com/content/2018_01_16/1516084351.jpg"},{"movie_id":"51","res_id":"61","title":"【创意动画短片】我想成为你的朋友","img":"http://i0.hdslb.com/bfs/archive/b7d5f436cbaf76f38c33626b196e75fbb5389252.png"},{"movie_id":"2","res_id":"53","title":"【新人向】刀剑神域：GAMESTART","img":"http://imgs.aixifan.com/content/2018_01_16/1516075754.png"},{"movie_id":"54","res_id":"62","title":"【混剪】守望先锋募员宣传片（伪）","img":"http://i0.hdslb.com/bfs/archive/aa7bdc6fbc80b76a79abb80411610a6709a63f35.jpg"}],"dsj":[{"movie_id":"89","res_id":"3"},{"movie_id":"90","res_id":"5"},{"movie_id":"89","res_id":"6"},{"movie_id":"84","res_id":"7"},{"movie_id":"88","res_id":"8"},{"movie_id":"87","res_id":"9"},{"movie_id":"90","res_id":"10"},{"movie_id":"86","res_id":"11"},{"movie_id":"93","res_id":"12"},{"movie_id":"94","res_id":"13"}],"jlp":[{"movie_id":"114","res_id":"4"},{"movie_id":"111","res_id":"5"},{"movie_id":"112","res_id":"6"},{"movie_id":"117","res_id":"7"},{"movie_id":"118","res_id":"8"},{"movie_id":"113","res_id":"9"},{"movie_id":"142","res_id":"10"},{"movie_id":"140","res_id":"11"},{"movie_id":"141","res_id":"12"},{"movie_id":"112","res_id":"13"},{"movie_id":"113","res_id":"14"},{"movie_id":"111","res_id":"15"},{"movie_id":"112","res_id":"16"},{"movie_id":"114","res_id":"17"},{"movie_id":"111","res_id":"18"},{"movie_id":"113","res_id":"19"}],"zt":[{"movie_id":"44$43$42$41$","img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1519751194029&di=374f34c14862b8cd62e1a10650463756&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D9d85532d1530e924dba9947224610473%2Fb999a9014c086e068718716e08087bf40ad1cb67.jpg","title":"测试专题","res_id":"6"},{"movie_id":"44$43$42$41$","img":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1519751194029&di=374f34c14862b8cd62e1a10650463756&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D9d85532d1530e924dba9947224610473%2Fb999a9014c086e068718716e08087bf40ad1cb67.jpg","title":"测试专题2","res_id":"7"}]}
     * msg : 加载成功
     * code : 200
     */

    private DataBean data;
    private String msg;
    private String code;

    public static HomeBean objectFromData(String str) {

        return new com.google.gson.Gson().fromJson(str, HomeBean.class);
    }

    public static HomeBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new com.google.gson.Gson().fromJson(jsonObject.getString(str), HomeBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<HomeBean> arrayHomeBeanFromData(String str) {

        Type listType = new com.google.gson.reflect.TypeToken<ArrayList<HomeBean>>() {
        }.getType();

        return new com.google.gson.Gson().fromJson(str, listType);
    }

    public static List<HomeBean> arrayHomeBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new com.google.gson.reflect.TypeToken<ArrayList<HomeBean>>() {
            }.getType();

            return new com.google.gson.Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class DataBean {
        private List<LunboBean> lunbo;
        private List<DyBean> dy;
        private List<DyBean> dsj;
        private List<DyBean> jlp;
        private List<DyBean> zt;

        public List<DyBean> getHj() {
            return hj;
        }

        public void setHj(List<DyBean> hj) {
            this.hj = hj;
        }

        private List<DyBean> hj;
        public static DataBean objectFromData(String str) {

            return new com.google.gson.Gson().fromJson(str, DataBean.class);
        }

        public static DataBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new com.google.gson.Gson().fromJson(jsonObject.getString(str), DataBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new com.google.gson.reflect.TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new com.google.gson.Gson().fromJson(str, listType);
        }

        public static List<DataBean> arrayDataBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new com.google.gson.reflect.TypeToken<ArrayList<DataBean>>() {
                }.getType();

                return new com.google.gson.Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public List<LunboBean> getLunbo() {
            return lunbo;
        }

        public void setLunbo(List<LunboBean> lunbo) {
            this.lunbo = lunbo;
        }

        public List<DyBean> getDy() {
            return dy;
        }

        public void setDy(List<DyBean> dy) {
            this.dy = dy;
        }

        public List<DyBean> getDsj() {
            return dsj;
        }

        public void setDsj(List<DyBean> dsj) {
            this.dsj = dsj;
        }

        public List<DyBean> getJlp() {
            return jlp;
        }

        public void setJlp(List<DyBean> jlp) {
            this.jlp = jlp;
        }

        public List<DyBean> getZt() {
            return zt;
        }

        public void setZt(List<DyBean> zt) {
            this.zt = zt;
        }

        public static class LunboBean {
            /**
             * movie_id : 87
             * img : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1519736052567&di=a635ab6d842aa89a6523c44d33b2b054&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D69b792f43301213fdb3e469f3c8e5ca4%2Fb90e7bec54e736d1cb892a2591504fc2d5626901.jpg
             * res_id : 1
             */

            private String movie_id;
            private String img;
            private String res_id;

            public String getDbname() {
                return dbname;
            }

            public void setDbname(String dbname) {
                this.dbname = dbname;
            }

            private String dbname;
            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            private String tag;

            public Bitmap getCache_Bitmap() {
                return cache_Bitmap;
            }

            public void setCache_Bitmap(Bitmap cache_Bitmap) {
                this.cache_Bitmap = cache_Bitmap;
            }

            private Bitmap cache_Bitmap;

            public static LunboBean objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, LunboBean.class);
            }

            public static LunboBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new com.google.gson.Gson().fromJson(jsonObject.getString(str), LunboBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<LunboBean> arrayLunboBeanFromData(String str) {

                Type listType = new com.google.gson.reflect.TypeToken<ArrayList<LunboBean>>() {
                }.getType();

                return new com.google.gson.Gson().fromJson(str, listType);
            }

            public static List<LunboBean> arrayLunboBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new com.google.gson.reflect.TypeToken<ArrayList<LunboBean>>() {
                    }.getType();

                    return new com.google.gson.Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getMovie_id() {
                return movie_id;
            }

            public void setMovie_id(String movie_id) {
                this.movie_id = movie_id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getRes_id() {
                return res_id;
            }

            public void setRes_id(String res_id) {
                this.res_id = res_id;
            }
        }

        public static class DyBean {
            /**
             * movie_id : 2
             * res_id : 59
             * title : 【新人向】刀剑神域：GAMESTART
             * img : http://imgs.aixifan.com/content/2018_01_16/1516075754.png
             */

            private String movie_id;
            private String res_id;
            private String title;
            private String img;
            private File file;
            private String pf;

            public String getPf() {
                return pf;
            }

            public void setPf(String pf) {
                this.pf = pf;
            }




            public String getBg() {
                return bg;
            }

            public void setBg(String bg) {
                this.bg = bg;
            }

            private String bg;
            public Bitmap getCache_Bitmap() {
                return cache_Bitmap;
            }

            public void setCache_Bitmap(Bitmap cache_Bitmap) {
                this.cache_Bitmap = cache_Bitmap;
            }

            private Bitmap cache_Bitmap;

            public File getFile() {
                return file;
            }

            public void setFile(File file) {
                this.file = file;
            }

            public String getFile_patch() {
                return file_patch;
            }

            public void setFile_patch(String file_patch) {
                this.file_patch = file_patch;
            }

            private String file_patch;

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            //用于自己的标识
            private String tag;

            public static DyBean objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, DyBean.class);
            }

            public static DyBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new com.google.gson.Gson().fromJson(jsonObject.getString(str), DyBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<DyBean> arrayDyBeanFromData(String str) {

                Type listType = new com.google.gson.reflect.TypeToken<ArrayList<DyBean>>() {
                }.getType();

                return new com.google.gson.Gson().fromJson(str, listType);
            }

            public static List<DyBean> arrayDyBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new com.google.gson.reflect.TypeToken<ArrayList<DyBean>>() {
                    }.getType();

                    return new com.google.gson.Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getMovie_id() {
                return movie_id;
            }

            public void setMovie_id(String movie_id) {
                this.movie_id = movie_id;
            }

            public String getRes_id() {
                return res_id;
            }

            public void setRes_id(String res_id) {
                this.res_id = res_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
