package com.zack.csdn.control;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.zack.csdn.R;

public class ImageLoaderControl {
	public static DisplayImageOptions options; // DisplayImageOptions是用于设置图片显示的类
	public static DisplayImageOptions options_circle_imge;

	static {
		options = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.default_image) // 设置图片下载期间显示的图片
				.showImageForEmptyUri(R.drawable.default_image) // 设置图片Uri为空或是错误的时候显示的图片
				.showImageOnFail(R.drawable.default_image) // 设置图片加载或解码过程中发生错误显示的图片
				.cacheInMemory(true) // 设置下载的图片是否缓存在内存中
				.cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
				.bitmapConfig(Bitmap.Config.RGB_565).build();
		
		options_circle_imge = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.default_image) // 设置图片下载期间显示的图片
				.showImageForEmptyUri(R.drawable.default_image) // 设置图片Uri为空或是错误的时候显示的图片
				.showImageOnFail(R.drawable.default_image) // 设置图片加载或解码过程中发生错误显示的图片
				.cacheInMemory(true) // 设置下载的图片是否缓存在内存中
				.cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
				.displayer(new RoundedBitmapDisplayer(8)) // 设置成圆角图片
				.bitmapConfig(Bitmap.Config.RGB_565).build();
	}
}
