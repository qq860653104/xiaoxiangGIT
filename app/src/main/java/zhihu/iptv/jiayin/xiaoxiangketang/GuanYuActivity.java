package zhihu.iptv.jiayin.xiaoxiangketang;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.chunleikeji.bean.BzBean;
import com.chunleikeji.util.BaseUrl;
import com.chunleikeji.util.OkHttpUtils;
import com.google.gson.Gson;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class GuanYuActivity extends Activity {

    private WebView mGywm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guan_yu);
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setScenarioType(this,MobclickAgent.EScenarioType.E_UM_NORMAL);
        initView();

        getGYWM();
    }


    private String gywm = BaseUrl.BASE+"getGYWM";
    BzBean userInfo;
    public void getGYWM(){
        OkHttpUtils.getOkHttp(this, gywm, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();

                userInfo = new Gson().fromJson(body, BzBean.class);

                if (userInfo == null || userInfo.getData() == null || userInfo.getData().get(0) == null) {
                    return;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mGywm.loadData(userInfo.getData().get(0).getContent(), "text/html;charset=utf-8","utf-8");
                    }
                });

//                allMovieBean = new Gson().fromJson(body, AllMovieBean.class);




            }
        });



    }

    private void initView() {
        mGywm = (WebView) findViewById(R.id.gywm);
    }

}
