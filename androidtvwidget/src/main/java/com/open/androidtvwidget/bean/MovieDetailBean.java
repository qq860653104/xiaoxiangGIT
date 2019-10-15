package com.open.androidtvwidget.bean;

import android.graphics.Bitmap;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wh on 2018/3/12.
 */

public class MovieDetailBean {


    /**
     * code : 200
     * msg : 成功
     * data : {"info":{"0":"52713","id":"52713","1":"海上花","name":"海上花","2":"/attachment/vod/201803/07/2018030721400763082.jpg","pic":"/attachment/vod/201803/07/2018030721400763082.jpg","3":"","pic2":"","4":"18","cid":"18","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"杨凡","daoyan":"杨凡","11":"未知","zhuyan":"未知","12":"剧情片","type":"剧情片","13":"香港","diqu":"香港","14":"","yuyan":"","15":"1986","year":"1986","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"影片以倒叙的手法，描述10年前在澳门做茶楼歌女的张美龄（张艾嘉饰）与日本运动员中村（鹤见辰吾饰）相遇并相互爱慕。中村回国后，美龄继续唱歌，并与白兰（姚炜饰）一见如故，开始了一段微妙的关系。10年后，中村来找美龄，引起白兰愤恨。当美龄和中村在酒店见面时，中村被杀，美龄在审讯时一直沉默，到底谁是真凶？","text":"影片以倒叙的手法，描述10年前在澳门做茶楼歌女的张美龄（张艾嘉饰）与日本运动员中村（鹤见辰吾饰）相遇并相互爱慕。中村回国后，美龄继续唱歌，并与白兰（姚炜饰）一见如故，开始了一段微妙的关系。10年后，中村来找美龄，引起白兰愤恨。当美龄和中村在酒店见面时，中村被杀，美龄在审讯时一直沉默，到底谁是真凶？","24":"play.html","skin":"play.html","25":"ydisk###1$u00195rg1bf&type=qq","url":"ydisk###1$u00195rg1bf&type=qq","26":null,"down":null,"27":"1520421868","addtime":"1520421868","28":"","tags":""},"tuijian":[{"0":"45094","id":"45094","1":"笑春","name":"笑春","2":"http://r1.ykimg.com/050E0000520481C567583944440A01EF","pic":"http://r1.ykimg.com/050E0000520481C567583944440A01EF","3":"","pic2":"","4":"14","cid":"14","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"姚中文","daoyan":"姚中文","11":"吴瑕/梁爽/其其格/田玉魁","zhuyan":"吴瑕/梁爽/其其格/田玉魁","12":"国产剧","type":"国产剧","13":"大陆","diqu":"大陆","14":"","yuyan":"","15":"2009","year":"2009","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"东北某市郊渔村，经营饭店的王笑春本不想参与村长竞选，但是由于村民支持王笑春放弃经营多年的饭店，回来当上了村长。他的养母二婶知道金品三等人的家族势力，怕干不好得罪他们，引来不必要的麻烦，当村长的王笑春顶住了二婶的百般反对与金品三等人家族势力展开了一场集体与个人利益之争，他顶住各种压力，克服了重重困难，得到了全村人民的拥护和信任带领渔村一步一步向社会主义新农村迈进。","text":"东北某市郊渔村，经营饭店的王笑春本不想参与村长竞选，但是由于村民支持王笑春放弃经营多年的饭店，回来当上了村长。他的养母二婶知道金品三等人的家族势力，怕干不好得罪他们，引来不必要的麻烦，当村长的王笑春顶住了二婶的百般反对与金品三等人家族势力展开了一场集体与个人利益之争，他顶住各种压力，克服了重重困难，得到了全村人民的拥护和信任带领渔村一步一步向社会主义新农村迈进。","24":"play.html","skin":"play.html","25":"ydisk###第1集$http://www.iqiyi.com/v_19rrkjrr4s.html\n第2集$http://www.iqiyi.com/v_19rrkjrj8o.html\n第3集$http://www.iqiyi.com/v_19rrkjrs2o.html\n第4集$http://www.iqiyi.com/v_19rrkjrm9o.html\n第5集$http://www.iqiyi.com/v_19rrkjrqkg.html\n第6集$http://www.iqiyi.com/v_19rrkjri7g.html\n第7集$http://www.iqiyi.com/v_19rrkjrq84.html\n第8集$http://www.iqiyi.com/v_19rrkjrgqo.html\n第9集$http://www.iqiyi.com/v_19rrkjrkdw.html\n第10集$http://www.iqiyi.com/v_19rrkjrp2k.html\n第11集$http://www.iqiyi.com/v_19rrkjrsd4.html\n第12集$http://www.iqiyi.com/v_19rrkjrl0g.html\n第13集$http://www.iqiyi.com/v_19rrkjrlng.html\n第14集$http://www.iqiyi.com/v_19rrkjrhhs.html\n第15集$http://www.iqiyi.com/v_19rrkjrimg.html\n第16集$http://www.iqiyi.com/v_19rrkjrkjg.html\n第17集$http://www.iqiyi.com/v_19rrkjradc.html\n第18集$http://www.iqiyi.com/v_19rrkjrbsw.html","url":"ydisk###第1集$http://www.iqiyi.com/v_19rrkjrr4s.html\n第2集$http://www.iqiyi.com/v_19rrkjrj8o.html\n第3集$http://www.iqiyi.com/v_19rrkjrs2o.html\n第4集$http://www.iqiyi.com/v_19rrkjrm9o.html\n第5集$http://www.iqiyi.com/v_19rrkjrqkg.html\n第6集$http://www.iqiyi.com/v_19rrkjri7g.html\n第7集$http://www.iqiyi.com/v_19rrkjrq84.html\n第8集$http://www.iqiyi.com/v_19rrkjrgqo.html\n第9集$http://www.iqiyi.com/v_19rrkjrkdw.html\n第10集$http://www.iqiyi.com/v_19rrkjrp2k.html\n第11集$http://www.iqiyi.com/v_19rrkjrsd4.html\n第12集$http://www.iqiyi.com/v_19rrkjrl0g.html\n第13集$http://www.iqiyi.com/v_19rrkjrlng.html\n第14集$http://www.iqiyi.com/v_19rrkjrhhs.html\n第15集$http://www.iqiyi.com/v_19rrkjrimg.html\n第16集$http://www.iqiyi.com/v_19rrkjrkjg.html\n第17集$http://www.iqiyi.com/v_19rrkjradc.html\n第18集$http://www.iqiyi.com/v_19rrkjrbsw.html","26":null,"down":null,"27":"1520420232","addtime":"1520420232","28":"","tags":""},{"0":"54538","id":"54538","1":"神犬奇兵","name":"神犬奇兵","2":"/attachment/vod/201803/07/2018030721285619989.jpg","pic":"/attachment/vod/201803/07/2018030721285619989.jpg","3":"","pic2":"","4":"14","cid":"14","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"王小列","daoyan":"王小列","11":"杨烁/王洋/王煜/夏凡/张汇仓/赵达/张柏嘉/徐乐同/王路","zhuyan":"杨烁/王洋/王煜/夏凡/张汇仓/赵达/张柏嘉/徐乐同/王路","12":"国产剧","type":"国产剧","13":"大陆","diqu":"大陆","14":"","yuyan":"","15":"2014","year":"2014","16":"","info":"","17":"1","hits":"1","18":"1","yhits":"1","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"《神犬奇兵》精彩看点：电视剧《神犬奇兵》是江何工作室继《麻辣女兵》之后又一军旅力作（原名《小米加步枪》），根据著名编剧冯骥的长篇小说《特警犬王》改编。该剧由金牌制片人何静、吴玉江担纲总制片人，《麻辣女兵》制作班底保驾护航，实力小生杨烁领衔主演，携手青春偶像王煜、王洋、刘倩文、刘潺、王建福以及实力戏骨冯恩鹤、高发、刘金龙、夏凡等众多优秀演员共同倾情演绎。《神犬奇兵》剧情梗概：剧情聚焦军旅中的\u201c人犬情\u201d，围绕一群军旅战士和他们骁勇善战的军犬而展开，既有同类影视作品中血气方刚的烈性，也有柔情动人的细腻情感，更有令人忍俊不禁的喜感。 一次危险的边境伏击，将养猪班长郭油子和四只小野狗送进了塞外的军犬收养连。小野狗\u201c步枪\u201d、\u201c小米\u201d、\u201c沧海\u201d和\u201c滔滔\u201d在艰苦卓绝的环境中克服种种困难，出色地完成了各种任务，却因为有狼性血统而无法获得军犬资格，险些被送进动物园，幸好某军犬基地及时发出调令，拯救了四犬。在军犬基地接受正规训练后，\u201c步枪\u201d等犬终于成为优秀军犬，在各类危险任务中屡建功勋，最终代表中国军犬参加世界军犬锦标赛，过关斩将加冕\u201c犬王\u201d。在一次任务中，\u201c步枪\u201d为救战友堕入悬崖，一年后，训导员们带着新繁育出的小犬们在\u201c步枪\u201d的坠崖处宣誓\u2014\u2014永远守护祖国的疆土。","text":"《神犬奇兵》精彩看点：电视剧《神犬奇兵》是江何工作室继《麻辣女兵》之后又一军旅力作（原名《小米加步枪》），根据著名编剧冯骥的长篇小说《特警犬王》改编。该剧由金牌制片人何静、吴玉江担纲总制片人，《麻辣女兵》制作班底保驾护航，实力小生杨烁领衔主演，携手青春偶像王煜、王洋、刘倩文、刘潺、王建福以及实力戏骨冯恩鹤、高发、刘金龙、夏凡等众多优秀演员共同倾情演绎。《神犬奇兵》剧情梗概：剧情聚焦军旅中的\u201c人犬情\u201d，围绕一群军旅战士和他们骁勇善战的军犬而展开，既有同类影视作品中血气方刚的烈性，也有柔情动人的细腻情感，更有令人忍俊不禁的喜感。 一次危险的边境伏击，将养猪班长郭油子和四只小野狗送进了塞外的军犬收养连。小野狗\u201c步枪\u201d、\u201c小米\u201d、\u201c沧海\u201d和\u201c滔滔\u201d在艰苦卓绝的环境中克服种种困难，出色地完成了各种任务，却因为有狼性血统而无法获得军犬资格，险些被送进动物园，幸好某军犬基地及时发出调令，拯救了四犬。在军犬基地接受正规训练后，\u201c步枪\u201d等犬终于成为优秀军犬，在各类危险任务中屡建功勋，最终代表中国军犬参加世界军犬锦标赛，过关斩将加冕\u201c犬王\u201d。在一次任务中，\u201c步枪\u201d为救战友堕入悬崖，一年后，训导员们带着新繁育出的小犬们在\u201c步枪\u201d的坠崖处宣誓\u2014\u2014永远守护祖国的疆土。","24":"play.html","skin":"play.html","25":"ydisk###1$y0014m1yd6l&type=qq\n2$b0014zko0xm&type=qq\n3$n0014zo76la&type=qq\n4$m0014mowvvc&type=qq\n5$v0014y7gego&type=qq\n6$h0014b7d5bp&type=qq\n7$c0014rkudzv&type=qq\n8$e00145ew61s&type=qq\n9$f00142l4akt&type=qq\n10$r0014hfzqde&type=qq\n11$o0014k742vn&type=qq\n12$k001416yzab&type=qq\n13$j0014a49zw4&type=qq\n14$b0014wybynt&type=qq\n15$y00149izy1u&type=qq\n16$f0014t61n1k&type=qq\n17$x0014rupw49&type=qq\n18$e0014tsb30t&type=qq\n19$y0014akex9k&type=qq\n20$r0014suwozz&type=qq\n21$l0014ch2jsl&type=qq\n22$x0014e6b699&type=qq\n23$f00141g2m68&type=qq\n24$v0014rumv86&type=qq\n25$k00145bvyrm&type=qq\n26$y0014xr7an9&type=qq\n27$t0014on3ch5&type=qq\n28$e00140nulgs&type=qq\n29$d0014jwutk1&type=qq\n30$d0014d7z3xv&type=qq\n31$m0014vizkom&type=qq\n32$w0014o0mue5&type=qq\n33$t00142kloh5&type=qq\n34$y001438cds4&type=qq\n35$o0014zvf3l9&type=qq\n36$s0014walu9z&type=qq\n37$p0014ifsf4h&type=qq","url":"ydisk###1$y0014m1yd6l&type=qq\n2$b0014zko0xm&type=qq\n3$n0014zo76la&type=qq\n4$m0014mowvvc&type=qq\n5$v0014y7gego&type=qq\n6$h0014b7d5bp&type=qq\n7$c0014rkudzv&type=qq\n8$e00145ew61s&type=qq\n9$f00142l4akt&type=qq\n10$r0014hfzqde&type=qq\n11$o0014k742vn&type=qq\n12$k001416yzab&type=qq\n13$j0014a49zw4&type=qq\n14$b0014wybynt&type=qq\n15$y00149izy1u&type=qq\n16$f0014t61n1k&type=qq\n17$x0014rupw49&type=qq\n18$e0014tsb30t&type=qq\n19$y0014akex9k&type=qq\n20$r0014suwozz&type=qq\n21$l0014ch2jsl&type=qq\n22$x0014e6b699&type=qq\n23$f00141g2m68&type=qq\n24$v0014rumv86&type=qq\n25$k00145bvyrm&type=qq\n26$y0014xr7an9&type=qq\n27$t0014on3ch5&type=qq\n28$e00140nulgs&type=qq\n29$d0014jwutk1&type=qq\n30$d0014d7z3xv&type=qq\n31$m0014vizkom&type=qq\n32$w0014o0mue5&type=qq\n33$t00142kloh5&type=qq\n34$y001438cds4&type=qq\n35$o0014zvf3l9&type=qq\n36$s0014walu9z&type=qq\n37$p0014ifsf4h&type=qq","26":null,"down":null,"27":"1520422190","addtime":"1520422190","28":"","tags":""},{"0":"52393","id":"52393","1":"黄蜂尾后针","name":"黄蜂尾后针","2":"/attachment/vod/201803/07/2018030721414072410.jpg","pic":"/attachment/vod/201803/07/2018030721414072410.jpg","3":"","pic2":"","4":"19","cid":"19","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"郑丹瑞","daoyan":"郑丹瑞","11":"郑裕玲/刘松仁/叶德娴","zhuyan":"郑裕玲/刘松仁/叶德娴","12":"警匪片","type":"警匪片","13":"香港","diqu":"香港","14":"","yuyan":"","15":"0","year":"0","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"金融界商人邱世龙（刘松仁）阴险奸诈，表面上进行正当交易，实则专替黑帮洗黑钱；其妻刘艳娥（郑裕玲）乃执业律师，为求赚钱，不择手段，甚至参与黑钱之事，而二人之关系实单靠金钱来衡量。某日，娥无意中发现龙隐瞒了一千万美无，一怒之下，把巨款收起，准备跟他摊牌。然而，龙在慌乱之中竟误以为杀死妻子，其后得悉娥变成植物人，龙才松一口气。曾受娥陷害的女护士马美珍（叶德娴）碰巧转职至此，珍趁机报复，误打误撞下竟把娥弄醒。龙为了探取娥收藏款项的地点，决定尽情照顾，惟娥记忆尽失，且性情怪异。一天，娥不知不觉地返回旧日律师行，发觉自己过往所做的种种坏事，后悔不已；再加上被同事调戏，龙逼她食增强记忆的药，且受珍的咒骂，终于忍受不了自杀。幸得珍加以安慰，两人遂成好友。未几，娥突然恢复记忆，并拿出巨款准备交还泰国帮，然后与龙远走高飞，从新生活。就在这时，娥闻得珍的死讯，伤心欲绝，反而指证龙的罪行，并且\u2026\u2026。","text":"金融界商人邱世龙（刘松仁）阴险奸诈，表面上进行正当交易，实则专替黑帮洗黑钱；其妻刘艳娥（郑裕玲）乃执业律师，为求赚钱，不择手段，甚至参与黑钱之事，而二人之关系实单靠金钱来衡量。某日，娥无意中发现龙隐瞒了一千万美无，一怒之下，把巨款收起，准备跟他摊牌。然而，龙在慌乱之中竟误以为杀死妻子，其后得悉娥变成植物人，龙才松一口气。曾受娥陷害的女护士马美珍（叶德娴）碰巧转职至此，珍趁机报复，误打误撞下竟把娥弄醒。龙为了探取娥收藏款项的地点，决定尽情照顾，惟娥记忆尽失，且性情怪异。一天，娥不知不觉地返回旧日律师行，发觉自己过往所做的种种坏事，后悔不已；再加上被同事调戏，龙逼她食增强记忆的药，且受珍的咒骂，终于忍受不了自杀。幸得珍加以安慰，两人遂成好友。未几，娥突然恢复记忆，并拿出巨款准备交还泰国帮，然后与龙远走高飞，从新生活。就在这时，娥闻得珍的死讯，伤心欲绝，反而指证龙的罪行，并且\u2026\u2026。","24":"play.html","skin":"play.html","25":"ydisk###1$8Mf0NTTopVM&type=qq","url":"ydisk###1$8Mf0NTTopVM&type=qq","26":null,"down":null,"27":"1520421813","addtime":"1520421813","28":"","tags":""},{"0":"45284","id":"45284","1":"29+1","name":"29+1","2":"http://r1.ykimg.com/051600005959FC9AADBC09B6B703062A","pic":"http://r1.ykimg.com/051600005959FC9AADBC09B6B703062A","3":"","pic2":"","4":"8","cid":"8","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"彭秀慧","daoyan":"彭秀慧","11":"周秀娜/郑欣宜/蔡瀚亿","zhuyan":"周秀娜/郑欣宜/蔡瀚亿","12":"爱情片","type":"爱情片","13":"香港","diqu":"香港","14":"","yuyan":"","15":"2017","year":"2017","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"简介：电影改编自彭秀慧执导的香港大热同名舞台剧，主要讲述即将进入三十岁的两位女性，在面对大部分同龄女性都会面对的困扰时，选择了截然不同的人生态度。一个是即将踏入三十岁的林若君，面对压力升级的工作挑战、双亲病重、仿如鸡肋的爱情关系，突然来袭的这些不安，令她感到前所未有的恐惧。另一个同样是即将迎来三十岁的黄天乐，却永远乐天知命，不为生活所困扰，身患癌症却坚持环游世界，寻找爱情，甚至从未因为微胖身型错过美食。她们互不认识，性格各异，因缘际会林若君搬进了黄天乐的家，没想到二人竟是同年同月同日出生，林若君通过黄天乐的日记阅读着对方的人生点滴，两个女子在空气中互相融合，观照，影响，到底是谁闯进了谁的世界？","text":"简介：电影改编自彭秀慧执导的香港大热同名舞台剧，主要讲述即将进入三十岁的两位女性，在面对大部分同龄女性都会面对的困扰时，选择了截然不同的人生态度。一个是即将踏入三十岁的林若君，面对压力升级的工作挑战、双亲病重、仿如鸡肋的爱情关系，突然来袭的这些不安，令她感到前所未有的恐惧。另一个同样是即将迎来三十岁的黄天乐，却永远乐天知命，不为生活所困扰，身患癌症却坚持环游世界，寻找爱情，甚至从未因为微胖身型错过美食。她们互不认识，性格各异，因缘际会林若君搬进了黄天乐的家，没想到二人竟是同年同月同日出生，林若君通过黄天乐的日记阅读着对方的人生点滴，两个女子在空气中互相融合，观照，影响，到底是谁闯进了谁的世界？","24":"play.html","skin":"play.html","25":"ydisk###高清$https://v.qq.com/x/cover/cld0v6tqfiiox40.html","url":"ydisk###高清$https://v.qq.com/x/cover/cld0v6tqfiiox40.html","26":null,"down":null,"27":"1520420370","addtime":"1520420370","28":"","tags":""},{"0":"54100","id":"54100","1":"道北人","name":"道北人","2":"/attachment/vod/201803/07/2018030721331279448.jpg","pic":"/attachment/vod/201803/07/2018030721331279448.jpg","3":"","pic2":"","4":"14","cid":"14","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"张汉杰/刘惠宁/孙毅安/马建安","daoyan":"张汉杰/刘惠宁/孙毅安/马建安","11":"胡亚捷/李琳/张嘉译/徐成林/常江/高远/王双宝/刘远/何佳怡/扈耀之/李少飞","zhuyan":"胡亚捷/李琳/张嘉译/徐成林/常江/高远/王双宝/刘远/何佳怡/扈耀之/李少飞","12":"国产剧","type":"国产剧","13":"大陆","diqu":"大陆","14":"","yuyan":"","15":"1995","year":"1995","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"1995年31集电视剧《道北人》通过道北三代人、四个家庭二十年的动荡变迁，着重表现了中国相当数量的城市平民的生活际遇、情感纠葛、命运浮沉和心路历程。","text":"1995年31集电视剧《道北人》通过道北三代人、四个家庭二十年的动荡变迁，着重表现了中国相当数量的城市平民的生活际遇、情感纠葛、命运浮沉和心路历程。","24":"play.html","skin":"play.html","25":"ydisk###1$h0017ggeb9t&type=qq\n2$o0017e51ely&type=qq\n3$j0017iftko7&type=qq\n4$r0017g8ckrt&type=qq\n5$h0017p8ux1c&type=qq\n6$k0017gcghw3&type=qq\n7$d0017e4q0rk&type=qq\n8$b00179e9adv&type=qq\n9$m0017l2d7ch&type=qq\n10$p0017zznc23&type=qq\n11$v0017zqcuin&type=qq\n12$j0017jdqrqf&type=qq\n13$l0017yi0f9c&type=qq\n14$u0017v2agul&type=qq\n15$t0017ehoqz6&type=qq\n16$j0017u6epjl&type=qq\n17$m0017ewlvyn&type=qq\n18$w0017rxt0m2&type=qq\n19$p001728tlr7&type=qq\n20$z00179vf1wo&type=qq\n21$v0017pisb9k&type=qq\n22$d0017ibtjy7&type=qq\n23$b00174k1jek&type=qq\n24$y0017n5dp5j&type=qq\n25$r0017f1arbk&type=qq\n26$v0017lukmr8&type=qq\n27$z0017dec117&type=qq\n28$n00176ooicd&type=qq\n29$t0017mlsj2k&type=qq\n30$z0017hsy3la&type=qq\n31$y0017swuc58&type=qq","url":"ydisk###1$h0017ggeb9t&type=qq\n2$o0017e51ely&type=qq\n3$j0017iftko7&type=qq\n4$r0017g8ckrt&type=qq\n5$h0017p8ux1c&type=qq\n6$k0017gcghw3&type=qq\n7$d0017e4q0rk&type=qq\n8$b00179e9adv&type=qq\n9$m0017l2d7ch&type=qq\n10$p0017zznc23&type=qq\n11$v0017zqcuin&type=qq\n12$j0017jdqrqf&type=qq\n13$l0017yi0f9c&type=qq\n14$u0017v2agul&type=qq\n15$t0017ehoqz6&type=qq\n16$j0017u6epjl&type=qq\n17$m0017ewlvyn&type=qq\n18$w0017rxt0m2&type=qq\n19$p001728tlr7&type=qq\n20$z00179vf1wo&type=qq\n21$v0017pisb9k&type=qq\n22$d0017ibtjy7&type=qq\n23$b00174k1jek&type=qq\n24$y0017n5dp5j&type=qq\n25$r0017f1arbk&type=qq\n26$v0017lukmr8&type=qq\n27$z0017dec117&type=qq\n28$n00176ooicd&type=qq\n29$t0017mlsj2k&type=qq\n30$z0017hsy3la&type=qq\n31$y0017swuc58&type=qq","26":null,"down":null,"27":"1520422113","addtime":"1520422113","28":"","tags":""},{"0":"53061","id":"53061","1":"大乡里八面威风","name":"大乡里八面威风","2":"/attachment/vod/201803/07/2018030721382492046.jpg","pic":"/attachment/vod/201803/07/2018030721382492046.jpg","3":"","pic2":"","4":"6","cid":"6","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"杨权","daoyan":"杨权","11":"谭炳文/李香琴/郑少秋","zhuyan":"谭炳文/李香琴/郑少秋","12":"喜剧片","type":"喜剧片","13":"香港","diqu":"香港","14":"","yuyan":"","15":"1974","year":"1974","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"暂无简介","text":"暂无简介","24":"play.html","skin":"play.html","25":"ydisk###1$j00158d2w8x&type=qq","url":"ydisk###1$j00158d2w8x&type=qq","26":null,"down":null,"27":"1520421928","addtime":"1520421928","28":"","tags":""},{"0":"53418","id":"53418","1":"冲破黎明前的黑暗","name":"冲破黎明前的黑暗","2":"/attachment/vod/201803/07/2018030721364377509.jpg","pic":"/attachment/vod/201803/07/2018030721364377509.jpg","3":"","pic2":"","4":"18","cid":"18","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"王苹/刘沛然","daoyan":"王苹/刘沛然","11":"今欣/高保成","zhuyan":"今欣/高保成","12":"剧情片","type":"剧情片","13":"大陆","diqu":"大陆","14":"","yuyan":"","15":"1956","year":"1956","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"1942年5月，敌酋岗村宁次组织数万日伪军对我冀中平原展开大扫荡。为掩护主力撤退，阎志刚（今欣 饰）带人留下坚持斗争。遭敌夹击后分散突围，阎在战斗中受伤，被抗属李大娘（陈立中 饰）和儿媳凤霞（李雪红 饰）救回家中养伤。敌联队长（严寄洲 饰）得知村里藏着八路，叫嚣要活捉阎志刚。养好伤后阎志刚滋生大意，在一次执行任务时被特务跟踪，给我方造成损失，阎自责不已。冀中人民发明的地道战，让狂妄的敌人吃尽了苦头。一次，敌人集结兵力到刘家营村抢粮，配合县大队的战斗任务交给了阎志刚，他和区小队、县大队分三面包围了抢粮的敌人，并将计就计消灭了敌人的据点......","text":"1942年5月，敌酋岗村宁次组织数万日伪军对我冀中平原展开大扫荡。为掩护主力撤退，阎志刚（今欣 饰）带人留下坚持斗争。遭敌夹击后分散突围，阎在战斗中受伤，被抗属李大娘（陈立中 饰）和儿媳凤霞（李雪红 饰）救回家中养伤。敌联队长（严寄洲 饰）得知村里藏着八路，叫嚣要活捉阎志刚。养好伤后阎志刚滋生大意，在一次执行任务时被特务跟踪，给我方造成损失，阎自责不已。冀中人民发明的地道战，让狂妄的敌人吃尽了苦头。一次，敌人集结兵力到刘家营村抢粮，配合县大队的战斗任务交给了阎志刚，他和区小队、县大队分三面包围了抢粮的敌人，并将计就计消灭了敌人的据点......","24":"play.html","skin":"play.html","25":"ydisk###1$g0015s91ef3&type=qq","url":"ydisk###1$g0015s91ef3&type=qq","26":null,"down":null,"27":"1520421993","addtime":"1520421993","28":"","tags":""},{"0":"43845","id":"43845","1":"青春荷尔蒙2躁动时代","name":"青春荷尔蒙2躁动时代","2":"http://pic5.qiyipic.com/image/20150317/3a/7d/08/v_105337720_m_601_m5_195_260.jpg","pic":"http://pic5.qiyipic.com/image/20150317/3a/7d/08/v_105337720_m_601_m5_195_260.jpg","3":"","pic2":"","4":"8","cid":"8","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"姚庆涛","daoyan":"姚庆涛","11":"莫熙儿/高宇/李水诺/罗京/闫鹏涛","zhuyan":"莫熙儿/高宇/李水诺/罗京/闫鹏涛","12":"爱情片","type":"爱情片","13":"华语","diqu":"华语","14":"","yuyan":"","15":"2015","year":"2015","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"　　莫菲和男友雷宇在学校时成立了自己的乐队\u2014\u2014HOPE乐队，毕业后，乐队被签约到著名的东方唱片公司。本以为未来充满希望的几个年轻人，却在成长的过程有了更多的误会隔阂。莫菲和男友的感情濒临破裂，和队友们产生了分歧。经历了社会的残酷之后，年轻时的梦想和憧憬被现实打破，莫菲也不知不觉走上一条不归路。青春最残忍的不是治愈，而是带着越来越多的伤痛继续前行","text":"　　莫菲和男友雷宇在学校时成立了自己的乐队\u2014\u2014HOPE乐队，毕业后，乐队被签约到著名的东方唱片公司。本以为未来充满希望的几个年轻人，却在成长的过程有了更多的误会隔阂。莫菲和男友的感情濒临破裂，和队友们产生了分歧。经历了社会的残酷之后，年轻时的梦想和憧憬被现实打破，莫菲也不知不觉走上一条不归路。青春最残忍的不是治愈，而是带着越来越多的伤痛继续前行","24":"play.html","skin":"play.html","25":"ydisk###正片$http://www.iqiyi.com/v_19rrh4gf2g.html","url":"ydisk###正片$http://www.iqiyi.com/v_19rrh4gf2g.html","26":null,"down":null,"27":"1520420021","addtime":"1520420021","28":"","tags":""},{"0":"43970","id":"43970","1":"国宝","name":"国宝","2":"http://r1.ykimg.com/050E0000522FFEA76758393E8D0223A1","pic":"http://r1.ykimg.com/050E0000522FFEA76758393E8D0223A1","3":"","pic2":"","4":"14","cid":"14","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"张绍林","daoyan":"张绍林","11":"刘文治/赵文瑄/陈刚/宋运成","zhuyan":"刘文治/赵文瑄/陈刚/宋运成","12":"国产剧","type":"国产剧","13":"大陆","diqu":"大陆","14":"","yuyan":"","15":"2004","year":"2004","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"1931年，日军入侵山海关，华北形势告急，故宫博物院决定将馆藏精品转移，以避战火浩劫。文物由北京经上海、南京辗转运抵位于大后方的四川和贵州，最后保存在乐山、峨嵋、安顺等偏远地区。至抗战结束后，陆续运回南京，之后部分被运送到台湾，部分回归北平本院，部分留在南京。　　文物南迁工作历时十五年，近二万箱、近百万件文物，行程数万公里，曾经在徐州、郑州遭到日军飞机的轰炸、在峨嵋经受了大火的考验，但都能化险为夷，文物没有丢失损毁，这是中国文物保护史乃至文化史上的奇迹，也是中华文明史上的奇迹。南迁之路是一条充满艰险的道路，无数的人力物力，无比崇高的责任心，无与伦比的勇气，铺平了这条道路，其中的艰辛困苦和危急是难以想象的\u2026\u2026","text":"1931年，日军入侵山海关，华北形势告急，故宫博物院决定将馆藏精品转移，以避战火浩劫。文物由北京经上海、南京辗转运抵位于大后方的四川和贵州，最后保存在乐山、峨嵋、安顺等偏远地区。至抗战结束后，陆续运回南京，之后部分被运送到台湾，部分回归北平本院，部分留在南京。　　文物南迁工作历时十五年，近二万箱、近百万件文物，行程数万公里，曾经在徐州、郑州遭到日军飞机的轰炸、在峨嵋经受了大火的考验，但都能化险为夷，文物没有丢失损毁，这是中国文物保护史乃至文化史上的奇迹，也是中华文明史上的奇迹。南迁之路是一条充满艰险的道路，无数的人力物力，无比崇高的责任心，无与伦比的勇气，铺平了这条道路，其中的艰辛困苦和危急是难以想象的\u2026\u2026","24":"play.html","skin":"play.html","25":"ydisk###1$c0018ugz31d&type=qq\n2$p0019ydfcg3&type=qq\n3$b0019hxo2z8&type=qq\n4$m0019qp89u2&type=qq\n5$j0018vgakm7&type=qq\n6$a00190224s3&type=qq\n7$a00199m7pol&type=qq\n8$s0019xbk6dy&type=qq\n9$a00186r3o09&type=qq\n10$q00194odyb2&type=qq\n11$r0018tvr2m2&type=qq\n12$l0018qcictb&type=qq\n13$i0019i3pofp&type=qq\n14$p0019nzj6s8&type=qq\n15$k0019pheonw&type=qq\n16$m0019j8nh1y&type=qq\n17$s001963wadl&type=qq\n18$q0019680nfa&type=qq\n19$m00192ndj37&type=qq\n20$f0019zbf3gf&type=qq","url":"ydisk###1$c0018ugz31d&type=qq\n2$p0019ydfcg3&type=qq\n3$b0019hxo2z8&type=qq\n4$m0019qp89u2&type=qq\n5$j0018vgakm7&type=qq\n6$a00190224s3&type=qq\n7$a00199m7pol&type=qq\n8$s0019xbk6dy&type=qq\n9$a00186r3o09&type=qq\n10$q00194odyb2&type=qq\n11$r0018tvr2m2&type=qq\n12$l0018qcictb&type=qq\n13$i0019i3pofp&type=qq\n14$p0019nzj6s8&type=qq\n15$k0019pheonw&type=qq\n16$m0019j8nh1y&type=qq\n17$s001963wadl&type=qq\n18$q0019680nfa&type=qq\n19$m00192ndj37&type=qq\n20$f0019zbf3gf&type=qq","26":null,"down":null,"27":"1520421025","addtime":"1520421025","28":"","tags":""},{"0":"41100","id":"41100","1":"Hand Shakers","name":"Hand Shakers","2":"http://photocdn.sohu.com/kis/fengmian/1209/1209636/1209636_ver_big_20170106100506.jpg","pic":"http://photocdn.sohu.com/kis/fengmian/1209/1209636/1209636_ver_big_20170106100506.jpg","3":"","pic2":"","4":"16","cid":"16","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"","daoyan":"","11":"未知","zhuyan":"未知","12":"动漫片","type":"动漫片","13":"其它","diqu":"其它","14":"","yuyan":"","15":"2017","year":"2017","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"Hand Shakers指的是通过紧握双手从内心深处诞生出武器，并使用这种被称为\u201c尼姆罗德\u201d的武器互相战斗的人，为了实现自己的愿望大多数的Hand Shakers都是以打倒神为目标来互相战斗。","text":"Hand Shakers指的是通过紧握双手从内心深处诞生出武器，并使用这种被称为\u201c尼姆罗德\u201d的武器互相战斗的人，为了实现自己的愿望大多数的Hand Shakers都是以打倒神为目标来互相战斗。","24":"play.html","skin":"play.html","25":"ydisk###第1集$http://www.iqiyi.com/v_19rr9wkxdk.html\n第2集$http://www.iqiyi.com/v_19rranzwus.html\n第3集$http://www.iqiyi.com/v_19rralozdo.html\n第4集$http://www.iqiyi.com/v_19rrakdg90.html\n第5集$http://www.iqiyi.com/v_19rrasd5hg.html\n第6集$http://www.iqiyi.com/v_19rraqurqs.html\n第7集$http://www.iqiyi.com/v_19rrae6zt0.html\n第8集$http://www.iqiyi.com/v_19rrabpi9w.html\n第9集$http://www.iqiyi.com/v_19rraj54ns.html\n第10集$http://www.iqiyi.com/v_19rragojcw.html","url":"ydisk###第1集$http://www.iqiyi.com/v_19rr9wkxdk.html\n第2集$http://www.iqiyi.com/v_19rranzwus.html\n第3集$http://www.iqiyi.com/v_19rralozdo.html\n第4集$http://www.iqiyi.com/v_19rrakdg90.html\n第5集$http://www.iqiyi.com/v_19rrasd5hg.html\n第6集$http://www.iqiyi.com/v_19rraqurqs.html\n第7集$http://www.iqiyi.com/v_19rrae6zt0.html\n第8集$http://www.iqiyi.com/v_19rrabpi9w.html\n第9集$http://www.iqiyi.com/v_19rraj54ns.html\n第10集$http://www.iqiyi.com/v_19rragojcw.html","26":null,"down":null,"27":"1520419621","addtime":"1520419621","28":"","tags":""},{"0":"54667","id":"54667","1":"这该死的爱","name":"这该死的爱","2":"/attachment/vod/201803/07/2018030721280933051.jpg","pic":"/attachment/vod/201803/07/2018030721280933051.jpg","3":"","pic2":"","4":"15","cid":"15","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"金魁太","daoyan":"金魁太","11":"申敏儿/郑智薰/李基宇/金莎朗/金英在/李顺载","zhuyan":"申敏儿/郑智薰/李基宇/金莎朗/金英在/李顺载","12":"韩国剧","type":"韩国剧","13":"韩国","diqu":"韩国","14":"","yuyan":"","15":"2005","year":"2005","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"剧中的江复久是一位k-1（将武术、空手道、跆拳道和自由搏击结合在一起的运动）运动员，他爱上不该爱的人\u2014\u2014哥哥的前恋人、当模特儿的女主角，但却不畏艰难险阻，勇往直前。 　　申敏雅饰演的车恩锡是在韩国最具人气的女演员。她的外表充满神秘魅力，不过内却活泼开朗，她偶然邂逅性格强悍又温柔的格斗拳手rain，两人发展出一段想爱又不能爱的苦恋。虽然她是一位身兼名气和大众人气的神奇人物，但她还是一个平凡和富有人情味儿的20多岁女性。她偶尔成为rain的目标，陷入无法自拔的感情纠葛，并为了这段根本没有结果的感情而伤心。","text":"剧中的江复久是一位k-1（将武术、空手道、跆拳道和自由搏击结合在一起的运动）运动员，他爱上不该爱的人\u2014\u2014哥哥的前恋人、当模特儿的女主角，但却不畏艰难险阻，勇往直前。 　　申敏雅饰演的车恩锡是在韩国最具人气的女演员。她的外表充满神秘魅力，不过内却活泼开朗，她偶然邂逅性格强悍又温柔的格斗拳手rain，两人发展出一段想爱又不能爱的苦恋。虽然她是一位身兼名气和大众人气的神奇人物，但她还是一个平凡和富有人情味儿的20多岁女性。她偶尔成为rain的目标，陷入无法自拔的感情纠葛，并为了这段根本没有结果的感情而伤心。","24":"play.html","skin":"play.html","25":"ydisk###1$a0014j0oo3h&type=qq\n2$q0014b65k19&type=qq\n3$d00140ajzg0&type=qq\n4$z0014t112p3&type=qq\n5$k00148qhaze&type=qq\n6$m0014jxdhtn&type=qq\n7$v00142a4rqj&type=qq\n8$c0014s7kcvf&type=qq\n9$j0014qxifw5&type=qq\n10$x0014nkmm8c&type=qq\n11$o0014p372hi&type=qq\n12$c0014655adg&type=qq\n13$j0014eh9gas&type=qq\n14$m0014a3i5fd&type=qq\n15$f0014vwrlk2&type=qq\n16$e0014x8fepn&type=qq","url":"ydisk###1$a0014j0oo3h&type=qq\n2$q0014b65k19&type=qq\n3$d00140ajzg0&type=qq\n4$z0014t112p3&type=qq\n5$k00148qhaze&type=qq\n6$m0014jxdhtn&type=qq\n7$v00142a4rqj&type=qq\n8$c0014s7kcvf&type=qq\n9$j0014qxifw5&type=qq\n10$x0014nkmm8c&type=qq\n11$o0014p372hi&type=qq\n12$c0014655adg&type=qq\n13$j0014eh9gas&type=qq\n14$m0014a3i5fd&type=qq\n15$f0014vwrlk2&type=qq\n16$e0014x8fepn&type=qq","26":null,"down":null,"27":"1520422211","addtime":"1520422211","28":"","tags":""},{"0":"48399","id":"48399","1":"瘦身男女","name":"瘦身男女","2":"http://r3.ykimg.com/050E000052B10352675839603E051787","pic":"http://r3.ykimg.com/050E000052B10352675839603E051787","3":"","pic2":"","4":"6","cid":"6","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"杜琪峰/韦家辉","daoyan":"杜琪峰/韦家辉","11":"未知","zhuyan":"未知","12":"喜剧片","type":"喜剧片","13":"香港","diqu":"香港","14":"","yuyan":"","15":"2001","year":"2001","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"Mini（郑秀文饰）是旅居日本的香港人，本是一位窈窕淑女，却在遭受失恋的刺激后变成一个体重260磅的大肥婆。就在自卑感非常强烈的时候，却有缘认识了同病相怜的肥佬（刘德华饰）。在交流中Mini告诉肥佬她和初恋情人黑川（黑川力矢饰）有一个十年之约，而在如今只剩下45天的时候，她却变成了一个大肥婆。好心的肥佬帮助Mini恢复原来的体形，成全有情人，于是与Mini一起取采地狱式方法来减肥。终于功夫不负有心人，在这四十多天时间里，肥佬和Mini都减肥成功。十年之约来临的那天，黑川向Mini求婚，但当黑川得知她曾经变成肥婆的真相时，事情则变得复杂起来\u2026\u2026","text":"Mini（郑秀文饰）是旅居日本的香港人，本是一位窈窕淑女，却在遭受失恋的刺激后变成一个体重260磅的大肥婆。就在自卑感非常强烈的时候，却有缘认识了同病相怜的肥佬（刘德华饰）。在交流中Mini告诉肥佬她和初恋情人黑川（黑川力矢饰）有一个十年之约，而在如今只剩下45天的时候，她却变成了一个大肥婆。好心的肥佬帮助Mini恢复原来的体形，成全有情人，于是与Mini一起取采地狱式方法来减肥。终于功夫不负有心人，在这四十多天时间里，肥佬和Mini都减肥成功。十年之约来临的那天，黑川向Mini求婚，但当黑川得知她曾经变成肥婆的真相时，事情则变得复杂起来\u2026\u2026","24":"play.html","skin":"play.html","25":"ydisk###1$n0019evme0t&type=qq","url":"ydisk###1$n0019evme0t&type=qq","26":null,"down":null,"27":"1520421030","addtime":"1520421030","28":"","tags":""}]}
     */

