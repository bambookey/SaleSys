package com.lxy.salesys.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lxy.salesys.pojo.Good;
import com.lxy.salesys.pojo.ShoppingRecord;
import com.lxy.salesys.service.IGoodService;
import com.lxy.salesys.service.IShoppingRecordService;

@Controller
public class ShoppingRecordController {
	
	private Logger logger = LoggerFactory.getLogger(ShoppingRecordController.class);
	
	@Autowired
	IShoppingRecordService shoppingRecordService;
	
	@Autowired
	IGoodService goodService;
	
	/**
	 * 
	 * @Title: insertShoppingRecords 
	 * @Description: 提交订单
	 * @param @param goodIds
	 * @param @param goodCnts
	 * @param @param request
	 * @param @param response
	 * @param @return    设定文件 
	 * @return JSONObject    返回类型 
	 * @throws
	 */
	@RequestMapping(value="/C/insertShoppingRecords", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject insertShoppingRecords(
			@RequestParam(value = "goodIds[]",required = false,defaultValue = "") Integer[] goodIds,
			@RequestParam(value = "goodCnts[]",required = false,defaultValue = "") Integer[] goodCnts,
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject ret = new JSONObject();
		ArrayList<ShoppingRecord> shoppingRecords = new ArrayList<ShoppingRecord>();
		HashMap<Integer, Good> goods = new HashMap<Integer, Good>();
		Integer userId = null;
		Timestamp insertDatetime = new Timestamp(System.currentTimeMillis());
		Double totalMoney = 0.0;
		goods = goodService.selectGoodsMapByIds(Arrays.asList(goodIds));
		
		
		try {
			userId =  Integer.parseInt(request.getSession().getAttribute("UserId").toString());
		} catch (Exception e) {
			logger.error("ERROR: ShoppingRecordController->insertShoppingRecords->parseInt");
			e.printStackTrace();
		}
		
		if(goodIds.length != goodCnts.length) {
			logger.error("ERROR: ShoppingRecordController->insertShoppingRecords->different array length");
		} else {
			int len = goodIds.length;
			for(int i = 0; i < len; i++) {
				int gid = goodIds[i];
				Good g = goods.get(gid);
				double prize = g.getPrize();
				ShoppingRecord shoppingRecord = new ShoppingRecord(userId, gid, goodCnts[i], prize * goodCnts[i], insertDatetime);
				shoppingRecords.add(shoppingRecord);
			}
		}
		
		try {
			shoppingRecordService.insertShoppingRecords(shoppingRecords);
		} catch (Exception e) {
			logger.error("ERROR: ShoppingRecordController->insertShoppingRecords->insertShoppingRecords");
			e.printStackTrace();
		}
		ret.put("aaa", "aa");
		return ret;
	}
}
