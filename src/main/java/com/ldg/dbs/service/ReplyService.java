package com.ldg.dbs.service;

import java.util.List;

import com.ldg.dbs.dto.ReplyVO;

public interface ReplyService {	
	
	public void register(ReplyVO reply);
	public List<ReplyVO> getList(int bno);
	public void delete(int rno);	

}
