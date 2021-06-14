package com.cos.mogaco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.mogaco.model.User;

// jsp -> DAO
// 레거시 -> spring IoC에서 객체로 들고 있는가? -> 자동으로 bean 등록이 됨(@Repository 생략 가능)
public interface UserRepository extends JpaRepository<User, Long> {
	// 기본적인 select, insert, update, delete의 경우는 아무 것도 적어주지 않아도 가능
	// Controller에 주입
}
