package xml_interface;

import java.util.List;
import java.util.Map;

import vo.Book;

// xml_interface.BookMapper
public interface BookMapper {
	public int insertBook(Book book);
	public int deleteBook(Map<String, Integer> paramMap);
	public Book selectBook(int book_num);
	public List<Book> selectBookList();
}
