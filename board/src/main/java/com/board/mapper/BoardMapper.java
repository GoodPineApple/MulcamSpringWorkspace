package com.board.mapper;

import java.util.List;

import com.board.domain.BoardVo;

public interface BoardMapper {
	public void boardInsert(BoardVo board) throws Exception;

	public List<BoardVo> boardList() throws Exception;
}
