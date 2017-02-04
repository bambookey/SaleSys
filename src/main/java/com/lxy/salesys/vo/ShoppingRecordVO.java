package com.lxy.salesys.vo;

import java.sql.Timestamp;

public class ShoppingRecordVO {
	private Integer goodId;
	private String goodName;
	private String imgPath;
	private Double goodPrize;
	private Double totalPrize;
	private Integer goodCnt;
	private Timestamp insertDatetime;
	
	public ShoppingRecordVO() {}
	/**
	 * 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param goodId
	 * @param goodName
	 * @param imgPath
	 * @param goodPrize
	 * @param totalPrize
	 * @param goodCnt
	 * @param insertDatetime
	 */
	public ShoppingRecordVO(Integer goodId, String goodName, String imgPath, Double goodPrize, Double totalPrize, 
			Integer goodCnt, Timestamp insertDatetime) {
		this.goodId = goodId;
		this.goodName = goodName;
		this.imgPath = imgPath;
		this.goodPrize = goodPrize;
		this.totalPrize = totalPrize;
		this.goodCnt = goodCnt;
		this.insertDatetime = insertDatetime;
	}
	
	public Integer getGoodId() {
		return goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Double getGoodPrize() {
		return goodPrize;
	}

	public void setGoodPrize(Double goodPrize) {
		this.goodPrize = goodPrize;
	}

	public Double getTotalPrize() {
		return totalPrize;
	}

	public void setTotalPrize(Double totalPrize) {
		this.totalPrize = totalPrize;
	}

	public Integer getGoodCnt() {
		return goodCnt;
	}

	public void setGoodCnt(Integer goodCnt) {
		this.goodCnt = goodCnt;
	}

	public Timestamp getInsertDatetime() {
		return insertDatetime;
	}

	public void setInsertDatetime(Timestamp insertDatetime) {
		this.insertDatetime = insertDatetime;
	}

}
