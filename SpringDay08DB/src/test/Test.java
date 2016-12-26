package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import repository.BookDao;
import vo.Book;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		BookDao dao = context.getBean("bookDao", BookDao.class);
//		for(Book b : dao.selectList()){
//			System.out.println(b);
//		}
		
		Book book = new Book("ÇÑ±Û", "publisher", "writer", 10000);
		System.out.println(dao.insert(book));
	}
}
