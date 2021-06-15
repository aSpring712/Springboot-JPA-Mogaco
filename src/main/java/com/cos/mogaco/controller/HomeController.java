package com.cos.mogaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // view를 return 하겠다
public class HomeController {
	
	// 메인 index.jsp 페이지로 이동
	@GetMapping({"", "/"})
	public String index() {
		// /WEB-INF/views/index.jsp
		return "index";
	}
	
	@GetMapping({"/generic", "/elements"})
	public void generic() {
		
	}
}
