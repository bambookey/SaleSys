package com.lxy.salesys.service;

import com.lxy.salesys.pojo.User;

public interface IUserService {
	
	public User userLogin(User u);
	
	public User getUserByUserName(String userName);
}
