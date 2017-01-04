package com.pineapple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pineapple.repository.ArticleMapper;
import com.pineapple.vo.ArticleVO;

@Component
public class ArticleService {
	
	@Autowired
	private ArticleMapper mapper;
	
	public void setArticleMapper(ArticleMapper mapper){
		this.mapper = mapper;
	}
	
	public boolean insertArticle(ArticleVO article){
		if(mapper.articleInsert(article) == 1){
			return true;
		} else {
			return false;
		}
	}
	
	public List<ArticleVO> selectArticleList(){
		return mapper.articleSelectList();
	}
	
	public ArticleVO selectArticle(int articleNum){
		return mapper.articleSelect(articleNum);
	}

	public void hitPlus(int articleNum) {
		mapper.hitPlus(articleNum);
		
	}
	
	
}
