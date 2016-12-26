package ver9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new
			ClassPathXmlApplicationContext("ver9/applicationContext.xml");
		
		Person person = context.getBean("girl", Person.class);
		
		person.makeFood(5);
	}

}
