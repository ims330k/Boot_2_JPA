package com.iu.b1.board.notice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iu.b1.board.BoardVO;

public interface NoticeRepository extends JpaRepository<NoticeVO, Integer> {
	
	// select * from notice where num > ? order by num desc
	List<NoticeVO> findByNumGreaterThanOrderByNumDesc(int num) throws Exception;

}
