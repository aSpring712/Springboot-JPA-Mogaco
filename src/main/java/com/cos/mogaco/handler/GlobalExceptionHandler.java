package com.cos.mogaco.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.mogaco.dto.ResponseDTO;

@ControllerAdvice // 모든 exception 발생 시 이 class로 들어올 수 있도록
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class) // 모든 Exception 발생 시
	public ResponseDTO<String> handleArgumentException(Exception e) { // error를 이 메서드에 전달해 줌
		return new ResponseDTO<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()); 
	}
}
