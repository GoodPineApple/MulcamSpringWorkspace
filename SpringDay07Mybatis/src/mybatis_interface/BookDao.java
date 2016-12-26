package mybatis_interface;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.Book;

public class BookDao {
	private SqlSessionFactory factory;

	public BookDao() {
		String resource = "mybatis_interface/conf.xml";
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
///////////////////////////////////////////////////////
	public int insert(Book book){
//		SqlSession session = factory.openSession(true);
		SqlSession session = factory.openSession();
		BookMapper mapper = session.getMapper(BookMapper.class);
		int result = mapper.insertBook(book);
		if(result>0)
			session.commit();
		return result;
	}
	
	public Book select(int bookNum){
		SqlSession session = factory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.selectBook(bookNum);
	}
	
	public List<Book> selectList(){
		SqlSession session = factory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.selectBookList();
	}
}










