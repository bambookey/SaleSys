package com.lxy.salesys.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.salesys.dao.TrolleyDao;
import com.lxy.salesys.pojo.Trolley;
import com.lxy.salesys.service.ITrolleyService;

/**
 * 
 * @ClassName: GoodServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017年1月28日 下午9:26:34 
 *
 */
@Service("trolleyService")
public class TrolleyServiceImpl implements ITrolleyService{

	@Autowired
	TrolleyDao trolleyDao;

	public int insertTrolley(Trolley trolley) {
		return trolleyDao.insertTrolley(trolley);
	}

	public ArrayList<Trolley> getTrolleysByUserId(int id) {
		return trolleyDao.getTrolleysByUserId(id);
	}
}
