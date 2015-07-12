package com.lovemyxiaoqu.cumt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CumtController {
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	
}
