package com.lxy.salesys.controller;

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
import com.lxy.salesys.service.IGoodService;

/**
 * 
 * @ClassName: GoodController 
 * @Description: 商品控制器
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017年1月28日 下午10:30:17 
 *
 */
@Controller
public class GoodController {
	
	private Logger logger = LoggerFactory.getLogger(GoodController.class);
	
	@Autowired
	IGoodService goodService;
	
	/**
	 * 
	 * @Title: goodInsertB 
	 * @Description: 【跳转】B端插入商品
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/B/goodInsert")
	public String goodInsertB() {
		return "B/goodInsert";
	}
	
	
	/**
	 * 
	 * @Title: insertGood 
	 * @Description: 插入货物，返回受影响的行数
	 * @param @param request
	 * @param @param response
	 * @param @return    设定文件 
	 * @return JSONObject    返回类型 
	 * @throws
	 */
	@RequestMapping(value="/B/insertGood", method = RequestMethod.POST)
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
		int rowAffected = -1;
		try {
			rowAffected = goodService.insertGood(good);
			status = 0;
		} catch (Exception e) {
			logger.error("ERROR: GoodController->insertGood->insertGood");
			e.printStackTrace();
		}
		
		ret.put("status", status);
		ret.put("rowAffected", rowAffected);
		return ret;
	}
	

	/**
	 * 
	 * @Title: selectAllGoods 
	 * @Description: 查找出所有的商品
	 * @param @return    设定文件 
	 * @return ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping("/B/goodList")
	public ModelAndView goodListB() {
		ModelAndView modelAndView = new ModelAndView();
		ArrayList<Good> goodList = new ArrayList<Good>();
		int status = 0;
		try {
			goodList = goodService.selectAllGoods();
		} catch (Exception e) {
			logger.error("ERROR: GoodController->selectAllGoods->selectAllGoods");
			e.printStackTrace();
		}
		
		
		modelAndView.setViewName("B/goodList");
		modelAndView.addObject("status", status);
		modelAndView.addObject("goodList", goodList);
		return modelAndView;
	}
	
	/**
	 * 
	 * @Title: selectAllGoods 
	 * @Description: 查找出所有的商品
	 * @param @return    设定文件 
	 * @return ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping("/C/goodList")
	public ModelAndView goodListC() {
		ModelAndView modelAndView = new ModelAndView();
		ArrayList<Good> goodList = new ArrayList<Good>();
		int status = 0;
		try {
			goodList = goodService.selectAllGoods();
		} catch (Exception e) {
			logger.error("ERROR: GoodController->selectAllGoods->selectAllGoods");
			e.printStackTrace();
		}
		
		
		modelAndView.setViewName("C/goodList");
		modelAndView.addObject("status", status);
		modelAndView.addObject("goodList", goodList);
		return modelAndView;
	}
	
	/**
	 * 
	 * @Title: goodDetail 
	 * @Description: B端商品详细信息
	 * @param @param request
	 * @param @param response
	 * @param @return    设定文件 
	 * @return ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping("/B/goodDetail")
	public ModelAndView goodDetail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		int status = 0;
		Good good = goodService.selectGoodById(id);
		
		modelAndView.setViewName("B/goodDetail");
		modelAndView.addObject("status", status);
		modelAndView.addObject("good", good);
		return modelAndView;
	}
	
	
	
}
