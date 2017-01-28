package com.lxy.salesys.dao;

import org.springframework.stereotype.Repository;

import com.lxy.salesys.pojo.Good;

@Repository
public interface GoodDao {
	/**
	 * 
	 * @Title: insertGood 
	 * @Description: 插入一个新商品
	 * @param @param good
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insertGood(Good good);
}
