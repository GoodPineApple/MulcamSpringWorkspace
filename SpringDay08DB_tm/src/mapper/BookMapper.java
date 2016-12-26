package mapper;

import java.util.List;
import java.util.Map;

import vo.Book;

public interface BookMapper {
	public int insertBook(Book book);
	public int deleteBook(int bookNum);
	public int updateBook(Book book);
	public Book selectBook(int bookNum);
	public List<Book> selectBookList();
	public List<Book> selectBookByNums(Map<String, Integer> paramMap);
}
