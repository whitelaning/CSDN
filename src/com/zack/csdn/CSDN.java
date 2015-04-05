package com.zack.csdn;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Application;
/**
 * ��������
 * @author Zack White
 */
public class CSDN extends Application {
	private static CSDN instance;

	/**
	 * ��ȡApplication
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
	 * ��ȡ������
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
		ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));// ��ʼ��ImageLoader
	}
}
