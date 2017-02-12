package com.lxy.salesys.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
import com.lxy.salesys.pojo.ShoppingRecord;
import com.lxy.salesys.service.IGoodService;
import com.lxy.salesys.service.IShoppingRecordService;
import com.lxy.salesys.vo.GoodVO;

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
	
	@Autowired
	IShoppingRecordService shoppingRecordService;
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
		Timestamp insertDatetime = new Timestamp(System.currentTimeMillis());
		
		Good good = new Good(title, summary, text, img, prize, false, insertDatetime);
		
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
		ArrayList<GoodVO> goodVOList = new ArrayList<GoodVO>();
		Map<Integer, Integer> goodSoldCnt = new HashMap<Integer, Integer>();
		int status = 0;
		try {
			goodList = goodService.selectAllGoods();
			goodSoldCnt = shoppingRecordService.selectShoppingGoodAmountMap();
		} catch (Exception e) {
			logger.error("ERROR: GoodController->selectAllGoods->selectAllGoods");
			e.printStackTrace();
		}
		
		for(Good good : goodList) {
			int soldCnt = 0;
			if(goodSoldCnt.containsKey(good.getId())) {
				soldCnt = goodSoldCnt.get(good.getId());
			}
			GoodVO goodVO = new GoodVO(good, soldCnt);
			goodVOList.add(goodVO);
		}
		
		modelAndView.setViewName("B/goodList");
		modelAndView.addObject("status", status);
		modelAndView.addObject("goodList", goodVOList);
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
	public ModelAndView goodListC(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		ArrayList<Good> goodList = new ArrayList<Good>();
		ArrayList<GoodVO> goodVOList = new ArrayList<GoodVO>();
		HashSet<Integer> boughtGoodIds = new HashSet<Integer>();
		Boolean noPurchase = false;
		Integer noPurchasePara = -1;
		try {
			if(request.getParameter("noPurchase") != null && !request.getParameter("noPurchase").equals("null")) {
				noPurchasePara = Integer.parseInt(request.getParameter("noPurchase").trim());
			}
			if(noPurchasePara == 1) {
				noPurchase = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("ERROR: GoodController->selectAllGoods->parseInt" + noPurchasePara);
		}
		
		Integer userId = request.getSession().getAttribute("UserId") == null ?
				null : Integer.parseInt(request.getSession().getAttribute("UserId").toString());
		int status = 0;
		try {
			goodList = goodService.selectAllGoods();
		} catch (Exception e) {
			logger.error("ERROR: GoodController->selectAllGoods->selectAllGoods");
			e.printStackTrace();
		}
		ArrayList<ShoppingRecord> shoppingRecords = shoppingRecordService.selectShoppingRecordsByUserId(userId);
		for(ShoppingRecord record : shoppingRecords) {
			boughtGoodIds.add(record.getGoodId());
		}
		for(Good good : goodList) {
			GoodVO goodVO = new GoodVO(good);
			if(boughtGoodIds.contains(good.getId())) {
				goodVO.setIsBought(true);
			} else {
				goodVO.setIsBought(false);
			}
			
			if(noPurchase) {
				if(!goodVO.getIsBought()) {
					goodVOList.add(goodVO);
				}
			} else {
				goodVOList.add(goodVO);
			}
			
		}
		modelAndView.setViewName("C/goodList");
		modelAndView.addObject("status", status);
		modelAndView.addObject("goodList", goodVOList);
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
	public ModelAndView goodDetailB(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		int status = 0;
		Good good = goodService.selectGoodById(id);
		
		modelAndView.setViewName("B/goodDetail");
		modelAndView.addObject("status", status);
		modelAndView.addObject("good", good);
		return modelAndView;
	}
	
	/**
	 * 
	 * @Title: goodDetail 
	 * @Description: C端商品详细信息
	 * @param @param request
	 * @param @param response
	 * @param @return    设定文件 
	 * @return ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping("/C/goodDetail")
	public ModelAndView goodDetailC(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		int status = 0;
		Good good = goodService.selectGoodById(id);
		
		modelAndView.setViewName("C/goodDetail");
		modelAndView.addObject("status", status);
		modelAndView.addObject("good", good);
		return modelAndView;
	}
	
	/**
	 * 
	 * @Title: updateGoodById 
	 * @Description: 更新产品
	 * @param @param request
	 * @param @param response
	 * @param @return    设定文件 
	 * @return JSONObject    返回类型 
	 * @throws
	 */
	@RequestMapping("/B/updateGood")
	@ResponseBody
	public JSONObject updateGoodById(HttpServletRequest request, HttpServletResponse response) {
		JSONObject ret = new JSONObject();
		Integer id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String text = request.getParameter("text");
		String imgPath = request.getParameter("img");
		Double prize = Double.parseDouble(request.getParameter("prize"));
		Timestamp updateDatetime = new Timestamp(System.currentTimeMillis());
		Good good = new Good(id, title, summary, text, imgPath, prize, false, updateDatetime);
		
		int status = -1;
		int rowAffected = -1;
		try {
			rowAffected = goodService.updateGoodById(good);
			status = 0;
		} catch (Exception e) {
			logger.error("ERROR: GoodController->updateGoodById->updateGoodById");
			e.printStackTrace();
		}
		
		ret.put("status", status);
		ret.put("rowAffected", rowAffected);
		return ret;
	}
	
	/**
	 * 
	 * @Title: deleteGoodById 
	 * @Description: 删除商品
	 * @param @param request
	 * @param @param response
	 * @param @return    设定文件 
	 * @return JSONObject    返回类型 
	 * @throws
	 */
	@RequestMapping(value="/B/deleteGood", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteGoodById(HttpServletRequest request, HttpServletResponse response) {
		Integer goodId = Integer.parseInt(request.getParameter("goodId"));
		JSONObject ret = new JSONObject();
		int status = goodService.deleteGoodById(goodId);
		ret.put("status", status);
		return ret;
	}
}
