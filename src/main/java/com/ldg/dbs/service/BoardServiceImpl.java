package com.ldg.dbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ldg.dbs.dto.BoardVO;
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
	public int insert(BoardVO board) {
		// TODO Auto-generated method stub
		
		int result = boardMapper.insert(board);
		
		
		return result;
	}

	@Override
	public BoardVO selectOne(int bno) {
		// TODO Auto-generated method stub
		return null;
	}


	
	@Override
	public void update(BoardVO board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub

	}

}
