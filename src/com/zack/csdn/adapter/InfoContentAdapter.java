package com.zack.csdn.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.zack.csdn.R;
import com.zack.csdn.control.Constant;
import com.zack.csdn.control.ImageLoaderControl;
import com.zack.csdn.model.Infos;
import com.zack.csdn.tool.LogTool;

public class InfoContentAdapter extends BaseAdapter {
	private static final String tag = "InfoContentAdapter";
	private LayoutInflater mInflater;// 加载器
	private List<Infos> infoDataList = new ArrayList<Infos>();
	private ImageLoader imageLoader = ImageLoader.getInstance();// 用ImageLoader来加载图片
	public InfoContentAdapter(Context context) {
		mInflater = LayoutInflater.from(context);// 获取加载器实例，用于加载view
	}

	/**
	 * 加载数据到适配器的数据list中
	 * @param datas
	 */
	public void addList(List<Infos> infoDatas) {
		infoDataList.addAll(infoDatas);
		LogTool.e(tag, "addList,infoDataList.size() = " + infoDataList.size());
	}

	@Override
	public int getCount() {
		return infoDataList.size();
	}

	@Override
	public Object getItem(int position) {
		return infoDataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	/**
	 * 当 ListView 要显示某一项时，getItemViewType 方法被调用，根据返回值在 mRecycler 搜索得到缓存的视图。
	 * 这也是为什么 getViewTypeCount 返回值要比定义的视图类型常量值大的原因，否则会导致数组越界异常。
	 */
	@Override
	public int getItemViewType(int position) {
		switch (infoDataList.get(position).getType()) {
		case Constant.TITLE:
			return Constant.TITLE - 1;
		case Constant.SUMMARY:
			return Constant.SUMMARY - 1;
		case Constant.CONTENT:
			return Constant.CONTENT - 1;
		case Constant.IMG:
			return Constant.IMG - 1;
		case Constant.BOLD_TITLE:
			return Constant.BOLD_TITLE - 1;
		}
		return -1;
	}
	/**
	 * 在 ListView 的父类 AbsListView 中，有一个变量 RecycleBin mRecycler 用来存储某一显示项布局对应的视图。
	 * 实际存储在 ArrayList<View>[]中，该数组的长度为 getViewTypeCount 的返回值。
	 * RecycleBin 是 AbsListView 的一个内部类。
	 * 当 ListView 执行 setAdapter 方法时，mRecycler 会重置，getViewTypeCount 方法会被调用。       
	 */
	@Override
	public int getViewTypeCount() {
		return 5; //因为我们导入的布局文件有5个，所以这里返回5
	}
	/**
	 * 重写 isEnabled 方法，只有图片可以点击
	 */
	@Override
	public boolean isEnabled(int position) {
		switch (infoDataList.get(position).getType()) {
		case Constant.IMG:
			return true;
		default:
			return false;
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Infos info = infoDataList.get(position); // 获取当前项数据
		ViewHolder holder = null;
		if (null == convertView) {
			holder = new ViewHolder();
			switch (info.getType()) { // 根据不同的类型来加载不同的布局展示页面
			case Constant.TITLE:// 标题数据，用标题布局显示
				convertView = mInflater.inflate(R.layout.info_content_title_item, parent, false);
				holder.textView = (TextView) convertView.findViewById(R.id.text);
				break;
			case Constant.SUMMARY:// 概要数据，用概要布局显示
				convertView = mInflater.inflate(R.layout.info_content_summary_item, parent, false);
				holder.textView = (TextView) convertView.findViewById(R.id.text);
				break;
			case Constant.CONTENT:// 内容数据，用内容布局显示
				convertView = mInflater.inflate(R.layout.info_content_item, parent, false);
				holder.textView = (TextView) convertView.findViewById(R.id.text);
				break;
			case Constant.IMG:// 图片数据，用图片布局显示
				convertView = mInflater.inflate(R.layout.info_content_img_item, parent, false);
				holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
				break;
			case Constant.BOLD_TITLE:// 加粗标题数据，用加粗标题布局显示
				convertView = mInflater.inflate(R.layout.info_content_bold_title_item, parent, false);
				holder.textView = (TextView) convertView.findViewById(R.id.text);
				break;
			}
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// 根据数据类型设置数据
		if (null != info) {
			switch (info.getType()) {
			case Constant.IMG:
				imageLoader.displayImage(info.getImageLink(), holder.imageView, ImageLoaderControl.options);
				break;
			case Constant.TITLE:
				holder.textView.setText(info.getTitle());
				break;
			case Constant.SUMMARY:
				holder.textView.setText(info.getSummary());
				break;
			case Constant.CONTENT:
				// “\u3000”是空格的意思
				holder.textView.setText("\u3000\u3000" + Html.fromHtml(info.getContent()));
				break;
			case Constant.BOLD_TITLE:
				holder.textView.setText("\u3000\u3000" + Html.fromHtml(info.getContent()));
			default:
				break;
			}
		}
		return convertView;
	}

	private static final class ViewHolder {
		private TextView textView;
		private ImageView imageView;
	}
}
