package com.lxy.salesys.service;

import com.lxy.salesys.pojo.User;

public interface IUserService {
	
	/**
	 * 
	 * @Title: userLogin 
	 * @Description: 用户登录用方法，登录成功返回用户对象，失败返回null
	 * @param @param u
	 * @param @return    设定文件 
	 * @return User    返回类型 
	 * @throws
	 */
	public User userLogin(User u);
	
	/**
	 * 
	 * @Title: getUserByUserName 
	 * @Description: 根据用户名返回用户对象，没有对象返回null
	 * @param @param userName
	 * @param @return    设定文件 
	 * @return User    返回类型 
	 * @throws
	 */
	public User getUserByUserName(String userName);
}
