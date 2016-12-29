package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.MemberService;

public class Test {
	public static void main(String[] args) throws Exception{
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		MemberService service = context.getBean(MemberService.class);
		
		service.memberFunc();
		System.out.println("실행완료");
	}
}
