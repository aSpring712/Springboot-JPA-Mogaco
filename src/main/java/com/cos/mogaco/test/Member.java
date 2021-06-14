package com.cos.mogaco.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor // 생성자 만듦 Member(id, username, password, email)

@Data // getter, setter 생성 
@NoArgsConstructor // 빈 생성자 만들어줌 Member()
public class Member { // db에서 들고온 아래의 값들을 변경할 일이 없으므로 final로 불변성 유지
	private int id;
	private String username;
	private String password;
	private String email;
	
	@Builder // 객체를 만들 때 Member m = new Member(...) 안하고 
	// Member m = Member.builder().password() 등.. . 하면 넣고싶은 것들을 넣을 수 있음
	public Member(int id, String username, String password, String email) { // @AllArgsConstructor가 자동으로 만들어 줌 
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	// 자바에서 변수를 private로 선언하는 이유
	// -> 변수에 바로 접근해서 값을 바꿔버릴 수 있으므로 X
	// 객체 지향과 맞지 않음
	// 함수를 통해 접근하는 것이 맞음
	
	// 객체지향 - 변수를 private으로 -> 변수의 상태는 메서드를 통해 변화시켜야 함
	// 따라서 Class를 만들 때는 생성자 생성, 변수는 private으로 만들고 접근할 수 있도록 getter, setter를 만들어야 함
}
