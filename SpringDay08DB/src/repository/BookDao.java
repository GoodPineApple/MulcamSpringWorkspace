package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import mapper.BookMapper;
import vo.Book;

@Component
public class BookDao {
	@Autowired
	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session){
		this.session = session;
	}
	
	public int insert(Book book){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.insertBook(book);
	}
	
	public Book select(int bookNum){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.selectBook(bookNum);
	}
	
	public List<Book> selectList(){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.selectBookList();
	}
}
