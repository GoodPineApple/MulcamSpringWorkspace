package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.ArticleMapper;
import vo.Article;

@Component
public class ArticleDao {
	@Autowired
	private SqlSessionTemplate session;
	
	public void setSqlSessionTemplate(SqlSessionTemplate session){
		this.session = session;
	}
	
	public int insert(Article article){
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.insert(article);
	}
	
	public int insertReply(Article article){
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.insertReply(article);
	}
	
	public int update(Article article){
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.update(article);
	}
	
	public int delete(int articleNum){
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.delete(articleNum);
	}
	
	public Article select(int articleNum){
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.select(articleNum);
	}
	
	public List<Article> selectList(){
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.selectList();
	}
	
	public int selectCount(){
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.selectCount();
	}

	public List<Article> selectListPerPage(int start, int end) {
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.selectListPerCount(start, end);
	}

	public int updateHit(int articleNum) {
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.updateHits(articleNum);
	}
	
	public int updateStep(Article article){
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.updateStep(article);
	}
	
}
