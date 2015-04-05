package com.zack.csdn.util;

import com.zack.csdn.control.Constant;

public class URLUtil {

	public static String getUrl(int newsType, int currentPage) {
		currentPage = currentPage > 0 ? currentPage : 1;
		String urlStr = "";
		switch (newsType) {
		case Constant.TYPE_NEWS:
			urlStr = Constant.URL_NEWS;
			break;
		case Constant.TYPE_MOBILE:
			urlStr = Constant.URL_MOBILE;
			break;
		case Constant.TYPE_SD:
			urlStr = Constant.URL_SD;
			break;
		case Constant.TYPE_PROGRAMMER:
			urlStr = Constant.URL_PROGRAMMER;
			break;
		case Constant.TYPE_CLOUD:
			urlStr = Constant.URL_CLOUD;
			break;
		}

		urlStr += "/" + currentPage;

		return urlStr;

	}
}
