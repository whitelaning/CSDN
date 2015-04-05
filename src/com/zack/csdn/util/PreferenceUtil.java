package com.zack.csdn.util;

import android.content.Context;
import android.content.SharedPreferences;
/**
 * 
 * @author white
 *
 */
public class PreferenceUtil {
	/**
	 * ָ��SharedPreferencesд������
	 * @param context ������
	 * @param SharedPreferencesName SharedPreferences����
	 * @param key ��
	 * @param value ֵ
	 */
	public static void write(Context context, String SharedPreferencesName, String key, String value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		sharedPreferences.edit().putString(key, value).commit();
	}
	
	/**
	 * ָ��SharedPreferencesд������
	 * @param context ������
	 * @param SharedPreferencesName SharedPreferences����
	 * @param key ��
	 * @param value ֵ
	 */
	public static void write(Context context, String SharedPreferencesName, String key, int value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		sharedPreferences.edit().putInt(key, value).commit();
	}
	
	/**
	 * ָ��SharedPreferencesд������
	 * @param context ������
	 * @param SharedPreferencesName SharedPreferences����
	 * @param key ��
	 * @param value ֵ
	 */
	public static void write(Context context, String SharedPreferencesName, String key, Boolean value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		sharedPreferences.edit().putBoolean(key, value).commit();
	}
	
	/**
	 * ָ��SharedPreferences��ȡ����
	 * @param context ������
	 * @param SharedPreferencesName SharedPreferences����
	 * @param key ��
	 * @return String ֵ
	 */
	public static String readString(Context context, String SharedPreferencesName, String key) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		return sharedPreferences.getString(key, "");
	}

	/**
	 * ָ��SharedPreferences��ȡ����
	 * @param context ������
	 * @param SharedPreferencesName SharedPreferences����
	 * @param key ��
	 * @return int ֵ
	 */
	public static int readInt(Context context, String SharedPreferencesName, String key) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		return sharedPreferences.getInt(key, 0);
	}

	/**
	 * ָ��SharedPreferences��ȡ����
	 * @param context ������
	 * @param SharedPreferencesName SharedPreferences����
	 * @param key ��
	 * @return Boolean ֵ
	 */
	public static Boolean readBoolean(Context context, String SharedPreferencesName, String key) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		return sharedPreferences.getBoolean(key, false);
	}

	/**
	 * ָ��SharedPreferencesɾ������
	 * @param context ������
	 * @param SharedPreferencesName SharedPreferences����
	 * @param key ��
	 */
	public static void remove(Context context, String SharedPreferencesName, String key) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		sharedPreferences.edit().remove(key).commit();
	}
}
