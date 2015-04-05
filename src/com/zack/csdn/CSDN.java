package com.zack.csdn;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Application;
/**
 * 上下文类
 * @author Zack White
 */
public class CSDN extends Application {
	private static CSDN instance;

	/**
	 * 获取Application
	 * 
	 * @return CSDN
	 */
	public static CSDN getInstance() {
		if (instance == null) {
			instance = new CSDN();
		}
		return instance;
	}

	/**
	 * 获取上下文
	 * 
	 * @return getInstance()
	 */
	public static CSDN getContext() {
		return getInstance();
	}

	@Override
	public void onCreate() {
		synchronized (CSDN.class) {
			instance = this;
		}
		super.onCreate();
		ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));// 初始化ImageLoader
	}
}
