package ver3_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		// 차량 용품점
		ApplicationContext context = new 
				FileSystemXmlApplicationContext
					("/src/ver3_1/applicationContext.xml");
//		GenericXmlApplicationContext ctx = 
//				new GenericXmlApplicationContext
//					("classpath:applicationContext.xml");
		
		Car myCar = context.getBean("sonata", Car.class);
		Tire tire = context.getBean("koreaTire", Tire.class);
		
		myCar.setTire(tire); // 가져온 객체 조립
		myCar.printCarInfo();
		
	}
	
	
	
}
