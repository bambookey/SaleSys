package com.lxy.salesys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.salesys.dao.UserDao;
import com.lxy.salesys.pojo.User;
import com.lxy.salesys.service.IUserService;

/**
 * 
 * @ClassName: UserServiceImpl 
 * @Description: TODO
 * @author lixiangyu
 * @date 2017年1月28日 下午8:49:38 
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserDao userDao;
	
	public User userLogin(User u) {
		User user = null;
		String userName = u.getUserName();
		String password = u.getPassword();
		
		user = getUserByUserName(userName);
		
		if(user != null && !user.getPassword().equals(password)) {
			user = null;
		}
		
		return user;
	}

	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

}
