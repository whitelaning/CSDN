package com.zack.csdn.tool;

import com.zack.csdn.CSDN;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

public class ScreenTool {

	public static final Point outSize = new Point();
	
	static {
		((WindowManager) CSDN.getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(outSize);
	}
	
	public static int getDisplayMetricsWidth() {
		return Math.min(outSize.x, outSize.y);
	}

	public static int getWidth() {
		return outSize.x;
	}

	public static int getHeight() {
		return outSize.y;
	}

	public static float getAspectRatio(int width, int height) {
		return outSize.y / outSize.x;
	}
}
