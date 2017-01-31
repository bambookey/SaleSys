package com.lxy.salesys.pojo;

public class Good {
	private Integer id;
	private String title;
	private String summary;
	private String text;
	private String imgPath;
	private Double prize;
	private Boolean isAvailable;

	public Good() {
	}
	
	public Good(String title, String summary, String text, String imgPath, Double prize) {
		this.title = title;
		this.summary = summary;
		this.text = text;
		this.imgPath = imgPath;
		this.prize = prize;
	}
	
	public Good(Integer id, String title, String summary, String text, String imgPath, Double prize) {
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.text = text;
		this.imgPath = imgPath;
		this.prize = prize;
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

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
