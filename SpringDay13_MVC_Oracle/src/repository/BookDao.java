package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.BookMapper;
import vo.Book;

@Component
public class BookDao {
	
	@Autowired
	private SqlSessionTemplate session;

	public void setSession(SqlSessionTemplate session){
		this.session = session;
	}
	
	public int insertBook(Book book){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.insertBook(book);
	}
	
	public int deleteBook(int bookNum){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.deleteBook(bookNum);
	}
	
	public int updateBook(Book book){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.updateBook(book);
	}
	
	public Book selectBook(int bookNum){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.selectBook(bookNum);
	}
	
	public List<Book> selectBookList(){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.selectBookList();
	}
	
	
	
}
