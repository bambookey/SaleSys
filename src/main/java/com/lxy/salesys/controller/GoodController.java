package com.lxy.salesys.controller;

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
import com.lxy.salesys.pojo.Good;
import com.lxy.salesys.service.IGoodService;

@Controller
public class GoodController {
	
	private Logger logger = LoggerFactory.getLogger(GoodController.class);
	
	@Autowired
	IGoodService goodService;
	
	@RequestMapping("/goodInsert")
	public String goodInsert() {
		return "goodInsert";
	}
	
	@RequestMapping(value="/insertGood", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject insertGood(HttpServletRequest request, HttpServletResponse response) {
		JSONObject ret = new JSONObject();
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String text = request.getParameter("text");
		String img = request.getParameter("img");
		Double prize = Double.parseDouble(request.getParameter("prize"));
		
		Good good = new Good(title, summary, text, img, prize);
		
		int status = -1;
		int id = -1;
		try {
			id = goodService.insertGood(good);
			status = 0;
		} catch (Exception e) {
			logger.error("ERROR: GoodController->insertGood->insertGood");
			e.printStackTrace();
		}
		
		ret.put("status", status);
		ret.put("id", id);
		return ret;
	}
}
