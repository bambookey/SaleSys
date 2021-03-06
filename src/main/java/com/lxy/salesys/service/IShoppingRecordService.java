package com.lxy.salesys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	/**
	 * 
	 * @Title: selectShoppingRecordsByUserId 
	 * @Description: 根据用户ID提取用户消费记录，按时间从近到远排序
	 * @param @param userId
	 * @param @return    设定文件 
	 * @return ArrayList<ShoppingRecord>    返回类型 
	 * @throws
	 */
	public ArrayList<ShoppingRecord> selectShoppingRecordsByUserId(Integer userId);
	
	/**
	 * 
	 * @Title: selectShoppingGoodAmount 
	 * @Description: 查出商品id和售出量的kv LIST
	 * @param @return    设定文件 
	 * @return List<Map<Integer,Integer>>    返回类型 
	 * @throws
	 */
	public List<Map<Integer, Integer>> selectShoppingGoodAmount();
	
	/**
	 * 
	 * @Title: selectShoppingGoodAmountMap 
	 * @Description: 查出商品id和售出量的kv  k:goodId, v:soldCnt
	 * @param @return    设定文件 
	 * @return Map<Integer,Integer>    返回类型 
	 * @throws
	 */
	public Map<Integer, Integer> selectShoppingGoodAmountMap();
}
