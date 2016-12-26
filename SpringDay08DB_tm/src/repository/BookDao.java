package repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.BookMapper;
import vo.Book;

@Component
public class BookDao {
	@Autowired
	private SqlSessionTemplate session;
	
	public BookDao(SqlSessionTemplate session){
		this.session = session;
	}
	
	public BookDao(){}
	
	public int insertBook(Book book){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.insertBook(book);
	}
	
	public int updateBook(Book book){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.updateBook(book);
	}
	
	public int deleteBook(int bookNum){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.deleteBook(bookNum);
	}
	
	public Book selectBook(int bookNum){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.selectBook(bookNum);
	}
	
	public List<Book> selectBookList(){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.selectBookList();
	}
	
	public List<Book> selectBookByNums(Map<String, Integer> paramMap){
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.selectBookByNums(paramMap);
	}
}
