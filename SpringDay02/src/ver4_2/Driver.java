package ver4_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext context = 
			new ClassPathXmlApplicationContext
			("ver4_2/applicationContext.xml");
		
		Car mycar = context.getBean("sonata", Car.class);
		
		mycar.printCarInfo();
	}

}
