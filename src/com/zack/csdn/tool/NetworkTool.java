package com.zack.csdn.tool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * �жϵ�ǰ������״̬
 */
public class NetworkTool {
	/**
	 * ��鵱ǰ�ֻ�����
	 * 
	 * @param context
	 * @return
	 */
	public static boolean checkNetState(Context context) {
		// �ж����ӷ�ʽ
		boolean wifiConnected = isWIFIConnected(context);
		boolean mobileConnected = isMOBILEConnected(context);
		if (wifiConnected == false && mobileConnected == false) {
			// �����û�����ӷ���false����ʾ�û���ǰû������
			return false;
		}
		return true;
	}

	/**
	 * �ж��ֻ��Ƿ����wifi����
	 */
	public static boolean isWIFIConnected(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		}
		return false;
	}

	/**
	 * �ж��ֻ��Ƿ����3G/2G����
	 */
	public static boolean isMOBILEConnected(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		}
		return false;
	}
}
