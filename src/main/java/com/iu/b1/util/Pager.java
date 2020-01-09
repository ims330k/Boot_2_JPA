package com.iu.b1.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Pager {
	private int curPage;
	private int perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	private Page<? extends Object> pageList;
	private Pageable pageable;
	
	public Pager() {
		this.curPage=0;
		this.perPage=10;
	}
	
	public void makeNum() {
		int perBlock=5;
		this.totalBlock = pageList.getTotalPages()/perBlock;
		
		if(pageList.getTotalPages()%perBlock !=0) {
			this.totalBlock++;
		}
		
		this.curBlock = (pageList.getNumber()+1)/perBlock;
		if((pageList.getNumber()+1)%perBlock != 0) {
			this.curBlock++;
		}
		
		this.startNum = (curBlock-1)*perBlock+1;
		this.lastNum = curBlock*perBlock;
		
		if(this.curBlock == totalBlock) {
			this.lastNum=pageList.getTotalPages();
		}
		
	}


	
	public void makePageRequest() {
		this.pageable = PageRequest.of(this.getCurPage(), this.getPerPage());
	}

	
	public void setCurPage(int curPage) {
		this.curPage = curPage-1;
		if(curPage-1<0) {
			this.curPage=0;
		}
		
	}
	

	
	
	
	
	
	
	

	
	
	
	
	

}
