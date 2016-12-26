package test01_named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test01_named.vo.BookVO;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("test01_named/applicationContext.xml");
	
		BookDaoNamed dao = context.getBean("dao", BookDaoNamed.class);
		
		BookVO book = new BookVO(100, "Spring DB", "yangyu", 30000, "¸ÖÄ·");	
		System.out.println("insert:" + dao.insert(book));
	}
}
