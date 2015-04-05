package com.zack.csdn.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	private static final String DB_NAME = "zack_csdn";
	public static final String TABLE_INFOS_NAME = "infos";
	private static final String CREAT_TABLE_INFOS = 
			"create table "+ TABLE_INFOS_NAME + "(" +
			"_id integer primary key autoincrement," +
			"title text," + 
			"link text," +
			"date text," +
			"imgLink text," +
			"content text," + 
			"infoType integer);";
			
	public DBHelper(Context context) {
		super(context, DB_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREAT_TABLE_INFOS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}
