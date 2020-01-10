package com.iu.b1.board.notice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iu.b1.board.BoardVO;

public interface NoticeRepository extends JpaRepository<NoticeVO, Integer> {
	
	// select * from notice where num > ? order by num desc
	//@Query("select n from notice n where num>0 order by num desc")
	Page <NoticeVO> findByNumGreaterThan(int num, Pageable pageable) throws Exception;
	
	Page <NoticeVO> findByTitleContainingAndNumGreaterThan(String title, int num, Pageable pageable)throws Exception;
	

	
	
}
