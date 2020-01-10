package com.iu.b1.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
class QnaRepositoryTest {
	
	@Resource
	private QnaRepository qnaRepository;
	
	@Autowired
	private QnaService qnaService;
	@Test
	void columnTest()throws Exception{
		List<Object []> obj = qnaRepository.qnaSelect(2);
		for(Object[] o:obj) {
			for(Object o2:o) {
				System.out.println(o2);
			}
		}
	}
	
//	@Test
	@Rollback(false)
	void UpdateTest()throws Exception{
//		qnaService.qnaUpdate();
		qnaRepository.qnaUpdate("reTitle", "recontents", 2);
//		QnaVO qnaVO = new QnaVO();
//		qnaVO.setNum(2);
//		qnaVO.setTitle("reTitle");
//		qnaVO.setContents("recontents");
//		qnaVO.setQnaFilesVOs(null);
//		qnaRepository.save(qnaVO);
	}
	
	//@Test
	void selectOneTest()throws Exception{
		QnaVO qnaVO = qnaRepository.findQnaVO(2);
		System.out.println(qnaVO.getTitle());
		System.out.println(qnaVO.getQnaFilesVOs().get(0).getFname());
	}
	
	//@Test
	void selectTest()throws Exception{
		List<QnaVO> ar = qnaRepository.findQnas();
		for(QnaVO qnaVO:ar) {
			System.out.println(qnaVO.getTitle());
			for(QnaFilesVO qnaFilesVO:qnaVO.getQnaFilesVOs()) {
				System.out.println(qnaFilesVO.getFname());
			}
		}
	}

	//@Test
	void test() {
		QnaVO qnaVO = new QnaVO();
		qnaVO.setTitle("qt3");
		qnaVO.setWriter("qw3");
		qnaVO.setContents("qc3");
		
		List<QnaFilesVO> ar = new ArrayList<QnaFilesVO>();
		
		QnaFilesVO qnaFilesVO = new QnaFilesVO();
		qnaFilesVO.setFname("f3.jpg");
		qnaFilesVO.setOname("o3.jpg");
		qnaFilesVO.setQnaVO(qnaVO);
		ar.add(qnaFilesVO);
		
		qnaFilesVO = new QnaFilesVO();
		qnaFilesVO.setFname("f2.jpg");
		qnaFilesVO.setOname("o2.jpg");
		qnaFilesVO.setQnaVO(qnaVO);
		ar.add(qnaFilesVO);
		
		qnaVO.setQnaFilesVOs(ar);
		
		qnaVO = qnaRepository.save(qnaVO);
		qnaVO.setRef(qnaVO.getNum());
		qnaRepository.save(qnaVO);
		
		System.out.println(qnaVO.getNum());
		System.out.println(qnaVO.getTitle());
	}

}
