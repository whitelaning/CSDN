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
	 * 指定SharedPreferences写入数据
	 * @param context 上下文
	 * @param SharedPreferencesName SharedPreferences名字
	 * @param key 键
	 * @param value 值
	 */
	public static void write(Context context, String SharedPreferencesName, String key, String value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		sharedPreferences.edit().putString(key, value).commit();
	}
	
	/**
	 * 指定SharedPreferences写入数据
	 * @param context 上下文
	 * @param SharedPreferencesName SharedPreferences名字
	 * @param key 键
	 * @param value 值
	 */
	public static void write(Context context, String SharedPreferencesName, String key, int value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		sharedPreferences.edit().putInt(key, value).commit();
	}
	
	/**
	 * 指定SharedPreferences写入数据
	 * @param context 上下文
	 * @param SharedPreferencesName SharedPreferences名字
	 * @param key 键
	 * @param value 值
	 */
	public static void write(Context context, String SharedPreferencesName, String key, Boolean value) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		sharedPreferences.edit().putBoolean(key, value).commit();
	}
	
	/**
	 * 指定SharedPreferences读取数据
	 * @param context 上下文
	 * @param SharedPreferencesName SharedPreferences名字
	 * @param key 键
	 * @return String 值
	 */
	public static String readString(Context context, String SharedPreferencesName, String key) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		return sharedPreferences.getString(key, "");
	}

	/**
	 * 指定SharedPreferences读取数据
	 * @param context 上下文
	 * @param SharedPreferencesName SharedPreferences名字
	 * @param key 键
	 * @return int 值
	 */
	public static int readInt(Context context, String SharedPreferencesName, String key) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		return sharedPreferences.getInt(key, 0);
	}

	/**
	 * 指定SharedPreferences读取数据
	 * @param context 上下文
	 * @param SharedPreferencesName SharedPreferences名字
	 * @param key 键
	 * @return Boolean 值
	 */
	public static Boolean readBoolean(Context context, String SharedPreferencesName, String key) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		return sharedPreferences.getBoolean(key, false);
	}

	/**
	 * 指定SharedPreferences删除数据
	 * @param context 上下文
	 * @param SharedPreferencesName SharedPreferences名字
	 * @param key 键
	 */
	public static void remove(Context context, String SharedPreferencesName, String key) {
		SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesName, Context.MODE_PRIVATE);
		sharedPreferences.edit().remove(key).commit();
	}
}
