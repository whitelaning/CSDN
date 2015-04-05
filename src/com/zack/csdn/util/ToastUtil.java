package com.zack.csdn.util;

import com.zack.csdn.view.ToastView;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtil {

	/**
	 * 显示Toast
	 * @param context 上下文
	 * @param message 内容
	 */
	public static void show(Context context, String message) {
		Toast.makeText(context, message.trim(), Toast.LENGTH_SHORT).show();
	}
	/**
	 * 显示自定义ToastView
	 * @param context 上下文
	 * @param message 内容
	 */
	public static void showToastView(Context context, String message) {
		ToastView toast = new ToastView(context, message);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
	/**
	 * 显示自定义ToastView
	 * @param context 上下文
	 * @param message 内容
	 * @param duration Toast.LENGTH_LONG / Toast.LENGTH_SHORT
	 */
	public static void showToastView(Context context, String message, int duration) {
		ToastView toast = new ToastView(context, message);
		toast.setDuration(duration);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
}
