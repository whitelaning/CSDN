package com.zack.csdn.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.extra.xlistview.IXListViewLoadMore;
import com.extra.xlistview.IXListViewRefreshListener;
import com.extra.xlistview.XListView;
import com.zack.csdn.R;
import com.zack.csdn.activity.InfoContentActivity;
import com.zack.csdn.adapter.InfoItemAdapter;
import com.zack.csdn.control.Constant;
import com.zack.csdn.dao.InfosItemDao;
import com.zack.csdn.model.InfoItem;
import com.zack.csdn.tool.LogTool;
import com.zack.csdn.tool.NetworkTool;
import com.zack.csdn.util.InfoItemHandle;
import com.zack.csdn.util.TimeUtil;
import com.zack.csdn.util.ToastUtil;

public class MainFragment extends Fragment implements IXListViewRefreshListener, IXListViewLoadMore {
	private static final String tag = "MainFragment";
	private boolean isFirstIn = true;// �Ƿ��ǵ�һ�ν���
	private boolean isLoadingDataFromNetWork;// ��ǰ�����Ƿ��Ǵ������л�ȡ��
	private int infoType = Constant.TYPE_NEWS;// Ĭ�ϵ�Type
	private int currentPage = 1;// ��ǰҳ��
	private InfoItemHandle infoItemHandle;// �������ŵ�ҵ����
	private InfosItemDao infosItemDao;// �����ݿ⽻��
	private XListView xListView;// ��չ��ListView
	private InfoItemAdapter infoItemAdapter;// ����������
	private List<InfoItem> infoItemList = new ArrayList<InfoItem>();// ����

	public MainFragment(int infoType) {
		this.infoType = infoType;
		infoItemHandle = new InfoItemHandle();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.tab_item_fragment_main, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		LogTool.e(tag, "onActivityCreated()");
		infosItemDao = new InfosItemDao(getActivity());
		infoItemAdapter = new InfoItemAdapter(getActivity(), infoItemList);
		xListView = (XListView) getView().findViewById(R.id.xListView);
		xListView.setAdapter(infoItemAdapter);
		xListView.setPullRefreshEnable(this);
		xListView.setPullLoadEnable(this);
		xListView.setRefreshTime(TimeUtil.getRefreashTime(getActivity(), infoType));
		xListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				InfoItem infoItem = infoItemList.get(position - 1);
				Intent intent = new Intent(getActivity(), InfoContentActivity.class);
				intent.putExtra("url", infoItem.getLink());
				startActivity(intent);
			}
		});

		if (isFirstIn) {
			xListView.startRefresh();
			isFirstIn = false;
		} else {
			xListView.NotRefreshAtBegin();
		}
	}

	@Override
	public void onRefresh() {
		LogTool.e(tag, "onRefresh()");
		new LoadDatasTask().execute(Constant.LOAD_REFREASH);
	}

	@Override
	public void onLoadMore() {
		LogTool.e(tag, "onLoadMore()");
		new LoadDatasTask().execute(Constant.LOAD_MORE);
	}

	/**
	 * �������ݵ��첽����
	 */
	class LoadDatasTask extends AsyncTask<Integer, Void, Integer> {

		@Override
		protected Integer doInBackground(Integer... params) {
			switch (params[0]) {
			case Constant.LOAD_MORE:
				loadMoreData();
				break;
			case Constant.LOAD_REFREASH:
				return refreashData();
			}
			return -1;
		}

		@Override
		protected void onPostExecute(Integer result) {
			switch (result) {
			case Constant.ERROR_NO_NETWORK:
				ToastUtil.show(getActivity(), "û���������ӣ�");
				infoItemAdapter.setDatas(infoItemList);
				infoItemAdapter.notifyDataSetChanged();
				break;
			case Constant.ERROR_SERVER:
				ToastUtil.show(getActivity(), "����������");
				break;
			default:
				break;
			}
			xListView.setRefreshTime(TimeUtil.getRefreashTime(getActivity(), infoType));
			xListView.stopRefresh();
			xListView.stopLoadMore();
		}
	}

	/**
	 * ����ˢ������
	 */
	public Integer refreashData() {

		if (NetworkTool.checkNetState(getActivity())) {
			// ��ȡ��������
			try {
				List<InfoItem> inofItems = infoItemHandle.getInfosItems(infoType, currentPage);
				infoItemAdapter.setDatas(inofItems);

				isLoadingDataFromNetWork = true;
				// ����ˢ��ʱ��
				TimeUtil.setRefreashTime(getActivity(), infoType);
				// ������ݿ�����
				infosItemDao.deleteAll(infoType);
				// �������ݿ�
				infosItemDao.add(inofItems);

			} catch (Exception e) {
				e.printStackTrace();
				isLoadingDataFromNetWork = false;
				return Constant.ERROR_SERVER;
			}
		} else {
			isLoadingDataFromNetWork = false;
			// TODO�����ݿ��м���
			List<InfoItem> infoItems = infosItemDao.list(infoType, currentPage);
			infoItemList = infoItems;
			return Constant.ERROR_NO_NETWORK;
		}
		return -1;
	}

	public void loadMoreData() {
		// ��ǰ�����Ǵ������ȡ��
		if (isLoadingDataFromNetWork) {
			currentPage += 1;
			try {
				List<InfoItem> infoItems = infoItemHandle.getInfosItems(infoType, currentPage);
				infosItemDao.add(infoItems);
				infoItemAdapter.addAll(infoItems);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			// �����ݿ���ص�
			currentPage += 1;
			List<InfoItem> infoItems = infosItemDao.list(infoType, currentPage);
			infoItemAdapter.addAll(infoItems);
		}
	}
}
