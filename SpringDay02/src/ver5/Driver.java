package ver5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext context = 
			new ClassPathXmlApplicationContext
			("ver5/applicationContext.xml");
		
		Car mycar = context.getBean("sonata", Car.class);
		Tire tire = context.getBean("koreaTire", Tire.class);
		
		mycar.setTire(tire);
		
		mycar.printCarInfo();
	}

}
