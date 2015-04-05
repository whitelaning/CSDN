package com.zack.csdn.control;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.zack.csdn.R;

public class ImageLoaderControl {
	public static DisplayImageOptions options; // DisplayImageOptions����������ͼƬ��ʾ����
	public static DisplayImageOptions options_circle_imge;

	static {
		options = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.default_image) // ����ͼƬ�����ڼ���ʾ��ͼƬ
				.showImageForEmptyUri(R.drawable.default_image) // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
				.showImageOnFail(R.drawable.default_image) // ����ͼƬ���ػ��������з���������ʾ��ͼƬ
				.cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
				.cacheOnDisk(true) // �������ص�ͼƬ�Ƿ񻺴���SD����
				.bitmapConfig(Bitmap.Config.RGB_565).build();
		
		options_circle_imge = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.default_image) // ����ͼƬ�����ڼ���ʾ��ͼƬ
				.showImageForEmptyUri(R.drawable.default_image) // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
				.showImageOnFail(R.drawable.default_image) // ����ͼƬ���ػ��������з���������ʾ��ͼƬ
				.cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
				.cacheOnDisk(true) // �������ص�ͼƬ�Ƿ񻺴���SD����
				.displayer(new RoundedBitmapDisplayer(8)) // ���ó�Բ��ͼƬ
				.bitmapConfig(Bitmap.Config.RGB_565).build();
	}
}
