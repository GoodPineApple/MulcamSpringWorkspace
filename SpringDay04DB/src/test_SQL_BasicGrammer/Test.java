package test_SQL_BasicGrammer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test_SQL_BasicGrammer.vo.BookVO;


public class Test {
	public static void main(String[] args) {
//		BookDao dao = new BookDao();
		ApplicationContext context = new 
			ClassPathXmlApplicationContext
			("test_SQL_BasicGrammer/applicationContext.xml");
		
		BookDao dao = context.getBean("dao", BookDao.class);
		
		//insert
		BookVO book = new BookVO("Spring","yangyu",35000,"sds");
		System.out.println(dao.insert(book));
		
		//update
		BookVO bookWithNum = new BookVO(6,"TT","dahyun",20000,"jyp");
		System.out.println(dao.update(book));
		
		//delete
		System.out.println(dao.delete(1));
		
		//selectAll
		System.out.println("모든책 목록-----------------");
		for(BookVO b : dao.selectAll()) {
			System.out.println(b);
		}
		
		//selectOne
		System.out.println("4번책 조회");
		System.out.println(dao.select(4));
		
		//selectByTitle
		for(BookVO b : dao.selectByTitle("Spring")) {
			System.out.println(b);
		}
	}
}





