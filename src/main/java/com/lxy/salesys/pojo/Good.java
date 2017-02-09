package com.lxy.salesys.pojo;

import java.sql.Timestamp;

public class Good {
	private Integer id;
	private String title;
	private String summary;
	private String text;
	private String imgPath;
	private Double prize;
	private Boolean isDeleted;
	private Timestamp updateDatetime;

	public Good() {
	}
	
	public Good(String title, String summary, String text, String imgPath, Double prize, Boolean isDeleted, Timestamp updateDatetime) {
		this.title = title;
		this.summary = summary;
		this.text = text;
		this.imgPath = imgPath;
		this.prize = prize;
		this.isDeleted = isDeleted;
		this.updateDatetime = updateDatetime;
	}
	
	public Good(Integer id, String title, String summary, String text, String imgPath, Double prize, Boolean isDeleted, Timestamp updateDatetime) {
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.text = text;
		this.imgPath = imgPath;
		this.prize = prize;
		this.isDeleted = isDeleted;
		this.updateDatetime = updateDatetime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Double getPrize() {
		return prize;
	}

	public void setPrize(Double prize) {
		this.prize = prize;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

}
