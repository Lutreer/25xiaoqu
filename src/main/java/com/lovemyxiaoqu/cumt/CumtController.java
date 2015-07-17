package com.lovemyxiaoqu.cumt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.descriptor.web.ErrorPage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lovemyxiaoqu.cumt.pojo.ErrorPojo;
import com.lovemyxiaoqu.cumt.pojo.LrjExcelDataPojo;


@Controller
@EnableAutoConfiguration
@RequestMapping(value="/cumt")
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 20, maxRequestSize = 1024 * 1024 * 200)
public class CumtController {
	
	@RequestMapping(value="/lrjexceldata", method = { RequestMethod.POST })
	public ResponseEntity<Object> index(@RequestParam String params,
			@RequestParam("file") MultipartFile[] files,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
	
		ObjectMapper mapper = new ObjectMapper();  
		LrjExcelDataPojo param = mapper.readValue(params.toString(), LrjExcelDataPojo.class);  
		
		ErrorPojo error = new ErrorPojo();
		error.setCode(22);
		error.setErrorMessage("success!!!!!!!!");
		
		return  new ResponseEntity<Object>(new Resource<ErrorPojo>(error), HttpStatus.OK);
		
	}
	
	
}
