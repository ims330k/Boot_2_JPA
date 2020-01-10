package com.iu.b1.board.qna;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QnaRepository extends JpaRepository<QnaVO, Integer> {
	
	List <QnaVO> findByNumGreaterThan(int num, Pageable pageable) throws Exception;
	
	@Query(value = "SELECT q FROM QnaVO q order by q.ref desc, q.step asc")
	List <QnaVO> findQnas()throws Exception;
	
	@Query(value = "select q from QnaVO q where num= :num", nativeQuery = true)
	QnaVO findQnaVO(@Param("num")int num)throws Exception;
	
	@Modifying
	@Query("update QnaVO q set q.title= ?1, q.contents= ?2 where q.num= ?3")
	void qnaUpdate(String title, String contents, int num)throws Exception;
	
	@Query("select q.writer, q.contents from QnaVO q where num=?1")
	List<Object[]> qnaSelect(int num)throws Exception;
	
	

}

