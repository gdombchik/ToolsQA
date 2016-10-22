package com.toolsqa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service("fileService")
public class FileServiceImpl implements FileService {	
	@Value("${phantomJSDriver}")
	private String phantomJSDriver;
	
	@Value("${screenShot}")
	private String screenShot;

	@Autowired
	private Environment environment;

	public String getPhantomJSDriver(){
		return phantomJSDriver;
	}
	
	public String getScreenShot(){
		return screenShot;
	}
}
