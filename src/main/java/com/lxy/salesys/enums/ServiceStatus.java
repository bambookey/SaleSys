package com.lxy.salesys.enums;

public enum ServiceStatus {

	SUCCESS("成功", 0), 
	SUCCESS3("", 0);

	private String name;
	private int index;

	ServiceStatus(String name, int index) {
		this.name = name;
		this.index = index;
	}
}
