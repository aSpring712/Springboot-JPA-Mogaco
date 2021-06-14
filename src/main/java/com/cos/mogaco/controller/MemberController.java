package com.cos.mogaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	// 로그인 폼으로 이동
	@GetMapping("login")
	public void login() {
		
	}
	
	// 회원가입 폼으로 이동
	@GetMapping("join")
	public void join() {
		
	}
}
