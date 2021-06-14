package com.cos.mogaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // view를 return 하겠다
public class HomeController {
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping({"/generic", "/elements"})
	public void generic() {
		
	}
}
