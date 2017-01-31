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
	
	@Autowired
	IFileService fileService;
	
	@RequestMapping(value="/fileUpload", method = RequestMethod.POST, consumes = "multipart/form-data")
	@ResponseBody
	public String fileUpload(@RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request, ModelMap model) {  
		String path = request.getSession().getServletContext().getRealPath("upload");
		String filePath = "../upload/" + fileService.fileUpload(file, path);
		return filePath;
	}
}
