package com.lovemyxiaoqu.cumt;

import java.util.HashMap;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@EnableAutoConfiguration
@RequestMapping(value="/cumt")
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 20, maxRequestSize = 1024 * 1024 * 200)
public class CumtController {
	
	@RequestMapping(value="/lrjexceldata", method = { RequestMethod.POST })
	public ModelAndView index(@RequestParam(value = "modifyDate") String modifyDate,
			@RequestParam(value = "randomMin") String randomMin,
			@RequestParam(value = "randomMax") String randomMax,
			@RequestParam("file") MultipartFile file){
		HashMap<String,Object> wrapper = new HashMap<String,Object>();
		wrapper.put("result", true);
		ModelAndView model = new ModelAndView();
		model.addAllObjects(wrapper);
		return model;
	}
	
	
}
