package com.cos.mogaco.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter
@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 생성자
@Builder // 빌더 패턴
//ORM -> Java(다른 언어 포함)의 Object -> 테이블로 매핑해주는 기술
@Entity // table화 -> User 클래스가 MySQL에 테이블이 생성됨
//@DynamicInsert // insert 쿼리를 날릴 때 null인 filed는 제외 -> default로 설정한 값이 들어갈 수 있도록 
public class User {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 넘버링 전략 -> 프로젝트에서 연결된 DB의 넘버링 전략을 따름(즉 Mysql의 전략)
	private long id; // 오라클 : 시퀀스, mysql : auto_increment
	
	@Column(nullable = false, length = 30, unique = true)
	private String username; // 아이디
	
	@Column(nullable = false, length = 100) // 해쉬(비밀번호 암호화)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
//	@ColumnDefault("'user'") // 가입 시 기본 role은 'user'
//	private String role; // Enum을 쓰는 것이 좋음 -> Data의 도메인을 만들어 줄 수 있음 -> ADMIN, USER 등의 권한 부여 가능 (글 삭제 권한 등 ..)
	// type이 String이기 때문에 오타를 내서 managerrrrr 이런 식으로 잘못 들어갈 수 있음
	// Enum 사용 -> 도메인이 정해지기 때문에 admin, user, manager만 들어가는 등
	
	// DB는 RoleType이라는 게 없음 -> string이라고 알려줘야 함
	@Enumerated(EnumType.STRING)
	private RoleType role; // ADMIN, USER
	
	// 내가 직접 시간을 넣으려면 Timestamp.valueOf(LocalDtaeTime.now())
	@CreationTimestamp // 회원가입 시 table이 insert 될 때 현재 시간이 자동으로 입력됨 -> sysdate 또는 now 쿼리를 사용하지 않아도 됨
	private Timestamp createDate; // 회원가입한 시간 
	
//	private Timestamp updateDate; // 회원 정보 수정일
}
