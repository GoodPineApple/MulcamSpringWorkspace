package test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test02.vo.BookVO;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("test02/applicationContext.xml");
		BookDao dao = context.getBean("bookDao", BookDao.class);
		
		BookVO book = new BookVO("title", "taemin", 45000, "suwon");
		System.out.println(dao.insert(book));
	}
}
