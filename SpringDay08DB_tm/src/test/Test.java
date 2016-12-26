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
		
		Book book = new Book("����", "�۰�", 1000, "���ǻ�");
		int deleteNum = 1;
		Book updateBook = new Book(2, "��å", "���۰�", 10000, "�����ǻ�");
		
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
