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
import com.lxy.salesys.utils.MD5;

@Controller
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	IUserService userService;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	/**
	 * 
	 * @Title: userLogin 
	 * @Description: 用户登录
	 * @param @param request
	 * @param @param response
	 * @param @return    设定文件 
	 * @return JSONObject    返回类型 status:0:存在用户且登录成功；-1:用户不存在或密码错误
	 * @throws
	 */
	@RequestMapping(value="/userLogin", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject userLogin(HttpServletRequest request, HttpServletResponse response) {
		JSONObject ret = new JSONObject();
		int status = 0;
		int userType = 0;
		String userName = request.getParameter("userId");
		String userPassword = MD5.GetMD5Code(request.getParameter("userPassword"));
		System.out.println(userPassword);
		User loginUser = new User(userName, userPassword);
		User user = null;
		
		try {
			user = userService.userLogin(loginUser);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error: LoginController->userLogin->getUserByUserName");
		}
		
		if(user == null) {
			status = -1;
		} else {
			userType = user.getUserType();
			request.getSession().setAttribute("NickName", user.getNickName());
			request.getSession().setAttribute("UserName", user.getUserName());
			request.getSession().setAttribute("UserId", user.getId());
		}
		ret.put("status", status);
		ret.put("userType", userType);
		return ret;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("NickName");
		request.getSession().removeAttribute("UserName");
		request.getSession().removeAttribute("UserId");
		return "login";
	}
}
