package com.cos.mogaco.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.mogaco.model.RoleType;
import com.cos.mogaco.model.User;
import com.cos.mogaco.repository.UserRepository;

// html 파일이 아닌 data를 return 해주는 Controller
@RestController // 페이지 이동X, 데이터만 return하여 응답만 해줄 수 있게
public class DummyControllerTest {
	
	@Autowired // 의존성 주입(DI) 
	private UserRepository userRepository;
	
	// http://localhost:8000/mogaco/dummy/user
	@GetMapping("/dummy/users")
	public List<User> list() {
		return userRepository.findAll();
	}
	
	// 한페이지당 2건에 데이터를 리턴받기
	@GetMapping("/dummy/user") // id를 최신 순으로 해서 2건씩
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<User> pagingUser = userRepository.findAll(pageable); // 페이징 & List<User> 뿐만 아니라 다른 것들도 다 받아옴
		
		List<User> users = pagingUser.getContent(); // List<User>만 받아옴
		return users;
	}
	
	// save 함수 -> id 전달 X 시 insert를 해주고
	// svae 함수 -> id 전달 O 시 해당 id에 대한 data가 있으면 update
	// save 함수 -> id 전달 O 시 해당 id에 대한 데이터가 없으면 insert 해줌
	// email, password 두가지만 수정
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable long id) {
		try { // 해당 id가 있으면 삭제
			userRepository.deleteById(id); // void로 return 값이 없는 메서드
		} catch (EmptyResultDataAccessException e) { // db에 없는 경우 (Exception가 최상위)
			return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
		}
		
		return "삭제되었습니다. id : " + id;
	}
	
	@Transactional // 함수 종료시에 자동 commit이 됨
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable long id, @RequestBody User requestUser) { // json 데이터를 받아오려면 @RequestBody 필요
		// json 데이터를 요청 => Java Object(MessageConverter)로 변환해서 받아줌
		System.out.println("id : " + id);
		System.out.println("password : " + requestUser.getPassword());
		System.out.println("email : " + requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{ // dbd에서 수정하고자 하는 유저의 data 받아옴 -> 영속화(1차 캐시)
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		
		user.setPassword(requestUser.getPassword()); // 영속화된 user obj의 값을 변경 
		user.setEmail(requestUser.getEmail()); // 영속화된 user obj의 값을 변경
		
//		userRepository.save(user); -> save하지 않아도 @Transactional 어노테이션을 추가하니 수정이 된 것을 확인알 수 있음
		
		// 더티 체킹
		
		return user;
		
		// @Transaction 어노테이션 -> 종료 시 commit이 되며
		// db에서 들고온 1차 캐시에 있던 user obj의 pwd와 email이 변경됐구나 인식(변경 감지) 
		// db에 밀어넣어 줌(update문 수행)     =====> 더티 체킹
	}

	// {id} 주소로 파라미터를 전달받을 수 있음
	// http://localhost:8000/mogaco/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable long id) {
		// user/4를 조회하라고 했는데 db에서 못찾으면 user가 null이 될 것
		// -> return 시 null이 됨 -> 프로그램에 문제 생길 수 있음 -> Optional로 User 객체를 감싸서 가져옴
//		User user = userRepository.findById(id).get(); null이 올리가 없을 때 .get()으로 바로 가져올 수 있음
		
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() { // null이면 user 객체를 하나 만들어서 가져와라
//			@Override
//			public User get() { // null이면 빈 객체를 User에 넣어서 들고옴
//				// TODO Auto-generated method stub
//				return new User();
//			}
//		}); 
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없는 유저입니다. id : " + id);
			}
		});
		
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//			@Override
//			public User get() {
//				// TODO Auto-generated method stub
//				return new User();
//			}
//		});
		
		// 람다식
//		User user = userRepository.findById(id).orElseThrow(()->{ // 어떤 타입이 들어오는지 신경쓰지 않고 익명으로 처리 가능
//			return new IllegalArgumentException("해당 사용자는 없습니다.");
//		});
		
		// 요청 : 웹브라우저
		// user 객체 = 자바 오브젝트   --> 변환(웹 브라우저가 이해할 수 있는 데이터로) : json (Gson 라이브러리)
		// spring boot = MessageConverter가 응답시에 자동 작동 -> 만약 자바 오브젝트 return 시 메시지 컨버터가 Jackson 라이브러리 호출
		// -> user 오브젝트를 json 타입으로 변환해서 브라우저에게 전달
		return user;
	}
	
	// http://localhost:8000/mogaco/dummy/join (요청)
	// http의 body에 username, password, email 데이터를 가지고 (요청)
	@PostMapping("/dummy/join") // 회원가입 - insert
//	public String join(String username, String password, String email) { // 함수의 parameter로 파싱해서 들어옴 -> key = value 형태로
	public String join(User user) { // Object형으로 받아올 수 있음 
		System.out.println("id : " + user.getId());
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("role : " + user.getRole());
		System.out.println("createDate" + user.getCreateDate());
		
//		user.setRole("user"); // default 값 지우고 role filed에는 user로 지정
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}
}
