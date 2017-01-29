package com.lxy.salesys.controller;

import java.sql.Date;
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

import com.alibaba.fastjson.JSONObject;
import com.lxy.salesys.pojo.Trolley;
import com.lxy.salesys.service.ITrolleyService;

@Controller
public class TrolleyController {
	
	private Logger logger = LoggerFactory.getLogger(TrolleyController.class);
	
	@Autowired
	ITrolleyService trolleyService;
	
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
		trolleyService.insertTrolley(trolley);
		return ret;
	}
	
	/**
	 * 
	 * @Title: getTrolleysByUserId 
	 * @Description: 获取用户下所有购物车记录
	 * @param @param id
	 * @param @return    设定文件 
	 * @return ArrayList<Trolley>    返回类型 
	 * @throws
	 */
	public ArrayList<Trolley> getTrolleysByUserId(int id) {
		return trolleyService.getTrolleysByUserId(id);
	}
}
