package mapper;

import java.util.List;

import vo.Book;

public interface BookMapper {
	public int insertBook(Book book);
	public int deleteBook(int bookNum);
	public int updateBook(Book book);
	public Book selectBook(int bookNum);
	public List<Book> selectBookList();
}
