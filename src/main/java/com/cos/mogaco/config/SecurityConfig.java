package com.cos.mogaco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // 환경설정 파일로 인식
//@EnableWebSecurity // 환경설정 중 Security 관련임을 명시(레거시 때는 Security-context.xml에 해줬던 설정들)
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) // 미리 혹은 후에 security 체크 할건지
public class SecurityConfig { // extends WebSecurityConfigurerAdapter { // WebSecurityConfigurerAdapter에 Security가 구현되어 있음
//	@Bean // 외부에서 만들어진 객체 만들 때, component -> 내가 만드는 객체를 만들 때?
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.authorizeRequests() 					 // 권한 요구
//			.antMatchers("/admin/**").hasRole("ADMIN") // 매칭 -> user를 타고오는 모든 것에는 권한을 요구할 것
//			.antMatchers("/**").permitAll()
//			.and()
//				.formLogin()
//				.loginPage("/login")
//				.loginProcessingUrl("/loginPro")	 // form action="/loginPro"
//				.defaultSuccessUrl("/")				 // 성공 시 root로
//			.and()
//				.logout()
//				.logoutUrl("/logout")
//				.logoutSuccessUrl("/")
//				.invalidateHttpSession(true);
//	}
}
