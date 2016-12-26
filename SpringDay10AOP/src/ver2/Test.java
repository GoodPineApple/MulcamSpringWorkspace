package ver2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("ver2/applicationContext.xml");
		Person p = context.getBean("yunmi",Person.class);
		
		p.makeFood();
	}
}
