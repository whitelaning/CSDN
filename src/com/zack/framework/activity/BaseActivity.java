package com.zack.framework.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.zack.csdn.R;
import com.zack.csdn.control.ThemeControl;
import com.zack.csdn.tool.ActivityCollectorTool;

public class BaseActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityCollectorTool.addActivity(this);// Activity初始化时，加入AcitivityCollector的List中
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityCollectorTool.removeActivity(this);// Activity被销毁时，在AcitivityCollector的List中移除
	}

	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		overridePendingTransition(R.anim.activity_translate_right_in, R.anim.activity_translate_right_out);
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		super.startActivityForResult(intent, requestCode);
		overridePendingTransition(R.anim.activity_translate_right_in, R.anim.activity_translate_right_out);
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(R.anim.activity_translate_right_close_in, R.anim.activity_translate_right_close_out);
	}
}
