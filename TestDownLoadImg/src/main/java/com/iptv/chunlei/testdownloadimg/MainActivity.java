package com.iptv.chunlei.testdownloadimg;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class MainActivity extends Activity {

    private ImageView mMyimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        Glide.with(this).load("http://tv.yanglaoyz.net/ZhihuAdmin/static/upload/ba89890c13eb0282/0a49926a6974623b.png").into(mMyimg);


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                File file = null;
//                try {
//                    final String url = "http://www.jiayinkeji.xin/test/apk/ds.png";
//
//
//                    String fileName = url.substring(url.lastIndexOf("/") + 1);
//                    String saveAdr = "/mnt/sdcard/" + fileName;
//                    final File f = new File(saveAdr);
//                    if (f.exists()) {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Glide.with(MainActivity.this)
//                                        .load(f)
//                                        .into(mMyimg);
//                                Log.e("TAA","使用了本地:");
//                            }
//                        });
//
//                    } else {
//                        //不存在去下载。存在去使用
//                        file = Glide.with(MainActivity.this)
//                                .load(url)
//                                .downloadOnly(1280, 720)
//                                .get();
//                        copy(file, f);
//
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Glide.with(MainActivity.this)
//                                        .load(url)
//                                        .into(mMyimg);
//
//                                Log.e("TAA","使用了下载图:");
//                            }
//                        });
//
//
//                    }
//
//
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(MainActivity.this, "下载完了？", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        }).start();


    }


    /**
     * 复制文件
     *
     * @param source 输入文件
     * @param target 输出文件
     */
    public void copy(File source, File target) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(source);
            fileOutputStream = new FileOutputStream(target);
            byte[] buffer = new byte[1024];
            while (fileInputStream.read(buffer) > 0) {
                fileOutputStream.write(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        mMyimg = (ImageView) findViewById(R.id.myimg);
    }
}
