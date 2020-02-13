package com.ldg.dbs.dto;

//검색까지 하기위해 
public class Criteria {
	
	private int page;
	private int perPageNum;
	
	public Criteria() {
		//첫번째 페이지 
		this.page = 1;
		//레코드 10개 씩 => 한페이지 당 10개의 글 10개의 행 10개의 row
		this.perPageNum = 10;
	}
	
	public void setPage(int page) {
		if(page<=0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0 || perPageNum>100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	public int getPage() {
		return page;
	}
	
	public int getPageStart() {
		//				1-1	*	10 = 0
		//				2-1 *   10 = 10
		//				8-1 *   10 = 70
		return (this.page-1)*perPageNum;
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
	
	
}
