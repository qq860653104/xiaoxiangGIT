package zhihu.iptv.jiayin.xiaoxiangketang.apk;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.Toast;

import com.chunleikeji.zhibotv.OKHttpUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class InstallAPKUtils {
    Activity activity;
    String downName;
    String apkUrl;
    int currentProgress;
    IsDownLoadOk isDownLoadOk;
    /*name:xxx.apk*/
    public void getApkUrl(Activity activity,String apkUrl,String downName,IsDownLoadOk isDownLoad){

        this.isDownLoadOk = isDownLoad;
        this.apkUrl = apkUrl;
        this.downName = downName;
        this.activity = activity;
        isDownLoad.isDownLoad(true);
        //判断SDcard是否已经安装
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            //显示进度条
            showProgress();

        } else {
            Toast.makeText(activity,"SD卡不可用，请插入SD卡",Toast.LENGTH_LONG).show();
        }
    }
   public ProgressDialog progressDialog;
    private void showProgress( ) {
        if(progressDialog == null){
            Log.e("TAA", "应用_走的是这吗_InstallAPKUtils:1"+"apkUrl:" +apkUrl +"，downName:"+downName);
            progressDialog = new ProgressDialog(activity);    //进度条，在下载的时候实时更新进度，提高用户友好度
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setTitle("正在下载");
            progressDialog.setMessage("请稍候...");
            progressDialog.setProgress(0);
            progressDialog.show();
            downFile(apkUrl);
        }
    }
    public void downFile(final String url) {


        OKHttpUtils.get(url,new Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.cancel();
                        progressDialog = null;
                        //通知失败
                        isDownLoadOk.isDownLoad(false);
                        Toast.makeText(activity,"下载失败",Toast.LENGTH_LONG).show();
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = null;//输入流
                FileOutputStream fos = null;//输出流
                try {
                    is = response.body().byteStream();//获取输入流
                    final long total = response.body().contentLength();//获取文件大小

                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.setMax((int) total);
                        }
                    });
                    if(is != null){
                        File file = new File(Environment.getExternalStorageDirectory(),downName);// 设置路径
                        fos = new FileOutputStream(file);
                        byte[] buf = new byte[1024];
                        int ch = -1;
                        int process = 0;
                        while ((ch = is.read(buf)) != -1) {
                            fos.write(buf, 0, ch);
                            process += ch;

                            final int tmp = process;
                            activity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    currentProgress = tmp;
                                    progressDialog.setProgress(tmp);
                                }
                            });

                        }

                    }
                    fos.flush();
                    // 下载完成
                    if(fos != null){
                        fos.close();
                    }
                    //通知成功
                    isDownLoadOk.isDownLoad(false);
                    downSuccess();
                } catch (Exception e) {

                } finally {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.cancel();
                            progressDialog = null;
                           /* Toast.makeText(activity,"更新失败",Toast.LENGTH_LONG).show();*/
                        }
                    });
                    try {
                        if (is != null)
                            is.close();
                    } catch (IOException e) {
                    }
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {
                    }
                }
            }

            //private void down() {
            // progressDialog.cancel();
            // }
        });
    }
    public void downSuccess() {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                //关闭进度条，安装文件
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }

                //安装apk
                Intent intent = new Intent(Intent.ACTION_VIEW);

                if (Build.VERSION.SDK_INT >= 24) { //android7.0时使用Provider
                    Log.e("TAA", "应用_走的是这吗_InstallAPKUtils:1");

                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    Uri contentUri = FileProvider.getUriForFile(activity, "com.boatsystem.jiayin.apkupdate.fileprovider", new File(Environment.getExternalStorageDirectory(), downName));//注意修改
                    intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
                } else {
                    Log.e("TAA", "应用_走的是这吗_InstallAPKUtils2：" +Uri.fromFile(new File(Environment.getExternalStorageDirectory(), downName)));

                    intent.setDataAndType(Uri.fromFile(new File(Environment.getExternalStorageDirectory(), downName)), "application/vnd.android.package-archive");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
                activity.startActivity(intent);
            }

        });

    }
    public static abstract class IsDownLoadOk{
            public abstract void isDownLoad(boolean isOk);
    }
}
