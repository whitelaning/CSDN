package com.zack.csdn.dao;

import java.util.ArrayList;
import java.util.List;
import com.zack.csdn.model.InfoItem;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class InfosItemDao {

	private DBHelper dbHelper;

	public InfosItemDao(Context context) {
		dbHelper = new DBHelper(context);
	}

	public void add(InfoItem infosItem) {
		String sql = "insert into " + DBHelper.TABLE_INFOS_NAME + "(title,link,date,imgLink,content,infoType) values(?,?,?,?,?,?) ;";
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.execSQL(sql, new Object[] { infosItem.getTitle(), infosItem.getLink(), infosItem.getDate(), infosItem.getImgLink(), infosItem.getContent(), infosItem.getInfoType() });
		db.close();
	}

	public void deleteAll(int infoType) {
		String sql = "delete from " + DBHelper.TABLE_INFOS_NAME +" where infoType = ?";
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.execSQL(sql, new Object[] { infoType });
		db.close();
	}

	public void add(List<InfoItem> infoItems) {
		for (InfoItem infoItem : infoItems) {
			add(infoItem);
		}
	}

	/**
	 * 根据infoType和currentPage取数据
	 * @param infoType
	 * @param currentPage
	 */
	public List<InfoItem> list(int infoType, int currentPage) {
		List<InfoItem> infoItems = new ArrayList<InfoItem>();
		try {
			int offset = 10 * (currentPage - 1);
			String sql = "select title,link,date,imgLink,content,infoType from " + DBHelper.TABLE_INFOS_NAME + " where infoType = ? limit ?,? ";
			SQLiteDatabase db = dbHelper.getReadableDatabase();
			Cursor c = db.rawQuery(sql, new String[] { infoType + "", offset + "", "" + (offset + 10) });

			InfoItem infoItem = null;

			while (c.moveToNext()) {
				infoItem = new InfoItem();

				String title = c.getString(0);
				String link = c.getString(1);
				String date = c.getString(2);
				String imgLink = c.getString(3);
				String content = c.getString(4);
				Integer infotype = c.getInt(5);

				infoItem.setTitle(title);
				infoItem.setLink(link);
				infoItem.setImgLink(imgLink);
				infoItem.setDate(date);
				infoItem.setInfoType(infotype);
				infoItem.setContent(content);

				infoItems.add(infoItem);

			}
			c.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return infoItems;

	}

}
