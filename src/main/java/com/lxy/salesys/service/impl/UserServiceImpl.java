package com.lxy.salesys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.salesys.dao.UserDao;
import com.lxy.salesys.pojo.User;
import com.lxy.salesys.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserDao userDao;
	
	public User userLogin(User u) {
		User user = null;
		return user;
	}

	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
		//return null;
	}

}
