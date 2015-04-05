package com.zack.csdn.util;

import com.zack.csdn.view.ToastView;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtil {

	/**
	 * ��ʾToast
	 * @param context ������
	 * @param message ����
	 */
	public static void show(Context context, String message) {
		Toast.makeText(context, message.trim(), Toast.LENGTH_SHORT).show();
	}
	/**
	 * ��ʾ�Զ���ToastView
	 * @param context ������
	 * @param message ����
	 */
	public static void showToastView(Context context, String message) {
		ToastView toast = new ToastView(context, message);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
	/**
	 * ��ʾ�Զ���ToastView
	 * @param context ������
	 * @param message ����
	 * @param duration Toast.LENGTH_LONG / Toast.LENGTH_SHORT
	 */
	public static void showToastView(Context context, String message, int duration) {
		ToastView toast = new ToastView(context, message);
		toast.setDuration(duration);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
}
