package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.domain.BoardVo;
import com.board.mapper.BoardMapper;

@RestController
public class BoardListController {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@RequestMapping("/board")
	public List<BoardVo> board() throws Exception{
		List<BoardVo> board = boardMapper.boardList();
		return board;
	}
}
