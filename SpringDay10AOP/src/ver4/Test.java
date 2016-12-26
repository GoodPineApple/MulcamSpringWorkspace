package ver4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;






public class Test {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new
			ClassPathXmlApplicationContext
				("ver4/applicationContext.xml");
		
		Person p = context.getBean("jaemin",Person.class);
		
		p.makeFood(777);
	}
}
