package com.chunleikeji.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wh on 2018/3/16.
 */

public class AllMovieBean {


    /**
     * code : 200
     * msg : 成功
     * data : [{"detail":{"tag":"1","movie":[{"pic":"初始化","id":"初始化","title":"初始化"}]}},{"detail":{"tag":"9","movie":[{"pic":"/attachment/vod/201803/14/2018031414304151163.jpg","id":"392","title":"唐人街探案"},{"pic":"/attachment/vod/201803/14/2018031414302887558.jpg","id":"395","title":"宝贝特攻"},{"pic":"/attachment/vod/201803/14/2018031414304511734.jpg","id":"365","title":"赏金猎人"},{"pic":"/attachment/vod/201803/14/2018031414305129455.jpg","id":"343","title":"追击"},{"pic":"/attachment/vod/201803/14/2018031414304595218.jpg","id":"335","title":"非凡任务"},{"pic":"/attachment/vod/201803/14/2018031414305641842.jpg","id":"331","title":"湄公河行动"},{"pic":"/attachment/vod/201803/14/2018031414305186349.jpg","id":"320","title":"绑架者"}]}},{"detail":{"tag":"10","movie":[{"pic":"/attachment/vod/201803/14/2018031414305129570.jpg","id":"344","title":"捉妖记"},{"pic":"/attachment/vod/201803/14/2018031414305032120.jpg","id":"342","title":"唐人街探案"},{"pic":"/attachment/vod/201803/14/2018031414305610769.jpg","id":"334","title":"健忘村"},{"pic":"/attachment/vod/201803/14/2018031414305658527.jpg","id":"332","title":"乘风破浪"},{"pic":"/attachment/vod/201803/14/2018031414303664530.jpg","id":"322","title":"欢乐喜剧人"},{"pic":"/attachment/vod/201803/14/2018031414305167639.jpg","id":"323","title":"爱情冻住了"},{"pic":"/attachment/vod/201803/14/2018031414305131614.jpg","id":"319","title":"玛格丽特的春天"},{"pic":"/attachment/vod/201803/14/2018031414305144103.jpg","id":"317","title":"斗魂之熊孩子"},{"pic":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2455050536.jpg","id":"495","title":"上传电影测试"}]}},{"detail":{"tag":"11","movie":[{"pic":"/attachment/vod/201803/14/2018031414304143847.jpg","id":"394","title":"请爱我的女朋友"},{"pic":"/attachment/vod/201803/14/2018031414304558291.jpg","id":"336","title":"七月与安生"},{"pic":"/attachment/vod/201803/14/2018031414305642597.jpg","id":"333","title":"微微一笑很倾城"},{"pic":"/attachment/vod/201803/14/2018031414305251089.jpg","id":"321","title":"海角有个五店市"},{"pic":"/attachment/vod/201803/14/2018031414305197080.jpg","id":"316","title":"咱们分手吧"}]}},{"detail":{"tag":"12","movie":[{"pic":"初始化","id":"初始化","title":"初始化"}]}},{"detail":{"tag":"13","movie":[{"pic":"/attachment/vod/201803/14/2018031414305129200.jpg","id":"318","title":"诡眼"}]}},{"detail":{"tag":"14","movie":[{"pic":"/attachment/vod/201803/14/2018031414304571278.jpg","id":"369","title":"填满"},{"pic":"/attachment/vod/201803/14/2018031414304143814.jpg","id":"350","title":"丽人行"},{"pic":"/attachment/vod/201803/14/2018031414304122583.jpg","id":"349","title":"希望在人间"}]}},{"detail":{"tag":"17","movie":[{"pic":"/attachment/vod/201803/14/2018031414303378238.jpg","id":"412","title":"金陵十三钗"}]}},{"detail":{"tag":"15","movie":[{"pic":"/attachment/vod/201803/14/2018031414304159756.jpg","id":"351","title":"荷兰杀手"}]}},{"detail":{"tag":"16","movie":[{"pic":"/attachment/vod/201803/14/2018031414304161615.jpg","id":"393","title":"大熊猫传奇"}]}},{"detail":{"tag":"2","movie":[{"pic":"初始化","id":"初始化","title":"初始化"}]}},{"detail":{"tag":"18","movie":[{"pic":"初始化","id":"初始化","title":"初始化"}]}},{"detail":{"tag":"19","movie":[{"pic":"/attachment/vod/201803/14/2018031414302759287.jpg","id":"435","title":"谈判官 TV版"},{"pic":"/attachment/vod/201803/14/2018031414302438598.jpg","id":"434","title":"热血勇士"},{"pic":"/attachment/vod/201803/14/2018031414302494287.jpg","id":"432","title":"莫斯科行动 TV版"},{"pic":"/attachment/vod/201803/14/2018031414302470114.jpg","id":"433","title":"幸福起航"},{"pic":"/attachment/vod/201803/14/2018031414302437067.jpg","id":"431","title":"莫斯科行动 DVD版"},{"pic":"/attachment/vod/201803/14/2018031414303350356.jpg","id":"416","title":"谈判官 DVD版"},{"pic":"/attachment/vod/201803/14/2018031414303320019.jpg","id":"417","title":"相爱穿梭千年"},{"pic":"/attachment/vod/201803/14/2018031414303381735.jpg","id":"418","title":"我的青春遇见你 DVD版"},{"pic":"/attachment/vod/201803/14/2018031414303349752.jpg","id":"419","title":"恋爱先生"},{"pic":"/attachment/vod/201803/14/2018031414303334287.jpg","id":"420","title":"我的继父是偶像"},{"pic":"/attachment/vod/201803/14/2018031414303380763.jpg","id":"421","title":"和平饭店 DVD版"},{"pic":"/attachment/vod/201803/14/2018031414303324905.jpg","id":"422","title":"和平饭店 TV版"}]}},{"detail":{"tag":"20","movie":[{"pic":"初始化","id":"初始化","title":"初始化"}]}},{"detail":{"tag":"21","movie":[{"pic":"初始化","id":"初始化","title":"初始化"}]}},{"detail":{"tag":"3","movie":[{"pic":"/attachment/vod/201803/14/2018031414302060908.jpg","id":"456","title":"皇帝圣印战记"},{"pic":"/attachment/vod/201803/14/2018031414302058715.jpg","id":"457","title":"牙斗兽娘"},{"pic":"/attachment/vod/201803/14/2018031414302094275.jpg","id":"458","title":"49的灵魂"},{"pic":"/attachment/vod/201803/14/2018031414303324471.jpg","id":"411","title":"魔卡少女樱 透明牌篇"},{"pic":"/attachment/vod/201803/14/2018031414304022769.jpg","id":"389","title":"画江湖之换世门生"},{"pic":"/attachment/vod/201803/14/2018031414304017477.jpg","id":"390","title":"暴走恐怖故事之惊门诡事"},{"pic":"/attachment/vod/201803/14/2018031414304044934.jpg","id":"391","title":"欧布奥特曼 中文版"},{"pic":"/attachment/vod/201803/14/2018031414304079278.jpg","id":"387","title":"兔小蛋彩泥DIY"},{"pic":"/attachment/vod/201803/14/2018031414304079181.jpg","id":"388","title":"小猪班纳 第三季"},{"pic":"/attachment/vod/201803/14/2018031414303734825.jpg","id":"386","title":"Gon的旱獭"},{"pic":"/attachment/vod/201803/14/2018031414304530197.jpg","id":"360","title":"黑色四叶草"},{"pic":"/attachment/vod/201803/14/2018031414304542543.jpg","id":"361","title":"Infini-T Force"}]}},{"detail":{"tag":"4","movie":[{"pic":"/attachment/vod/201803/14/2018031414302053956.jpg","id":"460","title":"我的大学 2018"},{"pic":"/attachment/vod/201803/14/2018031414302415732.jpg","id":"450","title":"北京评书大会 2018"},{"pic":"/attachment/vod/201803/14/2018031414302448462.jpg","id":"451","title":"笑动欢乐秀 2018"},{"pic":"/attachment/vod/201803/14/2018031414302351066.jpg","id":"452","title":"美食地图 2018"},{"pic":"/attachment/vod/201803/14/2018031414302018219.jpg","id":"453","title":"每日文娱播报 2018 3月"},{"pic":"/attachment/vod/201803/14/2018031414302039691.jpg","id":"454","title":"娱乐乐翻天 2018 3月"},{"pic":"/attachment/vod/201803/14/2018031414302042004.jpg","id":"455","title":"明星10s时装周"},{"pic":"/attachment/vod/201803/14/2018031414302058577.jpg","id":"459","title":"戏里戏外 2018"},{"pic":"/attachment/vod/201803/14/2018031414302386425.jpg","id":"446","title":"生活广角 2018"},{"pic":"/attachment/vod/201803/14/2018031414302385114.jpg","id":"447","title":"我看行 2018"},{"pic":"/attachment/vod/201803/14/2018031414302376300.jpg","id":"448","title":"家政女皇 2018"},{"pic":"/attachment/vod/201803/14/2018031414302394703.jpg","id":"449","title":"耍大牌 2018"}]}},{"detail":{"tag":"5","movie":[{"pic":"初始化","id":"初始化","title":"初始化"}]}}]
     */

