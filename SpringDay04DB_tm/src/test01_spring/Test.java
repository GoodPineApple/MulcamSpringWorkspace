package test01_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import test01_spring.vo.BookVO;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new
				ClassPathXmlApplicationContext
					("test01_spring/applicationContext.xml");
		BookDao dao = context.getBean("dao", BookDao.class);
		
		BookVO book = new BookVO("Spring", "taemin", 35000, "sds");
//		System.out.println(book.getTitle());
		System.out.println(dao.insert(book));
	}
}
