package com.lxy.salesys.service.impl;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lxy.salesys.service.IFileService;

@Service("fileService")
public class FileServiceImpl implements IFileService{

	public String fileUpload(MultipartFile file, String path) {
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			path = null;
			
			e.printStackTrace();
		}
		return fileName;
	}
}
