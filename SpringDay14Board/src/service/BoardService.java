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
	// �۾���
	public int write(Article article){
		int result = 0;
		
		article.setReadCount(0);
		article.setWriteDate(new Date());
		
		// �Խñ� �߰��ϰ� �ش� �Խñ� ��ȣ ��ȯ�ϱ�
		if(boardDao.insert(article)>0)
			result = article.getArticleNum();
		return result;
	}
	
	// ���б�
	public Article read(int articleNum, String id){
		Article article = boardDao.select(articleNum);
		
		if(id==null || (article!=null && !id.equals(article.getWriter()))){
			boardDao.updateReadCount(articleNum);
			article.setReadCount(article.getReadCount()+1);
		}
		return article;
	}
	
	// �� ��Ϻ���
	public ArticlePage makePage(int currentPage){
		final int COUNT_PER_PAGE=10;
		int totalArticleCount = boardDao.selectCount();
		
		// �Խñ��� ������ ������
		if(totalArticleCount==0)
			return new ArticlePage();
		
		// ������ �Խñ� ��������
		int startRow = (currentPage-1)*COUNT_PER_PAGE;
		List<Article> articleList = 
			boardDao.selectList(startRow, COUNT_PER_PAGE);
		
		// �� �������� ���
		int totalPage = totalArticleCount/COUNT_PER_PAGE;
		if(totalArticleCount%COUNT_PER_PAGE != 0)
			totalPage++;
		
		// �Ʒ� ������ ��ũ ���
		int startPage = (currentPage-1)/10*10 +1;
		int endPage = startPage+9;
		if(endPage>totalPage)
			endPage = totalPage;
		
		return new ArticlePage(articleList, startPage, endPage, currentPage, totalPage);
	}
	
}






