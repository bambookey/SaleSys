package com.lxy.salesys.service;

import java.util.ArrayList;

import com.lxy.salesys.pojo.Trolley;

public interface ITrolleyService {
	
	/**
	 * 
	 * @Title: insertTrolley 
	 * @Description: 插入购物车记录
	 * @param @param trolley
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int insertTrolley(Trolley trolley);
	
	/**
	 * 
	 * @Title: getTrolleysByUserId 
	 * @Description: 根据用户ID获取购物车记录
	 * @param @param id
	 * @param @return    设定文件 
	 * @return ArrayList<Trolley>    返回类型 
	 * @throws
	 */
	public ArrayList<Trolley> getTrolleysByUserId(int id);
	/**
	 * 
	 * @Title: checkTrolley 
	 * @Description: 查看trolley是否有重复，返回符合重复要求的行数
	 * @param @param trolley
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	public int checkTrolley(Trolley trolley);
}
