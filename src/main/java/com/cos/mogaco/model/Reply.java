package com.cos.mogaco.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply { // 답변
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 200)
	private String content;
	
	// 어느 게시글에 대한 답변인가 -> 연간관계 설정 필요
	@ManyToOne // 여러 개의 답변이 하나의 게시글에 존재
	@JoinColumn(name="boardId")
	private Board board;
	
	@ManyToOne // 하나의 유저는 여러 개의 답변 달기 가능, 하나의 답변은 한 명의 유저만 달 수 있음
	@JoinColumn(name="userId")
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;
}
