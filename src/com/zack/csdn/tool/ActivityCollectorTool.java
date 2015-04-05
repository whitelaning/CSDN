package com.zack.csdn.tool;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
/**
 * Activity������
 * @author white
 *
 */
public class ActivityCollectorTool {
	public static List<Activity> activities = new ArrayList<Activity>();

	// �������Activity��ӽ���activities
	public static void addActivity(Activity activity) {
		activities.add(activity);
	}

	// �������Activity��activities���Ƴ�
	public static void removeActivity(Activity activity) {
		activities.remove(activity);
	}

	// �������л�û�ñ�ϵͳ�ջص�Activity
	public static void finishAll() {
		for (Activity activity : activities) {
			activity.finish();
		}
	}

	// �������л�û�ñ�ϵͳ�ջص�Activity,����mActivity
	public static void finishAll(Activity mActivity) {
		for (Activity activity : activities) {
			if (!activity.equals(mActivity)) {
				activity.finish();
			}
		}
	}
}