    private String code;
    private String msg;
    private DataBean data;

    public static MovieDetailBean objectFromData(String str) {

        return new Gson().fromJson(str, MovieDetailBean.class);
    }

    public static MovieDetailBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), MovieDetailBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<MovieDetailBean> arrayMovieDetailBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<MovieDetailBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<MovieDetailBean> arrayMovieDetailBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<MovieDetailBean>>() {
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * info : {"0":"52713","id":"52713","1":"海上花","name":"海上花","2":"/attachment/vod/201803/07/2018030721400763082.jpg","pic":"/attachment/vod/201803/07/2018030721400763082.jpg","3":"","pic2":"","4":"18","cid":"18","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"杨凡","daoyan":"杨凡","11":"未知","zhuyan":"未知","12":"剧情片","type":"剧情片","13":"香港","diqu":"香港","14":"","yuyan":"","15":"1986","year":"1986","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"影片以倒叙的手法，描述10年前在澳门做茶楼歌女的张美龄（张艾嘉饰）与日本运动员中村（鹤见辰吾饰）相遇并相互爱慕。中村回国后，美龄继续唱歌，并与白兰（姚炜饰）一见如故，开始了一段微妙的关系。10年后，中村来找美龄，引起白兰愤恨。当美龄和中村在酒店见面时，中村被杀，美龄在审讯时一直沉默，到底谁是真凶？","text":"影片以倒叙的手法，描述10年前在澳门做茶楼歌女的张美龄（张艾嘉饰）与日本运动员中村（鹤见辰吾饰）相遇并相互爱慕。中村回国后，美龄继续唱歌，并与白兰（姚炜饰）一见如故，开始了一段微妙的关系。10年后，中村来找美龄，引起白兰愤恨。当美龄和中村在酒店见面时，中村被杀，美龄在审讯时一直沉默，到底谁是真凶？","24":"play.html","skin":"play.html","25":"ydisk###1$u00195rg1bf&type=qq","url":"ydisk###1$u00195rg1bf&type=qq","26":null,"down":null,"27":"1520421868","addtime":"1520421868","28":"","tags":""}
         * tuijian : [{"0":"45094","id":"45094","1":"笑春","name":"笑春","2":"http://r1.ykimg.com/050E0000520481C567583944440A01EF","pic":"http://r1.ykimg.com/050E0000520481C567583944440A01EF","3":"","pic2":"","4":"14","cid":"14","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"姚中文","daoyan":"姚中文","11":"吴瑕/梁爽/其其格/田玉魁","zhuyan":"吴瑕/梁爽/其其格/田玉魁","12":"国产剧","type":"国产剧","13":"大陆","diqu":"大陆","14":"","yuyan":"","15":"2009","year":"2009","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"东北某市郊渔村，经营饭店的王笑春本不想参与村长竞选，但是由于村民支持王笑春放弃经营多年的饭店，回来当上了村长。他的养母二婶知道金品三等人的家族势力，怕干不好得罪他们，引来不必要的麻烦，当村长的王笑春顶住了二婶的百般反对与金品三等人家族势力展开了一场集体与个人利益之争，他顶住各种压力，克服了重重困难，得到了全村人民的拥护和信任带领渔村一步一步向社会主义新农村迈进。","text":"东北某市郊渔村，经营饭店的王笑春本不想参与村长竞选，但是由于村民支持王笑春放弃经营多年的饭店，回来当上了村长。他的养母二婶知道金品三等人的家族势力，怕干不好得罪他们，引来不必要的麻烦，当村长的王笑春顶住了二婶的百般反对与金品三等人家族势力展开了一场集体与个人利益之争，他顶住各种压力，克服了重重困难，得到了全村人民的拥护和信任带领渔村一步一步向社会主义新农村迈进。","24":"play.html","skin":"play.html","25":"ydisk###第1集$http://www.iqiyi.com/v_19rrkjrr4s.html\n第2集$http://www.iqiyi.com/v_19rrkjrj8o.html\n第3集$http://www.iqiyi.com/v_19rrkjrs2o.html\n第4集$http://www.iqiyi.com/v_19rrkjrm9o.html\n第5集$http://www.iqiyi.com/v_19rrkjrqkg.html\n第6集$http://www.iqiyi.com/v_19rrkjri7g.html\n第7集$http://www.iqiyi.com/v_19rrkjrq84.html\n第8集$http://www.iqiyi.com/v_19rrkjrgqo.html\n第9集$http://www.iqiyi.com/v_19rrkjrkdw.html\n第10集$http://www.iqiyi.com/v_19rrkjrp2k.html\n第11集$http://www.iqiyi.com/v_19rrkjrsd4.html\n第12集$http://www.iqiyi.com/v_19rrkjrl0g.html\n第13集$http://www.iqiyi.com/v_19rrkjrlng.html\n第14集$http://www.iqiyi.com/v_19rrkjrhhs.html\n第15集$http://www.iqiyi.com/v_19rrkjrimg.html\n第16集$http://www.iqiyi.com/v_19rrkjrkjg.html\n第17集$http://www.iqiyi.com/v_19rrkjradc.html\n第18集$http://www.iqiyi.com/v_19rrkjrbsw.html","url":"ydisk###第1集$http://www.iqiyi.com/v_19rrkjrr4s.html\n第2集$http://www.iqiyi.com/v_19rrkjrj8o.html\n第3集$http://www.iqiyi.com/v_19rrkjrs2o.html\n第4集$http://www.iqiyi.com/v_19rrkjrm9o.html\n第5集$http://www.iqiyi.com/v_19rrkjrqkg.html\n第6集$http://www.iqiyi.com/v_19rrkjri7g.html\n第7集$http://www.iqiyi.com/v_19rrkjrq84.html\n第8集$http://www.iqiyi.com/v_19rrkjrgqo.html\n第9集$http://www.iqiyi.com/v_19rrkjrkdw.html\n第10集$http://www.iqiyi.com/v_19rrkjrp2k.html\n第11集$http://www.iqiyi.com/v_19rrkjrsd4.html\n第12集$http://www.iqiyi.com/v_19rrkjrl0g.html\n第13集$http://www.iqiyi.com/v_19rrkjrlng.html\n第14集$http://www.iqiyi.com/v_19rrkjrhhs.html\n第15集$http://www.iqiyi.com/v_19rrkjrimg.html\n第16集$http://www.iqiyi.com/v_19rrkjrkjg.html\n第17集$http://www.iqiyi.com/v_19rrkjradc.html\n第18集$http://www.iqiyi.com/v_19rrkjrbsw.html","26":null,"down":null,"27":"1520420232","addtime":"1520420232","28":"","tags":""},{"0":"54538","id":"54538","1":"神犬奇兵","name":"神犬奇兵","2":"/attachment/vod/201803/07/2018030721285619989.jpg","pic":"/attachment/vod/201803/07/2018030721285619989.jpg","3":"","pic2":"","4":"14","cid":"14","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"王小列","daoyan":"王小列","11":"杨烁/王洋/王煜/夏凡/张汇仓/赵达/张柏嘉/徐乐同/王路","zhuyan":"杨烁/王洋/王煜/夏凡/张汇仓/赵达/张柏嘉/徐乐同/王路","12":"国产剧","type":"国产剧","13":"大陆","diqu":"大陆","14":"","yuyan":"","15":"2014","year":"2014","16":"","info":"","17":"1","hits":"1","18":"1","yhits":"1","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"《神犬奇兵》精彩看点：电视剧《神犬奇兵》是江何工作室继《麻辣女兵》之后又一军旅力作（原名《小米加步枪》），根据著名编剧冯骥的长篇小说《特警犬王》改编。该剧由金牌制片人何静、吴玉江担纲总制片人，《麻辣女兵》制作班底保驾护航，实力小生杨烁领衔主演，携手青春偶像王煜、王洋、刘倩文、刘潺、王建福以及实力戏骨冯恩鹤、高发、刘金龙、夏凡等众多优秀演员共同倾情演绎。《神犬奇兵》剧情梗概：剧情聚焦军旅中的\u201c人犬情\u201d，围绕一群军旅战士和他们骁勇善战的军犬而展开，既有同类影视作品中血气方刚的烈性，也有柔情动人的细腻情感，更有令人忍俊不禁的喜感。 一次危险的边境伏击，将养猪班长郭油子和四只小野狗送进了塞外的军犬收养连。小野狗\u201c步枪\u201d、\u201c小米\u201d、\u201c沧海\u201d和\u201c滔滔\u201d在艰苦卓绝的环境中克服种种困难，出色地完成了各种任务，却因为有狼性血统而无法获得军犬资格，险些被送进动物园，幸好某军犬基地及时发出调令，拯救了四犬。在军犬基地接受正规训练后，\u201c步枪\u201d等犬终于成为优秀军犬，在各类危险任务中屡建功勋，最终代表中国军犬参加世界军犬锦标赛，过关斩将加冕\u201c犬王\u201d。在一次任务中，\u201c步枪\u201d为救战友堕入悬崖，一年后，训导员们带着新繁育出的小犬们在\u201c步枪\u201d的坠崖处宣誓\u2014\u2014永远守护祖国的疆土。","text":"《神犬奇兵》精彩看点：电视剧《神犬奇兵》是江何工作室继《麻辣女兵》之后又一军旅力作（原名《小米加步枪》），根据著名编剧冯骥的长篇小说《特警犬王》改编。该剧由金牌制片人何静、吴玉江担纲总制片人，《麻辣女兵》制作班底保驾护航，实力小生杨烁领衔主演，携手青春偶像王煜、王洋、刘倩文、刘潺、王建福以及实力戏骨冯恩鹤、高发、刘金龙、夏凡等众多优秀演员共同倾情演绎。《神犬奇兵》剧情梗概：剧情聚焦军旅中的\u201c人犬情\u201d，围绕一群军旅战士和他们骁勇善战的军犬而展开，既有同类影视作品中血气方刚的烈性，也有柔情动人的细腻情感，更有令人忍俊不禁的喜感。 一次危险的边境伏击，将养猪班长郭油子和四只小野狗送进了塞外的军犬收养连。小野狗\u201c步枪\u201d、\u201c小米\u201d、\u201c沧海\u201d和\u201c滔滔\u201d在艰苦卓绝的环境中克服种种困难，出色地完成了各种任务，却因为有狼性血统而无法获得军犬资格，险些被送进动物园，幸好某军犬基地及时发出调令，拯救了四犬。在军犬基地接受正规训练后，\u201c步枪\u201d等犬终于成为优秀军犬，在各类危险任务中屡建功勋，最终代表中国军犬参加世界军犬锦标赛，过关斩将加冕\u201c犬王\u201d。在一次任务中，\u201c步枪\u201d为救战友堕入悬崖，一年后，训导员们带着新繁育出的小犬们在\u201c步枪\u201d的坠崖处宣誓\u2014\u2014永远守护祖国的疆土。","24":"play.html","skin":"play.html","25":"ydisk###1$y0014m1yd6l&type=qq\n2$b0014zko0xm&type=qq\n3$n0014zo76la&type=qq\n4$m0014mowvvc&type=qq\n5$v0014y7gego&type=qq\n6$h0014b7d5bp&type=qq\n7$c0014rkudzv&type=qq\n8$e00145ew61s&type=qq\n9$f00142l4akt&type=qq\n10$r0014hfzqde&type=qq\n11$o0014k742vn&type=qq\n12$k001416yzab&type=qq\n13$j0014a49zw4&type=qq\n14$b0014wybynt&type=qq\n15$y00149izy1u&type=qq\n16$f0014t61n1k&type=qq\n17$x0014rupw49&type=qq\n18$e0014tsb30t&type=qq\n19$y0014akex9k&type=qq\n20$r0014suwozz&type=qq\n21$l0014ch2jsl&type=qq\n22$x0014e6b699&type=qq\n23$f00141g2m68&type=qq\n24$v0014rumv86&type=qq\n25$k00145bvyrm&type=qq\n26$y0014xr7an9&type=qq\n27$t0014on3ch5&type=qq\n28$e00140nulgs&type=qq\n29$d0014jwutk1&type=qq\n30$d0014d7z3xv&type=qq\n31$m0014vizkom&type=qq\n32$w0014o0mue5&type=qq\n33$t00142kloh5&type=qq\n34$y001438cds4&type=qq\n35$o0014zvf3l9&type=qq\n36$s0014walu9z&type=qq\n37$p0014ifsf4h&type=qq","url":"ydisk###1$y0014m1yd6l&type=qq\n2$b0014zko0xm&type=qq\n3$n0014zo76la&type=qq\n4$m0014mowvvc&type=qq\n5$v0014y7gego&type=qq\n6$h0014b7d5bp&type=qq\n7$c0014rkudzv&type=qq\n8$e00145ew61s&type=qq\n9$f00142l4akt&type=qq\n10$r0014hfzqde&type=qq\n11$o0014k742vn&type=qq\n12$k001416yzab&type=qq\n13$j0014a49zw4&type=qq\n14$b0014wybynt&type=qq\n15$y00149izy1u&type=qq\n16$f0014t61n1k&type=qq\n17$x0014rupw49&type=qq\n18$e0014tsb30t&type=qq\n19$y0014akex9k&type=qq\n20$r0014suwozz&type=qq\n21$l0014ch2jsl&type=qq\n22$x0014e6b699&type=qq\n23$f00141g2m68&type=qq\n24$v0014rumv86&type=qq\n25$k00145bvyrm&type=qq\n26$y0014xr7an9&type=qq\n27$t0014on3ch5&type=qq\n28$e00140nulgs&type=qq\n29$d0014jwutk1&type=qq\n30$d0014d7z3xv&type=qq\n31$m0014vizkom&type=qq\n32$w0014o0mue5&type=qq\n33$t00142kloh5&type=qq\n34$y001438cds4&type=qq\n35$o0014zvf3l9&type=qq\n36$s0014walu9z&type=qq\n37$p0014ifsf4h&type=qq","26":null,"down":null,"27":"1520422190","addtime":"1520422190","28":"","tags":""},{"0":"52393","id":"52393","1":"黄蜂尾后针","name":"黄蜂尾后针","2":"/attachment/vod/201803/07/2018030721414072410.jpg","pic":"/attachment/vod/201803/07/2018030721414072410.jpg","3":"","pic2":"","4":"19","cid":"19","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"郑丹瑞","daoyan":"郑丹瑞","11":"郑裕玲/刘松仁/叶德娴","zhuyan":"郑裕玲/刘松仁/叶德娴","12":"警匪片","type":"警匪片","13":"香港","diqu":"香港","14":"","yuyan":"","15":"0","year":"0","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"金融界商人邱世龙（刘松仁）阴险奸诈，表面上进行正当交易，实则专替黑帮洗黑钱；其妻刘艳娥（郑裕玲）乃执业律师，为求赚钱，不择手段，甚至参与黑钱之事，而二人之关系实单靠金钱来衡量。某日，娥无意中发现龙隐瞒了一千万美无，一怒之下，把巨款收起，准备跟他摊牌。然而，龙在慌乱之中竟误以为杀死妻子，其后得悉娥变成植物人，龙才松一口气。曾受娥陷害的女护士马美珍（叶德娴）碰巧转职至此，珍趁机报复，误打误撞下竟把娥弄醒。龙为了探取娥收藏款项的地点，决定尽情照顾，惟娥记忆尽失，且性情怪异。一天，娥不知不觉地返回旧日律师行，发觉自己过往所做的种种坏事，后悔不已；再加上被同事调戏，龙逼她食增强记忆的药，且受珍的咒骂，终于忍受不了自杀。幸得珍加以安慰，两人遂成好友。未几，娥突然恢复记忆，并拿出巨款准备交还泰国帮，然后与龙远走高飞，从新生活。就在这时，娥闻得珍的死讯，伤心欲绝，反而指证龙的罪行，并且\u2026\u2026。","text":"金融界商人邱世龙（刘松仁）阴险奸诈，表面上进行正当交易，实则专替黑帮洗黑钱；其妻刘艳娥（郑裕玲）乃执业律师，为求赚钱，不择手段，甚至参与黑钱之事，而二人之关系实单靠金钱来衡量。某日，娥无意中发现龙隐瞒了一千万美无，一怒之下，把巨款收起，准备跟他摊牌。然而，龙在慌乱之中竟误以为杀死妻子，其后得悉娥变成植物人，龙才松一口气。曾受娥陷害的女护士马美珍（叶德娴）碰巧转职至此，珍趁机报复，误打误撞下竟把娥弄醒。龙为了探取娥收藏款项的地点，决定尽情照顾，惟娥记忆尽失，且性情怪异。一天，娥不知不觉地返回旧日律师行，发觉自己过往所做的种种坏事，后悔不已；再加上被同事调戏，龙逼她食增强记忆的药，且受珍的咒骂，终于忍受不了自杀。幸得珍加以安慰，两人遂成好友。未几，娥突然恢复记忆，并拿出巨款准备交还泰国帮，然后与龙远走高飞，从新生活。就在这时，娥闻得珍的死讯，伤心欲绝，反而指证龙的罪行，并且\u2026\u2026。","24":"play.html","skin":"play.html","25":"ydisk###1$8Mf0NTTopVM&type=qq","url":"ydisk###1$8Mf0NTTopVM&type=qq","26":null,"down":null,"27":"1520421813","addtime":"1520421813","28":"","tags":""},{"0":"45284","id":"45284","1":"29+1","name":"29+1","2":"http://r1.ykimg.com/051600005959FC9AADBC09B6B703062A","pic":"http://r1.ykimg.com/051600005959FC9AADBC09B6B703062A","3":"","pic2":"","4":"8","cid":"8","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"彭秀慧","daoyan":"彭秀慧","11":"周秀娜/郑欣宜/蔡瀚亿","zhuyan":"周秀娜/郑欣宜/蔡瀚亿","12":"爱情片","type":"爱情片","13":"香港","diqu":"香港","14":"","yuyan":"","15":"2017","year":"2017","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"简介：电影改编自彭秀慧执导的香港大热同名舞台剧，主要讲述即将进入三十岁的两位女性，在面对大部分同龄女性都会面对的困扰时，选择了截然不同的人生态度。一个是即将踏入三十岁的林若君，面对压力升级的工作挑战、双亲病重、仿如鸡肋的爱情关系，突然来袭的这些不安，令她感到前所未有的恐惧。另一个同样是即将迎来三十岁的黄天乐，却永远乐天知命，不为生活所困扰，身患癌症却坚持环游世界，寻找爱情，甚至从未因为微胖身型错过美食。她们互不认识，性格各异，因缘际会林若君搬进了黄天乐的家，没想到二人竟是同年同月同日出生，林若君通过黄天乐的日记阅读着对方的人生点滴，两个女子在空气中互相融合，观照，影响，到底是谁闯进了谁的世界？","text":"简介：电影改编自彭秀慧执导的香港大热同名舞台剧，主要讲述即将进入三十岁的两位女性，在面对大部分同龄女性都会面对的困扰时，选择了截然不同的人生态度。一个是即将踏入三十岁的林若君，面对压力升级的工作挑战、双亲病重、仿如鸡肋的爱情关系，突然来袭的这些不安，令她感到前所未有的恐惧。另一个同样是即将迎来三十岁的黄天乐，却永远乐天知命，不为生活所困扰，身患癌症却坚持环游世界，寻找爱情，甚至从未因为微胖身型错过美食。她们互不认识，性格各异，因缘际会林若君搬进了黄天乐的家，没想到二人竟是同年同月同日出生，林若君通过黄天乐的日记阅读着对方的人生点滴，两个女子在空气中互相融合，观照，影响，到底是谁闯进了谁的世界？","24":"play.html","skin":"play.html","25":"ydisk###高清$https://v.qq.com/x/cover/cld0v6tqfiiox40.html","url":"ydisk###高清$https://v.qq.com/x/cover/cld0v6tqfiiox40.html","26":null,"down":null,"27":"1520420370","addtime":"1520420370","28":"","tags":""},{"0":"54100","id":"54100","1":"道北人","name":"道北人","2":"/attachment/vod/201803/07/2018030721331279448.jpg","pic":"/attachment/vod/201803/07/2018030721331279448.jpg","3":"","pic2":"","4":"14","cid":"14","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"张汉杰/刘惠宁/孙毅安/马建安","daoyan":"张汉杰/刘惠宁/孙毅安/马建安","11":"胡亚捷/李琳/张嘉译/徐成林/常江/高远/王双宝/刘远/何佳怡/扈耀之/李少飞","zhuyan":"胡亚捷/李琳/张嘉译/徐成林/常江/高远/王双宝/刘远/何佳怡/扈耀之/李少飞","12":"国产剧","type":"国产剧","13":"大陆","diqu":"大陆","14":"","yuyan":"","15":"1995","year":"1995","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"1995年31集电视剧《道北人》通过道北三代人、四个家庭二十年的动荡变迁，着重表现了中国相当数量的城市平民的生活际遇、情感纠葛、命运浮沉和心路历程。","text":"1995年31集电视剧《道北人》通过道北三代人、四个家庭二十年的动荡变迁，着重表现了中国相当数量的城市平民的生活际遇、情感纠葛、命运浮沉和心路历程。","24":"play.html","skin":"play.html","25":"ydisk###1$h0017ggeb9t&type=qq\n2$o0017e51ely&type=qq\n3$j0017iftko7&type=qq\n4$r0017g8ckrt&type=qq\n5$h0017p8ux1c&type=qq\n6$k0017gcghw3&type=qq\n7$d0017e4q0rk&type=qq\n8$b00179e9adv&type=qq\n9$m0017l2d7ch&type=qq\n10$p0017zznc23&type=qq\n11$v0017zqcuin&type=qq\n12$j0017jdqrqf&type=qq\n13$l0017yi0f9c&type=qq\n14$u0017v2agul&type=qq\n15$t0017ehoqz6&type=qq\n16$j0017u6epjl&type=qq\n17$m0017ewlvyn&type=qq\n18$w0017rxt0m2&type=qq\n19$p001728tlr7&type=qq\n20$z00179vf1wo&type=qq\n21$v0017pisb9k&type=qq\n22$d0017ibtjy7&type=qq\n23$b00174k1jek&type=qq\n24$y0017n5dp5j&type=qq\n25$r0017f1arbk&type=qq\n26$v0017lukmr8&type=qq\n27$z0017dec117&type=qq\n28$n00176ooicd&type=qq\n29$t0017mlsj2k&type=qq\n30$z0017hsy3la&type=qq\n31$y0017swuc58&type=qq","url":"ydisk###1$h0017ggeb9t&type=qq\n2$o0017e51ely&type=qq\n3$j0017iftko7&type=qq\n4$r0017g8ckrt&type=qq\n5$h0017p8ux1c&type=qq\n6$k0017gcghw3&type=qq\n7$d0017e4q0rk&type=qq\n8$b00179e9adv&type=qq\n9$m0017l2d7ch&type=qq\n10$p0017zznc23&type=qq\n11$v0017zqcuin&type=qq\n12$j0017jdqrqf&type=qq\n13$l0017yi0f9c&type=qq\n14$u0017v2agul&type=qq\n15$t0017ehoqz6&type=qq\n16$j0017u6epjl&type=qq\n17$m0017ewlvyn&type=qq\n18$w0017rxt0m2&type=qq\n19$p001728tlr7&type=qq\n20$z00179vf1wo&type=qq\n21$v0017pisb9k&type=qq\n22$d0017ibtjy7&type=qq\n23$b00174k1jek&type=qq\n24$y0017n5dp5j&type=qq\n25$r0017f1arbk&type=qq\n26$v0017lukmr8&type=qq\n27$z0017dec117&type=qq\n28$n00176ooicd&type=qq\n29$t0017mlsj2k&type=qq\n30$z0017hsy3la&type=qq\n31$y0017swuc58&type=qq","26":null,"down":null,"27":"1520422113","addtime":"1520422113","28":"","tags":""},{"0":"53061","id":"53061","1":"大乡里八面威风","name":"大乡里八面威风","2":"/attachment/vod/201803/07/2018030721382492046.jpg","pic":"/attachment/vod/201803/07/2018030721382492046.jpg","3":"","pic2":"","4":"6","cid":"6","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"杨权","daoyan":"杨权","11":"谭炳文/李香琴/郑少秋","zhuyan":"谭炳文/李香琴/郑少秋","12":"喜剧片","type":"喜剧片","13":"香港","diqu":"香港","14":"","yuyan":"","15":"1974","year":"1974","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"暂无简介","text":"暂无简介","24":"play.html","skin":"play.html","25":"ydisk###1$j00158d2w8x&type=qq","url":"ydisk###1$j00158d2w8x&type=qq","26":null,"down":null,"27":"1520421928","addtime":"1520421928","28":"","tags":""},{"0":"53418","id":"53418","1":"冲破黎明前的黑暗","name":"冲破黎明前的黑暗","2":"/attachment/vod/201803/07/2018030721364377509.jpg","pic":"/attachment/vod/201803/07/2018030721364377509.jpg","3":"","pic2":"","4":"18","cid":"18","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"王苹/刘沛然","daoyan":"王苹/刘沛然","11":"今欣/高保成","zhuyan":"今欣/高保成","12":"剧情片","type":"剧情片","13":"大陆","diqu":"大陆","14":"","yuyan":"","15":"1956","year":"1956","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"1942年5月，敌酋岗村宁次组织数万日伪军对我冀中平原展开大扫荡。为掩护主力撤退，阎志刚（今欣 饰）带人留下坚持斗争。遭敌夹击后分散突围，阎在战斗中受伤，被抗属李大娘（陈立中 饰）和儿媳凤霞（李雪红 饰）救回家中养伤。敌联队长（严寄洲 饰）得知村里藏着八路，叫嚣要活捉阎志刚。养好伤后阎志刚滋生大意，在一次执行任务时被特务跟踪，给我方造成损失，阎自责不已。冀中人民发明的地道战，让狂妄的敌人吃尽了苦头。一次，敌人集结兵力到刘家营村抢粮，配合县大队的战斗任务交给了阎志刚，他和区小队、县大队分三面包围了抢粮的敌人，并将计就计消灭了敌人的据点......","text":"1942年5月，敌酋岗村宁次组织数万日伪军对我冀中平原展开大扫荡。为掩护主力撤退，阎志刚（今欣 饰）带人留下坚持斗争。遭敌夹击后分散突围，阎在战斗中受伤，被抗属李大娘（陈立中 饰）和儿媳凤霞（李雪红 饰）救回家中养伤。敌联队长（严寄洲 饰）得知村里藏着八路，叫嚣要活捉阎志刚。养好伤后阎志刚滋生大意，在一次执行任务时被特务跟踪，给我方造成损失，阎自责不已。冀中人民发明的地道战，让狂妄的敌人吃尽了苦头。一次，敌人集结兵力到刘家营村抢粮，配合县大队的战斗任务交给了阎志刚，他和区小队、县大队分三面包围了抢粮的敌人，并将计就计消灭了敌人的据点......","24":"play.html","skin":"play.html","25":"ydisk###1$g0015s91ef3&type=qq","url":"ydisk###1$g0015s91ef3&type=qq","26":null,"down":null,"27":"1520421993","addtime":"1520421993","28":"","tags":""},{"0":"43845","id":"43845","1":"青春荷尔蒙2躁动时代","name":"青春荷尔蒙2躁动时代","2":"http://pic5.qiyipic.com/image/20150317/3a/7d/08/v_105337720_m_601_m5_195_260.jpg","pic":"http://pic5.qiyipic.com/image/20150317/3a/7d/08/v_105337720_m_601_m5_195_260.jpg","3":"","pic2":"","4":"8","cid":"8","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"姚庆涛","daoyan":"姚庆涛","11":"莫熙儿/高宇/李水诺/罗京/闫鹏涛","zhuyan":"莫熙儿/高宇/李水诺/罗京/闫鹏涛","12":"爱情片","type":"爱情片","13":"华语","diqu":"华语","14":"","yuyan":"","15":"2015","year":"2015","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"　　莫菲和男友雷宇在学校时成立了自己的乐队\u2014\u2014HOPE乐队，毕业后，乐队被签约到著名的东方唱片公司。本以为未来充满希望的几个年轻人，却在成长的过程有了更多的误会隔阂。莫菲和男友的感情濒临破裂，和队友们产生了分歧。经历了社会的残酷之后，年轻时的梦想和憧憬被现实打破，莫菲也不知不觉走上一条不归路。青春最残忍的不是治愈，而是带着越来越多的伤痛继续前行","text":"　　莫菲和男友雷宇在学校时成立了自己的乐队\u2014\u2014HOPE乐队，毕业后，乐队被签约到著名的东方唱片公司。本以为未来充满希望的几个年轻人，却在成长的过程有了更多的误会隔阂。莫菲和男友的感情濒临破裂，和队友们产生了分歧。经历了社会的残酷之后，年轻时的梦想和憧憬被现实打破，莫菲也不知不觉走上一条不归路。青春最残忍的不是治愈，而是带着越来越多的伤痛继续前行","24":"play.html","skin":"play.html","25":"ydisk###正片$http://www.iqiyi.com/v_19rrh4gf2g.html","url":"ydisk###正片$http://www.iqiyi.com/v_19rrh4gf2g.html","26":null,"down":null,"27":"1520420021","addtime":"1520420021","28":"","tags":""},{"0":"43970","id":"43970","1":"国宝","name":"国宝","2":"http://r1.ykimg.com/050E0000522FFEA76758393E8D0223A1","pic":"http://r1.ykimg.com/050E0000522FFEA76758393E8D0223A1","3":"","pic2":"","4":"14","cid":"14","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"张绍林","daoyan":"张绍林","11":"刘文治/赵文瑄/陈刚/宋运成","zhuyan":"刘文治/赵文瑄/陈刚/宋运成","12":"国产剧","type":"国产剧","13":"大陆","diqu":"大陆","14":"","yuyan":"","15":"2004","year":"2004","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"1931年，日军入侵山海关，华北形势告急，故宫博物院决定将馆藏精品转移，以避战火浩劫。文物由北京经上海、南京辗转运抵位于大后方的四川和贵州，最后保存在乐山、峨嵋、安顺等偏远地区。至抗战结束后，陆续运回南京，之后部分被运送到台湾，部分回归北平本院，部分留在南京。　　文物南迁工作历时十五年，近二万箱、近百万件文物，行程数万公里，曾经在徐州、郑州遭到日军飞机的轰炸、在峨嵋经受了大火的考验，但都能化险为夷，文物没有丢失损毁，这是中国文物保护史乃至文化史上的奇迹，也是中华文明史上的奇迹。南迁之路是一条充满艰险的道路，无数的人力物力，无比崇高的责任心，无与伦比的勇气，铺平了这条道路，其中的艰辛困苦和危急是难以想象的\u2026\u2026","text":"1931年，日军入侵山海关，华北形势告急，故宫博物院决定将馆藏精品转移，以避战火浩劫。文物由北京经上海、南京辗转运抵位于大后方的四川和贵州，最后保存在乐山、峨嵋、安顺等偏远地区。至抗战结束后，陆续运回南京，之后部分被运送到台湾，部分回归北平本院，部分留在南京。　　文物南迁工作历时十五年，近二万箱、近百万件文物，行程数万公里，曾经在徐州、郑州遭到日军飞机的轰炸、在峨嵋经受了大火的考验，但都能化险为夷，文物没有丢失损毁，这是中国文物保护史乃至文化史上的奇迹，也是中华文明史上的奇迹。南迁之路是一条充满艰险的道路，无数的人力物力，无比崇高的责任心，无与伦比的勇气，铺平了这条道路，其中的艰辛困苦和危急是难以想象的\u2026\u2026","24":"play.html","skin":"play.html","25":"ydisk###1$c0018ugz31d&type=qq\n2$p0019ydfcg3&type=qq\n3$b0019hxo2z8&type=qq\n4$m0019qp89u2&type=qq\n5$j0018vgakm7&type=qq\n6$a00190224s3&type=qq\n7$a00199m7pol&type=qq\n8$s0019xbk6dy&type=qq\n9$a00186r3o09&type=qq\n10$q00194odyb2&type=qq\n11$r0018tvr2m2&type=qq\n12$l0018qcictb&type=qq\n13$i0019i3pofp&type=qq\n14$p0019nzj6s8&type=qq\n15$k0019pheonw&type=qq\n16$m0019j8nh1y&type=qq\n17$s001963wadl&type=qq\n18$q0019680nfa&type=qq\n19$m00192ndj37&type=qq\n20$f0019zbf3gf&type=qq","url":"ydisk###1$c0018ugz31d&type=qq\n2$p0019ydfcg3&type=qq\n3$b0019hxo2z8&type=qq\n4$m0019qp89u2&type=qq\n5$j0018vgakm7&type=qq\n6$a00190224s3&type=qq\n7$a00199m7pol&type=qq\n8$s0019xbk6dy&type=qq\n9$a00186r3o09&type=qq\n10$q00194odyb2&type=qq\n11$r0018tvr2m2&type=qq\n12$l0018qcictb&type=qq\n13$i0019i3pofp&type=qq\n14$p0019nzj6s8&type=qq\n15$k0019pheonw&type=qq\n16$m0019j8nh1y&type=qq\n17$s001963wadl&type=qq\n18$q0019680nfa&type=qq\n19$m00192ndj37&type=qq\n20$f0019zbf3gf&type=qq","26":null,"down":null,"27":"1520421025","addtime":"1520421025","28":"","tags":""},{"0":"41100","id":"41100","1":"Hand Shakers","name":"Hand Shakers","2":"http://photocdn.sohu.com/kis/fengmian/1209/1209636/1209636_ver_big_20170106100506.jpg","pic":"http://photocdn.sohu.com/kis/fengmian/1209/1209636/1209636_ver_big_20170106100506.jpg","3":"","pic2":"","4":"16","cid":"16","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"","daoyan":"","11":"未知","zhuyan":"未知","12":"动漫片","type":"动漫片","13":"其它","diqu":"其它","14":"","yuyan":"","15":"2017","year":"2017","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"Hand Shakers指的是通过紧握双手从内心深处诞生出武器，并使用这种被称为\u201c尼姆罗德\u201d的武器互相战斗的人，为了实现自己的愿望大多数的Hand Shakers都是以打倒神为目标来互相战斗。","text":"Hand Shakers指的是通过紧握双手从内心深处诞生出武器，并使用这种被称为\u201c尼姆罗德\u201d的武器互相战斗的人，为了实现自己的愿望大多数的Hand Shakers都是以打倒神为目标来互相战斗。","24":"play.html","skin":"play.html","25":"ydisk###第1集$http://www.iqiyi.com/v_19rr9wkxdk.html\n第2集$http://www.iqiyi.com/v_19rranzwus.html\n第3集$http://www.iqiyi.com/v_19rralozdo.html\n第4集$http://www.iqiyi.com/v_19rrakdg90.html\n第5集$http://www.iqiyi.com/v_19rrasd5hg.html\n第6集$http://www.iqiyi.com/v_19rraqurqs.html\n第7集$http://www.iqiyi.com/v_19rrae6zt0.html\n第8集$http://www.iqiyi.com/v_19rrabpi9w.html\n第9集$http://www.iqiyi.com/v_19rraj54ns.html\n第10集$http://www.iqiyi.com/v_19rragojcw.html","url":"ydisk###第1集$http://www.iqiyi.com/v_19rr9wkxdk.html\n第2集$http://www.iqiyi.com/v_19rranzwus.html\n第3集$http://www.iqiyi.com/v_19rralozdo.html\n第4集$http://www.iqiyi.com/v_19rrakdg90.html\n第5集$http://www.iqiyi.com/v_19rrasd5hg.html\n第6集$http://www.iqiyi.com/v_19rraqurqs.html\n第7集$http://www.iqiyi.com/v_19rrae6zt0.html\n第8集$http://www.iqiyi.com/v_19rrabpi9w.html\n第9集$http://www.iqiyi.com/v_19rraj54ns.html\n第10集$http://www.iqiyi.com/v_19rragojcw.html","26":null,"down":null,"27":"1520419621","addtime":"1520419621","28":"","tags":""},{"0":"54667","id":"54667","1":"这该死的爱","name":"这该死的爱","2":"/attachment/vod/201803/07/2018030721280933051.jpg","pic":"/attachment/vod/201803/07/2018030721280933051.jpg","3":"","pic2":"","4":"15","cid":"15","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"金魁太","daoyan":"金魁太","11":"申敏儿/郑智薰/李基宇/金莎朗/金英在/李顺载","zhuyan":"申敏儿/郑智薰/李基宇/金莎朗/金英在/李顺载","12":"韩国剧","type":"韩国剧","13":"韩国","diqu":"韩国","14":"","yuyan":"","15":"2005","year":"2005","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"剧中的江复久是一位k-1（将武术、空手道、跆拳道和自由搏击结合在一起的运动）运动员，他爱上不该爱的人\u2014\u2014哥哥的前恋人、当模特儿的女主角，但却不畏艰难险阻，勇往直前。 　　申敏雅饰演的车恩锡是在韩国最具人气的女演员。她的外表充满神秘魅力，不过内却活泼开朗，她偶然邂逅性格强悍又温柔的格斗拳手rain，两人发展出一段想爱又不能爱的苦恋。虽然她是一位身兼名气和大众人气的神奇人物，但她还是一个平凡和富有人情味儿的20多岁女性。她偶尔成为rain的目标，陷入无法自拔的感情纠葛，并为了这段根本没有结果的感情而伤心。","text":"剧中的江复久是一位k-1（将武术、空手道、跆拳道和自由搏击结合在一起的运动）运动员，他爱上不该爱的人\u2014\u2014哥哥的前恋人、当模特儿的女主角，但却不畏艰难险阻，勇往直前。 　　申敏雅饰演的车恩锡是在韩国最具人气的女演员。她的外表充满神秘魅力，不过内却活泼开朗，她偶然邂逅性格强悍又温柔的格斗拳手rain，两人发展出一段想爱又不能爱的苦恋。虽然她是一位身兼名气和大众人气的神奇人物，但她还是一个平凡和富有人情味儿的20多岁女性。她偶尔成为rain的目标，陷入无法自拔的感情纠葛，并为了这段根本没有结果的感情而伤心。","24":"play.html","skin":"play.html","25":"ydisk###1$a0014j0oo3h&type=qq\n2$q0014b65k19&type=qq\n3$d00140ajzg0&type=qq\n4$z0014t112p3&type=qq\n5$k00148qhaze&type=qq\n6$m0014jxdhtn&type=qq\n7$v00142a4rqj&type=qq\n8$c0014s7kcvf&type=qq\n9$j0014qxifw5&type=qq\n10$x0014nkmm8c&type=qq\n11$o0014p372hi&type=qq\n12$c0014655adg&type=qq\n13$j0014eh9gas&type=qq\n14$m0014a3i5fd&type=qq\n15$f0014vwrlk2&type=qq\n16$e0014x8fepn&type=qq","url":"ydisk###1$a0014j0oo3h&type=qq\n2$q0014b65k19&type=qq\n3$d00140ajzg0&type=qq\n4$z0014t112p3&type=qq\n5$k00148qhaze&type=qq\n6$m0014jxdhtn&type=qq\n7$v00142a4rqj&type=qq\n8$c0014s7kcvf&type=qq\n9$j0014qxifw5&type=qq\n10$x0014nkmm8c&type=qq\n11$o0014p372hi&type=qq\n12$c0014655adg&type=qq\n13$j0014eh9gas&type=qq\n14$m0014a3i5fd&type=qq\n15$f0014vwrlk2&type=qq\n16$e0014x8fepn&type=qq","26":null,"down":null,"27":"1520422211","addtime":"1520422211","28":"","tags":""},{"0":"48399","id":"48399","1":"瘦身男女","name":"瘦身男女","2":"http://r3.ykimg.com/050E000052B10352675839603E051787","pic":"http://r3.ykimg.com/050E000052B10352675839603E051787","3":"","pic2":"","4":"6","cid":"6","5":"0","tid":"0","6":"0","zid":"0","7":"0","yid":"0","8":"0","ztid":"0","9":"完结","state":"完结","10":"杜琪峰/韦家辉","daoyan":"杜琪峰/韦家辉","11":"未知","zhuyan":"未知","12":"喜剧片","type":"喜剧片","13":"香港","diqu":"香港","14":"","yuyan":"","15":"2001","year":"2001","16":"","info":"","17":"0","hits":"0","18":"0","yhits":"0","19":"0","zhits":"0","20":"0","rhits":"0","21":"0","cion":"0","22":"0","vip":"0","23":"Mini（郑秀文饰）是旅居日本的香港人，本是一位窈窕淑女，却在遭受失恋的刺激后变成一个体重260磅的大肥婆。就在自卑感非常强烈的时候，却有缘认识了同病相怜的肥佬（刘德华饰）。在交流中Mini告诉肥佬她和初恋情人黑川（黑川力矢饰）有一个十年之约，而在如今只剩下45天的时候，她却变成了一个大肥婆。好心的肥佬帮助Mini恢复原来的体形，成全有情人，于是与Mini一起取采地狱式方法来减肥。终于功夫不负有心人，在这四十多天时间里，肥佬和Mini都减肥成功。十年之约来临的那天，黑川向Mini求婚，但当黑川得知她曾经变成肥婆的真相时，事情则变得复杂起来\u2026\u2026","text":"Mini（郑秀文饰）是旅居日本的香港人，本是一位窈窕淑女，却在遭受失恋的刺激后变成一个体重260磅的大肥婆。就在自卑感非常强烈的时候，却有缘认识了同病相怜的肥佬（刘德华饰）。在交流中Mini告诉肥佬她和初恋情人黑川（黑川力矢饰）有一个十年之约，而在如今只剩下45天的时候，她却变成了一个大肥婆。好心的肥佬帮助Mini恢复原来的体形，成全有情人，于是与Mini一起取采地狱式方法来减肥。终于功夫不负有心人，在这四十多天时间里，肥佬和Mini都减肥成功。十年之约来临的那天，黑川向Mini求婚，但当黑川得知她曾经变成肥婆的真相时，事情则变得复杂起来\u2026\u2026","24":"play.html","skin":"play.html","25":"ydisk###1$n0019evme0t&type=qq","url":"ydisk###1$n0019evme0t&type=qq","26":null,"down":null,"27":"1520421030","addtime":"1520421030","28":"","tags":""}]
         */

        private InfoBean info;
        private List<TuijianBean> tuijian;

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

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public List<TuijianBean> getTuijian() {
            return tuijian;
        }

        public void setTuijian(List<TuijianBean> tuijian) {
            this.tuijian = tuijian;
        }

        public static class InfoBean {
            /**
             * 0 : 52713
             * id : 52713
             * 1 : 海上花
             * name : 海上花
             * 2 : /attachment/vod/201803/07/2018030721400763082.jpg
             * pic : /attachment/vod/201803/07/2018030721400763082.jpg
             * 3 :
             * pic2 :
             * 4 : 18
             * cid : 18
             * 5 : 0
             * tid : 0
             * 6 : 0
             * zid : 0
             * 7 : 0
             * yid : 0
             * 8 : 0
             * ztid : 0
             * 9 : 完结
             * state : 完结
             * 10 : 杨凡
             * daoyan : 杨凡
             * 11 : 未知
             * zhuyan : 未知
             * 12 : 剧情片
             * type : 剧情片
             * 13 : 香港
             * diqu : 香港
             * 14 :
             * yuyan :
             * 15 : 1986
             * year : 1986
             * 16 :
             * info :
             * 17 : 0
             * hits : 0
             * 18 : 0
             * yhits : 0
             * 19 : 0
             * zhits : 0
             * 20 : 0
             * rhits : 0
             * 21 : 0
             * cion : 0
             * 22 : 0
             * vip : 0
             * 23 : 影片以倒叙的手法，描述10年前在澳门做茶楼歌女的张美龄（张艾嘉饰）与日本运动员中村（鹤见辰吾饰）相遇并相互爱慕。中村回国后，美龄继续唱歌，并与白兰（姚炜饰）一见如故，开始了一段微妙的关系。10年后，中村来找美龄，引起白兰愤恨。当美龄和中村在酒店见面时，中村被杀，美龄在审讯时一直沉默，到底谁是真凶？
             * text : 影片以倒叙的手法，描述10年前在澳门做茶楼歌女的张美龄（张艾嘉饰）与日本运动员中村（鹤见辰吾饰）相遇并相互爱慕。中村回国后，美龄继续唱歌，并与白兰（姚炜饰）一见如故，开始了一段微妙的关系。10年后，中村来找美龄，引起白兰愤恨。当美龄和中村在酒店见面时，中村被杀，美龄在审讯时一直沉默，到底谁是真凶？
             * 24 : play.html
             * skin : play.html
             * 25 : ydisk###1$u00195rg1bf&type=qq
             * url : ydisk###1$u00195rg1bf&type=qq
             * 26 : null
             * down : null
             * 27 : 1520421868
             * addtime : 1520421868
             * 28 :
             * tags :
             */

            @SerializedName("0")
            private String _$0;
            private String id;
            @SerializedName("1")
            private String _$1;
            private String name;
            @SerializedName("2")
            private String _$2;
            private String pic;
            @SerializedName("3")
            private String _$3;
            private String pic2;
            @SerializedName("4")
            private String _$4;
            private String cid;
            @SerializedName("5")
            private String _$5;
            private String tid;
            @SerializedName("6")
            private String _$6;
            private String zid;
            @SerializedName("7")
            private String _$7;
            private String yid;
            @SerializedName("8")
            private String _$8;
            private String ztid;
            @SerializedName("9")
            private String _$9;
            private String state;
            @SerializedName("10")
            private String _$10;
            private String daoyan;
            @SerializedName("11")
            private String _$11;
            private String zhuyan;
            @SerializedName("12")
            private String _$12;
            private String type;
            @SerializedName("13")
            private String _$13;
            private String diqu;
            @SerializedName("14")
            private String _$14;
            private String yuyan;
            @SerializedName("15")
            private String _$15;
            private String year;
            @SerializedName("16")
            private String _$16;
            private String info;
            @SerializedName("17")
            private String _$17;
            private String hits;
            @SerializedName("18")
            private String _$18;
            private String yhits;
            @SerializedName("19")
            private String _$19;
            private String zhits;
            @SerializedName("20")
            private String _$20;
            private String rhits;
            @SerializedName("21")
            private String _$21;
            private String cion;
            @SerializedName("22")
            private String _$22;
            private String vip;
            @SerializedName("23")
            private String _$23;
            private String text;
            @SerializedName("24")
            private String _$24;
            private String skin;
            @SerializedName("25")
            private String _$25;
            private String url;
            @SerializedName("26")
            private Object _$26;
            private Object down;
            @SerializedName("27")
            private String _$27;
            private String addtime;
            @SerializedName("28")
            private String _$28;
            private String tags;

            public static InfoBean objectFromData(String str) {

                return new Gson().fromJson(str, InfoBean.class);
            }

            public static InfoBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), InfoBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<InfoBean> arrayInfoBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<InfoBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<InfoBean> arrayInfoBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<InfoBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String get_$0() {
                return _$0;
            }

            public void set_$0(String _$0) {
                this._$0 = _$0;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String get_$2() {
                return _$2;
            }

            public void set_$2(String _$2) {
                this._$2 = _$2;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String get_$3() {
                return _$3;
            }

            public void set_$3(String _$3) {
                this._$3 = _$3;
            }

            public String getPic2() {
                return pic2;
            }

            public void setPic2(String pic2) {
                this.pic2 = pic2;
            }

            public String get_$4() {
                return _$4;
            }

            public void set_$4(String _$4) {
                this._$4 = _$4;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String get_$5() {
                return _$5;
            }

            public void set_$5(String _$5) {
                this._$5 = _$5;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String get_$6() {
                return _$6;
            }

            public void set_$6(String _$6) {
                this._$6 = _$6;
            }

            public String getZid() {
                return zid;
            }

            public void setZid(String zid) {
                this.zid = zid;
            }

            public String get_$7() {
                return _$7;
            }

            public void set_$7(String _$7) {
                this._$7 = _$7;
            }

            public String getYid() {
                return yid;
            }

            public void setYid(String yid) {
                this.yid = yid;
            }

            public String get_$8() {
                return _$8;
            }

            public void set_$8(String _$8) {
                this._$8 = _$8;
            }

            public String getZtid() {
                return ztid;
            }

            public void setZtid(String ztid) {
                this.ztid = ztid;
            }

            public String get_$9() {
                return _$9;
            }

            public void set_$9(String _$9) {
                this._$9 = _$9;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String get_$10() {
                return _$10;
            }

            public void set_$10(String _$10) {
                this._$10 = _$10;
            }

            public String getDaoyan() {
                return daoyan;
            }

            public void setDaoyan(String daoyan) {
                this.daoyan = daoyan;
            }

            public String get_$11() {
                return _$11;
            }

            public void set_$11(String _$11) {
                this._$11 = _$11;
            }

            public String getZhuyan() {
                return zhuyan;
            }

            public void setZhuyan(String zhuyan) {
                this.zhuyan = zhuyan;
            }

            public String get_$12() {
                return _$12;
            }

            public void set_$12(String _$12) {
                this._$12 = _$12;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String get_$13() {
                return _$13;
            }

            public void set_$13(String _$13) {
                this._$13 = _$13;
            }

            public String getDiqu() {
                return diqu;
            }

            public void setDiqu(String diqu) {
                this.diqu = diqu;
            }

            public String get_$14() {
                return _$14;
            }

            public void set_$14(String _$14) {
                this._$14 = _$14;
            }

            public String getYuyan() {
                return yuyan;
            }

            public void setYuyan(String yuyan) {
                this.yuyan = yuyan;
            }

            public String get_$15() {
                return _$15;
            }

            public void set_$15(String _$15) {
                this._$15 = _$15;
            }

            public String getYear() {
                return year;
            }

            public void setYear(String year) {
                this.year = year;
            }

            public String get_$16() {
                return _$16;
            }

            public void set_$16(String _$16) {
                this._$16 = _$16;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String get_$17() {
                return _$17;
            }

            public void set_$17(String _$17) {
                this._$17 = _$17;
            }

            public String getHits() {
                return hits;
            }

            public void setHits(String hits) {
                this.hits = hits;
            }

            public String get_$18() {
                return _$18;
            }

            public void set_$18(String _$18) {
                this._$18 = _$18;
            }

            public String getYhits() {
                return yhits;
            }

            public void setYhits(String yhits) {
                this.yhits = yhits;
            }

            public String get_$19() {
                return _$19;
            }

            public void set_$19(String _$19) {
                this._$19 = _$19;
            }

            public String getZhits() {
                return zhits;
            }

            public void setZhits(String zhits) {
                this.zhits = zhits;
            }

            public String get_$20() {
                return _$20;
            }

            public void set_$20(String _$20) {
                this._$20 = _$20;
            }

            public String getRhits() {
                return rhits;
            }

            public void setRhits(String rhits) {
                this.rhits = rhits;
            }

            public String get_$21() {
                return _$21;
            }

            public void set_$21(String _$21) {
                this._$21 = _$21;
            }

            public String getCion() {
                return cion;
            }

            public void setCion(String cion) {
                this.cion = cion;
            }

            public String get_$22() {
                return _$22;
            }

            public void set_$22(String _$22) {
                this._$22 = _$22;
            }

            public String getVip() {
                return vip;
            }

            public void setVip(String vip) {
                this.vip = vip;
            }

            public String get_$23() {
                return _$23;
            }

            public void set_$23(String _$23) {
                this._$23 = _$23;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String get_$24() {
                return _$24;
            }

            public void set_$24(String _$24) {
                this._$24 = _$24;
            }

            public String getSkin() {
                return skin;
            }

            public void setSkin(String skin) {
                this.skin = skin;
            }

            public String get_$25() {
                return _$25;
            }

            public void set_$25(String _$25) {
                this._$25 = _$25;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public Object get_$26() {
                return _$26;
            }

            public void set_$26(Object _$26) {
                this._$26 = _$26;
            }

            public Object getDown() {
                return down;
            }

            public void setDown(Object down) {
                this.down = down;
            }

            public String get_$27() {
                return _$27;
            }

            public void set_$27(String _$27) {
                this._$27 = _$27;
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public String get_$28() {
                return _$28;
            }

            public void set_$28(String _$28) {
                this._$28 = _$28;
            }

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }
        }

        public static class TuijianBean {
            /**
             * 0 : 45094
             * id : 45094
             * 1 : 笑春
             * name : 笑春
             * 2 : http://r1.ykimg.com/050E0000520481C567583944440A01EF
             * pic : http://r1.ykimg.com/050E0000520481C567583944440A01EF
             * 3 :
             * pic2 :
             * 4 : 14
             * cid : 14
             * 5 : 0
             * tid : 0
             * 6 : 0
             * zid : 0
             * 7 : 0
             * yid : 0
             * 8 : 0
             * ztid : 0
             * 9 : 完结
             * state : 完结
             * 10 : 姚中文
             * daoyan : 姚中文
             * 11 : 吴瑕/梁爽/其其格/田玉魁
             * zhuyan : 吴瑕/梁爽/其其格/田玉魁
             * 12 : 国产剧
             * type : 国产剧
             * 13 : 大陆
             * diqu : 大陆
             * 14 :
             * yuyan :
             * 15 : 2009
             * year : 2009
             * 16 :
             * info :
             * 17 : 0
             * hits : 0
             * 18 : 0
             * yhits : 0
             * 19 : 0
             * zhits : 0
             * 20 : 0
             * rhits : 0
             * 21 : 0
             * cion : 0
             * 22 : 0
             * vip : 0
             * 23 : 东北某市郊渔村，经营饭店的王笑春本不想参与村长竞选，但是由于村民支持王笑春放弃经营多年的饭店，回来当上了村长。他的养母二婶知道金品三等人的家族势力，怕干不好得罪他们，引来不必要的麻烦，当村长的王笑春顶住了二婶的百般反对与金品三等人家族势力展开了一场集体与个人利益之争，他顶住各种压力，克服了重重困难，得到了全村人民的拥护和信任带领渔村一步一步向社会主义新农村迈进。
             * text : 东北某市郊渔村，经营饭店的王笑春本不想参与村长竞选，但是由于村民支持王笑春放弃经营多年的饭店，回来当上了村长。他的养母二婶知道金品三等人的家族势力，怕干不好得罪他们，引来不必要的麻烦，当村长的王笑春顶住了二婶的百般反对与金品三等人家族势力展开了一场集体与个人利益之争，他顶住各种压力，克服了重重困难，得到了全村人民的拥护和信任带领渔村一步一步向社会主义新农村迈进。
             * 24 : play.html
             * skin : play.html
             * 25 : ydisk###第1集$http://www.iqiyi.com/v_19rrkjrr4s.html
             第2集$http://www.iqiyi.com/v_19rrkjrj8o.html
             第3集$http://www.iqiyi.com/v_19rrkjrs2o.html
             第4集$http://www.iqiyi.com/v_19rrkjrm9o.html
             第5集$http://www.iqiyi.com/v_19rrkjrqkg.html
             第6集$http://www.iqiyi.com/v_19rrkjri7g.html
             第7集$http://www.iqiyi.com/v_19rrkjrq84.html
             第8集$http://www.iqiyi.com/v_19rrkjrgqo.html
             第9集$http://www.iqiyi.com/v_19rrkjrkdw.html
             第10集$http://www.iqiyi.com/v_19rrkjrp2k.html
             第11集$http://www.iqiyi.com/v_19rrkjrsd4.html
             第12集$http://www.iqiyi.com/v_19rrkjrl0g.html
             第13集$http://www.iqiyi.com/v_19rrkjrlng.html
             第14集$http://www.iqiyi.com/v_19rrkjrhhs.html
             第15集$http://www.iqiyi.com/v_19rrkjrimg.html
             第16集$http://www.iqiyi.com/v_19rrkjrkjg.html
             第17集$http://www.iqiyi.com/v_19rrkjradc.html
             第18集$http://www.iqiyi.com/v_19rrkjrbsw.html
             * url : ydisk###第1集$http://www.iqiyi.com/v_19rrkjrr4s.html
             第2集$http://www.iqiyi.com/v_19rrkjrj8o.html
             第3集$http://www.iqiyi.com/v_19rrkjrs2o.html
             第4集$http://www.iqiyi.com/v_19rrkjrm9o.html
             第5集$http://www.iqiyi.com/v_19rrkjrqkg.html
             第6集$http://www.iqiyi.com/v_19rrkjri7g.html
             第7集$http://www.iqiyi.com/v_19rrkjrq84.html
             第8集$http://www.iqiyi.com/v_19rrkjrgqo.html
             第9集$http://www.iqiyi.com/v_19rrkjrkdw.html
             第10集$http://www.iqiyi.com/v_19rrkjrp2k.html
             第11集$http://www.iqiyi.com/v_19rrkjrsd4.html
             第12集$http://www.iqiyi.com/v_19rrkjrl0g.html
             第13集$http://www.iqiyi.com/v_19rrkjrlng.html
             第14集$http://www.iqiyi.com/v_19rrkjrhhs.html
             第15集$http://www.iqiyi.com/v_19rrkjrimg.html
             第16集$http://www.iqiyi.com/v_19rrkjrkjg.html
             第17集$http://www.iqiyi.com/v_19rrkjradc.html
             第18集$http://www.iqiyi.com/v_19rrkjrbsw.html
             * 26 : null
             * down : null
             * 27 : 1520420232
             * addtime : 1520420232
             * 28 :
             * tags :
             */

            @SerializedName("0")
            private String _$0;
            private String id;
            @SerializedName("1")
            private String _$1;
            private String name;
            @SerializedName("2")
            private String _$2;
            private String pic;
            @SerializedName("3")
            private String _$3;
            private String pic2;
            @SerializedName("4")
            private String _$4;
            private String cid;
            @SerializedName("5")
            private String _$5;
            private String tid;
            @SerializedName("6")
            private String _$6;
            private String zid;
            @SerializedName("7")
            private String _$7;
            private String yid;
            @SerializedName("8")
            private String _$8;
            private String ztid;
            @SerializedName("9")
            private String _$9;
            private String state;
            @SerializedName("10")
            private String _$10;
            private String daoyan;
            @SerializedName("11")
            private String _$11;
            private String zhuyan;
            @SerializedName("12")
            private String _$12;
            private String type;
            @SerializedName("13")
            private String _$13;
            private String diqu;
            @SerializedName("14")
            private String _$14;
            private String yuyan;
            @SerializedName("15")
            private String _$15;
            private String year;
            @SerializedName("16")
            private String _$16;
            private String info;
            @SerializedName("17")
            private String _$17;
            private String hits;
            @SerializedName("18")
            private String _$18;
            private String yhits;
            @SerializedName("19")
            private String _$19;
            private String zhits;
            @SerializedName("20")
            private String _$20;
            private String rhits;
            @SerializedName("21")
            private String _$21;
            private String cion;
            @SerializedName("22")
            private String _$22;
            private String vip;
            @SerializedName("23")
            private String _$23;
            private String text;
            @SerializedName("24")
            private String _$24;
            private String skin;
            @SerializedName("25")
            private String _$25;
            private String url;
            @SerializedName("26")
            private Object _$26;
            private Object down;
            @SerializedName("27")
            private String _$27;
            private String addtime;
            @SerializedName("28")
            private String _$28;
            private String tags;

            public Bitmap getCaCheBitmap() {
                return caCheBitmap;
            }

            public void setCaCheBitmap(Bitmap caCheBitmap) {
                this.caCheBitmap = caCheBitmap;
            }

            private Bitmap caCheBitmap;

            public static TuijianBean objectFromData(String str) {

                return new Gson().fromJson(str, TuijianBean.class);
            }

            public static TuijianBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), TuijianBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<TuijianBean> arrayTuijianBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<TuijianBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<TuijianBean> arrayTuijianBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<TuijianBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String get_$0() {
                return _$0;
            }

            public void set_$0(String _$0) {
                this._$0 = _$0;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String get_$2() {
                return _$2;
            }

            public void set_$2(String _$2) {
                this._$2 = _$2;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String get_$3() {
                return _$3;
            }

            public void set_$3(String _$3) {
                this._$3 = _$3;
            }

            public String getPic2() {
                return pic2;
            }

            public void setPic2(String pic2) {
                this.pic2 = pic2;
            }

            public String get_$4() {
                return _$4;
            }

            public void set_$4(String _$4) {
                this._$4 = _$4;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String get_$5() {
                return _$5;
            }

            public void set_$5(String _$5) {
                this._$5 = _$5;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String get_$6() {
                return _$6;
            }

            public void set_$6(String _$6) {
                this._$6 = _$6;
            }

            public String getZid() {
                return zid;
            }

            public void setZid(String zid) {
                this.zid = zid;
            }

            public String get_$7() {
                return _$7;
            }

            public void set_$7(String _$7) {
                this._$7 = _$7;
            }

            public String getYid() {
                return yid;
            }

            public void setYid(String yid) {
                this.yid = yid;
            }

            public String get_$8() {
                return _$8;
            }

            public void set_$8(String _$8) {
                this._$8 = _$8;
            }

            public String getZtid() {
                return ztid;
            }

            public void setZtid(String ztid) {
                this.ztid = ztid;
            }

            public String get_$9() {
                return _$9;
            }

            public void set_$9(String _$9) {
                this._$9 = _$9;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String get_$10() {
                return _$10;
            }

            public void set_$10(String _$10) {
                this._$10 = _$10;
            }

            public String getDaoyan() {
                return daoyan;
            }

            public void setDaoyan(String daoyan) {
                this.daoyan = daoyan;
            }

            public String get_$11() {
                return _$11;
            }

            public void set_$11(String _$11) {
                this._$11 = _$11;
            }

            public String getZhuyan() {
                return zhuyan;
            }

            public void setZhuyan(String zhuyan) {
                this.zhuyan = zhuyan;
            }

            public String get_$12() {
                return _$12;
            }

            public void set_$12(String _$12) {
                this._$12 = _$12;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String get_$13() {
                return _$13;
            }

            public void set_$13(String _$13) {
                this._$13 = _$13;
            }

            public String getDiqu() {
                return diqu;
            }

            public void setDiqu(String diqu) {
                this.diqu = diqu;
            }

            public String get_$14() {
                return _$14;
            }

            public void set_$14(String _$14) {
                this._$14 = _$14;
            }

            public String getYuyan() {
                return yuyan;
            }

            public void setYuyan(String yuyan) {
                this.yuyan = yuyan;
            }

            public String get_$15() {
                return _$15;
            }

            public void set_$15(String _$15) {
                this._$15 = _$15;
            }

            public String getYear() {
                return year;
            }

            public void setYear(String year) {
                this.year = year;
            }

            public String get_$16() {
                return _$16;
            }

            public void set_$16(String _$16) {
                this._$16 = _$16;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String get_$17() {
                return _$17;
            }

            public void set_$17(String _$17) {
                this._$17 = _$17;
            }

            public String getHits() {
                return hits;
            }

            public void setHits(String hits) {
                this.hits = hits;
            }

            public String get_$18() {
                return _$18;
            }

            public void set_$18(String _$18) {
                this._$18 = _$18;
            }

            public String getYhits() {
                return yhits;
            }

            public void setYhits(String yhits) {
                this.yhits = yhits;
            }

            public String get_$19() {
                return _$19;
            }

            public void set_$19(String _$19) {
                this._$19 = _$19;
            }

            public String getZhits() {
                return zhits;
            }

            public void setZhits(String zhits) {
                this.zhits = zhits;
            }

            public String get_$20() {
                return _$20;
            }

            public void set_$20(String _$20) {
                this._$20 = _$20;
            }

            public String getRhits() {
                return rhits;
            }

            public void setRhits(String rhits) {
                this.rhits = rhits;
            }

            public String get_$21() {
                return _$21;
            }

            public void set_$21(String _$21) {
                this._$21 = _$21;
            }

            public String getCion() {
                return cion;
            }

            public void setCion(String cion) {
                this.cion = cion;
            }

            public String get_$22() {
                return _$22;
            }

            public void set_$22(String _$22) {
                this._$22 = _$22;
            }

            public String getVip() {
                return vip;
            }

            public void setVip(String vip) {
                this.vip = vip;
            }

            public String get_$23() {
                return _$23;
            }

            public void set_$23(String _$23) {
                this._$23 = _$23;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String get_$24() {
                return _$24;
            }

            public void set_$24(String _$24) {
                this._$24 = _$24;
            }

            public String getSkin() {
                return skin;
            }

            public void setSkin(String skin) {
                this.skin = skin;
            }

            public String get_$25() {
                return _$25;
            }

            public void set_$25(String _$25) {
                this._$25 = _$25;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public Object get_$26() {
                return _$26;
            }

            public void set_$26(Object _$26) {
                this._$26 = _$26;
            }

            public Object getDown() {
                return down;
            }

            public void setDown(Object down) {
                this.down = down;
            }

            public String get_$27() {
                return _$27;
            }

            public void set_$27(String _$27) {
                this._$27 = _$27;
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public String get_$28() {
                return _$28;
            }

            public void set_$28(String _$28) {
                this._$28 = _$28;
            }

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }
        }
    }
}
