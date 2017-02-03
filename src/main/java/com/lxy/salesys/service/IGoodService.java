package com.lxy.salesys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	/**
	 * 
	 * @Title: selectAllGoods 
	 * @Description: 获取全部商品
	 * @param @return    设定文件 
	 * @return ArrayList<Good>    返回类型 
	 * @throws
	 */
	public ArrayList<Good> selectAllGoods();
	
	/**
	 * 
	 * @Title: selectGoodById 
	 * @Description: 根据id查找商品
	 * @param @return    设定文件 
	 * @return Good    返回类型 
	 * @throws
	 */
	public Good selectGoodById(int id);
	
	/**
	 * 
	 * @Title: selectGoodsByIds 
	 * @Description: 根据Id集合批量返回多个商品
	 * @param @param goodIds
	 * @param @return    设定文件 
	 * @return ArrayList<Good>    返回类型 
	 * @throws
	 */
	public ArrayList<Good> selectGoodsByIds(List<Integer> list);
	
	/**
	 * 
	 * @Title: selectGoodsMapByIds 
	 * @Description: 根据Id集合批量返回多个商品的map
	 * @param @param list
	 * @param @return    设定文件 
	 * @return HashMap<Integer,Good>    返回类型 
	 * @throws
	 */
	public HashMap<Integer, Good> selectGoodsMapByIds(List<Integer> list);
	
	/**
	 * 
	 * @Title: updateGoodByI 
	 * @Description: 根据id更新商品
	 * @param @param good
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int updateGoodById(Good good);
}
