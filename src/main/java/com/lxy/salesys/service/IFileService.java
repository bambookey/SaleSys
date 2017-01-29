package com.lxy.salesys.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
	
	/**
	 * 
	 * @Title: fileUpload 
	 * @Description: 文件上传
	 * @param @param file
	 * @param @param path
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public String fileUpload(MultipartFile file, String path);
}
