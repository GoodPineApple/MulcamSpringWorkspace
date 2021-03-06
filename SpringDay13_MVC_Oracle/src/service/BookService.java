package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.BookDao;
import vo.Book;

@Component
public class BookService {
	@Autowired
	private BookDao dao;
	
	public BookService(BookDao dao){
		this.dao = dao;
	}
	
	public BookService(){}
	
	public boolean insertBook(Book book){
		if(dao.insertBook(book)>0){
			return true;
		} else{
			return false;
		}
	}
	
	public List<Book> selectBookList(){
		return dao.selectBookList();
	}
	
	public Book selectBook(int bookNum){
		return dao.selectBook(bookNum);
	}
	
	public boolean deleteBook(int bookNum){
		if(dao.deleteBook(bookNum)>0){
			return true;
		} else{
			return false;
		}
	}
	
	public boolean updateBook(Book book){
		if(dao.updateBook(book)>0){
			return true;
		} else{
			return false;
		}
	}
}
