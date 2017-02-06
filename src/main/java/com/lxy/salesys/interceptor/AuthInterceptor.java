package com.lxy.salesys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String userId = request.getSession().getAttribute("UserId") == null ? null : request.getSession().getAttribute("UserId").toString();
		String userTypeStr = request.getSession().getAttribute("UserType") == null ? null : request.getSession().getAttribute("UserType").toString();
		int userType = -1;
		String requestURI = request.getRequestURI();
		String uriType = "";
		try {
			userType = Integer.parseInt(userTypeStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(requestURI.split("/").length >= 2) {
			uriType = requestURI.split("/")[2];
		}
		
		//不需要验证的页面
		if (requestURI.contains("resources") || 
				requestURI.contains("userLogin")) {
	        return true;
	    }
		if(requestURI.contains("login") || 
				requestURI.contains("logout")) {
			if(userId == null || userTypeStr == null) {
				return true;
			} else {
				if(userType == 1) {
					response.sendRedirect("/SaleSys/C/goodList");
					return true;
				} else if(userType == 0) {
					response.sendRedirect("/SaleSys/B/goodList");
					return true;
				}
			}
		}
		
		
		if(userId == null || userTypeStr == null) {
			response.sendRedirect("/SaleSys/login");
			return true;
		}
		
		if(userType == 1) { // buyer
			if(uriType.equals("B")) {
				response.sendRedirect("/SaleSys/C/goodList");
			}
			return true;
		}
		if(userType == 0) { // seller
			if(uriType.equals("C")) {
				response.sendRedirect("/SaleSys/B/goodList");
			}
			return true	;
		}
		return true;
	}
}
