package com.lxy.salesys.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.lxy.salesys.pojo.ShoppingRecord;

@Repository
public interface ShoppingRecordDao {
	
	/**
	 * 
	 * @Title: insertShoppingRecords 
	 * @Description: 批量插入购物车记录
	 * @param @param shoppingRecords
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insertShoppingRecords(ArrayList<ShoppingRecord> shoppingRecords);
}
