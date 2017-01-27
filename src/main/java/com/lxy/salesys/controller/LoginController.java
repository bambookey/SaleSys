package com.lxy.salesys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

@Controller
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
//	ModelAndView modelAndView = new ModelAndView();
//	int status = 0;
//	String viewName = "login";
//	
//	modelAndView.setViewName(viewName);
//	modelAndView.addObject("status", status);
//	return modelAndView;
	
	@RequestMapping(value="/userLogin", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject userLogin() {
		JSONObject ret = new JSONObject();
		int status = 0;
		
		ret.put("status", status);
		ret.put("status", "www");
		return ret;
	}
}
