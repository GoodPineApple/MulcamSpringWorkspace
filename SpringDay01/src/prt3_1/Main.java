package prt3_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context =
				new FileSystemXmlApplicationContext
					("/src/prt3_1/applicationContext.xml");
		Controller con = context.getBean("controller", Controller.class);
		DAO dao = context.getBean("oracle",DAO.class);
		con.setDAO(dao);
		con.select();
	}
}
