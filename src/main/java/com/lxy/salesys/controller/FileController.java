package com.lxy.salesys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.lxy.salesys.service.IFileService;

@Controller
public class FileController {
	
	private static final int GOOD_IMG_SIZE_MAX = 1024 * 1024;
	
	@Autowired
	IFileService fileService;
	
	/**
	 * 
	 * @Title: fileUpload 
	 * @Description: 上传图片
	 * @param @param file
	 * @param @param request
	 * @param @param model
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping(value="/fileUpload", method = RequestMethod.POST, consumes = "multipart/form-data")
	@ResponseBody
	public String fileUpload(@RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request, ModelMap model) {  
		JSONObject ret = new JSONObject();
		String path = request.getSession().getServletContext().getRealPath("upload");
		String filePath = "";
		int status = 0;
		if(GOOD_IMG_SIZE_MAX >= file.getSize()) {
			filePath = "../upload/" + fileService.fileUpload(file, path);
		} else {
			status = 1;
		}
		ret.put("status", status);
		ret.put("filePath", filePath);
		return ret.toJSONString();
	}
}
