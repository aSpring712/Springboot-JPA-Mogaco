package com.cos.mogaco.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(HTML 파일)
// @Controller

// 사용자가 요청 -> 응답(Data를)
@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest : ";
	
	// localhost:8000/mogaco/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() {
		// id값은 1씩 자동으로 증가하는 sequence 값으로 db에서 알아서 처리하고 싶다면 생성자 더 필요?
//		Member m = new Member("ssar", "123456", "kwon@naver.com"); // @AllArgsConstructor가 생성해준 생성자
		
		// 이렇게하면 똑같이 객체가 생성됨 ! -> . 하고 넣고싶은 것만 순서 상관없이 넣어줄 수 있음
		Member m = Member.builder().username("ssar").password("1234").email("a@naver.com").build();
		System.out.println(TAG + "getter : " + m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG + "setter : " + m.getUsername());
//		Member m1 = new Member(1, "ssar", "123456", "kwon@naver.com"); // @AllArgsConstructor가 생성해준 생성자
		return "lombok test 완료";
	}
	
	// 인터넷 브라우저 요청은 무조건 get 요청밖에 할 수 없다.
	// http://localhost:8080/http/get (select) 
	@GetMapping("/http/get") // 쿼리스트링 방식 id=1&username=ssar&password=1234
	public String getTest(Member m) { // 객체 통해 한 번에 받기
		return "get 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword();
	}

	// http://localhost:8080/http/post (insert)
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) { // 쿼리스트링 방식이 아닌 Body에 Data를 보내야 함, String을 받으려면 @RequestBody 어노테이션 써야 함
		return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getPassword();
	}
	
	// http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청";
	}
	
	// http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
