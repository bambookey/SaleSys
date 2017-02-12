package com.lxy.salesys.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.lxy.salesys.pojo.Good;
import com.lxy.salesys.pojo.ShoppingRecord;
import com.lxy.salesys.pojo.User;
import com.lxy.salesys.service.IGoodService;
import com.lxy.salesys.service.IShoppingRecordService;
import com.lxy.salesys.service.IUserService;
import com.lxy.salesys.vo.ShoppingRecordVO;

@Controller
public class ShoppingRecordController {
	
	private Logger logger = LoggerFactory.getLogger(ShoppingRecordController.class);
	
	@Autowired
	IShoppingRecordService shoppingRecordService;
	
	@Autowired
	IGoodService goodService;
	
	@Autowired
	IUserService userService;
	
	
	/**
	 * 
	 * @Title: shoppingRecord 
	 * @Description: 消费记录页，提取消费记录信息
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/C/shoppingRecord")
	public ModelAndView shoppingRecord(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		ArrayList<ShoppingRecordVO> shoppingRecordVOList = new ArrayList<ShoppingRecordVO>();
		ArrayList<ShoppingRecord> shoppingRecordList = new ArrayList<ShoppingRecord>();
		ArrayList<Integer> goodIds = new ArrayList<Integer>();
		HashMap<Integer, Good> goods = new HashMap<Integer, Good>();
		Integer userId = request.getSession().getAttribute("UserId") == null ?
				null : Integer.parseInt(request.getSession().getAttribute("UserId").toString());
		Double totalMoney = 0.0;
		
		if(userId == null) {
			modelAndView.setViewName("login");
			return modelAndView;
		}
		
		shoppingRecordList = shoppingRecordService.selectShoppingRecordsByUserId(userId);
		
		if(shoppingRecordList != null && shoppingRecordList.size() != 0) {
			for(ShoppingRecord s : shoppingRecordList) {
				goodIds.add(s.getGoodId());
			}
			
			goods = goodService.selectGoodsMapByIds(goodIds);
			
			for(ShoppingRecord s : shoppingRecordList) {
				Good good = goods.get(s.getGoodId());
				if(good != null) {
					Integer goodId = good.getId();
					String goodName = good.getTitle();
					String imgPath = good.getImgPath();
					Double totalPrize = s.getTotalMoney();
					Integer goodCnt = s.getGoodAmount();
					Double goodPrize = totalPrize / goodCnt;
					Timestamp insertDatetime = s.getInsertDatetime();
					ShoppingRecordVO shoppingRecordVO = new ShoppingRecordVO(goodId, goodName, imgPath, goodPrize, totalPrize, goodCnt, insertDatetime);
					shoppingRecordVOList.add(shoppingRecordVO);
					
					totalMoney += totalPrize;
				}
			}
		}
		
		modelAndView.addObject("shoppingRecordVOList", shoppingRecordVOList);
		modelAndView.addObject("totalMoney", totalMoney);
		modelAndView.setViewName("C/shoppingRecord");
		return modelAndView;
	}
	
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
		Integer userId = request.getSession().getAttribute("UserId") == null ?
				null : Integer.parseInt(request.getSession().getAttribute("UserId").toString());
		String userName = null;
		Timestamp insertDatetime = new Timestamp(System.currentTimeMillis());
		/**
		 * status: 0-正常支付， 1-余额不足， 2-代码异常
		 */
		int status = 0;
		User user = null;
		Double userBalance = 0.0;
		Double totalMoney = 0.0;
		
		try {
			goods = goodService.selectGoodsMapByIds(Arrays.asList(goodIds));
		} catch (Exception e) {
			logger.error("ERROR: ShoppingRecordController->insertShoppingRecords->selectGoodsMapByIds");
			e.printStackTrace();
		}
		
		try {
			userName =  request.getSession().getAttribute("UserName").toString();
			user = userService.getUserByUserName(userName);
			userBalance = user.getBalance();
		} catch (Exception e) {
			logger.error("ERROR: ShoppingRecordController->insertShoppingRecords");
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
				double curMoney = prize * goodCnts[i];
				ShoppingRecord shoppingRecord = new ShoppingRecord(userId, gid, goodCnts[i], curMoney, insertDatetime);
				shoppingRecords.add(shoppingRecord);
				totalMoney += curMoney;
			}
		}
		
		if(totalMoney <= userBalance) {
			try {
				shoppingRecordService.insertShoppingRecords(shoppingRecords);
			} catch (Exception e) {
				logger.error("ERROR: ShoppingRecordController->insertShoppingRecords->insertShoppingRecords");
				e.printStackTrace();
			}
		} else {
			status = 1;
		}
		
		
		ret.put("status", status);
		return ret;
	}
}
