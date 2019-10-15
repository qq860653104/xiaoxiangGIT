package zhihu.iptv.jiayin.xiaoxiangketang;

import com.chunleikeji.bean.AllMovieBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by wh on 2018/3/26.
 */

public class MovieUpdataBean {


    /**
     * detail : {"tag":"9","movie":[{"pic":"/attachment/vod/201803/23/2018032318484639937.jpg","id":"3109","title":"兄弟之义字当头"},{"pic":"/attachment/vod/201803/23/2018032318304370324.jpg","id":"7949","title":"哥斯拉"},{"pic":"/attachment/vod/201803/23/2018032318483269466.jpg","id":"3189","title":"霹雳囧花"},{"pic":"/attachment/vod/201803/23/2018032318292669320.jpg","id":"8312","title":"超级保镖"},{"pic":"/attachment/vod/201803/23/2018032318292289522.jpg","id":"8341","title":"荒野猎人"},{"pic":"/attachment/vod/201803/23/2018032318480888806.jpg","id":"3312","title":"女飞虎"},{"pic":"/attachment/vod/201803/23/2018032318473882378.jpg","id":"3444","title":"诛仙番外之铃心剑魄"},{"pic":"/attachment/vod/201803/23/2018032318282222382.jpg","id":"8610","title":"大唐狄仁杰之东瀛邪术"},{"pic":"/attachment/vod/201803/23/2018032318275560684.jpg","id":"8708","title":"风暴"},{"pic":"/attachment/vod/201803/23/2018032318465576162.jpg","id":"3645","title":"七星碧玉刀"},{"pic":"/attachment/vod/201803/23/2018032318465093317.jpg","id":"3660","title":"少林英雄"},{"pic":"/attachment/vod/201803/23/2018032318462764779.jpg","id":"3759","title":"同归于尽"},{"pic":"/attachment/vod/201803/23/2018032318462343173.jpg","id":"3793","title":"赌王出山"},{"pic":"/attachment/vod/201803/23/2018032318453746685.jpg","id":"4005","title":"义胆雄心"},{"pic":"/attachment/vod/201803/23/2018032318453716130.jpg","id":"4006","title":"冷战"},{"pic":"/attachment/vod/201803/23/2018032318453724133.jpg","id":"4008","title":"D7特警"},{"pic":"/attachment/vod/201803/23/2018032318453748409.jpg","id":"4009","title":"铁男本色"},{"pic":"/attachment/vod/201803/23/2018032318453771817.jpg","id":"4012","title":"暗斗"},{"pic":"/attachment/vod/201803/23/2018032318452946975.jpg","id":"4050","title":"真命天子"},{"pic":"/attachment/vod/201803/23/2018032318451136398.jpg","id":"4141","title":"特工管家"},{"pic":"/attachment/vod/201803/23/2018032318450249857.jpg","id":"4199","title":"黄河大侠"},{"pic":"/attachment/vod/201803/23/2018032318312052271.jpg","id":"7784","title":"狼族觉醒之夜狼"},{"pic":"/attachment/vod/201803/23/2018032318445472702.jpg","id":"4226","title":"西安杀戮"},{"pic":"/attachment/vod/201803/23/2018032318444455541.jpg","id":"4307","title":"狂暴街区"},{"pic":"/attachment/vod/201803/23/2018032318444325881.jpg","id":"4309","title":"麻将门"},{"pic":"/attachment/vod/201803/23/2018032318441515720.jpg","id":"4432","title":"夜走鬼城"},{"pic":"/attachment/vod/201803/23/2018032318441514687.jpg","id":"4454","title":"赤裸女特工2暗夜舞者"},{"pic":"/attachment/vod/201803/23/2018032318441082662.jpg","id":"4455","title":"大刀王五"},{"pic":"/attachment/vod/201803/23/2018032318440475680.jpg","id":"4479","title":"大冲撞"},{"pic":"/attachment/vod/201803/23/2018032318260112642.jpg","id":"9186","title":"蜿龙"},{"pic":"/attachment/vod/201803/23/2018032318431854904.jpg","id":"4881","title":"天下无双"},{"pic":"/attachment/vod/201803/23/2018032318425138913.jpg","id":"5000","title":"喜乐长安"},{"pic":"/attachment/vod/201803/23/2018032318423626116.jpg","id":"5067","title":"生死对决"},{"pic":"/attachment/vod/201803/23/2018032318423379410.jpg","id":"5077","title":"西域响马"},{"pic":"/attachment/vod/201803/23/2018032318423242766.jpg","id":"5089","title":"香港浴血"},{"pic":"/attachment/vod/201803/23/2018032318422530336.jpg","id":"5113","title":"最佳拍档之女皇密令"},{"pic":"/attachment/vod/201803/23/2018032318421197699.jpg","id":"5180","title":"椰林曲"},{"pic":"/attachment/vod/201803/23/2018032318420164021.jpg","id":"5224","title":"木兰从军"},{"pic":"/attachment/vod/201803/23/2018032318415667344.jpg","id":"5231","title":"混江龙李俊"},{"pic":"/attachment/vod/201803/23/2018032318413565701.jpg","id":"5331","title":"我们混过的江湖"},{"pic":"/attachment/vod/201803/23/2018032318411191817.jpg","id":"5445","title":"战将之兄弟"},{"pic":"/attachment/vod/201803/23/2018032318410274122.jpg","id":"5475","title":"喋血柔情"},{"pic":"/attachment/vod/201803/23/2018032318410235599.jpg","id":"5477","title":"变形者之幽灵杀手"},{"pic":"/attachment/vod/201803/23/2018032318404773622.jpg","id":"5546","title":"迷途之兵痞"},{"pic":"/attachment/vod/201803/23/2018032318404213643.jpg","id":"5555","title":"疯狂夺爱之搏击少年"},{"pic":"/attachment/vod/201803/23/2018032318404232196.jpg","id":"5563","title":"生猛海鲜"},{"pic":"/attachment/vod/201803/23/2018032318403293945.jpg","id":"5609","title":"骗贷风云"},{"pic":"/attachment/vod/201803/23/2018032318381444538.jpg","id":"6226","title":"铁血壮士"},{"pic":"/attachment/vod/201803/23/2018032318350050266.jpg","id":"7064","title":"青眼虎李云"},{"pic":"/attachment/vod/201803/23/2018032318345973512.jpg","id":"7070","title":"侠僧探案传奇之催命符"},{"pic":"/attachment/vod/201803/23/2018032318345951498.jpg","id":"7071","title":"侠僧探案传奇之开封府"},{"pic":"/attachment/vod/201803/23/2018032318345668695.jpg","id":"7072","title":"侠僧探案传奇之醉玲珑"},{"pic":"/attachment/vod/201803/23/2018032318345615498.jpg","id":"7073","title":"侠僧探案传奇之洛阳花会"},{"pic":"/attachment/vod/201803/23/2018032318345622965.jpg","id":"7074","title":"侠僧探案传奇之白马镖局"},{"pic":"/attachment/vod/201803/23/2018032318345674044.jpg","id":"7075","title":"侠僧探案传奇之王陵之谜"},{"pic":"/attachment/vod/201803/23/2018032318345639152.jpg","id":"7076","title":"侠僧探案传奇之聚义钱庄"},{"pic":"/attachment/vod/201803/23/2018032318345686566.jpg","id":"7081","title":"功夫世家"},{"pic":"/attachment/vod/201803/23/2018032318345239135.jpg","id":"7107","title":"逆鳞"},{"pic":"/attachment/vod/201803/23/2018032318342732686.jpg","id":"7178","title":"刺客信条"},{"pic":"/attachment/vod/201803/23/2018032318342149559.jpg","id":"7193","title":"夺宝联盟"},{"pic":"/attachment/vod/201803/23/2018032318342187673.jpg","id":"7201","title":"机械师2：复活"},{"pic":"/attachment/vod/201803/23/2018032318341623448.jpg","id":"7202","title":"使徒行者"},{"pic":"/attachment/vod/201803/23/2018032318341690556.jpg","id":"7206","title":"疯狂的麦克斯"},{"pic":"/attachment/vod/201803/23/2018032318341630792.jpg","id":"7207","title":"康斯坦丁"},{"pic":"/attachment/vod/201803/23/2018032318341184460.jpg","id":"7225","title":"危城"},{"pic":"/attachment/vod/201803/23/2018032318340741314.jpg","id":"7230","title":"猩球崛起"},{"pic":"/attachment/vod/201803/23/2018032318340614866.jpg","id":"7239","title":"杀破狼2"},{"pic":"/attachment/vod/201803/23/2018032318334773558.jpg","id":"7265","title":"道士下山"},{"pic":"/attachment/vod/201803/23/2018032318334631803.jpg","id":"7275","title":"三人行"},{"pic":"/attachment/vod/201803/23/2018032318334568051.jpg","id":"7280","title":"十字追杀令2"},{"pic":"/attachment/vod/201803/23/2018032318332681226.jpg","id":"7318","title":"白雪公主和三只小猪"},{"pic":"/attachment/vod/201803/23/2018032318332612013.jpg","id":"7319","title":"冲天火"},{"pic":"/attachment/vod/201803/23/2018032318332596529.jpg","id":"7326","title":"封神传奇"},{"pic":"/attachment/vod/201803/23/2018032318330555246.jpg","id":"7374","title":"蜂鸟特攻"},{"pic":"/attachment/vod/201803/23/2018032318325956842.jpg","id":"7389","title":"一个人的武林"},{"pic":"/attachment/vod/201803/23/2018032318324164350.jpg","id":"7425","title":"反黑行动组"},{"pic":"/attachment/vod/201803/23/2018032318324147888.jpg","id":"7426","title":"东宫皇子"},{"pic":"/attachment/vod/201803/23/2018032318323637182.jpg","id":"7441","title":"加勒比海盗4：惊涛怪浪"},{"pic":"/attachment/vod/201803/23/2018032318323228693.jpg","id":"7464","title":"金刚狼2"},{"pic":"/attachment/vod/201803/23/2018032318323268981.jpg","id":"7468","title":"玄笔录前传之异域魔道"}]}
     */

