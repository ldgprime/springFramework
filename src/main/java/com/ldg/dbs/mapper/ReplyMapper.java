package com.ldg.dbs.mapper;

import java.util.List;

import com.ldg.dbs.dto.ReplyVO;

public interface ReplyMapper {
		
	public List<ReplyVO> getList(int bno);
	public void delete(int rno);
	public void insert(ReplyVO reply);
	public ReplyVO getReple(int rno);
	
}
