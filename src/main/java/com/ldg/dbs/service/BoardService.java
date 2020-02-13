package com.ldg.dbs.service;

import java.util.List;

import com.ldg.dbs.dto.BoardVO;

public interface BoardService {
	
	public List<BoardVO> selectAll();
	public void insert(BoardVO board);	
	public BoardVO selectOne(int bno);
	public void update(BoardVO board);
	public void delete(int bno);
	
}
