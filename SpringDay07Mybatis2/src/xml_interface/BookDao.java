package xml_interface;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.Book;

public class BookDao {
	private SqlSessionFactory factory;
	
	public BookDao(){
		String resource = "xml_interface/conf.xml";
		InputStream is = null;

		try {
			is = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException ex) {
			System.out.println("마이바티스 설정파일 에러");
			ex.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
////////////////////////////////////////////////////////	
	public int insert(Book book){
		SqlSession session = factory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.insertBook(book);
	}
	
	public int delete(int start, int end){
		SqlSession session = factory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("startRow", start);
		paramMap.put("endRow", end);
		
		return mapper.deleteBook(paramMap);
	}
	
	public Book select(int book_num){
		SqlSession session = factory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.selectBook(book_num);
	}
	
	public List<Book> selectList(){
		SqlSession session = factory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.selectBookList();
	}
}



