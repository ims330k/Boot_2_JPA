package com.iu.b1.board.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.b1.board.BoardVO;
import com.iu.b1.util.FilePathGenerator;
import com.iu.b1.util.FileSaver;

@Service
@Transactional
public class NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	public void boardWrite(NoticeVO noticeVO, List<MultipartFile> files)throws Exception{
		List<NoticeFilesVO> noticeFilesVOs = null;
		//---- 파일의 유무 검증
		if(files.size()>0) {
			for(MultipartFile multipartFile: files) {
				if(multipartFile.getSize() <=0) {
					//check=true;
					//break;
					files.remove(multipartFile);
				}
			}
			
			//for 끝
			if(files.size()>0) {
				noticeFilesVOs = new ArrayList<NoticeFilesVO>();
				for(MultipartFile multipartFile:files) {
					NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
					File file = filePathGenerator.getUseClassPathResource("upload");
					String fileName = fileSaver.save(file, multipartFile);
					noticeFilesVO.setFname(fileName);
					noticeFilesVO.setOname(multipartFile.getOriginalFilename());
					noticeFilesVOs.add(noticeFilesVO);
					noticeFilesVO.setNoticeVO(noticeVO);
				}
				
				noticeVO.setNoticeFilesVOs(noticeFilesVOs);
				
			}
			
			
			
			
		}
		
		//---- 파일 유무 검증
		
		noticeRepository.save(noticeVO);
		
	}
	
	public Optional<NoticeVO> boardSelect(int num)throws Exception{
		return noticeRepository.findById(num);
	}
	
	public List<NoticeVO> boardList()throws Exception{
		return noticeRepository.findByNumGreaterThanOrderByNumDesc(0);
	}

}
