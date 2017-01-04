package com.pineapple.repository;

import java.util.List;

import com.pineapple.vo.ArticleVO;

public interface ArticleMapper {
	public int articleInsert(ArticleVO article);
	public ArticleVO articleSelect(int articleNum);
	public List<ArticleVO> articleSelectList();
	public void hitPlus(int articleNum);
}
