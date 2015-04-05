package com.zack.csdn.control;

public class Constant {
	//����ģʽ����
	public static final boolean isDebug = true;
	
	public static final int LOAD_MORE = 0x10001;// ���ظ����ʶ
	public static final int LOAD_REFREASH = 0x10002;// ����ˢ�±�ʶ

	// ������ Start
	public static final int ERROR_NO_NETWORK = 0X10003;// û�������ʶ
	public static final int ERROR_SERVER = 0X10004;// �����������ʶ
	// ������ End

	// ��Ѷ��ʶ���� Start
	public static final int TYPE_NEWS = 1;// ҵ����Ѷ��ʶ
	public static final int TYPE_MOBILE = 2;// �ƶ���Ѷ��ʶ
	public static final int TYPE_CLOUD = 3;// �Ƽ�����Ѷ��ʶ
	public static final int TYPE_SD = 4;// ����з���Ѷ��ʶ
	public static final int TYPE_PROGRAMMER = 5;// ����Ա��Ѷ��ʶ
	// ��Ѷ��ʶ���� End

	// ��Ѷ��ַ���� Start
	public static final String URL_NEWS = "http://news.csdn.net/news";// ҵ��
	public static final String URL_MOBILE = "http://mobile.csdn.net/mobile";// �ƶ�
	public static final String URL_CLOUD = "http://cloud.csdn.net/cloud";// �Ƽ���
	public static final String URL_SD = "http://sd.csdn.net/sd";// ����з�
	public static final String URL_PROGRAMMER = "http://programmer.csdn.net/programmer";// ����Ա

	// ��Ѷ��ַ���� End

	// ��ѶType��ʶ���� Start
	public static final int TITLE = 1;
	public static final int SUMMARY = 2;
	public static final int CONTENT = 3;
	public static final int IMG = 4;
	public static final int BOLD_TITLE = 5;
	// ��ѶType��ʶ���� End
}
