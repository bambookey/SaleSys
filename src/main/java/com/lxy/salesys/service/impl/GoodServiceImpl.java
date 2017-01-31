package com.lxy.salesys.service.impl;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.salesys.dao.GoodDao;
import com.lxy.salesys.pojo.Good;
import com.lxy.salesys.service.IGoodService;

/**
 * 
 * @ClassName: GoodServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017年1月28日 下午9:26:34 
 *
 */
@Service("goodService")
public class GoodServiceImpl implements IGoodService{

	@Autowired
	GoodDao goodDao;
	
	public int insertGood(Good good) {
		System.out.println(good.getTitle());
		return goodDao.insertGood(good);
	}

	public ArrayList<Good> selectAllGoods() {
		return goodDao.selectAllGoods();
	}

	public Good selectGoodById(int id) {
		return goodDao.selectGoodById(id);
	}

	public int updateGoodById(Good good) {
		return goodDao.updateGoodById(good);
	}

}
