package test03_custom;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		Sample s = new Sample();
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext
			("test03_custom/applicationContext.xml");
				
		context.close();
	}

}