    private DetailBean detail;

    public static MovieUpdataBean objectFromData(String str) {

        return new Gson().fromJson(str, MovieUpdataBean.class);
    }

    public static MovieUpdataBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), MovieUpdataBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<MovieUpdataBean> arrayMovieUpdataBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<MovieUpdataBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<MovieUpdataBean> arrayMovieUpdataBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<MovieUpdataBean>>() {
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
         * tag : 9
         * movie : [{"pic":"/attachment/vod/201803/23/2018032318484639937.jpg","id":"3109","title":"兄弟之义字当头"},{"pic":"/attachment/vod/201803/23/2018032318304370324.jpg","id":"7949","title":"哥斯拉"},{"pic":"/attachment/vod/201803/23/2018032318483269466.jpg","id":"3189","title":"霹雳囧花"},{"pic":"/attachment/vod/201803/23/2018032318292669320.jpg","id":"8312","title":"超级保镖"},{"pic":"/attachment/vod/201803/23/2018032318292289522.jpg","id":"8341","title":"荒野猎人"},{"pic":"/attachment/vod/201803/23/2018032318480888806.jpg","id":"3312","title":"女飞虎"},{"pic":"/attachment/vod/201803/23/2018032318473882378.jpg","id":"3444","title":"诛仙番外之铃心剑魄"},{"pic":"/attachment/vod/201803/23/2018032318282222382.jpg","id":"8610","title":"大唐狄仁杰之东瀛邪术"},{"pic":"/attachment/vod/201803/23/2018032318275560684.jpg","id":"8708","title":"风暴"},{"pic":"/attachment/vod/201803/23/2018032318465576162.jpg","id":"3645","title":"七星碧玉刀"},{"pic":"/attachment/vod/201803/23/2018032318465093317.jpg","id":"3660","title":"少林英雄"},{"pic":"/attachment/vod/201803/23/2018032318462764779.jpg","id":"3759","title":"同归于尽"},{"pic":"/attachment/vod/201803/23/2018032318462343173.jpg","id":"3793","title":"赌王出山"},{"pic":"/attachment/vod/201803/23/2018032318453746685.jpg","id":"4005","title":"义胆雄心"},{"pic":"/attachment/vod/201803/23/2018032318453716130.jpg","id":"4006","title":"冷战"},{"pic":"/attachment/vod/201803/23/2018032318453724133.jpg","id":"4008","title":"D7特警"},{"pic":"/attachment/vod/201803/23/2018032318453748409.jpg","id":"4009","title":"铁男本色"},{"pic":"/attachment/vod/201803/23/2018032318453771817.jpg","id":"4012","title":"暗斗"},{"pic":"/attachment/vod/201803/23/2018032318452946975.jpg","id":"4050","title":"真命天子"},{"pic":"/attachment/vod/201803/23/2018032318451136398.jpg","id":"4141","title":"特工管家"},{"pic":"/attachment/vod/201803/23/2018032318450249857.jpg","id":"4199","title":"黄河大侠"},{"pic":"/attachment/vod/201803/23/2018032318312052271.jpg","id":"7784","title":"狼族觉醒之夜狼"},{"pic":"/attachment/vod/201803/23/2018032318445472702.jpg","id":"4226","title":"西安杀戮"},{"pic":"/attachment/vod/201803/23/2018032318444455541.jpg","id":"4307","title":"狂暴街区"},{"pic":"/attachment/vod/201803/23/2018032318444325881.jpg","id":"4309","title":"麻将门"},{"pic":"/attachment/vod/201803/23/2018032318441515720.jpg","id":"4432","title":"夜走鬼城"},{"pic":"/attachment/vod/201803/23/2018032318441514687.jpg","id":"4454","title":"赤裸女特工2暗夜舞者"},{"pic":"/attachment/vod/201803/23/2018032318441082662.jpg","id":"4455","title":"大刀王五"},{"pic":"/attachment/vod/201803/23/2018032318440475680.jpg","id":"4479","title":"大冲撞"},{"pic":"/attachment/vod/201803/23/2018032318260112642.jpg","id":"9186","title":"蜿龙"},{"pic":"/attachment/vod/201803/23/2018032318431854904.jpg","id":"4881","title":"天下无双"},{"pic":"/attachment/vod/201803/23/2018032318425138913.jpg","id":"5000","title":"喜乐长安"},{"pic":"/attachment/vod/201803/23/2018032318423626116.jpg","id":"5067","title":"生死对决"},{"pic":"/attachment/vod/201803/23/2018032318423379410.jpg","id":"5077","title":"西域响马"},{"pic":"/attachment/vod/201803/23/2018032318423242766.jpg","id":"5089","title":"香港浴血"},{"pic":"/attachment/vod/201803/23/2018032318422530336.jpg","id":"5113","title":"最佳拍档之女皇密令"},{"pic":"/attachment/vod/201803/23/2018032318421197699.jpg","id":"5180","title":"椰林曲"},{"pic":"/attachment/vod/201803/23/2018032318420164021.jpg","id":"5224","title":"木兰从军"},{"pic":"/attachment/vod/201803/23/2018032318415667344.jpg","id":"5231","title":"混江龙李俊"},{"pic":"/attachment/vod/201803/23/2018032318413565701.jpg","id":"5331","title":"我们混过的江湖"},{"pic":"/attachment/vod/201803/23/2018032318411191817.jpg","id":"5445","title":"战将之兄弟"},{"pic":"/attachment/vod/201803/23/2018032318410274122.jpg","id":"5475","title":"喋血柔情"},{"pic":"/attachment/vod/201803/23/2018032318410235599.jpg","id":"5477","title":"变形者之幽灵杀手"},{"pic":"/attachment/vod/201803/23/2018032318404773622.jpg","id":"5546","title":"迷途之兵痞"},{"pic":"/attachment/vod/201803/23/2018032318404213643.jpg","id":"5555","title":"疯狂夺爱之搏击少年"},{"pic":"/attachment/vod/201803/23/2018032318404232196.jpg","id":"5563","title":"生猛海鲜"},{"pic":"/attachment/vod/201803/23/2018032318403293945.jpg","id":"5609","title":"骗贷风云"},{"pic":"/attachment/vod/201803/23/2018032318381444538.jpg","id":"6226","title":"铁血壮士"},{"pic":"/attachment/vod/201803/23/2018032318350050266.jpg","id":"7064","title":"青眼虎李云"},{"pic":"/attachment/vod/201803/23/2018032318345973512.jpg","id":"7070","title":"侠僧探案传奇之催命符"},{"pic":"/attachment/vod/201803/23/2018032318345951498.jpg","id":"7071","title":"侠僧探案传奇之开封府"},{"pic":"/attachment/vod/201803/23/2018032318345668695.jpg","id":"7072","title":"侠僧探案传奇之醉玲珑"},{"pic":"/attachment/vod/201803/23/2018032318345615498.jpg","id":"7073","title":"侠僧探案传奇之洛阳花会"},{"pic":"/attachment/vod/201803/23/2018032318345622965.jpg","id":"7074","title":"侠僧探案传奇之白马镖局"},{"pic":"/attachment/vod/201803/23/2018032318345674044.jpg","id":"7075","title":"侠僧探案传奇之王陵之谜"},{"pic":"/attachment/vod/201803/23/2018032318345639152.jpg","id":"7076","title":"侠僧探案传奇之聚义钱庄"},{"pic":"/attachment/vod/201803/23/2018032318345686566.jpg","id":"7081","title":"功夫世家"},{"pic":"/attachment/vod/201803/23/2018032318345239135.jpg","id":"7107","title":"逆鳞"},{"pic":"/attachment/vod/201803/23/2018032318342732686.jpg","id":"7178","title":"刺客信条"},{"pic":"/attachment/vod/201803/23/2018032318342149559.jpg","id":"7193","title":"夺宝联盟"},{"pic":"/attachment/vod/201803/23/2018032318342187673.jpg","id":"7201","title":"机械师2：复活"},{"pic":"/attachment/vod/201803/23/2018032318341623448.jpg","id":"7202","title":"使徒行者"},{"pic":"/attachment/vod/201803/23/2018032318341690556.jpg","id":"7206","title":"疯狂的麦克斯"},{"pic":"/attachment/vod/201803/23/2018032318341630792.jpg","id":"7207","title":"康斯坦丁"},{"pic":"/attachment/vod/201803/23/2018032318341184460.jpg","id":"7225","title":"危城"},{"pic":"/attachment/vod/201803/23/2018032318340741314.jpg","id":"7230","title":"猩球崛起"},{"pic":"/attachment/vod/201803/23/2018032318340614866.jpg","id":"7239","title":"杀破狼2"},{"pic":"/attachment/vod/201803/23/2018032318334773558.jpg","id":"7265","title":"道士下山"},{"pic":"/attachment/vod/201803/23/2018032318334631803.jpg","id":"7275","title":"三人行"},{"pic":"/attachment/vod/201803/23/2018032318334568051.jpg","id":"7280","title":"十字追杀令2"},{"pic":"/attachment/vod/201803/23/2018032318332681226.jpg","id":"7318","title":"白雪公主和三只小猪"},{"pic":"/attachment/vod/201803/23/2018032318332612013.jpg","id":"7319","title":"冲天火"},{"pic":"/attachment/vod/201803/23/2018032318332596529.jpg","id":"7326","title":"封神传奇"},{"pic":"/attachment/vod/201803/23/2018032318330555246.jpg","id":"7374","title":"蜂鸟特攻"},{"pic":"/attachment/vod/201803/23/2018032318325956842.jpg","id":"7389","title":"一个人的武林"},{"pic":"/attachment/vod/201803/23/2018032318324164350.jpg","id":"7425","title":"反黑行动组"},{"pic":"/attachment/vod/201803/23/2018032318324147888.jpg","id":"7426","title":"东宫皇子"},{"pic":"/attachment/vod/201803/23/2018032318323637182.jpg","id":"7441","title":"加勒比海盗4：惊涛怪浪"},{"pic":"/attachment/vod/201803/23/2018032318323228693.jpg","id":"7464","title":"金刚狼2"},{"pic":"/attachment/vod/201803/23/2018032318323268981.jpg","id":"7468","title":"玄笔录前传之异域魔道"}]
         */

        private String tag;
        private List<AllMovieBean.DataBean.DetailBean.MovieBean> movie;

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

        public List<AllMovieBean.DataBean.DetailBean.MovieBean> getMovie() {
            return movie;
        }

        public void setMovie(List<AllMovieBean.DataBean.DetailBean.MovieBean> movie) {
            this.movie = movie;
        }


    }
}
