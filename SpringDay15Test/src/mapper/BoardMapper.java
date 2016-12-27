package mapper;

import java.util.List;
import java.util.Map;

import vo.Article;

public interface BoardMapper {
	public int insertArticle(Article article);

	public int totalCount();

	public List<Article> selectList(Map<String, Integer> paramMap);
	
	public int updateReadCount(int articleNum);
	public Article select(int articleNum);

	public int delete(int articleNum);

	public int update(Article article);

	public int insertReply(Article article);
}
