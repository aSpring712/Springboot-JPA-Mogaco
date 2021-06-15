package com.cos.mogaco.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.mogaco.model.User;
import com.cos.mogaco.repository.UserRepository;

// spring이 컴포넌트 스캔을 통해 Bean에 등록해줌 -> IoC를 해줌
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional // 회원가입이라는 서비스가 하나의 Transaction으로 묶임 -> 전체가 성공이 되어야 commit되고, 하나라도 실패 시 roll back(원복) 됨
	public void 회원가입(User user) {
			userRepository.save(user);
	}
}
