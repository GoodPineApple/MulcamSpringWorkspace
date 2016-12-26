package mybatis_interface;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import vo.Book;

// 어제 작성한 book-mapper.xml 파일을 인터페이스로 작성
public interface BookMapper {
	public static final String INSERT_SQL = 
		"INSERT INTO BOOK(TITLE,PUBLISHER,PRICE,WRITER)"+
		"VALUES(#{title},#{publisher},#{price},#{writer})";
	public static final String SELECT_SQL = 
		"SELECT * FROM BOOK WHERE BOOK_NUM=#{bookNum}";
	public static final String SELECT_ALL_SQL = 
		"SELECT * FROM BOOK";	
//////////////////////////////////////////////////////////	
	@Insert(INSERT_SQL)
	public int insertBook(Book book);
	
	@Select(SELECT_SQL)
	public Book selectBook(int bookNum);
	
	@Select(SELECT_ALL_SQL)
	public List<Book> selectBookList();
}