    private String code;
    private String msg;
    private ArrayList<DataBean> data;

    public static AllMovieBean objectFromData(String str) {

        return new Gson().fromJson(str, AllMovieBean.class);
    }

    public static AllMovieBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), AllMovieBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<AllMovieBean> arrayAllMovieBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<AllMovieBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<AllMovieBean> arrayAllMovieBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<AllMovieBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * detail : {"tag":"1","movie":[{"pic":"初始化","id":"初始化","title":"初始化"}]}
         */

        private DetailBean detail;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public static DataBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), DataBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<DataBean> arrayDataBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<DataBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public DetailBean getDetail() {
            return detail;
        }

        public void setDetail(DetailBean detail) {
            this.detail = detail;
        }

        public static class DetailBean {
            /**
             * tag : 1
             * movie : [{"pic":"初始化","id":"初始化","title":"初始化"}]
             */

            private String tag;
            private ArrayList<MovieBean> movie;

            public static DetailBean objectFromData(String str) {

                return new Gson().fromJson(str, DetailBean.class);
            }

            public static DetailBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), DetailBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<DetailBean> arrayDetailBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<DetailBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<DetailBean> arrayDetailBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<DetailBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public ArrayList<MovieBean> getMovie() {
                return movie;
            }

            public void setMovie(ArrayList<MovieBean> movie) {
                this.movie = movie;
            }

            public static class MovieBean {
                /**
                 * pic : 初始化
                 * id : 初始化
                 * title : 初始化
                 */

                private String pic;
                private String id;
                private String title;

                public static MovieBean objectFromData(String str) {

                    return new Gson().fromJson(str, MovieBean.class);
                }

                public static MovieBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), MovieBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<MovieBean> arrayMovieBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<MovieBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<MovieBean> arrayMovieBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<MovieBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }
    }
}
