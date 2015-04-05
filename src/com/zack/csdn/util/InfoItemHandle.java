package com.zack.csdn.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.zack.csdn.model.InfoItem;
import com.zack.csdn.model.Infos;
import com.zack.csdn.model.InfosDto;
import com.zack.csdn.tool.StringTool;

/**
 * 处理InfoItem的业务类
 */
public class InfoItemHandle {
	public List<InfoItem> getInfosItems(int infosType, int currentPage) throws Exception {
		String urlStr = URLUtil.getUrl(infosType, currentPage);// 获取地址
		String htmlStr = DataUtil.doGet(urlStr);// 获取数据

		List<InfoItem> infosItems = new ArrayList<InfoItem>();
		InfoItem infosItem = null;

		Document doc = Jsoup.parse(htmlStr);// 解析html数据
		Elements units = doc.getElementsByClass("unit");
		for (int i = 0; i < units.size(); i++) {
			infosItem = new InfoItem();
			infosItem.setInfoType(infosType);

			Element unit_ele = units.get(i);

			Element h1_ele = unit_ele.getElementsByTag("h1").get(0);
			Element h1_a_ele = h1_ele.child(0);

			String title = StringTool.ToDBC(h1_a_ele.text());
			String href = h1_a_ele.attr("href");

			infosItem.setLink(href);
			infosItem.setTitle(title);

			Element h4_ele = unit_ele.getElementsByTag("h4").get(0);
			Element ago_ele = h4_ele.getElementsByClass("ago").get(0);
			String date = ago_ele.text();

			infosItem.setDate(date);

			Element dl_ele = unit_ele.getElementsByTag("dl").get(0);
			Element dt_ele = dl_ele.child(0);

			try {
				Element img_ele = dt_ele.child(0);
				String imgLink = img_ele.child(0).attr("src");
				infosItem.setImgLink(imgLink);
			} catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {

			}

			Element content_ele = dl_ele.child(1);
			String content = StringTool.ToDBC(content_ele.text());
			infosItem.setContent(content);
			infosItems.add(infosItem);
		}
		return infosItems;
	}

	public InfosDto getInfos(String urlStr) throws Exception {
		InfosDto infosDto = new InfosDto();
		List<Infos> infosList = new ArrayList<Infos>();
		String htmlStr = DataUtil.doGet(urlStr);
		Document doc = Jsoup.parse(htmlStr);

		Element detailEle = doc.select(".left .detail").get(0);

		Element titleEle = detailEle.select("h1.title").get(0);
		Infos infos = new Infos();
		infos.setTitle(titleEle.text());
		infos.setType(1);
		infosList.add(infos);

		Element summaryEle = detailEle.select("div.summary").get(0);
		infos = new Infos();
		infos.setSummary(summaryEle.text());
		infosList.add(infos);

		Element contentEle = detailEle.select("div.con.news_content").get(0);
		Elements childrenEle = contentEle.children();

		for (Element child : childrenEle) {
			Elements imgEles = child.getElementsByTag("img");

			if (imgEles.size() > 0) {
				for (Element imgEle : imgEles) {
					if (imgEle.attr("src").equals(""))
						continue;
					infos = new Infos();
					infos.setImageLink(imgEle.attr("src"));
					infosList.add(infos);
				}
			}

			imgEles.remove();

			if (child.text().equals("")) {
				continue;
			}
			infos = new Infos();
			infos.setType(3);
			try {
				if (child.children().size() == 1) {
					Element cc = child.child(0);
					if (cc.tagName().equals("b")) {
						infos.setType(5);
					}
				}
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}
			infos.setContent(child.outerHtml());
			infosList.add(infos);
		}
		infosDto.setInfoList(infosList);
		return infosDto;
	}
}
