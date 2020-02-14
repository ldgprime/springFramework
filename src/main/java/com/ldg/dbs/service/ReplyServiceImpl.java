package com.ldg.dbs.service;

import java.util.List;

import javax.inject.Inject;

import com.ldg.dbs.dto.ReplyVO;
import com.ldg.dbs.mapper.BoardMapper;
import com.ldg.dbs.mapper.ReplyMapper;

public class ReplyServiceImpl implements ReplyService {
	@Inject
	private BoardMapper boardMapper;   
	
	@Inject
	private ReplyMapper replyMapper; 
	
	@Override
	public void register(ReplyVO reply) {
		// TODO Auto-generated method stub
		boardMapper.updateReplyCount(1, reply.getBno());
		replyMapper.insert(reply);
	}

	@Override
	public List<ReplyVO> getList(int bno) {
		// TODO Auto-generated method stub
		return replyMapper.getList(bno);
	}

	@Override
	public void delete(int rno) {
		// TODO Auto-generated method stub
		ReplyVO reply = replyMapper.getReple(rno);
		
		boardMapper.updateReplyCount(-1, reply.getBno());
		replyMapper.delete(rno);
	}



}
