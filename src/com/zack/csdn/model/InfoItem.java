package com.zack.csdn.model;

public class InfoItem {
	private int id;// Ψһ��ʶ
	private String title; // ����
	private String link; // ����
	private String date; // ��������
	private String imgLink;// ͼƬ������
	private String content;// ����
	private int infoType;// ����

	public int getInfoType() {
		return infoType;
	}

	public void setInfoType(int newsType) {
		this.infoType = newsType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getImgLink() {
		return imgLink;
	}

	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "InfoItem [id=" + id + ", title=" + title + ", link=" + link + ", date=" + date + ", imgLink=" + imgLink + ", content=" + content + ", infoType=" + infoType + "]";
	}
}
