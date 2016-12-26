package mapper;

import java.util.List;

import vo.Article;

public interface ArticleMapper {
	int insert(Article article);
	int update(Article article);
	int delete(int articleNum);
	Article select(int articleNum);
	List<Article> selectList();
	int selectCount();
	List<Article> selectListPerCount(int start, int end);
	int updateHits(int articleNum);
	int insertReply(Article article);
	int updateStep(Article article);
}
