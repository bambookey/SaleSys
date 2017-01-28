package com.lxy.salesys.dao;

import org.springframework.stereotype.Repository;

import com.lxy.salesys.pojo.User;

@Repository
public interface UserDao {
	public User getUserByUserName(String userName);
}
