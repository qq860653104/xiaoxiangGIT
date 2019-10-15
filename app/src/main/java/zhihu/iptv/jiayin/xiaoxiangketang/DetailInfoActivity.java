package zhihu.iptv.jiayin.xiaoxiangketang;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailInfoActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);
        final TextView myinfo = (TextView) findViewById(R.id.myinfo);

        final ImageView imageView = (ImageView) findViewById(R.id.bg_img);
        final String info = getIntent().getStringExtra("info");


        myinfo.setMovementMethod(ScrollingMovementMethod.getInstance());
//        String imgText = getIntent().getStringExtra("bg");
//
////        View blurredView = ((Activity)context).findViewById(R.id.recyclerView);
//        //给出了模糊视图并刷新模糊视图。
//        Glide.with(DetailInfoActivity.this)
//                .load(imgText)
//                .error(R.drawable.defult_movie2)
//                .into(new GlideDrawableImageViewTarget(imageView) {
//                    @Override
//                    public void onResourceReady(GlideDrawable drawable, GlideAnimation anim) {
//                        super.onResourceReady(drawable, anim);
//                        //在这里添加一些图片加载完成的操作
//                        mBlurringView.setBlurredView(imageView);
//                        mBlurringView.invalidate();
//
//
//
//                    }
//                });

        myinfo.setText(info);
    }


    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            this.finish();
//            overridePendingTransition(R.anim.activity_in,R.anim.activity_over);
            return true;
        }


        return super.onKeyUp(keyCode, event);
    }
}