package prt4_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = 
				new FileSystemXmlApplicationContext
					("/src/prt4_1/applicationContext.xml");
		Controller con = context.getBean("controller", Controller.class);
		con.select();
	}
}
