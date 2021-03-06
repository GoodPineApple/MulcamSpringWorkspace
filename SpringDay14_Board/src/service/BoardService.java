package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.BoardDao;
import vo.Article;
import vo.ArticlePage;

@Component
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
///////////////////////////////////////////////////////
	// 글쓰기
	public int write(Article article){
		int result = 0;
		
		article.setReadCount(0);
		article.setWriteDate(new Date());
		
		// 게시글 추가하고 해당 게시글 번호 반환하기
		if(boardDao.insert(article)>0)
			result = article.getArticleNum();
		return result;
	}
	
	// 글읽기
	public Article read(int articleNum, String id){
		Article article = boardDao.select(articleNum);
		
		if(id==null || (article!=null && !id.equals(article.getWriter()))){
			boardDao.updateReadCount(articleNum);
			article.setReadCount(article.getReadCount()+1);
		}
		return article;
	}
	
	// 글 목록보기
	public ArticlePage makePage(int currentPage){
		final int COUNT_PER_PAGE=10;
		int totalArticleCount = boardDao.selectCount();
		
		// 게시글이 없으면 끝내기
		if(totalArticleCount==0)
			return new ArticlePage();
		
		// 보여줄 게시글 가져오기
		int startRow = (currentPage-1)*COUNT_PER_PAGE;
		List<Article> articleList = 
			boardDao.selectList(startRow, COUNT_PER_PAGE);
		
		// 총 페이지수 계산
		int totalPage = totalArticleCount/COUNT_PER_PAGE;
		if(totalArticleCount%COUNT_PER_PAGE != 0)
			totalPage++;
		
		// 아래 페이지 링크 계산
		int startPage = (currentPage-1)/10*10 +1;
		int endPage = startPage+9;
		if(endPage>totalPage)
			endPage = totalPage;
		
		return new ArticlePage(articleList, startPage, endPage, currentPage, totalPage);
	}
	
}







