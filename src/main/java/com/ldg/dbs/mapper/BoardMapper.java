package com.ldg.dbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ldg.dbs.dto.BoardVO;
import com.ldg.dbs.dto.Criteria;

public interface BoardMapper {

	public List<BoardVO> getList();
	public void insert(BoardVO board);
	public void insertSelectKey(BoardVO board);
	public BoardVO read(int bno);
	public void delete(int bno);
	public void update(BoardVO board);
	public void updateReadCount(int bno);
	
	public List<BoardVO> oracleListPaging(Criteria criteria);
	
	public int countPaging(Criteria criteria);
	
	public void updateReplyCount(@Param ("amount") int amount,@Param ("bno") int bno);
	
}
