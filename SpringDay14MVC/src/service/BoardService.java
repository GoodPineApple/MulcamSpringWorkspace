package service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.BoardDao;
import vo.Article;

@Component
public class BoardService {
	@Autowired
	private BoardDao dao;
	public void setBoardDao(BoardDao dao){
		this.dao = dao;
	}
////////////////////////////////////////////////////////////////////////////
	//글 쓰기
	public int write(Article article){
		int result = 0;
		
		article.setReadCount(0);
		article.setWriteDate(new Date());
		
		result = dao.insert(article);
		return result;
	}
	
	//글 읽기
	public Article read(int articleNum, String id){
		Article article = dao.select(articleNum);
		
		if(article!=null && !id.equals(article.getWriter())){
			dao.updateReadCount(articleNum);
		}
		return article;
	}
	
}
