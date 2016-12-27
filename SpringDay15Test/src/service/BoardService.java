package service;

import java.awt.print.PageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.BoardDao;
import vo.Article;
import vo.ArticlePage;

@Component
public class BoardService {
	@Autowired
	private BoardDao dao;
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	public int insertArticle(Article article) {
		return dao.insertArticle(article);
	}
	public ArticlePage makePage(int page) {
		final int PAGE_FOR_COUNT = 10;
		int totalCount = dao.totalCount();
		if(totalCount==0){
			return new ArticlePage();
		}
		int startRow = (page - 1) * PAGE_FOR_COUNT;
		List<Article> articleList = dao.selectList(startRow,PAGE_FOR_COUNT);
		int totalPage;
		if(totalCount%PAGE_FOR_COUNT!=0){
			totalPage = totalCount/PAGE_FOR_COUNT+1;
		} else {
			totalPage = totalCount/PAGE_FOR_COUNT;
		}
		int startPage = (page-1)/PAGE_FOR_COUNT * PAGE_FOR_COUNT + 1;
		int endPage = startPage + PAGE_FOR_COUNT - 1;
		if(endPage > totalPage){
			endPage = totalPage;
		}
		return new ArticlePage(articleList,startPage,endPage,totalPage,page);
	}
	 // ±€¿–±‚
    public Article read(int articleNum, String id){
        Article article = dao.select(articleNum);
        if(id==null || (article!=null && !id.equals(article.getWriter()))){
            dao.updateReadCount(articleNum);
            article.setRead_count(article.getRead_count()+1);
        }
        return article;
    }
    public Article select(int articleNum){
        Article article = dao.select(articleNum);
        return article;
    }
	public boolean delete(String loginId, int articleNum) {
		Article article = dao.select(articleNum);
		if(article.getWriter().equals(loginId)){
			dao.delete(articleNum);
			return true;
		}
		return false;
	}
	public int updateArticle(Article article) {
		return dao.updateArticle(article);
	}
	public int insertReply(Article article) {
		return dao.insertReply(article);
	}
}
