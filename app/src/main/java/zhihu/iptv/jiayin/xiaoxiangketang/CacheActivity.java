package zhihu.iptv.jiayin.xiaoxiangketang;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.chunleikeji.ActivityClass.ActivityCollector;
import com.chunleikeji.ActivityClass.DelUtil;
import com.chunleikeji.adapter.CacheAdapter;
import com.chunleikeji.bean.HomePageBean;
import com.chunleikeji.login.Login;
import com.chunleikeji.util.StaticUtils;
import com.chunleikeji.util.ToastUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class CacheActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recView;
    Button butOk , imgEliminate , but , quitUser;
    FrameLayout live_progress;
    GlideCacheUtil glideCacheUtil;
    Context context;
    String dir = Environment.getExternalStorageDirectory() + "/xiaoxiangketnag";
    DelUtil delUtil;
    String user;
    String pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);
        ActivityCollector.addActivity(this);
        initView();
        init();

    }
        List<String> list = new ArrayList<>();
        List<String> listindex = new ArrayList<>();

    public void initView() {
        recView = (RecyclerView) findViewById(R.id.recView);
        butOk = (Button) findViewById(R.id.butOk);
        live_progress = findViewById(R.id.live_progress);
        imgEliminate = findViewById(R.id.imgEliminate);
        but = findViewById(R.id.but);
        quitUser = findViewById(R.id.quitUser);
        butOk.setOnClickListener(this);
        imgEliminate.setOnClickListener(this);
        but.setOnClickListener(this);
        quitUser.setOnClickListener(this);
    }
    HomePageBean listName;
    public void init(){
        listName = StaticUtils.listName;
        for (int i = 0; i < listName.getData().size(); i++) {
            list.add(listName.getData().get(i).getName());
        }

        Log.e("TAG", "init: " + StaticUtils.listName  );

        CacheAdapter cacheAdapter = new CacheAdapter(CacheActivity.this, list );
        GridLayoutManager linearLayoutManager = new GridLayoutManager(CacheActivity.this, 5,GridLayoutManager.VERTICAL, false);
        recView.setLayoutManager(linearLayoutManager);
        recView.setAdapter(cacheAdapter);
        cacheAdapter.setOnItemClickListener(new CacheAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String listName, int index) {

                listindex.add(listName);

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butOk:

                Log.e("TAG", "onClick: " +  listindex);
                delete(dir);
                ToastUtils.showToast(CacheActivity.this, "正在删除");
                live_progress.setVisibility(View.VISIBLE);
                handler.postDelayed(runnable1,3000);
                break;
            case R.id.imgEliminate:

                glideCacheUtil = GlideCacheUtil.getInstance();
                glideCacheUtil.clearImageAllCache(getApplicationContext());
                live_progress.setVisibility(View.VISIBLE);
                handler.postDelayed(runnable1,3000);
                break;
            case R.id.but:

                DelUtil.DelUtil(dir);
                ToastUtils.showToast(CacheActivity.this, "正在删除");
                live_progress.setVisibility(View.VISIBLE);
                handler.postDelayed(runnable1,3000);
                break;
            case R.id.quitUser:
                user = "";
                pwd = "";
                saveLoginInfo(CacheActivity.this, user, pwd);
                startActivity(new Intent(CacheActivity.this, Login.class));
                ActivityCollector.finishAll();
                break;
        }
    }
    Handler handler = new Handler();
    Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    live_progress.setVisibility(View.GONE);
                    listindex.clear();
                    findViewById(R.id.live_progress).setVisibility(View.GONE);
                    finish();
                }
            });

        }
    };
    /** 删除文件，可以是文件或文件夹
     * @param delFile 要删除的文件夹或文件名
     * @return 删除成功返回true，否则返回false
     */
    private boolean delete(String delFile) {
        File file = new File(delFile);
        if (!file.exists()) {
            Toast.makeText(getApplicationContext(), "已无缓存", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            if (file.isFile())
                return deleteSingleFile(delFile);
            else
                return deleteDirectory(delFile);
        }
    }

    /** 删除单个文件
     * @param filePath$Name 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    private boolean deleteSingleFile(String filePath$Name) {
        File file = new File(filePath$Name);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                Log.e("--Method--", "Copy_Delete.deleteSingleFile: 删除单个文件" + filePath$Name + "成功！");
                return true;
            } else {
                Toast.makeText(getApplicationContext(), "删除单个文件" + filePath$Name + "失败！", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(getApplicationContext(), "删除单个文件失败：" + filePath$Name + "不存在！", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    /** 删除目录及目录下的文件
     * @param filePath 要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    private boolean deleteDirectory(String filePath) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!filePath.endsWith(File.separator))
            filePath = filePath + File.separator;
        File dirFile = new File(filePath);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            Toast.makeText(getApplicationContext(), "删除目录失败：" + filePath + "不存在！", Toast.LENGTH_SHORT).show();
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (File file : files) {
            // 删除子文件
            if (file.isFile()) {
                flag = deleteSingleFile(file.getAbsolutePath());
                if (!flag)
                    break;
            }
            // 删除子目录
            else if (file.isDirectory()) {
                flag = deleteDirectory(file
                        .getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            Toast.makeText(getApplicationContext(), "删除目录失败！", Toast.LENGTH_SHORT).show();
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            Log.e("--Method--", "Copy_Delete.deleteDirectory: 删除目录" + filePath + "成功！");
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "删除目录：" + filePath + "失败！", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    public static void saveLoginInfo(Context context, String username, String password) {
        //获取SharedPreferences对象
        SharedPreferences sharedPre = context.getSharedPreferences("config", context.MODE_PRIVATE);
        //获取Editor对象
        SharedPreferences.Editor editor = sharedPre.edit();
        //设置参数
        editor.putString("username", username);
        editor.putString("password", password);
        //提交
        editor.commit();
    }

}
