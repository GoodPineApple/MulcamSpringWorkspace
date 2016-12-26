package mybatis_xml;

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
	
	public BookDao(){
		String resource = "mybatis_xml/conf.xml";
		InputStream is = null;
		
		try {
			is=Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			System.out.println("마이바티스 설정파일 에러");
			e.printStackTrace();
		} finally {
			try{
				is.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int insert(Book book){
//		SqlSession session = factory.openSession(true);
//		return session.insert("ktm.insertBook", book);
		SqlSession session = factory.openSession();
		int result = session.insert("ktm.insertBook", book);
		if(result > 0) {
			session.commit();
		}
		return result;
	}
	
	public Book select(int book_num){
		SqlSession session = factory.openSession();
		return session.selectOne("ktm.selectBook", book_num);
	}
	
	public List<Book> selectList(){
		SqlSession session = factory.openSession();
		return session.selectList("ktm.selectBookList");
	}
}
