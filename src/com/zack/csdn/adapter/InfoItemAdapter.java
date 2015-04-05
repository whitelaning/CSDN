package com.zack.csdn.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.zack.csdn.R;
import com.zack.csdn.control.ImageLoaderControl;
import com.zack.csdn.model.InfoItem;
import com.zack.csdn.tool.StringTool;

public class InfoItemAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private List<InfoItem> infoDatas;
	private ImageLoader imageLoader = ImageLoader.getInstance();
	public InfoItemAdapter(Context context, List<InfoItem> datas) {
		this.infoDatas = datas;
		mInflater = LayoutInflater.from(context);
	}

	public void addAll(List<InfoItem> infoDatas) {
		this.infoDatas.addAll(infoDatas);
	}

	public void setDatas(List<InfoItem> infoDatas) {
		this.infoDatas.clear();// Çå¿ÕÊý¾Ý
		this.infoDatas.addAll(infoDatas);
	}

	@Override
	public int getCount() {
		return infoDatas.size();
	}

	@Override
	public Object getItem(int position) {
		return infoDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.info_item_cell, parent, false);
			holder = new ViewHolder();
			holder.content = (TextView) convertView.findViewById(R.id.content);
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.date = (TextView) convertView.findViewById(R.id.date);
			holder.image = (ImageView) convertView.findViewById(R.id.image);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		InfoItem infoItem = infoDatas.get(position);
		holder.title.setText(StringTool.CN2EN(infoItem.getTitle()));
		holder.content.setText(StringTool.CN2EN(infoItem.getContent()));
		holder.date.setText(infoItem.getDate());
		if (infoItem.getImgLink() != null) {
			holder.image.setVisibility(View.VISIBLE);
			imageLoader.displayImage(infoItem.getImgLink(), holder.image, ImageLoaderControl.options_circle_imge);
		} else {
			holder.image.setVisibility(View.GONE);
		}

		return convertView;
	}

	private final class ViewHolder {
		private TextView title;
		private TextView content;
		private ImageView image;
		private TextView date;
	}

}
