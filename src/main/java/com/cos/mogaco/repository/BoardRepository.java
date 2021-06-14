package com.cos.mogaco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.mogaco.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	
}

