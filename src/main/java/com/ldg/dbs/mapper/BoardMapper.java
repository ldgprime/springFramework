package com.ldg.dbs.mapper;

import java.util.List;

import com.ldg.dbs.dto.BoardVO;

public interface BoardMapper {

	public List<BoardVO> getList();
	public void insert(BoardVO board);
	public void insertSelectKey(BoardVO board);
	public BoardVO read(int bno);
	public void delete(int bno);
	public void update(BoardVO board);
	public void updateReadCount(int bno);
	
}