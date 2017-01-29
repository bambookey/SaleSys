package com.lxy.salesys.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.lxy.salesys.pojo.Trolley;

@Repository
public interface TrolleyDao {
	
	/**
	 * 
	 * @Title: insertTrolley 
	 * @Description: 插入一条购物车记录
	 * @param @param trolley
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insertTrolley(Trolley trolley);
	
	/**
	 * 
	 * @Title: getTrolleysByUserId 
	 * @Description: 根据用户id查找用户的购物车记录
	 * @param @param id
	 * @param @return    设定文件 
	 * @return ArrayList<Trolley>    返回类型 
	 * @throws
	 */
	public ArrayList<Trolley> getTrolleysByUserId(int id);
}
