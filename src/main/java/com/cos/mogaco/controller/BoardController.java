package com.cos.mogaco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.mogaco.model.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	// 공지사항 리스트 조회
	@GetMapping("notice")
	public String noticeList(Model model, @PageableDefault(size = 5, sort="num", direction = Sort.Direction.DESC) Pageable pageable) {
//		Page<Board> lists = boardService.findAllNotice(pageable);
		return "board/noticeList";
	}
	
	// 커뮤니티 게시글 조회 -> 페이징
	@GetMapping("list")
	public String comList() {
//		Page<Board> lists = boardService.findAllComboard(pageable);
//		model.addAttribute("lists", lists);
//		model.addAttribute("count", boardService.count());
		return "board/comList";
	}
	
	// 커뮤니티 게시글 쓰기 폼 이동
	@GetMapping("insertForm")
	public String insert() {
		return "board/comForm";
	}
	
	// 글 쓰기 -> DB에 저장
	@PostMapping("insert")
	public String insert(Board board) {
//		boardService.insert(board);
		return "redirect:list";
	}
	
	// 게시글 상세보기
	@GetMapping("view/{num}")
	public String view() {
//		model.addAttribute("board", boardService.findById(num));
		return "board/comDetail";
	}
	
	// 게시글 수정 폼으로 이동
	@GetMapping("update/{num}")
	public String update() {
//		model.addAttribute("board", boardService.findById(num));
		return "board/comUpdate";
	}
	
	//수정하기 DB 수정
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody Board board) {
//		boardService.update(board);
		return "success";
	}
	
	//삭제
	@DeleteMapping("delete/{num}")
	@ResponseBody
	public String delete(@PathVariable Long num) {
//		boardService.delete(num);
		return "success";
	}
}
