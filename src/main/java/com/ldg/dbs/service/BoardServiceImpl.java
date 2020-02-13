package com.ldg.dbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldg.dbs.dto.BoardVO;
import com.ldg.dbs.dto.Criteria;
import com.ldg.dbs.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardMapper boardMapper;
	
	
	@Override
	public List<BoardVO> selectAll() {
		// TODO Auto-generated method stub
		
		return boardMapper.getList();
		
	}

	@Override
	public void insert(BoardVO board) {
		// TODO Auto-generated method stub
		
		boardMapper.insert(board);
		
	}
	
	
	@Override
	@Transactional
	public BoardVO selectOne(int bno) {
		// TODO Auto-generated method stub
		
		BoardVO board = boardMapper.read(bno);
		boardMapper.updateReadCount(bno);
		
		return board;
	}


	
	@Override
	public void update(BoardVO board) {
		// TODO Auto-generated method stub		
		boardMapper.update(board);
		
		
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		boardMapper.delete(bno);
	}

	@Override
	public List<BoardVO> selectAll(Criteria criteria) {
		// TODO Auto-generated method stub
		return boardMapper.oracleListPaging(criteria);
	}

	@Override
	public int countPaging(Criteria criteria) {
		// TODO Auto-generated method stub
		return boardMapper.countPaging();
	}

}
