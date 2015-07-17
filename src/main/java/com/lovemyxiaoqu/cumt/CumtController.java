package com.lovemyxiaoqu.cumt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lovemyxiaoqu.cumt.pojo.LrjExcelDataPojo;


@Controller
@EnableAutoConfiguration
@RequestMapping(value="/cumt")
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 20, maxRequestSize = 1024 * 1024 * 200)
public class CumtController {
	
	@RequestMapping(value="/lrjexceldata", method = { RequestMethod.POST })
	public String index(@RequestParam String params,
			@RequestParam("file") MultipartFile[] files,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
	
		ObjectMapper mapper = new ObjectMapper();  
		LrjExcelDataPojo param = mapper.readValue(params.toString(), LrjExcelDataPojo.class);  
		ResponseEntity<Object> responseEntity =  null;
		
		
		
		response.setContentType("text/plain;charset=UTF-8"); 
		PrintWriter out = response.getWriter(); 
		out.print("1`请选择文件后上传"); 
		out.flush(); 
		return null;
	}
	
	
}
