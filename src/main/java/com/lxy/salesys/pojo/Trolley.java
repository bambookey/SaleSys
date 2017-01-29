package com.lxy.salesys.pojo;

import java.sql.Timestamp;

public class Trolley {
	private Integer id;
	private Integer userId;
	private Integer goodId;
	private Integer status;
	private Timestamp insertDatetime;

	public Trolley() {
	}

	public Trolley(Integer userId, Integer goodId, Integer status, Timestamp insertDatetime) {
		this.userId = userId;
		this.goodId = goodId;
		this.status = status;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getInsertDatetime() {
		return insertDatetime;
	}

	public void setInsertDatetime(Timestamp insertDatetime) {
		this.insertDatetime = insertDatetime;
	}

}
