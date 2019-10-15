package com.open.androidtvwidget.viewpager;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.open.androidtvwidget.R;
import com.open.androidtvwidget.bean.HomeBean;

import java.util.List;

public class ImagePagerAdapter extends PagerAdapter {

	private List<HomeBean.DataBean.LunboBean> ids;
	private Context context;
	private LayoutInflater inflater;

	public ImagePagerAdapter.onItemClickListener getOnItemClickListener() {
		return onItemClickListener;
	}

	public void setOnItemClickListener(ImagePagerAdapter.onItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}

	private onItemClickListener onItemClickListener;

	public interface onItemClickListener{

		public void onItemClick(View view,HomeBean.DataBean.LunboBean lunboBean);
	}

	public ImagePagerAdapter(Context context,List<HomeBean.DataBean.LunboBean> url){
		this.ids=url;
		this.context=context;
		inflater = LayoutInflater.from(context);
		
	}
	private View mCurrentView;
	@Override
	public void setPrimaryItem(ViewGroup container, int position, Object object) {
		mCurrentView = (View)object;
		super.setPrimaryItem(container, position, object);
	}

	public View getPrimaryItem() {
	       return mCurrentView;
	}


	@Override
	public int getCount() {
		return ids.size()*8;
	}
	
    @Override  
    public boolean isViewFromObject(View arg0, Object arg1) {  
        return arg0 == arg1;  
    }  
  
    @Override  
    public void destroyItem(ViewGroup container, int position, Object object) {
		Log.e("TAA","销毁的："+container.getChildCount()+"_________"+position);
		container.removeView((View) object);
    }

    @Override  
    public Object instantiateItem(final ViewGroup container, int position) {
    	
		final ImageView imgview = new ImageView(context);
		final String img = ids.get(position % ids.size()).getImg();
		HomeBean.DataBean.LunboBean lunboBean =	ids.get(position % ids.size());
//		imgview.setImageResource(ids.get(position%ids.size()));
		imgview.setScaleType(ImageView.ScaleType.FIT_XY);

		Log.e("TAA","轮播图的地址："+img+"  ---序号："+(position % ids.size()));
		imgview.setBackgroundResource(R.drawable.header_defult);
		imgview.setTag(img);
		imgview.setTag(R.id.dybean,lunboBean);

		container.addView(imgview);
//    	container.addView(imgview, ViewPager.LayoutParams.MATCH_PARENT,463);

//		imgview.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//
//				if(onItemClickListener!=null){
//					onItemClickListener.onItemClick(v,(HomeBean.DataBean.LunboBean)v.getTag(R.id.dybean));
//				}
//			}
//		});


		if(lunboBean.getCache_Bitmap()!=null) {
			imgview.setImageBitmap(lunboBean.getCache_Bitmap());

		}else {
			Glide.with(container.getContext())
					.load(imgview.getTag())
					.error(R.drawable.header_defult)
					.placeholder(R.drawable.header_defult)
					.into(new SimpleTarget<GlideDrawable>(540, 235) {
						@Override
						public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
//                                mPlaybackControlsRow.setImageDrawable(resource);
//                                mRowsAdapter.notifyArrayItemRangeChanged(0, mRowsAdapter.size());
							imgview.setImageDrawable(resource);
//				imgview.setBackgroundDrawable(resource);
						}
					});
		}

//		imgview.post(new Runnable() {
//			@Override
//			public void run() {
//
//				Glide.with(container.getContext())
//						.load(imgview.getTag())
//						.error(R.drawable.header_defult)
//						.placeholder(R.drawable.header_defult)
//						.into(imgview);
//			}
//		});



    	return imgview;
    }
}
