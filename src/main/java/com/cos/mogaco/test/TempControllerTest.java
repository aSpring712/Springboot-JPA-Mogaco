package com.cos.mogaco.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 데이터가 아니라 file을 return할 것이기 때문에
public class TempControllerTest {
	
	// http://localhost:8000/mogaco/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()"); 
		// file return 시의 기본경로 : src/main/resources/static
		// return명 : /home.html 이라고 해야     -> 풀 경로 src/main/resources/static/home.html을 찾게 됨
		return "home.html";
	}
	
	// static 폴더 내에 사진 저장
	@GetMapping("/temp/img")
	public String tempimg() {
		return "/images/logo.svg";
	}
	
	// static 폴더 내에 .jsp 파일 저장 -> 찾지 못함 -> .jsp 파일은 정적인 파일이 아니기 때문에 (컴파일이 일어나야 하는 동적인 java 파일이기 때문에)
	@GetMapping("/temp/jsp")
	public String tempjsp() {
		return "/test.jsp";
	}
	
	// .yml 설정에 의해 /test.jsp가 return이 될텐데
	@GetMapping("/temp2/jsp")
	public String findjsp() {
		// prefix : /WEB-INF/views/
		// suffix : .jsp
		// 풀네임 : /WEB-INF/views//test.jsp.jsp를 찾음 --> "/test.jsp"를 "test"로 바꿔주면 /WEB-INF/views/test.jsp 이렇게 됨 
		return "test"; // 톰캣이 동작
	}
	
}
