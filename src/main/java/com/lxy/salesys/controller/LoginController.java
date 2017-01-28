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
import com.lxy.salesys.pojo.User;
import com.lxy.salesys.service.IUserService;

@Controller
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	IUserService userService;
	
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
	public JSONObject userLogin(HttpServletRequest request, HttpServletResponse response) {
		JSONObject ret = new JSONObject();
		int status = 0;
		int userType = 0;
		String userName = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		User user = userService.getUserByUserName(userName);
		
		if(user == null) {
			status = -1;
		} else {
			status = 1;
			
		}
		ret.put("status", status);
		ret.put("status", "www");
		return ret;
	}
}
