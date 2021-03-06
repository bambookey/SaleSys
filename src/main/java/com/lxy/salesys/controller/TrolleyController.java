package com.lxy.salesys.controller;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.lxy.salesys.pojo.Good;
import com.lxy.salesys.pojo.Trolley;
import com.lxy.salesys.service.IGoodService;
import com.lxy.salesys.service.ITrolleyService;

@Controller
public class TrolleyController {
	
	private Logger logger = LoggerFactory.getLogger(TrolleyController.class);
	
	@Autowired
	ITrolleyService trolleyService;
	
	@Autowired
	IGoodService goodService;
	
	@RequestMapping(value="/C/insertTrolley", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject insertTrolley(HttpServletRequest request, HttpServletResponse response) {
		JSONObject ret = new JSONObject();
		Integer userId = null;
		Integer goodId = null;
		try {
			userId =  Integer.parseInt(request.getSession().getAttribute("UserId").toString());
			goodId = Integer.parseInt(request.getParameter("goodId"));
		} catch (Exception e) {
			logger.error("ERROR: TrolleyController->insertTrolley->parseInt");
			e.printStackTrace();
		}
		
		Trolley trolley = new Trolley(userId, goodId, 0, new Timestamp(System.currentTimeMillis()));
		int trolleyExistCnt = trolleyService.checkTrolley(trolley);
		
		if(trolleyExistCnt == 0) {
			try {
				trolleyService.insertTrolley(trolley);
				ret.put("status", 0);
			} catch (Exception e) {
				logger.error("ERROR: TrolleyController->insertTrolley->insertTrolley");
				ret.put("status", 500);
				e.printStackTrace();
			}
		} else {
			ret.put("status", 1);
		}
		return ret;
	}
	
	/**
	 * 
	 * @Title: trolley 
	 * @Description: C端购物车
	 * @param @param request
	 * @param @param response
	 * @param @return    设定文件 
	 * @return ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping("/C/trolley")
	public ModelAndView trolley(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		
		Integer userId = request.getSession().getAttribute("UserId") == null ?
				null : Integer.parseInt(request.getSession().getAttribute("UserId").toString());
		
		if(userId == null) {
			modelAndView.setViewName("login");
			return modelAndView;
		}
		
		ArrayList<Trolley> trolleys = trolleyService.getTrolleysByUserId(userId);
		ArrayList<Integer> goodIds = new ArrayList<Integer>();
		ArrayList<Good> trolleyGoods = new ArrayList<Good>();
		
		if(trolleys.size() != 0) {
			for(Trolley trolley : trolleys) {
				goodIds.add(trolley.getGoodId());
			}
			trolleyGoods = goodService.selectGoodsByIds(goodIds);
		}
		
		modelAndView.setViewName("C/trolley");
		modelAndView.addObject("trolleys", trolleyGoods);
		return modelAndView;
	}
}
