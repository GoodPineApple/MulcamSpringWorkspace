package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.BoardMapper;
import vo.Article;

@Component
public class BoardDao {
	@Autowired
	private SqlSessionTemplate session;
	
	public int insertArticle(Article article) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return mapper.insertArticle(article);
	}

	public int totalCount() {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return mapper.totalCount();
	}

	public List<Article> selectList(int startRow, int page_for_count) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		Map<String,Integer> paramMap = new HashMap<>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", page_for_count);
		System.out.println(paramMap);
		return mapper.selectList(paramMap);
	}
	public Article select(int articleNum){
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        return mapper.select(articleNum);
    }
	public int updateReadCount(int articleNum){
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        return mapper.updateReadCount(articleNum);
    }

	public int delete(int articleNum) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
        return mapper.delete(articleNum);
	}

	public int updateArticle(Article article) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
        return mapper.update(article);
	}

	public int insertReply(Article article) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return mapper.insertReply(article);
	}
}
