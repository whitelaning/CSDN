package com.zack.framework.activity;

import com.zack.csdn.R;
import com.zack.csdn.tool.ActivityCollectorTool;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class BaseFragmentActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityCollectorTool.addActivity(this);
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
		ActivityCollectorTool.removeActivity(this);
	}

	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		overridePendingTransition(R.anim.activity_translate_right_in, R.anim.activity_translate_right_out);
	}

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
