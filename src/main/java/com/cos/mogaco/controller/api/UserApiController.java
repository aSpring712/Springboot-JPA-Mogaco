package com.cos.mogaco.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.mogaco.dto.ResponseDTO;
import com.cos.mogaco.model.RoleType;
import com.cos.mogaco.model.User;
import com.cos.mogaco.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	public ResponseDTO<Integer> save(@RequestBody User user) { // username, password, email 3개만 받아옴 -> 가입 시간, Role은 받지 않음
		System.out.println("UserApiController : save 호출됨");
		// 실제로 DB에 insert를 하고 아래에서 return 됨
		user.setRole(RoleType.USER); // 회원가입 시 USER로 가입시킴
		userService.회원가입(user); // 성공하면 200 return, 실패하면 exception handler에서 처리
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1); // 자바 오브젝트를 JSON으로 변환해서 return(Jackson 라이브러리)
	}
}
