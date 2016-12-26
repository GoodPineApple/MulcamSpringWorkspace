package test02_interface;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		Sample s = new Sample();
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext
			("test02_interface/applicationContext.xml");
				
		context.close();
	}

}
