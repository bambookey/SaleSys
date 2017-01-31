package com.lxy.salesys.dao;

import java.util.ArrayList;

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
	/**
	 * 
	 * @Title: selectAllGoods 
	 * @Description: 查出所有的商品
	 * @param @return    设定文件 
	 * @return ArrayList<Good>    返回类型 
	 * @throws
	 */
	public ArrayList<Good> selectAllGoods();
	/**
	 * 
	 * @Title: selectGoodById 
	 * @Description: 根据id查找Good
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Good    返回类型 
	 * @throws
	 */
	public Good selectGoodById(int id);
	
	/**
	 * 
	 * @Title: updateGoodById 
	 * @Description: 根据id更新商品
	 * @param @param good
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int updateGoodById(Good good);
}
