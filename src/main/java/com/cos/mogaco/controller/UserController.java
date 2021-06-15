package com.cos.mogaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// 로그인 폼으로 이동
	@GetMapping("loginForm")
	public void login() {
		
	}
	
	// 회원가입 페이지로 이동
	@GetMapping("joinForm")
	public void joinForm() {
		
	}
}
