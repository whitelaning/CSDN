package com.zack.csdn.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.extra.gesture.GestureImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zack.csdn.R;
import com.zack.csdn.control.ImageLoaderControl;
import com.zack.framework.activity.BaseActivity;

public class ImageShowActivity extends BaseActivity {

	private String url;// 图片的链接
	private GestureImageView gestureImageView;
	private ImageLoader imageLoader = ImageLoader.getInstance();

	public static void startImageShowActivity(Context context, String imageLink) {
		Intent intent = new Intent(context, ImageShowActivity.class);
		intent.putExtra("url", imageLink);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_show_activity);
		initView();
		initData();
	}

	private void initData() {
		url = getIntent().getExtras().getString("url");// 图片的链接
		imageLoader.displayImage(url, gestureImageView, ImageLoaderControl.options);
	}

	private void initView() {
		gestureImageView = (GestureImageView) findViewById(R.id.gestureImageView);
		findViewById(R.id.back).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
