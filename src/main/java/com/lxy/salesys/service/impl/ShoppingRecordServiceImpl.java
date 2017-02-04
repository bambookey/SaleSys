package com.lxy.salesys.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.salesys.dao.ShoppingRecordDao;
import com.lxy.salesys.pojo.ShoppingRecord;
import com.lxy.salesys.service.IShoppingRecordService;

/**
 * 
 * @ClassName: ShoppingRecordServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017年2月3日 下午9:06:57 
 *
 */
@Service("shoppingRecordService")
public class ShoppingRecordServiceImpl implements IShoppingRecordService{

	@Autowired
	ShoppingRecordDao shoppingRecordDao;

	public int insertShoppingRecords(ArrayList<ShoppingRecord> shoppingRecords) {
		return shoppingRecordDao.insertShoppingRecords(shoppingRecords);
	}

	public ArrayList<ShoppingRecord> selectShoppingRecordsByUserId(Integer userId) {
		return shoppingRecordDao.selectShoppingRecordsByUserId(userId);
	}
}
