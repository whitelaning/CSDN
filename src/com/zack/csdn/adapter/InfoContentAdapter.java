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
	private LayoutInflater mInflater;// ������
	private List<Infos> infoDataList = new ArrayList<Infos>();
	private ImageLoader imageLoader = ImageLoader.getInstance();// ��ImageLoader������ͼƬ
	public InfoContentAdapter(Context context) {
		mInflater = LayoutInflater.from(context);// ��ȡ������ʵ�������ڼ���view
	}

	/**
	 * �������ݵ�������������list��
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
	 * �� ListView Ҫ��ʾĳһ��ʱ��getItemViewType ���������ã����ݷ���ֵ�� mRecycler �����õ��������ͼ��
	 * ��Ҳ��Ϊʲô getViewTypeCount ����ֵҪ�ȶ������ͼ���ͳ���ֵ���ԭ�򣬷���ᵼ������Խ���쳣��
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
	 * �� ListView �ĸ��� AbsListView �У���һ������ RecycleBin mRecycler �����洢ĳһ��ʾ��ֶ�Ӧ����ͼ��
	 * ʵ�ʴ洢�� ArrayList<View>[]�У�������ĳ���Ϊ getViewTypeCount �ķ���ֵ��
	 * RecycleBin �� AbsListView ��һ���ڲ��ࡣ
	 * �� ListView ִ�� setAdapter ����ʱ��mRecycler �����ã�getViewTypeCount �����ᱻ���á�       
	 */
	@Override
	public int getViewTypeCount() {
		return 5; //��Ϊ���ǵ���Ĳ����ļ���5�����������ﷵ��5
	}
	/**
	 * ��д isEnabled ������ֻ��ͼƬ���Ե��
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
		Infos info = infoDataList.get(position); // ��ȡ��ǰ������
		ViewHolder holder = null;
		if (null == convertView) {
			holder = new ViewHolder();
			switch (info.getType()) { // ���ݲ�ͬ�����������ز�ͬ�Ĳ���չʾҳ��
			case Constant.TITLE:// �������ݣ��ñ��Ⲽ����ʾ
				convertView = mInflater.inflate(R.layout.info_content_title_item, parent, false);
				holder.textView = (TextView) convertView.findViewById(R.id.text);
				break;
			case Constant.SUMMARY:// ��Ҫ���ݣ��ø�Ҫ������ʾ
				convertView = mInflater.inflate(R.layout.info_content_summary_item, parent, false);
				holder.textView = (TextView) convertView.findViewById(R.id.text);
				break;
			case Constant.CONTENT:// �������ݣ������ݲ�����ʾ
				convertView = mInflater.inflate(R.layout.info_content_item, parent, false);
				holder.textView = (TextView) convertView.findViewById(R.id.text);
				break;
			case Constant.IMG:// ͼƬ���ݣ���ͼƬ������ʾ
				convertView = mInflater.inflate(R.layout.info_content_img_item, parent, false);
				holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
				break;
			case Constant.BOLD_TITLE:// �Ӵֱ������ݣ��üӴֱ��Ⲽ����ʾ
				convertView = mInflater.inflate(R.layout.info_content_bold_title_item, parent, false);
				holder.textView = (TextView) convertView.findViewById(R.id.text);
				break;
			}
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// ��������������������
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
				// ��\u3000���ǿո����˼
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
