package com.cos.mogaco.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private long id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content; // 섬머노트 라이브러리 사용 <html> 태그가 섞여서 디자인 되므로 대용량 Data -> Lob
	
//	@ColumnDefault("0") // 기본값 0 : int이므로 ' ' 는 필요 없음
	private int count; // 조회수
	
	// 연관관계 설정 - Board가 Many, User는 One -> 1명의 User는 여러개의 게시글 작성 가능 // 여러개의 게시글은 1명의 유저에 의해 쓰일 수 있음
	@ManyToOne(fetch = FetchType.EAGER)  // Board table select 시 글 쓴 user는 1명이므로 User를 바로 정보 가져오기(무조건 들고와야 함)
	@JoinColumn(name = "userId") // userId라는 이름으로 db에 들어감(fk로 만들어짐)
	private User user; // 게시글 작성자 - DB는 Object를 저장할 수 없어 FK를 저장, 자바는 오브젝트 저장 가능 -> 충돌 발생 : java에서 db의 자료형에 맞춰 fk의 key 값을 저장 -> ORM 사용 시 object 저장 가능 
	
	// 게시글을 작성한 user만 필요한 게 아니라 reply도 필요함
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // 이 reply는 mappedBy 연관관계의 주인이 아님 -> FK가 아님 -> DB에 컬럼을 만들지 말라. (reply table의 board가 fk)
//	@Joincolumn() 필요없음 -> 댓글은 여러개가 존재할 수 있음 -> 조인해서 값만 얻어오면 됨
	private List<Reply> reply; // 하나의 게시글에 수많은 댓글이 존재할 수 있으므로 기본 전략 : LAZY (필요할 때 들고옴)
	// But 필요할 때 가져오기인데 상세보기 시 댓글이 다 보여야 하므로 EAGER 전략으로 변경
	
	@CreationTimestamp
	private LocalDateTime createDate; // 게시글 작성 시간
}
