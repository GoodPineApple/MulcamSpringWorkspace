package test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import repository.BookDao;
import vo.Book;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		BookDao dao = context.getBean("bookDao", BookDao.class);
		
		Book book = new Book("제목", "작가", 1000, "출판사");
		int deleteNum = 1;
		Book updateBook = new Book(2, "새책", "새작가", 10000, "새출판사");
		
//		System.out.println(dao.insertBook(book));
//		System.out.println(dao.updateBook(updateBook));
//		System.out.println(dao.deleteBook(deleteNum));
//		System.out.println(dao.selectBook(2));
		
//		for(Book b : dao.selectBookList()){
//			System.out.println(b);
//		}
		
//		Map<String, Integer> paramMap = new HashMap<>();
//		paramMap.put("start", 2);
//		paramMap.put("end", 5);
//		for(Book b : dao.selectBookByNums(paramMap)){
//			System.out.println(b);
//		}
	}
}
