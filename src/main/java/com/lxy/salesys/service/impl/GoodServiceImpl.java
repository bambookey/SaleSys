package com.lxy.salesys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxy.salesys.dao.GoodDao;
import com.lxy.salesys.pojo.Good;
import com.lxy.salesys.service.IGoodService;

/**
 * 
 * @ClassName: GoodServiceImpl 
 * @Description: 商品服务类
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017年1月28日 下午9:26:34 
 *
 */
@Service("goodService")
public class GoodServiceImpl implements IGoodService{

	@Autowired
	GoodDao goodDao;
	
	public int insertGood(Good good) {
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

	public ArrayList<Good> selectGoodsByIds(List<Integer> goodIds) {
		return goodDao.selectGoodsByIds(goodIds);
	}

	public HashMap<Integer, Good> selectGoodsMapByIds(List<Integer> goodIds) {
		ArrayList<Good> goods = goodDao.selectGoodsByIds(goodIds);
		HashMap<Integer, Good> ret = new HashMap<Integer, Good>();
		for(Good g : goods) {
			ret.put(g.getId(), g);
		}
		return ret;
	}

	public int deleteGoodById(Integer goodId) {
		return goodDao.deleteGoodById(goodId);
	}

}
