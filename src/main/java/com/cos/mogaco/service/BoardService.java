package com.cos.mogaco.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.mogaco.model.Board;
import com.cos.mogaco.model.User;
import com.cos.mogaco.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void write(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	public List<Board> list(){
		return boardRepository.findAll();
	}
	
}
