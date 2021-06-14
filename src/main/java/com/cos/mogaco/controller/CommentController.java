package com.cos.mogaco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.mogaco.model.Board;
import com.cos.mogaco.model.Reply;


@RequestMapping("/reply/*")
@RestController
public class CommentController {
	
//	@Autowired
//	private CommentService commentService;
	
	// 댓글 추가
	@PostMapping("insert/{num}")
	public ResponseEntity<String> commentInsert(@PathVariable Long num,
			@RequestBody Reply comment) {
		Board b = new Board();
//		b.setNum(num);
		
		comment.setBoard(b);
//		commentService.insert(comment);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	// 댓글 리스트
//	@GetMapping("list")
//	public List<Reply> list(Long bnum) {
//		List<Reply> clist = commentService.list(bnum);
//		return clist;
//	}
	
	// 댓글 삭제
	@DeleteMapping("del/{cnum}")
	public String delete(@PathVariable Long cnum) {
//		commentService.delete(cnum);
		return cnum.toString();
	}
}
