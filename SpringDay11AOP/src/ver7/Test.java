package ver7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new
			ClassPathXmlApplicationContext
				("ver7/applicationContext.xml");
		
		Person p = context.getBean("girl",Person.class);
		
		p.makeFood();
	}
}
