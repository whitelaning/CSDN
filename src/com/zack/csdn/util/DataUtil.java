package com.zack.csdn.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataUtil {
	public static String doGet(String urlStr) throws Exception {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.1.9) Gecko/20100315 Firefox/3.5.9");
			if (conn.getResponseCode() == 200) {// ≥…π¶
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				int len = 0;
				char[] buf = new char[1024];

				while ((len = isr.read(buf)) != -1) {
					sb.append(new String(buf, 0, len));
				}

				is.close();
				isr.close();
				conn.disconnect();
			} else {
				throw new Exception("∑√Œ Õ¯¬Á ß∞‹£°");
			}
		} catch (Exception e) {
			throw new Exception("∑√Œ Õ¯¬Á ß∞‹£°");
		}
		return sb.toString();
	}
}
