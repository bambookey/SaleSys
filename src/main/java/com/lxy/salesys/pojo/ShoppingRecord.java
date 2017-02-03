package com.lxy.salesys.pojo;

import java.sql.Timestamp;

public class ShoppingRecord {

	private Integer id;
	private Integer userId;
	private Integer goodId;
	private Integer goodAmount;
	private Double totalMoney;
	private Timestamp insertDatetime;
	
	public ShoppingRecord() {}
	public ShoppingRecord(Integer userId, Integer goodId, Integer goodAmount, Double totalMoney, Timestamp insertDatetime) {
		this.userId = userId;
		this.goodId = goodId;
		this.goodAmount = goodAmount;
		this.totalMoney = totalMoney;
		this.insertDatetime = insertDatetime;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGoodId() {
		return goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public Integer getGoodAmount() {
		return goodAmount;
	}

	public void setGoodAmount(Integer goodAmount) {
		this.goodAmount = goodAmount;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Timestamp getInsertDatetime() {
		return insertDatetime;
	}

	public void setInsertDatetime(Timestamp insertDatetime) {
		this.insertDatetime = insertDatetime;
	}

}
