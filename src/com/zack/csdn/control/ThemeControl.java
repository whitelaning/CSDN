package com.zack.csdn.control;

import com.zack.csdn.CSDN;
import com.zack.csdn.R;
import com.zack.csdn.util.PreferenceUtil;

import android.app.Activity;
import android.content.Intent;

public class ThemeControl {
	private static int mTheme;

	public final static int THEME_DAY = 0;
	public final static int THEME_NIGHT = 1;
	
	static {
		mTheme = PreferenceUtil.readInt(CSDN.getContext(), SharedPreferencesConstant.CONFIG, "theme");
	}

	/**
	 * Set the theme of the Activity, and restart it by creating a new Activity
	 * of the same type.
	 */
	public static void changeToTheme(Activity activity, int theme) {
		mTheme = theme;
		activity.finish();
		activity.startActivity(new Intent(activity, activity.getClass()));
	}

	/** Set the theme of the activity, according to the configuration. */
	public static void onActivityCreateSetTheme(Activity activity) {
		switch (mTheme) {
		default:
		case 0:
			activity.setTheme(R.style.Theme_Day);
			break;
		case 1:
			activity.setTheme(R.style.Theme_Night);
			break;
		}
	}
}
