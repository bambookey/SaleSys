package com.lxy.salesys.service;

import java.util.ArrayList;


import com.lxy.salesys.pojo.ShoppingRecord;

public interface IShoppingRecordService {
	
	/**
	 * 
	 * @Title: insertShoppingRecords 
	 * @Description: 批量插入购物记录
	 * @param @param shoppingRecords
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insertShoppingRecords(ArrayList<ShoppingRecord> shoppingRecords);
}
