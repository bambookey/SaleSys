package com.lxy.salesys.service;

import com.lxy.salesys.pojo.Good;

public interface IGoodService {
	
	/**
	 * 
	 * @Title: insertGood 
	 * @Description: 插入一个新商品，返回受影响行数
	 * @param @param good
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insertGood(Good good);
}
