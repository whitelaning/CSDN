package com.zack.csdn.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.Context;
import android.text.TextUtils;

import com.zack.csdn.R;
import com.zack.csdn.control.SharedPreferencesConstant;

public class TimeUtil {
	/**
	 * 根据类型获取上次更新的时间
	 * 
	 * @param type
	 * @return timeString
	 */
	public static String getRefreashTime(Context context, int type) {
		String timeString = PreferenceUtil.readString(context, SharedPreferencesConstant.VARIABLE, "INFOS_" + type);
		if (TextUtils.isEmpty(timeString)) {
			return R.string.not_update + "...";
		}
		return timeString;
	}

	/**
	 * 根据类型设置上次更新的时间
	 * 
	 * @param type
	 * @return void
	 */
	public static void setRefreashTime(Context context, int type) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		PreferenceUtil.write(context, SharedPreferencesConstant.VARIABLE, "INFOS_" + type, simpleDateFormat.format(new Date()));
	}
}
