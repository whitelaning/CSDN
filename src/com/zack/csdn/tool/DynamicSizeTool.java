package com.zack.csdn.tool;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

public class DynamicSizeTool {
	public static final String tag = "DynamicSize";
	public static int defaultDisplayWidth;//��Ļ�Ŀ��
	public static int defaultDisplayHeight;//��Ļ�ĸ߶�
//	private static WindowManager windowManager;
	public static void setWidth (Context context,View view, int widthPx) {
		init(context);
		android.view.ViewGroup.LayoutParams lp = view.getLayoutParams();
		lp.width = widthPx;
	}

	public static void setHeight (Context context,View view, int heightPx) {
		init(context);
		android.view.ViewGroup.LayoutParams lp = view.getLayoutParams();
		lp.height = heightPx;
	}
	
	public static void setHeightAndWidth (Context context,View view, int heightPx,int widthPx) {
		init(context);
		android.view.ViewGroup.LayoutParams lp = view.getLayoutParams();
		lp.height = heightPx;
		lp.width = widthPx;
	}
	/**
	 * ͨ����Ļ��Ⱥ�ͼƬ��������ͼƬ�߶�
	 * @param context
	 * @param view
	 */
	public static void adaptiveImageByScreenWidth(Context context,View view, int imageViewHight, int imageViewWidth) {
		init(context);
		android.view.ViewGroup.LayoutParams lp = view.getLayoutParams();
		lp.width = defaultDisplayWidth;
		lp.height = defaultDisplayWidth * imageViewHight / imageViewWidth;
	}
	
	private static void init(Context context) {
//		windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		defaultDisplayHeight = ScreenTool.getHeight();
		defaultDisplayWidth = ScreenTool.getWidth();
//		defaultDisplayWidth = windowManager.getDefaultDisplay().getWidth();
//		defaultDisplayHeight = windowManager.getDefaultDisplay().getHeight();
	}
}
