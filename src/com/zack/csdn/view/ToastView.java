package com.zack.csdn.view;

import java.util.Timer;
import java.util.TimerTask;
import com.zack.csdn.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ToastView {
	public static Toast toast;
	private static int time;
	private static Timer timer;

	public ToastView(Context context, String text) {
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		View view = layoutInflater.inflate(R.layout.toast_view, null);
		
		TextView textView = (TextView) view.findViewById(R.id.toast_text);
		textView.setText(text);
		
		if (toast != null) {
			toast.cancel();
		} else {
			toast = new Toast(context);
			toast.setDuration(Toast.LENGTH_SHORT);
			toast.setView(view);
		}
	}

	// 设置toast显示位置
	public void setGravity(int gravity, int xOffset, int yOffset) {
		toast.setGravity(gravity, xOffset, yOffset);
	}

	// 设置toast显示时间
	public void setDuration(int duration) {
		toast.setDuration(duration);
	}

	// 设置toast显示时间(自定义时间)
	public void setLongTime(int duration) {
		time = duration;
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (time - 1000 >= 0) {
					show();
					time = time - 1000;
				} else {
					timer.cancel();
				}
			}
		}, 0, 1000);
	}
	//显示toast
	public void show() {
		if (toast != null) {
			toast.show();
		}
	}
	//取消toast
	public void cancel() {
		if (toast != null) {
			toast.cancel();
		}
	}
}
