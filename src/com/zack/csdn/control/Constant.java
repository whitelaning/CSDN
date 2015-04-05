package com.zack.csdn.control;

public class Constant {
	//调试模式开关
	public static final boolean isDebug = true;
	
	public static final int LOAD_MORE = 0x10001;// 加载更多标识
	public static final int LOAD_REFREASH = 0x10002;// 加载刷新标识

	// 错误常量 Start
	public static final int ERROR_NO_NETWORK = 0X10003;// 没有网络标识
	public static final int ERROR_SERVER = 0X10004;// 服务器错误标识
	// 错误常量 End

	// 资讯标识常量 Start
	public static final int TYPE_NEWS = 1;// 业界资讯标识
	public static final int TYPE_MOBILE = 2;// 移动资讯标识
	public static final int TYPE_CLOUD = 3;// 云计算资讯标识
	public static final int TYPE_SD = 4;// 软件研发资讯标识
	public static final int TYPE_PROGRAMMER = 5;// 程序员资讯标识
	// 资讯标识常量 End

	// 资讯地址常量 Start
	public static final String URL_NEWS = "http://news.csdn.net/news";// 业界
	public static final String URL_MOBILE = "http://mobile.csdn.net/mobile";// 移动
	public static final String URL_CLOUD = "http://cloud.csdn.net/cloud";// 云计算
	public static final String URL_SD = "http://sd.csdn.net/sd";// 软件研发
	public static final String URL_PROGRAMMER = "http://programmer.csdn.net/programmer";// 程序员

	// 资讯地址常量 End

	// 资讯Type标识常量 Start
	public static final int TITLE = 1;
	public static final int SUMMARY = 2;
	public static final int CONTENT = 3;
	public static final int IMG = 4;
	public static final int BOLD_TITLE = 5;
	// 资讯Type标识常量 End
}
