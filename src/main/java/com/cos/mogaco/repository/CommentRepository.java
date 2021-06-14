package com.cos.mogaco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.mogaco.model.Reply;

public interface CommentRepository extends JpaRepository<Reply, Long> {
//	@Modifying
//	@Query(value = "insert into tbl_comment3(bnum, content, regdate) values(?1, ?2, now())",
//			nativeQuery = true)
//	public void commentInsert(Long bnum, String content);
//	
//	// 댓글리스트
//	@Query("select sc from tbl_comment3 sc where bnum=?1")
//	public List<Reply> findByBnum(Long bnum);
}
