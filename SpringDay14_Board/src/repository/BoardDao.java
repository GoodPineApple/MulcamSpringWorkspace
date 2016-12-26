package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.mapper.BoardMapper;
import vo.Article;

@Component
public class BoardDao {
	@Autowired
	private SqlSessionTemplate session;
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
//////////////////////////////////////////////////////////
	public int insert(Article article){
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return mapper.insert(article);
	}
	
	public Article select(int articleNum){
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return mapper.select(articleNum);
	}
	
	public List<Article> selectList
							(int startRow, int count){
		Map<String, Integer> map = new HashMap<>();
		map.put("startRow",startRow);
		map.put("count", count);
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return mapper.selectList(map);
	}
	
	public int updateReadCount(int articleNum){
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return mapper.updateReadCount(articleNum);
	}
	
	public int selectCount(){
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return mapper.selectArticleCount();
	}
}







