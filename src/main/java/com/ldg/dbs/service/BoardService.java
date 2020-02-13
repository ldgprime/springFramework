package com.ldg.dbs.service;

import java.util.List;

import com.ldg.dbs.dto.BoardVO;
import com.ldg.dbs.dto.Criteria;

public interface BoardService {
	
	public List<BoardVO> selectAll();
	public void insert(BoardVO board);	
	public BoardVO selectOne(int bno);
	public void update(BoardVO board);
	public void delete(int bno);
	
	public List<BoardVO> selectAll(Criteria criteria);
	
	public int countPaging(Criteria criteria);
}
