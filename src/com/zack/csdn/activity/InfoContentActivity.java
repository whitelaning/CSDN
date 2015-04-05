package com.zack.csdn.activity;

import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.extra.xlistview.XListView;
import com.zack.csdn.CSDN;
import com.zack.csdn.R;
import com.zack.csdn.adapter.InfoContentAdapter;
import com.zack.csdn.control.ThemeControl;
import com.zack.csdn.model.Infos;
import com.zack.csdn.model.InfosDto;
import com.zack.csdn.tool.LogTool;
import com.zack.csdn.tool.NetworkTool;
import com.zack.csdn.util.InfoItemHandle;
import com.zack.csdn.util.ToastUtil;
import com.zack.framework.activity.BaseActivity;

public class InfoContentActivity extends BaseActivity {
	private static final String tag = "InfoContentActivity";
	private XListView xListView;
	private InfoItemHandle infoItemBiz;
	private List<Infos> dataList;
	private ProgressBar progressBar;
	private InfoContentAdapter infoContentAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		LogTool.e(tag, "onCreate");
		ThemeControl.onActivityCreateSetTheme(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_content_activity);
		initView();
		initData();
	}

	private void initData() {
		infoItemBiz = new InfoItemHandle();
		infoContentAdapter = new InfoContentAdapter(this);

		xListView.setAdapter(infoContentAdapter);// 设置内容数据
		xListView.disablePullRefreash();// 不显示下拉更新
		xListView.disablePullLoad();// 不显示加载更多
		xListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// 打开大图
				ImageShowActivity.startImageShowActivity(InfoContentActivity.this, dataList.get(position - 1).getImageLink());
			}
		});

		progressBar.setVisibility(View.VISIBLE);// 准备加载数据显示进度圈
		if (NetworkTool.checkNetState(this)) {
			new LoadDataTask().execute();// 加载内容
		} else {
			ToastUtil.show(this, getString(R.string.without_the_internet) + "!");
			finish();
		}
	}

	private void initView() {
		xListView = (XListView) findViewById(R.id.xlistView);
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		findViewById(R.id.back).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	class LoadDataTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			try {
				String url = getIntent().getExtras().getString("url");// 获取点击的url
				LogTool.e(tag, "LoadDataTask,url = " + url);
				InfosDto infosDto = infoItemBiz.getInfos(url);// 根据url加载内容
				dataList = infosDto.getInfoList();// 获取资讯信息列表
				LogTool.e(tag, "LoadDataTask,dataList.size() = " + dataList.size());
			} catch (Exception e) {
				Looper.prepare();
				Toast.makeText(CSDN.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
				Looper.loop();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			LogTool.e(tag, "onPostExecute,dataList.size() = " + dataList.size());
			if (dataList == null) {
				return;// 下载的数据为空时
			} else {
				infoContentAdapter.addList(dataList);// 将下载到的数据加载到适配器中
				infoContentAdapter.notifyDataSetChanged();// 通知刷新数据
				progressBar.setVisibility(View.GONE);// 隐藏进度
				LogTool.e(tag, "onPostExecute,infoContentAdapter.notifyDataSetChanged()");
			}
		}
	}
}
